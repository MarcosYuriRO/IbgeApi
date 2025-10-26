package com.marcos.IbgeApi.model.countries;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Countries(@JsonAlias("nome") AllNameCountries name,
                        @JsonAlias("area") AreaCountry totalArea,
                        @JsonAlias("governo") Capital capitalCountry) {


    @Override
    public Capital capitalCountry() {
        return capitalCountry;
    }

    @Override
    public String toString() {
        return name + "\n" + totalArea + "\n" + capitalCountry + "\n";
    }
}