package com.casumo.videorental.api.services;

import com.casumo.videorental.api.dto.Video;
import com.casumo.videorental.api.repositories.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    public Video getById(long id) {
        return this.videoRepository.findById(id).orElse(null);
    }

    public Video create(Video video) {
        if (video.getId() == null) return null;
        return this.videoRepository.save(video);
    }

    public List<Video> create(List<Video> videos) {
        List<Video> videoList = new ArrayList<>();
        videos.forEach(video -> videoList.add(create(video)));
        return videoList;
    }

    public List<Video> getAll() {
        return this.videoRepository.findAll();
    }
}
