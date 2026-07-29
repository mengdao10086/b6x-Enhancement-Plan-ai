package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class w2 implements c2.g, c2.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.i1
    public static final int f7540i = 15;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.i1
    public static final int f7541j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.i1
    public static final TreeMap<Integer, w2> f7542k = new TreeMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7543l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7544m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7545n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f7546o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f7547p = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f7548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.i1
    public final long[] f7549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.i1
    public final double[] f7550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.i1
    public final String[] f7551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.i1
    public final byte[][] f7552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f7553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.i1
    public final int f7554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.i1
    public int f7555h;

    public class a implements c2.f {
        public a() {
        }

        @Override // c2.f
        public void D(int i10, String str) {
            w2.this.D(i10, str);
        }

        @Override // c2.f
        public void E0(int i10, byte[] bArr) {
            w2.this.E0(i10, bArr);
        }

        @Override // c2.f
        public void M1() {
            w2.this.M1();
        }

        @Override // c2.f
        public void R(int i10, double d10) {
            w2.this.R(i10, d10);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // c2.f
        public void l1(int i10) {
            w2.this.l1(i10);
        }

        @Override // c2.f
        public void s0(int i10, long j10) {
            w2.this.s0(i10, j10);
        }
    }

    public w2(int i10) {
        this.f7554g = i10;
        int i11 = i10 + 1;
        this.f7553f = new int[i11];
        this.f7549b = new long[i11];
        this.f7550c = new double[i11];
        this.f7551d = new String[i11];
        this.f7552e = new byte[i11][];
    }

    public static w2 f(String str, int i10) {
        TreeMap<Integer, w2> treeMap = f7542k;
        synchronized (treeMap) {
            Map.Entry<Integer, w2> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (entryCeilingEntry == null) {
                w2 w2Var = new w2(i10);
                w2Var.k(str, i10);
                return w2Var;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            w2 value = entryCeilingEntry.getValue();
            value.k(str, i10);
            return value;
        }
    }

    public static w2 i(c2.g gVar) {
        w2 w2VarF = f(gVar.d(), gVar.c());
        gVar.a(w2VarF.new a());
        return w2VarF;
    }

    public static void l() {
        TreeMap<Integer, w2> treeMap = f7542k;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it2 = treeMap.descendingKeySet().iterator();
        while (true) {
            int i10 = size - 1;
            if (size <= 0) {
                return;
            }
            it2.next();
            it2.remove();
            size = i10;
        }
    }

    @Override // c2.f
    public void D(int i10, String str) {
        this.f7553f[i10] = 4;
        this.f7551d[i10] = str;
    }

    @Override // c2.f
    public void E0(int i10, byte[] bArr) {
        this.f7553f[i10] = 5;
        this.f7552e[i10] = bArr;
    }

    @Override // c2.f
    public void M1() {
        Arrays.fill(this.f7553f, 1);
        Arrays.fill(this.f7551d, (Object) null);
        Arrays.fill(this.f7552e, (Object) null);
        this.f7548a = null;
    }

    @Override // c2.f
    public void R(int i10, double d10) {
        this.f7553f[i10] = 3;
        this.f7550c[i10] = d10;
    }

    @Override // c2.g
    public void a(c2.f fVar) {
        for (int i10 = 1; i10 <= this.f7555h; i10++) {
            int i11 = this.f7553f[i10];
            if (i11 == 1) {
                fVar.l1(i10);
            } else if (i11 == 2) {
                fVar.s0(i10, this.f7549b[i10]);
            } else if (i11 == 3) {
                fVar.R(i10, this.f7550c[i10]);
            } else if (i11 == 4) {
                fVar.D(i10, this.f7551d[i10]);
            } else if (i11 == 5) {
                fVar.E0(i10, this.f7552e[i10]);
            }
        }
    }

    @Override // c2.g
    public int c() {
        return this.f7555h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // c2.g
    public String d() {
        return this.f7548a;
    }

    public void h(w2 w2Var) {
        int iC = w2Var.c() + 1;
        System.arraycopy(w2Var.f7553f, 0, this.f7553f, 0, iC);
        System.arraycopy(w2Var.f7549b, 0, this.f7549b, 0, iC);
        System.arraycopy(w2Var.f7551d, 0, this.f7551d, 0, iC);
        System.arraycopy(w2Var.f7552e, 0, this.f7552e, 0, iC);
        System.arraycopy(w2Var.f7550c, 0, this.f7550c, 0, iC);
    }

    public void k(String str, int i10) {
        this.f7548a = str;
        this.f7555h = i10;
    }

    @Override // c2.f
    public void l1(int i10) {
        this.f7553f[i10] = 1;
    }

    public void m() {
        TreeMap<Integer, w2> treeMap = f7542k;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f7554g), this);
            l();
        }
    }

    @Override // c2.f
    public void s0(int i10, long j10) {
        this.f7553f[i10] = 2;
        this.f7549b[i10] = j10;
    }
}
