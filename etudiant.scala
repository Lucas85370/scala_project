import java.util.Date
import java.text.SimpleDateFormat
import java.util.GregorianCalendar
import java.util.Calendar
import java.time.Period
import java.time.LocalDate

class Etudiant(id: Int, nom: String, prenomE: String, dateNaissanceE:  Date) {
    val eid = id
    val name = nom
    val prenom = prenomE
    val dateNaissance = dateNaissanceE
    override
    def toString():String =
        return (getInfo())
    def getInfo():String = {
        "[Nom:" + name + "], " + "[Prenom:" + prenom + "]," + "[Année de Naissance : "+getAgeNow()+"]"
    }
    def getBirthHere():Integer = {
        val calendar = new GregorianCalendar()
        calendar.setTime(dateNaissance)
        return calendar.get(Calendar.YEAR)
    }
    def getAgeNow():Integer = {
        val current_date = LocalDate.now()
        return(current_date.getYear-getBirthHere())
    }
}
object POO1 {
    def getAvgAge(etudiants:List[Etudiant]):Double = {
        return (etudiants.map(age => age.getAgeNow().toInt).sum.toDouble/etudiants.length)
    }
    def main(args: Array[String]):Unit = {
        val format = new SimpleDateFormat("dd-MM-yyyy")
        val e1 = new Etudiant(1, "Sicard", "Lucas", format.parse("07-01-1999"))
        val e2 = new Etudiant(2, "Sicard", "Martin", format.parse("24-09-2000"))
        val e3 = new Etudiant(3, "Sicard", "Maryse", format.parse("02-11-1960"))
        val etudiants=List(e1,e2,e3)
        println(getAvgAge(etudiants))
        println(e1.getInfo())
    }
}