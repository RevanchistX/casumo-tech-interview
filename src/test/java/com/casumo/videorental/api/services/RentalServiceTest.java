package com.casumo.videorental.api.services;

import com.casumo.videorental.api.dto.Video;
import com.casumo.videorental.api.dto.VideoRental;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentalServiceTest {

    @Test
    public void testRentalService() {
        VideoRental mockVideoRental = Mockito.mock(VideoRental.class);
        Video mockVideo = Mockito.mock(Video.class);
        RentalService mockService = Mockito.mock(RentalService.class);
        Mockito.when(mockService.calculateDaysPerVideoType(mockVideo, 1L)).thenReturn(mockVideoRental);
        VideoRental calculatedRental = mockService.calculateDaysPerVideoType(mockVideo, 1L);
        assertEquals(mockVideoRental.getRentalCost(), calculatedRental.getRentalCost());
        Mockito.verify(mockVideo).getType();
    }

}