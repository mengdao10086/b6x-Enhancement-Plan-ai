package v2;

import g.i1;
import g.n0;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f52589b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Runnable f52591d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<a> f52588a = new ArrayDeque<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f52590c = new Object();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f52592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f52593b;

        public a(@n0 j serialExecutor, @n0 Runnable runnable) {
            this.f52592a = serialExecutor;
            this.f52593b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f52593b.run();
            } finally {
                this.f52592a.c();
            }
        }
    }

    public j(@n0 Executor executor) {
        this.f52589b = executor;
    }

    @i1
    @n0
    public Executor a() {
        return this.f52589b;
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f52590c) {
            z10 = !this.f52588a.isEmpty();
        }
        return z10;
    }

    public void c() {
        synchronized (this.f52590c) {
            a aVarPoll = this.f52588a.poll();
            this.f52591d = aVarPoll;
            if (aVarPoll != null) {
                this.f52589b.execute(this.f52591d);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@n0 Runnable command) {
        synchronized (this.f52590c) {
            this.f52588a.add(new a(this, command));
            if (this.f52591d == null) {
                c();
            }
        }
    }
}
