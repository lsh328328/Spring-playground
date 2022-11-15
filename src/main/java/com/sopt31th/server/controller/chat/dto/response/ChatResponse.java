package com.sopt31th.server.controller.chat.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatResponse {
    private Long id;

    private String chatImage;

    private String name;

    private String content;

    private ChatResponse(final Long id, final String chatImage, final String name, final String content) {
        this.id = id;
        this.chatImage = chatImage;
        this.name = name;
        this.content = content;
    }

    public static ChatResponse of(final Long id, final String chatImage, final String name, final String content) {
        return new ChatResponse(id, chatImage, name, content);
    }
}
