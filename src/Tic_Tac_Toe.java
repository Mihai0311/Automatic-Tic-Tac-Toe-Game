import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {

	public static void main(String[] args) {

		char[][] board = new char[3][3];

		for(int i=0;i<board.length;i++) {
			
			for(int j=0; j< board[i].length;j++) {
				
				board[i][j] = '*';
				
			}
		}

		
		
		
		Random rand = new Random();
		
		boolean game_over = false;
		
        char current_symbol = 'X'; // Start with 'X' symbol

		
		while(!game_over) {
			
			// print_board(board);
	          
			 System.out.println(" -----------------");

	            int random_row, random_col;

	            do {
	            
	            	random_row = rand.nextInt(board.length);
	                random_col = rand.nextInt(board.length);
	         
	            } while (board[random_row][random_col] != '*');   //finds an empty cell

	            board[random_row][random_col] = current_symbol;
	           
	            print_board(board);  //displying the board after each move
	            
	            System.out.println(" -----------------");

	            if (has_won(board, current_symbol)) {
	              
	            	System.out.println(current_symbol + " wins!");
	                game_over = true;
	            
	            } else if (full_board(board)) {
	            
	            	System.out.println("It's a draw!");
	                game_over = true;
	            
	            } else {
	             
	            	// Alternate between 'X' and '0' symbols for each turn
	                current_symbol = (current_symbol == 'X') ? '0' : 'X';
			 
		}
            
		}
		
	}
	
	public static void print_board(char [][] board) {
		

		for(int i=0;i<board.length;i++) {
			
			for(int j=0; j< board[i].length;j++) {
				
				System.out.print(board[i][j] + " ");
				
			}
			
			 System.out.println();
		}
		
	}
	
	public static boolean has_won(char[][] board, char symbol) {
	    // check the rows
	  
		for (int row = 0; row < board.length; row++) {
	    
			if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol) {
	        
				return true;
	      }
	    }

	    // check for col
	    for (int col = 0; col < board[0].length; col++) {
	      
	    	if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol) {
	        
	    		return true;
	      }
	    }

	    // diagonal
	    if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
	      
	    	return true;
	    }

	    if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
	      
	    	return true;
	    }
	    return false;
	  }
	
	   public static boolean full_board( char[][] board) {
	        
		   for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	       
	            	if (board[i][j] == '*') {
	        
	            		return false;  //the table is not full yet
	                
	            	}
	            }
	        }
	        return true;   //the table is full
	    }
	
	
}

