
package Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Menu.Ingreso;
import Menu.VerAlumnos;
import Menu.VerProfes;

public class Administrador {
     Connection conexion = null;
    Statement sentencia = null;
   
    public void crearAlumno()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
            sentencia = conexion.createStatement();
            
            String SQL = "CREATE TABLE ALUMNO" + 
                    "(ID_ALUMNO   INT  PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE    TEXT    NOT NULL," +
                    " APELLIDO    TEXT NOT NULL,"
                    +" CURSO INT NOT NULL )";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
          JOptionPane.showMessageDialog(null,"Error"+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error: " + e.getMessage());
            System.exit(0);   //Termina la ejecución de la JVM    
        }
        
        System.out.println("Base de datos creada!");
        
    }
     public void crearProfe()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
            sentencia = conexion.createStatement();
            
            String SQL = "CREATE TABLE PROFESOR" + 
                    "(ID_PROFESOR        INT     PRIMARY KEY NOT NULL,"+ 
                    " NOMBRE    TEXT    NOT NULL," +
                    " APELLIDO      TEXT NOT NULL,"+
                    "ASIGNATURA TEXT NOT NULL)";
            
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
          JOptionPane.showMessageDialog(null,"Error"+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error: " + e.getMessage());
            System.exit(0);   //Termina la ejecución de la JVM    
        }
        
        System.out.println("Base de datos creada!");
        
    }

    public void insertarAlumnos(int ID_ALUMNO , String NOMBRE , String APELLIDO , int CURSO)
    {
        try
        {
            
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            
            JOptionPane.showMessageDialog(null, "Alumno ya Existente");
            String SQL = "INSERT INTO ALUMNO (ID_ALUMNO, NOMBRE,  APELLIDO , CURSO) " +
                    "VALUES ('"+ID_ALUMNO+"','"+NOMBRE+"','"+APELLIDO+"','"+CURSO+"')";
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
             JOptionPane.showMessageDialog(null,"Error"+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
        
    }
     public void insertarProfesores(int ID_PROFESOR , String NOMBRE , String APELLIDO , String ASIGNATURA)
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
            conexion.setAutoCommit(false);
            sentencia = conexion.createStatement();
            String SQL = "INSERT INTO PROFESOR (ID_PROFESOR, NOMBRE,  APELLIDO , ASIGNATURA) " +
                    "VALUES ('"+ID_PROFESOR+"','"+NOMBRE+"','"+APELLIDO+"','"+ASIGNATURA+"')";
            sentencia.executeUpdate(SQL);
            sentencia.close();
            conexion.commit();
            conexion.close();
            
        }
        catch(ClassNotFoundException | SQLException e)
        {
             JOptionPane.showMessageDialog(null,"Error"+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Datos Ingresados Correctamente");
        
    }
        public void actualizarAlumnos(int ID_ALUMNO , String NOMBRE , String APELLIDO , int CURSO){

                  try{
                    Class.forName("org.sqlite.JDBC");
                    conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
                    conexion.setAutoCommit(false);  //establece confirmación automática
                    sentencia=conexion.createStatement();

                    String Query="UPDATE ALUMNO SET  NOMBRE='"+NOMBRE+"', APELLIDO='"+APELLIDO+"', CURSO='"+CURSO+"' WHERE ID_ALUMNO='"+ID_ALUMNO+"'";
                    sentencia.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    conexion.commit();  //guardar los cambios
                    
                    sentencia.close();
                    conexion.close();
                  }catch(ClassNotFoundException | SQLException ex){
                      JOptionPane.showMessageDialog(null,"Error"+ ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                       System.exit(0);
                  }
                   
                }
       public void actualizarProfesor(int ID_PROFESOR, String NOMBRE , String APELLIDO ,String ASIG){

                  try{
                    Class.forName("org.sqlite.JDBC");
                    conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
                    conexion.setAutoCommit(false);  //establece confirmación automática
                    sentencia=conexion.createStatement();

                    String Query="UPDATE PROFESOR SET  NOMBRE='"+NOMBRE+"', APELLIDO='"+APELLIDO+"', ASIGNATURA='"+ASIG+"' WHERE ID_PROFESOR='"+ID_PROFESOR+"'";
                    sentencia.executeUpdate(Query);
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    conexion.commit();  //guardar los cambios
                    
                    sentencia.close();
                    conexion.close();
                  }catch(ClassNotFoundException | SQLException ex){
                      JOptionPane.showMessageDialog(null,"Error"+ ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                       System.exit(0);
                  }
                   
                }
       public void eliminarProfe(int ID){

                      try{
                          Class.forName("org.sqlite.JDBC");
                          conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
                          conexion.setAutoCommit(false);
                          sentencia=conexion.createStatement();

                          String Query="DELETE FROM PROFESOR WHERE ID_PROFESOR='"+ID+"'";
                          sentencia.executeUpdate(Query);

                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
                          conexion.commit();
                          sentencia.close();
                          conexion.close();

                      }catch(ClassNotFoundException | SQLException ex){
                             System.err.println("Error:"+ex.getMessage());
                             System.exit(0);
                      }   
                      
                    }
       public void eliminarALUMNO(int ID){

                      try{
                          Class.forName("org.sqlite.JDBC");
                          conexion = DriverManager.getConnection("jdbc:sqlite:Colegio.sqlite");
                          conexion.setAutoCommit(false);
                          sentencia=conexion.createStatement();

                          String Query="DELETE FROM ALUMNO WHERE ID_ALUMNO='"+ID+"'";
                          sentencia.executeUpdate(Query);

                        JOptionPane.showMessageDialog(null, "Registro Eliminado");
                          conexion.commit();
                          sentencia.close();
                          conexion.close();

                      }catch(ClassNotFoundException | SQLException ex){
                             System.err.println("Error:"+ex.getMessage());
                             System.exit(0);
                      }
 
       }
     public static void main (String[]args){
       Ingreso v = new Ingreso();
       v.setVisible(true);
      // Administrador Ve=new Administrador();
      // Ve.crearAlumno();
      // Ve.crearProfe();
      
     }
   
}
