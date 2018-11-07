package camelHelloWorldExample;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

import ftp.FTPCopier;
 
public class FTPCopierTest
{
 
    @Test
    @Ignore
    public void downloadFTPDir()
    {
        FTPCopier copier = new FTPCopier();
 
        String url = "ftpperso.free.fr";
        String remotePath = "test";
        String localPath = "//home/artaud/Musique/test";
        String username = "myartaud";
        String password = "voopheit";
 
        try
        {
            copier.ftpDownload(url, remotePath, localPath, username, password);
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }
 
    @Test
    public void downloadSFTPDir()
    {
        FTPCopier copier = new FTPCopier();
 
        String url = "test.rebex.net";
        String remotePath = "";
        String localPath = "/home/artaud/Musique/test";
        String username = "demo";
        String password = "password";
 
        try
        {
            copier.sftpDownload(url, remotePath, localPath, username, password);
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }
 
}
