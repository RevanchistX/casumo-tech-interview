package com.casumo.videorental.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class VideoRental {

    final Video video;
    final Long rentalCost;
    String currency = "SEK";

}
