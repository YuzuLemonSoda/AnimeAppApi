package com.anime.AnimeAppApi.entity;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;


@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
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

    @Type(type = "string-array")
    @Column(name = "alternativetitles", columnDefinition = "text[]")
    private String[] alternativeTitles;

    @Column(name = "ranking")
    private Long ranking;

    @Type(type = "string-array")
    @Column(name = "genres", columnDefinition = "text[]")
    private String[] genres;

    @Column(name = "episodes")
    private int episodes;

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

    @Column(name = "synopsis", columnDefinition = "text")
    private String synopsis;

    @Column(name = "thumb")
    private String thumb;

    @Column(name = "type")
    private String type;

}
