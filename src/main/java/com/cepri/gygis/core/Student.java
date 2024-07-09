package com.cepri.gygis.core;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Comparator;

public class Student implements Comparator<Student> {

    private String name;

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }


}
