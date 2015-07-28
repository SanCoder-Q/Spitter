package com.tw.sancoder.spitter.test;//Created by SanCoder on 7/28/15.

import org.flywaydb.core.Flyway;
import org.junit.*;

import com.tw.sancoder.spitter.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MessagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static final Flyway flyway = new Flyway();

    @BeforeClass
    public static void setUpClassFeature(){
        flyway.setDataSource("jdbc:mysql://127.0.0.1:3306/spitter_test?characterEncoding=utf8", "root", "");
        flyway.setLocations("filesystem:./src/test/resources/db/migration");
    }

    @Before
    public void setUpFeature() {
        System.setOut(new PrintStream(outContent));
        flyway.clean();
        flyway.migrate();
    }

    @After
    public void cleanUpFeature() {
        flyway.clean();
        flyway.migrate();
        System.setOut(null);
    }

    @Test
    public void should_print_correct_string(){
        Messager.print();
        Assert.assertEquals("Come on.\n", outContent.toString());
    }
}
