package ul;

import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lul/a;", "", "", "f", "Lul/c;", "queue", "Lkotlin/z1;", "e", "(Lul/c;)V", "", "toString", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "cancelable", "Z", "a", "()Z", "Lul/c;", "d", "()Lul/c;", "h", "nextExecuteNanoTime", "J", "c", "()J", "g", "(J)V", "<init>", "(Ljava/lang/String;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final String f52191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f52192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public c f52193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f52194d;

    public a(@k String name, boolean z10) {
        f0.p(name, "name");
        this.f52191a = name;
        this.f52192b = z10;
        this.f52194d = -1L;
    }

    public final boolean a() {
        return this.f52192b;
    }

    @k
    public final String b() {
        return this.f52191a;
    }

    public final long c() {
        return this.f52194d;
    }

    @l
    public final c d() {
        return this.f52193c;
    }

    public final void e(@k c queue) {
        f0.p(queue, "queue");
        c cVar = this.f52193c;
        if (cVar == queue) {
            return;
        }
        if (!(cVar == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f52193c = queue;
    }

    public abstract long f();

    public final void g(long j10) {
        this.f52194d = j10;
    }

    public final void h(@l c cVar) {
        this.f52193c = cVar;
    }

    @k
    public String toString() {
        return this.f52191a;
    }

    public /* synthetic */ a(String str, boolean z10, int i10, u uVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
