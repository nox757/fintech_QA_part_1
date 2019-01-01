package fintechQA.model;

public class Address {
    private String postCode;
    private String country;
    private String region;
    private String city;
    private String street;
    private Integer numHouse;
    private Integer numFlat;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (postCode != null ? !postCode.equals(address.postCode) : address.postCode != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (numHouse != null ? !numHouse.equals(address.numHouse) : address.numHouse != null) return false;
        return numFlat != null ? numFlat.equals(address.numFlat) : address.numFlat == null;
    }

    @Override
    public int hashCode() {
        int result = postCode != null ? postCode.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (numHouse != null ? numHouse.hashCode() : 0);
        result = 31 * result + (numFlat != null ? numFlat.hashCode() : 0);
        return result;
    }
}