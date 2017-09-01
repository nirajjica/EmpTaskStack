package com.eschool.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Converter
public class ListToStringConverter implements AttributeConverter<List<String>, String> {

    /**
     * Converts property to  string
     *
     * @param attribute The property of entity
     * @return string
     */
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        final String string = attribute.toString();
        return string.substring(1, string.length() - 1);
    }

    /**
     * Converts  string to property of entity
     *
     * @param dbData string
     * @return propety value
     */
    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(dbData.split(", ")));
    }
}