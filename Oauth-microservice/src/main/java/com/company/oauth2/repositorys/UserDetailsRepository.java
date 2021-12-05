package com.company.oauth2.repositorys;

import com.company.oauth2.dtos.User;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
