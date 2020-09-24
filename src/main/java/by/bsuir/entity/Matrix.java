package by.bsuir.entity;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private List<Row> rows;
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.rows = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            rows.add(new Row(n));
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

    @Override
    public String toString() {
        String result = "";
        for (Row row : rows) {
            result += "[";
            for (int i = 0; i < n; i++) {
                result += row.get(i);
                if (i < n - 1) {
                    result += " ";
                }
            }
            result += "]\n";
        }
        return result;
    }
}
