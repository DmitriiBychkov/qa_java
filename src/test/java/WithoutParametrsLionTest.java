import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WithoutParametrsLionTest {

    @Before
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    //    Проверка текста исключения пола
    @Test
    public void unknownSexLionExceptionTextTest() {
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion("Оно", feline));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}