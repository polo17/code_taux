
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class DAO {
    
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource) {
 	this.myDataSource = dataSource;
    }    
    
    public List<CodeDiscount> getAllDiscountCode() throws SQLException {
        List<CodeDiscount> result = new ArrayList<CodeDiscount>();
  
        String sql = "SELECT * FROM DISCOUNT_CODE";
        try (Connection connection = myDataSource.getConnection();
            Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String code  = rs.getString("discount_code");
                float rate = rs.getFloat("rate");
                CodeDiscount c = new CodeDiscount(code,rate);
 		result.add(c);
            }
 	}
        return result;      
    }  
    
    public void createDiscount(String code,float rate) throws Exception {
        
        String sql_final = "INSERT INTO discount_code VALUES(?,?)";
        
        //CodeDiscount c = new CodeDiscount(code,rate);
        
         try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql_final))
           { 
                stmt.setString(1, code); 
	        stmt.setFloat(2, rate);
                stmt.executeUpdate();
           }       
    }
    
    public void deleteDiscount(String code) throws DAOException, SQLException {
        
        String sql = "DELETE FROM discount_code WHERE code = ?";
        
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) 
        {
            stmt.setString(1, code);
            stmt.executeUpdate();
        } 
    }
    
    public int updateDiscount_Code(String code,Float taux) throws Exception {

        String sql = "UPDATE APP.DISCOUNT_CODE SET RATE = ? WHERE DISCOUNT_CODE = ?";
        try (   Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)
                ) {
            stmt.setFloat(1, taux);
                        stmt.setString(2, code);
            
            return stmt.executeUpdate();

        }  catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new Exception(ex.getMessage());
        }
    }
}
