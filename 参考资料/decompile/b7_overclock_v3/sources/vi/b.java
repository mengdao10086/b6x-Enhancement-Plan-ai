package vi;

import io.objectbox.sync.listener.SyncChangeListener;
import java.io.Closeable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.b
public interface b extends Closeable {
    void b(@Nullable SyncChangeListener syncChangeListener);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getPort();

    boolean isRunning();

    String m0();

    void start();

    void stop();

    String x0();
}
