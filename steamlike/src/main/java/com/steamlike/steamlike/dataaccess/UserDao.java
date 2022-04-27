package com.steamlike.steamlike.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.steamlike.steamlike.entity.concretes.Gamer;

@Repository
public interface UserDao extends JpaRepository<Gamer, Long> {

}
