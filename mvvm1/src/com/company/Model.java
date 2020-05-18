package com.company;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Integer> values = new ArrayList<>();
    public int sum = 0;
    public int count = 0;

    public Model() {
        this.values.add(1);
        this.values.add(12);
        this.values.add(13);
        this.values.add(121);
    }

    public void addValue(int value) {
        if(!values.contains(value)){
            values.add(value);
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    public void removeValue(int value){
        if(values.contains(value)){
            values.remove(values.indexOf(value));
        }
        sum+=value;
        count++;
    }
}
