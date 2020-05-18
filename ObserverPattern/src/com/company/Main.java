package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(false, "Bethoven", false);
        Teacher teacher2 = new Teacher(false, "Mozart", true);
        Teacher teacher3 = new Teacher(false, "Shopen", false);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        Decanat decanat = new Decanat(teachers);
        teacher1.addObserver(decanat);
        teacher2.addObserver(decanat);
        teacher3.addObserver(decanat);

        //teacher1.CreateAcademicalPerformance();

        decanat.checkTeachers();
    }
}
