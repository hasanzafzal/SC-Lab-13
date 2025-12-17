public class Simulator
{
    private Actor[][] grid;
    private final PopulationGenerator generator;

    public Simulator(int rows, int cols)
    {
        grid = new Actor[rows][cols];
        generator = new PopulationGenerator();
        generator.populate(grid);
    }

    public void simulateOneStep()
    {
        Actor[][] next = new Actor[grid.length][grid[0].length];

        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                if(grid[r][c] != null)
                {
                    grid[r][c].act(grid, next, r, c);
                }
            }
        }
        grid = next;
    }

    public void run(int steps)
    {
        for(int i = 0; i < steps; i++)
        {
            System.out.println("Step " + (i + 1));
            simulateOneStep();
            printGrid();
        }
    }

    // -------------------------------
    // Console visualization
    // -------------------------------
    private void printGrid()
    {
        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                if(grid[r][c] instanceof Fox)
                    System.out.print("F ");
                else if(grid[r][c] instanceof Rabbit)
                    System.out.print("R ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}
