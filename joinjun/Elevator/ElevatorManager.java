package chap8.Elevator;

import java.util.ArrayList;

public class ElevatorManager {
    public ArrayList<ElevatorController> controllList;

    public ElevatorManager(int controllerCount){
        controllList = new ArrayList<>(controllerCount);
    }

    public void addController(ElevatorController controller){
        controllList.add(controller);

    }

    public void requestElevator(int destination,Direction direction){
        int selectedElevator = selectElevator(destination,direction);

        switch (direction){
            case UP:
                System.out.println("-----엘리베이터가 "+destination+"층으로 올라가는 중입니다-----"); break;
            case DOWN:
                System.out.println("-----엘리베이터가 "+destination+"층으로 내려가는 중입니다-----"); break;
        }


        controllList.get(selectedElevator).gotoFloor(destination);

    }

    private int selectElevator(int destination, Direction direction){
        int min = Math.abs(controllList.get(0).getCurFloor()-destination);


        for(int i=0; i<controllList.size(); i++){

            int interval = Math.abs(controllList.get(i).getCurFloor() - destination);

            if(interval <min) return i;

        }

        return 0;

    }

    public ElevatorController getElevator(int destination, Direction direction){
        int min = Math.abs(controllList.get(0).getCurFloor()-destination);

        for(int i=0; i<controllList.size(); i++){

            int interval = Math.abs(controllList.get(i).getCurFloor() - destination);

            if(interval <min) return controllList.get(i);

        }

        return controllList.get(0);

    }

}
