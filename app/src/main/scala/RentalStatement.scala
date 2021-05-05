import java.util

class RentalStatement(val name: String) {
  private val rentals = new util.ArrayList[Rental]
  private var totalAmount = .0
  private var frequentRenterPoints = 0

  def addRental(rental: Rental): Boolean = rentals.add(rental)

  def makeRentalStatement: String = {
    clearTotals()
    makeHeader + makeRentalLines + makeSummary
  }

  private def clearTotals(): Unit = {
    totalAmount = 0
    frequentRenterPoints = 0
  }

  private def makeHeader = "Rental Record for " + getName + "\n"

  private def makeRentalLines = {
    var rentalLines = ""

    rentals.forEach(rental => rentalLines += makeRentalLine(rental))
    rentalLines
  }

  private def makeRentalLine(rental: Rental) = {
    val thisAmount = rental.determineAmount
    frequentRenterPoints += rental.determineFrequentRenterPoints
    totalAmount += thisAmount
    formatRentalLine(rental, thisAmount)
  }

  private def formatRentalLine(rental: Rental, thisAmount: Double) = "\t" + rental.getTitle + "\t" + thisAmount + "\n"

  private def makeSummary = "You owed " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points\n"

  def getName: String = name

  def getAmountOwed: Double = totalAmount

  def getFrequentRenterPoints: Int = frequentRenterPoints
}