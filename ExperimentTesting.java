import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ExperimentTesting
{
    @Test
    public void MyAsserTrue()
    {
        assertEquals(true, true);
    }

    @Test
    public void MyAssertFalse()
    {
        assertEquals(false, true);
    }
}