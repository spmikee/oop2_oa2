package guilib;

import io.github.humbleui.skija.Color4f;
import io.github.humbleui.skija.Typeface;


public abstract class Control extends Node{

    int x;
    int y;
    int width;
    String display; //Why geht das nicht????
    private Color4f backgroundColor;
    private Color4f pressedBackgroundColor;
    private Color4f hoverBackgroundColor;


    public Control(int spacing, int spacing1, int i, String display) { // i = breite
        x = spacing;
        y = spacing1;
        width = i;
        this.display = display;


    }


    public void setWidth(int width) {
        this.width = width;
    }

    public static final Typeface DEFAULT_TYPEFACE = Typeface.makeDefault();


    public void setFontSize(int maxDisplayFontSize) {

    }

    public String getText() {
        return display;
    }


    public void setText(String display) {
        this.display = display;
    }

    public void setTextAlignment() {

    }

//    public abstract void setText();


    public float getWidth(){
        return width;
    }

    public void setBackgroundColor(Color4f lighter) {
        this.backgroundColor = lighter;
    }

    public Color4f getBackgroundColor() {
        if (backgroundColor == null){
            setBackgroundColor(new Color4f(
                    1, 1, 1));
        }

        return backgroundColor;
    }

    public void setPressedBackgroundColor(Color4f lighter) {
        this.pressedBackgroundColor = lighter;
    }

    public Color4f getPressedBackgroundColor() {

        if (pressedBackgroundColor == null){
            setPressedBackgroundColor(new Color4f(
                    1, 1, 1));
        }
        return pressedBackgroundColor;
    }
    public void setHoverBackgroundColor(Color4f lighter) {
        this.hoverBackgroundColor = lighter;
    }

    public Color4f getHoverBackgroundColor() {
        if (hoverBackgroundColor == null){
            setHoverBackgroundColor(new Color4f(
                    1, 1, 1));
        }
        return hoverBackgroundColor;
    }

}
