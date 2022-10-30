import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline feline;

    //    Проверка голоса кота
    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        Assert.assertEquals("Кот говорит мяу", expectedSound, actualSound);
    }

    //    Проверка рациона кота
    @Test
    public void catGetFoodLikePredator() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Кот ест как Хищник", expectedFood, actualFood);
    }
}
