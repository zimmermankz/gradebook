package gradebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class in some Course.  Contains Sections and can calculate their
 * average numerical and letter grades. Plays a Concrete Factory design pattern.
 * @author Kyle Z
 */
public final class Class extends GradedGroup implements Gradable {
    /**
     * The Course of which this Class is part.
     */
    private Course course;
    /**
     * The Sections of this Class.
     */
    private List<Section> sections;

    /**
     * Full Class Constructor, specifying a GradingScheme.
     * @param aCourse Course of which this Class is part
     * @param sectionList Sections of this Class
     * @param aScheme GradingScheme for the Class
     */
    public Class(final Course aCourse, final List<Section> sectionList,
            final GradingScheme aScheme) {
        course = aCourse;
        sections = sectionList;
        if (sections == null) {
            sections = new ArrayList<Section>();
        }
        setScheme(aScheme);
        if (aCourse != null) {
            aCourse.addClass(this);
        }
    }
    /**
     * Basic Class Constructor.  Uses default GradingScheme.
     * @param aCourse Course of which this Class is part
     * @param sectionList Sections of this Class
     */
    public Class(final Course aCourse, final List<Section> sectionList) {
        this(aCourse, sectionList, new GradingScheme());
    }

    @Override
    public double getScore() {
        return getAverageScore(sections);
    }

    @Override
    public LetterGrade getLetterGrade() {
        return getAverageLetterGrade(sections);
    }
    /**
     * Adds a Section to the Section list.
     * @param newSection Section to be added to the list
     */
    public void addSection(final Section newSection) {
        sections.add(newSection);
    }
    /**
     * Course getter.
     * @return current Course
     */
    public Course getCourse() {
        return course;
    }
    /**
     * Section list getter.
     * @return current Sections list
     */
    public List<Section> getSections() {
        return sections;
    }
    /**
     * Course setter.
     * @param newCourse new Course
     */
    public void setCourse(final Course newCourse) {
        course = newCourse;
    }
    /**
     * Section list setter.
     * @param newSections new Section list
     */
    public void setSections(final List<Section> newSections) {
        sections = newSections;
        if (sections == null) {
            sections = new ArrayList<Section>();
        }
    }

    @Override
    public double getWeight() {
        return 1.0;
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
