package dao;

import domain.PersonRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import web.AddPersonServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonAddDao {

    private static final Logger logger = LoggerFactory.getLogger(AddPersonServlet.class);

    private static final String SQL_REQUEST = "INSERT INTO client (given_name, sur_name, patronymic) Values (?, ?, ?)";

    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder){
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException{
        return connectionBuilder.getConnection();
    }


    public int addPerson(PersonRequest request) {
        logger.info("addition is started ");

        int rows = 0;

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_REQUEST)){

            stmt.setString(1, request.getGivenName());
            stmt.setString(2, request.getSurName());
            stmt.setString(3, request.getPatronymic());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
