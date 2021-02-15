Feature: The status of any dead cell at each round of the game
  In order to make sure that Game of life’s rules is respected
  As a developer
  I write the evolution of a dead cell changes each turn of the game 	depending on the statuses of that cell's 8 neighbor


  Scenario: A dead cell with exactly three live neighbours
    Given one dead cell on the grid
    When it has three neighbors
    Then the dead cell becomes a live cell


  Scenario: A dead cell with less or more than three live neighbours
    Given one cell on the grid
    When it has less or more than three neighbours
    Then the dead cell remains dead