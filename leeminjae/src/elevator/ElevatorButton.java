package elevator;

public class ElevatorButton {
    private Command command;

    public ElevatorButton(Command command) {
        this.command = command;
    }

    void pressed() {
        command.execute();
    }
}
