package ja;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import g.v0;
import ha.b;
import hd.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import la.k;
import rb.a0;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<T extends k<? extends qa.e<? extends Entry>>> extends ViewGroup implements pa.e {
    public static final int C1 = 7;
    public static final int C2 = 14;
    public static final int K1 = 11;
    public static final int K2 = 18;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final String f36243k1 = "MPAndroidChart";

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f36244v1 = 4;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f36245v2 = 13;
    public oa.d[] A;
    public float B;
    public boolean C;
    public ka.d D;
    public boolean K0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f36246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f36247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f36250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public na.d f36251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f36252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f36253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public XAxis f36254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f36255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ka.c f36256k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public ArrayList<Runnable> f36257k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Legend f36258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public sa.a f36259m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChartTouchListener f36260n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f36261o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.github.mikephil.charting.listener.b f36262p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public va.i f36263q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public va.g f36264r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public oa.f f36265s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l f36266t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ha.a f36267u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f36268v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f36269w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f36270x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f36271y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f36272z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.postInvalidate();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36274a;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            f36274a = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36274a[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36274a[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(Context context) {
        super(context);
        this.f36246a = false;
        this.f36247b = null;
        this.f36248c = true;
        this.f36249d = true;
        this.f36250e = 0.9f;
        this.f36251f = new na.d(0);
        this.f36255j = true;
        this.f36261o = "No chart data available.";
        this.f36266t = new l();
        this.f36268v = 0.0f;
        this.f36269w = 0.0f;
        this.f36270x = 0.0f;
        this.f36271y = 0.0f;
        this.f36272z = false;
        this.B = 0.0f;
        this.C = true;
        this.f36257k0 = new ArrayList<>();
        this.K0 = false;
        H();
    }

    public void A(float f10, float f11, int i10) {
        B(f10, f11, i10, true);
    }

    public void B(float f10, float f11, int i10, boolean z10) {
        if (i10 < 0 || i10 >= this.f36247b.m()) {
            F(null, z10);
        } else {
            F(new oa.d(f10, f11, i10), z10);
        }
    }

    public void C(float f10, int i10) {
        D(f10, i10, true);
    }

    public void D(float f10, int i10, boolean z10) {
        B(f10, Float.NaN, i10, z10);
    }

    public void E(oa.d dVar) {
        F(dVar, false);
    }

    public void F(oa.d dVar, boolean z10) {
        Entry entry = null;
        if (dVar == null) {
            this.A = null;
        } else {
            if (this.f36246a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Highlighted: ");
                sb2.append(dVar.toString());
            }
            Entry entryS = this.f36247b.s(dVar);
            if (entryS == null) {
                this.A = null;
                dVar = null;
            } else {
                this.A = new oa.d[]{dVar};
            }
            entry = entryS;
        }
        setLastHighlighted(this.A);
        if (z10 && this.f36259m != null) {
            if (Y()) {
                this.f36259m.a(entry, dVar);
            } else {
                this.f36259m.b();
            }
        }
        invalidate();
    }

    public void G(oa.d[] dVarArr) {
        this.A = dVarArr;
        setLastHighlighted(dVarArr);
        invalidate();
    }

    public void H() {
        setWillNotDraw(false);
        this.f36267u = new ha.a(new a());
        xa.k.H(getContext());
        this.B = xa.k.e(500.0f);
        this.f36256k = new ka.c();
        Legend legend = new Legend();
        this.f36258l = legend;
        this.f36263q = new va.i(this.f36266t, legend);
        this.f36254i = new XAxis();
        this.f36252g = new Paint(1);
        Paint paint = new Paint(1);
        this.f36253h = paint;
        paint.setColor(Color.rgb(247, a0.f47918w, 51));
        this.f36253h.setTextAlign(Paint.Align.CENTER);
        this.f36253h.setTextSize(xa.k.e(12.0f));
    }

    public boolean I() {
        return this.f36249d;
    }

    @Deprecated
    public boolean J() {
        return K();
    }

    public boolean K() {
        return this.C;
    }

    public boolean L() {
        T t10 = this.f36247b;
        return t10 == null || t10.r() <= 0;
    }

    public boolean M() {
        return this.f36248c;
    }

    public boolean N() {
        return this.f36246a;
    }

    public abstract void O();

    public void P(Runnable runnable) {
        this.f36257k0.remove(runnable);
    }

    public boolean Q(String str) {
        return S(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public boolean R(String str, int i10) {
        return S(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i10);
    }

    public boolean S(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i10) {
        if (i10 < 0 || i10 > 100) {
            i10 = 50;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i11 = b.f36274a[compressFormat.ordinal()];
        String str4 = "image/png";
        if (i11 != 1) {
            if (i11 != 2) {
                if (!str.endsWith(hd.k.S) && !str.endsWith(hd.k.T)) {
                    str = str + hd.k.S;
                }
                str4 = w.C0;
            } else {
                if (!str.endsWith(".webp")) {
                    str = str + ".webp";
                }
                str4 = "image/webp";
            }
        } else if (!str.endsWith(".png")) {
            str = str + ".png";
        }
        String str5 = file.getAbsolutePath() + fh.a.f28350w + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i10, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
            contentValues.put(com.google.android.exoplayer2.offline.b.f17433i, str4);
            contentValues.put("description", str3);
            contentValues.put("orientation", (Integer) 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public boolean T(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + fh.a.f28350w + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public void U(float f10, float f11, float f12, float f13) {
        setExtraLeftOffset(f10);
        setExtraTopOffset(f11);
        setExtraRightOffset(f12);
        setExtraBottomOffset(f13);
    }

    public void V(Paint paint, int i10) {
        if (i10 == 7) {
            this.f36253h = paint;
        } else {
            if (i10 != 11) {
                return;
            }
            this.f36252g = paint;
        }
    }

    public void W(float f10, float f11) {
        T t10 = this.f36247b;
        this.f36251f.m(xa.k.r((t10 == null || t10.r() < 2) ? Math.max(Math.abs(f10), Math.abs(f11)) : Math.abs(f11 - f10)));
    }

    public final void X(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i10 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i10 >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                X(viewGroup.getChildAt(i10));
                i10++;
            }
        }
    }

    public boolean Y() {
        oa.d[] dVarArr = this.A;
        return (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) ? false : true;
    }

    public void g(Runnable runnable) {
        if (this.f36266t.B()) {
            post(runnable);
        } else {
            this.f36257k0.add(runnable);
        }
    }

    public ha.a getAnimator() {
        return this.f36267u;
    }

    public xa.g getCenter() {
        return xa.g.c(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // pa.e
    public xa.g getCenterOfView() {
        return getCenter();
    }

    @Override // pa.e
    public xa.g getCenterOffsets() {
        return this.f36266t.p();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // pa.e
    public RectF getContentRect() {
        return this.f36266t.q();
    }

    public T getData() {
        return this.f36247b;
    }

    @Override // pa.e
    public na.l getDefaultValueFormatter() {
        return this.f36251f;
    }

    public ka.c getDescription() {
        return this.f36256k;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f36250e;
    }

    public float getExtraBottomOffset() {
        return this.f36270x;
    }

    public float getExtraLeftOffset() {
        return this.f36271y;
    }

    public float getExtraRightOffset() {
        return this.f36269w;
    }

    public float getExtraTopOffset() {
        return this.f36268v;
    }

    public oa.d[] getHighlighted() {
        return this.A;
    }

    public oa.f getHighlighter() {
        return this.f36265s;
    }

    public ArrayList<Runnable> getJobs() {
        return this.f36257k0;
    }

    public Legend getLegend() {
        return this.f36258l;
    }

    public va.i getLegendRenderer() {
        return this.f36263q;
    }

    public ka.d getMarker() {
        return this.D;
    }

    @Deprecated
    public ka.d getMarkerView() {
        return getMarker();
    }

    @Override // pa.e
    public float getMaxHighlightDistance() {
        return this.B;
    }

    public com.github.mikephil.charting.listener.b getOnChartGestureListener() {
        return this.f36262p;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.f36260n;
    }

    public va.g getRenderer() {
        return this.f36264r;
    }

    public l getViewPortHandler() {
        return this.f36266t;
    }

    public XAxis getXAxis() {
        return this.f36254i;
    }

    @Override // pa.e
    public float getXChartMax() {
        return this.f36254i.G;
    }

    @Override // pa.e
    public float getXChartMin() {
        return this.f36254i.H;
    }

    @Override // pa.e
    public float getXRange() {
        return this.f36254i.I;
    }

    public float getYMax() {
        return this.f36247b.z();
    }

    public float getYMin() {
        return this.f36247b.B();
    }

    @v0(11)
    public void h(int i10) {
        this.f36267u.a(i10);
    }

    @v0(11)
    public void i(int i10, b.c0 c0Var) {
        this.f36267u.b(i10, c0Var);
    }

    @v0(11)
    public void j(int i10, int i11) {
        this.f36267u.c(i10, i11);
    }

    @v0(11)
    public void k(int i10, int i11, b.c0 c0Var) {
        this.f36267u.d(i10, i11, c0Var);
    }

    @v0(11)
    public void l(int i10, int i11, b.c0 c0Var, b.c0 c0Var2) {
        this.f36267u.e(i10, i11, c0Var, c0Var2);
    }

    @v0(11)
    public void m(int i10) {
        this.f36267u.f(i10);
    }

    @v0(11)
    public void n(int i10, b.c0 c0Var) {
        this.f36267u.g(i10, c0Var);
    }

    public abstract void o();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.K0) {
            X(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f36247b == null) {
            if (!TextUtils.isEmpty(this.f36261o)) {
                xa.g center = getCenter();
                canvas.drawText(this.f36261o, center.f54987c, center.f54988d, this.f36253h);
                return;
            }
            return;
        }
        if (this.f36272z) {
            return;
        }
        p();
        this.f36272z = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            getChildAt(i14).layout(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int iE = (int) xa.k.e(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(iE, i10)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(iE, i11)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        if (i10 > 0 && i11 > 0 && i10 < 10000 && i11 < 10000) {
            if (this.f36246a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting chart dimens, width: ");
                sb2.append(i10);
                sb2.append(", height: ");
                sb2.append(i11);
            }
            this.f36266t.V(i10, i11);
        } else if (this.f36246a) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("*Avoiding* setting chart dimens! width: ");
            sb3.append(i10);
            sb3.append(", height: ");
            sb3.append(i11);
        }
        O();
        Iterator<Runnable> it2 = this.f36257k0.iterator();
        while (it2.hasNext()) {
            post(it2.next());
        }
        this.f36257k0.clear();
        super.onSizeChanged(i10, i11, i12, i13);
    }

    public abstract void p();

    public void q() {
        this.f36247b = null;
        this.f36272z = false;
        this.A = null;
        this.f36260n.f(null);
        invalidate();
    }

    public void r() {
        this.f36257k0.clear();
    }

    public void s() {
        this.f36247b.h();
        invalidate();
    }

    public void setData(T t10) {
        this.f36247b = t10;
        this.f36272z = false;
        if (t10 == null) {
            return;
        }
        W(t10.B(), t10.z());
        for (qa.e eVar : this.f36247b.q()) {
            if (eVar.o0() || eVar.V() == this.f36251f) {
                eVar.I(this.f36251f);
            }
        }
        O();
    }

    public void setDescription(ka.c cVar) {
        this.f36256k = cVar;
    }

    public void setDragDecelerationEnabled(boolean z10) {
        this.f36249d = z10;
    }

    public void setDragDecelerationFrictionCoef(float f10) {
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 >= 1.0f) {
            f10 = 0.999f;
        }
        this.f36250e = f10;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z10) {
        setDrawMarkers(z10);
    }

    public void setDrawMarkers(boolean z10) {
        this.C = z10;
    }

    public void setExtraBottomOffset(float f10) {
        this.f36270x = xa.k.e(f10);
    }

    public void setExtraLeftOffset(float f10) {
        this.f36271y = xa.k.e(f10);
    }

    public void setExtraRightOffset(float f10) {
        this.f36269w = xa.k.e(f10);
    }

    public void setExtraTopOffset(float f10) {
        this.f36268v = xa.k.e(f10);
    }

    public void setHardwareAccelerationEnabled(boolean z10) {
        if (z10) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z10) {
        this.f36248c = z10;
    }

    public void setHighlighter(oa.b bVar) {
        this.f36265s = bVar;
    }

    public void setLastHighlighted(oa.d[] dVarArr) {
        if (dVarArr == null || dVarArr.length <= 0 || dVarArr[0] == null) {
            this.f36260n.f(null);
        } else {
            this.f36260n.f(dVarArr[0]);
        }
    }

    public void setLogEnabled(boolean z10) {
        this.f36246a = z10;
    }

    public void setMarker(ka.d dVar) {
        this.D = dVar;
    }

    @Deprecated
    public void setMarkerView(ka.d dVar) {
        setMarker(dVar);
    }

    public void setMaxHighlightDistance(float f10) {
        this.B = xa.k.e(f10);
    }

    public void setNoDataText(String str) {
        this.f36261o = str;
    }

    public void setNoDataTextColor(int i10) {
        this.f36253h.setColor(i10);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f36253h.setTypeface(typeface);
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.b bVar) {
        this.f36262p = bVar;
    }

    public void setOnChartValueSelectedListener(sa.a aVar) {
        this.f36259m = aVar;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.f36260n = chartTouchListener;
    }

    public void setRenderer(va.g gVar) {
        if (gVar != null) {
            this.f36264r = gVar;
        }
    }

    public void setTouchEnabled(boolean z10) {
        this.f36255j = z10;
    }

    public void setUnbindEnabled(boolean z10) {
        this.K0 = z10;
    }

    public void t() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void u(Canvas canvas) {
        float height;
        float width;
        ka.c cVar = this.f36256k;
        if (cVar == null || !cVar.f()) {
            return;
        }
        xa.g gVarM = this.f36256k.m();
        this.f36252g.setTypeface(this.f36256k.c());
        this.f36252g.setTextSize(this.f36256k.b());
        this.f36252g.setColor(this.f36256k.a());
        this.f36252g.setTextAlign(this.f36256k.o());
        if (gVarM == null) {
            width = (getWidth() - this.f36266t.Q()) - this.f36256k.d();
            height = (getHeight() - this.f36266t.O()) - this.f36256k.e();
        } else {
            float f10 = gVarM.f54987c;
            height = gVarM.f54988d;
            width = f10;
        }
        canvas.drawText(this.f36256k.n(), width, height, this.f36252g);
    }

    public void v(Canvas canvas) {
        if (this.D == null || !K() || !Y()) {
            return;
        }
        int i10 = 0;
        while (true) {
            oa.d[] dVarArr = this.A;
            if (i10 >= dVarArr.length) {
                return;
            }
            oa.d dVar = dVarArr[i10];
            qa.e eVarK = this.f36247b.k(dVar.d());
            Entry entryS = this.f36247b.s(this.A[i10]);
            int iT = eVarK.t(entryS);
            if (entryS != null && iT <= eVarK.e1() * this.f36267u.h()) {
                float[] fArrY = y(dVar);
                if (this.f36266t.G(fArrY[0], fArrY[1])) {
                    this.D.c(entryS, dVar);
                    this.D.a(canvas, fArrY[0], fArrY[1]);
                }
            }
            i10++;
        }
    }

    public void w() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public oa.d x(float f10, float f11) {
        if (this.f36247b == null) {
            return null;
        }
        return getHighlighter().a(f10, f11);
    }

    public float[] y(oa.d dVar) {
        return new float[]{dVar.e(), dVar.f()};
    }

    public Paint z(int i10) {
        if (i10 == 7) {
            return this.f36253h;
        }
        if (i10 != 11) {
            return null;
        }
        return this.f36252g;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36246a = false;
        this.f36247b = null;
        this.f36248c = true;
        this.f36249d = true;
        this.f36250e = 0.9f;
        this.f36251f = new na.d(0);
        this.f36255j = true;
        this.f36261o = "No chart data available.";
        this.f36266t = new l();
        this.f36268v = 0.0f;
        this.f36269w = 0.0f;
        this.f36270x = 0.0f;
        this.f36271y = 0.0f;
        this.f36272z = false;
        this.B = 0.0f;
        this.C = true;
        this.f36257k0 = new ArrayList<>();
        this.K0 = false;
        H();
    }

    public e(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36246a = false;
        this.f36247b = null;
        this.f36248c = true;
        this.f36249d = true;
        this.f36250e = 0.9f;
        this.f36251f = new na.d(0);
        this.f36255j = true;
        this.f36261o = "No chart data available.";
        this.f36266t = new l();
        this.f36268v = 0.0f;
        this.f36269w = 0.0f;
        this.f36270x = 0.0f;
        this.f36271y = 0.0f;
        this.f36272z = false;
        this.B = 0.0f;
        this.C = true;
        this.f36257k0 = new ArrayList<>();
        this.K0 = false;
        H();
    }
}
