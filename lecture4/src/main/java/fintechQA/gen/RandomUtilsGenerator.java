package fintechQA.gen;


import java.time.LocalDate;

public interface RandomUtilsGenerator {
    void fillResources();

    String randWomanSurname();
    String randWomanName();
    String randWomanMiddleName();
    String randManSurname();
    String randManName();
    String randManMiddleName();
    String randCountry();
    String randRegion();
    String randCity();
    String randStreet();

    String randInn();
    LocalDate randBirthday();

    String randString();
}
