package com.anime.AnimeAppApi.jikan.model.seasonNow;



import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "JikanAnimeSeasonNow")
@lombok.Data
public class Root {
    public Pagination pagination;
    public ArrayList<Data> data;
}
