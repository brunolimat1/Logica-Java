package br.com.estruturas.atividades;

import java.io.IOException;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.sshtools.j2ssh.util.Base64.InputStream;

public class Executar {

	    	 private static final String REMOTE_HOST = "127.0.0.1";
		    private static final String USERNAME = "senac";
		    private static final String PASSWORD = "senac@123";
		    private static final int REMOTE_PORT = 2222;
		    private static final int SESSION_TIMEOUT = 10000;
		    private static final int CHANNEL_TIMEOUT = 5000;

		    public static void main(String[] args) {

		        String remoteShellScript = "/home/senac/app.sh";

		        Session jschSession = null;

		        try {
		        	
		        	java.util.Properties config = new java.util.Properties(); 
		        	config.put("StrictHostKeyChecking", "no");

		            JSch jsch = new JSch();
		            jsch.setKnownHosts("/home/senac/.ssh/known_hosts");
		            
		            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);

		            // not recommend, uses jsch.setKnownHosts
		            //jschSession.setConfig("StrictHostKeyChecking", "no");

		            // authenticate using password
		            jschSession.setPassword(PASSWORD);

		            jschSession.setConfig(config);
		            // 10 seconds timeout session
		            jschSession.connect(SESSION_TIMEOUT);

		            ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");

		            // run a shell script
		            channelExec.setCommand("sh " + remoteShellScript + " senac");

		            // display errors to System.err
		            channelExec.setErrStream(System.err);

		            java.io.InputStream in = channelExec.getInputStream();

		            // 5 seconds timeout channel
		            channelExec.connect(CHANNEL_TIMEOUT);

		            // read the result from remote server
		            byte[] tmp = new byte[1024];
		            while (true) {
		                while (in.available() > 0) {
		                    int i = in.read(tmp, 0, 1024);
		                    if (i < 0) break;
		                    System.out.print(new String(tmp, 0, i));
		                }
		                if (channelExec.isClosed()) {
		                    if (in.available() > 0) continue;
		                    System.out.println("exit-status: "
		                         + channelExec.getExitStatus());
		                    break;
		                }
		                try {
		                    Thread.sleep(1000);
		                } catch (Exception ee) {
		                }
		            }

		            channelExec.disconnect();

		        } catch (JSchException | IOException e) {

		            e.printStackTrace();

		        } finally {
		            if (jschSession != null) {
		                jschSession.disconnect();
		            }
		        }

		    }
		}