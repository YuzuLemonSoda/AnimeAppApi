package com.anime.AnimeAppApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "animedb_api", schema = "anime_app")
@AllArgsConstructor
@NoArgsConstructor
public class Anime {

    @Id
    @Column(name = "_id")
    private String _id;

    @Column(name = "title")
    private String title;

    @Column(name = "alternativetitles", columnDefinition = "text[]")
    private String[] alternativeTitles;

    @Column(name = "ranking")
    private Long ranking;

    @Column(name = "genres", columnDefinition = "text[]")
    private String[] genres;

    @Column(name = "episodes")
    private Long episodes;

    @Column(name = "hasepisode")
    private Boolean hasEpisode;

    @Column(name = "hasranking")
    private Boolean hasRanking;

    @Column(name = "image")
    private String image;

    @Column(name = "link")
    private String link;

    @Column(name = "status")
    private String status;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "thumb")
    private String thumb;

    @Column(name = "type")
    private String type;

}
