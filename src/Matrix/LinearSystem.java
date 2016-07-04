package Matrix;

import java.io.*;
import java.util.Hashtable;

/**
 * Created by danenespoli on 4/8/16.
 */
public class LinearSystem {
    protected AugmentedSquareMatrix system;
    private Hashtable<Integer, String> map; //for tracking variable names

    public LinearSystem(AugmentedSquareMatrix A) {
        system = new AugmentedSquareMatrix(A);
    }
    public LinearSystem(SquareMatrix A, Vector v) {
        system = new AugmentedSquareMatrix(A, v);
    }
    public LinearSystem(int M) {
        system = new AugmentedSquareMatrix(M);
    }
    public LinearSystem() throws IOException {
        readInSystem();
    }

    private void readInSystem() throws IOException {  //NEGATIVES DON'T WORK!
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of equations:");
        int numEqns = Integer.parseInt(stdin.readLine());
        system = new AugmentedSquareMatrix(numEqns);
        system.print();
        Hashtable<String, Integer> varMap = new Hashtable<>();
        Hashtable<Integer, String> colMap = new Hashtable<>();
        int column = 0;     //column indicates where the next assigned variable will go

        for (int r = 0; r < numEqns; r++) {
            System.out.println("Enter Equation " + (r + 1) + ":");
            String raw = stdin.readLine().replaceAll("\\s", ""); //eliminate whitespace
            String[] terms = raw.split("\\+|\\-|=");            //split string on operators

            for (int i = 0; i < terms.length - 1; i++) {
                String[] tokens = terms[i].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");    //split numbers from letters

                double coefficient = (tokens.length == 1) ? (1) : Double.parseDouble(tokens[0]);
                String variable = (tokens.length == 1) ? tokens[0] : tokens[1];
                if (!varMap.containsKey(variable)) { //if variable hasn't been seen before
                    colMap.put(column, variable);
                    varMap.put(variable, column);
                    column++;
                }
                system.matrix[r][varMap.get(variable)] = coefficient;
            }
            system.solution.set(r, Double.parseDouble(terms[terms.length - 1]));  //assumes last token is answer
            system.print();     //DEBUG
            map = colMap;
        }
    }

    private SquareMatrix colVectorIntoMatrix(int col) {
        assert(col >= 0 && col < system.M);
        SquareMatrix B = new SquareMatrix(system);
        for (int r=0; r<B.M; r++) {
            B.matrix[r][col] = system.solution.at(r);
        }
        return B;
    }
    private Hashtable solve() { //Use Cramer's Rule to solve system
        Hashtable<Integer, Double> solution = new Hashtable<>();    //maps variable (column) to its value
        double det = system.determinant();
        if (det == 0) {
            System.err.println("LinearSystem Solve Failed: determinant of matrix is 0");
            return null;
        } else {
            for (int c = 0; c < system.N; c++) {
                double detC = colVectorIntoMatrix(c).determinant();
                solution.put(c, detC/det);
            }
            return solution;
        }
    }
    public void printSolutions() {
        Hashtable<Integer, Double> solution = solve();
        for (int c=0; c<system.N; c++) {
            System.out.println(map.get(c) + " = " + solution.get(c));
        }
    }

}
