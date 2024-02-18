package fileexplorer;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileExplorer {
    
    public static boolean OpenFileViaExplorer(){
        
        try{
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter fliter = new FileNameExtensionFilter("Image files", "png","jpg");
            fileChooser.setFileFilter(fliter);
            
            fileChooser.setCurrentDirectory(new File("."));
            int result = fileChooser.showOpenDialog(null);
            System.out.println("Result"+result);
            
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println("File Path"+selectedFile);
                
                if(!Desktop.isDesktopSupported()){
                    System.out.println("Not Supported");
                    return false;
                }
                else{
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(selectedFile);
                    return true;
                }
            }
            else if(result == JFileChooser.CANCEL_OPTION){
                System.out.println("Cancelled");
                return false;
            }
            
        }
        catch(HeadlessException | IOException e){
            System.out.println(e);
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(OpenFileViaExplorer());
    }   
}
