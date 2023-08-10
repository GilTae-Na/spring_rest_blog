package com.example.springdeveloper.service;

import com.example.springdeveloper.AddArticleRequest;
import com.example.springdeveloper.domain.Article;
import com.example.springdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }
}
