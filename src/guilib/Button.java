package guilib;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.EventMouseButton;
import io.github.humbleui.skija.*;
import io.github.humbleui.types.Point;
import io.github.humbleui.types.RRect;
import io.github.humbleui.types.Rect;



public class Button extends Labeled {

    private static final Typeface DEFAULT_TYPEFACE = Typeface.makeDefault();
    private static final int DEFAULT_FOUNT_SIZE = 20;

//    private float x;
//    private float y;
//    private String text;
    private float fontSize = DEFAULT_FOUNT_SIZE;
    private Runnable onAction;

    public Button(float x, float y, String text) {
        super((int) x, (int) y, 20 , text); // 20 muss berechnet werden. (Breite)
        setWidth((int)getWidth());
    }

    public Button (Point point, int width, String text){
        super((int) point.getX(), (int) point.getY(), width, text);
    }

    public Button (Point point, float width, String text){
        super((int) point.getX(), (int) point.getY(), (int) width, text);
    }

    public Button(Point point, String text) {
        this(point.getX(), point.getY(), text);
    }



    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }



    public float getWidth() {
        return font().measureTextWidth(super.getText());
    } // Heraufschieben oder super.text und oben ein gettext

    public float getHeight() {
        return font().getMetrics().getHeight();
    }


    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public void setOnAction(Runnable onAction) {
        this.onAction = onAction;
    }

    public void handleEvent(Event e) {
        if (onAction != null
                && e instanceof EventMouseButton mb
                && !mb.isPressed() // released
                && isInside(mb.getX(), mb.getY())) {
            onAction.run();
        }
    }

    private boolean isInside(int x, int y) {
        return x >= this.x && x <= this.x + getWidth()
                && y >= this.y && y <= this.y + getHeight();
    }

    public void paint(Canvas canvas) {


        Rect rect = new Rect(x, y, x + getWidth(), y + getHeight());
        Paint rectPaint = new Paint();
        Color4f color4f = new Color4f(255, 0, 0, 255);
        rectPaint.setColor4f(color4f);
        canvas.drawRect(rect, rectPaint);

        var baseline = y - font().getMetrics().getAscent();
        canvas.drawString(super.getText(), x, baseline, font(), new Paint());


    }

    private Font font() {
        return new Font(DEFAULT_TYPEFACE, fontSize);
    }


}
