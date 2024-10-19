package org.example;

import java.util.ArrayList;
import java.util.List;

public class CU {
    private String nameCU;
    private List<Mark> marks;
    private int totalStudents;

    public CU(String nameCU, int totalStudents) {
        this.nameCU = nameCU;
        this.totalStudents = totalStudents;
        this.marks = new ArrayList<>();
    }

    public void insertMarkCU(int numStudent, double mark) {
        Mark studentMark = searchStudent(numStudent);
        if (studentMark == null) {
            if (marks.size() < totalStudents) {
                marks.add(new Mark(numStudent, mark));
            } else {
                System.out.println("Limite de alunos atingido.");
            }
        } else {
            studentMark.setMark(mark);
        }
    }

    public Mark searchStudent(int numStudent) {
        for (Mark mark : marks) {
            if (mark.getNumStudent() == numStudent) {
                return mark;
            }
        }
        return null;
    }

    public double averageCU() {
        if (marks.isEmpty()) return 0.0;

        double total = 0;
        for (Mark mark : marks) {
            total += mark.getMark();
        }
        return total / marks.size();
    }

    public boolean isApproved(int numStudent) {
        Mark studentMark = searchStudent(numStudent);
        if (studentMark != null && studentMark.getMark() >= 9.5) {
            return true;
        }
        return false;
    }
}
