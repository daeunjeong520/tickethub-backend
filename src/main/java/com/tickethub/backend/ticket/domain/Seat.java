package com.tickethub.backend.ticket.domain;

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

    @Id @GeneratedValue
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @Column(name = "seat_type")
    private String seatType; // 좌석 타입 (R, S)

    @Column(name = "total_seat")
    private Integer totalSeat; // 좌석 총 개수

    private Integer price; // 좌석 가격

}
