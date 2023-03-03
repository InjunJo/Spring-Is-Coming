package elevator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

public class ElevatorApplication {
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws Exception {
        ElevatorManager manager = new ElevatorManager(6);
        int curFloor = 1;  // 현재 층
        while (true) {
            printConsole();
            int op = Integer.parseInt(rd.readLine());
            switch (op) {
                case 1:
                    System.out.print("방향 선택 1. 위, 2. 아래 > ");
                    Direction d = Integer.parseInt(rd.readLine()) == 1 ? Direction.UP : Direction.DOWN;
                    ElevatorRequestCommand erc = new ElevatorRequestCommand(curFloor, d, manager);
                    ElevatorButton requestButton = new ElevatorButton(erc);
                    requestButton.pressed();
                    break;
                case 2:
                    System.out.print("엘리베이터 선택 > ");
                    int id = Integer.parseInt(rd.readLine());
                    ElevatorController controller = manager.controllers.get(id);

                    System.out.print("층 선택 > ");
                    int f = Integer.parseInt(rd.readLine());

                    DestinationSelectionCommand dsc = new DestinationSelectionCommand(f, controller);
                    ElevatorButton selectionButton = new ElevatorButton(dsc);
                    selectionButton.pressed();
                    break;
                case 3:
                    printInfo(manager);
                    break;
                case 4:
                    return;
            }
        }
    }

    public void printConsole() {
        System.out.println("--------------------------------------");
        System.out.println("| 1. 요청 | 2. 이동 | 3. 정보 | 4. 종료 |");
        System.out.println("--------------------------------------");
        System.out.print("선택 > ");
    }

    public void printInfo(ElevatorManager manager) {
        Set<Map.Entry<Integer, ElevatorController>> entries = manager.controllers.entrySet();
        for (Map.Entry<Integer, ElevatorController> e : entries) {
            System.out.println("id : " + e.getValue().getId() + ", curFloor : " + e.getValue().getCurFloor());
        }
    }

    public static void main(String[] args) throws Exception {
        new ElevatorApplication().run();
    }
}
