package com.tickethub.backend.book.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBook {

    private Long seatId; // 좌석 아이디
    private Integer seatNum; // 좌석 개수
}