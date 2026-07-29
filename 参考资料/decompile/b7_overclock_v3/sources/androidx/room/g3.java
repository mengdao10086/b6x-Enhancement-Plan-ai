package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class g3 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f7385b = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f7386c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f7387a;

        public a(Runnable runnable) {
            this.f7387a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f7387a.run();
            } finally {
                g3.this.a();
            }
        }
    }

    public g3(@g.n0 Executor executor) {
        this.f7384a = executor;
    }

    public synchronized void a() {
        Runnable runnablePoll = this.f7385b.poll();
        this.f7386c = runnablePoll;
        if (runnablePoll != null) {
            this.f7384a.execute(runnablePoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f7385b.offer(new a(runnable));
        if (this.f7386c == null) {
            a();
        }
    }
}
