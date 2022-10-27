package com.geektrust.backend;


import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Apptest")
class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        List<String> arguments= new ArrayList<>(List.of("sample_input/input1.txt"));
        String expectedOutput = "2400 5215";
        App.run(arguments);
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }
    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        List<String> arguments= new ArrayList<>(List.of("sample_input/input2.txt"));
        String expectedOutput = "3000 5750";
        App.run(arguments);
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
