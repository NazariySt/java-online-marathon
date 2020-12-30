import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;

    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        this.statement = connection.createStatement();
        return this.statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        statement.executeUpdate("CREATE SCHEMA if not exists " + schemaName);
    }

    public void dropSchema() throws SQLException {
        statement.executeUpdate("DROP SCHEMA IF EXISTS " + schemaName + " CASCADE ");
    }

    public void useSchema() throws SQLException {
        statement.execute("SET SCHEMA " + schemaName);
    }

    public void createTableRoles() throws SQLException {
        statement.execute("CREATE TABLE Roles ("
                + " id INT NOT NULL AUTO_INCREMENT,"
                + " roleName VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY (`id`),"
                + " UNIQUE INDEX id_ROLES (`id` ASC));");
    }

    public void createTableDirections() throws SQLException {
        statement.executeUpdate("create table Directions ( " +
                "id int NOT NULL primary key AUTO_INCREMENT, " +
                "directionName varchar(30) NOT NULL UNIQUE " +
                ")");
    }

    public void createTableProjects() throws SQLException {
        statement.executeUpdate("create table Projects (" +
                "id int NOT NULL primary key AUTO_INCREMENT," +
                "projectName varchar(30) NOT NULL UNIQUE ," +
                "directionId int NOT NULL," +
                "FOREIGN KEY (directionId) REFERENCES Directions (id)" +
                ")");
    }

    public void createTableEmployee() throws SQLException {
        statement.executeUpdate("create table Employee (" +
                "id int NOT NULL primary key AUTO_INCREMENT," +
                "firstName varchar(30) NOT NULL," +
                "roleId int NOT NULL," +
                "projectId int NOT NULL," +
                "FOREIGN KEY (roleId) REFERENCES Roles (id)," +
                "FOREIGN KEY (projectId) REFERENCES Projects (id)" +
                ")");
    }

    public void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + " CASCADE ");
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.execute("INSERT INTO Roles (roleName) VALUES ('" + roleName + "');");
    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.executeUpdate("insert into Directions (directionName) values ('" + directionName + "')");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        int directionId = getDirectionId(directionName);
            statement.executeUpdate("insert into Projects (projectName, directionId) values ('" + projectName.trim() +
                    "', '" + directionId + "')");
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        int roleId = getRoleId(roleName);
        int projectId = getProjectId(projectName);
            statement.executeUpdate("insert into Employee (firstName,roleId,projectId) values ('" + firstName.trim() +
                    "', '" + roleId + "', '" + projectId + "')");

    }

    public int getRoleId(String roleName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id from Roles where roleName='" + roleName + "'");
        return resultSet.next() ? resultSet.getInt("id") : -1;
    }

    public int getDirectionId(String directionName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id from Directions where directionName='" + directionName + "'");
        return resultSet.next() ? resultSet.getInt("id") : -1;
    }

    public int getProjectId(String projectName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id from Projects where projectName='" + projectName + "'");
        return resultSet.next() ? resultSet.getInt("id") : -1;

    }

    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id from Employee where firstName='" + firstName + "'");
        return resultSet.next() ? resultSet.getInt("id") : -1;

    }

    public List<String> getAllRoles() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select roleName from Roles");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllDirestion() throws SQLException {

        ResultSet resultSet = statement.executeQuery("select directionName from Directions");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllProjects() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select projectName from Projects");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllEmployee() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select firstName from Employee");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllDevelopers() throws SQLException {
        int developers = getRoleId("Developer");
        ResultSet resultSet = statement.executeQuery("select firstName from Employee where roleId='" + developers + "'");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllJavaProjects() throws SQLException {
        int java = getDirectionId("Java");
        ResultSet resultSet = statement.executeQuery("select projectName from Projects where directionId='" + java + "'");
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;

    }

    public List<String> getAllJavaDevelopers() throws SQLException {

        int java = getDirectionId("Java");
        int developer = getRoleId("Developer");

        ResultSet resultSet = statement.executeQuery("select firstName from Employee where projectId in(" +
                "select id from Projects where directionId='" + java + "') and roleId=" + developer);
        List<String> list = new ArrayList<>();
        while (resultSet.next()) list.add(resultSet.getString(1));
        return list;
    }
}
