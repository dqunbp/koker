// Создаем класс, создаем обьекты масти наследуя от класса масти
// Далее можно будет обращаться к ним Suit.Diamonds
abstract class Suit {
  override def toString(): String = this match {
    case Clubs    => "♣"
    case Spades   => "♠️"
    case Hearts   => "♥️"
    case Diamonds => "♦️"
  }
}

case object Clubs extends Suit
case object Diamonds extends Suit
case object Hearts extends Suit
case object Spades extends Suit

// Создаем класс и объект для ранга, создаем и наследуем от него объекты рангов
// Так же объявляем свойство класса value для хранения числового значения ранга в объектах ранга
// Передаем это числовое значение при наследовании от базового класса
abstract class Rank(val value: Int) {
  override def toString(): String = this match {
    case Jack  => "J"
    case Queen => "Q"
    case Ace   => "A"
    case King  => "K"
    case rank  => rank.value.toString()
  }
}

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

// Объявляем класс карты сочетающий 2 свойства - ранг и масть
case class Card(rank: Rank, suit: Suit) {
  def >(a: Card): Boolean = {
    this.rank.value > a.rank.value
  }

}

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

  def ::(card: Card): CardList = Cons(card, this)

  def _head: Card = this match {
    case Nil              => throw new Error("Hyyi tebe")
    case Cons(head, tail) => head
  }

  def _tail: CardList = this match {
    case Nil              => throw new Error("Hyyi tebe 2")
    case Cons(head, tail) => tail
  }

}
case class Cons(head: Card, tail: CardList) extends CardList
case object Nil extends CardList

val list = new Cons(new Card(Two, Hearts), Nil)

new Card(Two, Spades) :: Nil

2 - 1

2.-(1)

list.length

def hasRoyalFlush(cards: CardList): Boolean = {
  val fs = filterGte10(cards)
  fs.length == 5 && sameSuit(fs)
}

// Фильтруем карты рангом меньше 10
def filterGte10(cards: CardList): CardList = cards match {
  case Cons(card, tail) =>
    if (card.rank.value >= 10) Cons(card, filterGte10(tail))
    else filterGte10(tail)
  case Nil => Nil
}

// Проверяем у всех ли одинаковая рубашка, сравнивая попарно каждые 2 карты
def sameSuit(cards: CardList): Boolean = cards match {
  case Nil             => true
  case Cons(card, Nil) => true
  case Cons(card1, Cons(card2, tail)) =>
    card1.suit == card2.suit && sameSuit(Cons(card2, tail))
}

val rf =
  Card(Ten, Spades) ::
    Card(Queen, Spades) ::
    Card(Two, Hearts) ::
    Card(King, Spades) ::
    Card(Ace, Spades) ::
    Card(Jack, Spades) ::
    Card(Five, Hearts) :: Nil

val noRf =
  Card(Two, Diamonds) ::
    Card(Queen, Diamonds) ::
    Card(Ten, Diamonds) ::
    Card(Jack, Diamonds) ::
    Nil

val noRf2 =
  Card(Two, Diamonds) ::
    Card(Queen, Diamonds) ::
    Card(Ten, Spades) ::
    Card(Jack, Spades) :: Nil

// тесты должны проходить если имплементация корректна
assert(sameSuit(noRf2) == false)
assert(filterGte10(rf).length == 5)
assert(filterGte10(noRf).length == 3)
assert(sameSuit(rf) == false)
assert(sameSuit(noRf))
assert(hasRoyalFlush(rf))
assert(hasRoyalFlush(noRf) == false)

def mergeSort(cards: CardList): CardList = {
  val sr = cards.length / 2

  if (sr == 0) cards
  else {

    def merge(cards: CardList, spisok: CardList): CardList =
      (cards, spisok) match {
        case (cards, Nil)  => cards
        case (Nil, spisok) => spisok
        case (Cons(a, b), Cons(c, d)) =>
          if (a > c) c :: merge(cards, d) else a :: merge(b, spisok)
      }

    def split(cards: CardList, tails: CardList, sr: Int): (CardList, CardList) =
      sr match {
        case 0 => (cards, tails)
        case _ => split(cards._tail, cards._head :: tails, sr - 1)

      }
    val (n1, n2) = split(cards, Nil, sr)
    merge(mergeSort(n1), mergeSort(n2))
  }

}

mergeSort(rf)

// 4213
// 42 13

// 4 2 1 3

// 24 13

// 1 24 3
// 12 4 3
// 1234

//   13

// 42 13
// 1 merge(42, 3)
// 1 3 merge(42, )
// 1 3 42

List(1, 2) splitAt 1
