package si;

import io.objectbox.sync.SyncCredentials;
import io.objectbox.sync.listener.SyncChangeListener;
import java.io.Closeable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.b
public interface e extends Closeable {
    boolean F();

    void J0(@Nullable ui.d dVar);

    boolean N1(long j10);

    boolean O1();

    void P1();

    boolean Q();

    long Q1();

    long X1();

    void b(@Nullable SyncChangeListener syncChangeListener);

    boolean b1();

    void c1(@Nullable ui.c cVar);

    @li.b
    boolean c2();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean e1();

    void i0(SyncCredentials syncCredentials);

    void p(@Nullable ui.e eVar);

    void p0(@Nullable ui.b bVar);

    @li.b
    b r(long j10, @Nullable String str);

    void start();

    void stop();

    String t1();

    long u0();

    long w0();

    void x(@Nullable ui.f fVar);
}
