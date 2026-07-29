package qt;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f47629f = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a[] f47630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f47633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile float f47634e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f47635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f47636b;

        public a(long j10, a aVar) {
            this.f47635a = j10;
            this.f47636b = aVar;
        }
    }

    public static class b extends c {
        public b(int i10) {
            super(i10);
        }

        @Override // qt.c
        public synchronized boolean a(long j10) {
            return super.a(j10);
        }

        @Override // qt.c
        public synchronized void b() {
            super.b();
        }

        @Override // qt.c
        public synchronized boolean c(long j10) {
            return super.c(j10);
        }

        @Override // qt.c
        public synchronized long[] f() {
            return super.f();
        }

        @Override // qt.c
        public synchronized boolean g(long j10) {
            return super.g(j10);
        }

        @Override // qt.c
        public synchronized void h(int i10) {
            super.h(i10);
        }

        @Override // qt.c
        public synchronized void i(int i10) {
            super.i(i10);
        }
    }

    public c() {
        this(16);
    }

    public static c d() {
        return new b(16);
    }

    public static c e(int i10) {
        return new b(i10);
    }

    public boolean a(long j10) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47631b;
        a aVar = this.f47630a[i10];
        for (a aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f47636b) {
            if (aVar2.f47635a == j10) {
                return false;
            }
        }
        this.f47630a[i10] = new a(j10, aVar);
        this.f47633d++;
        if (this.f47633d > this.f47632c) {
            i(this.f47631b * 2);
        }
        return true;
    }

    public void b() {
        this.f47633d = 0;
        Arrays.fill(this.f47630a, (Object) null);
    }

    public boolean c(long j10) {
        for (a aVar = this.f47630a[((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47631b]; aVar != null; aVar = aVar.f47636b) {
            if (aVar.f47635a == j10) {
                return true;
            }
        }
        return false;
    }

    public long[] f() {
        long[] jArr = new long[this.f47633d];
        int i10 = 0;
        for (a aVar : this.f47630a) {
            while (aVar != null) {
                jArr[i10] = aVar.f47635a;
                aVar = aVar.f47636b;
                i10++;
            }
        }
        return jArr;
    }

    public boolean g(long j10) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.f47631b;
        a aVar = this.f47630a[i10];
        a aVar2 = null;
        while (aVar != null) {
            a aVar3 = aVar.f47636b;
            if (aVar.f47635a == j10) {
                if (aVar2 == null) {
                    this.f47630a[i10] = aVar3;
                } else {
                    aVar2.f47636b = aVar3;
                }
                this.f47633d--;
                return true;
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return false;
    }

    public void h(int i10) {
        i((int) ((i10 * this.f47634e * 1.3f) + 0.5f));
    }

    public void i(int i10) {
        a[] aVarArr = new a[i10];
        for (a aVar : this.f47630a) {
            while (aVar != null) {
                long j10 = aVar.f47635a;
                int i11 = ((((int) (j10 >>> 32)) ^ ((int) j10)) & Integer.MAX_VALUE) % i10;
                a aVar2 = aVar.f47636b;
                aVar.f47636b = aVarArr[i11];
                aVarArr[i11] = aVar;
                aVar = aVar2;
            }
        }
        this.f47630a = aVarArr;
        this.f47631b = i10;
        this.f47632c = (int) ((i10 * this.f47634e) + 0.5f);
    }

    public void j(float f10) {
        this.f47634e = f10;
    }

    public int k() {
        return this.f47633d;
    }

    public c(int i10) {
        this.f47634e = 1.3f;
        this.f47631b = i10;
        this.f47632c = (int) ((i10 * this.f47634e) + 0.5f);
        this.f47630a = new a[i10];
    }
}
