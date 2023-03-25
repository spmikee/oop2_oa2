package guilib;

import io.github.humbleui.skija.Color4f;

public abstract class Labeled extends Control {

    public Labeled(int spacing, int spacing1, int i, String display) { // i = breite
        super(spacing,spacing1,i,display);
    }


    public void setTextAlignment(TextAlignment alignment) {
        super.setTextAlignment();
    }

    public void setText(String text) {
        super.setText(text);
    }


}
