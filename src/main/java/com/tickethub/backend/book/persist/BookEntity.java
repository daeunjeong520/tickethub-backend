package com.tickethub.backend.book.persist;

import com.tickethub.backend.performance.persist.SeatEntity;
import com.tickethub.backend.user.persist.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity; // 회원

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity; // 좌석
}
