package com.marcos.IbgeApi.model.countries;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AllNameCountries(@JsonAlias("abreviado")String nameCountrie) {
    @Override
    public String toString() {
        return "Nome do País: " + nameCountrie;
    }
}
