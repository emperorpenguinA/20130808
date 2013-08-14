package atcoder001;

/**
 * 高橋君は、エアコンの設定温度を変更しようとしています。現在の設定温度は A 度ですが、これを B 度に設定したいと思っています。
 * エアコンのリモコンは 1 回ボタンを押すことで、
 *     1 度設定温度を下げる、もしくは上げる
 *     5 度設定温度を下げる、もしくは上げる
 *     10 度設定温度を下げる、もしくは上げる
 * の、6 種類の操作のいずれか 1 つを実行することが出来ます。
 * 高橋君が設定温度を A 度から B 度に変更するために押すボタンの最小回数を求めなさい。
 */
public class QuestionB {

    /**
     * <pre>
     * args[0] : 現在の設定温度(0≤A≤40) , args[1] : 設定したい温度(0≤B≤40)
     *
     * 結果出力
     * X    ボタン操作の最小回数
     * </pre>
     * @param args
     */
    public static void main(String[] args) {

        //引数の値判定(0≤A≤40)
        String errorMessage = validate(args);
        if (errorMessage != null) {
            System.out.println(errorMessage);
            return;
        }

        //温度の差を取得
        Integer difNum = Math.abs(Integer.parseInt(args[0]) - Integer.parseInt(args[1]));

        //操作回数取得
        int count = checkButton(difNum);
        System.out.println(count);
    }

    /**
     * 引数の値が正しいか判定する
     *
     * @param args
     * @return 引数が正しくないときのメッセージ(正しい場合はnull)
     */
    private static String validate(String[] args) {
        //引数は2つ
        if (args.length != 2) {
            return "引数を正しく設定してください。";
        }
        //引数は数値で0≤A≤40
        try {

            int beforeNum = Integer.parseInt(args[0]);
            int afterNum = Integer.parseInt(args[1]);

            if (!(beforeNum >= 0 && beforeNum <=40 & afterNum >= 0 && afterNum <= 40)) {
                return"引数の値が範囲外です。";
            }
        } catch (NumberFormatException e) {
            return"引数は数値で入力してください。";
        }
        return null;
    }

    /**
     * 温度の差分から操作回数を取得する
     *
     * @param difNum
     * @return
     */
    private static int checkButton(Integer difNum) {

        int count = 0;
        int rest = 0;
        /*
         * 1の位が0-7の時はすべて+
         * 　例) 6 = 5 + 1
         * 8,9の時は10からマイナス
         * 　例) 18 = 10 + 10 - 1 - 1
         */
        if ((rest = difNum % 10) <= 7) {
            count += difNum / 10;
            count += rest / 5;
            count += rest - rest / 5 * 5;

        } else {
            count += difNum / 10 + 1;
            count += 10 - rest;
        }

        return count;
    }

}
