/**
 * 
 */
package barista.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gregd
 *
 */
public class Application {

	static Inventory inventory = new Inventory();
	static Menu menu = new Menu();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	      BufferedReader br = null;

	        try {

	            br = new BufferedReader(new InputStreamReader(System.in));

	            inventory.printInventory();
	            menu.printMenu(inventory);
	            
	            while (true) {
	            	
	            	
	            	System.out.print("enter option >");
	            	
	                String input = br.readLine();

	                boolean validselection = true;
	                
	                if ("q".equalsIgnoreCase(input)) {
	                    System.exit(0);
	                }
	                
	                if ("r".equalsIgnoreCase(input)) {
	                	inventory = new Inventory();
	                	
	                }else{
		                int m = -1;
		                
		                try { 
		                	m = Integer.parseInt(input); 
		                	validselection = menu.dispense(m , inventory);
		                } catch(Exception e) { 
		                	validselection = false;
		                }
		                
	                }
	                if(validselection){
	                	inventory.printInventory();
	                	menu.printMenu(inventory);
	                }else{
	                	System.out.println("invalid selection, try again.");
	                }

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}
	

}
