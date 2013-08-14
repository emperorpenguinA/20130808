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
            List<Cell> cellList = new ArrayList<Cell>();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    System.in));

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

                    // 行ごとのMapを作成
                    int rowQueenCount = 0;
                    for (int j = 0; j < 8; j++) {
                        String cellDispName = str.substring(j, j + 1);
                        if (QUEENCELL.equals(cellDispName)
                                || NOTQUEENCELL.equals(cellDispName)) {
                            Cell cell = new Cell(cellDispName, i, j);
                            if (cell.isQueen()) {
                                queenCount++;
                                rowQueenCount++;
                            }
                            cellList.add(cell);
                        } else {

                            // 入力されたセルの値が正しくない場合はエラー
                            System.out.println(VALIDATE + "2.CellValue");
                            return;
                        }
                    }

                    if (rowQueenCount > 1) {
                        System.out.println(VALIDATE + "4.queenCount");
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
            cellList = analyzeQueen(cellList);

            // 出力
            for (int i = 0; i < 8; i++) {
                StringBuilder queenDisp = new StringBuilder();
                for (int j = 0; j < 8; j++) {
                    queenDisp.append(cellList.get(i * 8 + j).getDispName());
                }
                System.out.println(queenDisp.toString());
            }
        } catch (IOException e) {
            // TODO: handle exception
        }

    }

    private static List<Cell> analyzeQueen(List<Cell> cellList) {
        List<Cell> returnList = cellList;

        int queenCount = 3;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = cellList.get(i * 8 + j);

                if (!cell.isQueen) {

                }

            }
        }

        return returnList;
    }

    private static Cell getCell(Map<Integer, Map<Integer, Cell>> cellMap,
            int row, int column) {
        Cell cell = cellMap.get(row).get(column);

        return cell;
    }

    public static class CellMap {
        private Map<Integer, Map<Integer, Cell>> cellMap;

        public CellMap() {
            cellMap = new HashMap<Integer, Map<Integer, Cell>>();
            for (int i = 0; i < 8; i++) {
                Map<Integer, Cell> cellRow = new HashMap<Integer, Cell>();
                for (int j = 0; j < 8; j++) {
                    cellRow.put(j, new Cell());
                }
                cellMap.put(i, cellRow);
            }
        }

        public void putCell(Cell cell, int row, int column) {
            cellMap.get(row).put(column, cell);
        }

        public Cell getCell(int row, int column) {
            return cellMap.get(row).get(column);
        }

        public List<Cell> getRowCell(int row) {
            List<Cell> rowCell = new ArrayList<Cell>();
            for (int i = 0; i < 8; i++) {
                rowCell.add(cellMap.get(row).get(i));
            }
            return rowCell;
        }

        public List<Cell> getColumnCell(int column) {
            List<Cell> columnCell = new ArrayList<Cell>();
            for (int i = 0; i < 8; i++) {
                columnCell.add(cellMap.get(i).get(column));
            }
            return columnCell;
        }

        public Map<Integer, Map<Integer, Cell>> getCellMap() {
            return cellMap;
        }

        public void setCellMap(Map<Integer, Map<Integer, Cell>> cellMap) {
            this.cellMap = cellMap;
        }
    }

    public static class Cell {

        private String dispName;
        private boolean isQueen;
        private int row;
        private int column;

        public Cell() {
            // TODO 自動生成されたコンストラクター・スタブ
        }

        public Cell(String dispName, int row, int column) {
            this.dispName = dispName;
            this.row = row;
            this.column = column;
            if (QUEENCELL.equals(dispName)) {
                isQueen = true;
            } else {
                isQueen = false;
            }
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public String getDispName() {
            return dispName;
        }

        public void setDispName(String dispName) {
            this.dispName = dispName;
        }

        public boolean isQueen() {
            return isQueen;
        }

        public void setQueen(boolean isQueen) {
            this.isQueen = isQueen;
        }
    }

}
