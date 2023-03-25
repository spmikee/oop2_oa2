package guilib;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.skija.Canvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Group extends Node {
private ArrayList<Node> controls = new ArrayList<>();

public Group(Node... children){
    for (Node i:children){
        controls.add(i);
    }
}
// TODOO: clear dirty override
//    @Override
//    protected boolean clearDirty() {
//
//        for (Node i:controls) {
//            if (checkDirty()) { //application muss window.requestFrame() machen. //
//                this.isDirty = false;
//                //window.requestFrame();
//                return true;
//
//            }
//        }
//        return false;
//    }

    @Override
    protected boolean clearDirty() {
        boolean isGroupDirty = false;
        for (Node node : controls) {
            if (node.clearDirty()) {
                isGroupDirty = true;
            }
        }
        return isGroupDirty;
    }

    public Group() {

    }

    // when it's time to draw the GUI, call the paint() method on the Group object
    public void paint(Canvas canvas) {
        for (Node i:controls) {
            i.paint(canvas);
        }
    }
//
    // when an event occurs, call the handleEvent() method on the Group object
    public void handleEvent(io.github.humbleui.jwm.Event b) {
        for (Node i:controls) {
            i.handleEvent(b);
        }

    }



}
