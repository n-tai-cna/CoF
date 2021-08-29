public class ChainOfResponsibility {

  public static void main(String[] args) {

    var f0 = new FoodSeller();
    var f1 = new Shipper();
    var f2 = new Receiver();

    f0.setTargetPerson(f1);
    f1.setTargetPerson(f2);

    f0.act("milk tea");
  }

}

interface IPerson {
  void setTargetPerson(IPerson person);

  void act(String food);
}

abstract class BasePerson implements IPerson {

  protected IPerson targetPerson;

  @Override
  public void setTargetPerson(IPerson person) {
    this.targetPerson = person;
  }
}

class FoodSeller extends BasePerson {

  @Override
  public void act(String food) {
    if (super.targetPerson != null) {

      System.out.println(String.format("%s sell %s for %s", this.getClass().getSimpleName(), food,
          super.targetPerson.getClass().getSimpleName()));

      super.targetPerson.act(food);
    }
  }
}

class Shipper extends BasePerson {
  @Override
  public void act(String food) {
    if (super.targetPerson != null) {
      System.out.println(String.format("%s ship %s for %s", this.getClass().getSimpleName(), food,
          super.targetPerson.getClass().getSimpleName()));
      super.targetPerson.act(food);
    }
  }
}

class Receiver extends BasePerson {
  @Override
  public void act(String food) {
    if (super.targetPerson != null) {
      System.out.println(String.format("%s eat %s with %s", this.getClass().getSimpleName(), food,
          super.targetPerson.getClass().getSimpleName()));
      super.targetPerson.act(food);
    }
  }
}