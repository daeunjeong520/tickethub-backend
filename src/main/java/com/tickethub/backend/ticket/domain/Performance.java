package com.tickethub.backend.ticket.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "performance")
public class Performance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performance_id")
    private Long performanceId;

    private String name;             // 공연이름

    @Column(name = "viewing_hours")
    private Integer viewingHours;    // 관람시간

    private LocalDate date;          // 공연 날짜

    private String cast;             // 출연진

    private String location;         // 장소

    @Column(name = "poster_path")
    private String posterPath;       // 이미지 경로

    @OneToMany(mappedBy = "performance")
    private List<Seat> seats = new ArrayList<>();
}
