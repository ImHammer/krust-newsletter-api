package com.krust.newsletter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krust.newsletter.models.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>
{
}