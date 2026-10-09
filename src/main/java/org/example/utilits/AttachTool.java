package org.example.utilits;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;

public class AttachTool {
    public static void attach(String pid) throws Exception {

        String agentPath =
                "D:\\Education\\java\\Agent\\target\\Agent-1.0-SNAPSHOT.jar";
        System.out.println("Agent path = " + agentPath);
        File agentFile = new File(agentPath);
        System.out.println("Exists = " + agentFile.exists());
        System.out.println("Is file = " + agentFile.isFile());
        System.out.println("Absolute path = " + agentFile.getAbsolutePath());
        System.out.println("Attaching to JVM with PID: " + pid);

        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent(agentPath);
        vm.detach();
    }
}
