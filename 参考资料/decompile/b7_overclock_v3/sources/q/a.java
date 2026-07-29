package q;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.n;
import g.h1;
import g.i0;
import g.n0;
import g.p0;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f47074e = "AsyncLayoutInflater";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f47075a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler.Callback f47078d = new C0539a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f47076b = new Handler(this.f47078d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f47077c = d.b();

    /* JADX INFO: renamed from: q.a$a, reason: collision with other inner class name */
    public class C0539a implements Handler.Callback {
        public C0539a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            c cVar = (c) message.obj;
            if (cVar.f47084d == null) {
                cVar.f47084d = a.this.f47075a.inflate(cVar.f47083c, cVar.f47082b, false);
            }
            cVar.f47085e.a(cVar.f47084d, cVar.f47083c, cVar.f47082b);
            a.this.f47077c.d(cVar);
            return true;
        }
    }

    public static class b extends LayoutInflater {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f47080a = {"android.widget.", "android.webkit.", "android.app."};

        public b(Context context) {
            super(context);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context context) {
            return new b(context);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String str, AttributeSet attributeSet) throws ClassNotFoundException {
            View viewCreateView;
            for (String str2 : f47080a) {
                try {
                    viewCreateView = createView(str, str2, attributeSet);
                } catch (ClassNotFoundException unused) {
                }
                if (viewCreateView != null) {
                    return viewCreateView;
                }
            }
            return super.onCreateView(str, attributeSet);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f47081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ViewGroup f47082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f47083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f47084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f47085e;
    }

    public static class d extends Thread {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f47086c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayBlockingQueue<c> f47087a = new ArrayBlockingQueue<>(10);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public n.c<c> f47088b = new n.c<>(10);

        static {
            d dVar = new d();
            f47086c = dVar;
            dVar.start();
        }

        public static d b() {
            return f47086c;
        }

        public void a(c cVar) {
            try {
                this.f47087a.put(cVar);
            } catch (InterruptedException e10) {
                throw new RuntimeException("Failed to enqueue async inflate request", e10);
            }
        }

        public c c() {
            c cVarA = this.f47088b.a();
            return cVarA == null ? new c() : cVarA;
        }

        public void d(c cVar) {
            cVar.f47085e = null;
            cVar.f47081a = null;
            cVar.f47082b = null;
            cVar.f47083c = 0;
            cVar.f47084d = null;
            this.f47088b.b(cVar);
        }

        public void e() {
            try {
                c cVarTake = this.f47087a.take();
                try {
                    cVarTake.f47084d = cVarTake.f47081a.f47075a.inflate(cVarTake.f47083c, cVarTake.f47082b, false);
                } catch (RuntimeException unused) {
                }
                Message.obtain(cVarTake.f47081a.f47076b, 0, cVarTake).sendToTarget();
            } catch (InterruptedException unused2) {
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                e();
            }
        }
    }

    public interface e {
        void a(@n0 View view, @i0 int i10, @p0 ViewGroup viewGroup);
    }

    public a(@n0 Context context) {
        this.f47075a = new b(context);
    }

    @h1
    public void a(@i0 int i10, @p0 ViewGroup viewGroup, @n0 e eVar) {
        Objects.requireNonNull(eVar, "callback argument may not be null!");
        c cVarC = this.f47077c.c();
        cVarC.f47081a = this;
        cVarC.f47083c = i10;
        cVarC.f47082b = viewGroup;
        cVarC.f47085e = eVar;
        this.f47077c.a(cVarC);
    }
}
