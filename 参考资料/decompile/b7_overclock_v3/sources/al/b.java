package al;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.s1;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final b f727i = new b();

    public b() {
        super(m.f751c, m.f752d, m.f753e, m.f749a);
    }

    @Override // al.g, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        r.a(i10);
        return i10 >= m.f751c ? this : super.k2(i10);
    }

    public final void s2() {
        super.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        return "Dispatchers.Default";
    }
}
