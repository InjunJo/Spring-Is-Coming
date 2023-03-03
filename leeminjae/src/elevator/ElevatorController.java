package elevator;

public class ElevatorController {
    private int id;
    private int curFloor;

    public ElevatorController(int id) {
        this.id = id;
    }

    void gotoFloor(int destination) {
        this.curFloor=destination;
    }

    public int getId() {
        return id;
    }

    public int getCurFloor() {
        return curFloor;
    }
}
