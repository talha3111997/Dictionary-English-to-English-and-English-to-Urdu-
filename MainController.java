/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import java.util.ArrayList; 
import java.util.Scanner;
import javafx.scene.control.Label;

import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;


/**
 *
 * @author ASFAND
 */
public class MainController {
    @FXML 
    private JFXButton proceed;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton search1;
    @FXML
    private Label meaning;
    
    
    Stage primaryStage2 = new Stage();
    Map<String, String>map = new Map<>();
    String key,value;
    int flag = 0 ;
    int flagUrdu = 0;
    public void enter(ActionEvent event)throws Exception{
        

        Parent root;
        root = FXMLLoader.load(getClass().getResource("2ndpage.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
         primaryStage2.initStyle(StageStyle.UNDECORATED);
         primaryStage2.setTitle("Dictionary");
         primaryStage2.setScene(scene);
         primaryStage2.show();
    }
    
    public void search(ActionEvent event)throws Exception{
        
        
        if(flag == 0){
        File file = new File("C:\\Users\\Muhammad Talha\\Desktop\\DSA\\Dictionary.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            key = toLowerCase(scanner.next());
            value = scanner.nextLine();
            map.add(key,value);
            meaning.setText("yoooo");
        }
        flag++;
        }
        String key1 = search.getText();
        key1 = toLowerCase(key1);
        String value1 = map.get(key1);
        if (value1 == null){
            meaning.setText("SORRY, WORD NOT FOUND");
        } else {
            meaning.setText(value1);
        }
        
    }
    
       public void enter_urdu(ActionEvent event)throws Exception{
        

        Parent root;
        root = FXMLLoader.load(getClass().getResource("urdu.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
         primaryStage2.initStyle(StageStyle.UNDECORATED);
         primaryStage2.setTitle("Dictionary");
         primaryStage2.setScene(scene);
         primaryStage2.show();
    }
    
    public void search_urdu(ActionEvent event)throws Exception{
        
        
        if(flagUrdu == 0){
        File file = new File("C:\\Users\\Muhammad Talha\\Desktop\\DSA\\urdu1.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            key = toLowerCase(scanner.next());
            value = scanner.nextLine();
            map.add(key,value);
            meaning.setText("yoooo");
        }
        flagUrdu++;
        }
        String key1 = search.getText();
        key1 = toLowerCase(key1);
        String value1 = map.get(key1);
        if (value1 == null){
            meaning.setText("ہم معذرت خواہ ہیں آپ کا مطلوبہ لفظ موجود نہیں");
        } else {
            meaning.setText(value1);
        }
        
    }
    
}



class HashNode<K, V> 
{ 
	K key; 
	V value; 

	// Reference to next node 
	HashNode<K, V> next; 

	// Constructor 
	public HashNode(K key, V value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 

// Class to represent entire hash table 
class Map<K, V> 
{ 
	// bucketArray is used to store array of chains 
	private ArrayList<HashNode<K, V>> bucketArray; 

	// Current capacity of array list 
	private int numBuckets; 

	// Current size of array list 
	private int size; 

	// Constructor (Initializes capacity, size and 
	// empty chains. 
	public Map() 
	{ 
		bucketArray = new ArrayList<>(); 
		numBuckets = 1000; 
		size = 0; 

		// Create empty chains 
		for (int i = 0; i < numBuckets; i++) 
			bucketArray.add(null); 
	} 

	public int size() { return size; } 
	public boolean isEmpty() { return size() == 0; } 

	// This implements hash function to find index 
	// for a key 
	private int getBucketIndex(K key) 
	{ 
		int hashCode = key.hashCode(); 
                if(hashCode<0)
                    hashCode *= -1;
		int index = hashCode % numBuckets; 
		return index; 
	} 

	// Method to remove a given key 
	public V remove(K key) 
	{ 
		// Apply hash function to find index for given key 
		int bucketIndex = getBucketIndex(key); 

		// Get head of chain 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Search for key in its chain 
		HashNode<K, V> prev = null; 
		while (head != null) 
		{ 
			// If Key found 
			if (head.key.equals(key)) 
				break; 

			// Else keep moving in chain 
			prev = head; 
			head = head.next; 
		} 

		// If key was not there 
		if (head == null) 
			return null; 

		// Reduce size 
		size--; 

		// Remove key 
		if (prev != null) 
			prev.next = head.next; 
		else
			bucketArray.set(bucketIndex, head.next); 

		return head.value; 
	} 

	// Returns value for a key 
	public V get(K key) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Search key in chain 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
				return head.value; 
			head = head.next; 
		} 

		// If key not found 
		return null; 
	} 

	// Adds a key value pair to hash 
	public void add(K key, V value) 
	{ 
		// Find head of chain for given key 
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		// Check if key is already present 
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
			{ 
				head.value = value; 
				return; 
			} 
			head = head.next; 
		} 

		// Insert key in chain 
		size++; 
		head = bucketArray.get(bucketIndex); 
		HashNode<K, V> newNode = new HashNode<K, V>(key, value); 
		newNode.next = head; 
		bucketArray.set(bucketIndex, newNode); 

		// If load factor goes beyond threshold, then 
		// double hash table size 
		if ((1.0*size)/numBuckets >= 0.7) 
		{ 
			ArrayList<HashNode<K, V>> temp = bucketArray; 
			bucketArray = new ArrayList<>(); 
			numBuckets = 2 * numBuckets; 
			size = 0; 
			for (int i = 0; i < numBuckets; i++) 
				bucketArray.add(null); 

			for (HashNode<K, V> headNode : temp) 
			{ 
				while (headNode != null) 
				{ 
					add(headNode.key, headNode.value); 
					headNode = headNode.next; 
				} 
			} 
		} 
        }
}