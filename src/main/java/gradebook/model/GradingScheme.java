package gradebook.model;

/**
 * A grading scheme used by some GradedGroup.  Contains useful information for
 * the GradedGroup stored in an easily modifiable way.
 * @author Kyle Z
 */
public final class GradingScheme {
    /**
     * Minimum percentage score for a grade to be considered an A.
     */
    private double aCutOff;
    /**
     * Minimum percentage score for a grade to be considered an B.
     */
    private double bCutOff;
    /**
     * Minimum percentage score for a grade to be considered an C.
     */
    private double cCutOff;
    /**
     * Minimum percentage score for a grade to be considered an D.
     */
    private double dCutOff;
    /**
     * Number of grades dropped from the list (lowest ones first).
     */
    private int numberDropped;

    /**
     * Base Constructor for a GradingScheme.
     * @param minA Minimum A score
     * @param minB Minimum B score
     * @param minC Minimum C score
     * @param minD Minimum D score
     * @param numDropped number of dropped grades
     */
    public GradingScheme(final double minA, final double minB,
            final double minC, final double minD, final int numDropped) {
        aCutOff = minA;
        bCutOff = minB;
        cCutOff = minC;
        dCutOff = minD;
        numberDropped = numDropped;
    }
    /**
     * Simpler Constructor, only used for changing letter grade cutoffs.
     * @param minA Minimum A score
     * @param minB Minimum B score
     * @param minC Minimum C score
     * @param minD Minimum D score
     */
    public GradingScheme(final double minA, final double minB,
            final double minC, final double minD) {
        this(minA, minB, minC, minD, 0);
    }
    /**
     * Default Constructor, uses default grade cutoffs found in LetterGrade.
     */
    public GradingScheme() {
        this(LetterGrade.A_CUT_OFF, LetterGrade.B_CUT_OFF,
                LetterGrade.C_CUT_OFF, LetterGrade.D_CUT_OFF, 0);
    }
    /**
     * aCutOff getter.
     * @return current aCutOff
     */
    public double getACutOff() {
        return aCutOff;
    }
    /**
     * bCutOff getter.
     * @return current bCutOff
     */
    public double getBCutOff() {
        return bCutOff;
    }
    /**
     * cCutOff getter.
     * @return current cCutOff
     */
    public double getCCutOff() {
        return cCutOff;
    }
    /**
     * dCutOff getter.
     * @return current dCutOff
     */
    public double getDCutOff() {
        return dCutOff;
    }
    /**
     * numberDropped getter.
     * @return current numberDropped
     */
    public int getNumberDropped() {
        return numberDropped;
    }
    /**
     * aCutOff setter.
     * @param newACutOff new aCutOff
     */
    public void setACutOff(final double newACutOff) {
        aCutOff = newACutOff;
    }
    /**
     * bCutOff setter.
     * @param newBCutOff new bCutOff
     */
    public void setBCutOff(final double newBCutOff) {
        bCutOff = newBCutOff;
    }
    /**
     * cCutOff setter.
     * @param newCCutOff new cCutOff
     */
    public void setCCutOff(final double newCCutOff) {
        cCutOff = newCCutOff;
    }
    /**
     * dCutOff setter.
     * @param newDCutOff new dCutOff
     */
    public void setDCutOff(final double newDCutOff) {
        dCutOff = newDCutOff;
    }
    /**
     * numberDropped setter.
     * @param newNumberDropped new numberDropped
     */
    public void setNumberDropped(final int newNumberDropped) {
        numberDropped = newNumberDropped;
    }
}
