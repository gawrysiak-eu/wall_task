# Wall Task


This is my version of implementing the methods from the Wall class.
The recruitment task involves implementing methods for a `Wall` class that implements the `Structure` interface, considering the structure of blocks, including composite blocks.

## Structure Interface

### `findBlockByColor(String color): Optional<Block>`
- Returns an optional containing any block with the specified color.

### `findBlocksByMaterial(String material): List<Block>`
- Returns a list of all blocks with the specified material.

### `count(): int`
- Returns the total number of blocks in the structure.

## Wall Class

The `Wall` class is designed to handle a list of blocks and implements the `Structure` interface. It includes methods to find blocks by color, material, and count the total number of blocks.

### Implementation Details

- **findBlockByColor**: Utilizes a stream to filter blocks based on the color and checks recursively within composite blocks.

- **findBlocksByMaterial**: Utilizes a stream to flatMap and collect blocks recursively based on the specified material.

- **count**: Utilizes a stream to map the blocks to an integer stream, considering composite blocks.

### Usage

The `Wall` class can be instantiated with a list of blocks, and then the implemented methods can be used to analyze the structure.

### Exception Handling

The methods throw `IllegalArgumentException` if the provided color or material is `null`.

### Important Note

This implementation avoids code duplication by using recursion and stream operations to handle both normal and composite blocks.

#

Author: GG
