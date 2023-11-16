package github.boniGarcia.junit4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class JUnit4ParameterizedWithConstructorTest {
    WebDriver driver;
    private String username;
    private String password;
    private boolean success;
    @Before
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @After
    public void teardown(){driver.quit();}

    public JUnit4ParameterizedWithConstructorTest(String username, String password, boolean success) {
        this.username = username;
        this.password = password;
        this.success = success;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"user1", "pass1", true},
                {"user2", "pass2", false}
        });
    }

    @Test
    public void testLogin() {
        // ...
    }
    /*
    değişkenleri private olarak tanımladım çünkü constructor üzerinden parametre geçişini göstermek istedim
    ve bu durumda değişkenlere dışarıdan erişim gerekmiyor.

    ama ParameterizedJUnit4Test classinda ise
    sınıf değişkenlerine doğrudan annotasyonlarla enjekte etme yontemi kullanilmis,
    bu durumda ise
    Bu yöntemde, değişkenlerin public olması genellikle gereklidir,
çünkü test runner'ı bu değişkenlere doğrudan erişip değer ataması yapar.

     */
    /*
 önceki cevaplarımda verdiğim örnek ile sizin sunduğunuz örnekte bir fark var.
 Sizin örneğinizde, sınıf değişkenleri @Parameter annotasyonu ile işaretlenmiş
 ve bu değişkenlerin her birine bir index atanmış. JUnit test runner'ı
 @Parameters tarafından sağlanan veri koleksiyonundaki her bir nesne dizisini alır
 ve bu dizilerdeki her bir değeri sırasıyla @Parameter(0), @Parameter(1) vb. ile işaretlenmiş değişkenlere atar.

Bu, JUnit 4'teki parameterized testlerin alternatif bir yazım şeklidir.
Yapısal olarak aynı işlevi görür: testlerinizi farklı parametrelerle çalıştırmak için bir yol sağlar.
Ancak bu yöntem, test verilerinizi direkt olarak sınıfın alanlarına enjekte etmenizi sağlar
ve constructor üzerinden parametre geçişi yapmaz. Bu, bazı durumlarda daha temiz ve okunabilir kod sağlayabilir.
Her iki yöntem de JUnit 4 ile parameterized testler yapmak için geçerlidir.
     */
}
