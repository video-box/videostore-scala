// This file is the original program.  It has been left here so you can compare it with the refactored version.
import java.util

class Customer(val name: String) {
  private val rentals = new util.ArrayList[Rental]

  def addRental(rental: Rental): Boolean = rentals.add(rental)

  def getName: String = name

  def statement: String = {
    var totalAmount: Double = 0
    var frequentRenterPoints = 0
    var result = "Rental Record for " + getName + "\n"

    rentals.forEach { rental =>
      var thisAmount: Double = 0
      // determines the amount for each line
      rental.movie.getPriceCode match {
        case Movie.REGULAR =>
          thisAmount += 2
          if (rental.daysRented > 2) thisAmount += (rental.daysRented - 2) * 1.5
        case Movie.NEW_RELEASE =>
          thisAmount += rental.daysRented * 3
        case Movie.CHILDRENS =>
          thisAmount += 1.5
          if (rental.daysRented > 3) thisAmount += (rental.daysRented - 3) * 1.5
      }
      frequentRenterPoints += 1
      if ((rental.movie.getPriceCode eq Movie.NEW_RELEASE) && rental.daysRented > 1) frequentRenterPoints += 1
      result = result + "\t" + rental.getMovie.getTitle + "\t" + String.valueOf(thisAmount) + "\n"
      totalAmount += thisAmount
    }

    result += "You owed " + String.valueOf(totalAmount) + "\n"
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n"
    result
  }
}