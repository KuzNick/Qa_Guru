package github;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitSimpleTest {

    @Test
    @DisplayName("Типа тест")
    void simpleTest(){
        Assertions.assertTrue(3>2);
    }
}
