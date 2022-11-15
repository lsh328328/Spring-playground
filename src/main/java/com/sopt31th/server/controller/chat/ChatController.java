package com.sopt31th.server.controller.chat;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.SuccessCode;
import com.sopt31th.server.controller.chat.dto.response.ChatResponse;
import com.sopt31th.server.service.chat.ChatService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final ChatService chatService;

    @ApiOperation("채팅리스트 조회 페이지 - 채팅리스트를 요청합니다.")
    @GetMapping("chat/list")
    public ApiResponse<List<ChatResponse>> getChectList() {
        return ApiResponse.success(SuccessCode.GET_CHATLIST_SUCCESS, chatService.getList());
    }
}
