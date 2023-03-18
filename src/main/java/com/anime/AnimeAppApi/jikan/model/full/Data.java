package com.anime.AnimeAppApi.jikan.model.full;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@lombok.Data
public class Data {

    @MongoId
    public long mal_id;

    public String url;
    public Images images;
    @JsonIgnore
    public Images2 images2;
    public Trailer trailer;
    public boolean approved;
    public ArrayList<Title> titles;
    public String title;
    public String title_english;
    public String title_japanese;
    public ArrayList<String> title_synonyms;
    public String type;
    public String source;
    public int episodes;
    public String status;
    public boolean airing;
    public Aired aired;
    public String duration;
    public String rating;
    public int score;
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
    public ArrayList<Licensor> licensors;
    public ArrayList<Studio> studios;
    public ArrayList<Genre> genres;
    public ArrayList<ExplicitGenre> explicit_genres;
    public ArrayList<Theme> theme;
    public ArrayList<Demographic> demographics;
    public ArrayList<Relation> relations;
    public ArrayList<Themes> themes;
    public ArrayList<External> external;
    public ArrayList<Streaming> streaming;
}
