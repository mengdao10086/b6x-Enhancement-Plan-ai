package hd;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f30984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f30985b;

    public f() {
        this(c.f30965a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f30985b) {
            wait();
        }
    }

    public synchronized boolean b(long j10) throws InterruptedException {
        if (j10 <= 0) {
            return this.f30985b;
        }
        long jE = this.f30984a.e();
        long j11 = j10 + jE;
        if (j11 < jE) {
            a();
        } else {
            while (!this.f30985b && jE < j11) {
                wait(j11 - jE);
                jE = this.f30984a.e();
            }
        }
        return this.f30985b;
    }

    public synchronized void c() {
        boolean z10 = false;
        while (!this.f30985b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z10 = true;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z10;
        z10 = this.f30985b;
        this.f30985b = false;
        return z10;
    }

    public synchronized boolean e() {
        return this.f30985b;
    }

    public synchronized boolean f() {
        if (this.f30985b) {
            return false;
        }
        this.f30985b = true;
        notifyAll();
        return true;
    }

    public f(c cVar) {
        this.f30984a = cVar;
    }
}
