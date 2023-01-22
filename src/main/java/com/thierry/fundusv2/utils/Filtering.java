package com.thierry.fundusv2.utils;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
public class Filtering {

    public static MappingJacksonValue filter(Object object, String filterName, String... fields){
        var mapping = new MappingJacksonValue(object);
        var filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        var filters = new SimpleFilterProvider().addFilter(filterName, filter);
        mapping.setFilters(filters);
        return mapping;
    }
}
