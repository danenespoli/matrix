package Matrix;

/**
 * Created by danenespoli on 4/8/16.
 */
public class AugmentedSquareMatrix extends SquareMatrix {
    protected Vector solution;    //solution column

    public AugmentedSquareMatrix(int M) {
        super(M);
        solution = new Vector(M);
    }
    public AugmentedSquareMatrix(AugmentedSquareMatrix A) {
        super(A);
        solution = A.solution;
    }

    public AugmentedSquareMatrix(SquareMatrix A, Vector v) {
        super(A);
        solution = new Vector(v);
    }

    @Override
    public void print() {
        for (int r=0; r<M; r++) {
            for (int c=0; c<M; c++) {
                System.out.print((int)matrix[r][c] + "\t");
            }
            System.out.println("|\t" + (int)solution.at(r));
        }
        System.out.println();
    }
}
