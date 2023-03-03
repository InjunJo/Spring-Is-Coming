package elevator;

public class ElevatorRequestCommand implements Command {
    private int destination;
    private Direction direction;
    private ElevatorManager em;

    public ElevatorRequestCommand(int destination, Direction direction, ElevatorManager em) {
        this.destination = destination;
        this.direction = direction;
        this.em = em;
    }

    @Override
    public void execute() {
        em.requestElevator(destination, direction);
    }
}
