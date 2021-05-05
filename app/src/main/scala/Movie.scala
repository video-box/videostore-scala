
abstract class Movie(val title: String) {
  def getTitle: String = title

  def determineAmount(daysRented: Int): Double

  def determineFrequentRenterPoints(daysRented: Int) : Int
}