package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import com.santander.dio.projeto.bootcamp.DIO.repositories.NewsRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewService {

    @Autowired
    private NewsRepositorie newsRepositorie;

    public News save(News news){
        return newsRepositorie.save(news);
    }

    public List<News> findAll(){
        List<News> newList = newsRepositorie.findAll();
        return newList;
    }

    public Optional<News> findById(Long id){
        return newsRepositorie.findById(id);
    }

    public News update(News newsUpdated, Long id){
        Optional<News> optNews = newsRepositorie.findById(id);
        if(optNews.isPresent()){
            News existentNews = optNews.get();

            existentNews.setIcon(newsUpdated.getIcon());
            existentNews.setDescription(newsUpdated.getDescription());

         return   newsRepositorie.save(existentNews);

        }else{
            throw new RuntimeException("Dados não encontrados para: "+ id);
        }
    }

    public void delete(Long id){
        newsRepositorie.deleteById(id);
    }


}
