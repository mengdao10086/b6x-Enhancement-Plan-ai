package u0;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import g.y0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f51785a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f51786b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f51787c = 3;

    /* JADX INFO: renamed from: u0.a$a, reason: collision with other inner class name */
    @v0(16)
    public static class C0594a {
        @u
        @y0(p4.f.f46367b)
        public static boolean a(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    @v0(24)
    public static class b {
        @u
        public static int a(ConnectivityManager connectivityManager) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    @p0
    @y0(p4.f.f46367b)
    @SuppressLint({"ReferencesDeprecated"})
    public static NetworkInfo a(@n0 ConnectivityManager connectivityManager, @n0 Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    public static int b(@n0 ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.a(connectivityManager);
        }
        return 3;
    }

    @y0(p4.f.f46367b)
    public static boolean c(@n0 ConnectivityManager connectivityManager) {
        return C0594a.a(connectivityManager);
    }
}
