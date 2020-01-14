package hello.dp;

public class MaximumOneRegions {

	public static void main(String s[]) {
		int matrix[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 1, 1 } };

		/*
		 * { { 0, 0, 0, 1, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 }, { 0, 1, 0, 0, 1, 1, 0 },
		 * { 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1 } };
		 */

		System.out.println(getBiggestRegion(matrix));

	}

	public static int getBiggestRegion(int matrix[][]) {

		int maxRegion = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				// System.out.println(row +"::"+column);
				if (matrix[row][column] == 1) {
					int size = getRegionSize(matrix, row, column);
					maxRegion = Math.max(size, maxRegion);
				}

			}
		}

		return maxRegion;
	}

	private static int getRegionSize(int[][] matrix, int row, int column) {

		if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[row].length) {

			return 0;
		}

		if (matrix[row][column] == 0) {
			return 0;
		}
		matrix[row][column] = 0;

		int size = 1;
		for (int r = (row - 1); r <= (row + 1); r++) {
			for (int c = (column - 1); c <= (column - 1); c++) {

				if (r != row || c != column) {
					System.out
							.println("column --> " + column + "<-- row -->" + row + " <-- r -->" + r + "<-- c -->" + c);
					size += getRegionSize(matrix, r, c);
					// System.out.println("Size -->"+size);
				}
			}
		}
		return size;
	}
}
