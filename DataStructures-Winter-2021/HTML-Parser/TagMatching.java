import java.io.*;


public class TagMatching {
    public static void main(String[] args)
    {
        StringStackImpl<String> tags = new StringStackImpl<>();//create an empty Stack of Strings
        /*Open the file and start reading line by line until the end of the file.
        For every line, split into words with split(). If a word starts with < then its an HTML Tag
        so put it in the stack. When a tag starts with </ its a closing Tag so push the last Item.
        At the end of the file, check if the stack is empty. If it's not then the tags weren't properly closed.
        */
        try {
             File htmlfile = new File(args[0]);
             FileReader fileReader = new FileReader(htmlfile);
             BufferedReader buffer = new BufferedReader(fileReader);
             String currentLine;
             while ((currentLine = buffer.readLine()) != null) {
                 //System.out.println(currentLine);
                 String[] splitted = currentLine.split("\s\\>");
                 for (String string : splitted) {
                     if (string.startsWith("</")) {
                        tags.pop();
                     }else if (string.startsWith("<")) {
                         tags.push(string);
                     }
                 }
             }
             if(tags.isEmpty()) {
                 System.out.println("Tags were matching!");
             }else {
                 System.out.println("Tags were not matching!");
             }

         }catch (FileNotFoundException e) {
             System.out.println("File not Found!");
         }catch (IOException e) {
             System.out.println("Error.");
             e.printStackTrace();
         }catch (IndexOutOfBoundsException e) {
            System.out.println("No argument given.");
            e.printStackTrace();
        }



    }
}
