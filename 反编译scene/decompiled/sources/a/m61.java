package a;

import android.content.Context;
import android.os.BatteryManager;
import com.omarea.Scene;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m61 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BatteryManager f1894a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k61 f6775a = new k61(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z32 f1891a = a42.a(i61.f6380a);
    public static final z32 b = a42.a(j61.f6480a);
    public static final z32 c = a42.a(h61.f6281a);

    public m61(Context context) {
        f92.d(context, "context");
        this.f1893a = context;
        Object systemService = context.getSystemService("batterymanager");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
        }
        this.f1894a = (BatteryManager) systemService;
    }

    public static /* synthetic */ void i(m61 m61Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        m61Var.h(z);
    }

    public final void h(boolean z) {
        if ((z || !Scene.f4798a.g().contains(f6775a.d())) && !f1892a) {
            f1892a = true;
            m92 m92Var = new m92();
            m92Var.f6785a = k();
            ArrayList arrayList = new ArrayList();
            l92 l92Var = new l92();
            l92Var.f6687a = 0;
            qc2.d(xd2.a(qe2.b()), null, null, new l61(this, m92Var, l92Var, arrayList, null), 3, null);
        }
    }

    public final int j(long j) {
        boolean zM = fa0.f867a.m();
        int i = -1;
        if ((!zM || j <= 0) && (zM || j >= 0)) {
            i = 1;
        }
        long jAbs = Math.abs(k());
        while (jAbs > (zM ? 10000 : 60000)) {
            jAbs /= (long) 1000;
            i *= 1000;
        }
        return i;
    }

    public final long k() {
        return this.f1894a.getLongProperty(2);
    }
}
