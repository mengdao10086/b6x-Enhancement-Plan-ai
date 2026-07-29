package fd;

import android.net.Uri;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k {
    public static long a(l lVar) {
        return lVar.b(l.f28116c, -1L);
    }

    @p0
    public static Uri b(l lVar) {
        String strA = lVar.a(l.f28115b, null);
        if (strA == null) {
            return null;
        }
        return Uri.parse(strA);
    }
}
