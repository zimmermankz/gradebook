package gradebook.model;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Includes methods to calculate average score and letter grade.
 * With Gradable, plays a form of Template Method design pattern, using
 * information from Gradables to report data uniformly.
 * @author Kyle Z
 */
public abstract class GradedGroup {
    /**
     * The grading scheme to be used when grading the group.  Is never null,
     * instead uses a default object.
     */
    private GradingScheme scheme = new GradingScheme();

    /**
     * Averages the scores of a list of gradables.
     * @param gradables List to be averaged together
     * @return average score
     */
    protected final double getAverageScore(
            final List<? extends Gradable> gradables) {
        if (gradables.size() != 0) {
            PriorityQueue<Gradable> pq = new PriorityQueue<Gradable>();
            for (int i = 0; i < gradables.size(); i++) {
                pq.add(gradables.get(i));
            }
            if (scheme.getNumberDropped() > 0 && gradables.size() != 1) {
                for (int i = 0; i < Math.min(scheme.getNumberDropped(),
                        gradables.size() - 1); i++) {
                    pq.poll();
                }
            }
            double totalScore = 0;
            double totalWeights = 0;
            for (Gradable gradable : pq) {
                totalScore += (gradable.getScore() * gradable.getWeight());
                totalWeights += gradable.getWeight();
            }
            return totalScore / totalWeights;
        } else {
            return 0.0;
        }
    }

    /**
     * Averages the letter grades of a list of gradables.
     * @param gradables List to be averaged together
     * @return average letter grade
     */
    protected final LetterGrade getAverageLetterGrade(
            final List<? extends Gradable> gradables) {
        if (gradables.size() != 0) {
            return LetterGrade.convertToLetterGrade(getAverageScore(gradables),
                    scheme.getACutOff(), scheme.getBCutOff(),
                    scheme.getCCutOff(), scheme.getDCutOff());
        } else {
            return LetterGrade.F;
        }
    }
    /**
     * Scheme getter.
     * @return current scheme
     */
    public final GradingScheme getScheme() {
        return scheme;
    }
    /**
     * Scheme setter.  Never sets scheme to null, instead will set it to the
     * default object.
     * @param newScheme new scheme
     */
    public final void setScheme(final GradingScheme newScheme) {
        if (newScheme != null) {
            scheme = newScheme;
        } else {
            scheme = new GradingScheme();
        }
    }
}
