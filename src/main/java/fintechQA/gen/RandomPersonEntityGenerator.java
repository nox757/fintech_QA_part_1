package fintechQA.gen;

import fintechQA.model.Person;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;

public class RandomPersonEntityGenerator extends RandomEntityGenerator<Person> {

    public RandomPersonEntityGenerator(RandomUtilsGenerator rdUtils) {
        super(rdUtils);
    }

    public Person generate() {
        Person person = new Person();
        person.setGender(genereteGender());
        fillNames(person);
        person.setInn(generateInn())
                .setBirthday(LocalDate.now().minusYears(RandomUtils.nextLong(1, 100))); //TODO: сдеалть генерацию разных дат
        person.setAddress(new RandomAdressEntityGenerator(rdUtils).generate());
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
