package com.marcos.IbgeApi.model.countries;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Capital(@JsonAlias("capital") CapitalName capital) {
    @Override
    public String toString() {
        return "" + capital;
    }
}
