package ke;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import m0.g;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f37211i = 68;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f37212j = 20;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f37213k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f37214l = new int[3];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float[] f37215m = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f37216n = new int[4];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float[] f37217o = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Paint f37218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Paint f37219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Paint f37220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f37224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f37225h;

    public b() {
        this(-16777216);
    }

    public void a(@n0 Canvas canvas, @p0 Matrix matrix, @n0 RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f37224g;
        if (z10) {
            int[] iArr = f37216n;
            iArr[0] = 0;
            iArr[1] = this.f37223f;
            iArr[2] = this.f37222e;
            iArr[3] = this.f37221d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f37216n;
            iArr2[0] = 0;
            iArr2[1] = this.f37221d;
            iArr2[2] = this.f37222e;
            iArr2[3] = this.f37223f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / fWidth);
        float[] fArr = f37217o;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f37219b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f37216n, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f37225h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f37219b);
        canvas.restore();
    }

    public void b(@n0 Canvas canvas, @p0 Matrix matrix, @n0 RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f37214l;
        iArr[0] = this.f37223f;
        iArr[1] = this.f37222e;
        iArr[2] = this.f37221d;
        Paint paint = this.f37220c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f37215m, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f37220c);
        canvas.restore();
    }

    public void c(@n0 Canvas canvas, @p0 Matrix matrix, @n0 RectF rectF, int i10, float f10, float f11, @n0 float[] fArr) {
        if (f11 > 0.0f) {
            f10 += f11;
            f11 = -f11;
        }
        a(canvas, matrix, rectF, i10, f10, f11);
        Path path = this.f37224g;
        path.rewind();
        path.moveTo(fArr[0], fArr[1]);
        path.arcTo(rectF, f10, f11);
        path.close();
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        canvas.drawPath(path, this.f37225h);
        canvas.drawPath(path, this.f37218a);
        canvas.restore();
    }

    @n0
    public Paint d() {
        return this.f37218a;
    }

    public void e(int i10) {
        this.f37221d = g.B(i10, 68);
        this.f37222e = g.B(i10, 20);
        this.f37223f = g.B(i10, 0);
        this.f37218a.setColor(this.f37221d);
    }

    public b(int i10) {
        this.f37224g = new Path();
        Paint paint = new Paint();
        this.f37225h = paint;
        this.f37218a = new Paint();
        e(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f37219b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f37220c = new Paint(paint2);
    }
}
