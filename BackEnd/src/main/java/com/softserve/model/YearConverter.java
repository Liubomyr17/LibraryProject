package com.softserve.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        if (year != null) {
            return (short) year.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Short dbYear) {
        if (dbYear != null) {
            return Year.of(dbYear);
        }
        return null;
    }
}