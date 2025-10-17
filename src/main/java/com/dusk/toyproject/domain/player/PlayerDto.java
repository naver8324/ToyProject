package com.dusk.toyproject.domain.player;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerDto {
    private String nickname;
    private int score;

    public static PlayerDto of(String nickname, int score) {
        return new PlayerDto(nickname, score);
    }
}
