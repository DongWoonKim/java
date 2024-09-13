package notice;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    private Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/notice"; // 데이터베이스 URL
        final String USER = "root"; // 데이터베이스 사용자 이름
        final String PASSWORD = "1234"; // 데이터베이스 비밀번호

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean sigupExc(String userId, String password, String name) {
        String query = "INSERT INTO user (user_id, password, name) VALUES (?, ?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            int rowInserted = preparedStatement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean checkUserId(String userId) {
        String query = "SELECT COUNT(*) FROM user WHERE user_id = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
                return resultSet.getInt(1) > 0;

            throw new RuntimeException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public SignInResponseDTO signInExc(String userId, String password) {
        String query = "SELECT user_id, name, password FROM USER WHERE user_id =?";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String pw = resultSet.getString("password");
                String id = resultSet.getString("user_id");

                if (!password.equals(pw)) {
                    // 비밀번호가 일치하지 않는 상황
                    return new SignInResponseDTO(false, null, null);
                }

                return new SignInResponseDTO(true, id, name);
            } else {
                // userId가 존재하지 않는 상황
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean newNotice(String userId, String content) {
        String query = "INSERT INTO content (user_id, content) VALUES (?, ?)";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, content);

            int rowInserted = preparedStatement.executeUpdate();
            return rowInserted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getList() {
        String query = "SELECT id, user_id, content, created FROM content";
        List<String> returnList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userId = resultSet.getString("user_id");
                String content = resultSet.getString("content");
                String created = resultSet.getString("created");

                String str = "[" + id + "] " + userId + " - " + content + " - " + created;
                returnList.add(str);
            }

            return returnList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getListByUserId(String userId) {
        String query = "SELECT id, user_id, content, created FROM content WHERE user_id = ?";
        List<String> returnList = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String content = resultSet.getString("content");
                String created = resultSet.getString("created");

                String str = "[" + id + "] " + userId + " - " + content + " - " + created;
                returnList.add(str);
            }

            return returnList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateNotice(int contentId, String content) {
        String query = "UPDATE content SET content = ?, created = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, content);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(3, contentId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteNotice(int contentId) {
        String query = "DELETE FROM content WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, contentId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean leaveExc(String userId) {
        String query = "DELETE FROM user WHERE user_id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteContentExc(String userId) {
        String query = "DELETE FROM content WHERE user_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
