package ftl3;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.Random;

public class RandomPersonGenerator {

    private RandomUtilsGenerator rdUtils;

    public RandomPersonGenerator(RandomUtilsGenerator rdUtils) {
        this.rdUtils = rdUtils;
    }

    public Person generate() {
        Person person = new Person();
        person.setGender(genereteGender());
        fillNames(person);
        person.setCountry(rdUtils.randCountry())
                .setRegion(rdUtils.randRegion())
                .setCity(rdUtils.randCity())
                .setStreet(rdUtils.randStreet())
                .setPostCode(RandomStringUtils.randomNumeric(6))
                .setNumHouse(RandomUtils.nextInt(0, 999))
                .setNumFlat(RandomUtils.nextInt(0,999))
                .setInn(generateInn())
                .setBirthday(LocalDate.now().minusYears(RandomUtils.nextLong(1, 100))); //TODO: сдеалть генерацию разных дат
        return person;
    }

    private String genereteGender() {
        return RandomUtils.nextInt(0, 2) == 1 ? "М" : "Ж";
    }

    private void fillNames(Person person) {
        if (person.getGender().equals("М")) {
            person.setSurname(rdUtils.randManSurname())
                    .setName(rdUtils.randManName())
                    .setMiddleName(rdUtils.randManMiddleName());
        }
        if (person.getGender().equals("Ж")) {
            person.setSurname(rdUtils.randWomanSurname())
                    .setName(rdUtils.randWomanName())
                    .setMiddleName(rdUtils.randWomanMiddleName());
        }
    }

    private String generateInn() {
        String inn = "77";
        //TODO: сделать валидную генерацию ИНН
        inn += RandomStringUtils.randomNumeric(10);
        return inn;
    }
}
