package github.boniGarcia.testng.ch05.DSL_approach;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactoryLoginNGTest {
    FactoryLoginPage login;
    @BeforeMethod
    public void setup(){login = new FactoryLoginPage("chrome");}
    @AfterMethod
    public void teardown(){login.teardown();}
    @Test
    public void testLoginSuccess(){
        login.with("user", "user");

        assertThat(login.successBoxPresent()).isTrue();
    }
}

