import org.example.PrimeNumberProcesser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberProcesserTest {

    //success of import and exception work
    @Test
    public void testImportExcel() {
        assertNotNull(PrimeNumberProcesser.excelData);
        Assertions.assertThrows(RuntimeException.class, () -> PrimeNumberProcesser.importExcel("src/test/resources/data_testing.txt"));
    }


    //Sorting data - ignoring invalid and write valid data for next processing.
    @Test
    public void testSortExcelData() {
        PrimeNumberProcesser.excelData.clear();
        PrimeNumberProcesser.excelData.add("abc");
        PrimeNumberProcesser.excelData.add(" 5");
        PrimeNumberProcesser.excelData.add("*!");
        PrimeNumberProcesser.excelData.add("a5");
        PrimeNumberProcesser.excelData.add("3");
        PrimeNumberProcesser.excelData.add("abc");
        PrimeNumberProcesser.sortExcelData();
        assertFalse(PrimeNumberProcesser.sortedExcelData.isEmpty());
        assertEquals(2, PrimeNumberProcesser.sortedExcelData.size());
        assertEquals(5L, PrimeNumberProcesser.sortedExcelData.get(0).longValue());
    }


    //only prime number approved by isPrimeNumber() method could be add for next step
    @Test
    public void testNotePrimeNumber() {
        PrimeNumberProcesser.sortedExcelData.clear();
        PrimeNumberProcesser.sortedExcelData.add(2);
        PrimeNumberProcesser.sortedExcelData.add(3);
        PrimeNumberProcesser.sortedExcelData.add(5);
        PrimeNumberProcesser.sortedExcelData.add(7);
        PrimeNumberProcesser.sortedExcelData.add(11);
        PrimeNumberProcesser.sortedExcelData.add(13);
        PrimeNumberProcesser.sortedExcelData.add(14);
        PrimeNumberProcesser.sortedExcelData.add(16);
        PrimeNumberProcesser.notePrimeNumber();
        assertFalse(PrimeNumberProcesser.primeNumbers.isEmpty());
        assertEquals(6, PrimeNumberProcesser.primeNumbers.size());
        assertEquals(13L, PrimeNumberProcesser.primeNumbers.get(5).longValue());
    }


    //test if data is prime number and could be added
    @Test
    public void testIsPrimeNumber() {
        assertTrue(PrimeNumberProcesser.isPrimeNumber(2));
        assertTrue(PrimeNumberProcesser.isPrimeNumber(3));
        assertFalse(PrimeNumberProcesser.isPrimeNumber(4));
        assertFalse(PrimeNumberProcesser.isPrimeNumber(12));
        assertFalse(PrimeNumberProcesser.isPrimeNumber(15));
    }

}
