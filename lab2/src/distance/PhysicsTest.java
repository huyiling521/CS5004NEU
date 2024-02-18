package distance;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for the Physics class
 */
class PhysicsTest {

    @Test
    void testVelocity() {
        Point3D point1 = new Point3D();
        Point3D point2 = new Point3D(10, 5, 8);
        assertThrows(IllegalArgumentException.class, () -> {
            Physics.velocity(point1, point2, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Physics.velocity(point1, point2, -8);
        });
        assertDoesNotThrow(() -> Physics.velocity(point1, point2, 8));
    }
}