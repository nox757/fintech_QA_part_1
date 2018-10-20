package fintechQA;

import fintechQA.gen.RandomPersonGenerator;
import fintechQA.gen.RandomUtilsGenerator;
import fintechQA.gen.RandomUtilsGeneratorImpl;
import fintechQA.model.Person;
import fintechQA.converter.ConverterToList;
import fintechQA.converter.PersonConverterToListImp;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<String> headers = new ArrayList<>(Arrays.asList("Фамилия",
            "Имя", "Отчество", "Возраст", "Пол", "Дата рождения", "Инн",
            "Почтовый индекс", "Страна", "Область", "Город", "Улица", "Дом", "Квартира"));

    public static void main(String[] args) throws IOException {

        RandomUtilsGenerator randomUtilsGenerator = new RandomUtilsGeneratorImpl();
        randomUtilsGenerator.fillResources();

        RandomPersonGenerator personGenerator = new RandomPersonGenerator(randomUtilsGenerator);
        List<Person> persons = new ArrayList<>();
        int numRow = RandomUtils.nextInt(1,30);
        for (int i = 0; i < numRow; i++) {
            persons.add(personGenerator.generate());
        }
        ExcelCreator excelCreator = new ExcelCreator("new");
        ConverterToList<Person, String> converterToList = new PersonConverterToListImp();
        excelCreator.createHeaderRow(headers);
        for (Person person : persons) {
            excelCreator.addRow(converterToList.getListString(person));
        }
        String path = excelCreator.writeToFile(randomUtilsGenerator.randString());
        System.out.println(path);
    }
}
