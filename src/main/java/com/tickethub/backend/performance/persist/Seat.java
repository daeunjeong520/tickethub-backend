package com.tickethub.backend.performance.persist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seat")
public class Seat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @Column(name = "seat_type", nullable = false)
    private String seatType; // 좌석 타입 (R, S)

    @Column(name = "total_seat", nullable = false)
    private Integer totalSeat; // 좌석 총 개수

    @Column(nullable = false)
    private Integer price; // 좌석 가격

}
