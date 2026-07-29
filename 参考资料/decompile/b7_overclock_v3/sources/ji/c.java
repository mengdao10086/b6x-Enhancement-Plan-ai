package ji;

import android.os.Handler;
import android.os.Looper;
import g.n0;
import java.util.ArrayDeque;
import java.util.Deque;
import pi.j;
import pi.k;

/* JADX INFO: loaded from: classes5.dex */
public class c extends Handler implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f36419b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deque<a> f36420a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public j<Object> f36421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f36422b;

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f36421a.a(this.f36422b);
            this.f36421a = null;
            this.f36422b = null;
            synchronized (c.this.f36420a) {
                if (c.this.f36420a.size() < 20) {
                    c.this.f36420a.add(this);
                }
            }
        }
    }

    public c(Looper looper) {
        super(looper);
        this.f36420a = new ArrayDeque();
    }

    public static synchronized k c() {
        if (f36419b == null) {
            f36419b = new c(Looper.getMainLooper());
        }
        return f36419b;
    }

    @Override // pi.k
    public <T> void a(@n0 j<T> jVar, @n0 T t10) {
        a aVarPoll;
        synchronized (this.f36420a) {
            aVarPoll = this.f36420a.poll();
        }
        if (aVarPoll == null) {
            aVarPoll = new a();
        }
        aVarPoll.f36421a = jVar;
        aVarPoll.f36422b = t10;
        post(aVarPoll);
    }
}
