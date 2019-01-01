package fintechQA.converter;

import java.util.List;

public interface ConverterToList<I, O> {
    List<O> getListString(I entity);
}
