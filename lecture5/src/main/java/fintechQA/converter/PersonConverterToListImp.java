package fintechQA.converter;

import fintechQA.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonConverterToListImp implements ConverterToList<Person, String> {

    @Override
    public List<String> getListString(Person person) {
        if (person == null) {
            return null;
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(person.getSurname());
        resultList.add(person.getName());
        resultList.add(person.getMiddleName());
        resultList.add(String.valueOf(person.getAge()));
        resultList.add(person.getGender());
        resultList.add(String.valueOf(person.getBirthday()));
        resultList.add(person.getInn());
        resultList.addAll(new AddressConverterToListImp().getListString(person.getAddress()));
        return resultList;
    }

}
