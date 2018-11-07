package ftp;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;

/**
 * Main class that can upload files to an existing FTP server.
 */
public final class MyFtpClient {

    private MyFtpClient() {
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new MyFtpClientRouteBuilder());
        main.run();
    }

}