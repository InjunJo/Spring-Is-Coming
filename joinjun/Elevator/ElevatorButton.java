package chap8.Elevator;

public class ElevatorButton {
    private Command command;

    public ElevatorButton(Command command){
        this.command = command;
    }

    public void pressed(int destination){
        command.execute(destination);
    }

    public void setCommand(Command command){
        this.command = command;
    }

}
