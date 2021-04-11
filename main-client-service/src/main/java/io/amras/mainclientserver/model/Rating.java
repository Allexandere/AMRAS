package io.amras.mainclientserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class Rating{
    @JsonProperty("Source")
    private String source;
    @JsonProperty("Value")
    private String value;

    public Rating(String source, String value){
        this.source = source;
        this.value = value;
    }
}
