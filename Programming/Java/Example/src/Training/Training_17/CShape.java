package Training.Training_17;

/**
 * 도형
 */
public class CShape {
    private int m_nColor = 0;

    /** 생성자 */
    public CShape(int a_nColor) {
        this.m_nColor = a_nColor;
    }

    /** 색상을 반환한다 */
    public String getColor() {
        String[] oStrings = {
                "", "빨간색", "녹색", "파란색"
        };

        return oStrings[m_nColor];
    }

    /** 형태를 반환한다 */
    public String getShape() {
        return "";
    }

    /** 도형을 그린다 */
    public void draw() {
        String oColor = this.getColor();
        String oShape = this.getShape();

        System.out.printf("%s %s 를 그렸습니다.\n", oColor, oShape);
    }

    /**
     * 색상
     */
    public static final int COLOR_RED = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_BLUE = 3;
}

/**
 * 선
 */
class CLine extends CShape {
    /** 생성자 */
    public CLine(int a_nColor) {
        super(a_nColor);
    }

    /** 형태를 반환한다 */
    @Override
    public String getShape() {
        return "선";
    }
}

/**
 * 삼각형
 */
class CTriangle extends CShape {
    /** 생성자 */
    public CTriangle(int a_nColor) {
        super(a_nColor);
    }

    /** 형태를 반환한다 */
    @Override
    public String getShape() {
        return "삼각형";
    }
}

/**
 * 사각형
 */
class CRectangle extends CShape {
    /** 생성자 */
    public CRectangle(int a_nColor) {
        super(a_nColor);
    }

    /** 형태를 반환한다 */
    @Override
    public String getShape() {
        return "사각형";
    }
}
