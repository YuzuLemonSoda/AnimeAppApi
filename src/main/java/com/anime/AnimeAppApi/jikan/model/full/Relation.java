package com.anime.AnimeAppApi.jikan.model.full;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Relation {
    public String relation;
    public ArrayList<Entry> entry;
}
