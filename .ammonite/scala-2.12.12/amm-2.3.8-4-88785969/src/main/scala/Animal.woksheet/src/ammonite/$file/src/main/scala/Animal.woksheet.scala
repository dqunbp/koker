
package ammonite
package $file.src.main.scala
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.repl.tools.{
  desugar,
  source
}
import _root_.mainargs.{
  arg,
  main
}
import _root_.ammonite.repl.tools.Util.{
  PathRead
}


object `Animal.woksheet`{
/*<script>*/val num = 112

def num2 = 3

def num3(a: Int) = 3 + 1 + a

/*<amm>*/val res_3 = /*</amm>*/num3(4)

// abstract class Animal(years: Int) {
//   override def toString(): String = f"Animal: ${years} y.o."
// }

// case class Dog(years: Int) extends Animal(years) {
//   def bark = println("Wow, wow!")
// }

// case class Cat(years: Int) extends Animal(years)

// def mathcAnimal(animal: Animal) = animal match {
//   case Dog(2)   => println(f"Dog of 2 years")
//   case Dog(num) => println(f"Dog of ${num} years")
//   case Cat(1)   => println("Cat!")
//   case Cat(_)   => println("Cat _!")
// }

// mathcAnimal(new Dog(1))
// mathcAnimal(new Cat(2))
/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "Animal$u002Ewoksheet"
  /*</generated>*/
}
