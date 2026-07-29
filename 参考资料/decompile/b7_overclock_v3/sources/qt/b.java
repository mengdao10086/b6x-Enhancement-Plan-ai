package qt;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class b<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f47621e = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a<T>[] f47622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f47625d;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f47626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public T f47627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a<T> f47628c;

        public a(long j10, T t10, a<T> aVar) {
            this.f47626a = j10;
            this.f47627b = t10;
            this.f47628c = aVar;
        }
    }

    /* JADX INFO: renamed from: qt.b$b, reason: collision with other inner class name */
    public static class C0547b<T> extends b<T> {
        public C0547b(int i10) {
            super(i10);
        }

        @Override // qt.b
        public synchronized void a() {
            super.a();
        }

        @Override // qt.b
        public synchronized boolean b(long j10) {
            return super.b(j10);
        }

        @Override // qt.b
        public synchronized a<T>[] e() {
            return super.e();
        }

        @Override // qt.b
        public synchronized T f(long j10) {
            return (T) super.f(j10);
        }

        @Override // qt.b
        public synchronized long[] g() {
            return super.g();
        }

        @Override // qt.b
        public synchronized T h(long j10, T t10) {
            return (T) super.h(j10, t10);
        }

        @Override // qt.b
        public synchronized T i(long j10) {
            return (T) super.i(j10);
        }

        @Override // qt.b
        public synchronized void j(int i10) {
            super.j(i10);
        }

        @Override // qt.b
        public synchronized void k(int i10) {
            super.k(i10);
        }
    }

    public b() {
        this(16);
    }

    public static <T> b<T> c() {
        return new C0547b(16);
    }

    public static <T> b<T> d(int i10) {
        return new C0547b(i10);
    }

    public void a() {
        this.f47625d = 0;
        Arrays.fill(this.f47622a, (Object) null);
    }

    public boolean b(long j10) {
        for (a<T> aVar = this.f47622a[((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47623b]; aVar != null; aVar = aVar.f47628c) {
            if (aVar.f47626a == j10) {
                return true;
            }
        }
        return false;
    }

    public a<T>[] e() {
        a<T>[] aVarArr = new a[this.f47625d];
        int i10 = 0;
        for (a<T> aVar : this.f47622a) {
            while (aVar != null) {
                aVarArr[i10] = aVar;
                aVar = aVar.f47628c;
                i10++;
            }
        }
        return aVarArr;
    }

    public T f(long j10) {
        for (a<T> aVar = this.f47622a[((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47623b]; aVar != null; aVar = aVar.f47628c) {
            if (aVar.f47626a == j10) {
                return aVar.f47627b;
            }
        }
        return null;
    }

    public long[] g() {
        long[] jArr = new long[this.f47625d];
        int i10 = 0;
        for (a<T> aVar : this.f47622a) {
            while (aVar != null) {
                jArr[i10] = aVar.f47626a;
                aVar = aVar.f47628c;
                i10++;
            }
        }
        return jArr;
    }

    public T h(long j10, T t10) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47623b;
        a<T> aVar = this.f47622a[i10];
        for (a<T> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f47628c) {
            if (aVar2.f47626a == j10) {
                T t11 = aVar2.f47627b;
                aVar2.f47627b = t10;
                return t11;
            }
        }
        this.f47622a[i10] = new a<>(j10, t10, aVar);
        this.f47625d++;
        if (this.f47625d <= this.f47624c) {
            return null;
        }
        k(this.f47623b * 2);
        return null;
    }

    public T i(long j10) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47623b;
        a<T> aVar = this.f47622a[i10];
        a<T> aVar2 = null;
        while (aVar != null) {
            a<T> aVar3 = aVar.f47628c;
            if (aVar.f47626a == j10) {
                if (aVar2 == null) {
                    this.f47622a[i10] = aVar3;
                } else {
                    aVar2.f47628c = aVar3;
                }
                this.f47625d--;
                return aVar.f47627b;
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return null;
    }

    public void j(int i10) {
        k((i10 * 5) / 3);
    }

    public void k(int i10) {
        a<T>[] aVarArr = new a[i10];
        for (a<T> aVar : this.f47622a) {
            while (aVar != null) {
                long j10 = aVar.f47626a;
                int i11 = ((((int) (j10 >>> 32)) ^ ((int) j10)) & Integer.MAX_VALUE) % i10;
                a<T> aVar2 = aVar.f47628c;
                aVar.f47628c = aVarArr[i11];
                aVarArr[i11] = aVar;
                aVar = aVar2;
            }
        }
        this.f47622a = aVarArr;
        this.f47623b = i10;
        this.f47624c = (i10 * 4) / 3;
    }

    public int l() {
        return this.f47625d;
    }

    public b(int i10) {
        this.f47623b = i10;
        this.f47624c = (i10 * 4) / 3;
        this.f47622a = new a[i10];
    }
}
