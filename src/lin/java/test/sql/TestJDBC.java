package lin.java.test.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJDBC {

    public static void main(String[] args) {
            queryForList();
    }

    public static List<Map<String,Object>> queryForList(){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<Map<String,Object>> resultList =new ArrayList<Map<String,Object>>();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/lin?characterEncoding=utf-8&useSSL=false&autoReconnect=true";
            String username = "root";
            String password = "root";

            connection = DriverManager.getConnection(url,username,password);

            String sql = "select * from account where username = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"小王");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int num = rsmd.getColumnCount();
            while (resultSet.next()){
                Map map = new HashMap();
                for(int i = 0; i < num;i++){
                    String columnName = rsmd.getColumnName(i+1);
                    map.put(columnName,resultSet.getString(columnName));

                }
                resultList.add(map);
            }
            System.out.println(resultList);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
}
