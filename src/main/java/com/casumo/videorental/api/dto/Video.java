package com.casumo.videorental.api.dto;

import com.casumo.videorental.api.dto.enums.ReleaseType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private ReleaseType type;


}
