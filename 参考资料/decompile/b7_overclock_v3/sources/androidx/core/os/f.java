package androidx.core.os;

import android.os.CancellationSignal;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f4652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4654d;

    @v0(16)
    public static class a {
        @g.u
        public static void a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        @g.u
        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    public interface b {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            if (this.f4651a) {
                return;
            }
            this.f4651a = true;
            this.f4654d = true;
            b bVar = this.f4652b;
            Object obj = this.f4653c;
            if (bVar != null) {
                try {
                    bVar.onCancel();
                } catch (Throwable th2) {
                    synchronized (this) {
                        this.f4654d = false;
                        notifyAll();
                        throw th2;
                    }
                }
            }
            if (obj != null) {
                a.a(obj);
            }
            synchronized (this) {
                this.f4654d = false;
                notifyAll();
            }
        }
    }

    @p0
    public Object b() {
        Object obj;
        synchronized (this) {
            if (this.f4653c == null) {
                CancellationSignal cancellationSignalB = a.b();
                this.f4653c = cancellationSignalB;
                if (this.f4651a) {
                    a.a(cancellationSignalB);
                }
            }
            obj = this.f4653c;
        }
        return obj;
    }

    public boolean c() {
        boolean z10;
        synchronized (this) {
            z10 = this.f4651a;
        }
        return z10;
    }

    public void d(@p0 b bVar) {
        synchronized (this) {
            f();
            if (this.f4652b == bVar) {
                return;
            }
            this.f4652b = bVar;
            if (this.f4651a && bVar != null) {
                bVar.onCancel();
            }
        }
    }

    public void e() {
        if (c()) {
            throw new OperationCanceledException();
        }
    }

    public final void f() {
        while (this.f4654d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
