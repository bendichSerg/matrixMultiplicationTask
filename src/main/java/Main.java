import matrixhandler.MatrixHandler;

public class Main {
    public static void main(String[] args) {
        MatrixHandler matrix = new MatrixHandler();
        MatrixHandler multiplierMatrix = new MatrixHandler();
        MatrixHandler resultMatrix = matrix.multiplyMatrix(multiplierMatrix);
        resultMatrix.outputMatrix();
    }
}