import Matrix.*;
import GUI.*;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by danenespoli on 4/6/16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //Linear system solver
        LinearSystem LS = new LinearSystem();
        LS.printSolutions();

        //Determinant
        SquareMatrix A = new SquareMatrix(new double[][]{
                {1, 2, 3},
                {5, 0, 1},
                {8, 7, 3}
        });
        System.out.println(A.determinant());

        //Matrix multiplication
        Matrix B = new Matrix(new double[][]{
                {1, 2, 3, 0},
                {5, 0, 1, 1},
                {8, 7, 3, 8}
        });
        Matrix C = A.multiply(B);
        C.print();
    }
}
