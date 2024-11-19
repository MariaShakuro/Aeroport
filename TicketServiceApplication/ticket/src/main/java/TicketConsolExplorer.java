import com.aviation.core.service.TicketSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@Component
public class TicketConsolExplorer implements CommandLineRunner {
    @Autowired
    private TicketSevice ticketSevice;
    @Override
    public void run(String[] args)throws IOException {
        Scanner in=new Scanner(System.in);
        PrintWriter out =new PrintWriter(System.out);
        out.println("Enter format:json,xml,yaml,txt:");
        String format=in.nextLine();
        out.println("Enter filename:");
        String filename=in.nextLine();
        ticketSevice.exportTicketsToFile(format,filename);
        out.println("Tickets are written successfully in"+filename);
    }
}
