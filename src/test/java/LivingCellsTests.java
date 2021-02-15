import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

public class LivingCellsTests {
    private GameOfLife gameOfLife;

    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }



    @Given("one live cell on the grid")
    public void oneLiveCellOnTheGrid() {
        gameOfLife.setLivingCell(0, 3);
    }
    @When("it has fewer than two live neighbours")
    public void itHasFewerThanTwoLiveNeighbours() {
        gameOfLife.computeNextGeneration();
    }
    @Then("the live cell dies caused by underpopulation")
    public void theLiveCellDiesCausedByUnderpopulation(){
        Assert.assertThat(gameOfLife.isDead(0,0), CoreMatchers.is(Boolean.TRUE));
    }




    @Given("one live cell on the grid with two or three neighbours")
    public void oneLiveCellOnTheGridWithTwoOrThreeNeighbours() {
        gameOfLife.setLivingCell(0, 0);
    }
    @When("it has two or three live neighbours")
    public void aCellWithAtLeastTwoNeighboursLives() {
        gameOfLife.setLivingCell(0, 1);
        gameOfLife.setLivingCell(1, 1);
        gameOfLife.computeNextGeneration();
    }
    @Then("the live cell is alive on to the next generation")
    public void TheLiveCellIsAlive() {
        Assert.assertThat(gameOfLife.isAlive(0,0), CoreMatchers.is(Boolean.TRUE));
    }




    @Given("one live cell on the grid with more than three live neighbours")
    public void oneLiveCellOnTheGridWithMoreThanThreeLiveNeighbours() {
        gameOfLife.setLivingCell(1, 4);
    }
    @When("it has more than three neighbors")
    public void itHasMoreThanThreeNeighbors() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
        gameOfLife.computeNextGeneration();
    }
    @Then("the live cell is dead as if by overcrowding")
    public void theLiveCellIsDeadAsIfByOvercrowding() {
        Assert.assertThat(gameOfLife.isDead(1,4), CoreMatchers.is(Boolean.TRUE));
    }


}
