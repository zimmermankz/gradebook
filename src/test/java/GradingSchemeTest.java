import static org.junit.Assert.*;
import gradebook.model.GradingScheme;

import org.junit.Test;

public class GradingSchemeTest {
    GradingScheme gs = new GradingScheme();

    @Test
    public void testFullConstructor() {
        GradingScheme scheme = new GradingScheme(80, 70, 60, 50, 1);
        assertEquals(80, scheme.getACutOff(), .0001);
        assertEquals(70, scheme.getBCutOff(), .0001);
        assertEquals(60, scheme.getCCutOff(), .0001);
        assertEquals(50, scheme.getDCutOff(), .0001);
        assertEquals(1, scheme.getNumberDropped());
    }

    @Test
    public void testBasicConstructor() {
        GradingScheme scheme = new GradingScheme(80, 70, 60, 50);
        assertEquals(80, scheme.getACutOff(), .0001);
        assertEquals(70, scheme.getBCutOff(), .0001);
        assertEquals(60, scheme.getCCutOff(), .0001);
        assertEquals(50, scheme.getDCutOff(), .0001);
    }

    @Test
    public void testDefaultConstructor() {
        GradingScheme scheme = new GradingScheme();
        assertEquals(90, scheme.getACutOff(), .0001);
        assertEquals(80, scheme.getBCutOff(), .0001);
        assertEquals(70, scheme.getCCutOff(), .0001);
        assertEquals(60, scheme.getDCutOff(), .0001);
    }

    @Test
    public void testGetACutOff() {
        assertEquals(90, gs.getACutOff(), .0001);
    }

    @Test
    public void testGetBCutOff() {
        assertEquals(80, gs.getBCutOff(), .0001);
    }

    @Test
    public void testGetCCutOff() {
        assertEquals(70, gs.getCCutOff(), .0001);
    }

    @Test
    public void testGetDCutOff() {
        assertEquals(60, gs.getDCutOff(), .0001);
    }

    @Test
    public void testGetNumberDropped() {
        assertEquals(0, gs.getNumberDropped());
    }

    @Test
    public void testSetACutOff() {
        gs.setACutOff(85);
        assertEquals(85, gs.getACutOff(), .0001);
    }

    @Test
    public void testSetBCutOff() {
        gs.setBCutOff(75);
        assertEquals(75, gs.getBCutOff(), .0001);
    }

    @Test
    public void testSetCCutOff() {
        gs.setCCutOff(65);
        assertEquals(65, gs.getCCutOff(), .0001);
    }

    @Test
    public void testSetDCutOff() {
        gs.setDCutOff(55);
        assertEquals(55, gs.getDCutOff(), .0001);
    }

    @Test
    public void testSetNumberDropped() {
        gs.setNumberDropped(5);
        assertEquals(5, gs.getNumberDropped());
    }

}
