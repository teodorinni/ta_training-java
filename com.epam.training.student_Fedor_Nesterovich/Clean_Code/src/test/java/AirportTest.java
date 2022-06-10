import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;
import specifications.ClassificationLevels;
import specifications.ExperimentalTypes;
import specifications.MilitaryPlaneTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryPlaneTypes.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryPlaneTypes.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryPlaneTypes.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevels.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VERTICAL_TAKEOFF_AND_LANDING, ClassificationLevels.TOP_SECRET)
    );

    private static PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertSame(militaryPlane.getPlanePurpose(), MilitaryPlaneTypes.TRANSPORT);
        }

    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testPlanesSortedByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        int previousPlaneMaxLoadCapacity = planesSortedByMaxLoadCapacity.get(0).getMaxLoadCapacity();
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (Plane plane : planesSortedByMaxLoadCapacity) {
            if (plane.getMaxLoadCapacity() >= previousPlaneMaxLoadCapacity) {
                previousPlaneMaxLoadCapacity = plane.getMaxLoadCapacity();
            } else {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            if ((militaryPlane.getPlanePurpose() == MilitaryPlaneTypes.BOMBER)) {
                Assert.assertSame(militaryPlane.getPlanePurpose(), MilitaryPlaneTypes.BOMBER);
                break;
            }
        }
    }

    @Test
    public void testExperimentalPlanesHasUnclassifiedPlanes() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for ( ExperimentalPlane ExperimentalPlane : experimentalPlanes) {
            if (ExperimentalPlane.getClassificationLevel() == ClassificationLevels.UNCLASSIFIED) {
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
