package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_cookies extends TestBase {
    @Test
    public void cookieTest() {
        driver.get("https://www.amazon.com");
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int count = 1;
        // print cookies
        for (Cookie each : cookieSet
        ) {
            System.out.println(count + ". cookie: " + each);
            count++;
        }
        // count cookies
        System.out.println("Cookies count : " + cookieSet.size());
        // is i18n-prefs cookies value USD
        for (Cookie each : cookieSet
        ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }
        // create cookie cookieName - cookieValue
        Cookie cookie = new Cookie("cookieName","cookieValue");
        driver.manage().addCookie(cookie);
        // check new cookie
        cookieSet = driver.manage().getCookies();
        count = 1;
        for (Cookie each : cookieSet
        ) {
            System.out.println(count + ". cookie: " + each);
            count++;
        }
        // delete named skin cookie nd check
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(driver.manage().getCookies().contains("skin"));
        // delete all cookies nd check
        driver.manage().deleteAllCookies();
        Assert.assertTrue(driver.manage().getCookies().isEmpty());


    }
}
