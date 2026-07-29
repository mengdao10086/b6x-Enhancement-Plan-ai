package gb;

import com.google.android.exoplayer2.drm.DrmSession;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i {
    public static boolean a(DrmSession drmSession) {
        return false;
    }

    public static void b(@p0 DrmSession drmSession, @p0 DrmSession drmSession2) {
        if (drmSession == drmSession2) {
            return;
        }
        if (drmSession2 != null) {
            drmSession2.e(null);
        }
        if (drmSession != null) {
            drmSession.f(null);
        }
    }
}
