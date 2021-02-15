Feature: The status of any living cell at each round of the game
  In order to make sure that Game of life’s rules is respected
  As a developer
  I write the evolution of living cell changes each turn of the game depending on the statuses of that cell's 8 neighbor


  Scenario: Living cell with fewer than two live neighbours
    Given one live cell on the grid
    When it has fewer than two live neighbours
    Then the live cell dies caused by underpopulation



  Scenario: Living cell with two or three live neighbours
    Given one live cell on the grid with two or three neighbours
    When it has two or three live neighbours
    Then the live cell is alive on to the next generation


  Scenario: Living cell with more than three live neighbours
    Given one live cell on the grid with more than three live neighbours
    When it has more than three neighbors
    Then the live cell is dead as if by overcrowding



