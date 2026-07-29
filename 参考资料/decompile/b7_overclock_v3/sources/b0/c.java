package b0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

/* JADX INFO: loaded from: classes2.dex */
public class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f8949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f8950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f8951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f8955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8959k;

    public c(Context context) {
        super(context);
        this.f8949a = new Paint();
        this.f8950b = new Paint();
        this.f8951c = new Paint();
        this.f8952d = true;
        this.f8953e = true;
        this.f8954f = null;
        this.f8955g = new Rect();
        this.f8956h = Color.argb(255, 0, 0, 0);
        this.f8957i = Color.argb(255, 200, 200, 200);
        this.f8958j = Color.argb(255, 50, 50, 50);
        this.f8959k = 4;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MockView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MockView_mock_label) {
                    this.f8954f = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.f8952d = typedArrayObtainStyledAttributes.getBoolean(index, this.f8952d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.f8956h = typedArrayObtainStyledAttributes.getColor(index, this.f8956h);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.f8958j = typedArrayObtainStyledAttributes.getColor(index, this.f8958j);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.f8957i = typedArrayObtainStyledAttributes.getColor(index, this.f8957i);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.f8953e = typedArrayObtainStyledAttributes.getBoolean(index, this.f8953e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f8954f == null) {
            try {
                this.f8954f = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.f8949a.setColor(this.f8956h);
        this.f8949a.setAntiAlias(true);
        this.f8950b.setColor(this.f8957i);
        this.f8950b.setAntiAlias(true);
        this.f8951c.setColor(this.f8958j);
        this.f8959k = Math.round(this.f8959k * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f8952d) {
            width--;
            height--;
            float f10 = width;
            float f11 = height;
            canvas.drawLine(0.0f, 0.0f, f10, f11, this.f8949a);
            canvas.drawLine(0.0f, f11, f10, 0.0f, this.f8949a);
            canvas.drawLine(0.0f, 0.0f, f10, 0.0f, this.f8949a);
            canvas.drawLine(f10, 0.0f, f10, f11, this.f8949a);
            canvas.drawLine(f10, f11, 0.0f, f11, this.f8949a);
            canvas.drawLine(0.0f, f11, 0.0f, 0.0f, this.f8949a);
        }
        String str = this.f8954f;
        if (str == null || !this.f8953e) {
            return;
        }
        this.f8950b.getTextBounds(str, 0, str.length(), this.f8955g);
        float fWidth = (width - this.f8955g.width()) / 2.0f;
        float fHeight = ((height - this.f8955g.height()) / 2.0f) + this.f8955g.height();
        this.f8955g.offset((int) fWidth, (int) fHeight);
        Rect rect = this.f8955g;
        int i10 = rect.left;
        int i11 = this.f8959k;
        rect.set(i10 - i11, rect.top - i11, rect.right + i11, rect.bottom + i11);
        canvas.drawRect(this.f8955g, this.f8951c);
        canvas.drawText(this.f8954f, fWidth, fHeight, this.f8950b);
    }

    public c(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f8949a = new Paint();
        this.f8950b = new Paint();
        this.f8951c = new Paint();
        this.f8952d = true;
        this.f8953e = true;
        this.f8954f = null;
        this.f8955g = new Rect();
        this.f8956h = Color.argb(255, 0, 0, 0);
        this.f8957i = Color.argb(255, 200, 200, 200);
        this.f8958j = Color.argb(255, 50, 50, 50);
        this.f8959k = 4;
        a(context, attrs);
    }

    public c(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8949a = new Paint();
        this.f8950b = new Paint();
        this.f8951c = new Paint();
        this.f8952d = true;
        this.f8953e = true;
        this.f8954f = null;
        this.f8955g = new Rect();
        this.f8956h = Color.argb(255, 0, 0, 0);
        this.f8957i = Color.argb(255, 200, 200, 200);
        this.f8958j = Color.argb(255, 50, 50, 50);
        this.f8959k = 4;
        a(context, attrs);
    }
}
