package conexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class Main {

	 public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String myUrl = "jdbc:mysql://localhost:3306/prueba";
        Connection conn = 
                DriverManager.getConnection(myUrl, "root", "");
        // Aqui se hace la query
        String query = "SELECT * FROM EMPLOYEES";
        
         // ¿create the java statement?
        Statement st = conn.createStatement();
        
        // De esta manera ejecutamos en Java la query.
        // rs es la variable que guardara los datos de la consulta.
        ResultSet rs = st.executeQuery(query);
               
        System.out.println("id \t nombre\t apellido\t");
        
        // Imprimir los datos que hemos conseguido de la consulta.
        while (rs.next())
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+
                    "\t"+rs.getString(3));
    }
}