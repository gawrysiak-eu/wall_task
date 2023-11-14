import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = new ArrayList<>(blocks);
    }


    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("Material cannot be null");
        }
        return blocks.stream()
                .flatMap(block -> findAllBlocksByMaterialRecursive(block, material).stream())
                .toList();
    }


    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        return blocks.stream()
                .filter(block -> findBlockByColorRecursive(block, color))
                .findFirst();
    }

    private boolean findBlockByColorRecursive(Block block, String color) {
        if (block.getColor().equals(color)) {
            return true;
        }
        if (block instanceof CompositeBlock compositeBlock) {
            for (Block subBlock : compositeBlock.getBlocks()) {
                if (findBlockByColorRecursive(subBlock, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Block> findAllBlocksByMaterialRecursive(Block block, String material) {
        List<Block> foundBlocks = new ArrayList<>();
        if (block.getMaterial().equals(material)) {
            foundBlocks.add(block);
        }
        if (block instanceof CompositeBlock compositeBlock) {
            compositeBlock.getBlocks()
                    .stream()
                    .flatMap(subBlock -> findAllBlocksByMaterialRecursive(subBlock, material).stream())
                    .forEach(foundBlocks::add);
        }
        return foundBlocks;
    }

    @Override
    public int count() {
        return blocks.stream()
                .mapToInt(this::countRecursive)
                .sum();
    }

    private int countRecursive(Block block) {
        if (block instanceof CompositeBlock compositeBlock) {
            return 1 + compositeBlock.getBlocks()
                    .stream()
                    .mapToInt(this::countRecursive)
                    .sum();
        }
        return 1;
    }

}