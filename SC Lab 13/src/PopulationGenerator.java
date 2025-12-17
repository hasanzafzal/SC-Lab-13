import java.awt.Color;
import java.util.Random;

public class PopulationGenerator
{
    private static final double FOX_PROB = 0.02;
    private static final double RABBIT_PROB = 0.08;
    private static final Random rand = new Random();

    public void populate(Actor[][] grid)
    {
        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length; c++)
            {
                double chance = rand.nextDouble();
                if(chance <= FOX_PROB)
                    grid[r][c] = new Fox();
                else if(chance <= FOX_PROB + RABBIT_PROB)
                    grid[r][c] = new Rabbit();
            }
        }
    }

    public Color getColor(Class<?> cls)
    {
        if(cls == Fox.class) return Color.RED;
        if(cls == Rabbit.class) return Color.GREEN;
        return Color.GRAY;
    }
}
