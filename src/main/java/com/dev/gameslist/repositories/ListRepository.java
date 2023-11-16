package com.dev.gameslist.repositories;

import com.dev.gameslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<GameList, Long> {
}
