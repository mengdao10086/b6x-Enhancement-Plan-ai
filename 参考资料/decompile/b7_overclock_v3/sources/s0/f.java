package s0;

import android.location.Location;
import android.os.Bundle;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f {
    public static void a(g gVar, int i10) {
    }

    public static void b(g gVar, @n0 List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            gVar.onLocationChanged((Location) list.get(i10));
        }
    }

    public static void c(g gVar, @n0 String str) {
    }

    public static void d(g gVar, @n0 String str) {
    }

    public static void e(g gVar, @n0 String str, int i10, @p0 Bundle bundle) {
    }
}
