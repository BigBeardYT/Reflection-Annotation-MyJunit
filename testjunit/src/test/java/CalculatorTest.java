import org.junit.*;
public class CalculatorTest {

    private Calculator cal;//待测试的单元

    @BeforeClass
    public static void bc(){
        System.out.println("beforeclass");
    }

    @Before //执行测试方法前要调用的
    public void setUp() throws Exception {
        System.out.println("before");
    }
    @After  //执行测试方法后要调用的
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @AfterClass
    public static void ac()throws Exception{
        System.out.println("Afterclass");
    }

    @Test
    public void add() {
        System.out.println("add测试:");
        Assert.assertEquals(3,cal.add(1,2));

    }

    @Test
    public void sub() {
        System.out.println("sub测试:");
        Assert.assertEquals(1,cal.sub(2,1));
    }

}
