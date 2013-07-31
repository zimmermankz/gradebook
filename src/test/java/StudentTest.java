import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import gradebook.model.Course;
import gradebook.model.Class;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.GradingScheme;
import gradebook.model.LetterGrade;
import gradebook.model.Section;
import gradebook.model.Student;

import org.junit.Test;

public class StudentTest {
    private GradingScheme gs = new GradingScheme(80, 70, 60, 50, 1);
    private Course co = new Course("CS", 2340, "Course", null, null);
    private Class c1 = new Class(co, null);
    private Section se1 = new Section(c1, null);
    private Section se2 = new Section(c1, null);
    private Student s1 = new Student("A", null, se1, gs);
    private Student s2 = new Student("B", null, se1);
    private Student s3 = new Student("C", null, se2);
    private GradebookCategory c11 = new GradebookCategory("a", 1, s1, null);
    private GradebookItem i11 = new GradebookItem("", c11, 100);
    private GradebookCategory c12 = new GradebookCategory("b", 1, s1, null);
    private GradebookItem i12 = new GradebookItem("", c12, 90);
    private GradebookCategory c13 = new GradebookCategory("c", 1, s1, null);
    private GradebookItem i13 = new GradebookItem("", c13, 80);
    private GradebookCategory c21 = new GradebookCategory("a", 1, s2, null);
    private GradebookItem i21 = new GradebookItem("", c21, 100);
    private GradebookCategory c22 = new GradebookCategory("b", 2, s2, null);
    private GradebookItem i22 = new GradebookItem("", c22, 70);
    private GradebookCategory c23 = new GradebookCategory("c", 3, s2, null);
    private GradebookItem i23 = new GradebookItem("", c23, 60);
    private GradebookCategory c3 = new GradebookCategory("", 100, s3, null);
    private GradebookItem i3 = new GradebookItem("", c3, 70);
    
    @Test
    public void testFullConstructor() {
        List<GradebookCategory> list = new ArrayList<GradebookCategory>();
        Student student = new Student("Name", list, se1, gs);
        assertEquals("Name", student.getName());
        assertEquals(list, student.getCategories());
        assertEquals(se1, student.getSection());
        assertEquals(gs, student.getScheme());
    }

    @Test
    public void testBasicConstructor() {
        List<GradebookCategory> list = new ArrayList<GradebookCategory>();
        Student student = new Student("Name", list, se1);
        assertEquals("Name", student.getName());
        assertEquals(list, student.getCategories());
        assertEquals(se1, student.getSection());
    }

    @Test
    public void testGetName() {
        assertEquals("A", s1.getName());
    }

    @Test
    public void testGetCategories() {
        List<GradebookCategory> lst = new ArrayList<GradebookCategory>();
        Student student = new Student("a", lst, se1);
        assertEquals(lst, student.getCategories());
    }

    @Test
    public void testGetSection() {
        assertEquals(se1, s1.getSection());
    }

    @Test
    public void testSetName() {
        s1.setName("name");
        assertEquals("name", s1.getName());
    }

    @Test
    public void testSetCategories() {
        List<GradebookCategory> lst = new ArrayList<GradebookCategory>();
        s1.setCategories(lst);
        assertEquals(lst, s1.getCategories());
    }

    @Test
    public void testSetSection() {
        s1.setSection(se2);
        assertEquals(se2, s1.getSection());
    }

    @Test
    public void testGetScore() {
        assertEquals(95, s1.getScore(), .0001);
    }

    @Test
    public void testGetLetterGrade() {
        assertEquals(LetterGrade.A, s1.getLetterGrade());
    }

    @Test
    public void testGetWeight() {
        assertEquals(1, s1.getWeight(), .0001);
    }

    @Test
    public void testAddCategory() {
        List<GradebookCategory> lst = new ArrayList<GradebookCategory>();
        s1.setCategories(lst);
        s1.addCategory(c3);
        assertEquals(1, s1.getCategories().size());
        assertEquals(c3, s1.getCategories().get(0));
    }

}
