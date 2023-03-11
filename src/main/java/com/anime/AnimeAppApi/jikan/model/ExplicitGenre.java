package com.anime.AnimeAppApi.jikan.model;

import lombok.Data;

@Data
public class ExplicitGenre {
    public int mal_id;
    public String type;
    public String name;
    public String url;
}
