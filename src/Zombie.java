import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zombie {

    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        int num = 0;
        for(int i = 0; i <= nums.length; i++) {
            for(int j = i+1; j <= nums.length; i++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }
    /**
     * Find zombie's location
     * @param gird
     * @param zombie
     * @param creatures
     * @param move
     */
    public static void run(int gird, int[] zombie, List<int[]> creatures, String move) {
        // Validate input, if false stop program
        if(!isValid(gird, zombie, creatures, move)) return;

        String[] slipMove = move.trim().split("");
        // List zombie infects a creature
        List<int[]> infected = new ArrayList<>();
        // Total zombies
        List<int[]> listZombie = new ArrayList<>();

        String messageZombie = "zombie {0} infected creature at {1}";
        String messageZombieMove = "zombie {0} moved to {1}";
        String messageListZombies = "zombies' positions:";
        String messageListCreatures = "creatures' positions:";

        // Push original zombie to infected
        infected.add(zombie);

        // Position zombie
        int position = 0;
        // Run list infected until it is removed all
        while (infected.size() != 0) {
            zombie = infected.get(0);
            // Loop movement steps
            for (int i = 0; i < slipMove.length; i++) {
                // Zombie move by movement step
                zombie = move(zombie[0], zombie[1], gird, slipMove[i]);
                //Each time a zombie takes a step, the new location should be logged
                formatMessage(messageZombieMove, new Object[] {position, Arrays.toString(zombie)});
                // If a zombie occupies the same square as a creature, the creature is transformed into another zombie.
                if(isExistCreature(creatures, zombie)) {
                    // Add new zombie to infected
                    addZombie(infected, zombie);
                    // Print message zombie infects a creature
                    formatMessage(messageZombie, new Object[] {position, Arrays.toString(zombie)});
                }

                if (i == slipMove.length -1){
                    // Add zombie to total list zombie
                    listZombie.add(zombie);
                }
            }
            // Increase position of zombie
            position ++;
            // Remove a zombie from infected
            infected.remove(0);
        }

        formatMessage("Output: ", new Object[]{});
        // Print message total zombies' position
        formatMessage(messageListZombies, listZombie);
        // Print message list remaining creatures' position
        formatMessage(messageListCreatures, creatures);
    }

    /**
     * Add zombie to infected
     * @param infected
     * @param zombie
     */
    private static void addZombie(List<int[]> infected, int[] zombie) {
        // Add new zombie to infected
        infected.add(zombie);
    }

    /**
     * Zombie move by step
     * @param x
     * @param y
     * @param grid
     * @param move
     * @return New location
     */
    private static int[] move(int x, int y, int grid, String move) {
        int[] moveZombie = new int[2];

        Boolean isMove = false;
        switch(move) {
            case "U":// Up edit y
                if (y == 0) y = grid -1;
                else y = y -1;
                isMove = true;
                break;
            case "D":// Down edit y
                if (y == grid - 1) y = 0;
                else y = y + 1;
                isMove = true;
                break;

            case "L":// Left edit x
                if (x == 0) x = grid -1;
                else x = x - 1;
                isMove = true;
                break;
            case "R":// Right edit x
                if (x == grid -1) x = 0;
                else x = x + 1;
                isMove = true;
                break;
            default:
                moveZombie[0] = x;
                moveZombie[1] = y;
                break;
        }
        if (isMove) {
            moveZombie[0] = x;
            moveZombie[1] = y;
        }

        return moveZombie;

    }

    /**
     * Check a zombie occupies the same square as a creature, the creature is transformed into another zombie.
     * @param creatures
     * @param zombie
     * @return Remove a creature from creatures
     */
    private static Boolean isExistCreature(List<int[]> creatures, int[] zombie) {
        Boolean result = false;
        for (int[] creature: creatures) {
            result = Arrays.equals(creature, zombie);
            if (result) {
                creatures.remove(creature);
                break;
            }
        }
       return result;

    }

    /**
     * Format message with parameter Object[]
     * @param message
     * @param args
     */
    public static void formatMessage(String message, Object[] args)
    {
        String START_TOKEN = "{";
        String END_TOKEN = "}";

        if(message != null)
        {
            int index = 0;
            for(Object arg : args)
            {
                String token = START_TOKEN + String.valueOf(index) + END_TOKEN;
                message = message.replace(token, String.valueOf(arg));
                index ++;
            }
        }

        printMessage(message);
    }

    /**
     * Format message with parameter List<int[]>
     * @param message
     * @param args
     */
    public static void formatMessage(String message, List<int[]> args)
    {
        String convertMessage = "";
        String comma = ",";
        printMessage(message);
        if(message != null && args.size() > 0)
        {
            for(int[] arg : args)
            {
                convertMessage += Arrays.toString(arg) + comma;
            }
        }
        if(convertMessage.endsWith(comma))
        {
            convertMessage = convertMessage.substring(0,convertMessage.length() - 1);
        }
        if (args.size() == 0) convertMessage = "none";
        printMessage(convertMessage);

    }

    /**
     * Print message
     * @param message
     */
    public static void printMessage(String message)
    {
        String START_SINGLE_SQUARE_BRACKET = "\\[";
        String END_SINGLE_SQUARE_BRACKET = "]";

        if(message != null)
        {
            message = message.replaceAll(START_SINGLE_SQUARE_BRACKET, "(");
            message = message.replaceAll(END_SINGLE_SQUARE_BRACKET, ")");
        }

        System.out.println(message);
    }


    /**
     * Validate input
     * @param gird
     * @param zombie
     * @param creatures
     * @param move
     * @return status
     */
    public static Boolean isValid(int gird, int[] zombie, List<int[]> creatures, String move) {
        Boolean result = true;
        String constantMovement = "UDLR";
        String messageErrorSizePosition = "{0} is an invalid initial position for {1}";

        // Validate gird
        if (gird < 0) {
            result = false;
            formatMessage("Invalid grid dimensions", new Object[]{});
        }
        // Validate zombie
        if(result && zombie.length != 2) {
            result = false;
            formatMessage(messageErrorSizePosition, new Object[]{Arrays.toString(zombie), "zombie"});
        }
        if(result && zombie.length == 2 ) {

            if(validateArray(zombie, gird)) {
                result = false;

                formatMessage(messageErrorSizePosition, new Object[]{Arrays.toString(zombie), "zombie"});
            }

        }

        // Validate creatures
        if(result && creatures.size() > 0) {
            for (int[] create: creatures) {
                // Validate create
                if(create.length != 2) {
                    result = false;
                    formatMessage(messageErrorSizePosition, new Object[]{Arrays.toString(create), "creature"});
                }
                if(result && create.length == 2 ) {

                    if(validateArray(create, gird)) {
                        result = false;

                        formatMessage(messageErrorSizePosition, new Object[]{Arrays.toString(create), "creature"});
                    }

                }
            }

        }

        // Validate creatures
        if(result && (move == null || move.trim().isEmpty())) {
            result = false;

            formatMessage("({0}) is an invalid movement sequence", new Object[]{move});
        }
        if(result && move != null && !move.isEmpty()) {
            String[] slipMove = move.trim().split("");

            for (String m: slipMove) {
                if (!constantMovement.contains(m)) {
                    formatMessage("({0}) is an invalid movement sequence", new Object[]{move});
                    result = false;
                    break;

                }
            }

        }

        return result;
    }

    /**
     * Validate array
     * @param zombie
     * @param gird
     * @return status
     */
    public static Boolean validateArray(int[] zombie, int gird) {
        boolean result = Arrays.stream(zombie)
                .anyMatch(x -> x < 0 || x > gird);
        return result;
    }
}