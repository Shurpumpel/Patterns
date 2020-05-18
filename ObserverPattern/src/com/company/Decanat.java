package com.company;

import java.util.ArrayList;
import java.util.List;

public class Decanat implements Observer {
    private List<Teacher> teachers = new ArrayList<>();

    public Decanat(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void Update(Observed a) {
        System.out.println(((Teacher)a).name + " обновил текущую успеваемость.");
    }



    public void checkTeachers(){
        for (Teacher a : teachers){
            if (!a.isCreatedAcademicalPerformance() && a.isMustCreatePerformance){
                System.out.println("\n!!!!!!!!!!!!!!!!\n"+((Teacher)a).name + " не обновил текущую успеваемость.");
            }
        }
    }
}
