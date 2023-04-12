import matrixhandler.MatrixHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MatrixHandler matrix = new MatrixHandler();
        MatrixHandler multiplierMatrix = new MatrixHandler();

        Scanner scanner = new Scanner(System.in);
        matrix.inputMatrix(scanner);
        multiplierMatrix.inputMatrix(scanner);

        MatrixHandler resultMatrix = matrix.multiplyMatrix(multiplierMatrix);
        resultMatrix.outputMatrix();
    }
}