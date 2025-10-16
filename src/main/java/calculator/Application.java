package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        String input = Console.readLine();
        if (input.isBlank()) {
            System.out.println("결과 : " + 0);
            return;
        }

        // 첫번째 문자가 숫자일 경우
        if (Character.isDigit(input.charAt(0))) {
            String[] arr = input.split("[,:]");
            int answer = 0;
            for (String tokens : arr) {
                int number;
                try {
                    number = Integer.parseInt(tokens);
                    answer += number;
                }
                catch (NumberFormatException e) {
                    throw new IllegalArgumentException(); // 숫자+문자 일 경우 예외
                }

                if (number < 0) {
                    throw new IllegalArgumentException();
                }
            }
            System.out.println("결과 : " + answer);
        }

        // 첫번째 문자가 //로 시작하는 경우
        if (input.startsWith("//")) {
            int answer = 0;
            char[] arr = input.toCharArray();
            String seperator = "";
            if (input.matches("[^0-9]*")) throw new IllegalArgumentException(); // 문자만 입력된 경우
            if (!input.contains("\\n")) throw new IllegalArgumentException(); // 잘못된 커스텀 구분자 사용
            for (int i = 2; i < arr.length - 1; i++) {
                if (arr[i] == '\\' && arr[i+1] == 'n') {
                    break;
                }
                seperator = seperator + arr[i];
            }

            String sep = input.split(Pattern.quote("\\n"))[1];
            String[] numbers = sep.split(Pattern.quote(seperator));
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if (num < 0) throw new IllegalArgumentException();
                answer += num;
            }
            System.out.println("결과 : " + answer);
        }

        // 숫자도 아니고 //로 시작하지도 않는다면 잘못된 커스텀 구분자 사용으로 판단.
        if(!Character.isDigit(input.charAt(0)) && !input.startsWith("//")){
            throw new IllegalArgumentException();
        }
    }
}

