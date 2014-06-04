package com.gridpoint.energy.util.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostUtil {

    /**
     * Returns the localhost's ip address as a String
     * 
     * @exception IllegalStateException
     *                if ip address is unavailable or is a loopback address
     */
    public static String getHostname() {
        InetAddress localhost;
        try {
            localhost = InetAddress.getLocalHost();

        } catch (UnknownHostException ex) {
            throw new IllegalStateException("no ip address for localhost could be found", ex);
        }
        String hostname = localhost.getHostName();
        if (hostname.equals("localhost")) {
            throw new IllegalStateException("localhost Address is loopback. " + hostname + " " + localhost.getHostAddress());
        }
        return hostname;
    }

}
