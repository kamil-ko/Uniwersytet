package pl.sda.model;

import java.util.Objects;

public class Grade {

    private int id;
    private int firstTerm;
    private int secondTerm;
    private int studentId;
    private int subjectId;


    public Grade(int id, int firstTerm, int secondTerm, int studentId, int subjectId) {
        this.id = id;
        this.firstTerm = firstTerm;
        this.secondTerm = secondTerm;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(int firstTerm) {
        this.firstTerm = firstTerm;
    }

    public int getSecondTerm() {
        return secondTerm;
    }

    public void setSecondTerm(int secondTerm) {
        this.secondTerm = secondTerm;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return id == grade.id &&
                firstTerm == grade.firstTerm &&
                secondTerm == grade.secondTerm &&
                studentId == grade.studentId &&
                subjectId == grade.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstTerm, secondTerm, studentId, subjectId);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", firstTerm=" + firstTerm +
                ", secondTerm=" + secondTerm +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                '}';
    }
}
