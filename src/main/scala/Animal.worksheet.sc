val num = 112

def num2 = 3

def num3(a: Int) = 3 + 1 + a

num3(4)

abstract class Animal(years: Int) {
  override def toString(): String = f"Animal: ${years} y.o."
}

case class Dog(years: Int) extends Animal(years) {
  def bark = println("Wow, wow!")
}

val myDog = new Dog(5)
myDog.bark

case class Cat(years: Int) extends Animal(years)

def mathcAnimal(animal: Animal) = animal match {
  case Dog(2)   => println(f"Dog 2 yo")
  case Dog(num) => println(f"Dog ${num} yo")
  case Cat(1)   => println("Cat 1 yo!")
  case Cat(_)   => println("Cat other yo!")
}

mathcAnimal(new Dog(1))
mathcAnimal(new Cat(2))
