
class ChildrensMovie(override val title: String) extends Movie(title) {
  override def determineAmount(daysRented: Int): Double = {
    var thisAmount = 1.5
    if (daysRented > 3) thisAmount += (daysRented - 3) * 1.5
    thisAmount
  }

  override def determineFrequentRenterPoints(daysRented: Int): Int = 1
}