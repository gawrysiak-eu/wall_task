


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTestSuite {

    private static List<Block> blocks;

    @BeforeAll
    static void createTestData() {
        blocks = new ArrayList<>();
        blocks.add(new NormalBlock("Gray", "Metal"));
        blocks.add(new NormalBlock("Gray", "Cement"));
        blocks.add(new NormalBlock("Brown", "Wood"));
        List<Block> multiList = List.of(
                new NormalBlock("Blue", "Plastic"),
                new NormalBlock("Blue", "Plastic"),
                new NormalBlock("Blue", "Plastic"));
        MultiBlock multi1 = new MultiBlock("Blue", "Plastic", multiList);
        blocks.add(multi1);
        List<Block> multiList2 = List.of(
                new NormalBlock("Yellow", "Gold"),
                new NormalBlock("Yellow", "Gold"),
                new NormalBlock("Yellow", "Gold"));
        MultiBlock multi2 = new MultiBlock("Yellow", "Gold", multiList2);
        blocks.add(multi2);
    }

    @Test
    void testFindBlockByColor() {
        // given
        Wall wall = new Wall(blocks);
        // when
        Optional<Block> grayTest = wall.findBlockByColor("Gray");
        Optional<Block> pinkTest = wall.findBlockByColor("Pink");
        // then
        assertTrue(grayTest.isPresent());
        assertEquals("Gray", grayTest.get().getColor());
        assertFalse(pinkTest.isPresent());
    }

    @Test
    void testFindBlocksByMaterial() {
        // given
        Wall wall = new Wall(blocks);
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
        Wall wall = new Wall(blocks);
        // when
        int countResult = wall.count();
        // then
        assertEquals(11, countResult);
    }

    @Test
    void testFindBlockByColorThrowException() {
        // given
        Wall wall = new Wall(blocks);
        // when and then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(null));
        assertEquals("Color cannot be null", exception.getMessage());
    }

    @Test
    void testFindBlocksByMaterialThrowException() {
        // given
        Wall wall = new Wall(blocks);
        // when and then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(null));
        assertEquals("Material cannot be null", exception.getMessage());
    }

}
