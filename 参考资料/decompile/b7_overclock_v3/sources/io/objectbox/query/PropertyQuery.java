package io.objectbox.query;

import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Query<?> f32781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Property<?> f32783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f32784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32786f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f32787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f32788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f32789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f32790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f32791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f32792l;

    public PropertyQuery(Query<?> query, Property<?> property) {
        this.f32781a = query;
        this.f32782b = query.f32837h;
        this.f32783c = property;
        this.f32784d = property.f32643id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double Q() throws Exception {
        return Double.valueOf(nativeAvg(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long R() throws Exception {
        return Long.valueOf(nativeAvgLong(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long S() throws Exception {
        return Long.valueOf(nativeCount(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ byte[] T() throws Exception {
        return nativeFindBytes(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, (byte) this.f32792l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ char[] U() throws Exception {
        return nativeFindChars(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, (char) this.f32792l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ double[] V() throws Exception {
        return nativeFindDoubles(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, this.f32789i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float[] W() throws Exception {
        return nativeFindFloats(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, this.f32790j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int[] X() throws Exception {
        return nativeFindInts(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, (int) this.f32792l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ long[] Y() throws Exception {
        return nativeFindLongs(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, this.f32792l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Z() throws Exception {
        return nativeFindNumber(this.f32782b, this.f32781a.z(), this.f32784d, this.f32788h, this.f32785e, this.f32787g, this.f32792l, this.f32790j, this.f32789i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ short[] a0() throws Exception {
        return nativeFindShorts(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32787g, (short) this.f32792l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String b0() throws Exception {
        return nativeFindString(this.f32782b, this.f32781a.z(), this.f32784d, this.f32788h, this.f32785e, this.f32785e && !this.f32786f, this.f32787g, this.f32791k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String[] c0() throws Exception {
        return nativeFindStrings(this.f32782b, this.f32781a.z(), this.f32784d, this.f32785e, this.f32785e && this.f32786f, this.f32787g, this.f32791k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long d0() throws Exception {
        return Long.valueOf(nativeMax(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double e0() throws Exception {
        return Double.valueOf(nativeMaxDouble(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long f0() throws Exception {
        return Long.valueOf(nativeMin(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double g0() throws Exception {
        return Double.valueOf(nativeMinDouble(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long h0() throws Exception {
        return Long.valueOf(nativeSum(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double i0() throws Exception {
        return Double.valueOf(nativeSumDouble(this.f32782b, this.f32781a.z(), this.f32784d));
    }

    public byte[] A() {
        return (byte[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32877a.T();
            }
        });
    }

    public Character B() {
        return (Character) L();
    }

    public char[] C() {
        return (char[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32879a.U();
            }
        });
    }

    public Double D() {
        return (Double) L();
    }

    public double[] E() {
        return (double[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.o
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32899a.V();
            }
        });
    }

    public Float F() {
        return (Float) L();
    }

    public float[] G() {
        return (float[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32886a.W();
            }
        });
    }

    public Integer H() {
        return (Integer) L();
    }

    public int[] I() {
        return (int[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32903a.X();
            }
        });
    }

    public Long J() {
        return (Long) L();
    }

    public long[] K() {
        return (long[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.x
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32908a.Y();
            }
        });
    }

    public final Object L() {
        return this.f32781a.m(new Callable() { // from class: io.objectbox.query.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32884a.Z();
            }
        });
    }

    public Short M() {
        return (Short) L();
    }

    public short[] N() {
        return (short[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32901a.a0();
            }
        });
    }

    public String O() {
        return (String) this.f32781a.m(new Callable() { // from class: io.objectbox.query.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32887a.b0();
            }
        });
    }

    public String[] P() {
        return (String[]) this.f32781a.m(new Callable() { // from class: io.objectbox.query.w
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32907a.c0();
            }
        });
    }

    public long j0() {
        return ((Long) this.f32781a.m(new Callable() { // from class: io.objectbox.query.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32883a.d0();
            }
        })).longValue();
    }

    public double k0() {
        return ((Double) this.f32781a.m(new Callable() { // from class: io.objectbox.query.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32902a.e0();
            }
        })).doubleValue();
    }

    public long l0() {
        return ((Long) this.f32781a.m(new Callable() { // from class: io.objectbox.query.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32898a.f0();
            }
        })).longValue();
    }

    public double m0() {
        return ((Double) this.f32781a.m(new Callable() { // from class: io.objectbox.query.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32889a.g0();
            }
        })).doubleValue();
    }

    public PropertyQuery n0(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null values are not allowed");
        }
        boolean z10 = obj instanceof String;
        boolean z11 = obj instanceof Number;
        if (!z10 && !z11) {
            throw new IllegalArgumentException("Unsupported value class: " + obj.getClass());
        }
        this.f32787g = true;
        this.f32791k = z10 ? (String) obj : null;
        boolean z12 = obj instanceof Float;
        this.f32790j = z12 ? ((Float) obj).floatValue() : 0.0f;
        boolean z13 = obj instanceof Double;
        this.f32789i = z13 ? ((Double) obj).doubleValue() : 0.0d;
        this.f32792l = (!z11 || z12 || z13) ? 0L : ((Number) obj).longValue();
        return this;
    }

    public native double nativeAvg(long j10, long j11, int i10);

    public native long nativeAvgLong(long j10, long j11, int i10);

    public native long nativeCount(long j10, long j11, int i10, boolean z10);

    public native byte[] nativeFindBytes(long j10, long j11, int i10, boolean z10, boolean z11, byte b10);

    public native char[] nativeFindChars(long j10, long j11, int i10, boolean z10, boolean z11, char c10);

    public native double[] nativeFindDoubles(long j10, long j11, int i10, boolean z10, boolean z11, double d10);

    public native float[] nativeFindFloats(long j10, long j11, int i10, boolean z10, boolean z11, float f10);

    public native int[] nativeFindInts(long j10, long j11, int i10, boolean z10, boolean z11, int i11);

    public native long[] nativeFindLongs(long j10, long j11, int i10, boolean z10, boolean z11, long j12);

    public native Object nativeFindNumber(long j10, long j11, int i10, boolean z10, boolean z11, boolean z12, long j12, float f10, double d10);

    public native short[] nativeFindShorts(long j10, long j11, int i10, boolean z10, boolean z11, short s10);

    public native String nativeFindString(long j10, long j11, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str);

    public native String[] nativeFindStrings(long j10, long j11, int i10, boolean z10, boolean z11, boolean z12, String str);

    public native long nativeMax(long j10, long j11, int i10);

    public native double nativeMaxDouble(long j10, long j11, int i10);

    public native long nativeMin(long j10, long j11, int i10);

    public native double nativeMinDouble(long j10, long j11, int i10);

    public native long nativeSum(long j10, long j11, int i10);

    public native double nativeSumDouble(long j10, long j11, int i10);

    public PropertyQuery o0() {
        this.f32785e = false;
        this.f32786f = true;
        this.f32788h = false;
        this.f32787g = false;
        this.f32789i = 0.0d;
        this.f32790j = 0.0f;
        this.f32791k = null;
        this.f32792l = 0L;
        return this;
    }

    public long p0() {
        return ((Long) this.f32781a.m(new Callable() { // from class: io.objectbox.query.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32900a.h0();
            }
        })).longValue();
    }

    public double q0() {
        return ((Double) this.f32781a.m(new Callable() { // from class: io.objectbox.query.t
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32904a.i0();
            }
        })).doubleValue();
    }

    public PropertyQuery r0() {
        this.f32788h = true;
        return this;
    }

    public double t() {
        return ((Double) this.f32781a.m(new Callable() { // from class: io.objectbox.query.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32906a.Q();
            }
        })).doubleValue();
    }

    public long u() {
        return ((Long) this.f32781a.m(new Callable() { // from class: io.objectbox.query.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32905a.R();
            }
        })).longValue();
    }

    public long v() {
        return ((Long) this.f32781a.m(new Callable() { // from class: io.objectbox.query.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f32885a.S();
            }
        })).longValue();
    }

    public PropertyQuery w() {
        this.f32785e = true;
        return this;
    }

    public PropertyQuery x(QueryBuilder.StringOrder stringOrder) {
        if (this.f32783c.type == String.class) {
            this.f32785e = true;
            this.f32786f = stringOrder == QueryBuilder.StringOrder.CASE_INSENSITIVE;
            return this;
        }
        throw new RuntimeException("Reserved for string properties, but got " + this.f32783c);
    }

    public Boolean y() {
        return (Boolean) L();
    }

    public Byte z() {
        return (Byte) L();
    }
}
