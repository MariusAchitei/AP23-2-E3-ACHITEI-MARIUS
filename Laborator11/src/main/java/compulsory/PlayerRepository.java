package com.lab11.demo;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PlayerRepository extends JpaRepository<Player,Long> {
}
