package com.example.Task.controller;

import com.example.Task.domain.Comment;
import com.example.Task.service.ProductService;
import com.example.Task.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }


    @GetMapping("showcomment/{id}")
    public List<Comment> showComment(@PathVariable Long id) {

        return productService.commentContext(id);
    }

    @GetMapping("vote/{id}")
    public Map<String, Object> getVotesCounts(@PathVariable Long id) {
        int commentsCounts = productService.getVotesCounts(id);
        Double votesAverage = productService.getVotesAverage(id);

        HashMap<String, Object> map = new HashMap<>();

        map.put("count", commentsCounts);
        map.put("avg", votesAverage);
        return map;
    }

    @GetMapping("comment/{id}")
    public Map<String, Integer> getCommentsCounts(@PathVariable Long id) {
        int commentsCounts = productService.getCommentsCounts(id);
        HashMap<String, Integer> stringStringHashMap = new HashMap<>();

        stringStringHashMap.put("count", commentsCounts);
        return stringStringHashMap;
    }


    @GetMapping("/{id}")
    public Map<String, String> getProductDescription(@PathVariable Long id) {
        String s = productService.productDescription(id);

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        stringStringHashMap.put("description", s);
        return stringStringHashMap;

    }


}