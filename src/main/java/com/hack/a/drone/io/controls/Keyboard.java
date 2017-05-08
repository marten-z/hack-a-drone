package com.hack.a.drone.io.controls;

import com.hack.a.drone.model.Command;

import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class Keyboard implements IController, KeyEventDispatcher {
    private final KeyboardFocusManager focusManager;
    private CommandListener commandListener;
    private Command command = new Command();

    public Keyboard(KeyboardFocusManager focusManager) {
        this.focusManager = focusManager;
    }

    public void start() {
        focusManager.addKeyEventDispatcher(this);
    }

    public void stop() {
        focusManager.removeKeyEventDispatcher(this);
    }

    public boolean isAvailable() {
        return false;
    }

    public void setListener(CommandListener controlListener) {
        this.commandListener = controlListener;
    }

    private void onKeyEvent(KeyEvent e, boolean isPressed) {
        int value = isPressed ? 127 : 0;
        boolean newInput = true;
        // TODO implement
//        switch (e.getKeyCode()) {
//            case // TODO implement (UP)
//                command.setThrottle(value);
//                break;
//            case // TODO implement (DOWN)
//                command.setThrottle(-value);
//                break;
//            case // TODO implement (TURN RIGHT)
//                command.setYaw(value);
//                break;
//            case // TODO implement (TURN LEFT)
//                command.setYaw(-value);
//                break;
//            case // TODO implement (FORWARD)
//                command.setPitch(value);
//                break;
//            case // TODO implement (BACKWARD)
//                command.setPitch(-value);
//                break;
//            case // TODO implement (LEAN RIGHT)
//                command.setRoll(value);
//                break;
//            case // TODO implement (LEAN LEFT)
//                command.setRoll(-value);
//                break;
//            case // TODO implement
//                command.setTakeOff(isPressed);
//                break;
//            case // TODO implement
//                command.setLand(isPressed);
//                break;
//            default:
//                newInput = false;
//        }

        if (commandListener != null && newInput) {
            commandListener.onCommandReceived(command);
        }
        e.consume();
    }

    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KEY_PRESSED) {
            onKeyEvent(e, true);
        } else if (e.getID() == KEY_RELEASED) {
            onKeyEvent(e, false);
        }
        return false;
    }
}
