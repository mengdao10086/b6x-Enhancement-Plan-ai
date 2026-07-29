package tt;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Runnable, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f51633a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f51634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f51635c;

    public b(c cVar) {
        this.f51634b = cVar;
    }

    @Override // tt.k
    public void a(p pVar, Object obj) {
        i iVarA = i.a(pVar, obj);
        synchronized (this) {
            this.f51633a.a(iVarA);
            if (!this.f51635c) {
                this.f51635c = true;
                this.f51634b.g().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVarC;
        while (true) {
            try {
                iVarC = this.f51633a.c(1000);
            } catch (InterruptedException e10) {
                this.f51634b.h().b(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e10);
                return;
            } finally {
                this.f51635c = false;
            }
            if (iVarC == null) {
                synchronized (this) {
                    iVarC = this.f51633a.b();
                    if (iVarC == null) {
                        return;
                    }
                    this.f51635c = false;
                }
            }
            this.f51634b.l(iVarC);
        }
    }
}
