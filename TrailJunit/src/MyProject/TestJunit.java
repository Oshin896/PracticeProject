package MyProject;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {
    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        String message="How do you do";
        assertEquals(message,messageUtil.printMessage());
    }
}
