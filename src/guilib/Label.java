package guilib;

import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.EventMouseButton;
import io.github.humbleui.skija.Canvas;
import io.github.humbleui.skija.Font;
import io.github.humbleui.skija.Paint;

public class Label extends Labeled{

    private static final int DEFAULT_FOUNT_SIZE = 20;

    private float fontSize = DEFAULT_FOUNT_SIZE;

    private TextAlignment alignment;

    private String text;

    private Runnable onAction;


    public Label(int spacing, int spacing1, int i, String display) { // i = breite
        super(spacing,spacing1,i,display);
    }

    @Override
    public void setTextAlignment(TextAlignment alignment) {
        this.alignment = alignment;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public int getX(){
        return super.x;
    }

    public int getY(){
        return super.y;
    }


    public int getHeight(){
        return 10;
    }

    //    public void setTextAlignment (TextAlignment alignment){
//
//        if (alignment.equals(TextAlignment.RIGHT)){
//
//        }
//    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }



    public float getWidth() {
        return 0;
    }


    @Override
    public void paint(Canvas canvas) {
        var baseline = y - font().getMetrics().getAscent();
        canvas.drawString(super.getText(), x, baseline, font(), new Paint());
    }
    private Font font() {
        return new Font(DEFAULT_TYPEFACE, fontSize);
    }

    public void setOnAction(Runnable onAction) {
        this.onAction = onAction;
    }
    private boolean isInside(int x, int y) {
        return x >= this.x && x <= this.x + getWidth()
                && y >= this.y && y <= this.y + getHeight();
    }
    @Override
    public void handleEvent(Event e) {
        if (onAction != null
                && e instanceof EventMouseButton mb
                && !mb.isPressed() // released
                && isInside(mb.getX(), mb.getY())) {
            onAction.run();
        }
    }
}
