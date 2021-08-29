public class ChainOfResponsibility {

  public static void main(String[] args) {

    var woman = new F0();
    var man = new F1();
    var boy = new F2();

    woman.setTargetPerson(man);
    man.setTargetPerson(boy);

    woman.act();
  }

}

interface IPerson {
  void setTargetPerson(IPerson person);

  void act();
}

abstract class BasePerson implements IPerson {

  protected IPerson targetPerson;

  @Override
  public void setTargetPerson(IPerson person) {
    this.targetPerson = person;
  }
}

class F0 extends BasePerson {
  @Override
  public void act() {
    if (super.targetPerson != null) {

      System.out.println(String.format("%s %s %s", this.getClass().getSimpleName(), "sell food for",
          super.targetPerson.getClass().getSimpleName()));

      super.targetPerson.act();
    }
  }
}

class F1 extends BasePerson {
  @Override
  public void act() {
    if (super.targetPerson != null) {
      System.out.println(String.format("%s %s %s", this.getClass().getSimpleName(), "ship food for",
          super.targetPerson.getClass().getSimpleName()));
      super.targetPerson.act();
    }
  }
}

class F2 extends BasePerson {
  @Override
  public void act() {
    if (super.targetPerson != null) {
      System.out.println(String.format("%s %s %s", this.getClass().getSimpleName(), "eat food with",
          super.targetPerson.getClass().getSimpleName()));
      super.targetPerson.act();
    }
  }
}