package gradebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a category of GradebookItems for some Student. Also has a variable
 * weight.
 * @author Kyle Z
 */
public final class GradebookCategory extends GradedGroup implements Gradable {
    /**
     * Name of the category.
     */
    private String name;
    /**
     * Weight of the total of the items in the category.
     */
    private double weight;
    /**
     * Student to which the category belongs.
     */
    private Student student;
    /**
     * Grades within the category.
     */
    private List<GradebookItem> grades;

    /**
     * Full GradebookCategory Constructor, specifying GradingScheme.
     * @param newName name of the category
     * @param newWeight weight of the category
     * @param aStudent Student to which the category belongs
     * @param gradeList list of grades in the category
     * @param aScheme GradingScheme for the category
     */
    public GradebookCategory(final String newName, final double newWeight,
            final Student aStudent, final List<GradebookItem> gradeList,
            final GradingScheme aScheme) {
        name = newName;
        weight = newWeight;
        student = aStudent;
        grades = gradeList;
        if (grades == null) {
            grades = new ArrayList<GradebookItem>();
        }
        setScheme(aScheme);
        if (aStudent != null) {
            aStudent.addCategory(this);
        }
    }
    /**
     * Basic GradebookCategory Constructor. Uses default GradingScheme.
     * @param newName name of the category
     * @param newWeight weight of the category
     * @param aStudent Student to which the category belongs
     * @param gradeList list of grades in the category
     */
    public GradebookCategory(final String newName, final double newWeight,
            final Student aStudent, final List<GradebookItem> gradeList) {
        this(newName, newWeight, aStudent, gradeList, new GradingScheme());
    }

    /**
     * Name getter.
     * @return current name
     */
    public String getName() {
        return name;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    /**
     * Student getter.
     * @return current student
     */
    public Student getStudent() {
        return student;
    }
    /**
     * Grades getter.
     * @return current grades
     */
    public List<GradebookItem> getGrades() {
        return grades;
    }
    /**
     * Name setter.
     * @param newName new name
     */
    public void setName(final String newName) {
        name = newName;
    }
    /**
     * Weight setter.
     * @param newWeight new weight
     */
    public void setWeight(final double newWeight) {
        weight = newWeight;
    }
    /**
     * Student setter.
     * @param newStudent new student
     */
    public void setStudent(final Student newStudent) {
        student = newStudent;
    }
    /**
     * Grades setter.
     * @param newGrades new grades
     */
    public void setGrades(final List<GradebookItem> newGrades) {
        grades = newGrades;
        if (grades == null) {
            grades = new ArrayList<GradebookItem>();
        }
    }
    /**
     * Adds a GradebookItem to the list.
     * @param newGrade Item to be added.
     */
    public void addGrade(final GradebookItem newGrade) {
        grades.add(newGrade);
    }

    @Override
    public double getScore() {
        return this.getAverageScore(grades);
    }

    @Override
    public LetterGrade getLetterGrade() {
        return this.getAverageLetterGrade(grades);
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
