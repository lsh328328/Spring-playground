package com.sopt31th.server.controller.chat.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatHeaderResponse {
    private String chatImage;

    private String name;

    private String content;

    private String updatedAt;

    public ChatHeaderResponse(String chatImage, String name, String content, String updatedAt) {
        this.chatImage = chatImage;
        this.name = name;
        this.content = content;
        this.updatedAt = updatedAt;
    }
}
