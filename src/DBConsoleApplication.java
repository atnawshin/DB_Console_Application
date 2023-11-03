import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class DBConsoleApplication {
    private final String USERNAME = "user";
    private final String PASSWORD = "user";
    private final String HOSTNAME = "192.168.0.152";
    private final String DBNAME = "studentdb";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

//    Create data or insert data
    private void insertData(){
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            System.out.println("Connection OK!");

            String query = "insert into student values(105,'Bela bosh','some where in BD','2441139');";

            Statement statement = connection.createStatement();

            statement.executeUpdate(query);
            System.out.println("Record inserted");

            connection.close();

        } catch (SQLException sqle) {
//            throw new RuntimeException(sqle);
            System.out.println(("something" + sqle));
        }
    }

//    Read data or retrieve data
    public void retrieveData(){
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            System.out.println("Connection OK!");

            String query = "select * from student;";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Retrieve Data");

//            next returns a boolean
            while (resultSet.next()){
                int studentId = resultSet.getInt("id");
                String studentName = resultSet.getString("name");
                System.out.println(studentId + " " + studentName);
            }

            connection.close();

        } catch (SQLException sqle) {
//            throw new RuntimeException(sqle);
            System.out.println(("something" + sqle));
        }
    }

//    Update data
    public void updateData(){
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            System.out.println("Connection OK!");

            String query = "update student set name = 'Karim Rahman' where id = 104;";

            Statement statement = connection.createStatement();

            int resultSet = statement.executeUpdate(query);
            System.out.println("Data updated");

//            next returns a boolean
            if(resultSet >0){
                System.out.println("Student updated successfully");
            }

            connection.close();

        } catch (SQLException sqle) {
//            throw new RuntimeException(sqle);
            System.out.println(("something went wrong!" + sqle));
        }
    }

//Delete data
    public void deleteData(){
        try {
            System.out.println("Connecting to the database...");
            Connection connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
            System.out.println("Connection OK!");

            String query = "delete from student where id = 105;";

            Statement statement = connection.prepareStatement(query);

            int resultSet = statement.executeUpdate(query);
            if(resultSet > 0){
                System.out.println("Data deleted");
            }

            connection.close();

        } catch (SQLException sqle) {
//            throw new RuntimeException(sqle);
            System.out.println(("something went wrong!" + sqle));
        }
    }


//    constructor
    public DBConsoleApplication() {
//        insertData();
//        retrieveData();
//          deleteData();
          updateData();
    }

    public static void main(String[] args) {

        DBConsoleApplication a = new DBConsoleApplication();
    }
}