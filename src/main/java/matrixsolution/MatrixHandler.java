package matrixsolution;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class MatrixHandler {
    private int[][] matrix;
    private int rowsCount;
    private int columnsCount;

    MatrixHandler() {
        Scanner scanner = new Scanner(System.in);
        inputRowsCount(scanner);
        inputColumnsCount(scanner);

        this.matrix = new int[rowsCount][columnsCount];
        System.out.println("Write matrix with size " + rowsCount + " x " + columnsCount);

        for (int i = 0; i < rowsCount; ++i) {
            inputArray(this.matrix[i], scanner);
        }
    }

    public void inputRowsCount(Scanner scanner){
        System.out.println("Write count of matrix rows: ");
        this.rowsCount = scanner.nextInt();
    }

    public void inputColumnsCount(Scanner scanner){
        System.out.println("Write count of matrix columns: ");
        this.columnsCount = scanner.nextInt();
    }

    public void inputArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; ++i) {
            array[i] = scanner.nextInt();
        }
    }


    public void outputMatrix() {
        System.out.println("Our matrix with size " + this.rowsCount + " x " + this.columnsCount);

        for (int rowNumber = 0; rowNumber < this.rowsCount; ++rowNumber) {
            outputArray(this.matrix[rowNumber]);
            System.out.println("\n");
        }
    }

    public void outputArray(int[] array) {
        for (int i : array) {
            System.out.printf(" %d ", i);
        }
    }

    public void multiplyMatrix(MatrixHandler matrix) {
        if (isMultiplied(matrix.getRowsCount())) {
            int resultColumnsCount = matrix.getColumnsCount();
            int[][] multiplierMatrix = matrix.getMatrix();
            int[][] outMatrix = new int[this.rowsCount][resultColumnsCount];

            for (int rowNumber = 0; rowNumber < this.rowsCount; ++rowNumber) {
                outMatrix[rowNumber] =
                        multiplyArrayByMatrixColumns(this.matrix[rowNumber], multiplierMatrix, resultColumnsCount);
            }
            setMatrix(outMatrix);
            setColumnsCount(resultColumnsCount);
        } else {
            throw new IllegalArgumentException("Different values of columns and rows in matrices when multiplying");
        }
    }

    public boolean isMultiplied(int rowsCount) {
        return this.columnsCount == rowsCount;
    }

    public int[] multiplyArrayByMatrixColumns(int[] array, int[][] matrix, int columnsCount) {
        int[] resultArray = new int[columnsCount];
        for (int columnNumber = 0; columnNumber < columnsCount; ++columnNumber) {
            for (int i = 0; i < array.length; ++i) {
                resultArray[columnNumber] += array[i] * matrix[i][columnNumber];
            }
        }
        return resultArray;
    }
}
