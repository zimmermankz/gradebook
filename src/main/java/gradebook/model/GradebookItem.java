package gradebook.model;

/**
 * A graded item for a Student.  Its weight in the Student's score is
 * determined by the GradebookCategory's weight.
 * @author Kyle Z
 */
public final class GradebookItem implements Gradable {
    /**
     * Name of the item.
     */
    private String name;
    /**
     * Category to which the item belongs.
     */
    private GradebookCategory category;
    /**
     * Percentage score for the item, out of 100.
     */
    private double score;

    /**
     * GradebookItem Constructor.
     * @param newName name of the item
     * @param aCategory GradebookCategory to which the item belongs
     * @param newScore score of the item
     */
    public GradebookItem(final String newName,
            final GradebookCategory aCategory, final double newScore) {
        name = newName;
        category = aCategory;
        score = newScore;
        if (aCategory != null) {
            aCategory.addGrade(this);
        }
    }

    /**
     * Name getter.
     * @return current name
     */
    public String getName() {
        return name;
    }
    /**
     * Category getter.
     * @return current category
     */
    public GradebookCategory getCategory() {
        return category;
    }
    @Override
    public double getScore() {
        return score;
    }
    /**
     * Name setter.
     * @param newName new name
     */
    public void setName(final String newName) {
        name = newName;
    }
    /**
     * Category setter.
     * @param newCategory new category
     */
    public void setCategory(final GradebookCategory newCategory) {
        category = newCategory;
    }
    /**
     * Score setter.
     * @param newScore new score
     */
    public void setScore(final double newScore) {
        score = newScore;
    }

    @Override
    public LetterGrade getLetterGrade() {
        return LetterGrade.convertToLetterGrade(score);
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
