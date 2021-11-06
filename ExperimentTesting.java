import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        assertFalse(false);
    }
}