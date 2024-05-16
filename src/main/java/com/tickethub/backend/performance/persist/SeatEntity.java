package com.tickethub.backend.performance.persist;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seat")
public class SeatEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private PerformanceEntity performance;

    @Column(name = "seat_type", nullable = false)
    private String seatType; // 좌석 타입 (R, S)

    @Column(name = "total_seat", nullable = false)
    private Integer totalSeat; // 좌석 총 개수

    @Column(nullable = false)
    private Integer price; // 좌석 가격

    @Column(nullable = false)
    private Integer seatLimit; // 좌석 수 제한 개수

    // 좌석 예매 (좌석 수 차감)
    public void decreaseSeat(int seatNum) {
        // 제한된 좌석수를 넘게 예매하려고 하면 예외
        if(seatNum > seatLimit) {
            throw new IllegalArgumentException("Exceeded the limited number of seats");
        }
        // 잔여 좌석이 없으면 예외
        if(totalSeat - seatNum < 0) {
            throw new IllegalArgumentException("There are not enough seats");
        }
        totalSeat -= seatNum;
    }
}