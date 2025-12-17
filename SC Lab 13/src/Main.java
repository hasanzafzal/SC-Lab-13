public class Main
{
    public static void main(String[] args)
    {
        Simulator sim = new Simulator(10, 10);
        sim.run(10);
        System.out.println("Simulation completed");
    }
}