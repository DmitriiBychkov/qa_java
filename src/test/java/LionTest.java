package com.example;

import org.junit.Assert;
import org.junit.Test;

public class LionTest {
    @Test
    public void getKittensReturnsValidValue() {
//        Arrange - подготовка тестовых данных
        Lion lion = new Lion();
        int expectedKittens = 4;
//        Act - вызов метода, который тестируем
        int actualKittens = lion.getKittens();
//        Assert - сравнение ОР и ФР
        Assert.assertEquals("Kittens is incorrect", expectedKittens, actualKittens);
    }
}
