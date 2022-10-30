import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final int expectedKittens;
    private final boolean expectedMane;

    public LionTest(String sex, int expectedKittens, boolean expectedMane) {
        this.sex = sex;
        this.expectedKittens = expectedKittens;
        this.expectedMane = expectedMane;
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Feline feline;

    @Parameterized.Parameters
    public static Object[][] getOffspring() {
        return new Object[][]{
                {"Самка", 1, false},
                {"Самец", 1, true},
        };
    }

    //    Проверка наличия потомства
    @Test
    public void lionGetKittensReturnsOne() throws Exception {
        Lion lion = new Lion(sex, feline);
        int actualKittens = lion.getKittens();
        Assert.assertEquals("У львов должен быть один львёнок", expectedKittens, actualKittens);
    }

    //    Проверка наличия гривы
    @Test
    public void maleSexLionDoesHaveManeReturnsTrue() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualMane = lion.doesHaveMane();
        Assert.assertEquals("У самца должна быть грива", expectedMane, actualMane);
    }

    //    Проверка рациона льва
    @Test
    public void lionEatsLikeAPredator() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> expectedKind = List.of("Животные", "Птицы", "Рыба");
        List<String> actualKind = lion.getFood();
        Assert.assertEquals("Лев ест как хищник", expectedKind, actualKind);
    }

    //    Проверка текста исключения пола
    @Test
    public void unknownSexLionExceptionTextTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Оно", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    //    Проверка на удаление вывода исключения в else для пола
//    @Test(expected = Exception.class)
//    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {
//        new Lion("Оно", feline);
//    }
}