package com.sopt31th.server.service.music;

import com.sopt31th.server.controller.music.dto.request.MusicRequest;
import com.sopt31th.server.controller.music.dto.response.MusicResponse;
import com.sopt31th.server.domain.music.Music;
import com.sopt31th.server.domain.music.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {

    private final MusicRepository musicRepository;
    private final S3Service s3Service;

    public List<MusicResponse> getList() {
        return getMusicResponseList(musicRepository.findAll());
    }

    @NotNull
    private List<MusicResponse> getMusicResponseList(final List<Music> musicList) {
        return musicList.stream()
                .map(m -> MusicResponse.of(
                        m.getId(),
                        m.getImage(),
                        m.getTitle(),
                        m.getSinger()
                )).collect(Collectors.toList());
    }

    @Transactional
    public MusicResponse register(MultipartFile image, MusicRequest request) {
        String imageUrl = s3Service.upload(image);
        Music music = musicRepository.save(request.toEntity(imageUrl));
        return MusicResponse.of(music.getId(), music.getImage(), music.getTitle(), music.getSinger());
    }
}
