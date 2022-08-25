package com.example.Task;

import com.example.Task.domain.Comment;
import com.example.Task.domain.CommentStatus;
import com.example.Task.domain.Product;
import com.example.Task.domain.Vote;
import com.example.Task.repository.CommentRepository;
import com.example.Task.repository.ProductRepository;
import com.example.Task.repository.VoteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaRepositories
@Component
public class DemApplication {

    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    private final VoteRepository voteRepository;


    public DemApplication(ProductRepository productRepository, CommentRepository commentRepository, VoteRepository voteRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
        this.voteRepository = voteRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(DemApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void initial() {
        Product product = new Product();
        product.setAbleToVoteForAll(true);
        product.setAvgVotes(3.5d);
        product.setDescription("The product");


        Comment comment = new Comment();
        comment.setContent("Hmmm");
        comment.setStatus(CommentStatus.IN_PROGRESS);

        Comment comment1 = new Comment();
        comment1.setContent("Bad Product");
        comment1.setStatus(CommentStatus.REJECTED);

        Comment comment2 = new Comment();
        comment2.setContent("Nice Product");
        comment2.setStatus(CommentStatus.PUBLISHED);

        ArrayList<Comment> comments = new ArrayList<>();

        comments.add(comment);
        comments.add(comment1);
        comments.add(comment2);


        Vote vote = new Vote();
        vote.setPoint(3);

        Vote vote1 = new Vote();
        vote.setPoint(4);

        ArrayList<Vote> votes = new ArrayList<>();

        votes.add(vote);
        votes.add(vote1);


        product.setVotes(votes);
        product.setComments(comments);

        commentRepository.saveAll(comments);
        voteRepository.saveAll(votes);
        productRepository.save(product);


    }

}
