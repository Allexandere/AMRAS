package io.amras.omdbapiservice.model;

import lombok.Data;

@Data
public class MovieRequest {
    private String searchKeyword;
    private String year;

    public MovieRequest(String searchKeyword, String year){
        this.searchKeyword = searchKeyword;
        this.year=year;
    }

    public MovieRequest(){}
}
