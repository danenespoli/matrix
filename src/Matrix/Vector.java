package Matrix;

/**
 * Created by danenespoli on 4/6/16.
 */
public class Vector extends Matrix {

    public enum VectorType {
        ROW, COL
    }

    public Vector(int M) {
        super(M, 1);
    }
    public Vector(Vector v) {
        super(v);
    }
    public Vector(Matrix A, int index, VectorType vtype) {  //vector from Row/Col
        super((vtype == VectorType.ROW) ? A.N : A.M, 1);
        if (vtype == VectorType.ROW) {
            for (int i=0; i<A.N; i++) {
                matrix[i][0] = A.matrix[index][i];
            }
        } else if (vtype == VectorType.COL) {
            for (int i=0; i<A.M; i++) {
                matrix[i][0] = A.matrix[i][index];
            }
        }
    }
    public Vector(double[] m) {
        super(m.length, 1);
        for (int i=0; i<m.length; i++) matrix[i][0] = m[i];
    }

    public double at(int i) {
        return matrix[i][0];
    }
    public void set(int i, double val) {
        matrix[i][0] = val;
    }
    public double dot(Vector v) {
        if (M != v.M) return 0;
        double dot = 0;
        for (int i=0; i<M; i++) {
            dot += at(i) * v.at(i);
        }
        return dot;
    }
}
