package library.persistence;

import library.model.Article;
import library.model.Book;
import library.model.CD;
import library.model.DVD;
import org.h2.jdbc.JdbcSQLSyntaxErrorException;

import java.sql.*;

public class LibraryDAOH2 implements LibraryDAO {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/library";

    static final String USER = "tp1";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createDatabase() {
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            String sql =  "CREATE TABLE   BOOK " +
                    "(id INTEGER not NULL, " +
                    " title VARCHAR(255) not NULL, " +
                    " author VARCHAR(255), " +
                    " editor VARCHAR(255), " +
                    " yearPublication VARCHAR(255), " +
                    " numbrePages NUMBER, " +
                    " typeDocument VARCHAR(255) CHECK(typeDocument IN('ROMAN','MANUEL_SCOLAIRE','ETUDE','MAGAZINE',NULL)), " +
                    " possibleQuantity NUMBER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

            stmt.close();
            conn.close();
        } catch(JdbcSQLSyntaxErrorException e) {
            handleException(e);
        } catch(SQLException se) {
            handleException(se);
        } catch(Exception e) {
            handleException(e);
        } finally {
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                handleException(se);
            }
        }
        System.out.println("Goodbye!");
    }

    public static void dropTable() {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DROP TABLE BOOK";
            stmt.executeUpdate(sql);
            System.out.println("Table deleted in given database...");
        } catch (SQLException e) {
            handleException(e);
        }
    }

    public void save(Article article) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            System.out.println("Inserting records into the table...");


                if(article instanceof Book){
                    String sql = "INSERT INTO BOOK VALUES (" +
                            article.getId() +  ", '" +
                            article.getTitle() + "', '" +
                            article.getAuthor() + "', '" +
                            article.getEditor() + "', '" +
                            article.getYearPublication() + "', '" +
                            article.getNumbrePages() + "', '" +
                            article.getTypeBook() + "', '" +
                            article.getPossibleQuantity() + "');";
                    stmt.executeUpdate(sql);
                }
                if(article instanceof CD){
                    String sql = "INSERT INTO CD VALUES (" +
                            article.getId() +  ", '" +
                            article.getTitle() + "', '" +
                            article.getDurationMovie() + "', '" +
                            article.getPossibleQuantity() + "');";
                    stmt.executeUpdate(sql);
                }
                if(article instanceof DVD){
                    String sql = "INSERT INTO DVD VALUES (" +
                            article.getId() +  ", '" +
                            article.getTitle() + "', '" +
                            article.getDurationMovie() + "', '" +
                            article.getPossibleQuantity() + "');";
                    stmt.executeUpdate(sql);
                }


            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            handleException(e);
        }
    }

    public void selectRecords(String QUERY) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                printResultat(rs);
            }
            System.out.println();
        } catch (SQLException e) {
            handleException(e);
        }
    }

    private static void printResultat(ResultSet rs) throws SQLException {
        System.out.print("ID: " + rs.getInt("id"));
        System.out.print(", Title: " + rs.getString("title"));
        System.out.println(", Type: " + rs.getString("typeDocument"));
        System.out.println(", Type: " + rs.getInt("possibleQuantity"));
    }
    private static void printResultatCDOrDVD(ResultSet rs) throws SQLException {
        System.out.print("ID: " + rs.getInt("id"));
        System.out.print(", Title: " + rs.getString("title"));
        System.out.println(", DurationMovie: " + rs.getString("durationMovie"));
    }

    public static void updateRecord(String QUERY, String sql) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            System.out.println("updated records");
            while(rs.next()){
                printResultat(rs);
            }
            System.out.println();
            rs.close();
        } catch (SQLException e) {
            handleException(e);
        }
    }

    public static void deleteRecord(String query, String sql) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {

            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Deleted record");
            while(rs.next()){
                printResultat(rs);
            }
            System.out.println();
            rs.close();
        } catch (SQLException e) {
            handleException(e);
        }
    }

    public static void whereClause(String sql) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {

            System.out.println("Fetching records with condition...");
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                printResultat(rs);
            }
            rs.close();
        } catch (SQLException e) {
            handleException(e);
        }
    }

    private static void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.println("Stacktrace: ");
        exception.printStackTrace();
    }


    public Article getArticle(int id) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement book = conn.prepareStatement("SELECT id, title, author,editor, yearPublication, typeDocument , numbrePages, possibleQuantity from BOOK WHERE id = ?");) {

            book.setInt(1,id);
            try (ResultSet rs = book.executeQuery()){
                System.out.println("records with id ?");
                rs.next();
                return new Book( rs.getInt("id"),rs.getString("title"),rs.getString("author"),rs.getString("editor"),rs.getString("yearPublication"),rs.getInt("numbrePages"),rs.getString("typeDocument"), rs.getInt("possibleQuantity"));
            }
        } catch (SQLException e) {
            handleException(e);
            return null;
        }
    }
}
