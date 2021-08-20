import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ZombieTest {

    Zombie zombie;

    @BeforeEach
    void setUp() {
        zombie = new Zombie();
    }

    @Test
    @DisplayName("Work return with no creature ")
    void workWithCreatureNone() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Work return with creature")
    void workWithCreature() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid grid dimensions")
    void invalidGridDimensions() {
        // Dimensions of the grid (N)
        int gird = -4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid initial position of zombie: x or y larger than grid dimension")
    void invalidInitialPositionOfZombieXOrYLagerThanGird() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {13,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid initial position of zombie: at (x,y,z)")
    void invalidInitialPositionOfZombieIsXYZ() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {1,3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid initial position of zombie: null or empty")
    void invalidInitialPositionOfZombieIsNullOrEmpty() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid initial position of creature: x or y larger than grid dimension")
    void invalidInitialCreatureOfPositionLagerThanGird() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {11,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }


    @Test
    @DisplayName("Invalid initial position of creature: at (x,y,z)")
    void invalidInitialCreatureOfPositionIsXYZ() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{1,0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }


    @Test
    @DisplayName("Invalid initial position of creature: null or empty")
    void invalidInitialPositionOfCreatureIsNullOrEmpty() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRU";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid movement input: not R, L, U or D")
    void invalidMovementInputIsNeitherRLUD() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "RDRUCE";

        Zombie.run(gird, zombie, creatures, move);
    }

    @Test
    @DisplayName("Invalid movement input: null or empty")
    void invalidMovementInputIsNullOrEmpty() {
        // Dimensions of the grid (N)
        int gird = 4;
        // The initial position of the zombie
        int[] zombie = {3,1};
        // A list of initial positions of the creatures
        List<int[]> creatures = new ArrayList<>(Arrays.asList(new int[][]{{0,1}, {1,2}, {1,1}, {2,4}}));
        // A list of moves the zombies will make
        String move = "";

        Zombie.run(gird, zombie, creatures, move);
    }

}