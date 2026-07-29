package sd;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import g.l;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f49665k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f49666l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f49667m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49668n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f49669o = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f49670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final View f49671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Path f49672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Paint f49673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Paint f49674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public g.e f49675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Drawable f49676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f49677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f49679j;

    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(a aVar) {
        this.f49670a = aVar;
        View view = (View) aVar;
        this.f49671b = view;
        view.setWillNotDraw(false);
        this.f49672c = new Path();
        this.f49673d = new Paint(7);
        Paint paint = new Paint(1);
        this.f49674e = paint;
        paint.setColor(0);
    }

    public void a() {
        if (f49669o == 0) {
            this.f49678i = true;
            this.f49679j = false;
            this.f49671b.buildDrawingCache();
            Bitmap drawingCache = this.f49671b.getDrawingCache();
            if (drawingCache == null && this.f49671b.getWidth() != 0 && this.f49671b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f49671b.getWidth(), this.f49671b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f49671b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f49673d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f49678i = false;
            this.f49679j = true;
        }
    }

    public void b() {
        if (f49669o == 0) {
            this.f49679j = false;
            this.f49671b.destroyDrawingCache();
            this.f49673d.setShader(null);
            this.f49671b.invalidate();
        }
    }

    public void c(@n0 Canvas canvas) {
        if (p()) {
            int i10 = f49669o;
            if (i10 == 0) {
                g.e eVar = this.f49675f;
                canvas.drawCircle(eVar.f49687a, eVar.f49688b, eVar.f49689c, this.f49673d);
                if (r()) {
                    g.e eVar2 = this.f49675f;
                    canvas.drawCircle(eVar2.f49687a, eVar2.f49688b, eVar2.f49689c, this.f49674e);
                }
            } else if (i10 == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f49672c);
                this.f49670a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f49671b.getWidth(), this.f49671b.getHeight(), this.f49674e);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i10);
                }
                this.f49670a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f49671b.getWidth(), this.f49671b.getHeight(), this.f49674e);
                }
            }
        } else {
            this.f49670a.c(canvas);
            if (r()) {
                canvas.drawRect(0.0f, 0.0f, this.f49671b.getWidth(), this.f49671b.getHeight(), this.f49674e);
            }
        }
        f(canvas);
    }

    public final void d(@n0 Canvas canvas, int i10, float f10) {
        this.f49677h.setColor(i10);
        this.f49677h.setStrokeWidth(f10);
        g.e eVar = this.f49675f;
        canvas.drawCircle(eVar.f49687a, eVar.f49688b, eVar.f49689c - (f10 / 2.0f), this.f49677h);
    }

    public final void e(@n0 Canvas canvas) {
        this.f49670a.c(canvas);
        if (r()) {
            g.e eVar = this.f49675f;
            canvas.drawCircle(eVar.f49687a, eVar.f49688b, eVar.f49689c, this.f49674e);
        }
        if (p()) {
            d(canvas, -16777216, 10.0f);
            d(canvas, -65536, 5.0f);
        }
        f(canvas);
    }

    public final void f(@n0 Canvas canvas) {
        if (q()) {
            Rect bounds = this.f49676g.getBounds();
            float fWidth = this.f49675f.f49687a - (bounds.width() / 2.0f);
            float fHeight = this.f49675f.f49688b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f49676g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    @p0
    public Drawable g() {
        return this.f49676g;
    }

    @l
    public int h() {
        return this.f49674e.getColor();
    }

    public final float i(@n0 g.e eVar) {
        return de.a.b(eVar.f49687a, eVar.f49688b, 0.0f, 0.0f, this.f49671b.getWidth(), this.f49671b.getHeight());
    }

    @p0
    public g.e j() {
        g.e eVar = this.f49675f;
        if (eVar == null) {
            return null;
        }
        g.e eVar2 = new g.e(eVar);
        if (eVar2.a()) {
            eVar2.f49689c = i(eVar2);
        }
        return eVar2;
    }

    public final void k() {
        if (f49669o == 1) {
            this.f49672c.rewind();
            g.e eVar = this.f49675f;
            if (eVar != null) {
                this.f49672c.addCircle(eVar.f49687a, eVar.f49688b, eVar.f49689c, Path.Direction.CW);
            }
        }
        this.f49671b.invalidate();
    }

    public boolean l() {
        return this.f49670a.d() && !p();
    }

    public void m(@p0 Drawable drawable) {
        this.f49676g = drawable;
        this.f49671b.invalidate();
    }

    public void n(@l int i10) {
        this.f49674e.setColor(i10);
        this.f49671b.invalidate();
    }

    public void o(@p0 g.e eVar) {
        if (eVar == null) {
            this.f49675f = null;
        } else {
            g.e eVar2 = this.f49675f;
            if (eVar2 == null) {
                this.f49675f = new g.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (de.a.e(eVar.f49689c, i(eVar), 1.0E-4f)) {
                this.f49675f.f49689c = Float.MAX_VALUE;
            }
        }
        k();
    }

    public final boolean p() {
        g.e eVar = this.f49675f;
        boolean z10 = eVar == null || eVar.a();
        return f49669o == 0 ? !z10 && this.f49679j : !z10;
    }

    public final boolean q() {
        return (this.f49678i || this.f49676g == null || this.f49675f == null) ? false : true;
    }

    public final boolean r() {
        return (this.f49678i || Color.alpha(this.f49674e.getColor()) == 0) ? false : true;
    }
}
