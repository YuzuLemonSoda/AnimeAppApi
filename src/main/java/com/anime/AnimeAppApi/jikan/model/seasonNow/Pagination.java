package com.anime.AnimeAppApi.jikan.model.seasonNow;

import lombok.Data;

@Data
public class Pagination {
    public long last_visible_page;
    public boolean has_next_page;
    public long current_page;
    public Items items;
}
