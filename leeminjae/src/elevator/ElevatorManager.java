package elevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ElevatorManager {
    Map<Integer, ElevatorController> controllers = new HashMap<>();

    public ElevatorManager(int controllerCount) {
        for (int i = 1; i <= controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            addController(controller);
        }
    }

    public void addController(ElevatorController controller) {
        controllers.put(controller.getId(), controller);
    }

    public void requestElevator(int destination, Direction direction) {
        int id = selectElevator(destination, direction);
        controllers.get(id).gotoFloor(destination);
    }

    private int selectElevator(int destination, Direction direction) {
        int min = destination - controllers.get(1).getCurFloor();
        int id = 1;
        Set<Map.Entry<Integer, ElevatorController>> e = controllers.entrySet();
        for (Map.Entry<Integer, ElevatorController> x : e) {
            if (Math.abs(destination - x.getValue().getCurFloor()) < min) {
                min = Math.abs(destination - x.getValue().getCurFloor());
                id = x.getKey();
            }
        }
        return id;
    }
}
