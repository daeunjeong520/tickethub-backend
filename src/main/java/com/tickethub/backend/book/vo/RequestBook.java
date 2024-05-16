package com.tickethub.backend.book.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBook {

    private Long seatId;
    private Integer seatNum;
}
