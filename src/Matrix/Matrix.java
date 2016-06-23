package Matrix;

/**
 * Created by danenespoli on 4/6/16.
 */
public class Matrix {
    protected int M, N;
    protected double[][] matrix;

    public Matrix(int M, int N) {   //empty matrix
        this.M = M;
        this.N = N;
        matrix = new double[M][N];
    }
    public Matrix(double[][] mat) {   //from array
        this.M = mat.length;
        this.N = mat[0].length;
        matrix = new double[M][N];
        for (int r=0; r<M; r++) {
            matrix[r] = mat[r].clone();
        }
    }
    public Matrix(Matrix A) {   //copy constructor
        this.M = A.M;
        this.N = A.N;
        matrix = new double[M][N];
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                matrix[r][c] = A.matrix[r][c];
            }
        }
    }

    //Print
    public void print() {
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                System.out.print((int)matrix[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Access
    public int getM() { return M; }
    public int getN() { return N; }
    public double at(int r, int c) {
        return matrix[r][c];
    }
    public void set(int r, int c, double val) {
        if (r<M && c<N) {
            matrix[r][c] = val;
        }
    }
    //Arithmetic
    public void add(double t) {
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                matrix[r][c] += t;
            }
        }
    }
    public void add(Matrix A) {
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                matrix[r][c] += A.matrix[r][c];
            }
        }
    }
    public Matrix multiply(Matrix A) {
        if (N != A.M) return null;
        Matrix result = new Matrix(M, A.N);
        for (int r=0; r<M; r++) {
            for (int c=0; c<A.N; c++) {
                Vector row = new Vector(this, r, Vector.VectorType.ROW);
                Vector col = new Vector(A, c, Vector.VectorType.COL);
                result.matrix[r][c] = row.dot(col);
            }
        }
        return result;
    }
    public Vector multiply(Vector v) {
        if (N != v.M) return null;
        Vector result = new Vector(M);
        for (int i=0; i<M; i++) {
                Vector row = new Vector(this, i, Vector.VectorType.ROW);
                result.set(i, row.dot(v));
        }
        return result;
    }
    public boolean isInvertible() {
        return false;
    }
}
