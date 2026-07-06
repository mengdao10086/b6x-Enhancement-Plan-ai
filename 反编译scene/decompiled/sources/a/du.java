package a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class du {
    public static final Matrix b = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final au f602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ba<String, Object> f603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PathMeasure f607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f609a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f610b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f611b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f612b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Path f613b;
    public float c;
    public float d;

    public du() {
        this.f604a = new Matrix();
        this.f5937a = 0.0f;
        this.f610b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.f611b = 255;
        this.f609a = null;
        this.f608a = null;
        this.f603a = new ba<>();
        this.f602a = new au();
        this.f606a = new Path();
        this.f613b = new Path();
    }

    public du(du duVar) {
        this.f604a = new Matrix();
        this.f5937a = 0.0f;
        this.f610b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.f611b = 255;
        this.f609a = null;
        this.f608a = null;
        ba<String, Object> baVar = new ba<>();
        this.f603a = baVar;
        this.f602a = new au(duVar.f602a, baVar);
        this.f606a = new Path(duVar.f606a);
        this.f613b = new Path(duVar.f613b);
        this.f5937a = duVar.f5937a;
        this.f610b = duVar.f610b;
        this.c = duVar.c;
        this.d = duVar.d;
        this.f601a = duVar.f601a;
        this.f611b = duVar.f611b;
        this.f609a = duVar.f609a;
        String str = duVar.f609a;
        if (str != null) {
            this.f603a.put(str, this);
        }
        this.f608a = duVar.f608a;
    }

    public static float a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        c(this.f602a, b, canvas, i, i2, colorFilter);
    }

    public final void c(au auVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        auVar.f136a.set(matrix);
        auVar.f136a.preConcat(auVar.f140b);
        canvas.save();
        for (int i3 = 0; i3 < auVar.f138a.size(); i3++) {
            bu buVar = auVar.f138a.get(i3);
            if (buVar instanceof au) {
                c((au) buVar, auVar.f136a, canvas, i, i2, colorFilter);
            } else if (buVar instanceof cu) {
                d(auVar, (cu) buVar, canvas, i, i2, colorFilter);
            }
        }
        canvas.restore();
    }

    public final void d(au auVar, cu cuVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = i / this.c;
        float f2 = i2 / this.d;
        float fMin = Math.min(f, f2);
        Matrix matrix = auVar.f136a;
        this.f604a.set(matrix);
        this.f604a.postScale(f, f2);
        float fE = e(matrix);
        if (fE == 0.0f) {
            return;
        }
        cuVar.d(this.f606a);
        Path path = this.f606a;
        this.f613b.reset();
        if (cuVar.c()) {
            this.f613b.setFillType(cuVar.f5828a == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
            this.f613b.addPath(path, this.f604a);
            canvas.clipPath(this.f613b);
            return;
        }
        zt ztVar = (zt) cuVar;
        if (ztVar.d != 0.0f || ztVar.e != 1.0f) {
            float f3 = ztVar.d;
            float f4 = ztVar.f;
            float f5 = (f3 + f4) % 1.0f;
            float f6 = (ztVar.e + f4) % 1.0f;
            if (this.f607a == null) {
                this.f607a = new PathMeasure();
            }
            this.f607a.setPath(this.f606a, false);
            float length = this.f607a.getLength();
            float f7 = f5 * length;
            float f8 = f6 * length;
            path.reset();
            if (f7 > f8) {
                this.f607a.getSegment(f7, length, path, true);
                this.f607a.getSegment(0.0f, f8, path, true);
            } else {
                this.f607a.getSegment(f7, f8, path, true);
            }
            path.rLineTo(0.0f, 0.0f);
        }
        this.f613b.addPath(path, this.f604a);
        if (ztVar.f3887b.l()) {
            cc ccVar = ztVar.f3887b;
            if (this.f612b == null) {
                Paint paint = new Paint(1);
                this.f612b = paint;
                paint.setStyle(Paint.Style.FILL);
            }
            Paint paint2 = this.f612b;
            if (ccVar.h()) {
                Shader shaderF = ccVar.f();
                shaderF.setLocalMatrix(this.f604a);
                paint2.setShader(shaderF);
                paint2.setAlpha(Math.round(ztVar.c * 255.0f));
            } else {
                paint2.setShader(null);
                paint2.setAlpha(255);
                paint2.setColor(gu.a(ccVar.e(), ztVar.c));
            }
            paint2.setColorFilter(colorFilter);
            this.f613b.setFillType(((cu) ztVar).f5828a == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
            canvas.drawPath(this.f613b, paint2);
        }
        if (ztVar.f3883a.l()) {
            cc ccVar2 = ztVar.f3883a;
            if (this.f605a == null) {
                Paint paint3 = new Paint(1);
                this.f605a = paint3;
                paint3.setStyle(Paint.Style.STROKE);
            }
            Paint paint4 = this.f605a;
            Paint.Join join = ztVar.f3885a;
            if (join != null) {
                paint4.setStrokeJoin(join);
            }
            Paint.Cap cap = ztVar.f3884a;
            if (cap != null) {
                paint4.setStrokeCap(cap);
            }
            paint4.setStrokeMiter(ztVar.g);
            if (ccVar2.h()) {
                Shader shaderF2 = ccVar2.f();
                shaderF2.setLocalMatrix(this.f604a);
                paint4.setShader(shaderF2);
                paint4.setAlpha(Math.round(ztVar.b * 255.0f));
            } else {
                paint4.setShader(null);
                paint4.setAlpha(255);
                paint4.setColor(gu.a(ccVar2.e(), ztVar.b));
            }
            paint4.setColorFilter(colorFilter);
            paint4.setStrokeWidth(ztVar.f8095a * fMin * fE);
            canvas.drawPath(this.f613b, paint4);
        }
    }

    public final float e(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
        float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
        float fMax = Math.max(fHypot, fHypot2);
        if (fMax > 0.0f) {
            return Math.abs(fA) / fMax;
        }
        return 0.0f;
    }

    public boolean f() {
        if (this.f608a == null) {
            this.f608a = Boolean.valueOf(this.f602a.a());
        }
        return this.f608a.booleanValue();
    }

    public boolean g(int[] iArr) {
        return this.f602a.b(iArr);
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f611b;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f611b = i;
    }
}
