import java.util.ArrayList;
import java.util.List;

class InMemoryWallFactory {

    private static List<Block> blocks;

    public static Wall getWall(){
        return new Wall(getBlocks());
    }

    private static List<Block> getBlocks(){
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
        return blocks;
    }
}
