package LessonOOP.polymorfizm_nasledovanie;

//public class Book {
//    private String name;
//    private String code;
//    private int pages;
//
//    public Book(String name, String code, int pages) {
//        this.name = name;
//        this.code = code;
//        this.pages = pages;
//    }
//
//    public String getBookData() {
//        return "Book{" +
//                "name='" + name + '\'' +
//                ", code='" + code + '\'' +
//                ", pages=" + pages +
//                '}';
//    }
//}
//
//
//class ScientificBook extends Book{
//    private int price;
//    private String publisher;
//
//    public ScientificBook(String name, String code, int pages, int price, String publisher) {
//        super(name, code, pages);
//        this.price = price;
//        this.publisher = publisher;
//    }
//
//    @Override
//    public String getBookData() {
//        return super.getBookData();
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getPublisher() {
//        return publisher;
//    }
//
//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }
//}
//
//class LiteratureBook extends Book{
//    private String author;
//    private int yearOfPublishing;
//
//    public LiteratureBook(String name, String code, int pages, String author, int yearOfPublishing) {
//        super(name, code, pages);
//        this.author = author;
//        this.yearOfPublishing = yearOfPublishing;
//    }
//
//    @Override
//    public String getBookData() {
//        return super.getBookData();
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public int getYearOfPublishing() {
//        return yearOfPublishing;
//    }
//
//    public void setYearOfPublishing(int yearOfPublishing) {
//        this.yearOfPublishing = yearOfPublishing;
//    }
//}
//
//class Library extends Book{
//    private String name;
//    private String city;
//    private String country;
//    private Book[] books;
//    private int sizeOfBooks = 0;
//
//    public Library() {
//        this.books = new Book[10]; // Предполагаем, что изначально массив вмещает 10 книг
//        this.sizeOfBooks = 0;
//    }
//
//    // Конструктор с параметрами
//    public Library(String name, String city, String country, Book[] books) {
//        this.name = name;
//        this.city = city;
//        this.country = country;
//        this.books = books;
//        this.sizeOfBooks = books.length;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    void addBook(Book b){
//        if (sizeOfBooks < books.length) {
//            books[sizeOfBooks] = b;
//            sizeOfBooks++;
//        }
//    }
//    public void printLibraryData() {
//        System.out.println("Library Name: " + name);
//        System.out.println("City: " + city);
//        System.out.println("Country: " + country);
//        System.out.println("Books in Library:");
//        for (int i = 0; i < sizeOfBooks; i++) {
//            System.out.println(books[i].getBookData());
//        }
//    }
//}