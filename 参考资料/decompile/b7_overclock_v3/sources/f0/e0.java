package f0;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import g.n0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 {

    @v0(16)
    public static class a {
        @g.u
        @n0
        public static PendingIntent a(@n0 Context context, int i10, @SuppressLint({"ArrayReturn"}) @n0 Intent[] intentArr, int i11, @n0 Bundle bundle) {
            return PendingIntent.getActivities(context, i10, intentArr, i11, bundle);
        }

        @g.u
        @n0
        public static PendingIntent b(@n0 Context context, int i10, @n0 Intent intent, int i11, @n0 Bundle bundle) {
            return PendingIntent.getActivity(context, i10, intent, i11, bundle);
        }
    }

    @v0(26)
    public static class b {
        @g.u
        public static PendingIntent a(Context context, int i10, Intent intent, int i11) {
            return PendingIntent.getForegroundService(context, i10, intent, i11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static int a(boolean z10, int i10) {
        int i11;
        if (z10) {
            if (Build.VERSION.SDK_INT < 31) {
                return i10;
            }
            i11 = CommonNetImpl.FLAG_SHARE_JUMP;
        } else {
            if (Build.VERSION.SDK_INT < 23) {
                return i10;
            }
            i11 = 67108864;
        }
        return i10 | i11;
    }

    @n0
    public static PendingIntent b(@n0 Context context, int i10, @SuppressLint({"ArrayReturn"}) @n0 Intent[] intentArr, int i11, @n0 Bundle bundle, boolean z10) {
        return a.a(context, i10, intentArr, a(z10, i11), bundle);
    }

    @n0
    public static PendingIntent c(@n0 Context context, int i10, @SuppressLint({"ArrayReturn"}) @n0 Intent[] intentArr, int i11, boolean z10) {
        return PendingIntent.getActivities(context, i10, intentArr, a(z10, i11));
    }

    @n0
    public static PendingIntent d(@n0 Context context, int i10, @n0 Intent intent, int i11, @n0 Bundle bundle, boolean z10) {
        return a.b(context, i10, intent, a(z10, i11), bundle);
    }

    @n0
    public static PendingIntent e(@n0 Context context, int i10, @n0 Intent intent, int i11, boolean z10) {
        return PendingIntent.getActivity(context, i10, intent, a(z10, i11));
    }

    @n0
    public static PendingIntent f(@n0 Context context, int i10, @n0 Intent intent, int i11, boolean z10) {
        return PendingIntent.getBroadcast(context, i10, intent, a(z10, i11));
    }

    @n0
    @v0(26)
    public static PendingIntent g(@n0 Context context, int i10, @n0 Intent intent, int i11, boolean z10) {
        return b.a(context, i10, intent, a(z10, i11));
    }

    @n0
    public static PendingIntent h(@n0 Context context, int i10, @n0 Intent intent, int i11, boolean z10) {
        return PendingIntent.getService(context, i10, intent, a(z10, i11));
    }
}
