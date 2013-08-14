package atcoder001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * 高橋君はセンター試験を受けました。 センター試験の各々の問題は 1 から 4
 * までの選択肢があります。高橋君はあまり勉強をしていなかったので、全ての問題で同じ選択肢を選びました。
 * 試験終了後、センター試験の解答が与えられましたが、高橋君は何番を選んだのかを忘れてしまいました。しかし、高橋君は自分の点数が気になります。
 * そこで、高橋君のため、高橋君が正解する問題の数として考えられる最大と最小の数を求めなさい。
 */
public class QuestionA {

    /**
     * <pre>
     * コンソール入力
     * N        問題数
     * 1234     問題の答え
     *
     * コンソール出力
     * 最大：X　最小：X
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));

            int qNum;
            String qAnswer;

            // 入力された問題数取得(1<=N<=100)
            try {
                qNum = Integer.parseInt(br.readLine());

                if (!(qNum >= 1 && qNum <= 100)) {
                    System.out.println("問題数が範囲外");
                    return;
                }

            } catch (NumberFormatException e) {
                System.out.println("問題数は数字を入力");
                return;
            }

            // 入力された問題の正解([1-4]がN文字)
            qAnswer = br.readLine();
            if (qAnswer != null && qNum == qAnswer.length()) {

                StringBuilder regexPattern = new StringBuilder();
                regexPattern.append("[1-4]{");
                regexPattern.append(qNum);
                regexPattern.append("}");

                if (!Pattern.compile(regexPattern.toString()).matcher(qAnswer)
                        .find()) {
                    System.out.println("正解文字列不正：選択肢不正");
                    return;
                }
            } else {
                System.out.println("正解文字列不正：問題数との不一致");
                return;
            }
            br.close();

            // 最大最小を判定
            checkAnswer(qAnswer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkAnswer(String qAnswer) {
        // 選択肢ごとの正解数を確認
        Integer[] answerArray = new Integer[] { 0, 0, 0, 0 };

        char[] qAnsserArray = qAnswer.toCharArray();

        for (int i = 0; i < qAnsserArray.length; i++) {
            switch (qAnsserArray[i]) {
            case '1':
                answerArray[0]++;
                break;
            case '2':
                answerArray[1]++;
                break;
            case '3':
                answerArray[2]++;
                break;
            case '4':
                answerArray[3]++;
                break;
            default:
                break;
            }
        }

        int max = answerArray[0];
        int min = answerArray[0];

        for (int i = 0; i < answerArray.length; i++) {
            max = Math.max(max, answerArray[i]);
            min = Math.min(min, answerArray[i]);
        }

        StringBuilder result = new StringBuilder("最大：");
        result.append(max);
        result.append("　最小：");
        result.append(min);

        System.out.println(result);

    }

}
