package gc;

import com.google.android.exoplayer2.Format;
import g.p0;
import hb.d0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface f {

    public interface a {
        d0 d(int i10, int i11);
    }

    boolean a(hb.l lVar) throws IOException;

    @p0
    Format[] b();

    void c(@p0 a aVar, long j10, long j11);

    @p0
    hb.e e();

    void release();
}
