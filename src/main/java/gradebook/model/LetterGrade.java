package gradebook.model;
/**
 * LetterGrade is used to keep track of letter grades for Students.
 * @author Kyle Z
 */
public enum LetterGrade {
    A, B, C, D, F;

    /**
     * The default minimum percentage grade that is considered an A.
     */
    public static final double A_CUT_OFF = 90;
    /**
     * The default minimum percentage grade that is considered a B.
     */
    public static final double B_CUT_OFF = 80;
    /**
     * The default minimum percentage grade that is considered a C.
     */
    public static final double C_CUT_OFF = 70;
    /**
     * The default minimum percentage grade that is considered a D.
     */
    public static final double D_CUT_OFF = 60;

    /**
     * Converts a percentage score into a LetterGrade, using default cutoffs.
     * @param score Percentage score to be converted
     * @return LetterGrade conversion
     */
    public static LetterGrade convertToLetterGrade(final double score) {
        if (score >= A_CUT_OFF) {
            return LetterGrade.A;
        } else if (score >= B_CUT_OFF) {
            return LetterGrade.B;
        } else if (score >= C_CUT_OFF) {
            return LetterGrade.C;
        } else if (score >= D_CUT_OFF) {
            return LetterGrade.D;
        } else {
            return LetterGrade.F;
        }
    }
    /**
     * Converts a percentage score into a LetterGrade, using specified cutoffs.
     * @param score Percentage score to be converted
     * @param aCutOff Cutoff for A grade
     * @param bCutOff Cutoff for B grade
     * @param cCutOff Cutoff for C grade
     * @param dCutOff Cutoff for D grade
     * @return LetterGrade conversion
     */
    public static LetterGrade convertToLetterGrade(final double score,
            final double aCutOff, final double bCutOff, final double cCutOff,
            final double dCutOff) {
        if (score >= aCutOff) {
            return LetterGrade.A;
        } else if (score >= bCutOff) {
            return LetterGrade.B;
        } else if (score >= cCutOff) {
            return LetterGrade.C;
        } else if (score >= dCutOff) {
            return LetterGrade.D;
        } else {
            return LetterGrade.F;
        }
    }
}
