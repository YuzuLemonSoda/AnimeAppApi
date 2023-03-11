package com.anime.AnimeAppApi.jikan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Prop {
    public From from;
    @JsonProperty("to")
    public To myto;
}
