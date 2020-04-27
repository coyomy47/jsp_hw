package jsp_hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class UserDAO3 {

	private static User getUserFrom(ResultSet resultSet) throws SQLException {
	User user = new User();
	user.setId(resultSet.getInt("id"));
	user.setName(resultSet.getString("name"));
	user.setDepartmentId(resultSet.getInt("departmentId"));
	user.setDepartmentName(resultSet.getString("departmentName"));
	user.setEmail(resultSet.getString("email"));
	user.setUserType(resultSet.getString("userType"));
	return user;
	}

	public static List<User> findAll() throws Exception {
		String sql = "SELECT s.*, d.departmentName " + "FROM user s LEFT JOIN department d ON s.departmentId = d.id";
		try (Connection connection = DB.getConnection("student1");
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {
			ArrayList<User> list = new ArrayList<User>();
			while (resultSet.next()) {
				list.add(getUserFrom(resultSet));
			}
			return list;
		}
	}

	public static List<User> findByName(String name) throws Exception {
        String sql = "SELECT s.*, d.departmentName " +
                     "FROM user s LEFT JOIN department d ON s.departmentId = d.id " +
                     "WHERE s.name LIKE ?";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
            	ArrayList<User> list = new ArrayList<User>();
    			while (resultSet.next()) {
    				list.add(getUserFrom(resultSet));
    			}
                return list;
            }
        }
    }
    public static User findById(int id) throws Exception {
        String sql = "SELECT s.*, d.departmentName " +
                     "FROM user s LEFT JOIN department d ON s.departmentId = d.id " +
                     "WHERE s.id = ?";
        try (Connection connection = DB.getConnection("student1");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    return getUserFrom(resultSet);
                else
                    return null;
            }
        }
    }

}
