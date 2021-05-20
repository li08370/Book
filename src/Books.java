public class  Books {
        private String title, author, genre;
        private double user_Rating, price, year, review;

    Books(String title, String author, double user_Rating, double review, double price, double year, String genre ){
            this.title = title;
            this.author = author;
            this.user_Rating = user_Rating;
            this.review = review;
            this.price = price;
            this.year = year;
            this.genre = genre;
        }

    public String getTitile() {
            return title;
        }
    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

        @Override
        public String toString() {
            return "Books{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", genre='" + genre + '\'' +
                    ", user_Rating=" + user_Rating +
                    ", price=" + price +
                    ", year=" + year +
                    '}';
        }

        public void setTitle(String titile) {
            this.title = titile;
        }

        public String getTitle(){
            return title;
        }

        public void setAuthor(String author){
            this.author = author;
        }

        public String getAuthor(){
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public double getUser_Rating() {
            return user_Rating;
        }

        public void setUser_Rating(double user_Rating) {
            this.user_Rating = user_Rating;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getYear() {
            return year;
        }

        public void setYear(double year) {
            this.year = year;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Books) {
                Books otherBook = (Books) obj;
                if (this.title.equalsIgnoreCase(otherBook.title)) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Books books){
            return (title.compareToIgnoreCase(books.getTitle()));
        }
    }



