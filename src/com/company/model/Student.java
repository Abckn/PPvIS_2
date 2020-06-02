package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int total;
    private List<Integer> sem_work = new ArrayList<>();


    public int getTotal() {
        return total;
    }

    public int getTenthTerm() {
        return sem_work.get(9);
    }

    public void setTenthTerm(int tenthTerm) {
        this.sem_work.add(tenthTerm);
        this.total += tenthTerm;
    }

    public int getNinthTerm() {
        return sem_work.get(8);
    }

    public void setNinthTerm(int ninthTerm) {
        this.sem_work.add(ninthTerm);
        this.total += ninthTerm;
    }

    public int getEighthTerm() {
        return sem_work.get(7);
    }

    public void setEighthTerm(int eighthTerm) {
        this.sem_work.add(eighthTerm);
        this.total += eighthTerm;
    }

    public int getSeventhTerm() {
        return sem_work.get(6);
    }

    public void setSeventhTerm(int seventhTerm) {
        this.sem_work.add(seventhTerm);
        this.total += seventhTerm;
    }

    public int getSixthTerm() {
        return sem_work.get(5);
    }

    public void setSixthTerm(int sixthTerm) {
        this.sem_work.add(sixthTerm);
        this.total += sixthTerm;
    }

    public int getFiveTerm() {
        return sem_work.get(4);
    }

    public void setFiveTerm(int fiveTerm) {
        this.sem_work.add(fiveTerm);
        this.total += fiveTerm;
    }

    public int getFourthTerm() {
        return sem_work.get(3);
    }

    public void setFourthTerm(int fourthTerm) {
        this.sem_work.add(fourthTerm);
        this.total += fourthTerm;
    }

    public int getThirdTerm() {
        return sem_work.get(2);
    }

    public void setThirdTerm(int thirdTerm) {
        this.sem_work.add(thirdTerm);
        this.total += thirdTerm;
    }

    public int getSecondTerm() {
        return sem_work.get(1);
    }

    public void setSecondTerm(int secondTerm) {
        this.sem_work.add(secondTerm);
        this.total += secondTerm;
    }

    public int getFirstTerm() {
        return sem_work.get(0);

    }

    public void setFirstTerm(int firstTerm) {
        this.sem_work.add(firstTerm);
        this.total += firstTerm;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}