package com.sopt31th.server.controller.chat.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ChatResponse {

    private String imageUrl;
    private ChatHeaderResponse[] chatInfo;

    public ChatResponse(final String imageUrl, final ChatHeaderResponse[] chatInfo) {
        this.imageUrl = imageUrl;
        this.chatInfo = chatInfo;
    }

    public static ChatResponse of(final String imageUrl, final ChatHeaderResponse[] chatInfo) {
        return new ChatResponse(imageUrl, chatInfo);
    }
}
