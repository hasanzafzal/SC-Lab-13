public interface Actor
{
    void act(Actor[][] current, Actor[][] next, int row, int col);
    boolean isAlive();
}