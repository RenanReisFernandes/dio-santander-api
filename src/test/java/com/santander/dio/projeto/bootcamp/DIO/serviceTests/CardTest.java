package com.santander.dio.projeto.bootcamp.DIO.serviceTests;

import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardConstructorAndGetters() {
        Card card = new Card(1L, "1234567890123456", 5000.0);

        assertEquals(1L, card.getId());
        assertEquals("1234567890123456", card.getNumber());
        assertEquals(5000.0, card.getLimit());
    }

    @Test
    public void testCardSetters() {
        Card card = new Card();
        card.setId(1L);
        card.setNumber("1234567890123456");
        card.setLimit(5000.0);

        assertEquals(1L, card.getId());
        assertEquals("1234567890123456", card.getNumber());
        assertEquals(5000.0, card.getLimit());
    }

    @Test
    public void testCardEqualsAndHashCode() {
        Card card1 = new Card(1L, "1234567890123456", 5000.0);
        Card card2 = new Card(1L, "1234567890123456", 5000.0);
        Card card3 = new Card(2L, "6543210987654321", 3000.0);

        assertEquals(card1, card2);
        assertNotEquals(card1, card3);

        assertEquals(card1.hashCode(), card2.hashCode());
        assertNotEquals(card1.hashCode(), card3.hashCode());
    }

    @Test
    public void testCardToString() {
        Card card = new Card(1L, "1234567890123456", 5000.0);
        String expected = "Card(id=1, number=1234567890123456, limit=5000.0)";

        assertEquals(expected, card.toString());
    }
}