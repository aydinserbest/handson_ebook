package github.boniGarcia.testng.ch03.user_gestures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {
    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void printTable() throws InterruptedException {

        WebElement table1 = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(table1.getText());
    }

    @Test
    public void getAllHeaders() {

        //How many columns we have
        //getAll Headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        // List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']//th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
        System.out.println("****************************************");
        //getRow size
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());
        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getRows() {


        //get all rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("numRows.size() = " + numRows.size());

        //get second row which is starting clock tower hotel
        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        for (int i = 1; i <=numRows.size() ; i++) {
            WebElement row= driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+i+"]"));
            System.out.println(i+"-" + row.getText());
        }
    }

    @Test
    public void gelAllCellInOneRow() {

        //get Burj Khalifa's info
        List<WebElement> burj = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        //expected size =6
        System.out.println("burj.size() = " + burj.size());

        for (WebElement element : burj) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void getSingleCell() {
        //get Height of Clock Tower Hotel (601)

        WebElement heightOfTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("heightOfTower.getText() = " + heightOfTower.getText());
    }

    @Test
    public void printAllCellByIndex() {

        int rowNumber =getNumberOfRows();
        int colNumber =getNumberOfColumns()-2;

        //her bir row u al
        for (int i = 1; i <=rowNumber ; i++) {
            //her bir column al
            for (int j = 1; j <=colNumber ; j++) {

                String cellXpath = "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println("cellXpath = " + cellXpath);
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.print(" "+cell.getText());
            }
            System.out.println();
        }
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }
}
