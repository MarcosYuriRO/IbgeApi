package com.marcos.IbgeApi.model.countries;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AreaCountry(@JsonAlias("total") String total) {
    @Override
    public String toString() {
        return "Área Total do País: " + total;
    }
}
