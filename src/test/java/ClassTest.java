import static org.junit.Assert.*;

import gradebook.model.Course;
import gradebook.model.Class;
import gradebook.model.GradebookCategory;
import gradebook.model.GradebookItem;
import gradebook.model.GradingScheme;
import gradebook.model.LetterGrade;
import gradebook.model.Section;
import gradebook.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ClassTest {
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
    public void testFullClassConstructor() {
        List<Section> lst = new ArrayList<Section>();
        Class clazz = new Class(co, lst, gs);
        assertEquals(co, clazz.getCourse());
        assertEquals(lst, clazz.getSections());
        assertEquals(gs, clazz.getScheme());
    }

    @Test
    public void testBasicConstructor() {
        List<Section> lst = new ArrayList<Section>();
        Class clazz = new Class(co, lst);
        assertEquals(co, clazz.getCourse());
        assertEquals(lst, clazz.getSections());
    }

    @Test
    public void testGetScore() {
        assertEquals(76.25, c1.getScore(), .0001);
    }

    @Test
    public void testGetLetterGrade() {
        assertEquals(LetterGrade.C, c1.getLetterGrade());
    }

    @Test
    public void testAddSection() {
        List<Section> lst = new ArrayList<Section>();
        Class clazz = new Class(co, lst);
        clazz.addSection(se1);
        assertEquals(1, lst.size());
        assertEquals(se1, lst.get(0));
    }

    @Test
    public void testGetCourse() {
        assertEquals(co, c1.getCourse());
    }

    @Test
    public void testGetSections() {
        List<Section> lst = new ArrayList<Section>();
        lst.add(se1);
        Class clazz = new Class(co, lst);
        assertEquals(lst, clazz.getSections());
    }

    @Test
    public void testSetCourse() {
        c1.setCourse(null);
        assertNull(c1.getCourse());
    }

    @Test
    public void testSetSections() {
        List<Section> lst = new ArrayList<Section>();
        c1.setSections(lst);
        assertEquals(lst, c1.getSections());
    }

    @Test
    public void testGetWeight() {
        assertEquals(1.0, c1.getWeight(), .0001);
    }
}
