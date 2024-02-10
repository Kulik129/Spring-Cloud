package com.example.api;

import com.example.model.Issue;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/api/issue")
public class IssuerController {
    private List<Issue> issues;

    @GetMapping
    public List<Issue> getAll() {
        return issues;
    }


    //    @PostConstruct
    public IssuerController(BookProvider provider) {
        issues = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            Date between = faker.date().between(startOfYear(), endOfYear());
            issue.setIssueAt(between.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            issue.setBookId(provider.getRandomBookId());
            issue.setReaderId(UUID.randomUUID());

            issues.add(issue);
        }
        this.issues = List.copyOf(issues);
    }

    private Date startOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, 1);
        instance.set(Calendar.DAY_OF_MONTH, 5);

        return instance.getTime();
    }

    private Date endOfYear() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2024);
        instance.set(Calendar.MONTH, 2);
        instance.set(Calendar.DAY_OF_MONTH, 15);

        return instance.getTime();
    }
}
