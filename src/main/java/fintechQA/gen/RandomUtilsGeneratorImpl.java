package fintechQA.gen;

import fintechQA.gen.sources.ResourcePath;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static fintechQA.gen.sources.LoaderFileResource.loadResource;

public class RandomUtilsGeneratorImpl implements RandomUtilsGenerator {

    public static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random rd = new Random();

    private Map<ResourcePath, List<String>> resources = new HashMap<>();

    public void fillResources() {
        for (ResourcePath nameResource : ResourcePath.values()) {
            resources.put(nameResource, loadResource(nameResource.toString()));
        }
    }

    private String randStringFromList(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.get(RandomUtils.nextInt(0, strings.size()));
    }

    public String randWomanSurname() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_SURNAME));
    }

    public String randWomanName() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_NAME));
    }

    public String randWomanMiddleName() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_MIDDLENAME));
    }

    public String randManSurname() {
        return randStringFromList(resources.get(ResourcePath.MAN_SURNAME));
    }

    public String randManName() {
        return randStringFromList(resources.get(ResourcePath.MAN_NAME));
    }

    public String randManMiddleName() {
        return randStringFromList(resources.get(ResourcePath.MAN_MIDDLENAME));
    }

    public String randCountry() {
        return randStringFromList(resources.get(ResourcePath.COUNTRY));
    }

    public String randCity() {
        return randStringFromList(resources.get(ResourcePath.CITY));
    }

    public String randRegion() {
        return randStringFromList(resources.get(ResourcePath.REGION));
    }

    public String randStreet() {
        return randStringFromList(resources.get(ResourcePath.STREET));
    }

    public String randInn() {
        int[] inn = new int[12];
        inn[0] = 7;
        inn[1] = 7;
        int ifnsCode = RandomUtils.nextInt(1, 52); // ИФНС
        inn[2] = ifnsCode / 10;
        inn[3] = ifnsCode % 10;
        for (int i = 4; i < 10; i++) {
            inn[i] = RandomUtils.nextInt(0,10);
        }
        int[] koeff11 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int[] koeff12 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        inn[10] = getControlDigit(inn, koeff11);
        inn[11] = getControlDigit(inn, koeff12);

        return Arrays.stream(inn)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));

    }

    private int getControlDigit(int[] arr1, int[] koeff) {
        int control = 0;
        for (int i = 0; i < koeff.length; i++) {
            control += arr1[i] * koeff[i];
        }
        return control % 11 % 10;
    }

    public LocalDate randBirthday(){
        return LocalDate.now().minusYears(RandomUtils.nextLong(1, 115))
                .minusMonths(RandomUtils.nextLong(0,13))
                .minusDays(RandomUtils.nextLong(0,32));
    }

    public String randString() {
        int length = rd.nextInt(20) + 1;
        return rd.ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }


}
