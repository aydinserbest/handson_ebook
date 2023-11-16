package github.boniGarcia.testng.ch03.user_gestures;

public class check {
    /*
     WebElement monthElement = driver.findElement(By.xpath(String.format("//th[contains(text(), '%d')]", currentYear)));
        monthElement.click();

        String xpath = String.format("//img[@src='img/%s.png']", imageName);
            WebElement image = driver.findElement(By.xpath(xpath));
            actions.moveToElement(image).build().perform();

     */


             /*
        --> go to website https://the-internet.herokuapp.com/hovers
        -->hover over each image
        -->verify each 'name:user' text is displayed
         */
    /*
        driver.get("https://the-internet.herokuapp.com/hovers");

        driver.findElement(By.xpath("(//img)[2]"));

        for (int i = 2; i <=4; i++) {
        String imgXpath="(//img)["+i+"]";
        WebElement img= driver.findElement(By.xpath(imgXpath));
        System.out.println(imgXpath);

        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.moveToElement(img).perform();

        String textPath= "//h5[text()='name: user"+(i-1)+"']";
        WebElement text= driver.findElement(By.xpath(textPath));
        System.out.println(textPath);
        Assert.assertTrue(text.isDisplayed(),"verify user "+(i-1)+" is displayed");



     */
    /*
            driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

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
     */

    /*

    http://eurotech.study/
    DevelopersPage

     public void navigateToMenu(String menuType){
        Driver.get().findElement(By.xpath("//*[text()='"+menuType+"']")).click();
    }

    basepage
        WebElement menu =   Driver.get().findElement(By.xpath("//a[text()='" + menuName + "']"));

        menu.click();
     */
    /*
    editprofile.feature
     Scenario: Verify Menu List
        When the user logs in using "eurotech@gmail.com" and "Test12345!"
        And the user navigates to "Edit Profile"
        And the user verify that following menu
          | * Select Professional Status |
          | Developer                    |
          | Junior Developer             |
          | Senior Developer             |
          | Manager                      |
          | Student or Learning          |
          | Instructor or Teacher        |
          | Intern                       |
          | Other                        |

             EditProfileStepDefs

      public void theUserVerifyThatFollowingMenu(List<String> expectedList) {
            WebElement selectMenu= Driver.get().findElement(By.xpath("//select[@name='status']"));
       Select select= new Select(selectMenu);

     */
}
