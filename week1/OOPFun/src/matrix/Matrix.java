package matrix;

public class Matrix {

    private Pixel[][] matrix;
    private int row;
    private int col;

    Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrix = new Pixel[row][col];
    }

    public Pixel[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Pixel[][] matrix) {
        this.matrix = matrix;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Pixel getPixelAt(int i, int j) {
        return matrix[i][j];
    }

    public void setPixelAt(Pixel p, int i, int j) {
        matrix[i][j] = p;
    }

    public void fillMatrixWith(Pixel value) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();
        int i;
        int j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                matrixString.append(matrix[i][j].toString());
            }
            matrixString.append("\n");
            
            for (j = 0; j < col; j++) {
                matrixString.append("--------------------------------");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }

    public void operate(MatrixOperation operation){
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                Pixel result = operation.withPixel(i, j, matrix);
                matrix[i][j] = result;
            }
        }
    }

}
