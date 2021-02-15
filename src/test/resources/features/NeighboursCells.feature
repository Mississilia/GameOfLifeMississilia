Feature: non-neighbouring cell

  Scenario: A live or dead cell with three live neighbours but they’re dead
    Given one live or dead cell on the grid
    When it has 3 neighbours
    Then live or dead cell is dead

  Example:
  | x |- | x |
  | - | - | - |
  | x | - | - |
  | - | x | - |
