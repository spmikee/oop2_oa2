package guilib;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.EventMouseButton;
import io.github.humbleui.skija.Canvas;

import java.awt.*;

public abstract class Node {
    public boolean isDirty;
    public abstract void paint(Canvas canvas);

    public abstract void handleEvent(Event event);

    protected void setDirty(){
        this.isDirty = true;
    }

    protected boolean clearDirty(){
        if (this.isDirty = true){ //application muss window.requestFrame() machen. //
            this.isDirty = false;
            return true;

        }


        this.isDirty = false;
        return false;
    }

    public boolean checkDirty(){
        return this.isDirty;
    }



   /* setDirty()

    Wird von allen Controls verwendet, um das «dirty»-Flag (ein boolean-Attribut) zu setzen, sobald eine Setter-Methode eine (sichtbare) Eigenschaft des Controls ändert.

    boolean clearDirty()

    Wird von Application verwendet, um am Ende der Event-Handling-Phase zu prüfen, ob ein Control (bzw. die Group) «dirty» geworden ist. Gibt true zurück, falls das Control «dirty» ist, und setzt gleichzeitig das «dirty»-Flag zurück. Falls nötig, fordert die Application mittels window.requestFrame() ein Neuzeichnen des Fensters an.




    Beachten Sie, dass die Group-Klasse eine spezielle Implementation von clearDirty() braucht. Eine Gruppe von Controls gilt als «dirty», wenn mindestens eines der enthaltenen Controls «dirty» ist.
*/







}
