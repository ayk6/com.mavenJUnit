package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03fileExist {
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
        // proje konumunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // pc kullanıcı konumu

        String textPath = System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(textPath);

        // dosya yolu testlerinde yollar farklı bilgisayarlarda
        // farklı olabileceği için dinamik path verilir
        // getPropherty kullanımı

        System.out.println(Files.exists(Paths.get(textPath))); // true
        Assert.assertTrue(Files.exists(Paths.get(textPath))); // test passed
    }
}
