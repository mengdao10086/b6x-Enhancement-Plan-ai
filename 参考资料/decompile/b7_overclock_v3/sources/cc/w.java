package cc;

import g.p0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface w {

    public interface a {
        void a(long j10, long j11, float f10);
    }

    void a(@p0 a aVar) throws InterruptedException, IOException;

    void cancel();

    void remove();
}
