Feature: The status of any dead cell at each round of the game
  In order to make sure that Game of life’s rules is respected
  As a developer
  I write the evolution of a dead cell changes each turn of the game 	depending on the statuses of that cell's 8 neighbor

  Scenario: A dead cell with exactly three live neighbours
    Given one dead cell on the grid
    When it has 3 neighbors
    Then the dead cell becomes a live cell
  Example:
  | Dead cell | Neighbours  | Status of the dead cell|
  | 1                | 3                    | alive                 	    |





  Scenario: A dead cell with less or more than three live neighbours
    Given one dead cell on the grid
    When it has les or more than 3 neighbours
    Then the dead cell remains dead
  Example:
  | Dead cell  | Neighbours | Status of the dead cell |
  | 1                | 4                    | dead                                |
  | 1                | 2                    | dead                                |
  | 1                | 8                    | dead                                |
