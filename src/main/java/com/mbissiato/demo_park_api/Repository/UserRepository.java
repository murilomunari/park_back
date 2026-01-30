package com.mbissiato.demo_park_api.Repository;

import com.mbissiato.demo_park_api.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);

}
