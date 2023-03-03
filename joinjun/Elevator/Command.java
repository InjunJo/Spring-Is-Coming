package chap8.Elevator;

enum Direction{UP(),DOWN}

public interface Command {

    public void execute(int floor);
}

class DestinationSelectionCommand implements Command{

    private ElevatorController controller;

    DestinationSelectionCommand(ElevatorController controller){
        this.controller = controller;
    }

    @Override
    public void execute(int floor) {
        controller.gotoFloor(floor);
    }
}

class ElevatorRequestCommand implements Command{
    private Direction direction;
    private ElevatorManager manager;

    ElevatorRequestCommand(Direction direction,ElevatorManager manager){

            this.direction = direction;
            this.manager = manager;
    }

    @Override
    public void execute(int floor) {
        manager.requestElevator(floor,direction);
    }
}
