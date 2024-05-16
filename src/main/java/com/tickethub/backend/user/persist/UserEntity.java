package com.tickethub.backend.user.persist;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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
}
