package fintechQA.model;

public class Address {
    String postCode;
    String country;
    String region;
    String city;
    String street;
    Integer numHouse;
    Integer numFlat;

    public String getPostCode() {
        return postCode;
    }

    public Address setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Address setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Integer getNumHouse() {
        return numHouse;
    }

    public Address setNumHouse(Integer numHouse) {
        this.numHouse = numHouse;
        return this;
    }

    public Integer getNumFlat() {
        return numFlat;
    }

    public Address setNumFlat(Integer numFlat) {
        this.numFlat = numFlat;
        return this;
    }
}