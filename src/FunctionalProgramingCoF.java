import java.util.function.Consumer;

public class FunctionalProgramingCoF {

  public static void main(String[] args) {

    Consumer<String> foodSeller = new FoodSeller()::act;
    Consumer<String> shipper = FunctionalProgramingCoF::ship;
    Consumer<String> receiver = (food) -> System.out.println(String.format("FP Receive eat %s", food));

    foodSeller.andThen(shipper).andThen(receiver).accept("milk tea");
  }

  static void ship(String food) {
    System.out.println(String.format("FP Shipper ship %s", food));
  }

}