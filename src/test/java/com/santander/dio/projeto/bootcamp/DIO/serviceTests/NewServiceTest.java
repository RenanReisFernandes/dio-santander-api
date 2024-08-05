package com.santander.dio.projeto.bootcamp.DIO.serviceTests;

import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import com.santander.dio.projeto.bootcamp.DIO.repositories.NewsRepositorie;
import com.santander.dio.projeto.bootcamp.DIO.services.NewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewServiceTest {

    @Mock
    private NewsRepositorie newsRepositorie;

    @InjectMocks
    private NewService newService;

    private News news;
    private News updatedNews;

    @BeforeEach
    public void setUp() {
        news = new News(1L, "icon1", "description1");
        updatedNews = new News(1L, "icon2", "description2");
    }

    @Test
    public void testSave() {
        when(newsRepositorie.save(news)).thenReturn(news);

        News savedNews = newService.save(news);

        assertEquals(news, savedNews);
        verify(newsRepositorie, times(1)).save(news);
    }

    @Test
    public void testFindAll() {
        List<News> newsList = Arrays.asList(news);
        when(newsRepositorie.findAll()).thenReturn(newsList);

        List<News> result = newService.findAll();

        assertEquals(newsList, result);
        verify(newsRepositorie, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(newsRepositorie.findById(1L)).thenReturn(Optional.of(news));

        Optional<News> result = newService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(news, result.get());
        verify(newsRepositorie, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        when(newsRepositorie.findById(1L)).thenReturn(Optional.of(news));
        when(newsRepositorie.save(any(News.class))).thenReturn(updatedNews);

        News result = newService.update(updatedNews, 1L);

        assertEquals(updatedNews.getIcon(), result.getIcon());
        assertEquals(updatedNews.getDescription(), result.getDescription());
        verify(newsRepositorie, times(1)).findById(1L);
        verify(newsRepositorie, times(1)).save(news);
    }

    @Test
    public void testUpdateNotFound() {
        when(newsRepositorie.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            newService.update(updatedNews, 1L);
        });

        assertEquals("Dados não encontrados para: 1", exception.getMessage());
        verify(newsRepositorie, times(1)).findById(1L);
        verify(newsRepositorie, times(0)).save(any(News.class));
    }

    @Test
    public void testDelete() {
        doNothing().when(newsRepositorie).deleteById(1L);

        newService.delete(1L);

        verify(newsRepositorie, times(1)).deleteById(1L);
    }
}