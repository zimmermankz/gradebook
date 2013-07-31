package gradebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a section of some Class.  Contains Students and can calculate
 * their average numerical and letter grade.  Plays a Concrete Factory design
 * pattern.
 * @author Kyle Z
 */
public final class Section extends GradedGroup implements Gradable {
    /**
     * The Class of which this Section is part.  Called "clazz" because "class"
     * is reserved by Java.
     */
    private Class clazz;
    /**
     * The list of Students in this Section.
     */
    private List<Student> students;

    /**
     * Full Section Constructor, specifying a GradingScheme.
     * @param aClass Class of which this Section is part
     * @param studentList list of Students in this Section
     * @param aScheme GradingScheme to be used by the Section.
     */
    public Section(final Class aClass, final List<Student> studentList,
            final GradingScheme aScheme) {
        clazz = aClass;
        students = studentList;
        if (students == null) {
            students = new ArrayList<Student>();
        }
        if (aClass != null) {
            aClass.addSection(this);
        }
        setScheme(aScheme);
    }
    /**
     * Basic Section Constructor.  Uses default GradingScheme.
     * @param aClass Class of which this Section is part
     * @param studentList list of Students in this Section
     */
    public Section(final Class aClass, final List<Student> studentList) {
        this(aClass, studentList, new GradingScheme());
    }

    @Override
    public double getScore() {
        return getAverageScore(students);
    }

    @Override
    public LetterGrade getLetterGrade() {
        return getAverageLetterGrade(students);
    }
    /**
     * Class getter.
     * @return current Class (clazz)
     */
    public Class getClazz() {
        return clazz;
    }
    /**
     * Student list getter.
     * @return current Student list
     */
    public List<Student> getStudents() {
        return students;
    }
    /**
     * Class setter.
     * @param newClass new class
     */
    public void setClazz(final Class newClass) {
        clazz = newClass;
    }
    /**
     * Student list setter.
     * @param newStudents new Student list
     */
    public void setStudents(final List<Student> newStudents) {
        students = newStudents;
        if (students == null) {
            students = new ArrayList<Student>();
        }
    }
    /**
     * Adds a Student to the Student list.
     * @param student Student to be added to the list
     */
    public void addStudent(final Student student) {
        students.add(student);
    }

    @Override
    public double getWeight() {
        return 1;
    }

    @Override
    public int compareTo(final Gradable o) {
        if (this.getScore() - o.getScore() < 0) {
            return -1;
        } else if (this.getScore() - o.getScore() > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
