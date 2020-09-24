package by.bsuir.main;

import by.bsuir.entity.Matrix;

public class Main {
    private static final String FIELD = "=================";

    public static void main(String... args) {
        System.out.println(FIELD + "First lab" + FIELD);
        int d = -1;
        double q = -4.25;
        //initialize matrix
        Matrix matrix = new Matrix(5, 5);

        matrix.set(q, 0, 0);
        matrix.set(q, 4, 4);
        for (int i = 1; i <= 4; i++) {
            matrix.set(1, i, i - 1);
            matrix.set(1, i - 1, i);
        }

        for (int i = 1; i <= 3; i++) {
            matrix.set(-2, i, i);
        }

        Matrix result = new Matrix(1, 5);

        for (int i = 1; i <= 3; i++) {
            result.set(d, 0, i);
        }

        System.out.println(matrix);
        System.out.println(result);
    }
}
