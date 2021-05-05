class Rental(val movie: Movie, val daysRented: Int) {
  def getTitle: String = movie.getTitle

  def determineAmount: Double = movie.determineAmount(daysRented)

  def determineFrequentRenterPoints: Int = movie.determineFrequentRenterPoints(daysRented)
}