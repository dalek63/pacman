package com.pacman.pacman;

import Classes.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Game game() {
        return new Game();
    }
}
