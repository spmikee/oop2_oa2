package guilib;

import io.github.humbleui.types.Point;

public final class Position {

    private Position() {} // no need to instantiate

    public static Point at(Button button) {
        return new Point(button.getX(), button.getY());
    }

    public static Point below(Button button) {
        return at(button).offset(0, button.getHeight());
    }

    public static Point rightOf(Button button) {
        return at(button).offset(button.getWidth(), 0);
    }

    public static Point at(Label label) {
        return new Point(label.getX(), label.getY());
    }

    public static Point below(Label label) {
        return at(label).offset(0, label.getHeight());
    }

    public static Point rightOf(Label label) {
        return at(label).offset(label.getWidth(), 0);
    }
}
