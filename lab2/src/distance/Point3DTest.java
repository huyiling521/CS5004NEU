package distance;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

/**
 * A JUnit test class for the Point3D class
 */
class Point3DTest {

    Point3D point1;
    Point3D point2;

    @BeforeEach
    void setUp() {
        this.point1 = new Point3D();
        this.point2 = new Point3D(10, 5, 8);
    }

    @Test
    void testEquals() {
        assertFalse(point1.equals(point2));
        Point3D point3 = new Point3D();
        assertTrue(point1.equals(point3));
        Point3D point4 = new Point3D(10, 5, 8);
        assertTrue(point2.equals(point4));
    }

    @Test
    void testHashCode() {
        assertNotEquals(point1.hashCode(), point2.hashCode());
        Point3D point3 = new Point3D();
        Point3D point4 = new Point3D(10, 5, 8);
        assertEquals(point4.hashCode(), point2.hashCode());
        assertEquals(point3.hashCode(), point1.hashCode());
    }

    @Test
    void testDistanceTo() {
        assertEquals(13.747727, point1.distanceTo(point2), 0.0001);
        Point3D point3 = new Point3D(3, 8, -12);
        assertEquals(21.400934, point2.distanceTo(point3), 0.0001);
        assertEquals(14.730919, point3.distanceTo(point1), 0.0001);
    }

    @Test
    void testGetX() {
        assertEquals(0, point1.getX());
        assertEquals(10, point2.getX());
    }

    @Test
    void testGetY() {
        assertEquals(0, point1.getY());
        assertEquals(5, point2.getY());
    }

    @Test
    void testGetZ() {
        assertEquals(0, point1.getZ());
        assertEquals(8, point2.getZ());
    }
}