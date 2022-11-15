package com.sopt31th.server.service.music;

import com.sopt31th.server.controller.music.dto.response.MusicResponse;
import com.sopt31th.server.domain.music.Music;
import com.sopt31th.server.domain.music.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicRepository musicRepository;

    public List<MusicResponse> getList() {
        return getMusicResponseList(musicRepository.findAll());
    }

    @NotNull
    private List<MusicResponse> getMusicResponseList(final List<Music> musicList) {
        return musicList.stream()
                .map(m -> MusicResponse.of(
                        m.getId(),
                        m.getTitle(),
                        m.getSinger(),
                        m.getImage()
                )).collect(Collectors.toList());
    }
}
