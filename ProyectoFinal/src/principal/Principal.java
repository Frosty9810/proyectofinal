package principal;

 
import java.sql.SQLException;
import java.util.Scanner;



public class Principal {
  public static void main(String[] args){

	  Scanner scanner = new Scanner(System.in);
	  
	  
	  try {
		menu.view.menuMenu.menu(scanner);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  scanner.close();
	  
	  
	  
	  
  }
}
