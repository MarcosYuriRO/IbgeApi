package com.marcos.IbgeApi.model.news;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record News(@JsonAlias("titulo") String title,
                   @JsonAlias("introducao") String introduction,
                   @JsonAlias("data_publicacao") String datePublication,
                   @JsonAlias("link") String linkNew) {

    @Override
    public String toString() {
        return "" + title + "\n" + introduction + "\n" + datePublication + "\n" + linkNew;
    }
}
