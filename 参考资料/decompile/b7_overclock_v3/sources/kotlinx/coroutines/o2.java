package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
public final class o2 extends kotlin.coroutines.a implements c2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final o2 f38922b = new o2();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final String f38923c = "NonCancellable can be used only as an argument for 'withContext', direct usages of its API are prohibited";

    public o2() {
        super(c2.f38296x2);
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void h2() {
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void i2() {
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void j2() {
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void k2() {
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void l2() {
    }

    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public static /* synthetic */ void m2() {
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    @yt.k
    public g1 F0(boolean z10, boolean z11, @yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        return p2.f38929a;
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    @yt.k
    public g1 L1(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        return p2.f38929a;
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    @yt.l
    public Object T(@yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    @yt.k
    public CancellationException Z() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        h(null);
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean d(Throwable th2) {
        return false;
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @yt.k
    public c2 d1(@yt.k c2 c2Var) {
        return c2.a.j(this, c2Var);
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    @yt.k
    public u f2(@yt.k w wVar) {
        return p2.f38929a;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public kotlin.sequences.m<c2> getChildren() {
        return SequencesKt__SequencesKt.g();
    }

    @Override // kotlinx.coroutines.c2
    @yt.l
    public c2 getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public void h(@yt.l CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.c2
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.c2
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.c2
    public boolean n() {
        return false;
    }

    @Override // kotlinx.coroutines.c2
    @yt.k
    public kotlinx.coroutines.selects.c s1() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.WARNING, message = f38923c)
    public boolean start() {
        return false;
    }

    @yt.k
    public String toString() {
        return "NonCancellable";
    }
}
