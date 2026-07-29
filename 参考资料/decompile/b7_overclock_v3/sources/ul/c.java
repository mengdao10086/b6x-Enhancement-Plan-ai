package ul;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import m0.k;
import rl.f;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0000\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b8\u00109J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J.\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0086\bø\u0001\u0000J8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0086\bø\u0001\u0000J\u0006\u0010\u0011\u001a\u00020\u0010J'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u000f\u0010\u0017\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\bH\u0016R\u001a\u0010\u001b\u001a\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010\"\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00102\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010&R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u0002058F¢\u0006\u0006\u001a\u0004\b6\u00101\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, d2 = {"Lul/c;", "", "Lul/a;", "task", "", "delayNanos", "Lkotlin/z1;", "n", "", "name", "Lkotlin/Function0;", "block", k.f40564b, "", "cancelable", "c", "Ljava/util/concurrent/CountDownLatch;", l.f16298a, "recurrence", "q", "(Lul/a;JZ)Z", "a", "u", "b", "()Z", "toString", "Lul/d;", "taskRunner", "Lul/d;", "k", "()Lul/d;", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "shutdown", "Z", j.f55230b, "t", "(Z)V", "activeTask", "Lul/a;", "e", "()Lul/a;", SsManifestParser.e.J, "(Lul/a;)V", "", "futureTasks", "Ljava/util/List;", "g", "()Ljava/util/List;", "cancelActiveTask", "f", an.aB, "", "i", "scheduledTasks", "<init>", "(Lul/d;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final d f52195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f52196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public ul.a f52198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final List<ul.a> f52199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f52200f;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lul/c$a;", "Lul/a;", "", "f", "Ljava/util/concurrent/CountDownLatch;", "latch", "Ljava/util/concurrent/CountDownLatch;", "i", "()Ljava/util/concurrent/CountDownLatch;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public final CountDownLatch f52201e;

        public a() {
            super(f0.C(f.f48804i, " awaitIdle"), false);
            this.f52201e = new CountDownLatch(1);
        }

        @Override // ul.a
        public long f() {
            this.f52201e.countDown();
            return -1L;
        }

        @yt.k
        public final CountDownLatch i() {
            return this.f52201e;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"ul/c$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f52202e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f52203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ik.a<z1> f52204g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, boolean z10, ik.a<z1> aVar) {
            super(str, z10);
            this.f52202e = str;
            this.f52203f = z10;
            this.f52204g = aVar;
        }

        @Override // ul.a
        public long f() {
            this.f52204g.o();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: ul.c$c, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"ul/c$c", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0604c extends ul.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f52205e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ik.a<Long> f52206f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0604c(String str, ik.a<Long> aVar) {
            super(str, false, 2, null);
            this.f52205e = str;
            this.f52206f = aVar;
        }

        @Override // ul.a
        public long f() {
            return this.f52206f.o().longValue();
        }
    }

    public c(@yt.k d taskRunner, @yt.k String name) {
        f0.p(taskRunner, "taskRunner");
        f0.p(name, "name");
        this.f52195a = taskRunner;
        this.f52196b = name;
        this.f52199e = new ArrayList();
    }

    public static /* synthetic */ void d(c cVar, String name, long j10, boolean z10, ik.a block, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        f0.p(name, "name");
        f0.p(block, "block");
        cVar.n(new b(name, z10, block), j10);
    }

    public static /* synthetic */ void o(c cVar, String name, long j10, ik.a block, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        f0.p(name, "name");
        f0.p(block, "block");
        cVar.n(new C0604c(name, block), j10);
    }

    public static /* synthetic */ void p(c cVar, ul.a aVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        cVar.n(aVar, j10);
    }

    public final void a() {
        if (f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f52195a) {
            if (b()) {
                k().i(this);
            }
            z1 z1Var = z1.f38230a;
        }
    }

    public final boolean b() {
        ul.a aVar = this.f52198d;
        if (aVar != null) {
            f0.m(aVar);
            if (aVar.a()) {
                this.f52200f = true;
            }
        }
        boolean z10 = false;
        int size = this.f52199e.size() - 1;
        if (size >= 0) {
            while (true) {
                int i10 = size - 1;
                if (this.f52199e.get(size).a()) {
                    ul.a aVar2 = this.f52199e.get(size);
                    if (d.f52207h.a().isLoggable(Level.FINE)) {
                        ul.b.c(aVar2, this, "canceled");
                    }
                    this.f52199e.remove(size);
                    z10 = true;
                }
                if (i10 < 0) {
                    break;
                }
                size = i10;
            }
        }
        return z10;
    }

    public final void c(@yt.k String name, long j10, boolean z10, @yt.k ik.a<z1> block) {
        f0.p(name, "name");
        f0.p(block, "block");
        n(new b(name, z10, block), j10);
    }

    @yt.l
    public final ul.a e() {
        return this.f52198d;
    }

    public final boolean f() {
        return this.f52200f;
    }

    @yt.k
    public final List<ul.a> g() {
        return this.f52199e;
    }

    @yt.k
    public final String h() {
        return this.f52196b;
    }

    @yt.k
    public final List<ul.a> i() {
        List<ul.a> listQ5;
        synchronized (this.f52195a) {
            listQ5 = CollectionsKt___CollectionsKt.Q5(g());
        }
        return listQ5;
    }

    public final boolean j() {
        return this.f52197c;
    }

    @yt.k
    public final d k() {
        return this.f52195a;
    }

    @yt.k
    public final CountDownLatch l() {
        synchronized (this.f52195a) {
            if (e() == null && g().isEmpty()) {
                return new CountDownLatch(0);
            }
            ul.a aVarE = e();
            if (aVarE instanceof a) {
                return ((a) aVarE).i();
            }
            for (ul.a aVar : g()) {
                if (aVar instanceof a) {
                    return ((a) aVar).i();
                }
            }
            a aVar2 = new a();
            if (q(aVar2, 0L, false)) {
                k().i(this);
            }
            return aVar2.i();
        }
    }

    public final void m(@yt.k String name, long j10, @yt.k ik.a<Long> block) {
        f0.p(name, "name");
        f0.p(block, "block");
        n(new C0604c(name, block), j10);
    }

    public final void n(@yt.k ul.a task, long j10) {
        f0.p(task, "task");
        synchronized (this.f52195a) {
            if (!j()) {
                if (q(task, j10, false)) {
                    k().i(this);
                }
                z1 z1Var = z1.f38230a;
            } else if (task.a()) {
                if (d.f52207h.a().isLoggable(Level.FINE)) {
                    ul.b.c(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (d.f52207h.a().isLoggable(Level.FINE)) {
                    ul.b.c(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean q(@yt.k ul.a task, long j10, boolean z10) {
        f0.p(task, "task");
        task.e(this);
        long jD = this.f52195a.h().d();
        long j11 = jD + j10;
        int iIndexOf = this.f52199e.indexOf(task);
        if (iIndexOf != -1) {
            if (task.c() <= j11) {
                if (d.f52207h.a().isLoggable(Level.FINE)) {
                    ul.b.c(task, this, "already scheduled");
                }
                return false;
            }
            this.f52199e.remove(iIndexOf);
        }
        task.g(j11);
        if (d.f52207h.a().isLoggable(Level.FINE)) {
            ul.b.c(task, this, z10 ? f0.C("run again after ", ul.b.b(j11 - jD)) : f0.C("scheduled after ", ul.b.b(j11 - jD)));
        }
        Iterator<ul.a> it2 = this.f52199e.iterator();
        int size = 0;
        while (true) {
            if (!it2.hasNext()) {
                size = -1;
                break;
            }
            if (it2.next().c() - jD > j10) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f52199e.size();
        }
        this.f52199e.add(size, task);
        return size == 0;
    }

    public final void r(@yt.l ul.a aVar) {
        this.f52198d = aVar;
    }

    public final void s(boolean z10) {
        this.f52200f = z10;
    }

    public final void t(boolean z10) {
        this.f52197c = z10;
    }

    @yt.k
    public String toString() {
        return this.f52196b;
    }

    public final void u() {
        if (f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this.f52195a) {
            t(true);
            if (b()) {
                k().i(this);
            }
            z1 z1Var = z1.f38230a;
        }
    }
}
