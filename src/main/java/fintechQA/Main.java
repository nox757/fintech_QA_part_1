package fintechQA;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import fintechQA.api.ServiceAPI;
import fintechQA.api.ServiceApiException;
import fintechQA.api.ServiceConnection;
import fintechQA.api.parser.PersonDeserializer;
import fintechQA.converter.ConverterToList;
import fintechQA.converter.PersonConverterToListImp;
import fintechQA.db.DBException;
import fintechQA.db.DBService;
import fintechQA.gen.RandomPersonGenerator;
import fintechQA.gen.RandomUtilsGenerator;
import fintechQA.gen.RandomUtilsGeneratorImpl;
import fintechQA.model.Person;
import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<String> headers = new ArrayList<>(Arrays.asList("Фамилия",
            "Имя", "Отчество", "Возраст", "Пол", "Дата рождения", "Инн",
            "Почтовый индекс", "Страна", "Область", "Город", "Улица", "Дом", "Квартира"));

    public static final RandomUtilsGenerator rdUtils = new RandomUtilsGeneratorImpl();


    public static void main(String[] args) throws IOException {

        int numRow = RandomUtils.nextInt(1, 30);
        List<Person> persons;
        DBService dbService = new DBService();
        try {
            persons = getApiPersons(numRow);
            try {
                for (Person person : persons) {
                    dbService.addPerson(person);
                }
            } catch (DBException exWrite) {
                System.err.println(exWrite.getMessage()
                        + "\nНе удалось записать данные из АPI в БД");
            }
        } catch (JsonParseException | ServiceApiException ex) {
            System.err.println(ex.getMessage()
                    + "\nНе удалось получить данные из АPI");
            try {
                persons = dbService.getRandListPersons(numRow);

            } catch (DBException exRead) {
                System.err.println(exRead.getMessage()
                        + "\nНе удалось получить данные из БД, файл будет создан своими силами");
                persons = getRandomPersons(numRow);
            }
        }
        ExcelCreator excelCreator = new ExcelCreator("new");
        ConverterToList<Person, String> converterToList = new PersonConverterToListImp();
        excelCreator.createHeaderRow(headers);
        for (Person person : persons) {
            excelCreator.addRow(converterToList.getListString(person));
        }
        String path = excelCreator.writeToFile(rdUtils.randString());
        System.out.println(path);
    }

    public static List<Person> getApiPersons(int num) throws ServiceApiException {

        ServiceAPI serviceAPI = new ServiceConnection();
        List<String> rowsJson = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            rowsJson.add(serviceAPI.getJson());
        }
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Person.class, new PersonDeserializer())
                .create();
        return rowsJson.stream()
                .map(json -> gson.fromJson(json, Person.class))
                .collect(Collectors.toList());
    }

    public static List<Person> getRandomPersons(int num) {

        RandomPersonGenerator personGenerator = new RandomPersonGenerator(rdUtils);
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            persons.add(personGenerator.generate());
        }
        return persons;
    }
}
