package gc;

import java.io.IOException;
import java.util.List;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public interface i {
    void a() throws IOException;

    long c(long j10, t1 t1Var);

    void d(e eVar);

    boolean e(long j10, e eVar, List<? extends m> list);

    boolean h(e eVar, boolean z10, Exception exc, long j10);

    int i(long j10, List<? extends m> list);

    void j(long j10, long j11, List<? extends m> list, g gVar);

    void release();
}
