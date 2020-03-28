package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(false, "Bethoven");
        Teacher teacher2 = new Teacher(false, "Mozart");

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        Decanat decanat = new Decanat(teachers);
        teacher1.addObserver(decanat);
        teacher2.addObserver(decanat);

        teacher1.CreateAcademicalPerformance();

        decanat.checkTeachers();
    }
}
