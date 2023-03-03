package chap8.Elevator;

public class ElevatorController {
    private int id;
    private int curFloor;

    public ElevatorController(int id){
        this.id = id;
        curFloor = 1;
    }

    public void gotoFloor(int destination){
        curFloor = destination;
        System.out.println("요청하신 "+id+"번 엘리베이터가 "+destination+"층에 도착했습니다.");
    }

    public int getCurFloor(){
        return curFloor;
    }
}
