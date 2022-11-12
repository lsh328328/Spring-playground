package com.sopt31th.server.domain.music;

import com.sopt31th.server.domain.music.repository.MusicRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long>, MusicRepositoryCustom {
}
