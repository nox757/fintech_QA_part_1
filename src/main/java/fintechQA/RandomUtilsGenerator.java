package fintechQA;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.stream.Collectors;

import static fintechQA.FileResource.getList;

public class RandomUtilsGenerator {

    public static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random rd = new Random();


    private Map<ResourcePath, List<String>> resources = new HashMap<>();

    public void fillResources() {
        for (ResourcePath nameResource : ResourcePath.values()) {
            resources.put(nameResource, getList(nameResource.toString()));
        }
    }

    private String randStringFromList(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.get(RandomUtils.nextInt(0,strings.size()));
    }

    public String randWomanSurname() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_SURNAME));
    }

    public  String randWomanName() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_NAME));
    }

    public  String randWomanMiddleName() {
        return randStringFromList(resources.get(ResourcePath.WOMAN_MIDDLENAME));
    }

    public  String randManSurname() {
        return randStringFromList(resources.get(ResourcePath.MAN_SURNAME));
    }

    public  String randManName() {
        return randStringFromList(resources.get(ResourcePath.MAN_NAME));
    }

    public  String randManMiddleName() {
        return randStringFromList(resources.get(ResourcePath.MAN_MIDDLENAME));
    }

    public  String randCountry() {
        return randStringFromList(resources.get(ResourcePath.COUNTRY));
    }

    public  String randCity() {
        return randStringFromList(resources.get(ResourcePath.CITY));
    }

    public  String randRegion() {
        return randStringFromList(resources.get(ResourcePath.REGION));
    }

    public  String randStreet() {
        return randStringFromList(resources.get(ResourcePath.STREET));
    }

    public static String randString() {
        int length = rd.nextInt(20) + 1;
        return rd.ints(length, 0, chars.length())
                .mapToObj(i -> "" + chars.charAt(i))
                .collect(Collectors.joining());
    }


}
