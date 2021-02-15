import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

public class DeadCellsTests {
    private GameOfLife gameOfLife;
    int aDeadCell;

    @Before
    public void before(){
        gameOfLife = new GameOfLife(4,8);
    }



    @Given("one dead cell on the grid")
    public void oneDeadCellOnTheGrid() {
        aDeadCell = 0;
    }
    @When("it has three neighbors")
    public void itHasThreeNeighbors() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
    }
    @Then("the dead cell becomes a live cell")
    public void theDeadCellBecomesALiveCell() {
        gameOfLife.computeNextGeneration();
        Assert.assertThat(gameOfLife.isAlive(1,4), CoreMatchers.is(Boolean.TRUE));
    }





    @Given("one cell on the grid")
    public void oneCellOnTheGrid() {
        gameOfLife.setLivingCell(1, 4);
    }
    @When("it has less or more than three neighbours")
    public void itHasLessOrMoreThanThreeNeighbours() {
        gameOfLife.setLivingCell(0, 3);
        gameOfLife.setLivingCell(0, 4);
        gameOfLife.setLivingCell(0, 5);
        gameOfLife.setLivingCell(1, 5);
    }
    @Then("the dead cell remains dead")
    public void theDeadCellRemainsDead() {
        gameOfLife.computeNextGeneration();
        Assert.assertThat(gameOfLife.isDead(1,4), CoreMatchers.is(Boolean.TRUE));
    }
}
