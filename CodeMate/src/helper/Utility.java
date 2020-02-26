package helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Utility contains static functions to help process and handle files.
 * @author Angus Walsh
 *
 */
public class Utility {	
	
	/**
	 * Default constructor
	 */
	private Utility() {};
	
	/**
	 * fileToString reads a file and attempts to convert it to a string.
	 * @param file
	 * @return
	 */
	public static String fileToString(File file) {		
		String fileData = "";
		String line;
		
		try	{
			// Create the file reading utilities
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);            

            // Read each line of the file 
            while((line = bufferedReader.readLine()) != null) {	        
            	fileData += line + "\n";   		            	
            }
            
            bufferedReader.close();
		} catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file.getName() + "'");                
        } catch(IOException ex) {
            System.out.println("Error reading file '" + file.getName() + "'"); 
        }
				
		return fileData.toString();
	}	
	
	/**
	 * populateFileList populates a given list of Files by recursively checking every
	 * directory it comes across. 
	 * @param directory
	 * @param files
	 */
	public static void populateFileList(String directory, List<File> files)
	{				
		File dir = new File(directory);
		
		// If the directory given is not a directory and just a java file, add the file
		// to the list and return
		if(getFileExtention(dir) != null && getFileExtention(dir).equals("java")) {
			files.add(dir);
			return;
		}
		
		// get all the files in a directory
		File[] fileArray = dir.listFiles();

		if(fileArray != null) {			
			for(File f : fileArray) {
				if(f.isFile()) {
					// If the current file is a java file, add it to the list.
					if(getFileExtention(f).equals("java")) {
						files.add(f);
					}				
				} else if(f.isDirectory()) {
					// if it's a directory run this method on it.
					populateFileList(f.getAbsolutePath(), files);
				}
			}
		}		
	}
	
	/**
	 * getFileExtention splits a files name by the delimeter '.' and returns the last
	 * element found in the resulting String array.
	 * @param file
	 * @return String
	 */
	public static String getFileExtention(File file) {
		
		if(file.isDirectory()) {
			return null;
		}
		
		String[] fileNameParts = file.getName().split("\\.");
			
		if(fileNameParts.length > 0) {
			return fileNameParts[fileNameParts.length - 1];
		} else {
			return null;	
		}		
	}
}
