package matrixsolution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatrixHandler {
    private int[][] matrix;
    private int rowsCount;
    private int columnsCount;

    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write count of matrix rows: ");
        this.rowsCount = scanner.nextInt();
        System.out.println("Write count of matrix columns: ");
        this.columnsCount = scanner.nextInt();

        this.matrix = new int[rowsCount][columnsCount];
        System.out.println("Write matrix with size " + rowsCount + " x " + columnsCount);

        for (int i = 0; i < rowsCount; ++i) {
            inputArray(this.matrix[i], this.columnsCount, scanner);
        }
    }

    public void inputArray(int[] array, int lenArray, Scanner scanner){
        for (int elNumber = 0; elNumber < lenArray; ++elNumber) {
            array[elNumber] = scanner.nextInt();
        }
    }


    public void outputMatrix() {
        System.out.println("Our matrix with size " + this.rowsCount + " x " + this.columnsCount);
        int intermediateOutputDistance = 3;
        int lenOutputMatrixSymbol = findMaxLenMatrixElement() + intermediateOutputDistance;
        String format = "%" + lenOutputMatrixSymbol + "d ";
        for (int rowNumber = 0; rowNumber < this.rowsCount; ++rowNumber) {
            outputArrayWithFormat(this.matrix[rowNumber], format);
            System.out.println("\n");
        }
    }

    public void outputArrayWithFormat(int[] array, String format){
        for (int elNumber = 0; elNumber < this.columnsCount; ++elNumber) {
            System.out.printf(format, array[elNumber]);
        }
    }

    public int findMaxLenMatrixElement() {
        int maxLen = 0;
        for (int rowNumber = 0; rowNumber < this.rowsCount; ++rowNumber) {
            maxLen = findArrayElementMoreThenQuantity(this.matrix[rowNumber], this.columnsCount, maxLen);
        }
        return maxLen;
    }

    public int findArrayElementMoreThenQuantity(int[] array, int lenArray, int quantity){
        int len;
        for (int elNumber = 0; elNumber < lenArray; ++elNumber) {
            len = ("" + array[elNumber]).length();
            if (len > quantity) {
                quantity = len;
            }
        }
        return quantity;
    }

    public MatrixHandler multiplyMatrix(MatrixHandler matrix) {
        MatrixHandler resultMatrix = new MatrixHandler();
        if (this.columnsCount == matrix.getRowsCount()) {
            int resultColumnsCount = matrix.getColumnsCount();
            int[][] multiplierMatrix = matrix.getMatrix();

            int[][] outMatrix = new int[this.rowsCount][resultColumnsCount];
            resultMatrix = new MatrixHandler(outMatrix, this.rowsCount, resultColumnsCount);

            for (int rowNumber = 0; rowNumber < this.rowsCount; ++rowNumber) {
                outMatrix[rowNumber] =
                        multiplyArrayByMatrixColumns(this.matrix[rowNumber], this.columnsCount, multiplierMatrix, resultColumnsCount);
            }
            resultMatrix.setMatrix(outMatrix);
        } else {
            System.err.println("Different values of columns and rows in matrices when multiplying");
        }
        return resultMatrix;
    }

    public int[] multiplyArrayByMatrixColumns(int[] array, int lenArray, int[][] matrix, int columnsCount){
        int[] resultArray = new int[columnsCount];
        for (int columnNumber = 0; columnNumber < columnsCount; ++columnNumber) {
            resultArray[columnNumber] = multiplyArrayByMatrixColumn(array, lenArray, matrix, columnNumber);
        }
        return resultArray;
    }


    public int multiplyArrayByMatrixColumn(int[] array, int lenArray, int[][] matrix, int columnNumber){
        int resultElement = 0;
        for (int elNumber = 0; elNumber < lenArray; ++elNumber) {
            resultElement += array[elNumber] * matrix[elNumber][columnNumber];
        }
        return resultElement;
    }
}
