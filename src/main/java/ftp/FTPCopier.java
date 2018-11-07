package ftp;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FTPCopier
{
    public String getFtpPath(String type, String url,String remotePath,String username,String password)
    {
        StringBuilder ftpBuilder = new StringBuilder(type);
        ftpBuilder.append("://")
                  .append(url)
                  .append("/")
                  .append(remotePath)
                  .append("?username=")
                  .append(username)
                  .append("&password=")
                  .append(password);
 
        return ftpBuilder.toString();
    }
 
    public void ftpDownload(String url,String remotePath,final String localPath,String username,String password) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
 
        final String ftpPath = this.getFtpPath("ftp",url, remotePath, username, password);
 
        context.addRoutes(new RouteBuilder()
        {
            public void configure()
            {
                from(ftpPath).to("file:"+localPath);
            }
        });
 
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
 
    public void sftpDownload(String url,String remotePath,final String localPath,String username,String password) throws Exception
    {
        CamelContext context = new DefaultCamelContext();
 
        final String ftpPath = this.getFtpPath("sftp",url, remotePath, username, password);
 
        context.addRoutes(new RouteBuilder()
        {
            public void configure()
            {
                from(ftpPath).to("file:"+localPath);
            }
        });
 
        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
