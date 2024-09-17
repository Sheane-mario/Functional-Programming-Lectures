object MapReduceFilter {

  // Iterators
  val it = Iterator("a", "mario", "silva")
  while (it.hasNext) {
      println(it.next())
  }

  // taka the max and min of a sequence 
  val l = List(2, 5, 1, 8, 10)
  val maxl = l.reduce((x, y) => x max y)
  val minl = l.reduce((x, y) => x min y)

  // passing functions to map and filter
  val isEven = (i: Int) => i % 2 == 0
  val double = (i: Int) => i * 2

  val ints = List(2, 3, 5, 7, 8, 10)
  val evenInts = ints.filter(isEven)
  val doubledInts = ints.map(double)

  // fold
  val l2 = List(2, 7, 3, 5)
  val a1 = l2.fold(20)((x, y) => x + y)

  // Generate Prime Numbers
  // generate number from 2 to sqrt of n
  // then filter those divided by n. which are factors of n
  // then check the size of the returned Vector. if the vector is empty then n is prime else no
  val isPrime = (n: Int) => (2 to Math.sqrt(n).toInt).filter(u => n % u == 0).size == 0
  val factorsList = isPrime(998244353)

  // Generate random numbers
  // generate a random number less than x
  val r1 = (x: Int) => scala.util.Random.nextInt(x)

  // generate a list of random numbers
  val randomNumList = List.fill(10)(r1(1000))

  // calculating the total of the randomNumList
  val sum = (l: List[Int]) => l.reduce((x, y) => x + y)

  // calculate the total and the average 
  val stat: (List[Int]) => (Int, Double) = l => (sum(l), sum(l).toDouble / l.size) 

  // Calculate Average
  // Generate a list of tuples
  val t = (l: List[Int]) => l.map(x => (x, 1))

  // add each elements
  val fx = (l: List[Int]) => l.map(x => (x, 1)).reduce((x, y) => (x._1 + y._1, x._2 + y._2))

  // calculate total and average
  val stats: (Tuple2[Int, Int]) => (Int, Double) = t => (t._1, t._1 / t._2.toDouble)

  // Calculate the Word Count 
  // read the line from the given file
  val source = scala.io.Source.fromFile("sample.txt", "UTF-8").getLines

  // Split the lines by using the space char
  val wordsCount = source
    .flatMap(line => line.split(" "))
    .map(x => (x, 1))
    .reduce((x, y) => ("", x._2 + y._2))
    ._2 // accessing the second element in the tuple

  val wc = (s: String) => scala.io.Source.fromFile(s)
    .getLines
    .flatMap(line => line.split(" "))
    .map(x => (x, 1))
    .reduce((x, y) => ("", x._2 + y._2))
    ._2


  // Calculate the letter count 
  
  // val fc = (x: Char, s: String) => (x, s.count(l => l == x))
  // fc() calculates the number of occurances of x in s
  val fc = (x: Char, s: String) => (x, s.count(_ == x))

  // reading a file into a single string
  val source_fc = scala.io.Source.fromFile("sample.txt", "UTF-8")
    .getLines
    .mkString

  // breaking into distinct characters and count the occurence of each distinct character within the source file 
  // val ll = source_fc.distinct.toCharArray.map(x => fc(x, source_fc))
  val ll = source_fc.distinct.toCharArray.map(fc(_, source_fc))

  // make the given source file into a single string
  val source_lc = (s: String) => scala.io.Source.fromFile(s)
    .getLines
    .mkString


  // count the total # of letters within the given source file
  val lc = (s: String) => scala.io.Source.fromFile(s)
    .getLines
    .mkString
    // make the given source file into a single string
    .distinct
    .toCharArray
    // from that single string take only the distinct characters and inserted them into an character array
    .map(x => fc(x, source_lc(s)))
    // take each distinct character in the character array and transform that into a tuple where the first element in the tuple is that distinct character and the second element is the # of occurances of that distinct character within the source file
    .reduce((x, y) => ('x', x._2 + y._2))
    // take each tuple pair and transform that to a tuple containing 'x' as the first element and the addition of occurances of each letter as the second 
    ._2
    // finally a tuple like this will be returned ('x', 178). where the second element is the total number of characters within the given source


  // Counting a given word
  
  // Convert the source to string 
  val sourceToString = (s: String) => scala.io.Source.fromFile(s)
    .getLines
    .mkString

  val givenWordCount = (source: String, word: String) => sourceToString(source)
    .split(" ")
    .map(_.toLowerCase)
    .filter(_ == word)
    .size




  def main(args: Array[String]): Unit = {

    println(maxl)
    println(minl)
    println(evenInts)
    println(doubledInts)
    println(a1)
    println()
    println(factorsList)
    println(randomNumList)
    println(sum(randomNumList))
    println(stat(randomNumList))

    println(t(l2))
    println(fx(l2))
    println(stats(fx(l2)))

    // word count
    //words.foreach(x => println(x))
    //println(wordsCount)
    println(wc("sample.txt"))
    println(fc('a', "mario silva"))

    // letter count 
    println(source_fc)
    //println(lc("sample.txt"))
    ll.foreach(x => println(x))
    println(s"Total number of letter withing the sample.txt file:  ${lc("sample.txt")}")

    // given word count from a file 
    println(givenWordCount("sample.txt", "mario"))

  }




}
