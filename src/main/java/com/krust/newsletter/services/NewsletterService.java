package com.krust.newsletter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.krust.newsletter.dtos.NewsletterDTO;
import com.krust.newsletter.models.Newsletter;
import com.krust.newsletter.repositories.NewsletterRepository;

@Service
public class NewsletterService
{
    private final NewsletterRepository newsletterRepository;

    public NewsletterService(NewsletterRepository newsletterRepository)
    {
        super();
        this.newsletterRepository = newsletterRepository;
    }

    public List<Newsletter> getAll()
    {
        return this.newsletterRepository.findAll();
    }

    public Newsletter get(int newsletterId)
    {
        Optional<Newsletter> findNewsletter = this.newsletterRepository.findById(newsletterId);
        if (findNewsletter.isPresent()) {
            return  findNewsletter.get();
        }
        return null;
    }

    public Newsletter createNewsletter(NewsletterDTO dto)
    {
        Newsletter newsletter = new Newsletter();
        BeanUtils.copyProperties(dto, newsletter);

        this.newsletterRepository.save(newsletter);

        if (newsletter.getId() == null) {
            return null;
        }
        return newsletter;
    }

    public Newsletter deleteNewsletter(int newsletterId)
    {
        Optional<Newsletter> findNewsletter = this.newsletterRepository.findById(newsletterId);
        if (!findNewsletter.isPresent()) {
            return null;
        }

        this.newsletterRepository.delete(findNewsletter.get());
        
        return findNewsletter.get();
    }

    public Newsletter updateNewsLetter(int newsletterId, NewsletterDTO dto)
    {
        Optional<Newsletter> findNewsLetter = this.newsletterRepository.findById(newsletterId);
        if (!findNewsLetter.isPresent()) {
            return null;
        }

        Newsletter newsletter = findNewsLetter.get();
        BeanUtils.copyProperties(dto, newsletter);

        newsletter = this.newsletterRepository.saveAndFlush(newsletter);

        return newsletter;
    }
}
