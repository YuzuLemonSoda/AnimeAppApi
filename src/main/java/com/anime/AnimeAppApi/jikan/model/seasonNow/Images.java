package com.anime.AnimeAppApi.jikan.model.seasonNow;

import lombok.Data;

@Data
public class Images {
    public Jpg jpg;
    public Webp webp;
    public String image_url;
    public String small_image_url;
    public String medium_image_url;
    public String large_image_url;
    public String maximum_image_url;
}
