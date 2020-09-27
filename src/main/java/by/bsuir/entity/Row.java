package by.bsuir.entity;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> values;

    public Row(List<Double> values) {
        this.values = values;
    }

    public Row(int size) {
        values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add((double) 0);
        }
    }

    public Row(Double value, int size) {
        values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add(value);
        }
    }

    public Row(Row row, int size) {
        if (size <= row.size()) {
            this.values = row.subRow(size).values;
        } else {
            int s = row.size();
            this.values = row.values;
            for (int i = s; i < size; i++) {
                this.values.add(0.0);
            }
        }
    }

    public Row subRow(int n) {
        Row row = null;
        if (n <= size()) {
            row = new Row(this.values.subList(0, n));
        }
        return row;
    }

    public void set(double value, int index) {
        if (index < values.size()) {
            values.set(index, value);
        }
    }

    public Double get(int index) {
        Double value = null;
        if (index < values.size()) {
            value = values.get(index);
        }
        return value;
    }

    public int size() {
        return values.size();
    }
}
