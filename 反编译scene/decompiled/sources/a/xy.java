package a;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xy {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f3634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f3635a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f3636b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Paint f3637b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Paint f3638c;
    public Paint d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f3631a = new int[3];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f7929a = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f3632b = new int[4];
    public static final float[] b = {0.0f, 0.0f, 0.5f, 1.0f};

    public xy() {
        this(-16777216);
    }

    public xy(int i) {
        this.f3635a = new Path();
        this.d = new Paint();
        this.f3634a = new Paint();
        d(i);
        this.d.setColor(0);
        Paint paint = new Paint(4);
        this.f3637b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3638c = new Paint(this.f3637b);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i, float f, float f2) {
        boolean z = f2 < 0.0f;
        Path path = this.f3635a;
        if (z) {
            int[] iArr = f3632b;
            iArr[0] = 0;
            iArr[1] = this.c;
            iArr[2] = this.f3636b;
            iArr[3] = this.f3633a;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            int[] iArr2 = f3632b;
            iArr2[0] = 0;
            iArr2[1] = this.f3633a;
            iArr2[2] = this.f3636b;
            iArr2[3] = this.c;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / fWidth);
        float[] fArr = b;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        this.f3637b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f3632b, b, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.d);
        }
        canvas.drawArc(rectF, f, f2, true, this.f3637b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = f3631a;
        iArr[0] = this.c;
        iArr[1] = this.f3636b;
        iArr[2] = this.f3633a;
        Paint paint = this.f3638c;
        float f = rectF.left;
        paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, f3631a, f7929a, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f3638c);
        canvas.restore();
    }

    public Paint c() {
        return this.f3634a;
    }

    public void d(int i) {
        this.f3633a = tc.d(i, 68);
        this.f3636b = tc.d(i, 20);
        this.c = tc.d(i, 0);
        this.f3634a.setColor(this.f3633a);
    }
}
