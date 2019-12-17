/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;
import java.io.IOException;
import java.util.ArrayList; 
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Dictionary extends Application{

    @Override
    public void start(Stage primaryStage) {
      

       try{  
       Parent root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
       Scene scene = new Scene(root);
       scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
       
       primaryStage.initStyle(StageStyle.UNDECORATED);
       primaryStage.setScene(scene);
       primaryStage.show();
       
       
       
    }
       catch(IOException e){
           e.printStackTrace();
       }
    }

    
    public void close(){
            
        }
  
   
public static void main(String[] args) {
        launch(args);
        
    }
}
//        Map<String, String>map = new Map<>();
//        String key,value;
//        File file = new File("C:\\Users\\ASFAND\\Desktop\\Nust 3rd Semester\\Data Structures and Algorithms\\Project\\Dictionary.txt.txt");
//        Scanner scanner = new Scanner(file);
//        while(scanner.hasNext()){
//            key = toLowerCase(scanner.next());
//            value = scanner.nextLine();
//            map.add(key,value);
//        }
//        
//        Scanner input = new Scanner(System.in);
//        String word = toLowerCase(input.next());
//         System.out.println(map.get(word));
//        
        
    
    

// Java program to demonstrate implementation of our 
// own hash table with chaining for collision detection 


// A node of chains 



