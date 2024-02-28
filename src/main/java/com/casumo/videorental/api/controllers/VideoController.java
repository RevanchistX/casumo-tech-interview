package com.casumo.videorental.api.controllers;

import com.casumo.videorental.api.dto.Video;
import com.casumo.videorental.api.services.VideoService;
//import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/videos")
//@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VideoController {
    private VideoService videoService;

    @GetMapping("/{id}")
    public Video getById(@PathVariable() Long id) {
        return this.videoService.getById(id);
    }
}
