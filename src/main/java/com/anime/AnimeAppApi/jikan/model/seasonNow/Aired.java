package com.anime.AnimeAppApi.jikan.model.seasonNow;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Aired {
    public String from;
    @JsonProperty("to")
    public String myto;
    public Prop prop;
    public String string;
}
