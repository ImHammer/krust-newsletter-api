package com.krust.newsletter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krust.newsletter.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
}
