package matrixhandler;

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
            for (int j = 0; j < columnsCount; ++j) {
                this.matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void outputMatrix() {
        System.out.println("Our matrix with size " + this.rowsCount + " x " + this.columnsCount);
        int intermediateOutputDistance = 3;
        int lenOutputMatrixSymbol = maxLenMatrixSymbol(this.matrix) + intermediateOutputDistance;
        String format = "%" + lenOutputMatrixSymbol + "d ";
        for (int i = 0; i < this.rowsCount; ++i) {
            for (int j = 0; j < this.columnsCount; ++j) {
                System.out.printf(format, this.matrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    public int maxLenMatrixSymbol(int[][] matrix) {
        int len;
        int maxLen = 0;
        for (int i = 0; i < this.rowsCount; ++i) {
            for (int j = 0; j < this.columnsCount; ++j) {
                len = ("" + matrix[i][j]).length();
                if (len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    public MatrixHandler multiplyMatrix(MatrixHandler matrix) {
        MatrixHandler resultMatrix = new MatrixHandler();
        if (this.columnsCount == matrix.getRowsCount()) {
            int resultColumnsCount = matrix.getColumnsCount();
            int[][] multiplierMatrix = matrix.getMatrix();
            matrix.outputMatrix();

            int[][] outMatrix = new int[this.rowsCount][resultColumnsCount];
            resultMatrix = new MatrixHandler(outMatrix, this.rowsCount, resultColumnsCount);

            for (int i = 0; i < this.rowsCount; ++i) {
                for (int j = 0; j < resultColumnsCount; ++j) {
                    for (int k = 0; k < this.columnsCount; ++k) {
                        outMatrix[i][j] += this.matrix[i][k] * multiplierMatrix[k][j];
                    }
                }
            }
            resultMatrix.setMatrix(outMatrix);
        } else {
            System.err.println("Different values of columns and rows in matrices when multiplying");
        }
        return resultMatrix;
    }
}
