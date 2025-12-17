public class Fox extends Animal
{
    private static final int BREEDING_AGE = 10;
    private static final int MAX_AGE = 150;
    private static final double BREED_PROB = 0.08;
    private static final int MAX_LITTER = 2;

    @Override
    public void act(Actor[][] current, Actor[][] next, int r, int c)
    {
        incrementAge();
        if(!alive) return;

        placeSelf(next, r, c);

        int births = breed();
        for(int i = 0; i < births; i++)
            placeOffspring(next);
    }

    private void placeSelf(Actor[][] grid, int r, int c)
    {
        if(grid[r][c] == null)
            grid[r][c] = this;
        else
            die();
    }

    private void placeOffspring(Actor[][] grid)
    {
        int r = rand.nextInt(grid.length);
        int c = rand.nextInt(grid[0].length);
        if(grid[r][c] == null)
            grid[r][c] = new Fox();
    }

    protected int getBreedingAge() { return BREEDING_AGE; }
    protected int getMaxAge() { return MAX_AGE; }
    protected double getBreedingProbability() { return BREED_PROB; }
    protected int getMaxLitterSize() { return MAX_LITTER; }
}
