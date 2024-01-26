package CodTechSolutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class encryptDecrypt {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        try 
	        {
	        	System.out.print("Enter the file path: ");
	            String filePath = sc.nextLine();
	            String originalText = readFile(filePath);
	            System.out.print("Enter the encryption key: ");
	            int encryptionKey = sc.nextInt();
	            String encryptedText = encrypt(originalText, encryptionKey);
	            String encryptedFilePath = filePath.replace(".txt", "_encrypted.txt");
	            saveToFile(encryptedFilePath, encryptedText);
	            System.out.println("Text successfully encrypted and saved to: " + encryptedFilePath);
	            System.out.print("Enter the decryption key: ");
	            int decryptionKey = sc.nextInt();
	            String decryptedText = encrypt(encryptedText, 26-decryptionKey);
	            String decryptedFilePath = filePath.replace(".txt", "_decrypted.txt");
	            saveToFile(decryptedFilePath, decryptedText);
	            System.out.println("Text successfully decrypted and saved to: " + decryptedFilePath);
	        } 
	            catch (IOException | NumberFormatException e)
	        {
	            e.printStackTrace();
	        }
	        sc.close();
	    }

	   public static String readFile(String filePath) throws IOException
	    {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	        {
	            String line;
	            while ((line = br.readLine()) != null)
	            {
	                content.append(line).append("\n");
	            }
	        }
	        return content.toString();
	    }
	    public static void saveToFile(String filePath, String content) throws IOException
	    {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
	        {
	            writer.write(content);
	        }
	    }

	    public static String encrypt(String text, int key)
	    {
	        StringBuilder encryptedText = new StringBuilder();
	        for (char c : text.toCharArray())
	        {
	            if (Character.isLetter(c))
	            {
	                char base = Character.isUpperCase(c) ? 'A' : 'a';
	                encryptedText.append((char) ((c - base + key) % 26 + base));
	            }
	            else
	            {
	                encryptedText.append(c);
	            }
	        }
	        return encryptedText.toString();
	    }
}
