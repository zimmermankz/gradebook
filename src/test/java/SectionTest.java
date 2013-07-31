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

public class SectionTest {
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
        List<Student> list = new ArrayList<Student>();
        Section section = new Section(c1, list, gs);
        assertEquals(c1, section.getClazz());
        assertEquals(list, section.getStudents());
        assertEquals(gs, section.getScheme());
    }

    @Test
    public void testBasicConstructor() {
        List<Student> list = new ArrayList<Student>();
        Section section = new Section(c1, list);
        assertEquals(c1, section.getClazz());
        assertEquals(list, section.getStudents());
    }

    @Test
    public void testGetScore() {
        assertEquals(82.5, se1.getScore(), .0001);
    }

    @Test
    public void testGetLetterGrade() {
        assertEquals(LetterGrade.B, se1.getLetterGrade());
    }

    @Test
    public void testGetClazz() {
        assertEquals(c1, se1.getClazz());
    }

    @Test
    public void testGetStudents() {
        List<Student> lst = new ArrayList<Student>();
        lst.add(s1);
        Section section = new Section(c1, lst);
        assertEquals(lst, section.getStudents());
    }

    @Test
    public void testSetClazz() {
        se1.setClazz(null);
        assertNull(se1.getClazz());
    }

    @Test
    public void testSetStudents() {
        List<Student> list = new ArrayList<Student>();
        se1.setStudents(list);
        assertEquals(list, se1.getStudents());
    }

    @Test
    public void testAddStudent() {
        List<Student> list = new ArrayList<Student>();
        se1.setStudents(list);
        se1.addStudent(s1);
        assertEquals(1, se1.getStudents().size());
        assertEquals(s1, se1.getStudents().get(0));
    }

    @Test
    public void testGetWeight() {
        assertEquals(1, se1.getWeight(), .0001);
    }

}
