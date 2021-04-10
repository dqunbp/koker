def detectNum(nums: List[Int]): Int = {
  val sorted = nums.sorted

  def traverse(nums: List[Int]): Int = nums match {
    case a :: b :: tail => if (b - a > 1) a + 1 else traverse(b :: tail)
    case _              => 9
  }

  if (sorted.head == 2) 1
  else traverse(nums)
}

detectNum(List(2, 3, 4, 5, 6, 7, 8, 9))
detectNum(List(1, 2, 3, 4, 5, 6, 7, 8))
detectNum(List(1, 2, 3, 4, 5, 6, 8, 9))

def controlsum(nums: List[Int]): Int = {
  if (nums == List())
    0
  else
    nums.head + controlsum(nums.tail)
}

def sumList(ns: List[Int]): Int = ns match {
  case List()    => 0
  case a :: tail => a + sumList(tail)
}

def solvePr(nums: List[Int]): Int = 45 - sumList(nums)

solvePr(List(1, 2, 9, 4, 5, 6, 8, 7))
sumList(List(1, 2))

def car(n: Int): (List[Int]) => Int = {
  def solvePr(nums: List[Int]): Int = n - sumList(nums)
  solvePr
}

val solve19 = car(45)

solve19((List(1, 2, 9, 4, 5, 6, 8, 7)))

def solve(n: Int)(nums: List[Int]): Int = n - sumList(nums)

val s6 = solve(54)(_)

s6(List(2, 3, 4, 5, 6, 7, 8, 10))

"abc".toList

List(
  List('d', 'a', 'b', 'c'),
  List('c', 'd', 'a', 'b'),
  List('b', 'c', 'd', 'a'),
  List('a', 'b', 'c', 'd')
)

List(
  List('a', 'b'),
  List('b', 'a')
)

def printQ(chars: List[Char]): List[List[Char]] = {
  def loop(
      first: List[Char],
      second: List[Char],
      acc: List[List[Char]]
  ): List[List[Char]] = first match {
    case List() => acc
    case head :: tl => {
      val list = tl ::: (second ::: List(head))
      loop(tl, second ::: List(head), list :: acc)
    }
  }

  loop(chars, List(), List())
}

printQ("abcd".toList)

List(1) ::: List(2)
