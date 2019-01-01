package fintechQA.converter;

import fintechQA.model.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressConverterToListImp implements ConverterToList<Address, String> {

    @Override
    public List<String> getListString(Address address) {
        if (address == null) {
            return null;
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(address.getPostCode());
        resultList.add(address.getCountry());
        resultList.add(address.getRegion());
        resultList.add(address.getCity());
        resultList.add(address.getStreet());
        resultList.add(String.valueOf(address.getNumHouse()));
        resultList.add(String.valueOf(address.getNumFlat()));

        return resultList;
    }
}
