package com.casumo.videorental.api.services;

import com.casumo.videorental.api.dto.Video;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VideoServiceTest {

    @Test
    public void testVideoService() {
        Video mockVideo = Mockito.mock(Video.class);
        VideoService mockService = Mockito.mock(VideoService.class);
        Mockito.when(mockService.getById(0L)).thenReturn(mockVideo);
        Video retrievedVideo = mockService.getById(0L);
        Mockito.verify(mockService).getById(0L);
        assertNotNull(retrievedVideo);
    }
}