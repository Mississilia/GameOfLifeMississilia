import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})

import java.util.Arrays;

public class GameOfLifeTests {

    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }


    @Test
    public void foundsNoLivingNeighboursInAnEmptyGrid() {

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(0));
    }

    @Test
    public void foundsOneLivingNeighbour() {

        gameOfLife.setLivingCell(0, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(1));
    }


    @Test
    public void foundsTwoLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(2));
    }


    @Test
    public void foundsThreeLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(3));
    }

    @Test
    public void foundsFourLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(4));
    }

    @Test
    public void foundsFiveLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(5));
    }

    @Test
    public void foundsSixLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(6));
    }


    @Test
    public void foundsSevenLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(7));
    }

    @Test
    public void foundsHeightLivingNeighbours() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.setLivingCell(2, 5);
        gameOfLife.setLivingCell(2, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(1, 3);

        int neighboursCount = gameOfLife.countlivingNeighbours(1, 4);

        Assert.assertThat(neighboursCount, CoreMatchers.is(8));
    }

    @Test
    public void foundsThreeLivingNeighboursForTheTopLeftCornerCell() {

        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.setLivingCell(1, 0);

        int neighboursCount = gameOfLife.countlivingNeighbours(0, 0);

        Assert.assertThat(neighboursCount, CoreMatchers.is(3));
    }

    @Test
    public void foundsThreeLivingNeighboursForTheBottomRightCornerCell() {

        gameOfLife.setLivingCell(3, 6);
        gameOfLife.setLivingCell(2, 6);
        gameOfLife.setLivingCell(2, 7);

        int neighboursCount = gameOfLife.countlivingNeighbours(3, 7);

        Assert.assertThat(neighboursCount, CoreMatchers.is(3));
    }

    @Test
    public void aCellWithFewerThanTwoNeighboursDies() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);

        gameOfLife.computeNextGeneration();

        Assert.assertThat(gameOfLife.isDead(0,0), CoreMatchers.is(Boolean.TRUE));
    }


    @Test
    public void aCellWithAtLeastTwoNeighboursLives() {

        gameOfLife.setLivingCell(0, 0);
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);

        gameOfLife.computeNextGeneration();

        Assert.assertThat(gameOfLife.isAlive(0,0), CoreMatchers.is(Boolean.TRUE));
    }


    @Test
    public void aCellWithMoreThanThreeNeighboursDies() {

        gameOfLife.setLivingCell(1, 4);
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);

        gameOfLife.computeNextGeneration();
        Assert.assertThat(gameOfLife.isDead(1,4), CoreMatchers.is(Boolean.TRUE));

    }


    @Test
    public void aDeadCellWithThreeNeighboursGetsAlive() {

        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);

        gameOfLife.computeNextGeneration();

        Assert.assertThat(gameOfLife.isAlive(1,4), CoreMatchers.is(Boolean.TRUE));
    }

    @Test
    public void testAnHandMadeGrid() {

        gameOfLife.setLivingCell(1, 4);
        gameOfLife.setLivingCell(2, 3);
        gameOfLife.setLivingCell(2, 4);

        gameOfLife.computeNextGeneration();

        int [][] expectedGrid = new int[][]{
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.LIVING_CELL, GameOfLife.LIVING_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL},
                {GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL, GameOfLife.DEAD_CELL}
        };
        Assert.assertThat(Arrays.deepEquals(gameOfLife.grid, expectedGrid), CoreMatchers.is(Boolean.TRUE));
    }

    private GameOfLife gameOfLife;
}