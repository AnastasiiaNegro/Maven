import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class JDBCTest {

    private static Statement statement;

    @BeforeAll
    public static void before() {
        statement = DatabaseService.getStatment();
    }

    @AfterAll
    public static void after() {
        DatabaseService.closeConnection(DatabaseService.getConnection());
    }

    //Написать тест проверяющий есть ли владельцы у машин
    @Test
    public void allOwnerMustBeHaveCar() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id_owner,name from car");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            assertTrue(resultSet.getInt("id_owner") > 0, "Car with name ".concat(name).concat(" don't have a owner"));
        }
    }

    //Написать тест проверяющий есть ли машины у владельца
    @Test
    public void allCarsMustBeHaveOwner() throws SQLException {
        ResultSet resultSet = statement.executeQuery("select id_owner, name from car");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            assertTrue(resultSet.getInt("id_owner") < 0, "Car with name ".concat(name).concat(" is have a owner"));
        }
    }

    //Написать тест проверяющий есть ли владельцы с более чем двумя машинами
    @Test
    public void ownerHasMoreThanTwoCar() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT owner.id, owner.name, count (car.name) \n" +
                "FROM owner\n" +
                "LEFT JOIN car ON owner.id = car.id_owner\n" +
                "GROUP by owner.id;");
        while (resultSet.next()) {
            String owner_name = resultSet.getString("name");
            assertTrue(resultSet.getInt("count (car.name)") < 2, "owner is ".concat(owner_name).concat(" has more than two car"));
        }
    }

    //    assertSame проверка возраста
    @Test
    public void legalAgeOfOwner() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT age\n" +
                "FROM owner;");
        assertSame(18, resultSet.getInt("age"), "Owner is ".concat(resultSet.getString("age")).concat(" years"));
    }
}




//        assertSame
//    @Test
//    public void legalAgeOfOwner() throws SQLException {
//        int [] years = new int [65];
//        int start = 16;
//        for (int i = 0; i < years.length; i++){
//            years[i]= start++;
//        }
//        ResultSet resultSet = statement.executeQuery("SELECT age\n" +
//                "FROM owner;");
//        assertSame(years, resultSet.getInt("age"), "Owner is ".concat(resultSet.getString("age")).concat(" years"));












