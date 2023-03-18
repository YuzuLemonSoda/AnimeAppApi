package com.anime.AnimeAppApi.jikan.model.full;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JikanAnimeAll")
@lombok.Data
public class Root {
    public Data data;
}
