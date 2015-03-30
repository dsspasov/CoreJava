package joinMethod;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JavaJoinTest {

    public JavaJoin arrayOfStrings = new JavaJoin();
    
    @Before
    public void setUp(){
        
        
    }
    
    @After
    public void TearDown(){
        
        
    }
    
    @Test
    public void testJoinWithZeroArray() {
        String result = "";
        assertEquals(result, arrayOfStrings.join(" "));
    }
    @Test
    public void testJoinWithSomeWords() {
        String result = "���� ����� ������ ������";
        assertEquals(result, arrayOfStrings.join(" ", "����", "�����", "������", "������"));
    }
    @Test
    public void testJoinWithEveryObject() {
        String result = "���� ����� 5 ������ ������";
        assertEquals(result, arrayOfStrings.join(" ", "����", "�����", 5, "������", "������"));
    }


}
