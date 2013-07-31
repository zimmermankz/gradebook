package gradebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course in some curriculum.  Can return an average grade across
 * all Classes from the course.  Plays a Concrete Factory design pattern.
 * @author Kyle Z
 */
public final class Course extends GradedGroup {
    /**
     * Subject of the Course.
     */
    private String subject;
    /**
     * Course number.
     */
    private int number;
    /**
     * Name of the Course.
     */
    private String name;
    /**
     * Prerequisites for taking the Course.
     */
    private List<Course> prereqs;
    /**
     * List of Classes of this Course.
     */
    private List<Class> classes;

    /**
     * Full Course Constructor, specifying a GradingScheme.
     * @param newSubject Course subject
     * @param newNumber Course number
     * @param newName Course name
     * @param prereqList Prerequisites for the Course
     * @param classList Classes of the Course
     * @param aScheme GradingScheme for the Course
     */
    public Course(final String newSubject, final int newNumber,
            final String newName, final List<Course> prereqList,
            final List<Class> classList, final GradingScheme aScheme) {
        subject = newSubject;
        number = newNumber;
        name = newName;
        prereqs = prereqList;
        classes = classList;
        if (classes == null) {
            classes = new ArrayList<Class>();
        }
        setScheme(aScheme);
    }
    /**
     * Basic Course Constructor. Uses default grading scheme.
     * @param newSubject Course subject
     * @param newNumber Course number
     * @param newName Course name
     * @param prereqList Prerequisites for the Course
     * @param classList Classes of the Course
     */
    public Course(final String newSubject, final int newNumber,
            final String newName, final List<Course> prereqList,
            final List<Class> classList) {
        this(newSubject, newNumber, newName, prereqList, classList,
                new GradingScheme());
    }

    /**
     * Subject getter.
     * @return current subject
     */
    public String getSubject() {
        return subject;
    }
    /**
     * Number getter.
     * @return current number
     */
    public int getCourseNumber() {
        return number;
    }
    /**
     * Name getter.
     * @return current name
     */
    public String getCourseName() {
        return name;
    }
    /**
     * Prereq getter.
     * @return current prereqs
     */
    public List<Course> getPrerequisites() {
        return prereqs;
    }
    /**
     * Class list getter.
     * @return current list of Classes
     */
    public List<Class> getClasses() {
        return classes;
    }
    /**
     * Subject setter.
     * @param newSubject new subject
     */
    public void setSubject(final String newSubject) {
        subject = newSubject;
    }
    /**
     * Number setter.
     * @param newNumber new number
     */
    public void setCourseNumber(final int newNumber) {
        number = newNumber;
    }
    /**
     * Name setter.
     * @param newName new name
     */
    public void setCourseName(final String newName) {
        name = newName;
    }
    /**
     * Prereqs setter.
     * @param newPrereqs new prereqs
     */
    public void setPrerequisites(final List<Course> newPrereqs) {
        prereqs = newPrereqs;
    }
    /**
     * Class list setter.
     * @param newClasses new Class list
     */
    public void setClassList(final List<Class> newClasses) {
        classes = newClasses;
        if (classes == null) {
            classes = new ArrayList<Class>();
        }
    }
    /**
     * Calculates (unweighted) average numerical score across all classes.
     * @return average score of classes
     */
    public double getAverageClassScore() {
        return getAverageScore(classes);
    }
    /**
     * Calculates (unweighted) average letter grade across all classes.
     * @return average letter grade of classes
     */
    public LetterGrade getAverageClassLetterGrade() {
        return getAverageLetterGrade(classes);
    }
    /**
     * Adds a Class to the Class list.
     * @param newClass Class to be added
     */
    public void addClass(final Class newClass) {
        classes.add(newClass);
    }
}
