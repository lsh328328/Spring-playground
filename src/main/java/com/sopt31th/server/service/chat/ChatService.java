package com.sopt31th.server.service.chat;

import com.sopt31th.server.controller.chat.dto.response.ChatResponse;
import com.sopt31th.server.domain.chat.Chat;
import com.sopt31th.server.domain.chat.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public List<ChatResponse> getList() {
        return getChatResponseList(chatRepository.findAll());
    }

    @NotNull
    private List<ChatResponse> getChatResponseList(final List<Chat> chatList) {
        return chatList.stream()
                .map(c -> ChatResponse.of(
                        c.getId(),
                        c.getChatImage(),
                        c.getName(),
                        c.getContent()
                )).collect(Collectors.toList());
    }
}
