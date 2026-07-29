package g5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.j;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.t;
import com.blankj.utilcode.util.x0;
import com.flydigi.account.R;
import g.n;
import g5.a;
import h0.d;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class b extends j implements g5.a, TextWatcher {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f29036z = 400;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f29038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f29040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f29041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f29042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f29043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f29044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f29045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a.InterfaceC0346a f29046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f29047p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f29048q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Paint f29049r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Paint f29050s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Paint f29051t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Paint f29052u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint f29053v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f29054w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TimerTask f29055x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Timer f29056y;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b.this.f29054w = !r0.f29054w;
            b.this.postInvalidate();
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f29047p = getText().length();
        postInvalidate();
        if (getText().length() != this.f29037f) {
            if (getText().length() > this.f29037f) {
                getText().delete(this.f29037f, getText().length());
            }
        } else {
            a.InterfaceC0346a interfaceC0346a = this.f29046o;
            if (interfaceC0346a != null) {
                interfaceC0346a.a(getText());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f29047p = getText().length();
        postInvalidate();
    }

    public final void f(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerCodeEditText);
        this.f29037f = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerCodeEditText_figures, 4);
        this.f29038g = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.VerCodeEditText_verCodeMargin, 0.0f);
        this.f29039h = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_bottomLineSelectedColor, getCurrentTextColor());
        int i10 = R.styleable.VerCodeEditText_bottomLineNormalColor;
        int i11 = R.color.color_000000_a40;
        this.f29040i = typedArrayObtainStyledAttributes.getColor(i10, t.a(i11));
        this.f29041j = typedArrayObtainStyledAttributes.getDimension(R.styleable.VerCodeEditText_bottomLineHeight, b1.b(4.0f));
        this.f29042k = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_selectedBackgroundColor, t.a(i11));
        this.f29043l = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.VerCodeEditText_cursorWidth, b1.b(1.0f));
        this.f29044m = typedArrayObtainStyledAttributes.getColor(R.styleable.VerCodeEditText_cursorColor, t.a(i11));
        this.f29045n = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerCodeEditText_cursorDuration, 400);
        typedArrayObtainStyledAttributes.recycle();
        setLayoutDirection(0);
    }

    public final void g() {
        this.f29055x = new a();
        this.f29056y = new Timer();
    }

    public final void h() {
        Paint paint = new Paint();
        this.f29049r = paint;
        paint.setColor(this.f29042k);
        Paint paint2 = new Paint();
        this.f29050s = paint2;
        paint2.setColor(t.a(android.R.color.transparent));
        this.f29051t = new Paint();
        this.f29052u = new Paint();
        this.f29051t.setColor(this.f29039h);
        this.f29052u.setColor(this.f29040i);
        this.f29051t.setStrokeWidth(this.f29041j);
        this.f29052u.setStrokeWidth(this.f29041j);
        Paint paint3 = new Paint();
        this.f29053v = paint3;
        paint3.setAntiAlias(true);
        this.f29053v.setColor(this.f29044m);
        this.f29053v.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f29053v.setStrokeWidth(this.f29043l);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f29056y.scheduleAtFixedRate(this.f29055x, 0L, this.f29045n);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29056y.cancel();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f29047p = getText().length();
        int paddingLeft = (this.f29048q - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        String string = getText().toString();
        for (int i10 = 0; i10 < string.length(); i10++) {
            canvas.save();
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f10 = measuredHeight - fontMetrics.bottom;
            float f11 = fontMetrics.top;
            canvas.drawText(String.valueOf(string.charAt(i10)), (paddingLeft * i10) + (this.f29038g * i10) + (paddingLeft / 2.0f), ((f10 + f11) / 2.0f) - f11, paint);
            canvas.restore();
        }
        for (int i11 = 0; i11 < this.f29037f; i11++) {
            canvas.save();
            float f12 = measuredHeight - (this.f29041j / 2.0f);
            int i12 = (paddingLeft * i11) + (this.f29038g * i11);
            int i13 = paddingLeft + i12;
            if (i11 < this.f29047p) {
                canvas.drawLine(i12, f12, i13, f12, this.f29051t);
            } else {
                canvas.drawLine(i12, f12, i13, f12, this.f29052u);
            }
            canvas.restore();
        }
        if (this.f29054w || !isCursorVisible() || this.f29047p >= this.f29037f || !hasFocus()) {
            return;
        }
        canvas.save();
        int i14 = (this.f29047p * (this.f29038g + paddingLeft)) + (paddingLeft / 2);
        float f13 = i14;
        canvas.drawLine(f13, measuredHeight / 4, f13, measuredHeight - r0, this.f29053v);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode != 1073741824) {
            size = x0.g();
        }
        int i12 = this.f29038g;
        int i13 = this.f29037f;
        this.f29048q = (size - (i12 * (i13 - 1))) / i13;
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 != 1073741824) {
            size2 = this.f29048q;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f29047p = getText().length();
        postInvalidate();
        a.InterfaceC0346a interfaceC0346a = this.f29046o;
        if (interfaceC0346a != null) {
            interfaceC0346a.b(getText(), i10, i11, i12);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        requestFocus();
        setSelection(getText().length());
        KeyboardUtils.q();
        return false;
    }

    @Override // g5.a
    public void setBottomLineHeight(int i10) {
        this.f29041j = i10;
        postInvalidate();
    }

    @Override // g5.a
    public void setBottomNormalColor(@n int i10) {
        this.f29039h = t.a(i10);
        postInvalidate();
    }

    @Override // g5.a
    public void setBottomSelectedColor(@n int i10) {
        this.f29039h = t.a(i10);
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void setCursorVisible(boolean z10) {
        super.setCursorVisible(z10);
    }

    @Override // g5.a
    public void setFigures(int i10) {
        this.f29037f = i10;
        postInvalidate();
    }

    @Override // g5.a
    public void setOnVerificationCodeChangedListener(a.InterfaceC0346a interfaceC0346a) {
        this.f29046o = interfaceC0346a;
    }

    @Override // g5.a
    public void setSelectedBackgroundColor(@n int i10) {
        this.f29042k = t.a(i10);
        postInvalidate();
    }

    @Override // g5.a
    public void setVerCodeMargin(int i10) {
        this.f29038g = i10;
        postInvalidate();
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f29047p = 0;
        this.f29048q = 0;
        f(attributeSet);
        setBackgroundColor(d.f(context, android.R.color.transparent));
        h();
        g();
        setFocusableInTouchMode(true);
        super.addTextChangedListener(this);
    }
}
