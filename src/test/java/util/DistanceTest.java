package util;

import de.packagingcalculator.util.Distance;
import de.packagingcalculator.util.DistanceUnit;
import org.junit.Ignore;
import org.junit.Test;

import java.util.IllegalFormatException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DistanceTest {

    @Test
    public void DistanceUnitParsingTest() {
        Distance distance = Distance.parse(20.0, DistanceUnit.M);

        assertEquals(distance.getDistance(), 20.0 * 1000.0, 0.0);

        distance = Distance.parse(40.0, DistanceUnit.MM);

        assertEquals(distance.getDistance(), 40.0, 0.0);

        distance = Distance.parse(20.0, DistanceUnit.CM);

        assertEquals(distance.getDistance(), 20.0 * 10.0, 0.0);

        distance = Distance.parse(20.0, DistanceUnit.DM);

        assertEquals(distance.getDistance(), 20.0 * 100.0, 0.0);
    }

    @Test
    @Ignore
    public void DistanceStringParsingTest() {
        Distance distance = Distance.parse("100.0mm");
    }

    @Test(expected = IllegalFormatException.class)
    @Ignore
    public void DistanceStringParsingErrorTest() {

    }

    @Test
    public void DistanceAddTest() {
        Distance distanceA, distanceB;

        distanceA = Distance.parse(10.0, DistanceUnit.CM);
        distanceB = Distance.parse(77.0, DistanceUnit.M);

        Distance result = distanceA.add(distanceB);

        assertEquals(result.getDistance(), 77000.0 + 100.0, 0.0);
    }

    @Test
    public void DistanceSubtractTest() {
        Distance distanceA, distanceB;

        distanceA = Distance.parse(10.0, DistanceUnit.CM);
        distanceB = Distance.parse(77.0, DistanceUnit.M);

        Distance result = distanceB.subtract(distanceA);

        assertEquals(result.getDistance(DistanceUnit.M), 76.9, 0.0);
    }

    @Test
    public void DistanceCompareTest() {
        Distance distanceA, distanceB;

        distanceA = Distance.parse(10.0, DistanceUnit.CM);
        distanceB = Distance.parse(77.0, DistanceUnit.M);

        assertTrue(distanceA.compareTo(distanceB) == -1);


        distanceA = Distance.parse(10.0, DistanceUnit.M);
        distanceB = Distance.parse(10.0, DistanceUnit.M);

        assertTrue(distanceA.compareTo(distanceB) == 0);


        distanceA = Distance.parse(10.0, DistanceUnit.M);
        distanceB = Distance.parse(77.0, DistanceUnit.MM);

        assertTrue(distanceA.compareTo(distanceB) == 1);
    }


}
