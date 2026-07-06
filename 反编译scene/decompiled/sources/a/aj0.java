package a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aj0 f5612a = new aj0();

    public final boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        f92.d(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        f92.c(networkCapabilities, "connectivityManager.getN…(network) ?: return false");
        return networkCapabilities.hasTransport(1);
    }
}
