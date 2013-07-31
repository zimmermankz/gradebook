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

public class GradebookCategoryTest {
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
    public void testFullConstructor() {
        List<GradebookItem> list = new ArrayList<GradebookItem>();
        GradebookCategory category = new GradebookCategory("Category", 2.0, s1,
                list, gs);
        assertEquals("Category", category.getName());
        assertEquals(2.0, category.getWeight(), .0001);
        assertEquals(s1, category.getStudent());
        assertEquals(list, category.getGrades());
        assertEquals(gs, category.getScheme());
    }

    @Test
    public void testBasicConstructor() {
        List<GradebookItem> list = new ArrayList<GradebookItem>();
        GradebookCategory category = new GradebookCategory("Category", 2.0, s1,
                list);
        assertEquals("Category", category.getName());
        assertEquals(2.0, category.getWeight(), .0001);
        assertEquals(s1, category.getStudent());
        assertEquals(list, category.getGrades());
    }

    @Test
    public void testGetName() {
        assertEquals("z", c3.getName());
    }

    @Test
    public void testGetWeight() {
        assertEquals(100, c3.getWeight(), .0001);
    }

    @Test
    public void testGetStudent() {
        assertEquals(s3, c3.getStudent());
    }

    @Test
    public void testGetGrades() {
        List<GradebookItem> list = new ArrayList<GradebookItem>();
        c3.setGrades(list);
        assertEquals(list, c3.getGrades());
    }

    @Test
    public void testSetName() {
        c3.setName("Name");
        assertEquals("Name", c3.getName());
    }

    @Test
    public void testSetWeight() {
        c3.setWeight(5.0);
        assertEquals(5.0, c3.getWeight(), .0001);
    }

    @Test
    public void testSetStudent() {
        c3.setStudent(s1);
        assertEquals(s1, c3.getStudent());
    }

    @Test
    public void testSetGrades() {
        List<GradebookItem> list = new ArrayList<GradebookItem>();
        c3.setGrades(list);
        assertEquals(list, c3.getGrades());
    }

    @Test
    public void testAddGrade() {
        List<GradebookItem> list = new ArrayList<GradebookItem>();
        c3.setGrades(list);
        c3.addGrade(i3);
        assertEquals(1, c3.getGrades().size());
        assertEquals(i3, c3.getGrades().get(0));
    }

    @Test
    public void testGetScore() {
        assertEquals(70.0, c3.getScore(), .0001);
    }

    @Test
    public void testGetLetterGrade() {
        assertEquals(LetterGrade.C, c3.getLetterGrade());
    }
}
