package com.sopt31th.server.controller.music;

import com.sopt31th.server.common.dto.ApiResponse;
import com.sopt31th.server.common.exception.SuccessCode;
import com.sopt31th.server.controller.music.dto.request.MusicRequest;
import com.sopt31th.server.controller.music.dto.response.MusicResponse;
import com.sopt31th.server.service.music.MusicService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MusicController {

    private final MusicService musicService;

    @ApiOperation("음악리스트 조회 페이지 - 음악리스트를 요청합니다.")
    @GetMapping("music/list")
    public ApiResponse<List<MusicResponse>> getMusicList() {
        return ApiResponse.success(SuccessCode.GET_MUSICLIST_SUCCESS, musicService.getList());
    }

    @ApiOperation("음악 생성 페이지 - 새로운 음악을 생성합니다.")
    @PostMapping(value = "music", consumes = "multipart/form-data")
    public ApiResponse<MusicResponse> registerMusic(@RequestPart @Valid MusicRequest request, @RequestPart MultipartFile image) {
        return ApiResponse.success(SuccessCode.REGISTER_MUSIC_SUCCESS, musicService.register(image, request));
    }
}
