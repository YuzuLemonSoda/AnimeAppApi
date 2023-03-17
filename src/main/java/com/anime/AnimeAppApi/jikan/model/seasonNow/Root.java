package com.anime.AnimeAppApi.jikan.model.seasonNow;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

@lombok.Data
public class Root {
    @JsonIgnore
    public Pagination pagination;
    public ArrayList<Data> data;
}
