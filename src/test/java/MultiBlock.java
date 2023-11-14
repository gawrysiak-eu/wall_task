import java.util.List;

record MultiBlock(String color, String material, List<Block> blocks) implements CompositeBlock {
}