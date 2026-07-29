package em;

import java.io.EOFException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.j;
import qk.v;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, d2 = {"Lokio/j;", "", "a", "okhttp-logging-interceptor"}, k = 2, mv = {1, 6, 0})
public final class b {
    public static final boolean a(@k j jVar) {
        f0.p(jVar, "<this>");
        try {
            j jVar2 = new j();
            jVar.u(jVar2, 0L, v.C(jVar.m2(), 64L));
            int i10 = 0;
            while (i10 < 16) {
                i10++;
                if (jVar2.d0()) {
                    return true;
                }
                int iU0 = jVar2.U0();
                if (Character.isISOControl(iU0) && !Character.isWhitespace(iU0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
