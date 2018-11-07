
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class DAO {
    
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource) {
 	this.myDataSource = dataSource;
    }    
    
    public List<CodeDiscount> getAllDiscountCode() throws SQLException {
        List<CodeDiscount> result = new ArrayList<CodeDiscount>();
  
        String sql = "SELECT AS NUMBER FROM DISCOUNT_CODE";
        try (Connection connection = myDataSource.getConnection();
            Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String code  = rs.getString("discount_code");
                float rate = rs.getFloat("rate");
                CodeDiscount c = new CodeDiscount(code.charAt(0),rate);
 		result.add(c);
            }
 	}
        return result;      
    }  
    
    public void createDiscount(char code,float rate) throws Exception {
        
        String sql_final = "INSERT INTO discount_code VALUES(?,?)";
        
        CodeDiscount c = new CodeDiscount(code,rate);
        
         try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql_final))
           { 
                stmt.setObject(1, c.getCode()); 
	        stmt.setObject(2, c.getRate());
                stmt.executeUpdate();
           }       
    }
    
    public void deleteDiscount(char code) throws DAOException, SQLException {
        
        String sql = "DELETE FROM discount_code WHERE code = ?";
        
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setObject(1, code);
            stmt.executeUpdate();
        } 
    }
}
