object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal

  case class Shelter[+T <: Animal] (animals: List[T]) {
    def +[A >: T <: Animal](newAnimal: A): Shelter[A] =
      Shelter[A](animals :+ newAnimal)

    def ++[A >: T <: Animal](newShelter: Shelter[A]): Shelter[A] =
      Shelter[A](animals ++ newShelter.animals)

    def feed[A >: T <: Animal](food: Food[A]): Seq[String] = {
      if (!food.isInstanceOf[Food[T]]) throw new IllegalArgumentException
      animals.map(food.feed)
    }

    def getNames: List[String] = {
      animals.map(_.name)
    }
  }

  trait Food[T <: Animal]{
    def name: String
    def feed(animal: T): String = s"${animal.name} eats ${this.name}"
  }

  case object Meat extends Food[Animal]{
    override def name: String = "meat"
  }

  case object Milk extends Food[Cat]{
    override def name: String = "milk"
  }

  case object Bread extends Food[Dog]{
    override def name: String = "bread"
  }
}