package teme.patricia.Selenium2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.skillbrain.web.utils.ScreenshotUtil;
import org.testng.Assert;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class DemoQaBrowser {

    private static final ChromeDriver driver = new ChromeDriver();
    private static final ChromeOptions options = new ChromeOptions();
    private static final ScreenshotUtil screenshotUtil = new ScreenshotUtil();

    public static void main(String[] args) {
//        browserWindow();
//        newWindow();
        NewWindowMessage();
    }


    public static void browserWindow() {
        try {
            options.addArguments("--start-maximized");
            driver.get("https://demoqa.com/browser-windows");

            WebElement tabButton = driver.findElement(By.id("tabButton"));
            tabButton.click();

            Set<String> windowHandles = driver.getWindowHandles();
            Iterator<String> iterator = windowHandles.iterator();
            String parentWindow = iterator.next();
            String childWindow = iterator.next();

            driver.switchTo().window(childWindow);

            String newPageHeading = driver.findElement(By.id("sampleHeading")).getText();

            Assert.assertEquals(newPageHeading, "This is a sample page");

            System.out.println("Text on page is: " + newPageHeading);

            driver.switchTo().window(parentWindow);

        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }

    public static void newWindow() {

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/browser-windows");

            WebElement newWindowButton = driver.findElement(By.id("windowButton"));

            for (int i = 0; i < 2; i++) {

                newWindowButton.click();

                String mainWindow = driver.getWindowHandle();
                Set<String> allWindows = driver.getWindowHandles();

                for (String handle : allWindows) {
                    if (!handle.equals(mainWindow)) {
                        driver.switchTo().window(handle);

                        WebElement sampleText = driver.findElement(By.tagName("h1"));

                        if (i == 0) {
                            System.out.println("New window text: " + sampleText.getText());
                        }

                        driver.close();
                    }
                }

                driver.switchTo().window(mainWindow);
            }

        } catch (Exception e) {
            e.printStackTrace();
            screenshotUtil.screenshot(driver);
        } finally {
            driver.quit();
        }
    }




        public static void NewWindowMessage() {
            WebDriver driver = new ChromeDriver();

            try {
                driver.manage().window().maximize();
                driver.get("https://demoqa.com/browser-windows");

                WebElement messageButton = driver.findElement(By.id("messageWindowButton"));
                messageButton.click();

                String mainWindow = driver.getWindowHandle();


                long start = System.currentTimeMillis();
                while (driver.getWindowHandles().size() == 1 &&
                        System.currentTimeMillis() - start < 5000) {

                }

                Set<String> allWindows = driver.getWindowHandles();


                if (allWindows.size() > 1) {
                    System.out.println("Child window detected");
                } else {
                    System.out.println("No child window detected.");
                }

                driver.switchTo().window(mainWindow);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Closing browser session...");
                driver.quit();
            }
        }
    }



