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

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
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
        List<Course> courseList = new ArrayList<Course>(); 
        List<Class> classList = new ArrayList<Class>(); 
        Course course = new Course("CS", 2340, "Objects & Design", courseList,
                classList, gs);
        assertEquals("CS", course.getSubject());
        assertEquals(2340, course.getCourseNumber());
        assertEquals("Objects & Design", course.getCourseName());
        assertEquals(courseList, course.getPrerequisites());
        assertEquals(classList, course.getClasses());
        assertEquals(gs, course.getScheme());
    }

    @Test
    public void testBasicConstructor() {
        List<Course> courseList = new ArrayList<Course>(); 
        List<Class> classList = new ArrayList<Class>(); 
        Course course = new Course("CS", 2340, "Objects & Design", courseList,
                classList);
        assertEquals("CS", course.getSubject());
        assertEquals(2340, course.getCourseNumber());
        assertEquals("Objects & Design", course.getCourseName());
        assertEquals(courseList, course.getPrerequisites());
        assertEquals(classList, course.getClasses());
    }

    @Test
    public void testGetSubject() {
        assertEquals("CS", co.getSubject());
    }

    @Test
    public void testGetCourseNumber() {
        assertEquals(2340, co.getCourseNumber());
    }

    @Test
    public void testGetCourseName() {
        assertEquals("Course", co.getCourseName());
    }

    @Test
    public void testGetPrerequisites() {
        assertNull(co.getPrerequisites());
    }

    @Test
    public void testGetClasses() {
        List<Class> classList = new ArrayList<Class>(); 
        Course course = new Course("CS", 2340, "Objects & Design", null,
                classList);
        assertEquals(classList, course.getClasses());
    }

    @Test
    public void testSetSubject() {
        co.setSubject("MATH");
        assertEquals("MATH", co.getSubject());
    }

    @Test
    public void testSetCourseNumber() {
        co.setCourseNumber(3232);
        assertEquals(3232, co.getCourseNumber());
    }

    @Test
    public void testSetCourseName() {
        co.setCourseName("O&D");
        assertEquals("O&D", co.getCourseName());
    }

    @Test
    public void testSetPrerequisites() {
        List<Course> list = new ArrayList<Course>();
        co.setPrerequisites(list);
        assertEquals(list, co.getPrerequisites());
    }

    @Test
    public void testSetClassList() {
        List<Class> list = new ArrayList<Class>();
        co.setClassList(list);
        assertEquals(list, co.getClasses());
    }

    @Test
    public void testGetAverageClassScore() {
        assertEquals(76.25, co.getAverageClassScore(), .0001);
    }

    @Test
    public void testGetAverageClassLetterGrade() {
        assertEquals(LetterGrade.C, co.getAverageClassLetterGrade());
    }

    @Test
    public void testAddClass() {
        co.setClassList(null);
        co.addClass(c1);
        assertEquals(1, co.getClasses().size());
        assertEquals(c1, co.getClasses().get(0));
    }
}
