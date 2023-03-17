package com.anime.AnimeAppApi.jikan.model.seasonNow;

import lombok.Data;

@Data
public class Pagination {
    public int last_visible_page;
    public boolean has_next_page;
    public int current_page;
    public Items items;
}
