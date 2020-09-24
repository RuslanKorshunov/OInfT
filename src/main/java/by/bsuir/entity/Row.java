package by.bsuir.entity;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Double> values;

    public Row(int size) {
        values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add((double) 0);
        }
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
