package ftl3;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ftl3.RandomUtilsGenerator.randString;

public class Main {

    public static List<String> headers = new ArrayList<>(Arrays.asList("Фамилия",
            "Имя", "Отчество", "Возраст", "Пол", "Дата рождения", "Инн",
            "Почтовый индекс", "Страна", "Область", "Город", "Улица", "Дом", "Квартира"));



    public static void main(String[] args) throws IOException {

        RandomUtilsGenerator randomUtilsGenerator = new RandomUtilsGenerator();
        randomUtilsGenerator.fillResources();
        RandomPersonGenerator personGenerator = new RandomPersonGenerator(randomUtilsGenerator);
        List<Person> persons = new ArrayList<>();
        int numRow = RandomUtils.nextInt(1,30);
        for (int i = 0; i < numRow; i++) {
            persons.add(personGenerator.generate());
        }
        ExcelCreator excelCreator = new ExcelCreator("new");
        excelCreator.createHeaderRow(headers);
        excelCreator.addRows(persons);
        excelCreator.writeToFile(randString());

        System.out.println();
    }
}
