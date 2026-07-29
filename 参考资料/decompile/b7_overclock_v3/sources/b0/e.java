package b0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.widget.R;
import androidx.core.view.m;
import com.bumptech.glide.load.engine.GlideException;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends View implements androidx.constraintlayout.motion.widget.e {
    public static String N7 = "MotionLabel";
    public static final int O7 = 1;
    public static final int P7 = 2;
    public static final int Q7 = 3;
    public boolean A;
    public float B;
    public float C;
    public Matrix C1;
    public float C2;
    public float D;
    public Paint E7;
    public int F7;
    public Rect G7;
    public Paint H7;
    public float I7;
    public float J7;
    public Matrix K0;
    public float K1;
    public float K2;
    public float K7;
    public float L7;
    public float M7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextPaint f8967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f8968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f8973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewOutlineProvider f8974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f8975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f8976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8977k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Drawable f8978k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Bitmap f8979k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8980l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8981m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f8982n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f8983o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8984p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Rect f8985q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public CharSequence f8986r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f8987s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8988t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f8989u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8990v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public BitmapShader f8991v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public float f8992v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f8993w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Layout f8994x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f8995y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8996z;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, e.this.getWidth(), e.this.getHeight(), (Math.min(r3, r4) * e.this.f8972f) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, e.this.getWidth(), e.this.getHeight(), e.this.f8973g);
        }
    }

    public e(Context context) {
        super(context);
        this.f8967a = new TextPaint();
        this.f8968b = new Path();
        this.f8969c = 65535;
        this.f8970d = 65535;
        this.f8971e = false;
        this.f8972f = 0.0f;
        this.f8973g = Float.NaN;
        this.f8976j = 48.0f;
        this.f8977k = Float.NaN;
        this.f8982n = 0.0f;
        this.f8983o = "Hello World";
        this.f8984p = true;
        this.f8985q = new Rect();
        this.f8987s = 1;
        this.f8988t = 1;
        this.f8989u = 1;
        this.f8990v = 1;
        this.f8995y = 8388659;
        this.f8996z = 0;
        this.A = false;
        this.K1 = Float.NaN;
        this.f8992v2 = Float.NaN;
        this.C2 = 0.0f;
        this.K2 = 0.0f;
        this.E7 = new Paint();
        this.F7 = 0;
        this.J7 = Float.NaN;
        this.K7 = Float.NaN;
        this.L7 = Float.NaN;
        this.M7 = Float.NaN;
        g(context, null);
    }

    private float getHorizontalOffset() {
        float f10 = Float.isNaN(this.f8977k) ? 1.0f : this.f8976j / this.f8977k;
        TextPaint textPaint = this.f8967a;
        String str = this.f8983o;
        return (((((Float.isNaN(this.C) ? getMeasuredWidth() : this.C) - getPaddingLeft()) - getPaddingRight()) - (f10 * textPaint.measureText(str, 0, str.length()))) * (this.C2 + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f10 = Float.isNaN(this.f8977k) ? 1.0f : this.f8976j / this.f8977k;
        Paint.FontMetrics fontMetrics = this.f8967a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.D) ? getMeasuredHeight() : this.D) - getPaddingTop()) - getPaddingBottom();
        float f11 = fontMetrics.descent;
        float f12 = fontMetrics.ascent;
        return (((measuredHeight - ((f11 - f12) * f10)) * (1.0f - this.K2)) / 2.0f) - (f10 * f12);
    }

    @Override // androidx.constraintlayout.motion.widget.e
    public void a(float l10, float t10, float r10, float b10) {
        int i10 = (int) (l10 + 0.5f);
        this.B = l10 - i10;
        int i11 = (int) (r10 + 0.5f);
        int i12 = i11 - i10;
        int i13 = (int) (b10 + 0.5f);
        int i14 = (int) (0.5f + t10);
        int i15 = i13 - i14;
        float f10 = r10 - l10;
        this.C = f10;
        float f11 = b10 - t10;
        this.D = f11;
        d(l10, t10, r10, b10);
        if (getMeasuredHeight() == i15 && getMeasuredWidth() == i12) {
            super.layout(i10, i14, i11, i13);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i15, 1073741824));
            super.layout(i10, i14, i11, i13);
        }
        if (this.A) {
            if (this.G7 == null) {
                this.H7 = new Paint();
                this.G7 = new Rect();
                this.H7.set(this.f8967a);
                this.I7 = this.H7.getTextSize();
            }
            this.C = f10;
            this.D = f11;
            Paint paint = this.H7;
            String str = this.f8983o;
            paint.getTextBounds(str, 0, str.length(), this.G7);
            float fHeight = this.G7.height() * 1.3f;
            float f12 = (f10 - this.f8988t) - this.f8987s;
            float f13 = (f11 - this.f8990v) - this.f8989u;
            float fWidth = this.G7.width();
            if (fWidth * f13 > fHeight * f12) {
                this.f8967a.setTextSize((this.I7 * f12) / fWidth);
            } else {
                this.f8967a.setTextSize((this.I7 * f13) / fHeight);
            }
            if (this.f8971e || !Float.isNaN(this.f8977k)) {
                f(Float.isNaN(this.f8977k) ? 1.0f : this.f8976j / this.f8977k);
            }
        }
    }

    public final void d(float l10, float t10, float r10, float b10) {
        if (this.C1 == null) {
            return;
        }
        this.C = r10 - l10;
        this.D = b10 - t10;
        l();
    }

    public Bitmap e(Bitmap bitmapOriginal, int factor) {
        System.nanoTime();
        int width = bitmapOriginal.getWidth() / 2;
        int height = bitmapOriginal.getHeight() / 2;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapOriginal, width, height, true);
        for (int i10 = 0; i10 < factor && width >= 32 && height >= 32; i10++) {
            width /= 2;
            height /= 2;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, width, height, true);
        }
        return bitmapCreateScaledBitmap;
    }

    public void f(float scale) {
        if (this.f8971e || scale != 1.0f) {
            this.f8968b.reset();
            String str = this.f8983o;
            int length = str.length();
            this.f8967a.getTextBounds(str, 0, length, this.f8985q);
            this.f8967a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f8968b);
            if (scale != 1.0f) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(androidx.constraintlayout.motion.widget.c.f());
                sb2.append(" scale ");
                sb2.append(scale);
                Matrix matrix = new Matrix();
                matrix.postScale(scale, scale);
                this.f8968b.transform(matrix);
            }
            Rect rect = this.f8985q;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f8984p = false;
        }
    }

    public final void g(Context context, AttributeSet attrs) {
        i(context, attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.MotionLabel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.MotionLabel_android_text) {
                    setText(typedArrayObtainStyledAttributes.getText(index));
                } else if (index == R.styleable.MotionLabel_android_fontFamily) {
                    this.f8993w = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MotionLabel_scaleFromTextSize) {
                    this.f8977k = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f8977k);
                } else if (index == R.styleable.MotionLabel_android_textSize) {
                    this.f8976j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, (int) this.f8976j);
                } else if (index == R.styleable.MotionLabel_android_textStyle) {
                    this.f8980l = typedArrayObtainStyledAttributes.getInt(index, this.f8980l);
                } else if (index == R.styleable.MotionLabel_android_typeface) {
                    this.f8981m = typedArrayObtainStyledAttributes.getInt(index, this.f8981m);
                } else if (index == R.styleable.MotionLabel_android_textColor) {
                    this.f8969c = typedArrayObtainStyledAttributes.getColor(index, this.f8969c);
                } else if (index == R.styleable.MotionLabel_borderRound) {
                    float dimension = typedArrayObtainStyledAttributes.getDimension(index, this.f8973g);
                    this.f8973g = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.MotionLabel_borderRoundPercent) {
                    float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f8972f);
                    this.f8972f = f10;
                    setRoundPercent(f10);
                } else if (index == R.styleable.MotionLabel_android_gravity) {
                    setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.MotionLabel_android_autoSizeTextType) {
                    this.f8996z = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.MotionLabel_textOutlineColor) {
                    this.f8970d = typedArrayObtainStyledAttributes.getInt(index, this.f8970d);
                    this.f8971e = true;
                } else if (index == R.styleable.MotionLabel_textOutlineThickness) {
                    this.f8982n = typedArrayObtainStyledAttributes.getDimension(index, this.f8982n);
                    this.f8971e = true;
                } else if (index == R.styleable.MotionLabel_textBackground) {
                    this.f8978k0 = typedArrayObtainStyledAttributes.getDrawable(index);
                    this.f8971e = true;
                } else if (index == R.styleable.MotionLabel_textBackgroundPanX) {
                    this.J7 = typedArrayObtainStyledAttributes.getFloat(index, this.J7);
                } else if (index == R.styleable.MotionLabel_textBackgroundPanY) {
                    this.K7 = typedArrayObtainStyledAttributes.getFloat(index, this.K7);
                } else if (index == R.styleable.MotionLabel_textPanX) {
                    this.C2 = typedArrayObtainStyledAttributes.getFloat(index, this.C2);
                } else if (index == R.styleable.MotionLabel_textPanY) {
                    this.K2 = typedArrayObtainStyledAttributes.getFloat(index, this.K2);
                } else if (index == R.styleable.MotionLabel_textBackgroundRotate) {
                    this.M7 = typedArrayObtainStyledAttributes.getFloat(index, this.M7);
                } else if (index == R.styleable.MotionLabel_textBackgroundZoom) {
                    this.L7 = typedArrayObtainStyledAttributes.getFloat(index, this.L7);
                } else if (index == R.styleable.MotionLabel_textureHeight) {
                    this.K1 = typedArrayObtainStyledAttributes.getDimension(index, this.K1);
                } else if (index == R.styleable.MotionLabel_textureWidth) {
                    this.f8992v2 = typedArrayObtainStyledAttributes.getDimension(index, this.f8992v2);
                } else if (index == R.styleable.MotionLabel_textureEffect) {
                    this.F7 = typedArrayObtainStyledAttributes.getInt(index, this.F7);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    public float getRound() {
        return this.f8973g;
    }

    public float getRoundPercent() {
        return this.f8972f;
    }

    public float getScaleFromTextSize() {
        return this.f8977k;
    }

    public float getTextBackgroundPanX() {
        return this.J7;
    }

    public float getTextBackgroundPanY() {
        return this.K7;
    }

    public float getTextBackgroundRotate() {
        return this.M7;
    }

    public float getTextBackgroundZoom() {
        return this.L7;
    }

    public int getTextOutlineColor() {
        return this.f8970d;
    }

    public float getTextPanX() {
        return this.C2;
    }

    public float getTextPanY() {
        return this.K2;
    }

    public float getTextureHeight() {
        return this.K1;
    }

    public float getTextureWidth() {
        return this.f8992v2;
    }

    public Typeface getTypeface() {
        return this.f8967a.getTypeface();
    }

    public final void h(String familyName, int typefaceIndex, int styleIndex) {
        Typeface typefaceCreate;
        if (familyName != null) {
            typefaceCreate = Typeface.create(familyName, styleIndex);
            if (typefaceCreate != null) {
                setTypeface(typefaceCreate);
                return;
            }
        } else {
            typefaceCreate = null;
        }
        if (typefaceIndex == 1) {
            typefaceCreate = Typeface.SANS_SERIF;
        } else if (typefaceIndex == 2) {
            typefaceCreate = Typeface.SERIF;
        } else if (typefaceIndex == 3) {
            typefaceCreate = Typeface.MONOSPACE;
        }
        if (styleIndex <= 0) {
            this.f8967a.setFakeBoldText(false);
            this.f8967a.setTextSkewX(0.0f);
            setTypeface(typefaceCreate);
        } else {
            Typeface typefaceDefaultFromStyle = typefaceCreate == null ? Typeface.defaultFromStyle(styleIndex) : Typeface.create(typefaceCreate, styleIndex);
            setTypeface(typefaceDefaultFromStyle);
            int i10 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & styleIndex;
            this.f8967a.setFakeBoldText((i10 & 1) != 0);
            this.f8967a.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    public final void i(Context context, @p0 AttributeSet attrs) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        TextPaint textPaint = this.f8967a;
        int i10 = typedValue.data;
        this.f8969c = i10;
        textPaint.setColor(i10);
    }

    public void j() {
        this.f8987s = getPaddingLeft();
        this.f8988t = getPaddingRight();
        this.f8989u = getPaddingTop();
        this.f8990v = getPaddingBottom();
        h(this.f8993w, this.f8981m, this.f8980l);
        this.f8967a.setColor(this.f8969c);
        this.f8967a.setStrokeWidth(this.f8982n);
        this.f8967a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f8967a.setFlags(128);
        setTextSize(this.f8976j);
        this.f8967a.setAntiAlias(true);
    }

    public final void k() {
        if (this.f8978k0 != null) {
            this.C1 = new Matrix();
            int intrinsicWidth = this.f8978k0.getIntrinsicWidth();
            int intrinsicHeight = this.f8978k0.getIntrinsicHeight();
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.f8992v2) ? 128 : (int) this.f8992v2;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                intrinsicHeight = Float.isNaN(this.K1) ? 128 : (int) this.K1;
            }
            if (this.F7 != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.f8979k1 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f8979k1);
            this.f8978k0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.f8978k0.setFilterBitmap(true);
            this.f8978k0.draw(canvas);
            if (this.F7 != 0) {
                this.f8979k1 = e(this.f8979k1, 4);
            }
            Bitmap bitmap = this.f8979k1;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f8991v1 = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    public final void l() {
        float f10 = Float.isNaN(this.J7) ? 0.0f : this.J7;
        float f11 = Float.isNaN(this.K7) ? 0.0f : this.K7;
        float f12 = Float.isNaN(this.L7) ? 1.0f : this.L7;
        float f13 = Float.isNaN(this.M7) ? 0.0f : this.M7;
        this.C1.reset();
        float width = this.f8979k1.getWidth();
        float height = this.f8979k1.getHeight();
        float f14 = Float.isNaN(this.f8992v2) ? this.C : this.f8992v2;
        float f15 = Float.isNaN(this.K1) ? this.D : this.K1;
        float f16 = f12 * (width * f15 < height * f14 ? f14 / width : f15 / height);
        this.C1.postScale(f16, f16);
        float f17 = width * f16;
        float f18 = f14 - f17;
        float f19 = f16 * height;
        float f20 = f15 - f19;
        if (!Float.isNaN(this.K1)) {
            f20 = this.K1 / 2.0f;
        }
        if (!Float.isNaN(this.f8992v2)) {
            f18 = this.f8992v2 / 2.0f;
        }
        this.C1.postTranslate((((f10 * f18) + f14) - f17) * 0.5f, (((f11 * f20) + f15) - f19) * 0.5f);
        this.C1.postRotate(f13, f14 / 2.0f, f15 / 2.0f);
        this.f8991v1.setLocalMatrix(this.C1);
    }

    @Override // android.view.View
    public void layout(int l10, int t10, int r10, int b10) {
        super.layout(l10, t10, r10, b10);
        boolean zIsNaN = Float.isNaN(this.f8977k);
        float f10 = zIsNaN ? 1.0f : this.f8976j / this.f8977k;
        this.C = r10 - l10;
        this.D = b10 - t10;
        if (this.A) {
            if (this.G7 == null) {
                this.H7 = new Paint();
                this.G7 = new Rect();
                this.H7.set(this.f8967a);
                this.I7 = this.H7.getTextSize();
            }
            Paint paint = this.H7;
            String str = this.f8983o;
            paint.getTextBounds(str, 0, str.length(), this.G7);
            int iWidth = this.G7.width();
            int iHeight = (int) (this.G7.height() * 1.3f);
            float f11 = (this.C - this.f8988t) - this.f8987s;
            float f12 = (this.D - this.f8990v) - this.f8989u;
            if (zIsNaN) {
                float f13 = iWidth;
                float f14 = iHeight;
                if (f13 * f12 > f14 * f11) {
                    this.f8967a.setTextSize((this.I7 * f11) / f13);
                } else {
                    this.f8967a.setTextSize((this.I7 * f12) / f14);
                }
            } else {
                float f15 = iWidth;
                float f16 = iHeight;
                f10 = f15 * f12 > f16 * f11 ? f11 / f15 : f12 / f16;
            }
        }
        if (this.f8971e || !zIsNaN) {
            d(l10, t10, r10, b10);
            f(f10);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = Float.isNaN(this.f8977k) ? 1.0f : this.f8976j / this.f8977k;
        super.onDraw(canvas);
        if (!this.f8971e && f10 == 1.0f) {
            canvas.drawText(this.f8983o, this.B + this.f8987s + getHorizontalOffset(), this.f8989u + getVerticalOffset(), this.f8967a);
            return;
        }
        if (this.f8984p) {
            f(f10);
        }
        if (this.K0 == null) {
            this.K0 = new Matrix();
        }
        if (!this.f8971e) {
            float horizontalOffset = this.f8987s + getHorizontalOffset();
            float verticalOffset = this.f8989u + getVerticalOffset();
            this.K0.reset();
            this.K0.preTranslate(horizontalOffset, verticalOffset);
            this.f8968b.transform(this.K0);
            this.f8967a.setColor(this.f8969c);
            this.f8967a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f8967a.setStrokeWidth(this.f8982n);
            canvas.drawPath(this.f8968b, this.f8967a);
            this.K0.reset();
            this.K0.preTranslate(-horizontalOffset, -verticalOffset);
            this.f8968b.transform(this.K0);
            return;
        }
        this.E7.set(this.f8967a);
        this.K0.reset();
        float horizontalOffset2 = this.f8987s + getHorizontalOffset();
        float verticalOffset2 = this.f8989u + getVerticalOffset();
        this.K0.postTranslate(horizontalOffset2, verticalOffset2);
        this.K0.preScale(f10, f10);
        this.f8968b.transform(this.K0);
        if (this.f8991v1 != null) {
            this.f8967a.setFilterBitmap(true);
            this.f8967a.setShader(this.f8991v1);
        } else {
            this.f8967a.setColor(this.f8969c);
        }
        this.f8967a.setStyle(Paint.Style.FILL);
        this.f8967a.setStrokeWidth(this.f8982n);
        canvas.drawPath(this.f8968b, this.f8967a);
        if (this.f8991v1 != null) {
            this.f8967a.setShader(null);
        }
        this.f8967a.setColor(this.f8970d);
        this.f8967a.setStyle(Paint.Style.STROKE);
        this.f8967a.setStrokeWidth(this.f8982n);
        canvas.drawPath(this.f8968b, this.f8967a);
        this.K0.reset();
        this.K0.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f8968b.transform(this.K0);
        this.f8967a.set(this.E7);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        this.A = false;
        this.f8987s = getPaddingLeft();
        this.f8988t = getPaddingRight();
        this.f8989u = getPaddingTop();
        this.f8990v = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f8967a;
            String str = this.f8983o;
            textPaint.getTextBounds(str, 0, str.length(), this.f8985q);
            if (mode != 1073741824) {
                size = (int) (this.f8985q.width() + 0.99999f);
            }
            size += this.f8987s + this.f8988t;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f8967a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f8989u + this.f8990v + fontMetricsInt;
            }
        } else if (this.f8996z != 0) {
            this.A = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int gravity) {
        if ((gravity & m.f5027d) == 0) {
            gravity |= m.f5025b;
        }
        if ((gravity & 112) == 0) {
            gravity |= 48;
        }
        if (gravity != this.f8995y) {
            invalidate();
        }
        this.f8995y = gravity;
        int i10 = gravity & 112;
        if (i10 == 48) {
            this.K2 = -1.0f;
        } else if (i10 != 80) {
            this.K2 = 0.0f;
        } else {
            this.K2 = 1.0f;
        }
        int i11 = gravity & m.f5027d;
        if (i11 != 3) {
            if (i11 != 5) {
                if (i11 != 8388611) {
                    if (i11 != 8388613) {
                        this.C2 = 0.0f;
                        return;
                    }
                }
            }
            this.C2 = 1.0f;
            return;
        }
        this.C2 = -1.0f;
    }

    @v0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f8973g = round;
            float f10 = this.f8972f;
            this.f8972f = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z10 = this.f8973g != round;
        this.f8973g = round;
        if (round != 0.0f) {
            if (this.f8968b == null) {
                this.f8968b = new Path();
            }
            if (this.f8975i == null) {
                this.f8975i = new RectF();
            }
            if (this.f8974h == null) {
                b bVar = new b();
                this.f8974h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f8975i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8968b.reset();
            Path path = this.f8968b;
            RectF rectF = this.f8975i;
            float f11 = this.f8973g;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @v0(21)
    public void setRoundPercent(float round) {
        boolean z10 = this.f8972f != round;
        this.f8972f = round;
        if (round != 0.0f) {
            if (this.f8968b == null) {
                this.f8968b = new Path();
            }
            if (this.f8975i == null) {
                this.f8975i = new RectF();
            }
            if (this.f8974h == null) {
                a aVar = new a();
                this.f8974h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f8972f) / 2.0f;
            this.f8975i.set(0.0f, 0.0f, width, height);
            this.f8968b.reset();
            this.f8968b.addRoundRect(this.f8975i, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float size) {
        this.f8977k = size;
    }

    public void setText(CharSequence text) {
        this.f8983o = text.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float pan) {
        this.J7 = pan;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float pan) {
        this.K7 = pan;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float rotation) {
        this.M7 = rotation;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float zoom) {
        this.L7 = zoom;
        l();
        invalidate();
    }

    public void setTextFillColor(int color) {
        this.f8969c = color;
        invalidate();
    }

    public void setTextOutlineColor(int color) {
        this.f8970d = color;
        this.f8971e = true;
        invalidate();
    }

    public void setTextOutlineThickness(float width) {
        this.f8982n = width;
        this.f8971e = true;
        if (Float.isNaN(width)) {
            this.f8982n = 1.0f;
            this.f8971e = false;
        }
        invalidate();
    }

    public void setTextPanX(float textPanX) {
        this.C2 = textPanX;
        invalidate();
    }

    public void setTextPanY(float textPanY) {
        this.K2 = textPanY;
        invalidate();
    }

    public void setTextSize(float size) {
        this.f8976j = size;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(androidx.constraintlayout.motion.widget.c.f());
        sb2.append(GlideException.a.f12263d);
        sb2.append(size);
        sb2.append(" / ");
        sb2.append(this.f8977k);
        TextPaint textPaint = this.f8967a;
        if (!Float.isNaN(this.f8977k)) {
            size = this.f8977k;
        }
        textPaint.setTextSize(size);
        f(Float.isNaN(this.f8977k) ? 1.0f : this.f8976j / this.f8977k);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float mTextureHeight) {
        this.K1 = mTextureHeight;
        l();
        invalidate();
    }

    public void setTextureWidth(float mTextureWidth) {
        this.f8992v2 = mTextureWidth;
        l();
        invalidate();
    }

    public void setTypeface(Typeface tf2) {
        if (this.f8967a.getTypeface() != tf2) {
            this.f8967a.setTypeface(tf2);
            if (this.f8994x != null) {
                this.f8994x = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public e(Context context, @p0 AttributeSet attrs) {
        super(context, attrs);
        this.f8967a = new TextPaint();
        this.f8968b = new Path();
        this.f8969c = 65535;
        this.f8970d = 65535;
        this.f8971e = false;
        this.f8972f = 0.0f;
        this.f8973g = Float.NaN;
        this.f8976j = 48.0f;
        this.f8977k = Float.NaN;
        this.f8982n = 0.0f;
        this.f8983o = "Hello World";
        this.f8984p = true;
        this.f8985q = new Rect();
        this.f8987s = 1;
        this.f8988t = 1;
        this.f8989u = 1;
        this.f8990v = 1;
        this.f8995y = 8388659;
        this.f8996z = 0;
        this.A = false;
        this.K1 = Float.NaN;
        this.f8992v2 = Float.NaN;
        this.C2 = 0.0f;
        this.K2 = 0.0f;
        this.E7 = new Paint();
        this.F7 = 0;
        this.J7 = Float.NaN;
        this.K7 = Float.NaN;
        this.L7 = Float.NaN;
        this.M7 = Float.NaN;
        g(context, attrs);
    }

    public e(Context context, @p0 AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8967a = new TextPaint();
        this.f8968b = new Path();
        this.f8969c = 65535;
        this.f8970d = 65535;
        this.f8971e = false;
        this.f8972f = 0.0f;
        this.f8973g = Float.NaN;
        this.f8976j = 48.0f;
        this.f8977k = Float.NaN;
        this.f8982n = 0.0f;
        this.f8983o = "Hello World";
        this.f8984p = true;
        this.f8985q = new Rect();
        this.f8987s = 1;
        this.f8988t = 1;
        this.f8989u = 1;
        this.f8990v = 1;
        this.f8995y = 8388659;
        this.f8996z = 0;
        this.A = false;
        this.K1 = Float.NaN;
        this.f8992v2 = Float.NaN;
        this.C2 = 0.0f;
        this.K2 = 0.0f;
        this.E7 = new Paint();
        this.F7 = 0;
        this.J7 = Float.NaN;
        this.K7 = Float.NaN;
        this.L7 = Float.NaN;
        this.M7 = Float.NaN;
        g(context, attrs);
    }
}
