package atcoder001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 高橋君は、パズルが好きです。今日は、8 クイーン問題に挑戦しようとしています。 8 クイーン問題とは、8×8 のチェスボード上の縦・横・斜め 45
 * 度の同一直線状にそれぞれクイーンが 1 つしか存在しないように、合計 8 つのクイーンを置く問題です。
 *
 * 高橋君は、3 つのクイーンを置いたところで残りのクイーンをどう置いたら良いのか判らなくなってしまいました。 残りの 5 つのクイーンを含めた 8
 * つのクイーンの位置を求めなさい。
 *
 * !!!!!未完成!!!!!
 *
 * @author rks-user
 *
 */
public class QuestionC {

    private static final String QUEENCELL = "Q";
    private static final String NOTQUEENCELL = ".";
    private static final String VALIDATE = "入力が不正です。";
    private static String[][] board;
    private static int[] rowArray;
    private static int[] columnArray;
    /**
     * <pre>
     *
     * コンソール入力
     *
     * c11 c12 … c18
     * c21 c22 … c28
     * :
     * :
     * c81 c82 … c88
     *
     * クイーンのある位置は'Q'
     * クイーンのない位置は'.'
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            board = new String[8][8];
            rowArray = new int[3];
            columnArray = new int[3];

            String str;
            int queenCount = 0;
            // マップ作成
            for (int i = 0; i < 8; i++) {

                str = br.readLine();

                // 入力がない場合はエラー
                if (str == null || "".equals(str)) {
                    System.out.println(VALIDATE + "1.NoValue");
                    return;
                }

                if (str.length() == 8) {

                    // 行を作成
                    for (int j = 0; j < 8; j++) {
                        String cellDispName = str.substring(j, j + 1);
                        if (QUEENCELL.equals(cellDispName)) {
                            board[i][j] = cellDispName;
                            rowArray[queenCount] = i;
                            columnArray[queenCount] = j;
                            queenCount++;
                        } else if (!NOTQUEENCELL.equals(cellDispName)) {
                            // 入力されたセルの値が正しくない場合はエラー
                            System.out.println(VALIDATE + "2.CellValue");
                            return;
                        }
                    }
                } else {
                    // 入力されたセルの数が正しくない場合はエラー
                    System.out.println(VALIDATE + "3.CellSize");
                    return;
                }

            }

            if (queenCount != 3) {
                System.out.println(VALIDATE + "4.queenCount");
            }

            br.close();

            // 判定
            if (analyzeQueen()) {
                // 出力
                for (int i = 0; i < 8; i++) {
                    StringBuilder queenDisp = new StringBuilder();
                    for (int j = 0; j < 8; j++) {
                        queenDisp.append(board[i][j]);
                    }
                    System.out.println(queenDisp.toString());
                }

            } else {
                System.out.println("NoAnswer");
            }

        } catch (IOException e) {
            // TODO: handle exception
        }

    }

    private static boolean analyzeQueen() {
        boolean isExistAnswer = true;

        //Queen1
        for (int i=1; i<8; i++) {
            if (i != rowArray[0]) {
                board[i][columnArray[0]] = NOTQUEENCELL;
            }
            if (i != columnArray[0]) {
                board[rowArray[0]][i] = NOTQUEENCELL;
            }

            if (i != rowArray[1]) {
                board[i][columnArray[1]] = NOTQUEENCELL;
            }
            if (i != columnArray[1]) {
                board[rowArray[1]][i] = NOTQUEENCELL;
            }
            if (i != rowArray[2]) {
                board[i][columnArray[2]] = NOTQUEENCELL;
            }
            if (i != columnArray[2]) {
                board[rowArray[2]][i] = NOTQUEENCELL;
            }

        }



        //Queen2

        //Queen3






        return isExistAnswer;
    }
}
