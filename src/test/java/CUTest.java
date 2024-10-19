import static org.junit.jupiter.api.Assertions.*;

import org.example.CU;
import org.example.Mark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CUTest {

    private CU cu;

    @BeforeEach
    public void setUp() {
        cu = new CU("Matemática", 5);
    }

    @Test
    public void testInsertMarkCU() {
        cu.insertMarkCU(1, 10.5);
        Mark mark = cu.searchStudent(1);
        assertNotNull(mark);
        assertEquals(10.5, mark.getMark(), 0.01);
    }

    @Test
    public void testSearchStudent() {
        cu.insertMarkCU(2, 12.0);
        Mark mark = cu.searchStudent(2);
        assertNotNull(mark);
        assertEquals(12.0, mark.getMark(), 0.01);

        assertNull(cu.searchStudent(999));
    }

    @Test
    public void testAverageCU() {
        cu.insertMarkCU(1, 15.0);
        cu.insertMarkCU(2, 10.0);
        assertEquals(12.5, cu.averageCU(), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10.0, true",
            "2, 8.0, false",
            "3, 9.5, true",
            "4, 9.49, false"
    })
    public void testIsApproved(int numStudent, double mark, boolean expectedResult) {
        cu.insertMarkCU(numStudent, mark);
        assertEquals(expectedResult, cu.isApproved(numStudent));
    }
}
