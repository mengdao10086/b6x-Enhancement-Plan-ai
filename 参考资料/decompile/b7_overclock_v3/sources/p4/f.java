package p4;

import android.content.Context;
import android.util.Log;
import g.n0;
import p4.c;

/* JADX INFO: loaded from: classes2.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46366a = "ConnectivityMonitor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f46367b = "android.permission.ACCESS_NETWORK_STATE";

    @Override // p4.d
    @n0
    public c a(@n0 Context context, @n0 c.a aVar) {
        boolean z10 = h0.d.a(context, f46367b) == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        return z10 ? new e(context, aVar) : new n();
    }
}
