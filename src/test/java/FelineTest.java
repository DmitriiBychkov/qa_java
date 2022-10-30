import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    //    Проверка рациона кошачьих
    @Test
    public void felineEatMeatLikeAPredator() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Кошачьи едят как хищники", expected, actual);
    }

    //    Проверка семейства
    @Test
    public void felineGetFamilyReturnsFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Feline - семейство кошачьих", expectedFamily, actualFamily);
    }

    //    Проверка наличия потомства
    @Test
    public void felineGetKittensReturnsOne() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        Assert.assertEquals("У кошачьих должен быть один детёныш", 1, actualKittens);
    }
}
