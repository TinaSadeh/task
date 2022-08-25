package com.example.Task.service;

import com.example.Task.domain.Comment;

import java.util.List;

public interface ProductService {

    String productDescription(Long productId);

    int getCommentsCounts(Long productId);

    int getVotesCounts(Long productId);

    Double getVotesAverage(Long productId);

    List<Comment> commentContext(Long productId);


}
