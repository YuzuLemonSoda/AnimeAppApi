package com.anime.AnimeAppApi.jikan.model.seasonNow;



import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "JikanAnimeSeasonNow")

@lombok.Data
public class Root {
    @JsonIgnore
    public Pagination pagination;
    public ArrayList<Data> data;
}
