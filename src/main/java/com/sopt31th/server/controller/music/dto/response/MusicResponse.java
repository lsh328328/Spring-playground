package com.sopt31th.server.controller.music.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MusicResponse {
    private Long id;

    private String image;

    private String title;

    private String singer;

    private MusicResponse(final Long id, final String image, final String title, final String singer) {
        this.id = id;
        this.image =image;
        this.title = title;
        this.singer = singer;
    }

    public static MusicResponse of(final Long id, final String image, final String title, final String singer) {
        return new MusicResponse(id, image, title, singer);
    }
}
