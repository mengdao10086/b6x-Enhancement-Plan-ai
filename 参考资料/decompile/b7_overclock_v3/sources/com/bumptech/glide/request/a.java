package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.request.a;
import com.google.common.collect.LinkedHashMultimap;
import g.f0;
import g.n0;
import g.p0;
import g.v;
import g.x;
import java.util.Map;
import v4.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    public static final int A = -1;
    public static final int B = 2;
    public static final int C = 4;
    public static final int C1 = 256;
    public static final int C2 = 2048;
    public static final int D = 8;
    public static final int E7 = 8192;
    public static final int F7 = 16384;
    public static final int G7 = 32768;
    public static final int H7 = 65536;
    public static final int I7 = 131072;
    public static final int J7 = 262144;
    public static final int K0 = 32;
    public static final int K1 = 512;
    public static final int K2 = 4096;
    public static final int K7 = 524288;
    public static final int L7 = 1048576;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f12709k0 = 16;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f12710k1 = 64;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f12711v1 = 128;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f12712v2 = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12713a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public Drawable f12717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Drawable f12719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12720h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12725m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Drawable f12727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f12728p;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f12732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public Resources.Theme f12733u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f12734v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12735w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12736x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12738z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12714b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public com.bumptech.glide.load.engine.h f12715c = com.bumptech.glide.load.engine.h.f12382e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public Priority f12716d = Priority.NORMAL;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12721i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12722j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12723k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public c4.b f12724l = u4.c.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12726n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public c4.e f12729q = new c4.e();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public Map<Class<?>, c4.h<?>> f12730r = new v4.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public Class<?> f12731s = Object.class;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12737y = true;

    public static boolean m0(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    @g.j
    @n0
    public T A(@v int i10) {
        if (this.f12734v) {
            return (T) l().A(i10);
        }
        this.f12728p = i10;
        int i11 = this.f12713a | 16384;
        this.f12727o = null;
        this.f12713a = i11 & (-8193);
        return (T) K0();
    }

    @n0
    public final T A0(@n0 DownsampleStrategy downsampleStrategy, @n0 c4.h<Bitmap> hVar) {
        if (this.f12734v) {
            return (T) l().A0(downsampleStrategy, hVar);
        }
        u(downsampleStrategy);
        return (T) S0(hVar, false);
    }

    @g.j
    @n0
    public T B(@p0 Drawable drawable) {
        if (this.f12734v) {
            return (T) l().B(drawable);
        }
        this.f12727o = drawable;
        int i10 = this.f12713a | 8192;
        this.f12728p = 0;
        this.f12713a = i10 & (-16385);
        return (T) K0();
    }

    @g.j
    @n0
    public <Y> T B0(@n0 Class<Y> cls, @n0 c4.h<Y> hVar) {
        return (T) V0(cls, hVar, false);
    }

    @g.j
    @n0
    public T C() {
        return (T) H0(DownsampleStrategy.f12533c, new s());
    }

    @g.j
    @n0
    public T C0(int i10) {
        return (T) D0(i10, i10);
    }

    @g.j
    @n0
    public T D(@n0 DecodeFormat decodeFormat) {
        m.d(decodeFormat);
        return (T) L0(o.f12607g, decodeFormat).L0(n4.i.f41874a, decodeFormat);
    }

    @g.j
    @n0
    public T D0(int i10, int i11) {
        if (this.f12734v) {
            return (T) l().D0(i10, i11);
        }
        this.f12723k = i10;
        this.f12722j = i11;
        this.f12713a |= 512;
        return (T) K0();
    }

    @g.j
    @n0
    public T E(@f0(from = 0) long j10) {
        return (T) L0(VideoDecoder.f12549g, Long.valueOf(j10));
    }

    @g.j
    @n0
    public T E0(@v int i10) {
        if (this.f12734v) {
            return (T) l().E0(i10);
        }
        this.f12720h = i10;
        int i11 = this.f12713a | 128;
        this.f12719g = null;
        this.f12713a = i11 & (-65);
        return (T) K0();
    }

    @n0
    public final com.bumptech.glide.load.engine.h F() {
        return this.f12715c;
    }

    @g.j
    @n0
    public T F0(@p0 Drawable drawable) {
        if (this.f12734v) {
            return (T) l().F0(drawable);
        }
        this.f12719g = drawable;
        int i10 = this.f12713a | 64;
        this.f12720h = 0;
        this.f12713a = i10 & (-129);
        return (T) K0();
    }

    public final int G() {
        return this.f12718f;
    }

    @g.j
    @n0
    public T G0(@n0 Priority priority) {
        if (this.f12734v) {
            return (T) l().G0(priority);
        }
        this.f12716d = (Priority) m.d(priority);
        this.f12713a |= 8;
        return (T) K0();
    }

    @p0
    public final Drawable H() {
        return this.f12717e;
    }

    @n0
    public final T H0(@n0 DownsampleStrategy downsampleStrategy, @n0 c4.h<Bitmap> hVar) {
        return (T) I0(downsampleStrategy, hVar, true);
    }

    @p0
    public final Drawable I() {
        return this.f12727o;
    }

    @n0
    public final T I0(@n0 DownsampleStrategy downsampleStrategy, @n0 c4.h<Bitmap> hVar, boolean z10) {
        T t10 = z10 ? (T) T0(downsampleStrategy, hVar) : (T) A0(downsampleStrategy, hVar);
        t10.f12737y = true;
        return t10;
    }

    public final int J() {
        return this.f12728p;
    }

    public final T J0() {
        return this;
    }

    public final boolean K() {
        return this.f12736x;
    }

    @n0
    public final T K0() {
        if (this.f12732t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) J0();
    }

    @n0
    public final c4.e L() {
        return this.f12729q;
    }

    @g.j
    @n0
    public <Y> T L0(@n0 c4.d<Y> dVar, @n0 Y y10) {
        if (this.f12734v) {
            return (T) l().L0(dVar, y10);
        }
        m.d(dVar);
        m.d(y10);
        this.f12729q.e(dVar, y10);
        return (T) K0();
    }

    @g.j
    @n0
    public T M0(@n0 c4.b bVar) {
        if (this.f12734v) {
            return (T) l().M0(bVar);
        }
        this.f12724l = (c4.b) m.d(bVar);
        this.f12713a |= 1024;
        return (T) K0();
    }

    public final int N() {
        return this.f12722j;
    }

    @g.j
    @n0
    public T N0(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        if (this.f12734v) {
            return (T) l().N0(f10);
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f12714b = f10;
        this.f12713a |= 2;
        return (T) K0();
    }

    public final int O() {
        return this.f12723k;
    }

    @g.j
    @n0
    public T O0(boolean z10) {
        if (this.f12734v) {
            return (T) l().O0(true);
        }
        this.f12721i = !z10;
        this.f12713a |= 256;
        return (T) K0();
    }

    @p0
    public final Drawable P() {
        return this.f12719g;
    }

    @g.j
    @n0
    public T P0(@p0 Resources.Theme theme) {
        if (this.f12734v) {
            return (T) l().P0(theme);
        }
        this.f12733u = theme;
        this.f12713a |= 32768;
        return (T) K0();
    }

    public final int Q() {
        return this.f12720h;
    }

    @g.j
    @n0
    public T Q0(@f0(from = 0) int i10) {
        return (T) L0(i4.b.f31824b, Integer.valueOf(i10));
    }

    @n0
    public final Priority R() {
        return this.f12716d;
    }

    @g.j
    @n0
    public T R0(@n0 c4.h<Bitmap> hVar) {
        return (T) S0(hVar, true);
    }

    @n0
    public final Class<?> S() {
        return this.f12731s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public T S0(@n0 c4.h<Bitmap> hVar, boolean z10) {
        if (this.f12734v) {
            return (T) l().S0(hVar, z10);
        }
        q qVar = new q(hVar, z10);
        V0(Bitmap.class, hVar, z10);
        V0(Drawable.class, qVar, z10);
        V0(BitmapDrawable.class, qVar.c(), z10);
        V0(n4.c.class, new n4.f(hVar), z10);
        return (T) K0();
    }

    @g.j
    @n0
    public final T T0(@n0 DownsampleStrategy downsampleStrategy, @n0 c4.h<Bitmap> hVar) {
        if (this.f12734v) {
            return (T) l().T0(downsampleStrategy, hVar);
        }
        u(downsampleStrategy);
        return (T) R0(hVar);
    }

    @g.j
    @n0
    public <Y> T U0(@n0 Class<Y> cls, @n0 c4.h<Y> hVar) {
        return (T) V0(cls, hVar, true);
    }

    @n0
    public final c4.b V() {
        return this.f12724l;
    }

    @n0
    public <Y> T V0(@n0 Class<Y> cls, @n0 c4.h<Y> hVar, boolean z10) {
        if (this.f12734v) {
            return (T) l().V0(cls, hVar, z10);
        }
        m.d(cls);
        m.d(hVar);
        this.f12730r.put(cls, hVar);
        int i10 = this.f12713a | 2048;
        this.f12726n = true;
        int i11 = i10 | 65536;
        this.f12713a = i11;
        this.f12737y = false;
        if (z10) {
            this.f12713a = i11 | 131072;
            this.f12725m = true;
        }
        return (T) K0();
    }

    @g.j
    @n0
    public T W0(@n0 c4.h<Bitmap>... hVarArr) {
        return hVarArr.length > 1 ? (T) S0(new c4.c(hVarArr), true) : hVarArr.length == 1 ? (T) R0(hVarArr[0]) : (T) K0();
    }

    @g.j
    @n0
    @Deprecated
    public T X0(@n0 c4.h<Bitmap>... hVarArr) {
        return (T) S0(new c4.c(hVarArr), true);
    }

    public final float Y() {
        return this.f12714b;
    }

    @g.j
    @n0
    public T Y0(boolean z10) {
        if (this.f12734v) {
            return (T) l().Y0(z10);
        }
        this.f12738z = z10;
        this.f12713a |= 1048576;
        return (T) K0();
    }

    @g.j
    @n0
    public T Z0(boolean z10) {
        if (this.f12734v) {
            return (T) l().Z0(z10);
        }
        this.f12735w = z10;
        this.f12713a |= 262144;
        return (T) K0();
    }

    @g.j
    @n0
    public T a(@n0 a<?> aVar) {
        if (this.f12734v) {
            return (T) l().a(aVar);
        }
        if (m0(aVar.f12713a, 2)) {
            this.f12714b = aVar.f12714b;
        }
        if (m0(aVar.f12713a, 262144)) {
            this.f12735w = aVar.f12735w;
        }
        if (m0(aVar.f12713a, 1048576)) {
            this.f12738z = aVar.f12738z;
        }
        if (m0(aVar.f12713a, 4)) {
            this.f12715c = aVar.f12715c;
        }
        if (m0(aVar.f12713a, 8)) {
            this.f12716d = aVar.f12716d;
        }
        if (m0(aVar.f12713a, 16)) {
            this.f12717e = aVar.f12717e;
            this.f12718f = 0;
            this.f12713a &= -33;
        }
        if (m0(aVar.f12713a, 32)) {
            this.f12718f = aVar.f12718f;
            this.f12717e = null;
            this.f12713a &= -17;
        }
        if (m0(aVar.f12713a, 64)) {
            this.f12719g = aVar.f12719g;
            this.f12720h = 0;
            this.f12713a &= -129;
        }
        if (m0(aVar.f12713a, 128)) {
            this.f12720h = aVar.f12720h;
            this.f12719g = null;
            this.f12713a &= -65;
        }
        if (m0(aVar.f12713a, 256)) {
            this.f12721i = aVar.f12721i;
        }
        if (m0(aVar.f12713a, 512)) {
            this.f12723k = aVar.f12723k;
            this.f12722j = aVar.f12722j;
        }
        if (m0(aVar.f12713a, 1024)) {
            this.f12724l = aVar.f12724l;
        }
        if (m0(aVar.f12713a, 4096)) {
            this.f12731s = aVar.f12731s;
        }
        if (m0(aVar.f12713a, 8192)) {
            this.f12727o = aVar.f12727o;
            this.f12728p = 0;
            this.f12713a &= -16385;
        }
        if (m0(aVar.f12713a, 16384)) {
            this.f12728p = aVar.f12728p;
            this.f12727o = null;
            this.f12713a &= -8193;
        }
        if (m0(aVar.f12713a, 32768)) {
            this.f12733u = aVar.f12733u;
        }
        if (m0(aVar.f12713a, 65536)) {
            this.f12726n = aVar.f12726n;
        }
        if (m0(aVar.f12713a, 131072)) {
            this.f12725m = aVar.f12725m;
        }
        if (m0(aVar.f12713a, 2048)) {
            this.f12730r.putAll(aVar.f12730r);
            this.f12737y = aVar.f12737y;
        }
        if (m0(aVar.f12713a, 524288)) {
            this.f12736x = aVar.f12736x;
        }
        if (!this.f12726n) {
            this.f12730r.clear();
            int i10 = this.f12713a & (-2049);
            this.f12725m = false;
            this.f12713a = i10 & (-131073);
            this.f12737y = true;
        }
        this.f12713a |= aVar.f12713a;
        this.f12729q.d(aVar.f12729q);
        return (T) K0();
    }

    @p0
    public final Resources.Theme a0() {
        return this.f12733u;
    }

    @n0
    public T b() {
        if (this.f12732t && !this.f12734v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.f12734v = true;
        return (T) s0();
    }

    @g.j
    @n0
    public T c() {
        return (T) T0(DownsampleStrategy.f12535e, new l());
    }

    @n0
    public final Map<Class<?>, c4.h<?>> c0() {
        return this.f12730r;
    }

    public final boolean d0() {
        return this.f12738z;
    }

    public final boolean e0() {
        return this.f12735w;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f12714b, this.f12714b) == 0 && this.f12718f == aVar.f12718f && v4.o.d(this.f12717e, aVar.f12717e) && this.f12720h == aVar.f12720h && v4.o.d(this.f12719g, aVar.f12719g) && this.f12728p == aVar.f12728p && v4.o.d(this.f12727o, aVar.f12727o) && this.f12721i == aVar.f12721i && this.f12722j == aVar.f12722j && this.f12723k == aVar.f12723k && this.f12725m == aVar.f12725m && this.f12726n == aVar.f12726n && this.f12735w == aVar.f12735w && this.f12736x == aVar.f12736x && this.f12715c.equals(aVar.f12715c) && this.f12716d == aVar.f12716d && this.f12729q.equals(aVar.f12729q) && this.f12730r.equals(aVar.f12730r) && this.f12731s.equals(aVar.f12731s) && v4.o.d(this.f12724l, aVar.f12724l) && v4.o.d(this.f12733u, aVar.f12733u);
    }

    @g.j
    @n0
    public T f() {
        return (T) H0(DownsampleStrategy.f12534d, new com.bumptech.glide.load.resource.bitmap.m());
    }

    public final boolean f0() {
        return this.f12734v;
    }

    @g.j
    @n0
    public T g() {
        return (T) T0(DownsampleStrategy.f12534d, new n());
    }

    public final boolean g0() {
        return l0(4);
    }

    public final boolean h0() {
        return this.f12732t;
    }

    public int hashCode() {
        return v4.o.q(this.f12733u, v4.o.q(this.f12724l, v4.o.q(this.f12731s, v4.o.q(this.f12730r, v4.o.q(this.f12729q, v4.o.q(this.f12716d, v4.o.q(this.f12715c, v4.o.s(this.f12736x, v4.o.s(this.f12735w, v4.o.s(this.f12726n, v4.o.s(this.f12725m, v4.o.p(this.f12723k, v4.o.p(this.f12722j, v4.o.s(this.f12721i, v4.o.q(this.f12727o, v4.o.p(this.f12728p, v4.o.q(this.f12719g, v4.o.p(this.f12720h, v4.o.q(this.f12717e, v4.o.p(this.f12718f, v4.o.m(this.f12714b)))))))))))))))))))));
    }

    public final boolean i0() {
        return this.f12721i;
    }

    public final boolean j0() {
        return l0(8);
    }

    public boolean k0() {
        return this.f12737y;
    }

    @Override // 
    @g.j
    public T l() {
        try {
            T t10 = (T) super.clone();
            c4.e eVar = new c4.e();
            t10.f12729q = eVar;
            eVar.d(this.f12729q);
            v4.b bVar = new v4.b();
            t10.f12730r = bVar;
            bVar.putAll(this.f12730r);
            t10.f12732t = false;
            t10.f12734v = false;
            return t10;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final boolean l0(int i10) {
        return m0(this.f12713a, i10);
    }

    @g.j
    @n0
    public T m(@n0 Class<?> cls) {
        if (this.f12734v) {
            return (T) l().m(cls);
        }
        this.f12731s = (Class) m.d(cls);
        this.f12713a |= 4096;
        return (T) K0();
    }

    @g.j
    @n0
    public T n() {
        return (T) L0(o.f12611k, Boolean.FALSE);
    }

    public final boolean n0() {
        return l0(256);
    }

    public final boolean o0() {
        return this.f12726n;
    }

    public final boolean p0() {
        return this.f12725m;
    }

    @g.j
    @n0
    public T q(@n0 com.bumptech.glide.load.engine.h hVar) {
        if (this.f12734v) {
            return (T) l().q(hVar);
        }
        this.f12715c = (com.bumptech.glide.load.engine.h) m.d(hVar);
        this.f12713a |= 4;
        return (T) K0();
    }

    public final boolean q0() {
        return l0(2048);
    }

    @g.j
    @n0
    public T r() {
        return (T) L0(n4.i.f41875b, Boolean.TRUE);
    }

    public final boolean r0() {
        return v4.o.w(this.f12723k, this.f12722j);
    }

    @g.j
    @n0
    public T s() {
        if (this.f12734v) {
            return (T) l().s();
        }
        this.f12730r.clear();
        int i10 = this.f12713a & (-2049);
        this.f12725m = false;
        this.f12726n = false;
        this.f12713a = (i10 & (-131073)) | 65536;
        this.f12737y = true;
        return (T) K0();
    }

    @n0
    public T s0() {
        this.f12732t = true;
        return (T) J0();
    }

    @g.j
    @n0
    public T t0(boolean z10) {
        if (this.f12734v) {
            return (T) l().t0(z10);
        }
        this.f12736x = z10;
        this.f12713a |= 524288;
        return (T) K0();
    }

    @g.j
    @n0
    public T u(@n0 DownsampleStrategy downsampleStrategy) {
        return (T) L0(DownsampleStrategy.f12538h, m.d(downsampleStrategy));
    }

    @g.j
    @n0
    public T u0() {
        return (T) A0(DownsampleStrategy.f12535e, new l());
    }

    @g.j
    @n0
    public T v(@n0 Bitmap.CompressFormat compressFormat) {
        return (T) L0(com.bumptech.glide.load.resource.bitmap.e.f12589c, m.d(compressFormat));
    }

    @g.j
    @n0
    public T v0() {
        return (T) y0(DownsampleStrategy.f12534d, new com.bumptech.glide.load.resource.bitmap.m());
    }

    @g.j
    @n0
    public T w(@f0(from = 0, to = 100) int i10) {
        return (T) L0(com.bumptech.glide.load.resource.bitmap.e.f12588b, Integer.valueOf(i10));
    }

    @g.j
    @n0
    public T w0() {
        return (T) A0(DownsampleStrategy.f12535e, new n());
    }

    @g.j
    @n0
    public T x(@v int i10) {
        if (this.f12734v) {
            return (T) l().x(i10);
        }
        this.f12718f = i10;
        int i11 = this.f12713a | 32;
        this.f12717e = null;
        this.f12713a = i11 & (-17);
        return (T) K0();
    }

    @g.j
    @n0
    public T x0() {
        return (T) y0(DownsampleStrategy.f12533c, new s());
    }

    @g.j
    @n0
    public T y(@p0 Drawable drawable) {
        if (this.f12734v) {
            return (T) l().y(drawable);
        }
        this.f12717e = drawable;
        int i10 = this.f12713a | 16;
        this.f12718f = 0;
        this.f12713a = i10 & (-33);
        return (T) K0();
    }

    @n0
    public final T y0(@n0 DownsampleStrategy downsampleStrategy, @n0 c4.h<Bitmap> hVar) {
        return (T) I0(downsampleStrategy, hVar, false);
    }

    @g.j
    @n0
    public T z0(@n0 c4.h<Bitmap> hVar) {
        return (T) S0(hVar, false);
    }
}
