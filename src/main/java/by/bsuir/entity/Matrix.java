package by.bsuir.entity;

import org.decimal4j.util.DoubleRounder;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<Row> rows;
    private int n;
    private int m;

    private Matrix() {
        this.rows = new ArrayList<>();
        this.m = 0;
        this.n = 0;
    }

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.rows = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.rows.add(new Row(n));
        }
    }

    public Matrix(Double value, int n, int m) {
        this.m = m;
        this.n = n;
        this.rows = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.rows.add(new Row(value, n));
        }
    }

    public Matrix(Matrix matrix, int n, int m) {
        this.m = m;
        this.n = n;
        List<Row> rows = new ArrayList<>();
        int number = Math.min(m, matrix.m);
        for (int i = 0; i < number; i++) {
            Row row = new Row(matrix.rows.get(i), n);
            rows.add(row);
        }
        if (m > matrix.m) {
            for (int i = matrix.m; i < m; i++) {
                Row row = new Row(n);
                rows.add(row);
            }
        }
        this.rows = rows;
    }

    public Matrix subMatrix(int n, int m) {
        Matrix matrix = null;
        if (m <= this.m && n <= this.n) {
            matrix = new Matrix();
            for (int i = 0; i < m; i++) {
                Row row = rows.get(i).subRow(n);
                matrix.rows.add(row);
            }
        }
        return matrix;
    }

    public void swapRows(int n1, int n2) {
        if (n1 != n2 && n1 < n && n2 < n && n1 >= 0 && n2 >= 0) {
            Row rowOne = rows.get(n1);
            Row rowTwo = rows.get(n2);
            rows.set(n2, rowOne);
            rows.set(n1, rowTwo);
        }
    }

    public void set(double value, int n, int m) {
        if (m < rows.size()) {
            rows.get(m).set(value, n);
        }
    }

    public Double get(int n, int m) {
        Double value = null;
        if (m < rows.size()) {
            value = rows.get(m).get(n);
        }
        return value;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    @Override
    public String toString() {
        String result = "";
        for (Row row : rows) {
            result += "[";
            for (int i = 0; i < n; i++) {
                Double number = row.get(i);
                if (number == null) {
                    result += "null";
                } else {
                    result += DoubleRounder.round(row.get(i), 3);
                }
                if (i < n - 1) {
                    result += " ";
                }
            }
            result += "]\n";
        }
        return result;
    }
}
