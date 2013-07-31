import static org.junit.Assert.*;

import gradebook.model.LetterGrade;

import org.junit.Test;

public class LetterGradeTest {

    @Test
    public void testConvertToLetterGradeDouble() {
        assertEquals(LetterGrade.A, LetterGrade.convertToLetterGrade(95));
        assertEquals(LetterGrade.B, LetterGrade.convertToLetterGrade(85));
        assertEquals(LetterGrade.C, LetterGrade.convertToLetterGrade(75));
        assertEquals(LetterGrade.D, LetterGrade.convertToLetterGrade(65));
        assertEquals(LetterGrade.F, LetterGrade.convertToLetterGrade(55));
    }

    @Test
    public void testConvertToLetterGradeDoubleDoubleDoubleDoubleDouble() {
        assertEquals(LetterGrade.A, LetterGrade.convertToLetterGrade(85, 80,
                70, 60, 50));
        assertEquals(LetterGrade.B, LetterGrade.convertToLetterGrade(75, 80,
                70, 60, 50));
        assertEquals(LetterGrade.C, LetterGrade.convertToLetterGrade(65, 80,
                70, 60, 50));
        assertEquals(LetterGrade.D, LetterGrade.convertToLetterGrade(55, 80,
                70, 60, 50));
        assertEquals(LetterGrade.F, LetterGrade.convertToLetterGrade(45, 80,
                70, 60, 50));
    }

}
