package com.hack.a.drone;

import com.hack.a.drone.ui.MainWindow;
import com.ivan.xinput.exceptions.XInputNotLoadedException;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException, XInputNotLoadedException {
        new MainWindow();
    }
}
