package com.krust.newsletter.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.krust.newsletter.dtos.NewsletterDTO;
import com.krust.newsletter.models.Newsletter;
import com.krust.newsletter.services.NewsletterService;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController
{
    private final NewsletterService newsletterService;
    
    public NewsletterController(NewsletterService newsletterService)
    {
        super();
        this.newsletterService = newsletterService;
    }

    @GetMapping
    public ResponseEntity<List<Newsletter>> readAll()
    {
        return ResponseEntity.ok().body(this.newsletterService.getAll());
    }

    @GetMapping(path = "/{newsletter_id}")
    public ResponseEntity<Newsletter> readNewsletter(@PathVariable("newsletter_id") String newsletterIdStr)
    {
        int newsletterId = Integer.parseInt(newsletterIdStr);

        Newsletter newsletter = this.newsletterService.get(newsletterId);
        if (newsletter == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok().body(newsletter);
    }

    @PostMapping
    public ResponseEntity<Newsletter> createNewsLetter(@RequestBody NewsletterDTO dto)
    {
        Newsletter createdNews = this.newsletterService.createNewsletter(dto);

        if (createdNews == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @DeleteMapping("/{newsletter_id}")
    public ResponseEntity<Newsletter> deleteNewsLetter(@PathVariable("newsletter_id") String newsletterIdStr)
    {
        int newsletterId = Integer.parseInt(newsletterIdStr);

        Newsletter newsletter = this.newsletterService.deleteNewsletter(newsletterId);
        if (newsletter == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok().body(newsletter);
    }

    @PutMapping("/{newsletter_id}")
    public ResponseEntity<Newsletter> updateNewsLetter(
        @PathVariable("newsletter_id") String newsletterIdStr,
        @RequestBody NewsletterDTO updateBody
    )
    {
        int newsletterId = Integer.parseInt(newsletterIdStr);

        Newsletter newsletter = this.newsletterService.updateNewsLetter(newsletterId, updateBody);
        if (newsletter == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(newsletter);
    }
}
