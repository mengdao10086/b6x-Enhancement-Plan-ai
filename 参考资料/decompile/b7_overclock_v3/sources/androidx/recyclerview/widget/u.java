package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.f0;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class u<T> implements e0<T> {

    public class a implements e0.b<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7198f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7199g = 2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7200h = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7201a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f7202b = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Runnable f7203c = new RunnableC0065a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e0.b f7204d;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.u$a$a, reason: collision with other inner class name */
        public class RunnableC0065a implements Runnable {
            public RunnableC0065a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVarA = a.this.f7201a.a();
                while (dVarA != null) {
                    int i10 = dVarA.f7222b;
                    if (i10 == 1) {
                        a.this.f7204d.c(dVarA.f7223c, dVarA.f7224d);
                    } else if (i10 == 2) {
                        a.this.f7204d.a(dVarA.f7223c, (f0.a) dVarA.f7228h);
                    } else if (i10 != 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unsupported message, what=");
                        sb2.append(dVarA.f7222b);
                    } else {
                        a.this.f7204d.b(dVarA.f7223c, dVarA.f7224d);
                    }
                    dVarA = a.this.f7201a.a();
                }
            }
        }

        public a(e0.b bVar) {
            this.f7204d = bVar;
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void a(int i10, f0.a<T> aVar) {
            d(d.c(2, i10, aVar));
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void b(int i10, int i11) {
            d(d.a(3, i10, i11));
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void c(int i10, int i11) {
            d(d.a(1, i10, i11));
        }

        public final void d(d dVar) {
            this.f7201a.c(dVar);
            this.f7202b.post(this.f7203c);
        }
    }

    public class b implements e0.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7207g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f7208h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f7209i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f7210j = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7211a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f7212b = AsyncTask.THREAD_POOL_EXECUTOR;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AtomicBoolean f7213c = new AtomicBoolean(false);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f7214d = new a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e0.a f7215e;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    d dVarA = b.this.f7211a.a();
                    if (dVarA == null) {
                        b.this.f7213c.set(false);
                        return;
                    }
                    int i10 = dVarA.f7222b;
                    if (i10 == 1) {
                        b.this.f7211a.b(1);
                        b.this.f7215e.d(dVarA.f7223c);
                    } else if (i10 == 2) {
                        b.this.f7211a.b(2);
                        b.this.f7211a.b(3);
                        b.this.f7215e.a(dVarA.f7223c, dVarA.f7224d, dVarA.f7225e, dVarA.f7226f, dVarA.f7227g);
                    } else if (i10 == 3) {
                        b.this.f7215e.c(dVarA.f7223c, dVarA.f7224d);
                    } else if (i10 != 4) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Unsupported message, what=");
                        sb2.append(dVarA.f7222b);
                    } else {
                        b.this.f7215e.b((f0.a) dVarA.f7228h);
                    }
                }
            }
        }

        public b(e0.a aVar) {
            this.f7215e = aVar;
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void a(int i10, int i11, int i12, int i13, int i14) {
            g(d.b(2, i10, i11, i12, i13, i14, null));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void b(f0.a<T> aVar) {
            f(d.c(4, 0, aVar));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void c(int i10, int i11) {
            f(d.a(3, i10, i11));
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void d(int i10) {
            g(d.c(1, i10, null));
        }

        public final void e() {
            if (this.f7213c.compareAndSet(false, true)) {
                this.f7212b.execute(this.f7214d);
            }
        }

        public final void f(d dVar) {
            this.f7211a.c(dVar);
            e();
        }

        public final void g(d dVar) {
            this.f7211a.d(dVar);
            e();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f7218a;

        public synchronized d a() {
            d dVar = this.f7218a;
            if (dVar == null) {
                return null;
            }
            this.f7218a = dVar.f7221a;
            return dVar;
        }

        public synchronized void b(int i10) {
            d dVar;
            while (true) {
                dVar = this.f7218a;
                if (dVar == null || dVar.f7222b != i10) {
                    break;
                }
                this.f7218a = dVar.f7221a;
                dVar.d();
            }
            if (dVar != null) {
                d dVar2 = dVar.f7221a;
                while (dVar2 != null) {
                    d dVar3 = dVar2.f7221a;
                    if (dVar2.f7222b == i10) {
                        dVar.f7221a = dVar3;
                        dVar2.d();
                    } else {
                        dVar = dVar2;
                    }
                    dVar2 = dVar3;
                }
            }
        }

        public synchronized void c(d dVar) {
            d dVar2 = this.f7218a;
            if (dVar2 == null) {
                this.f7218a = dVar;
                return;
            }
            while (true) {
                d dVar3 = dVar2.f7221a;
                if (dVar3 == null) {
                    dVar2.f7221a = dVar;
                    return;
                }
                dVar2 = dVar3;
            }
        }

        public synchronized void d(d dVar) {
            dVar.f7221a = this.f7218a;
            this.f7218a = dVar;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static d f7219i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f7220j = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d f7221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7224d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7225e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7226f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7227g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f7228h;

        public static d a(int i10, int i11, int i12) {
            return b(i10, i11, i12, 0, 0, 0, null);
        }

        public static d b(int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            d dVar;
            synchronized (f7220j) {
                dVar = f7219i;
                if (dVar == null) {
                    dVar = new d();
                } else {
                    f7219i = dVar.f7221a;
                    dVar.f7221a = null;
                }
                dVar.f7222b = i10;
                dVar.f7223c = i11;
                dVar.f7224d = i12;
                dVar.f7225e = i13;
                dVar.f7226f = i14;
                dVar.f7227g = i15;
                dVar.f7228h = obj;
            }
            return dVar;
        }

        public static d c(int i10, int i11, Object obj) {
            return b(i10, i11, 0, 0, 0, 0, obj);
        }

        public void d() {
            this.f7221a = null;
            this.f7227g = 0;
            this.f7226f = 0;
            this.f7225e = 0;
            this.f7224d = 0;
            this.f7223c = 0;
            this.f7222b = 0;
            this.f7228h = null;
            synchronized (f7220j) {
                d dVar = f7219i;
                if (dVar != null) {
                    this.f7221a = dVar;
                }
                f7219i = this;
            }
        }
    }

    @Override // androidx.recyclerview.widget.e0
    public e0.a<T> a(e0.a<T> aVar) {
        return new b(aVar);
    }

    @Override // androidx.recyclerview.widget.e0
    public e0.b<T> b(e0.b<T> bVar) {
        return new a(bVar);
    }
}
