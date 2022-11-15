package com.sopt31th.server.controller.music;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.SuccessCode;
import com.sopt31th.server.controller.music.dto.response.MusicResponse;
import com.sopt31th.server.service.music.MusicService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MusicController {

    private final MusicService musicService;

    @ApiOperation("음악리스트 조회 페이지 - 음악리스트를 요청합니다.")
    @GetMapping("music/list")
    public ApiResponse<List<MusicResponse>> getMusicList() {
        return ApiResponse.success(SuccessCode.GET_MUSICLIST_SUCCESS, musicService.getList());
    }
}
