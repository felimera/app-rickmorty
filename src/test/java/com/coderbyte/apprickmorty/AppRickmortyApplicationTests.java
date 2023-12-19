package com.coderbyte.apprickmorty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

@SpringBootTest
class AppRickmortyApplicationTests {

    @Test
    void contextLoads() {
        AppRickmortyApplication myClass = new AppRickmortyApplication();
        Assertions.assertNotNull(myClass);  // JUnit assertion
    }

}
