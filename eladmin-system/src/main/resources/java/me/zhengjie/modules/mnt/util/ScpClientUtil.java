
package me.zhengjie.modules.mnt.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ScpClientUtil {

	static private Map<String,ScpClientUtil> instance = Maps.newHashMap();

	static synchronized public ScpClientUtil getInstance(String ip, int port, String username, String password) {
		if (instance.get(ip) == null) {
			instance.put(ip, new ScpClientUtil(ip, port, username, password));
		}
		return instance.get(ip);
	}

	public ScpClientUtil(String ip, int port, String username, String password) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public void getFile(String remoteFile, String localTargetDirectory) {
		Connection conn = new Connection(ip, port);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (!isAuthenticated) {
				System.err.println("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			client.get(remoteFile, localTargetDirectory);
		} catch (IOException ex) {
			Logger.getLogger(SCPClient.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			conn.close();
		}
	}

	public void putFile(String localFile, String remoteTargetDirectory) {
		putFile(localFile, null, remoteTargetDirectory);
	}

	public void putFile(String localFile, String remoteFileName, String remoteTargetDirectory) {
		putFile(localFile, remoteFileName, remoteTargetDirectory,null);
	}

	public void putFile(String localFile, String remoteFileName, String remoteTargetDirectory, String mode) {
		Connection conn = new Connection(ip, port);
		try {
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(username, password);
			if (!isAuthenticated) {
				System.err.println("authentication failed");
			}
			SCPClient client = new SCPClient(conn);
			if ((mode == null) || (mode.length() == 0)) {
				mode = "0600";
			}
			if (remoteFileName == null) {
				client.put(localFile, remoteTargetDirectory);
			} else {
				client.put(localFile, remoteFileName, remoteTargetDirectory, mode);
			}
		} catch (IOException ex) {
			Logger.getLogger(ScpClientUtil.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			conn.close();
		}
	}

	private String ip;
	private int port;
	private String username;
	private String password;


}
