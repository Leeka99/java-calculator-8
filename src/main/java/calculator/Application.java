package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        String input = Console.readLine();
        if (input.isBlank()) {
            System.out.println("공백입력");
        }

        // 첫번째 문자가 숫자일 경우
        if (Character.isDigit(input.charAt(0))) {
            char[] arr = input.toCharArray();
            int answer = 0;
            for (char token : arr) {
                if (Character.isDigit(token)) {
                    answer += Character.getNumericValue(token);
                }
                if (!Character.isDigit(token) && token != ',' && token != ':') {
                    return;
                }
            }
            System.out.println("합 :" + answer);
        }

        // 첫번째 문자가 //로 시작하는 경우
        if (input.startsWith("//")) {
            int answer = 0;
            char[] arr = input.toCharArray();
            String seperator = "";
            for (int i = 2; i < arr.length - 1; i++) {
                if (arr[i] == '\\' && arr[i+1] == 'n') {
                    break;
                }
                seperator = seperator + arr[i];
            }

            String sep = input.split(Pattern.quote("\\n"))[1];
            String[] numbers = sep.split(Pattern.quote(seperator));
            for (String number : numbers) {
                answer += Integer.parseInt(number);
            }
            System.out.println(answer);
        }
    }
}
