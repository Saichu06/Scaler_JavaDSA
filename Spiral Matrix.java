class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while (startrow <= endrow && startcol <= endcol) {

            // top row
            for (int i = startcol; i <= endcol; i++) {
                list.add(matrix[startrow][i]);
            }

            // right column
            for (int i = startrow + 1; i <= endrow; i++) {
                list.add(matrix[i][endcol]);
            }

            // bottom row
            if (startrow < endrow) {
                for (int i = endcol - 1; i >= startcol; i--) {
                    list.add(matrix[endrow][i]);
                }
            }

            // left column
            if (startcol < endcol) {
                for (int i = endrow - 1; i > startrow; i--) {
                    list.add(matrix[i][startcol]);
                }
            }

            // 🔑 move to inner layer
            startrow++;
            endrow--;
            startcol++;
            endcol--;
        }

        return list;
    }
}
