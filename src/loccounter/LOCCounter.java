package loccounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sirlopu
 */
public class LOCCounter {

    private String block_comment_begin = "/*";
    private String block_comment_end = "*/";
    private String block_comment_body = "*";
    private String comment = "//";
    private String block_end = "}";
    private String package_declaration = "package";
    private String library_declaration = "import";
    private String countNumber;
    
    public String counter (File sourceFile){
        
        try{
            //buffer stream for selected file
            FileReader reader = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(reader);
            
            //create linkedlist to hold # of lines
            List<String> textData = new LinkedList<String>();
            
            //create string variable for lines to be read
            String line;
            
            //prase through the file
            while ((line = br.readLine()) != null){
                //if-else statement to only count logical lines 
                if(line.trim().startsWith(comment) || line.trim().startsWith(block_end)
                        || line.trim().startsWith(block_comment_begin) || line.trim().startsWith(block_comment_end)
                        || line.trim().startsWith(package_declaration) || line.trim().startsWith(library_declaration)
                        || line.trim().startsWith(block_comment_body) || line.trim().length() == 0){
                    //do nothing
                }
                else{
                    //add logical lines to linked list
                    textData.add(line);
                }
            }
            
            //get total # of elements from linkedlist and assign it to counter
            countNumber = String.valueOf(textData.size());
            
            //close input stream
            br.close();
            
            
        }catch (Exception ex){
            System.err.println("Error: " + ex.getMessage());
        }
        
        return countNumber;
        
    }

    
}
