package com.casumo.videorental.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class VideoRentalWrapper {

    private Long total;
    private String currency = "SEK";
    private List<VideoRental> rentals = new ArrayList<>();

}
