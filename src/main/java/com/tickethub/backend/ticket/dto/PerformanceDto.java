package com.tickethub.backend.ticket.dto;

import com.tickethub.backend.ticket.domain.Performance;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceDto {

    private Long performanceId;
    private String name;             // 공연이름
    private Integer viewingHours;    // 관람시간
    private LocalDate date;          // 공연 날짜
    private String cast;             // 출연진
    private String location;         // 장소
    private String posterPath;       // 이미지 경로
    private List<SeatDto> seats;     // 좌석 정보

    public static PerformanceDto from(Performance performance) {
        return PerformanceDto.builder()
                .performanceId(performance.getPerformanceId())
                .name(performance.getName())
                .viewingHours(performance.getViewingHours())
                .date(performance.getDate())
                .cast(performance.getCast())
                .location(performance.getLocation())
                .posterPath(performance.getPosterPath())
                .seats(performance.getSeats()
                        .stream()
                        .map(SeatDto::from)
                        .collect(Collectors.toList()))
                .build();
    }
}
