import static org.junit.Assert.*;

import gradebook.model.Course;
import gradebook.model.Class;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.GradingScheme;
import gradebook.model.LetterGrade;
import gradebook.model.Section;
import gradebook.model.Student;

import org.junit.Test;

public class GradebookItemTest {
    private GradingScheme gs = new GradingScheme(80, 70, 60, 50, 1);
    private Course co = new Course("CS", 2340, "Course", null, null);
    private Class c1 = new Class(co, null);
    private Section se1 = new Section(c1, null);
    private Section se2 = new Section(c1, null);
    private Student s1 = new Student("A", null, se1, gs);
    private Student s2 = new Student("B", null, se1);
    private Student s3 = new Student("C", null, se2);
    private GradebookCategory c11 = new GradebookCategory("a", 1, s1, null);
    private GradebookItem i11 = new GradebookItem("a1", c11, 100);
    private GradebookCategory c12 = new GradebookCategory("b", 1, s1, null);
    private GradebookItem i12 = new GradebookItem("a2", c12, 90);
    private GradebookCategory c13 = new GradebookCategory("c", 1, s1, null);
    private GradebookItem i13 = new GradebookItem("a3", c13, 80);
    private GradebookCategory c21 = new GradebookCategory("d", 1, s2, null);
    private GradebookItem i21 = new GradebookItem("b1", c21, 100);
    private GradebookCategory c22 = new GradebookCategory("e", 2, s2, null);
    private GradebookItem i22 = new GradebookItem("b2", c22, 70);
    private GradebookCategory c23 = new GradebookCategory("f", 3, s2, null);
    private GradebookItem i23 = new GradebookItem("b3", c23, 60);
    private GradebookCategory c3 = new GradebookCategory("z", 100, s3, null);
    private GradebookItem i3 = new GradebookItem("z1", c3, 70);
    
    @Test
    public void testConstructor() {
        GradebookItem item = new GradebookItem("Item", c11, 100);
        assertEquals("Item", item.getName());
        assertEquals(c11, item.getCategory());
        assertEquals(100, item.getScore(), .0001);
    }

    @Test
    public void testGetName() {
        assertEquals("z1", i3.getName());
    }

    @Test
    public void testGetCategory() {
        assertEquals(c3, i3.getCategory());
    }

    @Test
    public void testGetScore() {
        assertEquals(70, i3.getScore(), .0001);
    }

    @Test
    public void testSetName() {
        i3.setName("Name");
        assertEquals("Name", i3.getName());
    }

    @Test
    public void testSetCategory() {
        i3.setCategory(c11);
        assertEquals(c11, i3.getCategory());
    }

    @Test
    public void testSetScore() {
        i3.setScore(100);
        assertEquals(100, i3.getScore(), .0001);
    }

    @Test
    public void testGetLetterGrade() {
        assertEquals(LetterGrade.C, i3.getLetterGrade());
    }

    @Test
    public void testGetWeight() {
        assertEquals(1, i3.getWeight(), .0001);
    }

}
