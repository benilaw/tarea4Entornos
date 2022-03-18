
import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {

            // variable determinada que se llamará en el método de thisAmount
            double thisAmount = 0;

            Rental each = (Rental) rentals.nextElement();

            // instancio la clase Rental a través de un constructor sin variables. 
            Rental renta2 = new Rental();
            // llamada al método. 
            renta2.getChargetwo(each, thisAmount);
//llamada al método. 
            getFrequentRenterPoints(frequentRenterPoints, each);

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    public String getName() {
        return _name;
    }

    
    //creamos el método getFrequent con las variables frequentRenterPoints y Rental each, que realiza la busqueda
    // si no realiza lo llamado devuelve uno, como pide el refactor.
    /**
     * 
     * @param frequentRenterPoints
     * @param each
     * @return 
     */
    public int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        frequentRenterPoints++;
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
            frequentRenterPoints++;
        } else {
            return 1;
        }
    }
}
