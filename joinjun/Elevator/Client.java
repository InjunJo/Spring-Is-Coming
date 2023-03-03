package chap8.Elevator;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        ElevatorManager manager = new ElevatorManager(4);
        ElevatorRequestCommand request = new ElevatorRequestCommand(Direction.UP,manager);

        for(int i=0; i<4; i++){
            manager.addController(new ElevatorController(i+1));
        }


        DestinationSelectionCommand destinationSelect = new DestinationSelectionCommand(manager.getElevator(5,Direction.UP));

        ElevatorButton button = new ElevatorButton(request);

        button.pressed(5);

        button.setCommand(destinationSelect);

        new buttonThread().start();


    }
}

class buttonThread extends Thread{
    ElevatorManager manager = new ElevatorManager(4);


    ElevatorRequestCommand request = new ElevatorRequestCommand(Direction.UP,manager);
    ElevatorButton button = new ElevatorButton(request);

    @Override
    public void run() {
        for(int i=0; i<4; i++){
            manager.addController(new ElevatorController(i+1));
        }
        while(true){
            button.pressed(new Random().nextInt(10)+1);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }

    }
}
