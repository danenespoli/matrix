package Matrix;

/**
 * Created by danenespoli on 4/6/16.
 */
public class IdentityMatrix extends Matrix {

    public IdentityMatrix(int M) {
        super(M, M);
        for (int i=0; i<M; i++) {
            matrix[i][i] = 1;
        }
    }
}
