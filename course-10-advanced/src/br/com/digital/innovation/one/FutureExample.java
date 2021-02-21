import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExample {
  private static final ExecutorService personsToExecute = Executors.newFixedThreadPool(3);

  public static void main(String[] args) throws InterruptedException {
    House house = new House(new Bedroom());

    List<? extends Future<String>> futures = 
      new CopyOnWriteArrayList<Future<String>>(house.getHouseActivities().stream()
        .map(activity -> personsToExecute.submit(() -> {
            try {
              return activity.make();
            } catch (Exception e) {
              e.printStackTrace();
            }
            return null;
          })
        )
        .collect(Collectors.toList()));

    while (true) {
      int unfinishedActivities = 0;

      for (Future<String> future : futures) {
        if (future.isDone()) {
          try {
            System.out.println("Acabou! " + future.get());
            futures.remove(future);
          } catch (Exception e) {
            // TODO: handle exception
          }
        } else {
          unfinishedActivities++;
        }
      }
      if (futures.stream().allMatch(Future::isDone)) {
        break;
      }

      System.out.println("Atividades não-terminadas: " + unfinishedActivities);
      Thread.sleep(500);
    }
    
    personsToExecute.shutdown();
  }
}

class House {
  private List<Room> rooms;

  House (Room... rooms) {
    this.rooms = Arrays.asList(rooms);
  }

  List<Activity> getHouseActivities() {
    return this.rooms.stream()
      .map(Room::obtainTasksOfRoom)
      .reduce(new ArrayList<Activity>(), (pivot, activities) -> {
        pivot.addAll(activities);
        return pivot;
      });
  }
}

interface Activity {
  String make() throws InterruptedException;
}

abstract class Room {
  abstract List<Activity> obtainTasksOfRoom();
}

class Bedroom extends Room {
  @Override
  List<Activity> obtainTasksOfRoom() {
    return Arrays.asList(
      this::makeBed,
      this::sweep,
      this::fixCloset
    );
  }

  private String fixCloset() throws InterruptedException {
    System.out.println("Arrumando guarda-roupa...");
    Thread.sleep(6000);
    return "Guarda-roupa arrumado!";
  };

  private String sweep() throws InterruptedException {
    System.out.println("Varrendo o quarto...");
    Thread.sleep(4000);
    return "Quarto varrido!";
  }

  private String makeBed() throws InterruptedException {
    System.out.println("Arrumando cama...");
    Thread.sleep(1000);
    return "Cama arrumada!";
  }
}


