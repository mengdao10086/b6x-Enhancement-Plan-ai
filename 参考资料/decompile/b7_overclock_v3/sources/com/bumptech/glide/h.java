package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import g.n0;
import g.p0;
import g.u0;
import g.v;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import s4.m;
import s4.p;
import s4.r;
import v4.o;

/* JADX INFO: loaded from: classes2.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable, g<h<TranscodeType>> {

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final com.bumptech.glide.request.h f12139a8 = new com.bumptech.glide.request.h().q(com.bumptech.glide.load.engine.h.f12380c).G0(Priority.LOW).O0(true);
    public final Context M7;
    public final i N7;
    public final Class<TranscodeType> O7;
    public final b P7;
    public final d Q7;

    @n0
    public j<?, ? super TranscodeType> R7;

    @p0
    public Object S7;

    @p0
    public List<com.bumptech.glide.request.g<TranscodeType>> T7;

    @p0
    public h<TranscodeType> U7;

    @p0
    public h<TranscodeType> V7;

    @p0
    public Float W7;
    public boolean X7;
    public boolean Y7;
    public boolean Z7;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12141b;

        static {
            int[] iArr = new int[Priority.values().length];
            f12141b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12141b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12141b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12141b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f12140a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12140a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12140a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12140a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12140a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12140a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12140a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f12140a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public h(@n0 b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.X7 = true;
        this.P7 = bVar;
        this.N7 = iVar;
        this.O7 = cls;
        this.M7 = context;
        this.R7 = iVar.H(cls);
        this.Q7 = bVar.k();
        n1(iVar.F());
        a(iVar.G());
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: A1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> o(@p0 Object obj) {
        return E1(obj);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> t(@p0 String str) {
        return E1(str);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @Deprecated
    /* JADX INFO: renamed from: C1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> d(@p0 URL url) {
        return E1(url);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: D1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> h(@p0 byte[] bArr) {
        h<TranscodeType> hVarE1 = E1(bArr);
        if (!hVarE1.g0()) {
            hVarE1 = hVarE1.a(com.bumptech.glide.request.h.f1(com.bumptech.glide.load.engine.h.f12379b));
        }
        return !hVarE1.n0() ? hVarE1.a(com.bumptech.glide.request.h.y1(true)) : hVarE1;
    }

    @n0
    public final h<TranscodeType> E1(@p0 Object obj) {
        if (f0()) {
            return clone().E1(obj);
        }
        this.S7 = obj;
        this.Y7 = true;
        return K0();
    }

    public final com.bumptech.glide.request.e F1(Object obj, p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, Executor executor) {
        Context context = this.M7;
        d dVar = this.Q7;
        return SingleRequest.x(context, dVar, obj, this.S7, this.O7, aVar, i10, i11, priority, pVar, gVar, this.T7, requestCoordinator, dVar.f(), jVar.c(), executor);
    }

    @n0
    public p<TranscodeType> G1() {
        return H1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @n0
    public p<TranscodeType> H1(int i10, int i11) {
        return p1(m.e(this.N7, i10, i11));
    }

    @n0
    public com.bumptech.glide.request.d<TranscodeType> I1() {
        return J1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @n0
    public com.bumptech.glide.request.d<TranscodeType> J1(int i10, int i11) {
        com.bumptech.glide.request.f fVar = new com.bumptech.glide.request.f(i10, i11);
        return (com.bumptech.glide.request.d) r1(fVar, fVar, v4.f.a());
    }

    @g.j
    @n0
    @Deprecated
    public h<TranscodeType> K1(float f10) {
        if (f0()) {
            return clone().K1(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.W7 = Float.valueOf(f10);
        return K0();
    }

    @g.j
    @n0
    public h<TranscodeType> L1(@p0 h<TranscodeType> hVar) {
        if (f0()) {
            return clone().L1(hVar);
        }
        this.U7 = hVar;
        return K0();
    }

    @g.j
    @n0
    public h<TranscodeType> M1(@p0 List<h<TranscodeType>> list) {
        h<TranscodeType> hVarL1 = null;
        if (list == null || list.isEmpty()) {
            return L1(null);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            h<TranscodeType> hVar = list.get(size);
            if (hVar != null) {
                hVarL1 = hVarL1 == null ? hVar : hVar.L1(hVarL1);
            }
        }
        return L1(hVarL1);
    }

    @g.j
    @n0
    public h<TranscodeType> N1(@p0 h<TranscodeType>... hVarArr) {
        return (hVarArr == null || hVarArr.length == 0) ? L1(null) : M1(Arrays.asList(hVarArr));
    }

    @g.j
    @n0
    public h<TranscodeType> O1(@n0 j<?, ? super TranscodeType> jVar) {
        if (f0()) {
            return clone().O1(jVar);
        }
        this.R7 = (j) v4.m.d(jVar);
        this.X7 = false;
        return K0();
    }

    @g.j
    @n0
    public h<TranscodeType> a1(@p0 com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (f0()) {
            return clone().a1(gVar);
        }
        if (gVar != null) {
            if (this.T7 == null) {
                this.T7 = new ArrayList();
            }
            this.T7.add(gVar);
        }
        return K0();
    }

    @Override // com.bumptech.glide.request.a
    @g.j
    @n0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> a(@n0 com.bumptech.glide.request.a<?> aVar) {
        v4.m.d(aVar);
        return (h) super.a(aVar);
    }

    public final com.bumptech.glide.request.e c1(p<TranscodeType> pVar, @p0 com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return d1(new Object(), pVar, gVar, null, this.R7, aVar.R(), aVar.O(), aVar.N(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.bumptech.glide.request.e d1(Object obj, p<TranscodeType> pVar, @p0 com.bumptech.glide.request.g<TranscodeType> gVar, @p0 RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator bVar;
        if (this.V7 != null) {
            bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = bVar;
        } else {
            requestCoordinator2 = null;
            bVar = requestCoordinator;
        }
        com.bumptech.glide.request.e eVarE1 = e1(obj, pVar, gVar, bVar, jVar, priority, i10, i11, aVar, executor);
        if (requestCoordinator2 == null) {
            return eVarE1;
        }
        int iO = this.V7.O();
        int iN = this.V7.N();
        if (o.w(i10, i11) && !this.V7.r0()) {
            iO = aVar.O();
            iN = aVar.N();
        }
        h<TranscodeType> hVar = this.V7;
        com.bumptech.glide.request.b bVar2 = requestCoordinator2;
        bVar2.n(eVarE1, hVar.d1(obj, pVar, gVar, bVar2, hVar.R7, hVar.R(), iO, iN, this.V7, executor));
        return bVar2;
    }

    public final com.bumptech.glide.request.e e1(Object obj, p<TranscodeType> pVar, com.bumptech.glide.request.g<TranscodeType> gVar, @p0 RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        h<TranscodeType> hVar = this.U7;
        if (hVar == null) {
            if (this.W7 == null) {
                return F1(obj, pVar, gVar, aVar, requestCoordinator, jVar, priority, i10, i11, executor);
            }
            com.bumptech.glide.request.j jVar2 = new com.bumptech.glide.request.j(obj, requestCoordinator);
            jVar2.m(F1(obj, pVar, gVar, aVar, jVar2, jVar, priority, i10, i11, executor), F1(obj, pVar, gVar, aVar.l().N0(this.W7.floatValue()), jVar2, jVar, m1(priority), i10, i11, executor));
            return jVar2;
        }
        if (this.Z7) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        j<?, ? super TranscodeType> jVar3 = hVar.X7 ? jVar : hVar.R7;
        Priority priorityR = hVar.j0() ? this.U7.R() : m1(priority);
        int iO = this.U7.O();
        int iN = this.U7.N();
        if (o.w(i10, i11) && !this.U7.r0()) {
            iO = aVar.O();
            iN = aVar.N();
        }
        com.bumptech.glide.request.j jVar4 = new com.bumptech.glide.request.j(obj, requestCoordinator);
        com.bumptech.glide.request.e eVarF1 = F1(obj, pVar, gVar, aVar, jVar4, jVar, priority, i10, i11, executor);
        this.Z7 = true;
        h<TranscodeType> hVar2 = this.U7;
        com.bumptech.glide.request.e eVarD1 = hVar2.d1(obj, pVar, gVar, jVar4, jVar3, priorityR, iO, iN, hVar2, executor);
        this.Z7 = false;
        jVar4.m(eVarF1, eVarD1);
        return jVar4;
    }

    @Override // com.bumptech.glide.request.a
    @g.j
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public h<TranscodeType> l() {
        h<TranscodeType> hVar = (h) super.l();
        hVar.R7 = hVar.R7.clone();
        if (hVar.T7 != null) {
            hVar.T7 = new ArrayList(hVar.T7);
        }
        h<TranscodeType> hVar2 = hVar.U7;
        if (hVar2 != null) {
            hVar.U7 = hVar2.clone();
        }
        h<TranscodeType> hVar3 = hVar.V7;
        if (hVar3 != null) {
            hVar.V7 = hVar3.clone();
        }
        return hVar;
    }

    public final h<TranscodeType> g1() {
        return clone().j1(null).L1(null);
    }

    @g.j
    @Deprecated
    public com.bumptech.glide.request.d<File> h1(int i10, int i11) {
        return l1().J1(i10, i11);
    }

    @g.j
    @Deprecated
    public <Y extends p<File>> Y i1(@n0 Y y10) {
        return (Y) l1().p1(y10);
    }

    @n0
    public h<TranscodeType> j1(@p0 h<TranscodeType> hVar) {
        if (f0()) {
            return clone().j1(hVar);
        }
        this.V7 = hVar;
        return K0();
    }

    @g.j
    @n0
    public h<TranscodeType> k1(Object obj) {
        return obj == null ? j1(null) : j1(g1().o(obj));
    }

    @g.j
    @n0
    public h<File> l1() {
        return new h(File.class, this).a(f12139a8);
    }

    @n0
    public final Priority m1(@n0 Priority priority) {
        int i10 = a.f12141b[priority.ordinal()];
        if (i10 == 1) {
            return Priority.NORMAL;
        }
        if (i10 == 2) {
            return Priority.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + R());
    }

    @SuppressLint({"CheckResult"})
    public final void n1(List<com.bumptech.glide.request.g<Object>> list) {
        Iterator<com.bumptech.glide.request.g<Object>> it2 = list.iterator();
        while (it2.hasNext()) {
            a1((com.bumptech.glide.request.g) it2.next());
        }
    }

    @Deprecated
    public com.bumptech.glide.request.d<TranscodeType> o1(int i10, int i11) {
        return J1(i10, i11);
    }

    @n0
    public <Y extends p<TranscodeType>> Y p1(@n0 Y y10) {
        return (Y) r1(y10, null, v4.f.b());
    }

    public final <Y extends p<TranscodeType>> Y q1(@n0 Y y10, @p0 com.bumptech.glide.request.g<TranscodeType> gVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        v4.m.d(y10);
        if (!this.Y7) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.request.e eVarC1 = c1(y10, gVar, aVar, executor);
        com.bumptech.glide.request.e eVarR = y10.r();
        if (eVarC1.d(eVarR) && !t1(aVar, eVarR)) {
            if (!((com.bumptech.glide.request.e) v4.m.d(eVarR)).isRunning()) {
                eVarR.h();
            }
            return y10;
        }
        this.N7.C(y10);
        y10.l(eVarC1);
        this.N7.b0(y10, eVarC1);
        return y10;
    }

    @n0
    public <Y extends p<TranscodeType>> Y r1(@n0 Y y10, @p0 com.bumptech.glide.request.g<TranscodeType> gVar, Executor executor) {
        return (Y) q1(y10, gVar, this, executor);
    }

    @n0
    public r<ImageView, TranscodeType> s1(@n0 ImageView imageView) {
        com.bumptech.glide.request.a aVarU0;
        o.b();
        v4.m.d(imageView);
        if (!q0() && o0() && imageView.getScaleType() != null) {
            switch (a.f12140a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarU0 = l().u0();
                    break;
                case 2:
                    aVarU0 = l().v0();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarU0 = l().x0();
                    break;
                case 6:
                    aVarU0 = l().v0();
                    break;
                default:
                    aVarU0 = this;
                    break;
            }
        } else {
            aVarU0 = this;
        }
        return (r) q1(this.Q7.a(imageView, this.O7), null, aVarU0, v4.f.b());
    }

    public final boolean t1(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.e eVar) {
        return !aVar.i0() && eVar.isComplete();
    }

    @g.j
    @n0
    public h<TranscodeType> u1(@p0 com.bumptech.glide.request.g<TranscodeType> gVar) {
        if (f0()) {
            return clone().u1(gVar);
        }
        this.T7 = null;
        return a1(gVar);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> k(@p0 Bitmap bitmap) {
        return E1(bitmap).a(com.bumptech.glide.request.h.f1(com.bumptech.glide.load.engine.h.f12379b));
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: w1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> j(@p0 Drawable drawable) {
        return E1(drawable).a(com.bumptech.glide.request.h.f1(com.bumptech.glide.load.engine.h.f12379b));
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: x1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> e(@p0 Uri uri) {
        return E1(uri);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: y1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> i(@p0 File file) {
        return E1(file);
    }

    @Override // com.bumptech.glide.g
    @g.j
    @n0
    /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> p(@p0 @u0 @v Integer num) {
        return E1(num).a(com.bumptech.glide.request.h.w1(u4.a.c(this.M7)));
    }

    @SuppressLint({"CheckResult"})
    public h(Class<TranscodeType> cls, h<?> hVar) {
        this(hVar.P7, hVar.N7, cls, hVar.M7);
        this.S7 = hVar.S7;
        this.Y7 = hVar.Y7;
        a(hVar);
    }
}
