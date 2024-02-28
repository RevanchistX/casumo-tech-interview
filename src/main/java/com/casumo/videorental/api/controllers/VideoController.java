package com.casumo.videorental.api.controllers;


import com.casumo.videorental.api.dto.Video;
import com.casumo.videorental.api.dto.VideoRental;
import com.casumo.videorental.api.dto.VideoRentalWrapper;
import com.casumo.videorental.api.services.RentalService;
import com.casumo.videorental.api.services.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/.rest/api/v1/videos")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class VideoController {
    private final VideoService videoService;
    private final RentalService rentalService;

    @GetMapping()
    public List<Video> getAll() {
        return this.videoService.getAll();
    }

    @GetMapping("/{id}")
    public Video getById(@PathVariable() Long id) {
        return this.videoService.getById(id);
    }

    @GetMapping("/rental/{id}/{days}")
    public VideoRental rentalByDays(@PathVariable() Long id, @PathVariable() Long days) {
        return rentalService.calculateDaysPerVideoType(this.videoService.getById(id), days);
    }

    @PostMapping("/rental")
    public VideoRentalWrapper rentalByVideoByDay(@RequestBody List<Map<String, Integer>> data) {
        VideoRentalWrapper videoRentals = new VideoRentalWrapper();
        data.forEach(hMap -> {
            long id = (long) hMap.get("id");
            long day = (long) hMap.get("days");
            Video video = this.videoService.getById(id);
            if (video != null) {
                videoRentals.getRentals().add(rentalService.calculateDaysPerVideoType(video, day));
            }
        });

        Long total = videoRentals.getRentals().stream().map(VideoRental::getRentalCost).reduce(0L, Long::sum);
        videoRentals.setTotal(total);
        return videoRentals;
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Video create(@RequestBody Video video) {
        return this.videoService.create(video);
    }

    @PostMapping("/multiple")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Video> create(@RequestBody List<Video> videos) {
        return this.videoService.create(videos);
    }

}
