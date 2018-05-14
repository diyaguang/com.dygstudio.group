package com.dygstudio.group.microserviceprovideruser.repository;

import com.dygstudio.group.microserviceprovideruser.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
}
