package fintechQA;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String surname;
    private String name;
    private String middleName;
    private LocalDate birthday;
    private String gender;
    private String inn;

    private String postCode;
    private String country;
    private String region;
    private String city;
    private String street;
    private Integer numHouse;
    private Integer numFlat;

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

    public String getPostCode() {
        return postCode;
    }

    public Person setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Person setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Person setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Person setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Person setStreet(String street) {
        this.street = street;
        return this;
    }

    public Integer getNumHouse() {
        return numHouse;
    }

    public Person setNumHouse(Integer numHouse) {
        this.numHouse = numHouse;
        return this;
    }

    public Integer getNumFlat() {
        return numFlat;
    }

    public Person setNumFlat(Integer numFlat) {
        this.numFlat = numFlat;
        return this;
    }

    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
}
