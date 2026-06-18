public class BookArray {

    public static void main(String[] args) {

        System.out.println("Books in Library:");
        System.out.println();
        System.out.printf("%-4s %-12s %-44s %-8s%n", "No.", "Type", "Title", "Price");
        System.out.println("-----------------------------------------------------------------");

        Book[] library = new Book[10];

        library[0] = new Fiction   ("The Hobbit");
        library[1] = new NonFiction("A Brief History of Time");
        library[2] = new Fiction   ("Brave New World");
        library[3] = new NonFiction("Thinking, Fast and Slow");
        library[4] = new Fiction   ("The Catcher in the Rye");
        library[5] = new NonFiction("Sapiens");
        library[6] = new Fiction   ("The Alchemist");
        library[7] = new NonFiction("Educated");
        library[8] = new Fiction   ("Dune");
        library[9] = new NonFiction("The Body");

        for (int i = 0; i < library.length; i++) {
            String type = (library[i] instanceof Fiction) ? "Fiction" : "NonFiction";

            System.out.printf("%-4d %-12s %-44s $%-7.2f%n",
                    (i + 1),
                    type,
                    library[i].getTitle(),   
                    library[i].getPrice());  
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.println();

        int fictionCount = 0, nonFictionCount = 0;
        for (Book b : library) {
            if (b instanceof Fiction) fictionCount++;
            else nonFictionCount++;
        }
        
        System.out.println("Summary:");
        System.out.println("  Fiction books    : " + fictionCount);
        System.out.println("  NonFiction books : " + nonFictionCount);
        System.out.println("  Total books      : " + library.length);
    }
}