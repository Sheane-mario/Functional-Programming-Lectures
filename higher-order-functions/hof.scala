

object HigherOrderFunctions {
  val isEven = (n: Int) => n % 2 == 0
  val greater = (a: Int, b: Int) => if (a > b) a else b
  val EvenorOdd = (n: Int) => n % 2 match {
    case 0 => println("Even")
    case _ => println("Odd")
  }

  val hello: String => String = (str: String) => s"Hello ${str}!"
  val greeting = (callback: String => String, name: String) => println(callback(name))

  val add: (Int, Int) => Int = (a, b) => a + b
  val mul: (Int, Int) => Int = (a, b) => a * b
  val f: ((Int, Int) => Int, Int, Int) => Int = (op, a, b) => op(a, b)

  // execute and print
  val ePrint: ((Int, Int) => Int, Int, Int) => Unit = (op, a, b) => { val r = op(a, b); println(r)}

  // compute sum of integers from a to b
  val sumInt: (Int, Int) => Int = (a, b) => if (a > b) 0 else a + sumInt(a + 1, b) 

  // compute the sum of cubes of the integers from a to b 
  val cube: Int => Int = x => x * x * x
  val square: Int => Int = x => x * x
  val sum: (Int => Int, Int, Int) => Int = (f, a, b) => if (a > b) 0 else f(a) + sum(f, a + 1, b)

  // take two functions as input, two integers and pass those two integers to the two functions and return the answer as a tuple
  val cal: ((Int, Int) => Int, (Int, Int) => Int, Int, Int) => (Int, Int) = (f, g, x, y) => (f(x, y), g(x, y))


  // CURRING

  // function execution without curring
  def finalPrice(vat: Double, serviceCharge: Double, productPrice: Double): Double = productPrice + productPrice*vat/100 + productPrice*serviceCharge/100

  // function execution with curring
  val FinalPrice = (productPrice: Double) => (vat: Double) => (serviceCharge: Double) => productPrice + productPrice*vat/100 + productPrice*serviceCharge/100

  // NAMED ARGUEMENTS
  def printInt(a: Int, b: Int) = {
      println("Value of a: " + a)
      println("Value of b: " + b)
  }

  // VARIABLE LENGTH ARGUEMENTS
  def addNumbers(x: Int*) = {
    var total = 0
    for (i <- x) total += i
    total
  }

  // DEFAULT PARAMETERS
  def defaultAdd(x: Int=3, y: Int=5) = x + y

  // FUNCTIONS CALL-BY-NAME 
  def time() = {
    println("Getting time in nano-seconds")
    System.nanoTime
  }

  def delayed(t: => Long) = {
    println("In delayed method") 
    println("Param: " + t)
  }



  
  def main(args: Array[String]): Unit = {

    // LAMBDA FUNCTIONS
    greeting(hello, "Mario")
    ePrint(add, 4, 2)
    ePrint(mul, 4, 2)
    println(sumInt(1, 10))
    println(sum(cube, 1, 5))
    println(sum(square, 1, 5))

    println(cal(add, mul, 2, 8))

    println(finalPrice(100, 10, 12))

    // CURRING
    val vatApplied = FinalPrice(100)
    val serviceApplied = vatApplied(10)
    var price = serviceApplied(12)

    println(price)

    // NAMED ARGUEMENTS
    printInt(b=18, a=11)

    // VARIABLE LENGTH ARGUEMENTS
    println(addNumbers(1, 3, 4, 5, 6, 9))

    // DEFAULT PARAMETERS
    println(defaultAdd())

    // FUNCTIONS CALL-BY-NAME
    delayed(time())

  }
}
