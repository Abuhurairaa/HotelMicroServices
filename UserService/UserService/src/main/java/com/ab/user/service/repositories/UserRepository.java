package com.ab.user.service.repositories;

import com.ab.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    //to implement any custom method or query
}
