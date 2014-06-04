package com.gridpoint.energy.util.ftp;

import java.io.InputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import org.apache.log4j.Logger;

import com.gridpoint.energy.util.io.IOUtil;
import com.gridpoint.energy.util.xml.JaxbUtil;

public class FtpUtil {

    private static final Logger log = Logger.getLogger(FtpUtil.class);

    /** The port on the remote host to connect to.  Defaults to 21. */
    private int port = 21;

    /** The host to connect to. */
    private String host;

    /** The username to connect as. */
    private String username;

    /** The password to authenticate with. */
    private String password;

    public int getPort()
    {
	return port;
    }

    public void setPort(int port)
    {
	this.port = port;
    }

    public String getHost()
    {
	return host;
    }

    public void setHost(String host)
    {
	this.host = host;
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    /**
     * Renames the given source file to the given destination.
     *
     * @param src the file to rename.
     * @param dst the location to rename the file to.
     *
     * @exception IOException thrown if the file cannot be renamed.  This
     * may occur if the src file does not exist, the destination is not
     * writable, or a networking error is encountered.
     */
    public void rename(String src, String dst) 
	throws IOException {

	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    if (!ftp.rename(src, dst)) {
		throw new IOException("could not rename: " + src + ", " + dst);
	    }
	} finally {
	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    public long timestamp(String file) throws IOException {
	if (log.isDebugEnabled()) {
	    log.debug("timestamp(" + file + ")");
	}

	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    FTPFile[] files = ftp.listFiles(file);

	    if (files == null || files.length != 1) {
		throw new IllegalStateException("invalid file list");
	    }

	    return files[0].getTimestamp().getTimeInMillis();
	} finally {
	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    public void delete(String file) throws IOException {
	if (log.isDebugEnabled()) {
	    log.debug("delete(" + file + ")");
	}

	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    if (!ftp.deleteFile(file)) {
		throw new IOException("could not delete file: " + file);
	    }
	} finally {
	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    public String[] list(String path) throws IOException {
	if (log.isDebugEnabled()) {
	    log.debug("list(" + path + ")");
	}

	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    return ftp.listNames(path);
	} finally {
	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    public <T> T getContent(Class<T> clazz, String file) 
	throws IOException, JAXBException {

	if (log.isDebugEnabled()) {
	    log.debug("getContent(" + clazz + ", " + file + ")");
	}

	InputStream in = null;
	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    in = ftp.retrieveFileStream(file);

	    return JaxbUtil.getObject(clazz, in);
	} finally {
	    if (in != null) {
		try {
		    in.close();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    in = null;
		}
	    }

	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    public String getContent(String file) throws IOException {
	if (log.isDebugEnabled()) {
	    log.debug("getContent(" + file + ")");
	}

	InputStream in = null;
	FTPClient ftp = null;

	try {
	    ftp = connect(host, port, username, password);

	    in = ftp.retrieveFileStream(file);

	    return IOUtil.getContentAsString(in);
	} finally {
	    if (in != null) {
		try {
		    in.close();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    in = null;
		}
	    }

	    if (ftp != null) {
		try {
		    ftp.disconnect();
		} catch (IOException ex) {
		    log.warn(ex);
		} finally {
		    ftp = null;
		}
	    }
	}
    }

    /**
     * Connects to the remote host as the given user, with the given
     * password.
     *
     * @param host the host to connect to.
     * @param port the port to connect on.
     * @param username the user to connect as.
     * @param password the password to authenticate with.
     *
     * @exception IOException thrown if the connection cannot be established
     */
    private static FTPClient connect(String host, 
				     int port,
				     String username, 
				     String password) throws IOException {
	FTPClient client = new FTPClient();
	client.connect(host, port);
	client.login(username, password);

	if(!FTPReply.isPositiveCompletion(client.getReplyCode())) {
	    client.disconnect();
	    throw new IOException("Connection Refused");
	}

	return client;
    }
}