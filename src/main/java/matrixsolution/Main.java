package matrixsolution;

public class Main {
    public static void main(String[] args) {
        MatrixHandler matrix = new MatrixHandler();
        MatrixHandler multiplierMatrix = new MatrixHandler();

        matrix.multiplyMatrix(multiplierMatrix);
        matrix.outputMatrix();

    }
}