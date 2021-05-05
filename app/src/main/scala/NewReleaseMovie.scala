
class NewReleaseMovie(override val title: String) extends Movie(title) {
  override def determineAmount(daysRented: Int): Double = daysRented * 3.0

  override def determineFrequentRenterPoints(daysRented: Int): Int = if (daysRented > 1) 2 else 1
}