package Matrix;

/**
 * Created by danenespoli on 4/6/16.
 */
public class SquareMatrix extends Matrix {

    public SquareMatrix(int M) {
        super(M, M);
    }
    public SquareMatrix(SquareMatrix A) {
        super(A);
    }
    public SquareMatrix(double[][] mat) {
        super(mat);
        assert(mat[0].length == mat.length);
    }

    //Matrix.Matrix Analytics
    protected SquareMatrix matrixExclIndex(int rExclude, int cExclude) {
        assert(M > 1);
        SquareMatrix B = new SquareMatrix(M-1);
        int rResult = 0, cResult = 0;
        for (int r=0; r<M; r++) {
            if (r != rExclude) {
                for (int c = 0; c < N; c++) {
                    if (c != cExclude) {
                        B.matrix[rResult][cResult] =  matrix[r][c];
                        cResult++;
                    }
                }
                rResult++;
                cResult = 0;
            }
        }
        return B;
    }
    public double determinant() {
        if (M == 1) {
            return matrix[0][0];
        }
        else if (M == 2) {
            return ((matrix[0][0]*matrix[1][1]) - (matrix[1][0]*matrix[0][1]));   //2x2 determinant formula
        } else {
            double det = 0;
            for (int i = 0; i < M; i++) {   //cofactor expansion along first column
                det += Math.pow(-1, i) * matrix[i][0] * matrixExclIndex(i, 0).determinant();
            }
            return det;
        }
    }
    @Override
    public boolean isInvertible() {
        return (determinant() != 0);
    }
}
