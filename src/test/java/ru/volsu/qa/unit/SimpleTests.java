package ru.volsu.qa.unit;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.volsu.qa.utils.Math;

public class SimpleTests {

    @BeforeClass
    public void init() {
        System.out.println("Some actions before class");
    }

    @AfterClass
    public void cleanup() {
        System.out.println("Some actions after class");
    }

    @BeforeMethod
    public void initMethod() {
        System.out.println("Some actions before method");
    }

    @AfterMethod
    public void cleanupMethod() {
        System.out.println("Some actions after method");
    }

    @Ignore
    @Test(groups = {"smoke", "regression"})
    public void simpleTest() {
        System.out.println("Running test...");
        Assert.assertEquals(Math.max(2, 1), 2);
        Assert.assertEquals(Math.max(3, 5), 5);
    }

    @Ignore
    @Test(groups={"regression"})
    public void testWithSoftAssert() {
        SoftAssert sa = new SoftAssert();

        sa.assertEquals(Math.max(2, 1), 2);
        sa.assertEquals(Math.max(3, 5), 5);

        sa.assertAll();
    }

    @Ignore
    @Test
    @Parameters({"firstVal", "secondVal", "expectedVal"})
    public void testWithParams(int firstVal, int secondVal, int expectedVal){
        Assert.assertEquals(Math.max(firstVal, secondVal), expectedVal);
    }

    @DataProvider(name = "simpleDataProvider")
    public Object[][] someDataProvider(){
        return new Object[][]{
                {1,2,2},
                {3,4,4}
        };
    }

    @Ignore
    @Test(dataProvider = "simpleDataProvider", groups = {"regression"})
    public void testWithDataProvider(int firstVal, int secondVal, int expectedVal){
        Assert.assertEquals(Math.max(firstVal, secondVal), expectedVal);
    }
}
