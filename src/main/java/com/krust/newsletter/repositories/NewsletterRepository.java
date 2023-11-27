package com.krust.newsletter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krust.newsletter.models.Newsletter;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Integer>
{
}
