package gradebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Student in some Section.  Contains GradebookCategories which can
 * be averaged together according to their weights.
 * @author Kyle Z
 */
public final class Student extends GradedGroup implements Gradable {
    /**
     * Student's name.
     */
    private String name;
    /**
     * List of the Student's grades.
     */
    private List<GradebookCategory> categories;
    /**
     * Section in which the Student is.
     */
    private Section section;

    /**
     * Full Student Constructor, specifying a GradingScheme.
     * @param newName Student's name
     * @param list List of categories for the Student
     * @param aSection Section in which the Student is
     * @param aScheme GradingScheme for the Student
     */
    public Student(final String newName, final List<GradebookCategory> list,
            final Section aSection, final GradingScheme aScheme) {
        name = newName;
        categories = list;
        if (categories == null) {
            categories = new ArrayList<GradebookCategory>();
        }
        section = aSection;
        setScheme(aScheme);
        if (aSection != null) {
            aSection.addStudent(this);
        }
    }
    /**
     * Basic Student Constructor.  Uses default GradingScheme.
     * @param newName Name of the Student
     * @param list List of categories of grades for the Student
     * @param aSection Section in which the Student is
     */
    public Student(final String newName, final List<GradebookCategory> list,
            final Section aSection) {
        this(newName, list, aSection, new GradingScheme());
    }

    /**
     * Name getter.
     * @return current name
     */
    public String getName() {
        return name;
    }
    /**
     * Categories getter.
     * @return current categories
     */
    public List<GradebookCategory> getCategories() {
        return categories;
    }
    /**
     * Section getter.
     * @return current section
     */
    public Section getSection() {
        return section;
    }
    /**
     * Name setter.
     * @param newName new name
     */
    public void setName(final String newName) {
        name = newName;
    }
    /**
     * Grades setter.
     * @param newCategories new categories
     */
    public void setCategories(final List<GradebookCategory> newCategories) {
        categories = newCategories;
    }
    /**
     * Section setter.
     * @param newSection new section
     */
    public void setSection(final Section newSection) {
        section = newSection;
    }

    @Override
    public double getScore() {
        return this.getAverageScore(categories);
    }
    @Override
    public LetterGrade getLetterGrade() {
        return this.getAverageLetterGrade(categories);
    }
    @Override
    public double getWeight() {
        return 1;
    }

    /**
     * Adds a GradebookCategory to the category list.
     * @param aCategory category to be added
     */
    public void addCategory(final GradebookCategory aCategory) {
        categories.add(aCategory);
        if (categories == null) {
            categories = new ArrayList<GradebookCategory>();
        }
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
