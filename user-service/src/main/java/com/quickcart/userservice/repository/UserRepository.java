package com.quickcart.userservice.repository;
import com.quickcart.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

}
