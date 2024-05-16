package com.tickethub.backend.user.persist;

import com.tickethub.backend.book.persist.BookEntity;
import jakarta.persistence.*;
import lombok.*;

import java.awt.print.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Setter
    @Column(name = "encrypted_pwd", nullable = false, unique = true)
    private String encryptedPwd;

    @OneToMany(mappedBy = "userEntity")
    private List<BookEntity> books = new ArrayList<>();
}
