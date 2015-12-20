package terminalCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author uddhav
 */
class threadObject extends Thread{
    private String readline;
    private final JTextArea jtextArea1;
    private final BufferedReader br;
    private final Process process;
  

    threadObject(Process p, JTextArea jtextArea1) throws IOException {
        this.process = p;
        br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        this.jtextArea1 = jtextArea1;
    }
    
       
    @Override
    public void run() {
        try {
            readline = br.readLine();
            do {
                jtextArea1.append(readline + "\n"); 
            } while((readline = br.readLine()) != null);
        } catch (IOException ex) {
            Logger.getLogger(threadObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(threadObject.class.getName()).log(Level.SEVERE, null, ex);
        }
            } 
    
        }
    
    
