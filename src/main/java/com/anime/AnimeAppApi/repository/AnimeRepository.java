package com.anime.AnimeAppApi.repository;

import com.anime.AnimeAppApi.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
