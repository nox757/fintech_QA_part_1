package fintechQA.gen;

import fintechQA.model.Address;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RandomAdressGenerator extends RandomEntityGenerator<Address> {

    public RandomAdressGenerator(RandomUtilsGenerator rdUtils) {
        super(rdUtils);
    }

    public Address generate() {
        Address address = new Address();
        address.setCountry(rdUtils.randCountry())
                .setRegion(rdUtils.randRegion())
                .setCity(rdUtils.randCity())
                .setStreet(rdUtils.randStreet())
                .setPostCode(RandomStringUtils.randomNumeric(6))
                .setNumHouse(RandomUtils.nextInt(0, 999))
                .setNumFlat(RandomUtils.nextInt(0,999));
        return address;
    }
}
