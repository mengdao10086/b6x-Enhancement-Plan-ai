package va;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import va.c;

/* JADX INFO: loaded from: classes3.dex */
public class j extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public pa.g f52851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint f52852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WeakReference<Bitmap> f52853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Canvas f52854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Bitmap.Config f52855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Path f52856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f52857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float[] f52858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Path f52859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap<qa.e, b> f52860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float[] f52861s;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f52862a;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            f52862a = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f52862a[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f52862a[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f52862a[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public j(pa.g gVar, ha.a aVar, xa.l lVar) {
        super(aVar, lVar);
        this.f52855m = Bitmap.Config.ARGB_8888;
        this.f52856n = new Path();
        this.f52857o = new Path();
        this.f52858p = new float[4];
        this.f52859q = new Path();
        this.f52860r = new HashMap<>();
        this.f52861s = new float[2];
        this.f52851i = gVar;
        Paint paint = new Paint(1);
        this.f52852j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52852j.setColor(-1);
    }

    public void A() {
        Canvas canvas = this.f52854l;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f52854l = null;
        }
        WeakReference<Bitmap> weakReference = this.f52853k;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f52853k.clear();
            this.f52853k = null;
        }
    }

    public void B(Bitmap.Config config) {
        this.f52855m = config;
        A();
    }

    @Override // va.g
    public void b(Canvas canvas) {
        int iO = (int) this.f52889a.o();
        int iN = (int) this.f52889a.n();
        WeakReference<Bitmap> weakReference = this.f52853k;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iO || bitmapCreateBitmap.getHeight() != iN) {
            if (iO <= 0 || iN <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iO, iN, this.f52855m);
            this.f52853k = new WeakReference<>(bitmapCreateBitmap);
            this.f52854l = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (T t10 : this.f52851i.getLineData().q()) {
            if (t10.isVisible()) {
                u(canvas, t10);
            }
        }
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.f52836c);
    }

    @Override // va.g
    public void c(Canvas canvas) {
        r(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    @Override // va.g
    public void d(Canvas canvas, oa.d[] dVarArr) {
        la.m lineData = this.f52851i.getLineData();
        for (oa.d dVar : dVarArr) {
            qa.f fVar = (qa.f) lineData.k(dVar.d());
            if (fVar != null && fVar.i1()) {
                ?? Y = fVar.y(dVar.h(), dVar.j());
                if (l(Y, fVar)) {
                    xa.f fVarF = this.f52851i.a(fVar.a1()).f(Y.F(), Y.e() * this.f52835b.i());
                    dVar.n((float) fVarF.f54983c, (float) fVarF.f54984d);
                    n(canvas, (float) fVarF.f54983c, (float) fVarF.f54984d, fVar);
                }
            }
        }
    }

    @Override // va.g
    public void e(Canvas canvas, String str, float f10, float f11, int i10) {
        this.f52839f.setColor(i10);
        canvas.drawText(str, f10, f11, this.f52839f);
    }

    @Override // va.g
    public void f(Canvas canvas) {
        int i10;
        qa.f fVar;
        Entry entry;
        if (k(this.f52851i)) {
            List<T> listQ = this.f52851i.getLineData().q();
            for (int i11 = 0; i11 < listQ.size(); i11++) {
                qa.f fVar2 = (qa.f) listQ.get(i11);
                if (m(fVar2) && fVar2.e1() >= 1) {
                    a(fVar2);
                    xa.i iVarA = this.f52851i.a(fVar2.a1());
                    int iA0 = (int) (fVar2.a0() * 1.75f);
                    if (!fVar2.h1()) {
                        iA0 /= 2;
                    }
                    int i12 = iA0;
                    this.f52816g.a(this.f52851i, fVar2);
                    float fH = this.f52835b.h();
                    float fI = this.f52835b.i();
                    c.a aVar = this.f52816g;
                    float[] fArrC = iVarA.c(fVar2, fH, fI, aVar.f52817a, aVar.f52818b);
                    na.l lVarV = fVar2.V();
                    xa.g gVarD = xa.g.d(fVar2.f1());
                    gVarD.f54987c = xa.k.e(gVarD.f54987c);
                    gVarD.f54988d = xa.k.e(gVarD.f54988d);
                    int i13 = 0;
                    while (i13 < fArrC.length) {
                        float f10 = fArrC[i13];
                        float f11 = fArrC[i13 + 1];
                        if (!this.f52889a.J(f10)) {
                            break;
                        }
                        if (this.f52889a.I(f10) && this.f52889a.M(f11)) {
                            int i14 = i13 / 2;
                            Entry entryZ = fVar2.Z(this.f52816g.f52817a + i14);
                            if (fVar2.V0()) {
                                entry = entryZ;
                                i10 = i12;
                                fVar = fVar2;
                                e(canvas, lVarV.j(entryZ), f10, f11 - i12, fVar2.v0(i14));
                            } else {
                                entry = entryZ;
                                i10 = i12;
                                fVar = fVar2;
                            }
                            if (entry.b() != null && fVar.C()) {
                                Drawable drawableB = entry.b();
                                xa.k.k(canvas, drawableB, (int) (f10 + gVarD.f54987c), (int) (f11 + gVarD.f54988d), drawableB.getIntrinsicWidth(), drawableB.getIntrinsicHeight());
                            }
                        } else {
                            i10 = i12;
                            fVar = fVar2;
                        }
                        i13 += 2;
                        fVar2 = fVar;
                        i12 = i10;
                    }
                    xa.g.h(gVarD);
                }
            }
        }
    }

    @Override // va.g
    public void j() {
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public void r(Canvas canvas) {
        b bVar;
        Bitmap bitmapB;
        this.f52836c.setStyle(Paint.Style.FILL);
        float fI = this.f52835b.i();
        float[] fArr = this.f52861s;
        char c10 = 0;
        float f10 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List<T> listQ = this.f52851i.getLineData().q();
        int i10 = 0;
        while (i10 < listQ.size()) {
            qa.f fVar = (qa.f) listQ.get(i10);
            if (fVar.isVisible() && fVar.h1() && fVar.e1() != 0) {
                this.f52852j.setColor(fVar.F());
                xa.i iVarA = this.f52851i.a(fVar.a1());
                this.f52816g.a(this.f52851i, fVar);
                float fA0 = fVar.a0();
                float fK1 = fVar.k1();
                boolean z10 = fVar.r1() && fK1 < fA0 && fK1 > f10;
                boolean z11 = z10 && fVar.F() == 1122867;
                a aVar = null;
                if (this.f52860r.containsKey(fVar)) {
                    bVar = this.f52860r.get(fVar);
                } else {
                    bVar = new b(this, aVar);
                    this.f52860r.put(fVar, bVar);
                }
                if (bVar.c(fVar)) {
                    bVar.a(fVar, z10, z11);
                }
                c.a aVar2 = this.f52816g;
                int i11 = aVar2.f52819c;
                int i12 = aVar2.f52817a;
                int i13 = i11 + i12;
                while (i12 <= i13) {
                    ?? Z = fVar.Z(i12);
                    if (Z == 0) {
                        break;
                    }
                    this.f52861s[c10] = Z.F();
                    this.f52861s[1] = Z.e() * fI;
                    iVarA.o(this.f52861s);
                    if (!this.f52889a.J(this.f52861s[c10])) {
                        break;
                    }
                    if (this.f52889a.I(this.f52861s[c10]) && this.f52889a.M(this.f52861s[1]) && (bitmapB = bVar.b(i12)) != null) {
                        float[] fArr2 = this.f52861s;
                        canvas.drawBitmap(bitmapB, fArr2[c10] - fA0, fArr2[1] - fA0, (Paint) null);
                    }
                    i12++;
                    c10 = 0;
                }
            }
            i10++;
            c10 = 0;
            f10 = 0.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public void s(qa.f fVar) {
        float fI = this.f52835b.i();
        xa.i iVarA = this.f52851i.a(fVar.a1());
        this.f52816g.a(this.f52851i, fVar);
        float fN = fVar.N();
        this.f52856n.reset();
        c.a aVar = this.f52816g;
        if (aVar.f52819c >= 1) {
            int i10 = aVar.f52817a + 1;
            Object objZ = fVar.Z(Math.max(i10 - 2, 0));
            ?? Z = fVar.Z(Math.max(i10 - 1, 0));
            int i11 = -1;
            if (Z != 0) {
                this.f52856n.moveTo(Z.F(), Z.e() * fI);
                int i12 = this.f52816g.f52817a + 1;
                ?? r42 = Z;
                ?? r22 = Z;
                ?? r32 = objZ;
                while (true) {
                    c.a aVar2 = this.f52816g;
                    ?? Z2 = r22;
                    if (i12 > aVar2.f52819c + aVar2.f52817a) {
                        break;
                    }
                    if (i11 != i12) {
                        Z2 = fVar.Z(i12);
                    }
                    int i13 = i12 + 1;
                    if (i13 < fVar.e1()) {
                        i12 = i13;
                    }
                    ?? Z3 = fVar.Z(i12);
                    this.f52856n.cubicTo(r42.F() + ((Z2.F() - r32.F()) * fN), (r42.e() + ((Z2.e() - r32.e()) * fN)) * fI, Z2.F() - ((Z3.F() - r42.F()) * fN), (Z2.e() - ((Z3.e() - r42.e()) * fN)) * fI, Z2.F(), Z2.e() * fI);
                    r32 = r42;
                    r42 = Z2;
                    r22 = Z3;
                    int i14 = i12;
                    i12 = i13;
                    i11 = i14;
                }
            } else {
                return;
            }
        }
        if (fVar.b0()) {
            this.f52857o.reset();
            this.f52857o.addPath(this.f52856n);
            t(this.f52854l, fVar, this.f52857o, iVarA, this.f52816g);
        }
        this.f52836c.setColor(fVar.g1());
        this.f52836c.setStyle(Paint.Style.STROKE);
        iVarA.l(this.f52856n);
        this.f52854l.drawPath(this.f52856n, this.f52836c);
        this.f52836c.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    public void t(Canvas canvas, qa.f fVar, Path path, xa.i iVar, c.a aVar) {
        float fA = fVar.p().a(fVar, this.f52851i);
        path.lineTo(fVar.Z(aVar.f52817a + aVar.f52819c).F(), fA);
        path.lineTo(fVar.Z(aVar.f52817a).F(), fA);
        path.close();
        iVar.l(path);
        Drawable drawableS = fVar.S();
        if (drawableS != null) {
            q(canvas, path, drawableS);
        } else {
            p(canvas, path, fVar.h(), fVar.m());
        }
    }

    public void u(Canvas canvas, qa.f fVar) {
        if (fVar.e1() < 1) {
            return;
        }
        this.f52836c.setStrokeWidth(fVar.v());
        this.f52836c.setPathEffect(fVar.Q());
        int i10 = a.f52862a[fVar.e0().ordinal()];
        if (i10 == 3) {
            s(fVar);
        } else if (i10 != 4) {
            w(canvas, fVar);
        } else {
            v(fVar);
        }
        this.f52836c.setPathEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public void v(qa.f fVar) {
        float fI = this.f52835b.i();
        xa.i iVarA = this.f52851i.a(fVar.a1());
        this.f52816g.a(this.f52851i, fVar);
        this.f52856n.reset();
        c.a aVar = this.f52816g;
        if (aVar.f52819c >= 1) {
            ?? Z = fVar.Z(aVar.f52817a);
            this.f52856n.moveTo(Z.F(), Z.e() * fI);
            int i10 = this.f52816g.f52817a + 1;
            ?? r22 = Z;
            while (true) {
                c.a aVar2 = this.f52816g;
                if (i10 > aVar2.f52819c + aVar2.f52817a) {
                    break;
                }
                ?? Z2 = fVar.Z(i10);
                float F = r22.F() + ((Z2.F() - r22.F()) / 2.0f);
                this.f52856n.cubicTo(F, r22.e() * fI, F, Z2.e() * fI, Z2.F(), Z2.e() * fI);
                i10++;
                r22 = Z2;
            }
        }
        if (fVar.b0()) {
            this.f52857o.reset();
            this.f52857o.addPath(this.f52856n);
            t(this.f52854l, fVar, this.f52857o, iVarA, this.f52816g);
        }
        this.f52836c.setColor(fVar.g1());
        this.f52836c.setStyle(Paint.Style.STROKE);
        iVarA.l(this.f52856n);
        this.f52854l.drawPath(this.f52856n, this.f52836c);
        this.f52836c.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public void w(Canvas canvas, qa.f fVar) {
        int iE1 = fVar.e1();
        boolean z10 = fVar.e0() == LineDataSet.Mode.STEPPED;
        int i10 = z10 ? 4 : 2;
        xa.i iVarA = this.f52851i.a(fVar.a1());
        float fI = this.f52835b.i();
        this.f52836c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = fVar.B() ? this.f52854l : canvas;
        this.f52816g.a(this.f52851i, fVar);
        if (fVar.b0() && iE1 > 0) {
            x(canvas, fVar, iVarA, this.f52816g);
        }
        if (fVar.C0().size() > 1) {
            int i11 = i10 * 2;
            if (this.f52858p.length <= i11) {
                this.f52858p = new float[i10 * 4];
            }
            int i12 = this.f52816g.f52817a;
            while (true) {
                c.a aVar = this.f52816g;
                if (i12 > aVar.f52819c + aVar.f52817a) {
                    break;
                }
                ?? Z = fVar.Z(i12);
                if (Z != 0) {
                    this.f52858p[0] = Z.F();
                    this.f52858p[1] = Z.e() * fI;
                    if (i12 < this.f52816g.f52818b) {
                        ?? Z2 = fVar.Z(i12 + 1);
                        if (Z2 == 0) {
                            break;
                        }
                        if (z10) {
                            this.f52858p[2] = Z2.F();
                            float[] fArr = this.f52858p;
                            fArr[3] = fArr[1];
                            fArr[4] = fArr[2];
                            fArr[5] = fArr[3];
                            fArr[6] = Z2.F();
                            this.f52858p[7] = Z2.e() * fI;
                        } else {
                            this.f52858p[2] = Z2.F();
                            this.f52858p[3] = Z2.e() * fI;
                        }
                    } else {
                        float[] fArr2 = this.f52858p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    iVarA.o(this.f52858p);
                    if (!this.f52889a.J(this.f52858p[0])) {
                        break;
                    }
                    if (this.f52889a.I(this.f52858p[2]) && (this.f52889a.K(this.f52858p[1]) || this.f52889a.H(this.f52858p[3]))) {
                        this.f52836c.setColor(fVar.f0(i12));
                        canvas2.drawLines(this.f52858p, 0, i11, this.f52836c);
                    }
                }
                i12++;
            }
        } else {
            int i13 = iE1 * i10;
            if (this.f52858p.length < Math.max(i13, i10) * 2) {
                this.f52858p = new float[Math.max(i13, i10) * 4];
            }
            if (fVar.Z(this.f52816g.f52817a) != 0) {
                int i14 = this.f52816g.f52817a;
                int i15 = 0;
                while (true) {
                    c.a aVar2 = this.f52816g;
                    if (i14 > aVar2.f52819c + aVar2.f52817a) {
                        break;
                    }
                    ?? Z3 = fVar.Z(i14 == 0 ? 0 : i14 - 1);
                    ?? Z4 = fVar.Z(i14);
                    if (Z3 != 0 && Z4 != 0) {
                        int i16 = i15 + 1;
                        this.f52858p[i15] = Z3.F();
                        int i17 = i16 + 1;
                        this.f52858p[i16] = Z3.e() * fI;
                        if (z10) {
                            int i18 = i17 + 1;
                            this.f52858p[i17] = Z4.F();
                            int i19 = i18 + 1;
                            this.f52858p[i18] = Z3.e() * fI;
                            int i20 = i19 + 1;
                            this.f52858p[i19] = Z4.F();
                            i17 = i20 + 1;
                            this.f52858p[i20] = Z3.e() * fI;
                        }
                        int i21 = i17 + 1;
                        this.f52858p[i17] = Z4.F();
                        this.f52858p[i21] = Z4.e() * fI;
                        i15 = i21 + 1;
                    }
                    i14++;
                }
                if (i15 > 0) {
                    iVarA.o(this.f52858p);
                    int iMax = Math.max((this.f52816g.f52819c + 1) * i10, i10) * 2;
                    this.f52836c.setColor(fVar.g1());
                    canvas2.drawLines(this.f52858p, 0, iMax, this.f52836c);
                }
            }
        }
        this.f52836c.setPathEffect(null);
    }

    public void x(Canvas canvas, qa.f fVar, xa.i iVar, c.a aVar) {
        int i10;
        int i11;
        Path path = this.f52859q;
        int i12 = aVar.f52817a;
        int i13 = aVar.f52819c + i12;
        int i14 = 0;
        do {
            i10 = (i14 * 128) + i12;
            i11 = i10 + 128;
            if (i11 > i13) {
                i11 = i13;
            }
            if (i10 <= i11) {
                y(fVar, i10, i11, path);
                iVar.l(path);
                Drawable drawableS = fVar.S();
                if (drawableS != null) {
                    q(canvas, path, drawableS);
                } else {
                    p(canvas, path, fVar.h(), fVar.m());
                }
            }
            i14++;
        } while (i10 <= i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r3v2, types: [la.f] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.github.mikephil.charting.data.Entry, la.f] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final void y(qa.f fVar, int i10, int i11, Path path) {
        float fA = fVar.p().a(fVar, this.f52851i);
        float fI = this.f52835b.i();
        boolean z10 = fVar.e0() == LineDataSet.Mode.STEPPED;
        path.reset();
        ?? Z = fVar.Z(i10);
        path.moveTo(Z.F(), fA);
        path.lineTo(Z.F(), Z.e() * fI);
        ?? r52 = 0;
        int i12 = i10 + 1;
        ?? r32 = Z;
        while (i12 <= i11) {
            ?? Z2 = fVar.Z(i12);
            if (z10) {
                path.lineTo(Z2.F(), r32.e() * fI);
            }
            path.lineTo(Z2.F(), Z2.e() * fI);
            i12++;
            r32 = Z2;
            r52 = Z2;
        }
        if (r52 != 0) {
            path.lineTo(r52.F(), fA);
        }
        path.close();
    }

    public Bitmap.Config z() {
        return this.f52855m;
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Path f52863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap[] f52864b;

        public b() {
            this.f52863a = new Path();
        }

        public void a(qa.f fVar, boolean z10, boolean z11) {
            int iG = fVar.g();
            float fA0 = fVar.a0();
            float fK1 = fVar.k1();
            for (int i10 = 0; i10 < iG; i10++) {
                int i11 = (int) (((double) fA0) * 2.1d);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, i11, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                this.f52864b[i10] = bitmapCreateBitmap;
                j.this.f52836c.setColor(fVar.Z0(i10));
                if (z11) {
                    this.f52863a.reset();
                    this.f52863a.addCircle(fA0, fA0, fA0, Path.Direction.CW);
                    this.f52863a.addCircle(fA0, fA0, fK1, Path.Direction.CCW);
                    canvas.drawPath(this.f52863a, j.this.f52836c);
                } else {
                    canvas.drawCircle(fA0, fA0, fA0, j.this.f52836c);
                    if (z10) {
                        canvas.drawCircle(fA0, fA0, fK1, j.this.f52852j);
                    }
                }
            }
        }

        public Bitmap b(int i10) {
            Bitmap[] bitmapArr = this.f52864b;
            return bitmapArr[i10 % bitmapArr.length];
        }

        public boolean c(qa.f fVar) {
            int iG = fVar.g();
            Bitmap[] bitmapArr = this.f52864b;
            if (bitmapArr == null) {
                this.f52864b = new Bitmap[iG];
                return true;
            }
            if (bitmapArr.length == iG) {
                return false;
            }
            this.f52864b = new Bitmap[iG];
            return true;
        }

        public /* synthetic */ b(j jVar, a aVar) {
            this();
        }
    }
}
