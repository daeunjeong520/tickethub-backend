package com.tickethub.backend.book.persist;

import com.tickethub.backend.performance.persist.SeatEntity;
import com.tickethub.backend.user.persist.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class BookEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity; // 회원

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity; // 좌석

    @Column(name = "book_seat_num")
    private Integer bookSeatNum; // 예매한 좌석 수

    @Column(name = "book_price")
    private Integer bookPrice; // 결제 가격
}
