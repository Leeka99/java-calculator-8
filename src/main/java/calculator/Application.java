package calculator;
import camp.nextstep.edu.missionutils.Console;

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
    }
}
