import org.scalatest._
import flatspec._
import matchers._
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class VideoStoreSpec() extends AnyFlatSpec with should.Matchers {
  private val newRelease1 = new NewReleaseMovie("New Release 1")
  private val newRelease2 = new NewReleaseMovie("New Release 2")
  private val childrens = new ChildrensMovie("Childrens")
  private val regular1 = new RegularMovie("Regular 1")
  private val regular2 = new RegularMovie("Regular 2")
  private val regular3 = new RegularMovie("Regular 3")

  private def assertAmountAndPointsForReport(statement: RentalStatement, expectedAmount: Double, expectedPoints: Int) {
    expectedAmount should be (statement.getAmountOwed)
    expectedPoints should be (statement.getFrequentRenterPoints)
  }

  "testSingleNewReleaseStatement" should "report correct amounts" in {
    val statement = new RentalStatement("Customer Name")
    statement.addRental(new Rental(newRelease1, 3))
    statement.makeRentalStatement
    assertAmountAndPointsForReport(statement, 9.0, 2)
  }

  "testDualNewReleaseStatement" should "report correct amounts" in {
    val statement = new RentalStatement("Customer Name")
    statement.addRental(new Rental(newRelease1, 3))
    statement.addRental(new Rental(newRelease2, 3))
    statement.makeRentalStatement
    assertAmountAndPointsForReport(statement,18.0, 4)
  }

  "testSingleChildrensStatement" should "report correct amounts" in {
    val statement = new RentalStatement("Customer Name")
    statement.addRental(new Rental(childrens, 3))
    statement.makeRentalStatement
    assertAmountAndPointsForReport(statement,1.5, 1)
  }

  "testMultipleRegularStatement" should "report correct amounts" in {
    val statement = new RentalStatement("Customer Name")
    statement.addRental(new Rental(regular1, 1))
    statement.addRental(new Rental(regular2, 2))
    statement.addRental(new Rental(regular3, 3))
    statement.makeRentalStatement
    assertAmountAndPointsForReport(statement,7.5, 3)
  }

   "testRentalStatementFormat" should "be valid format" in {
     val statement = new RentalStatement("Customer Name")
     statement.addRental(new Rental(regular1, 1))
     statement.addRental(new Rental(regular2, 2))
     statement.addRental(new Rental(regular3, 3))
     statement.makeRentalStatement should be ("Rental Record for Customer Name\n" + "\tRegular 1\t2.0\n" + "\tRegular 2\t2.0\n" + "\tRegular 3\t3.5\n" + "You owed 7.5\n" + "You earned 3 frequent renter points\n")
  }
}