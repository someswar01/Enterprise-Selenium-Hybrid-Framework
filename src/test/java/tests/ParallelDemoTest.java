package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelDemoTest {

    @Test
    public void testOne() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Test One : " + Thread.currentThread().threadId());
        Assert.assertTrue(true);
    }

    @Test
    public void testTwo() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Test Two : " + Thread.currentThread().threadId());
        Assert.assertTrue(true);
    }

    @Test
    public void testThree() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Test Three : " + Thread.currentThread().threadId());
        Assert.assertTrue(true);
    }
}