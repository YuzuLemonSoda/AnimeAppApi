package com.anime.AnimeAppApi.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Anime")
@Data
public class Anime {

    @Id
    private String _id;

    private String title;

    private String[] alternativeTitles;

    private Long ranking;

    private String[] genres;

    private int episodes;

    private Boolean hasEpisode;

    private Boolean hasRanking;

    private String image;

    private String link;

    private String status;

    private String synopsis;

    private String thumb;

    private String type;

}
