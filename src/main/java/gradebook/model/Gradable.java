package gradebook.model;
/**
 * Forces implementing classes to have numerical scores and letter grades.
 * Intended for use with GradedGroup.
 * With GradedGroup, plays a form of Abstract Factory design pattern, allowing
 * GradedGroups to report data uniformly.
 */
public interface Gradable extends Comparable<Gradable> {
    /**
     * Returns a double to be treated as the numerical score.
     * @return numerical score
     */
    double getScore();
    /**
     * Returns the letter grade, in the form of the enum type LetterGrade.
     * @return letter grade
     */
    LetterGrade getLetterGrade();

    /**
     * Gets the weight of the item, if applicable (otherwise it's 1).
     * @return weight
     */
    double getWeight();
}
