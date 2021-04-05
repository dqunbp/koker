// Создаем класс и объект для масти, создаем обьекты масти наследуя от класса масти
// Далее можно будет обращаться к ним Suit.Diamonds
abstract class Suit
object Suit {
  case object Clubs extends Suit
  case object Diamonds extends Suit
  case object Hearts extends Suit
  case object Spades extends Suit
}

// Чтобы обращаться не Suit.Diamonds а напрямую Diamonds надо импортировать содержимое Suit,
// _ означает импортирвоать все
import Suit._

// Создаем класс и объект для ранга, создаем и наследуем от него объекты рангов
// Так же объявляем свойство класса value для хранения числового значения ранга в объектах ранга
// Передаем это числовое значение при наследовании от базового класса
abstract class Rank(val value: Int)
object Rank {
  case object Two extends Rank(2)
  case object Three extends Rank(3)
  case object Four extends Rank(4)
  case object Five extends Rank(5)
  case object Six extends Rank(6)
  case object Seven extends Rank(7)
  case object Eight extends Rank(8)
  case object Nine extends Rank(9)
  case object Ten extends Rank(10)
  case object Jack extends Rank(11)
  case object Queen extends Rank(12)
  case object King extends Rank(13)
  case object Ace extends Rank(14)
}

import Rank._

// Объявляем класс карты сочетающий 2 свойства - ранг и масть
case class Card(rank: Rank, suit: Suit)

// Объявляем список карт состоящий из 2 классов - пустой и непустой список
// Непустой список имеет 2 аттрибута - голову и хвост
// Оба являются подклассами базового класса CardList
// Объявляем в CardList метод length который будет доступен в каждом подклассе
// чтобы можно было получить длину списка
// Ключевое слово `this` используется для доступа к инстансу класса
// Обращение к `this` внутри метода возвращает ссылку на объект в котором этот метод вызывается
abstract class CardList {
  def length: Int = this match {
    case Nil         => 0
    case Cons(c, cs) => 1 + cs.length
  }
}
case class Cons(head: Card, tail: CardList) extends CardList
case object Nil extends CardList

val list = new Cons(new Card(Two, Hearts), Nil)

list.length

def hasRoyalFlush(cards: CardList): Boolean = {
  val fs = filterGte10(cards)
  fs.length == 5 && sameSuit(fs)
}

// Фильтруем карты рангом меньше 10
def filterGte10(cards: CardList): CardList = cards match {
  case Cons(card, tail) => if (card.rank.value >= 10) ??? else ???
  case Nil              => Nil
}

// Проверяем у всех ли одинаковая рубашка, сравнивая попарно каждые 2 карты
def sameSuit(cards: CardList): Boolean = cards match {
  case Nil             => true
  case Cons(card, Nil) => true
  case Cons(card1, Cons(card2, tail)) =>
    card1.suit == card2.suit && ???
}

val rf =
  Cons(
    Card(Ten, Spades),
    Cons(
      Card(Queen, Spades),
      Cons(
        Card(Two, Hearts),
        Cons(
          Card(King, Spades),
          Cons(
            Card(Ace, Spades),
            Cons(Card(Jack, Spades), Cons(Card(Five, Hearts), Nil))
          )
        )
      )
    )
  )

val noRf =
  Cons(
    Card(Two, Diamonds),
    Cons(
      Card(Queen, Diamonds),
      Cons(
        Card(Ten, Diamonds),
        Cons(
          Card(Jack, Diamonds),
          Nil
        )
      )
    )
  )

// тесты должны проходить если имплементация корректна
// assert(filterGte10(rf).length == 5)
// assert(filterGte10(noRf).length == 3)
// assert(sameSuit(rf) == false)
// assert(sameSuit(noRf))
// assert(hasRoyalFlush(rf))
// assert(hasRoyalFlush(noRf) == false)
