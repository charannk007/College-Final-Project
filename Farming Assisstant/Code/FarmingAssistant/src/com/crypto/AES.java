package com.crypto;

import java.security.Key;
import java.util.ArrayList;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.blockchain.Block;
import com.blockchain.StringUtil;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AES {
	private static String algorithm = "AES";
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	private static byte[] keyValue=new byte[] 
	{ 'A', 'S', 'e', 'c', 'u', 'r', 'e', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	        // Performs Encryption
	        public static String encrypt99(String plainText) throws Exception 
	        {
	                Key key = generateKey();
	                Cipher chiper = Cipher.getInstance(algorithm);
	                chiper.init(Cipher.ENCRYPT_MODE, key);
	                byte[] encVal = chiper.doFinal(plainText.getBytes());
	                String encryptedValue = new BASE64Encoder().encode(encVal);
	                return encryptedValue;
	        }

	        // Performs decryption
	        public static String decrypt(String encryptedText) throws Exception 
	        {
	                // generate key 
	                Key key = generateKey();
	                Cipher chiper = Cipher.getInstance(algorithm);
	                chiper.init(Cipher.DECRYPT_MODE, key);
	                byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
	                byte[] decValue = chiper.doFinal(decordedValue);
	                String decryptedValue = new String(decValue);
	                return decryptedValue;
	        }

	//generateKey() is used to generate a secret key for AES algorithm
	        private static Key generateKey() throws Exception 
	        {
	                Key key = new SecretKeySpec(keyValue, algorithm);
	                return key;
	        }

	        // performs encryption & decryption 
	        public static void main(String[] args) throws Exception 
	        {

	                String plainText = "Password";
	                String encryptedText = AES.encrypt99(plainText);
	                
//	        		System.out.println("Trying to Mine block 1... ");
	        		addBlock(new Block(encryptedText, "0"));
	        		
	        	/*	System.out.println("Trying to Mine block 2... ");
	        		addBlock(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
	        		
	        		System.out.println("Trying to Mine block 3... ");
	        		addBlock(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));	
	        		*/
//	        		System.out.println("\nBlockchain is Valid: " + isChainValid());
	        		
	        		String blockchainJson = StringUtil.getJson(blockchain);
//	        		System.out.println("\nThe block chain: ");
//	        		System.out.println(blockchainJson);
	                
	                   
	                
	                String decryptedText = AES.decrypt(encryptedText);

//	                System.out.println("Plain Text : " + plainText);
//	                System.out.println("Encrypted Text : " + encryptedText);
//	                System.out.println("Decrypted Text : " + decryptedText);
	        }
	    	public static Boolean isChainValid() {
	    		Block currentBlock; 
	    		Block previousBlock;
	    		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
	    		
	    		//loop through blockchain to check hashes:
	    		for(int i=1; i < blockchain.size(); i++) {
	    			currentBlock = blockchain.get(i);
	    			previousBlock = blockchain.get(i-1);
	    			//compare registered hash and calculated hash:
	    			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
	    				System.out.println("Current Hashes not equal");			
	    				return false;
	    			}
	    			//compare previous hash and registered previous hash
	    			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
	    				System.out.println("Previous Hashes not equal");
	    				return false;
	    			}
	    			//check if hash is solved
	    			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
	    				System.out.println("This block hasn't been mined");
	    				return false;
	    			}
	    			
	    		}
	    		return true;
	    	}
	    	
	    	public static void addBlock(Block newBlock) {
	    		newBlock.mineBlock(difficulty);
	    		blockchain.add(newBlock);
	    	}
}
