package com.sopt31th.server.controller.music.dto.request;

import com.sopt31th.server.domain.music.Music;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MusicRequest {
    @NotBlank
    private String singer;

    @NotBlank
    private String title;

    public Music toEntity(String imageUrl) {
        return Music.builder()
                .image(imageUrl)
                .singer(singer)
                .title(title)
                .build();
    }
}
