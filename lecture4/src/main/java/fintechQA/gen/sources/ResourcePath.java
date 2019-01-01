package fintechQA.gen.sources;

public enum ResourcePath {

    MAN_SURNAME("man/Surname.txt"),
    MAN_NAME("man/Name.txt"),
    MAN_MIDDLENAME("man/MiddleName.txt"),
    WOMAN_SURNAME("woman/Surname.txt"),
    WOMAN_NAME("woman/Name.txt"),
    WOMAN_MIDDLENAME("woman/MiddleName.txt"),
    COUNTRY("Country.txt"),
    REGION("Region.txt"),
    CITY("City.txt"),
    STREET("Street.txt");

    private final String path;

    private ResourcePath(String path) {
        this.path = path;
    }

    public boolean equalsPath(String otherPath) {
        return path.equals(otherPath);
    }

    public String toString() {
        return this.path;
    }

    public String get() {
        return this.path;
    }

}
