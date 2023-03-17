package com.anime.AnimeAppApi.jikan.model.seasonNow;

import lombok.Data;

@Data
public class Trailer {
    public String youtube_id;
    public String url;
    public String embed_url;
    public Images images;
}
