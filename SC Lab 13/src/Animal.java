import java.util.Random;

public abstract class Animal implements Actor
{
    protected int age;
    protected boolean alive;
    protected static final Random rand = new Random();

    public Animal()
    {
        age = 0;
        alive = true;
    }

    // 10.42
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isAlive() { return alive; }

    protected void die()
    {
        alive = false;
    }

    // 10.43
    public boolean canBreed()
    {
        return age >= getBreedingAge();
    }

    // 10.44
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge())
            die();
    }

    // 10.45
    protected int breed()
    {
        if(canBreed() && rand.nextDouble() <= getBreedingProbability())
            return rand.nextInt(getMaxLitterSize()) + 1;
        return 0;
    }

    protected abstract int getBreedingAge();
    protected abstract int getMaxAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
}
