import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BooksParser {
        private Connection connect = null;
        private Statement statement = null;
        private ResultSet resultSet = null;
        private PreparedStatement preparedStatement = null;
        private static String input;

        public static void main(String[] args) throws Exception {
            readCSV();
            BooksParser BP = new BooksParser();
            Scanner in = new Scanner(System.in);
            System.out.println("enter path/name of the file");
            input = in.nextLine();
        }
        private void writeResultSet(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                String title= resultSet.getString("title");
                String author = resultSet.getString("author");
                String user_Rating = resultSet.getString("user_rating");
                String review = resultSet.getString("reviews");
                String price = resultSet.getString("price");
                String year = resultSet.getString("year");
                String genre = resultSet.getString("genre");

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Rating: " + user_Rating);
                System.out.println("Reviews: " + review);
                System.out.println("Price: $ " + price);
                System.out.println("Year: " + year);
                System.out.println("Genre: " + genre);


                System.out.print("\t --> ");

            }
        }
        private static void readCSV(){
            BufferedReader br = null;
            int total = 0;
            int average = 0;
            ArrayList<Integer> bookList = new ArrayList<>();
            try {
                br = new BufferedReader(new FileReader(input));
                String line;
                br.readLine(); //reads the header
                while ((line = br.readLine()) != null) {
                    String[] BooksDetails = line.split(" ");
                    if (BooksDetails.length > 0) {
                         bookList.add(Integer.parseInt(BooksDetails[0]));
                          total += Integer.parseInt(BooksDetails[0]);
                          average = total/bookList.size();
                         System.out.println("average" +  average + "total" +total);
                    }
                }

                /*for (Books e : bookList) {
                    System.out.println(e);
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException ioe) {
                    System.out.println("Error occured while closing the Buffered Reader");
                    ioe.printStackTrace();
                }
            }
        }
        private void close() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        }
