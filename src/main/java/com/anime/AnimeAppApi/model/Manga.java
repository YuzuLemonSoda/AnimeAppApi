package com.anime.AnimeAppApi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Manga")
@Data
public class Manga {

    @Id
    private Long _id;

    private String aired_on;

    private String myanimelist_url;

    private String title;

    private Long rank;

    private String picture_url;

    private Double score;

    private Long members;

    private String type;
}
