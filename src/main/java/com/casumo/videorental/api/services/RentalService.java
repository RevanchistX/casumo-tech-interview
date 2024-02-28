package com.casumo.videorental.api.services;

import com.casumo.videorental.api.dto.Video;
import com.casumo.videorental.api.dto.VideoRental;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final int REGULAR_PRICE = 30;
    private final int PREMIUM_PRICE = 40;

    public VideoRental calculateDaysPerVideoType(Video video, Long days) {
        Long rentalCost = switch (video.getType()) {
            case REGULAR -> REGULAR_PRICE + Math.max((days - 3) * REGULAR_PRICE, 0);
            case NEW -> days * PREMIUM_PRICE;
            case OLD -> REGULAR_PRICE + Math.max((days - 5) * REGULAR_PRICE, 0);
            default -> (long) REGULAR_PRICE;
        };
        return new VideoRental(video, rentalCost);
    }
}
