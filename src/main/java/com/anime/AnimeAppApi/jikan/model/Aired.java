package com.anime.AnimeAppApi.jikan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Aired {
    public String from;
    @JsonProperty("to")
    public String myto;
    public Prop prop;
    public String string;
}
