package com.santander.dio.projeto.bootcamp.DIO.serviceTests;

import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import com.santander.dio.projeto.bootcamp.DIO.repositories.FeatureRepositorie;
import com.santander.dio.projeto.bootcamp.DIO.services.FeatureService;
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
public class FeatureServiceTest {

    @Mock
    private FeatureRepositorie featureRepositorie;

    @InjectMocks
    private FeatureService featureService;

    private Feature feature;
    private Feature updatedFeature;

    @BeforeEach
    public void setUp() {
        feature = new Feature(1L, "icon1", "description1");
        updatedFeature = new Feature(1L, "icon2", "description2");
    }

    @Test
    public void testSave() {
        when(featureRepositorie.save(feature)).thenReturn(feature);

        Feature savedFeature = featureService.save(feature);

        assertEquals(feature, savedFeature);
        verify(featureRepositorie, times(1)).save(feature);
    }

    @Test
    public void testFindAll() {
        List<Feature> features = Arrays.asList(feature);
        when(featureRepositorie.findAll()).thenReturn(features);

        List<Feature> result = featureService.findAll();

        assertEquals(features, result);
        verify(featureRepositorie, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(featureRepositorie.findById(1L)).thenReturn(Optional.of(feature));

        Optional<Feature> result = featureService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(feature, result.get());
        verify(featureRepositorie, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        when(featureRepositorie.findById(1L)).thenReturn(Optional.of(feature));
        when(featureRepositorie.save(any(Feature.class))).thenReturn(updatedFeature);

        Feature result = featureService.update(updatedFeature, 1L);

        assertEquals(updatedFeature.getIcon(), result.getIcon());
        assertEquals(updatedFeature.getDescription(), result.getDescription());
        verify(featureRepositorie, times(1)).findById(1L);
        verify(featureRepositorie, times(1)).save(feature);
    }

    @Test
    public void testUpdateNotFound() {
        when(featureRepositorie.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            featureService.update(updatedFeature, 1L);
        });

        assertEquals("Feature: 1 não encontrada!", exception.getMessage());
        verify(featureRepositorie, times(1)).findById(1L);
        verify(featureRepositorie, times(0)).save(any(Feature.class));
    }

    @Test
    public void testDelete() {
        doNothing().when(featureRepositorie).deleteById(1L);

        featureService.delete(1L);

        verify(featureRepositorie, times(1)).deleteById(1L);
    }
}