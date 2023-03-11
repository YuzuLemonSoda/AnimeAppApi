package com.anime.AnimeAppApi.jikan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Trailer {
    public String youtube_id;
    public String url;
    public String embed_url;
    @JsonProperty(value = "images")
    public Images2 images2;
}
