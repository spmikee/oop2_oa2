//package binarycalc;
//
//import guilib.Application;
//import guilib.Button;
//import io.github.humbleui.jwm.*;
//import io.github.humbleui.jwm.skija.EventFrameSkija;
//import io.github.humbleui.jwm.skija.LayerGLSkija;
//import io.github.humbleui.skija.Canvas;
//import io.github.humbleui.skija.Font;
//import io.github.humbleui.skija.Paint;
//import io.github.humbleui.skija.Typeface;
//
//import java.awt.event.WindowFocusListener;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class BinaryCalc extends Application {
//
//    private static final int WIDTH = 800;
//    private static final int HEIGHT = 200;
//    private static final int SPACING = 40;
//
//    private static final Typeface DEFAULT_TYPEFACE = Typeface.makeDefault();
//    private static final int NUMBERS_FONT_SIZE = 80;
//    private static final int RESET_FONT_SIZE = 40;
//    private static final int BIT_WIDTH = 45;
//
//    private static final int RESET_X = 660;
//    private static final int RESET_Y = 70;
//    private Button reset;
//
//
//    public static void main(String[] args) {
//        new BinaryCalc().start("Binary Calculator", WIDTH, HEIGHT);
//    }
//
//    private final int[] bits = {0, 0, 0, 0, 0, 0, 0, 0};
//
//
//
//    @Override
//    protected ArrayList<Button> createContent() {
//        reset = new Button(RESET_X, RESET_Y, "Reset");
//        reset.setFontSize(RESET_FONT_SIZE);
//        reset.setOnAction(() -> {
//            Arrays.fill(bits, 0);
//            getWindow().requestFrame();
//        });
//
//        // andere Buttons
//
//        return new ArrayList<Button>(List.of(reset));
//    }
//
//    private void start() {
//
//    }
//
//
//
//
//    protected void paint(Canvas canvas) {
//        super.paint(canvas);
//        var numberFont = new Font(DEFAULT_TYPEFACE, NUMBERS_FONT_SIZE);
//        var numberBaseline = SPACING - numberFont.getMetrics().getAscent();
//        for (int i = 0; i < bits.length; i++) {
//            canvas.drawString(bits[i] + "", bitX(i), numberBaseline, numberFont, new Paint());
//        }
//
//        canvas.drawString(decimal() + "", bitX(8) + SPACING, numberBaseline, numberFont, new Paint());
//
//        var resetFont = new Font(DEFAULT_TYPEFACE, RESET_FONT_SIZE);
//        var resetBaseline = RESET_Y - resetFont.getMetrics().getAscent();
//        canvas.drawString("Reset", RESET_X, resetBaseline, resetFont, new Paint());
//    }
//
//    private int decimal() {
//        int dec = 0;
//        for (int bit : bits) {
//            dec = dec << 1 | bit;
//        }
//        return dec;
//    }
//
//
////    private void handleEvent(Event e) {
////        if (e instanceof EventMouseButton mb && !mb.isPressed()){
////            var numberFont = new Font(DEFAULT_TYPEFACE, NUMBERS_FONT_SIZE);
////        if (mb.getY() >= SPACING && mb.getY() <= SPACING + numberFont.getMetrics().getHeight()) {
////            for (int i = 0; i < bits.length; i++) {
////                if (mb.getX() >= bitX(i) && mb.getX() <= bitX(i) + BIT_WIDTH) {
////                    bits[i] = 1 - bits[i]; // invert bit
////                    getWindow().requestFrame();
////                    return;
////                }
////            }
////        }
////        }
////    }
//
//
//    private int bitX(int i) {
//        return SPACING + i * BIT_WIDTH;
//    }
//}