package com.anime.AnimeAppApi.jikan.model.seasonNow;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@lombok.Data
public class Data {

    @MongoId
    public long mal_id;

    public String url;
    public Images images;
    public Trailer trailer;
    public boolean approved;
    public ArrayList<Title> titles;
    public String title;
    public String title_english;
    public String title_japanese;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ArrayList<String> title_synonyms;
    public String type;
    public String source;
    public int episodes;
    public String status;
    public boolean airing;
    public Aired aired;
    public String duration;
    public String rating;
    public double score;
    public int scored_by;
    public int rank;
    public int popularity;
    public int members;
    public int favorites;
    public String synopsis;
    public String background;
    public String season;
    public int year;
    public Broadcast broadcast;
    public ArrayList<Producer> producers;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ArrayList<Licensor> licensors;
    public ArrayList<Studio> studios;
    public ArrayList<Genre> genres;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ArrayList<Object> explicit_genres;
    public ArrayList<Theme> themes;
    public ArrayList<Demographic> demographics;
}
