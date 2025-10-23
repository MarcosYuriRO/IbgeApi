package com.marcos.IbgeApi.model.countries;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CapitalName(@JsonAlias("nome") String capitalName) {
    public String getCapitalName() {
        return capitalName;
    }

    @Override
    public String toString() {
        return "Capital: " + capitalName;


    }
}
