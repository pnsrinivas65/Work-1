package hello.onlinetest.test2;

public class Test3
{ 
    public void foo() 
    {
        assert false; /* Line 5 */
        assert false; /* Line 6 */
    } 
    public void bar()
    {
        while(true)
        {
            assert false; /* Line 12 */
        } 
        //assert false;  /* Line 14 */
    } 
}
