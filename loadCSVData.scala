import java.text.SimpleDateFormat
import java.util.Date

class Movie (id:Int, mTitle:String, mYear:Int,mDirector:String) {
    val mid=id
    var title=mTitle
    var year=mYear
    var director=mDirector
    override def toString():String = {
        "[Mid:"+mid + "]," + "[Title:"+title+ "]," +"[Year:"+year+ "]," + "[Director:"+director+ "]"
    }
}
// Rating(rID, mID, stars, ratingDate)
class Rating(p_rId:Int, p_mId:Int, p_stars:Int, p_ratingDate:String) {
    val rID=p_rId
    val mId=p_mId
    val stars=p_stars
    val format = new SimpleDateFormat("dd-MM-yyyy")
    val ratingDate = format.parse(p_ratingDate)
    override def toString():String = {
        "[Rid:"+rID + "]," + "[Mid:"+mId+ "]," +"[stars:"+stars+ "]," + "[ratingDate:"+ratingDate+ "]"
    }
}
// Reviewer(rID, name)
class Reviewer(p_rID:Int, p_name:String) {
    val rId=p_rID
    val name=p_name
    override def toString():String = {
        "[Rid:"+rId + "]," + "[Name:"+name+ "]"
    }
}
object Main {
    def loadMovieData(path:String):Array[Movie] = {
        var movies:Array[Movie] =Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines()) {
            val values = line.split(",").map(_.trim)
            val movie=new Movie(values(0).toInt, values(1).substring(1, values(1).length()-1), values(2).toInt, values(3).substring(1, values(3).length()-1))

            movies = movies :+ movie
        }
        bufferedSource.close
        return movies;
    }
    def loadRatingData(path:String):Array[Rating] = {
        var ratings:Array[Rating] =Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines) {
            val values = line.split(",").map(_.trim)
            val rating=new Rating(values(0).toInt, values(1).toInt, values(2).toInt,  values(3).substring(1, values(3).length-1))

            ratings = ratings :+ rating
        }
        bufferedSource.close
        return ratings;
    }
    def loadReviewerData(path:String):Array[Reviewer] = {
        var reviewers:Array[Reviewer] =Array.empty
        val bufferedSource = io.Source.fromFile(path)
        for (line <- bufferedSource.getLines) {
            val values = line.split(",").map(_.trim)
            val reviewer=new Reviewer(values(0).toInt, values(1).substring(1, values(1).length-1))

            reviewers = reviewers :+ reviewer
        }
        bufferedSource.close
        return reviewers;
    }
    def getReviewersFromRID(rID: Int, reviewers: Array[Reviewer]): Option[Reviewer] =
        reviewers.find(reviewer => reviewer.rId == rID)
    def getRatingsFromMID(mID: Int, ratings: Array[Rating]): Array[Rating] =
        ratings.filter(rating => rating.mId == mID)
    def getReviewerByName()
    

    def display(matchingReviews: Array[(String, String, Int)]): Unit = {
        println("Examinateur, Titre du film, Nombre d'étoiles :")
        matchingReviews.foreach { case (reviewer, title, stars) =>
            println(s"$reviewer, $title, $stars")
        }
    }
    def main(args: Array[String]) {
        var movies:Array[Movie] =loadMovieData("data/movie.csv")
        var ratings:Array[Rating] =loadRatingData("data/rating.csv")
        var reviewers:Array[Reviewer] =loadReviewerData("data/reviewer.csv")

        //Exercice 1 ------------
        val spielbergMovies: Array[Movie] = movies.filter(movie => movie.director == "Steven Spielberg")
        spielbergMovies.foreach(movie => println(s"Film de Steven Spielberg: ${movie.title}"))
        //Exercice 2 ------------
        val RatingSup: Array[Int] = movies
            .filter(movie => ratings.exists(rating => rating.mId == movie.mid && rating.stars >= 4))
            .map(_.year)
            .distinct
            .sorted
            println("Années avec des notes au dessus de 4 :")
            RatingSup.foreach(println)
        //Exercice 3 --------
        val nameMovie = "Gone with the Wind"
        val idMovie = movies.find(_.title == nameMovie).map(_.mid)

        val reviewTitle: Array[String] = idMovie match {
            case Some(id) => 
              ratings
                .filter(rating => rating.mId == id)
                .flatMap(rating => reviewers.find(reviewer => reviewer.rId == rating.rID).map(_.name))
                .distinct
            case none => Array.empty[String]
        }
        println(s"Les personnes qui ont noté '$nameMovie' :")
        reviewTitle.foreach(println)
        //Exercice 4 ----------
        val ExaminateurFilms = 
    }
}