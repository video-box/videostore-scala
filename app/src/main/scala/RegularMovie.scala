class RegularMovie(override val title: String) extends Movie(title) {
  override def determineAmount(daysRented: Int): Double = {
    var thisAmount: Double = 2
    if (daysRented > 2) thisAmount += (daysRented.toDouble - 2) * 1.5
    thisAmount
  }

  override def determineFrequentRenterPoints(daysRented: Int) = 1
}