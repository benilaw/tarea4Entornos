
public class Rental {

    private Movie _movie;
    private int _daysRented;

    //constructor sin valores para que no necesite introducir valores en la llamada a la clase. 
    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public Rental() {
    }

    // metodo donde trasladamos el metodo a la clase Rental y le cambiamos la propiedad a privada
    /**
     * 
     * @param each
     * @param thisAmount
     * @return 
     */
    private double getCharge(Rental each, double thisAmount) {
         switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
// metodo get para llamar el método getCharge que es privado a traves de una clase 
    //pública y de get. 
    /**
     * 
     * @param each
     * @param thisAmount
     * @return 
     */
    public double getChargetwo(Rental each, double thisAmount) {
        return this.getCharge(each, thisAmount);
    }
}
