
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTestSuite {


    @Test
    void testFindBlockByColor() {
        // given
        Wall wall = InMemoryWallFactory.getWall();
        // when
        Optional<Block> grayTest = wall.findBlockByColor("Gray");
        Optional<Block> pinkTest = wall.findBlockByColor("Pink");
        // then
        assertTrue(grayTest.isPresent());
        assertEquals("Gray", grayTest.get().color());
        assertFalse(pinkTest.isPresent());
    }

    @Test
    void testFindBlocksByMaterial() {
        // given
        Wall wall = InMemoryWallFactory.getWall();
        // when
        List<Block> gold = wall.findBlocksByMaterial("Gold");
        List<Block> platinum = wall.findBlocksByMaterial("Platinum");
        // then
        assertEquals(4, gold.size());
        assertEquals(0, platinum.size());
    }

    @Test
    void testCount() {
        // given
        Wall wall = InMemoryWallFactory.getWall();
        // when
        int countResult = wall.count();
        // then
        assertEquals(11, countResult);
    }

    @Test
    void testFindBlockByColorThrowException() {
        // given
        Wall wall = InMemoryWallFactory.getWall();
        // when and then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(null));
        assertEquals("Color cannot be null", exception.getMessage());
    }

    @Test
    void testFindBlocksByMaterialThrowException() {
        // given
        Wall wall = InMemoryWallFactory.getWall();
        // when and then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(null));
        assertEquals("Material cannot be null", exception.getMessage());
    }

}
