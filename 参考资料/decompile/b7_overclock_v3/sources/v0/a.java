package v0;

import android.graphics.Typeface;
import android.os.Handler;
import g.n0;
import v0.g;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final h.d f52451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Handler f52452b;

    /* JADX INFO: renamed from: v0.a$a, reason: collision with other inner class name */
    public class RunnableC0608a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.d f52453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f52454b;

        public RunnableC0608a(h.d dVar, Typeface typeface) {
            this.f52453a = dVar;
            this.f52454b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f52453a.b(this.f52454b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h.d f52456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f52457b;

        public b(h.d dVar, int i10) {
            this.f52456a = dVar;
            this.f52457b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f52456a.a(this.f52457b);
        }
    }

    public a(@n0 h.d dVar, @n0 Handler handler) {
        this.f52451a = dVar;
        this.f52452b = handler;
    }

    public final void a(int i10) {
        this.f52452b.post(new b(this.f52451a, i10));
    }

    public void b(@n0 g.e eVar) {
        if (eVar.a()) {
            c(eVar.f52483a);
        } else {
            a(eVar.f52484b);
        }
    }

    public final void c(@n0 Typeface typeface) {
        this.f52452b.post(new RunnableC0608a(this.f52451a, typeface));
    }

    public a(@n0 h.d dVar) {
        this.f52451a = dVar;
        this.f52452b = v0.b.a();
    }
}
