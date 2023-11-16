package github.boniGarcia.junit4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class ParameterizedJUnit4Test {
    WebDriver driver;
    @Parameter(0)
    public String username;
    @Parameterized.Parameter(1)
    public String password;
    @Parameter(3)
    public String expectedText;

    @Before
    public void setup(){driver = WebDriverManager.chromedriver().create();
    }
    @After
    public void teardown(){driver.quit();}

}
/*
Junit ile 2 ayri yontem var
constructor üzerinden ve sınıf değişkenlerine doğrudan annotasyonlarla enjekte etme.
 */
/*
Constructor Yöntemi:
Test sınıfının bir constructor'ı kullanılarak parametreler sınıf değişkenlerine atanır.
Bu yöntemde, değişkenler genellikle private olarak tanımlanır çünkü erişim constructor aracılığıyla sağlanır.

Annotasyon Yöntemi:
@Parameter annotasyonu kullanılarak, JUnit test runner'ı tarafından her test için belirlenen parametreler
direkt olarak public sınıf değişkenlerine atanır. Bu yöntemde, değişkenlerin public olması genellikle gereklidir,
çünkü test runner'ı bu değişkenlere doğrudan erişip değer ataması yapar.
 */
/*
    JUnit ile parameterized testler yaparken,
    test runner'ın parametre değerlerini test sınıfının değişkenlerine enjekte edebilmesi için
    bu değişkenlerin erişilebilir olması gerekmektedir.

    Test runner, parametreleri sınıfa enjekte etmek için bu değişkenlere doğrudan erişebilmeli,
    dolayısıyla değişkenlerin genellikle public olarak tanımlanması bu gereksinimi karşılar.

    TestNG'de ise parametreler genellikle metod parametreleri olarak verilir
    ve bu yüzden sınıf değişkenlerinin erişim düzeyleri farklılık gösterebilir.
 */


