# Zombie Apocalypse v4.6.1
Zombie invasion algorithm

## Solution Highlight
```
1. The program makes sure it will complete the last zombie and its movement by
- Step 1: Create a queue that holds zombie
- Step 2: Each time a zombie moves, the program will check creature list. If zombie occupies the same position as creature, it will move that creature to zombie queue 
- Step 3: After zombie has completed its movement, the program will remove it from zombie queue 
- Step 4: The program runs the next zombie in zombie queue until there is no more in the queue
2. Validation for input
- The program ensures all inputs will be validated before running.
 
```

## Technical Specs
```
1. Language: Java 8
2. Test: JUnit 5 
```

## Tools
```
1. Code Java: IntelliJIDEA
```

## Assumption
```
- There’s always one zombie to start with, called Z0 
- There’s at least one creature to start with, called C1 
- There is no more than one zombie moving at the same time
- Newly created zombies move in the order of infection 
- Right (R), Left (L), Up (U),Down (D), are the only valid movements   
- Grid dimensions must be a whole number, and must be greater than 0 
- Initial position of zombie must be in grid 
- Initial position of creatures must be in grid
- Mandatory inputs: 
 + Dimensions of grid
 + Initial position of zombie
 + Initial position of creatures
 + List of moves the zombies will make 
```

## Test Scenario
### 1. Scenario Outline: Valid inputs 
```
Given all inputs are valid then 
- the program will run 
- Log will show 
 + the new position each time a zombie takes a step (x,y)
 + the location each time a zombie infected a creature (x,y)
- Output will show 
 + Final zombies’ positions (if available): (x,y)
 + Final creatures’ positions (if available): (x,y) 
```
### 2. Scenario Outline: Invalid grid dimensions
```
When grid dimension input is a whole number less than 1
Then the program will not run and return below error message in Output 
“Invalid grid dimensions” 
```
### 3. Scenario Outline: Invalid initial position of zombie
```
1. When the input for zombie’s initial position is (x,y) where x or y larger than grid dimension input 
Then the program will not run and return below error message in Output 
“(x,y) is an invalid initial position for zombie” 
2. When the input for zombie’s initial position is (x,y,z)
Then the program will not run and return below error message in Output 
“(x,y,z) is an invalid initial position for zombie” 
3. When the input for zombie’s initial position is null or empty 
Then the program will not run and return below error message in Output 
“() is an invalid initial position for zombie” 
```
### 4. Scenario Outline: Invalid initial position of creatures
```
1. When the input for any creatures’ initial position is (x,y), where x or y larger than grid dimension input 
Then the program will not run and return below error message in Output 
“(x,y) is an invalid initial position for creatures” 
2. When the input for any creatures’ initial position is (x,y,z)
Then the program will not run and return below error message in Output 
“(x,y,z) is an invalid initial position for creatures 
3. When the input for any creatures’ initial position is null or empty 
Then the program will not run and return below error message in Output 
“() is an invalid initial position for creatures” 
```
### 5. Scenario Outline: Invalid movement 
```
1. When movement input is neither R, L, U or D
Then the program will not run and return below error message in Output 
“(Move) is an invalid movement sequence”
2. When movement input is null or empty
Then the program will not run and return below error message in Output 
“() is an invalid movement sequence”
```

## Test Instruction
1. The automation test covers all scenario listed above
2. Access test file path: zombie/test/ZombieTest.java
3. Run test: Select Run -> Run 'ZombieTest'
4. Test result: in the console -> select display name to view result
