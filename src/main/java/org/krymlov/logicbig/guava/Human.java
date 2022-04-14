package org.krymlov.logicbig.guava;

public class Human {

    private int age;
    private String name;
    boolean isAlive;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.isAlive = true;
    }

    private Human(){}

    public void growUp(){
        this.age++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }
}
