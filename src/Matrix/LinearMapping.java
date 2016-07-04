package Matrix;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by danenespoli on 4/6/16.
 */
public class LinearMapping extends MatrixMapping {

    public LinearMapping(SquareMatrix mapping) {    //domain = codomain
        super(mapping);
    }

//    public List<Map.Entry<Double, Vector>> eigenpairs() {
//        List<Map.Entry<Double, Vector>> eigenpairs = new ArrayList<>(); //eigenvalue + eigenvector pairs
//        eigenpairs.add(new AbstractMap.SimpleEntry<>(1.0, new Vector(new double[]{1, 2, 3})));
//
//        return eigenpairs;
//    }

}
