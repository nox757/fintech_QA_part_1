package fintechQA.api.parser;

import com.google.gson.*;
import fintechQA.gen.RandomUtilsGenerator;
import fintechQA.gen.RandomUtilsGeneratorImpl;
import fintechQA.model.Address;
import fintechQA.model.Person;

import java.lang.reflect.Type;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PersonDeserializer implements JsonDeserializer<Person> {

    private final static RandomUtilsGenerator rdUtils = new RandomUtilsGeneratorImpl();
    private JsonObject jsonObject;

    @Override
    public Person deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        if (jsonElement.isJsonObject()) {
            jsonObject = jsonElement.getAsJsonObject();

            Address address = new Address();
            address.setPostCode(getStringValue("postcode"))
                    .setCountry("Россия")
                    .setRegion(rdUtils.randRegion())
                    .setCity(getStringValue("city"))
                    .setStreet(getStringValue("street"))
                    .setNumHouse(getIntValue("house"))
                    .setNumFlat(getIntValue("apartment"));

            Person person = new Person();
            person.setSurname(getStringValue("lname"))
                    .setName(getStringValue("fname"))
                    .setMiddleName(getStringValue("patronymic"))
                    .setGender(getStringValue("gender").equals("w") ? "Ж" : "M")
                    .setInn(rdUtils.randInn())
                    .setAddress(address);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
                person.setBirthday(LocalDate.parse(getStringValue("date"), formatter));
            } catch (DateTimeException ex) {
                throw new JsonParseException("Could not parse date " + getStringValue("date"), ex);
            }
            return person;
        }
        throw new JsonParseException("Could not parse: " + jsonElement.getAsString());
    }

    private String getStringValue(String key) {
        if (jsonObject == null || !jsonObject.keySet().contains(key)) {
            throw new JsonParseException("Could not find key : " + key);
        }
        return jsonObject.get(key).getAsString();
    }

    private Integer getIntValue(String key) {
        if (jsonObject == null || !jsonObject.keySet().contains(key)) {
            throw new JsonParseException("Could not find key : " + key);
        }
        return jsonObject.get(key).getAsInt();
    }

}
