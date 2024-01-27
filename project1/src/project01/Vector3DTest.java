package project01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project01.Vector3D;

import static org.junit.jupiter.api.Assertions.*;

class Vector3DTest {
    Vector3D v;
    Vector3D u;
    @BeforeEach
    void setUp() {
        this.v = new Vector3D(1,2,3);
        this.u = new Vector3D(-5,-8,10);
    }

    @Test
    void getMagnitude() {
        assertEquals(3.741657386, this.v.getMagnitude(), 6);
        assertEquals(13.747727084, this.u.getMagnitude(), 6);
    }

    @Test
    void normalize() {
        Vector3D newV = this.v.normalize();
        Vector3D newU = this.u.normalize();
        assertTrue(newV.equals(new Vector3D(1/Math.sqrt(14), 2/Math.sqrt(14), 3/Math.sqrt(14))));
        assertTrue(newU.equals(new Vector3D(-5/Math.sqrt(189), -8/Math.sqrt(189), 10/Math.sqrt(189))));
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Vector3D test = new Vector3D(0,0,0);
            test.normalize();
        });
        assertEquals("This is the origin, not a valid vector that can be normalized.", thrown.getMessage());
    }

    @Test
    void add() {
        Vector3D res = this.v.add(this.u);
        assertEquals(-4, res.getX());
        assertEquals(-6, res.getY());
        assertEquals(13, res.getZ());
    }

    @Test
    void multiply() {
        Vector3D res1 = this.v.multiply(3.5);
        assertEquals(3.5, res1.getX());
        assertEquals(7, res1.getY());
        assertEquals(10.5, res1.getZ());

        Vector3D res2 = this.u.multiply(-10);
        assertEquals(50, res2.getX());
        assertEquals(80, res2.getY());
        assertEquals(-100, res2.getZ());
    }

    @Test
    void dotProduct() {
        assertEquals(9, this.v.dotProduct(this.u));
    }

    @Test
    void angleBetween() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            Vector3D test = new Vector3D(0,0,0);
            Vector3D.angleBetween(this.v, test);
        });
        assertEquals("There exists invalid vector, the computation cannot be completed.", thrown.getMessage());
        assertEquals(Math.toDegrees(9/(Math.sqrt(14) * Math.sqrt(189))), Vector3D.angleBetween(this.v, this.u));
    }

    @Test
    void crossProduct() {
        Vector3D cross1 = this.v.crossProduct(this.u);
        assertEquals(new Vector3D(44, -25,2), cross1);

        Vector3D cross2 = this.u.crossProduct(this.v);
        assertEquals(new Vector3D(-44, 25,-2), cross2);
    }

    @Test
    void getX() {
        assertEquals(1,this.v.getX());
        assertEquals(-5,this.u.getX());
    }

    @Test
    void getY() {
        assertEquals(2,this.v.getY());
        assertEquals(-8,this.u.getY());
    }

    @Test
    void getZ() {
        assertEquals(3,this.v.getZ());
        assertEquals(10,this.u.getZ());
    }
}