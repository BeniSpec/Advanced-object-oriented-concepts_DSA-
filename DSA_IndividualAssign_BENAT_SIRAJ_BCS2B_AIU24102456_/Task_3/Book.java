public abstract class Book {

    // Fields
    private String  title;    
    protected double price;   

    // Constructor requires title
    public Book(String title) {
        this.title = title;
    }

    // Abstract method to be implemented by child classes
    public abstract void setPrice();

    // Getters
    public String getTitle() { return title; }

    public double getPrice() { return price; }

    // String representation of the object
    @Override
    public String toString() {
        return "Book { title='" + title + "', price=$"
               + String.format("%.2f", price) + " }";
    }
}