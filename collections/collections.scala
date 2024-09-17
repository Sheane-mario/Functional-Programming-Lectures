
object Collections {

  var a = new Array[Int](5)

  // reading elements to an array
  def readA(i: Int): Array[Int] = {
    if (i < 1) Array()
    else {
      print("Enter: ")
      Array(scala.io.StdIn.readInt()) ++ readA(i - 1)
    }

  }

  // print elements in an array
  def printA(arr: Array[Int]): Unit = {
    if (arr.length > 0) {
        print(s"${arr.head} ")
        printA(arr.tail)
    }

  }

  // adding elements in the array
  def addA(arr: Array[Int]): Int = {
    if (arr.isEmpty) 0 
    else arr.head + addA(arr.tail)
  }

  // finding the maximum number within the array
  def maxA(arr: Array[Int]): Int = {
    if (arr.length == 1) arr.head
    else {
      val tmp = maxA(arr.tail)
      if (arr.head > tmp) arr.head else tmp
    }
  }

  // LISTS
  // lists are immutable
  var fruits = List("apple", "orange", "banana")
  fruits = "mangoes" :: fruits

  // collatz seq
  def collatzSeq(n: Int, acc: List[Int]): List[Int] = n match{
      case 1 => acc :+ 1
      case _ if (n % 2 == 0) => collatzSeq(n / 2, acc :+ n)
      case _ => collatzSeq(3 * n + 1, acc :+ n)

  }

  def collatz(n: Int): List[Int] = {
      collatzSeq(n, List())
  }


  // SET
  // sets are immutable by default
  var s = Set(1, 1, 1, 2, 3, 4)


  // MAPS
  // maps are immutable by default 
  var colors = Map("red" -> "#333", "blue" -> "#563")

  // TUPLES
  // tuples are immutable
  def getStudents(): (String, Int) = (scala.io.StdIn.readLine(), scala.io.StdIn.readInt()) 

  def getStudentWithGrade(): (String, Int, String) = {
    val name = scala.io.StdIn.readLine()
    val mark = scala.io.StdIn.readInt()
    mark match {
      case mark if (mark >= 75 && mark <= 100) => (name, mark, "A") 
      case mark if (mark >= 65 && mark < 75) => (name, mark, "B")
      case mark if (mark >= 55 && mark < 65) => (name, mark, "C")
      case mark if (mark >= 40 && mark < 55) => (name, mark, "S")
      case mark if (mark >= 0 && mark < 40) => (name, mark, "F")
    }
  }



  def main(args: Array[String]): Unit = {

//    var marks = readA(4)
//    printA(marks)
//    println()
//    println(addA(marks))
//    println(maxA(marks))
    println(fruits)
    var seq = collatz(10)
    println(seq)
    println(s)
    println(colors("red"))
    println(colors.keys)
    colors.keys.foreach(color => println(color + " " + colors(color)))
    println(getStudentWithGrade())

  }
}
