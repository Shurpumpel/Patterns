package com.company;

import java.util.List;

public class ViewModel {
    private Model model = new Model();

    private List<Integer> getList(){
        return model.getValues();
    }

    public String createStringWithValues(){
        List<Integer> list = model.getValues();
        String str = "";
        for(Integer val : list){
            str+=val+"\n";
        }
        return str;
    }

    public void removeValue(String str){
        model.removeValue(Integer.parseInt(str));
    }

    public void addValue(String str){
        model.addValue(Integer.parseInt(str));
    }

    public String getCount(){
        return String.valueOf(model.count);
    }

    public String getSum(){
        return String.valueOf(model.sum);
    }
}
