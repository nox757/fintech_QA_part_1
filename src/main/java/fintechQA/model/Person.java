package fintechQA.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String surname;
    private String name;
    private String middleName;
    private LocalDate birthday;
//    private  GENDER gender;
//    enum GENDER {
//        MALE, FEMALE;
//    }
    private String gender;
    private String inn;
    private Address address;

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Person setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Person setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Person setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getInn() {
        return inn;
    }

    public Person setInn(String inn) {
        this.inn = inn;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
