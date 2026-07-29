package ja;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import la.c;
import va.q;
import va.t;
import xa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RtlHardcoded"})
public abstract class b<T extends la.c<? extends qa.b<? extends Entry>>> extends e<T> implements pa.b {
    public int E7;
    public boolean F7;
    public boolean G7;
    public boolean H7;
    public boolean I7;
    public boolean J7;
    public boolean K7;
    public boolean L7;
    public boolean M7;
    public Paint N7;
    public Paint O7;
    public boolean P7;
    public boolean Q7;
    public boolean R7;
    public float S7;
    public boolean T7;
    public sa.c U7;
    public YAxis V7;
    public YAxis W7;
    public t X7;
    public t Y7;
    public xa.i Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public xa.i f36223a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public q f36224b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public long f36225c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public long f36226d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public RectF f36227e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public Matrix f36228f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public Matrix f36229g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public boolean f36230h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public float[] f36231i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public xa.f f36232j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public xa.f f36233k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public float[] f36234l8;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f36235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f36236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f36237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f36238d;

        public a(float f10, float f11, float f12, float f13) {
            this.f36235a = f10;
            this.f36236b = f11;
            this.f36237c = f12;
            this.f36238d = f13;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f36266t.U(this.f36235a, this.f36236b, this.f36237c, this.f36238d);
            b.this.G0();
            b.this.H0();
        }
    }

    /* JADX INFO: renamed from: ja.b$b, reason: collision with other inner class name */
    public static /* synthetic */ class C0410b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f36241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f36242c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f36242c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36242c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f36241b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36241b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36241b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f36240a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36240a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E7 = 100;
        this.F7 = false;
        this.G7 = false;
        this.H7 = true;
        this.I7 = true;
        this.J7 = true;
        this.K7 = true;
        this.L7 = true;
        this.M7 = true;
        this.P7 = false;
        this.Q7 = false;
        this.R7 = false;
        this.S7 = 15.0f;
        this.T7 = false;
        this.f36225c8 = 0L;
        this.f36226d8 = 0L;
        this.f36227e8 = new RectF();
        this.f36228f8 = new Matrix();
        this.f36229g8 = new Matrix();
        this.f36230h8 = false;
        this.f36231i8 = new float[2];
        this.f36232j8 = xa.f.b(0.0d, 0.0d);
        this.f36233k8 = xa.f.b(0.0d, 0.0d);
        this.f36234l8 = new float[2];
    }

    public boolean A0() {
        return this.G7;
    }

    public boolean B0() {
        return this.L7;
    }

    public boolean C0() {
        return this.M7;
    }

    public void D0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        g(ra.d.d(this.f36266t, f10, f11 + ((g0(axisDependency) / this.f36266t.x()) / 2.0f), a(axisDependency), this));
    }

    @TargetApi(11)
    public void E0(float f10, float f11, YAxis.AxisDependency axisDependency, long j10) {
        xa.f fVarM0 = m0(this.f36266t.h(), this.f36266t.j(), axisDependency);
        g(ra.a.j(this.f36266t, f10, f11 + ((g0(axisDependency) / this.f36266t.x()) / 2.0f), a(axisDependency), this, (float) fVarM0.f54983c, (float) fVarM0.f54984d, j10));
        xa.f.c(fVarM0);
    }

    public void F0(float f10) {
        g(ra.d.d(this.f36266t, f10, 0.0f, a(YAxis.AxisDependency.LEFT), this));
    }

    public void G0() {
        this.f36223a8.p(this.W7.I0());
        this.Z7.p(this.V7.I0());
    }

    @Override // ja.e
    public void H() {
        super.H();
        this.V7 = new YAxis(YAxis.AxisDependency.LEFT);
        this.W7 = new YAxis(YAxis.AxisDependency.RIGHT);
        this.Z7 = new xa.i(this.f36266t);
        this.f36223a8 = new xa.i(this.f36266t);
        this.X7 = new t(this.f36266t, this.V7, this.Z7);
        this.Y7 = new t(this.f36266t, this.W7, this.f36223a8);
        this.f36224b8 = new q(this.f36266t, this.f36254i, this.Z7);
        setHighlighter(new oa.b(this));
        this.f36260n = new com.github.mikephil.charting.listener.a(this, this.f36266t.r(), 3.0f);
        Paint paint = new Paint();
        this.N7 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.N7.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.O7 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.O7.setColor(-16777216);
        this.O7.setStrokeWidth(k.e(1.0f));
    }

    public void H0() {
        if (this.f36246a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Preparing Value-Px Matrix, xmin: ");
            sb2.append(this.f36254i.H);
            sb2.append(", xmax: ");
            sb2.append(this.f36254i.G);
            sb2.append(", xdelta: ");
            sb2.append(this.f36254i.I);
        }
        xa.i iVar = this.f36223a8;
        XAxis xAxis = this.f36254i;
        float f10 = xAxis.H;
        float f11 = xAxis.I;
        YAxis yAxis = this.W7;
        iVar.q(f10, f11, yAxis.I, yAxis.H);
        xa.i iVar2 = this.Z7;
        XAxis xAxis2 = this.f36254i;
        float f12 = xAxis2.H;
        float f13 = xAxis2.I;
        YAxis yAxis2 = this.V7;
        iVar2.q(f12, f13, yAxis2.I, yAxis2.H);
    }

    public void I0() {
        this.f36225c8 = 0L;
        this.f36226d8 = 0L;
    }

    public void J0() {
        this.f36230h8 = false;
        p();
    }

    public void K0() {
        this.f36266t.T(this.f36228f8);
        this.f36266t.S(this.f36228f8, this, false);
        p();
        postInvalidate();
    }

    public void L0(float f10, float f11) {
        this.f36266t.c0(f10);
        this.f36266t.d0(f11);
    }

    public void M0(float f10, float f11, float f12, float f13) {
        this.f36230h8 = true;
        post(new a(f10, f11, f12, f13));
    }

    public void N0(float f10, float f11) {
        float f12 = this.f36254i.I;
        this.f36266t.a0(f12 / f10, f12 / f11);
    }

    @Override // ja.e
    public void O() {
        if (this.f36247b == 0) {
            return;
        }
        va.g gVar = this.f36264r;
        if (gVar != null) {
            gVar.j();
        }
        o();
        t tVar = this.X7;
        YAxis yAxis = this.V7;
        tVar.a(yAxis.H, yAxis.G, yAxis.I0());
        t tVar2 = this.Y7;
        YAxis yAxis2 = this.W7;
        tVar2.a(yAxis2.H, yAxis2.G, yAxis2.I0());
        q qVar = this.f36224b8;
        XAxis xAxis = this.f36254i;
        qVar.a(xAxis.H, xAxis.G, false);
        if (this.f36258l != null) {
            this.f36263q.a(this.f36247b);
        }
        p();
    }

    public void O0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        this.f36266t.b0(g0(axisDependency) / f10, g0(axisDependency) / f11);
    }

    public void P0(float f10, YAxis.AxisDependency axisDependency) {
        this.f36266t.d0(g0(axisDependency) / f10);
    }

    public void Q0(float f10, YAxis.AxisDependency axisDependency) {
        this.f36266t.Z(g0(axisDependency) / f10);
    }

    public void R0(float f10, float f11, float f12, float f13) {
        this.f36266t.l0(f10, f11, f12, -f13, this.f36228f8);
        this.f36266t.S(this.f36228f8, this, false);
        p();
        postInvalidate();
    }

    public void S0(float f10, float f11, float f12, float f13, YAxis.AxisDependency axisDependency) {
        g(ra.f.d(this.f36266t, f10, f11, f12, f13, a(axisDependency), axisDependency, this));
    }

    @TargetApi(11)
    public void T0(float f10, float f11, float f12, float f13, YAxis.AxisDependency axisDependency, long j10) {
        xa.f fVarM0 = m0(this.f36266t.h(), this.f36266t.j(), axisDependency);
        g(ra.c.j(this.f36266t, this, a(axisDependency), e(axisDependency), this.f36254i.I, f10, f11, this.f36266t.w(), this.f36266t.x(), f12, f13, (float) fVarM0.f54983c, (float) fVarM0.f54984d, j10));
        xa.f.c(fVarM0);
    }

    public void U0() {
        xa.g gVarP = this.f36266t.p();
        this.f36266t.o0(gVarP.f54987c, -gVarP.f54988d, this.f36228f8);
        this.f36266t.S(this.f36228f8, this, false);
        xa.g.h(gVarP);
        p();
        postInvalidate();
    }

    @Override // ja.e
    public void V(Paint paint, int i10) {
        super.V(paint, i10);
        if (i10 != 4) {
            return;
        }
        this.N7 = paint;
    }

    public void V0() {
        xa.g gVarP = this.f36266t.p();
        this.f36266t.q0(gVarP.f54987c, -gVarP.f54988d, this.f36228f8);
        this.f36266t.S(this.f36228f8, this, false);
        xa.g.h(gVarP);
        p();
        postInvalidate();
    }

    public void W0(float f10, float f11) {
        xa.g centerOffsets = getCenterOffsets();
        Matrix matrix = this.f36228f8;
        this.f36266t.l0(f10, f11, centerOffsets.f54987c, -centerOffsets.f54988d, matrix);
        this.f36266t.S(matrix, this, false);
    }

    public void Z() {
        ((la.c) this.f36247b).g(getLowestVisibleX(), getHighestVisibleX());
        this.f36254i.n(((la.c) this.f36247b).y(), ((la.c) this.f36247b).x());
        if (this.V7.f()) {
            YAxis yAxis = this.V7;
            la.c cVar = (la.c) this.f36247b;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.n(cVar.C(axisDependency), ((la.c) this.f36247b).A(axisDependency));
        }
        if (this.W7.f()) {
            YAxis yAxis2 = this.W7;
            la.c cVar2 = (la.c) this.f36247b;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.n(cVar2.C(axisDependency2), ((la.c) this.f36247b).A(axisDependency2));
        }
        p();
    }

    @Override // pa.b
    public xa.i a(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.Z7 : this.f36223a8;
    }

    public void a0(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.f36258l;
        if (legend == null || !legend.f() || this.f36258l.H()) {
            return;
        }
        int i10 = C0410b.f36242c[this.f36258l.C().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return;
            }
            int i11 = C0410b.f36240a[this.f36258l.E().ordinal()];
            if (i11 == 1) {
                rectF.top += Math.min(this.f36258l.f16608y, this.f36266t.n() * this.f36258l.z()) + this.f36258l.e();
                return;
            } else {
                if (i11 != 2) {
                    return;
                }
                rectF.bottom += Math.min(this.f36258l.f16608y, this.f36266t.n() * this.f36258l.z()) + this.f36258l.e();
                return;
            }
        }
        int i12 = C0410b.f36241b[this.f36258l.y().ordinal()];
        if (i12 == 1) {
            rectF.left += Math.min(this.f36258l.f16607x, this.f36266t.o() * this.f36258l.z()) + this.f36258l.d();
            return;
        }
        if (i12 == 2) {
            rectF.right += Math.min(this.f36258l.f16607x, this.f36266t.o() * this.f36258l.z()) + this.f36258l.d();
            return;
        }
        if (i12 != 3) {
            return;
        }
        int i13 = C0410b.f36240a[this.f36258l.E().ordinal()];
        if (i13 == 1) {
            rectF.top += Math.min(this.f36258l.f16608y, this.f36266t.n() * this.f36258l.z()) + this.f36258l.e();
        } else {
            if (i13 != 2) {
                return;
            }
            rectF.bottom += Math.min(this.f36258l.f16608y, this.f36266t.n() * this.f36258l.z()) + this.f36258l.e();
        }
    }

    public void b0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        float fG0 = g0(axisDependency) / this.f36266t.x();
        g(ra.d.d(this.f36266t, f10 - ((getXAxis().I / this.f36266t.w()) / 2.0f), f11 + (fG0 / 2.0f), a(axisDependency), this));
    }

    @TargetApi(11)
    public void c0(float f10, float f11, YAxis.AxisDependency axisDependency, long j10) {
        xa.f fVarM0 = m0(this.f36266t.h(), this.f36266t.j(), axisDependency);
        float fG0 = g0(axisDependency) / this.f36266t.x();
        g(ra.a.j(this.f36266t, f10 - ((getXAxis().I / this.f36266t.w()) / 2.0f), f11 + (fG0 / 2.0f), a(axisDependency), this, (float) fVarM0.f54983c, (float) fVarM0.f54984d, j10));
        xa.f.c(fVarM0);
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f36260n;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.a) {
            ((com.github.mikephil.charting.listener.a) chartTouchListener).h();
        }
    }

    public void d0(float f10, YAxis.AxisDependency axisDependency) {
        g(ra.d.d(this.f36266t, 0.0f, f10 + ((g0(axisDependency) / this.f36266t.x()) / 2.0f), a(axisDependency), this));
    }

    public YAxis e(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.V7 : this.W7;
    }

    public void e0(Canvas canvas) {
        if (this.P7) {
            canvas.drawRect(this.f36266t.q(), this.N7);
        }
        if (this.Q7) {
            canvas.drawRect(this.f36266t.q(), this.O7);
        }
    }

    @Override // pa.b
    public boolean f(YAxis.AxisDependency axisDependency) {
        return e(axisDependency).I0();
    }

    public void f0() {
        Matrix matrix = this.f36229g8;
        this.f36266t.m(matrix);
        this.f36266t.S(matrix, this, false);
        p();
        postInvalidate();
    }

    public float g0(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.V7.I : this.W7.I;
    }

    public YAxis getAxisLeft() {
        return this.V7;
    }

    public YAxis getAxisRight() {
        return this.W7;
    }

    @Override // ja.e, pa.e, pa.b
    public /* bridge */ /* synthetic */ la.c getData() {
        return (la.c) super.getData();
    }

    public sa.c getDrawListener() {
        return this.U7;
    }

    @Override // pa.b
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.f36266t.i(), this.f36266t.f(), this.f36233k8);
        return (float) Math.min(this.f36254i.G, this.f36233k8.f54983c);
    }

    @Override // pa.b
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.f36266t.h(), this.f36266t.f(), this.f36232j8);
        return (float) Math.max(this.f36254i.H, this.f36232j8.f54983c);
    }

    @Override // pa.e
    public int getMaxVisibleCount() {
        return this.E7;
    }

    public float getMinOffset() {
        return this.S7;
    }

    public t getRendererLeftYAxis() {
        return this.X7;
    }

    public t getRendererRightYAxis() {
        return this.Y7;
    }

    public q getRendererXAxis() {
        return this.f36224b8;
    }

    @Override // android.view.View
    public float getScaleX() {
        l lVar = this.f36266t;
        if (lVar == null) {
            return 1.0f;
        }
        return lVar.w();
    }

    @Override // android.view.View
    public float getScaleY() {
        l lVar = this.f36266t;
        if (lVar == null) {
            return 1.0f;
        }
        return lVar.x();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // pa.e
    public float getYChartMax() {
        return Math.max(this.V7.G, this.W7.G);
    }

    @Override // pa.e
    public float getYChartMin() {
        return Math.min(this.V7.H, this.W7.H);
    }

    public qa.b h0(float f10, float f11) {
        oa.d dVarX = x(f10, f11);
        if (dVarX != null) {
            return (qa.b) ((la.c) this.f36247b).k(dVarX.d());
        }
        return null;
    }

    public Entry i0(float f10, float f11) {
        oa.d dVarX = x(f10, f11);
        if (dVarX != null) {
            return ((la.c) this.f36247b).s(dVarX);
        }
        return null;
    }

    public xa.f j0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        return a(axisDependency).f(f10, f11);
    }

    public xa.g k0(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        this.f36231i8[0] = entry.F();
        this.f36231i8[1] = entry.e();
        a(axisDependency).o(this.f36231i8);
        float[] fArr = this.f36231i8;
        return xa.g.c(fArr[0], fArr[1]);
    }

    public xa.f m0(float f10, float f11, YAxis.AxisDependency axisDependency) {
        xa.f fVarB = xa.f.b(0.0d, 0.0d);
        n0(f10, f11, axisDependency, fVarB);
        return fVarB;
    }

    public void n0(float f10, float f11, YAxis.AxisDependency axisDependency, xa.f fVar) {
        a(axisDependency).k(f10, f11, fVar);
    }

    @Override // ja.e
    public void o() {
        this.f36254i.n(((la.c) this.f36247b).y(), ((la.c) this.f36247b).x());
        YAxis yAxis = this.V7;
        la.c cVar = (la.c) this.f36247b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(cVar.C(axisDependency), ((la.c) this.f36247b).A(axisDependency));
        YAxis yAxis2 = this.W7;
        la.c cVar2 = (la.c) this.f36247b;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.n(cVar2.C(axisDependency2), ((la.c) this.f36247b).A(axisDependency2));
    }

    public boolean o0() {
        return this.f36266t.C();
    }

    @Override // ja.e, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f36247b == 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        e0(canvas);
        if (this.F7) {
            Z();
        }
        if (this.V7.f()) {
            t tVar = this.X7;
            YAxis yAxis = this.V7;
            tVar.a(yAxis.H, yAxis.G, yAxis.I0());
        }
        if (this.W7.f()) {
            t tVar2 = this.Y7;
            YAxis yAxis2 = this.W7;
            tVar2.a(yAxis2.H, yAxis2.G, yAxis2.I0());
        }
        if (this.f36254i.f()) {
            q qVar = this.f36224b8;
            XAxis xAxis = this.f36254i;
            qVar.a(xAxis.H, xAxis.G, false);
        }
        this.f36224b8.h(canvas);
        this.X7.h(canvas);
        this.Y7.h(canvas);
        if (this.f36254i.N()) {
            this.f36224b8.i(canvas);
        }
        if (this.V7.N()) {
            this.X7.i(canvas);
        }
        if (this.W7.N()) {
            this.Y7.i(canvas);
        }
        if (this.f36254i.f() && this.f36254i.Q()) {
            this.f36224b8.j(canvas);
        }
        if (this.V7.f() && this.V7.Q()) {
            this.X7.j(canvas);
        }
        if (this.W7.f() && this.W7.Q()) {
            this.Y7.j(canvas);
        }
        int iSave = canvas.save();
        canvas.clipRect(this.f36266t.q());
        this.f36264r.b(canvas);
        if (!this.f36254i.N()) {
            this.f36224b8.i(canvas);
        }
        if (!this.V7.N()) {
            this.X7.i(canvas);
        }
        if (!this.W7.N()) {
            this.Y7.i(canvas);
        }
        if (Y()) {
            this.f36264r.d(canvas, this.A);
        }
        canvas.restoreToCount(iSave);
        this.f36264r.c(canvas);
        if (this.f36254i.f() && !this.f36254i.Q()) {
            this.f36224b8.j(canvas);
        }
        if (this.V7.f() && !this.V7.Q()) {
            this.X7.j(canvas);
        }
        if (this.W7.f() && !this.W7.Q()) {
            this.Y7.j(canvas);
        }
        this.f36224b8.g(canvas);
        this.X7.g(canvas);
        this.Y7.g(canvas);
        if (r0()) {
            int iSave2 = canvas.save();
            canvas.clipRect(this.f36266t.q());
            this.f36264r.f(canvas);
            canvas.restoreToCount(iSave2);
        } else {
            this.f36264r.f(canvas);
        }
        this.f36263q.f(canvas);
        u(canvas);
        v(canvas);
        if (this.f36246a) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            long j10 = this.f36225c8 + jCurrentTimeMillis2;
            this.f36225c8 = j10;
            long j11 = this.f36226d8 + 1;
            this.f36226d8 = j11;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Drawtime: ");
            sb2.append(jCurrentTimeMillis2);
            sb2.append(" ms, average: ");
            sb2.append(j10 / j11);
            sb2.append(" ms, cycles: ");
            sb2.append(this.f36226d8);
        }
    }

    @Override // ja.e, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        float[] fArr = this.f36234l8;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.T7) {
            fArr[0] = this.f36266t.h();
            this.f36234l8[1] = this.f36266t.j();
            a(YAxis.AxisDependency.LEFT).n(this.f36234l8);
        }
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.T7) {
            a(YAxis.AxisDependency.LEFT).o(this.f36234l8);
            this.f36266t.e(this.f36234l8, this);
        } else {
            l lVar = this.f36266t;
            lVar.S(lVar.r(), this, true);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.f36260n;
        if (chartTouchListener == null || this.f36247b == 0 || !this.f36255j) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    @Override // ja.e
    public void p() {
        if (!this.f36230h8) {
            a0(this.f36227e8);
            RectF rectF = this.f36227e8;
            float fA0 = rectF.left + 0.0f;
            float f10 = rectF.top + 0.0f;
            float fA02 = rectF.right + 0.0f;
            float f11 = rectF.bottom + 0.0f;
            if (this.V7.L0()) {
                fA0 += this.V7.A0(this.X7.c());
            }
            if (this.W7.L0()) {
                fA02 += this.W7.A0(this.Y7.c());
            }
            if (this.f36254i.f() && this.f36254i.P()) {
                float fE = r2.M + this.f36254i.e();
                if (this.f36254i.w0() == XAxis.XAxisPosition.BOTTOM) {
                    f11 += fE;
                } else if (this.f36254i.w0() == XAxis.XAxisPosition.TOP) {
                    f10 += fE;
                } else if (this.f36254i.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                    f11 += fE;
                    f10 += fE;
                }
            }
            float extraTopOffset = f10 + getExtraTopOffset();
            float extraRightOffset = fA02 + getExtraRightOffset();
            float extraBottomOffset = f11 + getExtraBottomOffset();
            float extraLeftOffset = fA0 + getExtraLeftOffset();
            float fE2 = k.e(this.S7);
            this.f36266t.U(Math.max(fE2, extraLeftOffset), Math.max(fE2, extraTopOffset), Math.max(fE2, extraRightOffset), Math.max(fE2, extraBottomOffset));
            if (this.f36246a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offsetLeft: ");
                sb2.append(extraLeftOffset);
                sb2.append(", offsetTop: ");
                sb2.append(extraTopOffset);
                sb2.append(", offsetRight: ");
                sb2.append(extraRightOffset);
                sb2.append(", offsetBottom: ");
                sb2.append(extraBottomOffset);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content: ");
                sb3.append(this.f36266t.q().toString());
            }
        }
        G0();
        H0();
    }

    public boolean p0() {
        return this.V7.I0() || this.W7.I0();
    }

    public boolean q0() {
        return this.F7;
    }

    public boolean r0() {
        return this.R7;
    }

    public boolean s0() {
        return this.H7;
    }

    public void setAutoScaleMinMaxEnabled(boolean z10) {
        this.F7 = z10;
    }

    public void setBorderColor(int i10) {
        this.O7.setColor(i10);
    }

    public void setBorderWidth(float f10) {
        this.O7.setStrokeWidth(k.e(f10));
    }

    public void setClipValuesToContent(boolean z10) {
        this.R7 = z10;
    }

    public void setDoubleTapToZoomEnabled(boolean z10) {
        this.H7 = z10;
    }

    public void setDragEnabled(boolean z10) {
        this.J7 = z10;
        this.K7 = z10;
    }

    public void setDragOffsetX(float f10) {
        this.f36266t.W(f10);
    }

    public void setDragOffsetY(float f10) {
        this.f36266t.X(f10);
    }

    public void setDragXEnabled(boolean z10) {
        this.J7 = z10;
    }

    public void setDragYEnabled(boolean z10) {
        this.K7 = z10;
    }

    public void setDrawBorders(boolean z10) {
        this.Q7 = z10;
    }

    public void setDrawGridBackground(boolean z10) {
        this.P7 = z10;
    }

    public void setGridBackgroundColor(int i10) {
        this.N7.setColor(i10);
    }

    public void setHighlightPerDragEnabled(boolean z10) {
        this.I7 = z10;
    }

    public void setKeepPositionOnRotation(boolean z10) {
        this.T7 = z10;
    }

    public void setMaxVisibleValueCount(int i10) {
        this.E7 = i10;
    }

    public void setMinOffset(float f10) {
        this.S7 = f10;
    }

    public void setOnDrawListener(sa.c cVar) {
        this.U7 = cVar;
    }

    public void setPinchZoom(boolean z10) {
        this.G7 = z10;
    }

    public void setRendererLeftYAxis(t tVar) {
        this.X7 = tVar;
    }

    public void setRendererRightYAxis(t tVar) {
        this.Y7 = tVar;
    }

    public void setScaleEnabled(boolean z10) {
        this.L7 = z10;
        this.M7 = z10;
    }

    public void setScaleXEnabled(boolean z10) {
        this.L7 = z10;
    }

    public void setScaleYEnabled(boolean z10) {
        this.M7 = z10;
    }

    public void setVisibleXRangeMaximum(float f10) {
        this.f36266t.c0(this.f36254i.I / f10);
    }

    public void setVisibleXRangeMinimum(float f10) {
        this.f36266t.Y(this.f36254i.I / f10);
    }

    public void setXAxisRenderer(q qVar) {
        this.f36224b8 = qVar;
    }

    public boolean t0() {
        return this.J7 || this.K7;
    }

    public boolean u0() {
        return this.J7;
    }

    public boolean v0() {
        return this.K7;
    }

    public boolean w0() {
        return this.Q7;
    }

    public boolean x0() {
        return this.f36266t.D();
    }

    public boolean y0() {
        return this.I7;
    }

    @Override // ja.e
    public Paint z(int i10) {
        Paint paintZ = super.z(i10);
        if (paintZ != null) {
            return paintZ;
        }
        if (i10 != 4) {
            return null;
        }
        return this.N7;
    }

    public boolean z0() {
        return this.T7;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E7 = 100;
        this.F7 = false;
        this.G7 = false;
        this.H7 = true;
        this.I7 = true;
        this.J7 = true;
        this.K7 = true;
        this.L7 = true;
        this.M7 = true;
        this.P7 = false;
        this.Q7 = false;
        this.R7 = false;
        this.S7 = 15.0f;
        this.T7 = false;
        this.f36225c8 = 0L;
        this.f36226d8 = 0L;
        this.f36227e8 = new RectF();
        this.f36228f8 = new Matrix();
        this.f36229g8 = new Matrix();
        this.f36230h8 = false;
        this.f36231i8 = new float[2];
        this.f36232j8 = xa.f.b(0.0d, 0.0d);
        this.f36233k8 = xa.f.b(0.0d, 0.0d);
        this.f36234l8 = new float[2];
    }

    public b(Context context) {
        super(context);
        this.E7 = 100;
        this.F7 = false;
        this.G7 = false;
        this.H7 = true;
        this.I7 = true;
        this.J7 = true;
        this.K7 = true;
        this.L7 = true;
        this.M7 = true;
        this.P7 = false;
        this.Q7 = false;
        this.R7 = false;
        this.S7 = 15.0f;
        this.T7 = false;
        this.f36225c8 = 0L;
        this.f36226d8 = 0L;
        this.f36227e8 = new RectF();
        this.f36228f8 = new Matrix();
        this.f36229g8 = new Matrix();
        this.f36230h8 = false;
        this.f36231i8 = new float[2];
        this.f36232j8 = xa.f.b(0.0d, 0.0d);
        this.f36233k8 = xa.f.b(0.0d, 0.0d);
        this.f36234l8 = new float[2];
    }
}
