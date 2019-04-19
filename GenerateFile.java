import java.io.File;
import java.io.FileWriter;

public class GenerateFile {
    public static void main(String[] args) throws Exception{
        File f = new File("testWordCountFile.txt");
        FileWriter fw = new FileWriter(f);
        int i = 0;
        while(i<Math.pow(10,5))
        {
            fw.write("hello ");
            fw.write("how ");
            fw.write("are ");
            fw.write("you ");
            fw.write("\n");
            i++;
            if(i%100000==0)
                System.out.println(i);
        }
        fw.close();
    }
}
