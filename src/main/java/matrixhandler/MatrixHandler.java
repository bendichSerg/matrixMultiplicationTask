package matrixhandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@AllArgsConstructor
@Getter
@Setter
public class MatrixHandler {
    private int[][] matrix;
    private int rowsCount;
    private int columnsCount;

    public MatrixHandler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите колличество строк матрицы: ");
        this.rowsCount = scanner.nextInt();
        System.out.println("Введите колличество столбцов матрицы: ");
        this.columnsCount = scanner.nextInt();

        this.matrix = new int[rowsCount][columnsCount];
        System.out.println("Введите матрицу размера " + rowsCount + " на " + columnsCount);

        for(int i = 0; i < rowsCount; ++i){
            for(int j = 0; j < columnsCount; ++j){
                this.matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void outputMatrix(){
        System.out.println("Наша матрица размера " + this.rowsCount + " на " + this.columnsCount);

        for(int i = 0; i < this.rowsCount; ++i){
            for(int j = 0; j < this.columnsCount; ++j){
                System.out.println(this.matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

//    public int[][] multiplyMatrix(int[][] multiplierMatrix, int resultColumnsCount){
//        final int[][] resultMatrix = new int[this.rowsCount][resultColumnsCount];
//        for(int i = 0; i < this.rowsCount; ++i){
//            for(int j = 0; j < resultColumnsCount; ++j){
//                for(int k = 0; k < this.columnsCount; ++k) {
//                    resultMatrix[i][j] = this.matrix[i][k] * multiplierMatrix[k][j];
//                }
//            }
//        }
//        return resultMatrix;
//    }

    public MatrixHandler multiplyMatrix(MatrixHandler matrix){
        int resultColumnsCount = matrix.getColumnsCount();
        int[][] multiplierMatrix = matrix.getMatrix();
        MatrixHandler resultMatrix =
                new MatrixHandler(new int[this.rowsCount][resultColumnsCount], this.rowsCount, resultColumnsCount);
        int[][] outMatrix = resultMatrix.getMatrix();
        for(int i = 0; i < this.rowsCount; ++i){
            for(int j = 0; j < resultColumnsCount; ++j){
                for(int k = 0; k < this.columnsCount; ++k) {
                    outMatrix[i][j] = this.matrix[i][k] * multiplierMatrix[k][j];
                }
            }
        }
        resultMatrix.setMatrix(outMatrix);
        return resultMatrix;
    }
}
