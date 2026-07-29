package hd;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import g.c1;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30950a = -1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30951b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30952c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f30953d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f30954e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f30955f = 4;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Deprecated
    public static void a(Context context, String str, @c1 int i10, int i11) {
        b(context, str, i10, 0, i11);
    }

    public static void b(Context context, String str, @c1 int i10, @c1 int i11, int i12) {
        if (u0.f31154a >= 26) {
            NotificationManager notificationManager = (NotificationManager) hd.a.g((NotificationManager) context.getSystemService("notification"));
            NotificationChannel notificationChannel = new NotificationChannel(str, context.getString(i10), i12);
            if (i11 != 0) {
                notificationChannel.setDescription(context.getString(i11));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static void c(Context context, int i10, @g.p0 Notification notification) {
        NotificationManager notificationManager = (NotificationManager) hd.a.g((NotificationManager) context.getSystemService("notification"));
        if (notification != null) {
            notificationManager.notify(i10, notification);
        } else {
            notificationManager.cancel(i10);
        }
    }
}
