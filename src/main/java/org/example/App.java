package org.example;
import org.example.utilits.AttachTool;


public class App {
    public static void main(String[] args) throws Exception {
        String pid = args[0];
        AttachTool.attach(pid);
    }
}
