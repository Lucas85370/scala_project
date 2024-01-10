

object Hello {
    def max(list : List[Int]): Int = list.max
    def min(list : List[Int]): Int = list.min
    def sum(list : List[Int]): Int = list.sum
    def avg(list : List[Int]): Int = list.sum/list.length*/
    def AggFunc(list : List[Int]): Int = {
        var resultat = 0
        val listDeFonctions: List[Int => Int] = List(min(list), max(list), avg(list), sum(list))
        for (i <- 0 to 4)
            resultat = listDeFonctions.map(fonction => fonction(list))
        return (resultat)
    } 
    def SplitandAgg(list : List[Int], AggFunc : (list[Int]) => Int): (Int, Int) = {
        val pairList = list.filter(_ % 2 == 0)
        val impairList = list.filter(_ % 2 != 0)
        
        (AggFunc(pairList), AggFunc(impairList))
    }
  //  def motCommencantParB(list : List[String]) : 
//    multix(m:Int, x:Int):Int=m*x
    def multi10(m:Int):Int=m*10
  //  def f(k : Int, g: (Int, String) => Int) = {
  //      for (i<- 0 to k)
  //          println(g(i, "Hello number"))
   // }
    def main(args: Array[String]) = {
        val l = List(1,2,4,5,7,11)
        val fruits : List[String] = List("bananes", "oranges", "pommes")
        val chiffres : List[Int] = List(1,3,9,7)
        val listeDeListes : List[List[Int]] = List(List(1,3), List(2,5,7))
      //  f(3, g)
      //  println(motCommencantParB(List("banane, bonjour, commencer, endroit, bisounours")))
        var justB = fruits.filter(mot => mot.startsWith("b"))
        //SpiltandAgg(List(1, 3, 4, 7, 8), AggFunc)
        val carac = listeDeListes.flatMap(sublist => sublist.map(x => x + 1))
        println(carac)
        println("Hello, world")
        println(l.map(_+1))
    }
}

class Etudiant(id: Int, nom: String, prenomE: String, dateNaissanceE:  Date) {
    val eid = id
    val name = nom
    val prenom = prenomE
    val dateNaissance = dateNaissanceE
    def afficherleNom() = {
        "[Nom:" + name + "], " + "[Prenom:" + prenom + "]"
    }
 //   def calculAge(dateNaissance: Int) {
   //     datediff(current_date, )
    //}
}

object POO1 {
    def main(args: Array[String]):Unit = {
        val e1 = new Etudiant(1, "Sicard", "Lucas", "24-09-2000")
        val e2 = new Etudiant(2, "Sicard", "Martin", "07-01-1999")

        println(e1.afficherleNom())
    }
}