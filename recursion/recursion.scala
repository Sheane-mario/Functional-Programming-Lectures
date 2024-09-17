// recursion types
// 1. Direct Recursion
// 2. Indirect Recursion
//
// Direct Recursion
// 1. Linear Recursion : - Head recurison, tail recursion
// 2. Multiple Recursion : - Binary recursion, Nested recursion

// Tail Recursion
// - function's stack frame can be reused
// - these are iterative processes
// - one stack frame is sufficient for both functions

object Recursion {
  
  def gcd(a: Int, b: Int): Int = b match {
    case 0 => a
    case x if (x > a) => gcd(x, a)
    case _ => gcd(b, a % b)
  }

  def isPrime(p: Int, n: Int=2): Boolean = n match {
    case x if (x == p) => true
    case x if (gcd(p, x) > 1) => false
    case _ => isPrime(p, n + 1)
  }

  def primeSeq(n: Int): Unit = n match {
    case x if (x == 2) => print("2 ")
    case x if (x > 2) => { primeSeq(n - 1); if (isPrime(x)) print(s"${x} ") }
  }

  // print numbers from n to m where (n < m)
  def printN(n: Int, m: Int): Unit = n match {
    case n if (n > m) => print("") 
    case n if (n <= m) => { print(s"${n} "); printN(n + 1, m) }
  }

  // print numbers from m to n where (n < m)
  def printNDes(n: Int, m: Int): Unit = n match {
    case n if (n < m) => { printNDes(n + 1, m); print(s"${n} ") }
    case n if (n >= m) => print(s"${n} ")
  }
  
  def power(n: Int, m: Int): Int = m match {
    case 0 => 1
    case _ => n * power(n, m - 1)
  }

  def factorial(n: Int): Int = n match {
    case 0 => 1
    case _ => n * factorial(n - 1)
  }

  // printing the triangle like pattern given in the exercises
  def line(n: Int): Unit = n match {
    case n if (n < 1) => print("")
    case n if (n >= 1) => { print(n); line(n - 1)}
  }
  
  def pattern(n: Int): Unit = n match {
    case n if (n == 1) => { line(n); println() }
    case n if (n > 1) => { pattern(n - 1); line(n); println() }
  }

  def patternRev(n: Int): Unit = n match {
    case n if (n == 1) => { line(n); println() }
    case n if (n > 1) => { line(n); println(); patternRev(n - 1) }
  }
  // end of pattern helper functions

  def fizzBuzz(n: Int): Unit = {
    if (n < 1) print("")
    else {
      fizzBuzz(n - 1)
      n match {
        case n if (n % 3 == 0 && n % 5 == 0) =>  print(" fizzBuzz ") 
        case n if (n % 3 == 0) => print(" fizz ")
        case n if (n % 5 == 0) => print(" buzz ")
        case _ => print(s" ${n} ")
      }
    }
  }

  def fib(n: Int): Int = n match {
    case x if (x == 0) => 0
    case x if (x == 1) => 1 
    case _ => fib(n - 1) + fib(n - 2)
  }

  def fibSeq(n: Int): Unit = {
    if (n > 0) fibSeq(n - 1)
    print(s" ${fib(n)} ")
  }

  // Tower of hanoi
  def TowerOfHanoi(n: Int, from: String, to: String, aux: String): Unit = {
    if (n == 1) {
        println(s"Move Disk 1 from $from to $to")
    } else {
        TowerOfHanoi(n - 1, from, aux, to)
        println(s"Move Disk $n from $from to $to")
        TowerOfHanoi(n - 1, aux, to, from)
    }
  }

  def josephus(n: Int, k: Int): Int = {
    if (n == 1) 0
    else (josephus(n - 1, k) + k) % n
  }

  // Indirect Recursion / Mutual Recursion
  def isEven(n: Int): Boolean = n match {
    case 0 => true
    case _ => isOdd(n - 1)
  }

  def isOdd(n: Int): Boolean = !(isEven(n)) 

  // Jambu tree and Rabutan tree puzzle

  def jambuTree(x: Int, y: Int): (Int, Int) = {
    val x = 2 * y - 3
    checkWithRabutanTree(x, y)
  }

  def checkWithRabutanTree(x: Int, y: Int): (Int, Int) = y match {
    case n if (x == n + 2) => (x, y) 
    case _ => jambuTree(x, y + 1)
  }

  def findBirds() = jambuTree(1, 1)

  def main(args: Array[String]): Unit = {
    println(gcd(35, 49))
    println(isPrime(19))
    primeSeq(1000)
    println()
    printN(5, 10)
    println()
    printNDes(5, 10)
    println()
    println(power(2, 4))
    println(factorial(10))
    pattern(27)
    patternRev(26)
    fizzBuzz(30)
    println()
    println(fib(5))
    fibSeq(10)
    println()
    TowerOfHanoi(4, "A", "B", "C")
    println(josephus(8, 2))
    println(isEven(8))
    println(isEven(7))

    println(findBirds())

  }

}
