package fintechQA.gen;

import fintechQA.model.Person;
import org.apache.commons.lang3.RandomUtils;

public class RandomPersonGenerator extends RandomEntityGenerator<Person> {

    public RandomPersonGenerator(RandomUtilsGenerator rdUtils) {
        super(rdUtils);
    }

    public Person generate() {
        Person person = new Person();
        person.setGender(generateGender());
        fillNames(person);
        person.setInn(rdUtils.randInn())
                .setBirthday(rdUtils.randBirthday());
        person.setAddress(new RandomAdressGenerator(rdUtils).generate());
        return person;
    }

    private String generateGender() {
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

}
