package Matrix;

/**
 * Created by danenespoli on 4/6/16.
 */
public class MatrixMapping extends Matrix {

    public MatrixMapping(Matrix mapping) {
        super(mapping);
    }

    Vector eval(Vector input) {
        return multiply(input);
    }
}
