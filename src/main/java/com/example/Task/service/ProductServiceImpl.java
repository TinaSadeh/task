package com.example.Task.service;

import com.example.Task.domain.Comment;
import com.example.Task.domain.CommentStatus;
import com.example.Task.domain.Product;
import com.example.Task.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public String productDescription(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent())
            return product.get().getDescription();
        return null;
    }

    @Override
    public int getCommentsCounts(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) {
            List<Comment> comments = product.get().getComments();
            int counter = 0;
            for (Comment comment : comments) {
                if (comment.getStatus().equals(CommentStatus.PUBLISHED))
                    counter++;
            }
            return counter;
        }
        return 0;
    }

    @Override
    public int getVotesCounts(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent())
            return product.get().getVotes().size();
        return 0;
    }

    @Override
    public Double getVotesAverage(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent())
            return product.get().getAvgVotes();
        return 0d;
    }

    @Override
    public List<Comment> commentContext(Long productId) {
        Optional<Product> product = repository.findById(productId);
        if(product.isPresent())
            return product.get().getComments();
        return null;
    }


}
