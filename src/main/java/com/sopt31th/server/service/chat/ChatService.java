package com.sopt31th.server.service.chat;

import com.sopt31th.server.controller.chat.dto.response.ChatHeaderResponse;
import com.sopt31th.server.controller.chat.dto.response.ChatResponse;
import com.sopt31th.server.domain.chat.Chat;
import com.sopt31th.server.domain.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;
    @Value("${image.header}")
    String imageUrl;

    public ChatResponse getList() {
        return getChatResponseList(chatRepository.findAll());
    }

    @NotNull
    private ChatResponse getChatResponseList(final List<Chat> chatList) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        ChatHeaderResponse[] content = new ChatHeaderResponse[chatList.size()];
        for (int c = 0; c < content.length; c++) {
            Chat chat = chatList.get(c);
            content[c] = new ChatHeaderResponse(chat.getChatImage(), chat.getName(), chat.getContent(), chat.getUpdatedAt().format(format));
        }
        return new ChatResponse(imageUrl, content);
    }
}
