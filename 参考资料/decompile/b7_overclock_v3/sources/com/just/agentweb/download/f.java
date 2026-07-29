package com.just.agentweb.download;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import f0.v;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f21949l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f21950m = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NotificationManager f21953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Notification f21954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v.n f21955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f21956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f21957g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f21959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public File f21960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v.b f21961k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21951a = (int) SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f21958h = false;

    public f(Context context, int i10) {
        this.f21957g = "";
        this.f21952b = i10;
        this.f21956f = context;
        this.f21953c = (NotificationManager) context.getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT < 26) {
                this.f21955e = new v.n(this.f21956f);
                return;
            }
            Context context2 = this.f21956f;
            String strConcat = context2.getPackageName().concat(" agentweb/4.0.1 ");
            this.f21957g = strConcat;
            this.f21955e = new v.n(context2, strConcat);
            ((NotificationManager) this.f21956f.getSystemService("notification")).createNotificationChannel(new NotificationChannel(this.f21957g, com.just.agentweb.a.q(context), 3));
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
            throw th2;
        }
    }

    public final PendingIntent a(Context context, int i10, String str) {
        Intent intent = new Intent(context, (Class<?>) NotificationCancelReceiver.class);
        intent.setAction(NotificationCancelReceiver.f21939a);
        intent.putExtra("TAG", str);
        int i11 = i10 << 3;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i11, intent, 134217728);
        c0.c(f21950m, "id<<3:" + i11);
        return broadcast;
    }

    public void b() {
        this.f21953c.cancel(this.f21952b);
    }

    public final boolean c() {
        return this.f21955e.x().deleteIntent != null;
    }

    public void d(DownloadTask downloadTask) {
        String string = TextUtils.isEmpty(downloadTask.l0().getName()) ? this.f21956f.getString(R.string.agentweb_file_download) : downloadTask.l0().getName();
        if (string.length() > 20) {
            string = "..." + string.substring(string.length() - 20, string.length());
        }
        this.f21955e.N(PendingIntent.getActivity(this.f21956f, 200, new Intent(), 134217728));
        this.f21955e.t0(downloadTask.Q());
        this.f21955e.B0(this.f21956f.getString(R.string.agentweb_trickter));
        this.f21955e.P(string);
        this.f21955e.O(this.f21956f.getString(R.string.agentweb_coming_soon_download));
        this.f21955e.H0(System.currentTimeMillis());
        this.f21955e.D(true);
        this.f21955e.k0(2);
        this.f21959i = downloadTask.m();
        this.f21960j = downloadTask.l0();
        this.f21955e.U(a(this.f21956f, downloadTask.m0(), downloadTask.m()));
        this.f21955e.T(0);
    }

    public void e() {
        int iIndexOf;
        try {
            Field declaredField = this.f21955e.getClass().getDeclaredField("mActions");
            ArrayList arrayList = declaredField != null ? (ArrayList) declaredField.get(this.f21955e) : null;
            if (arrayList != null && (iIndexOf = arrayList.indexOf(this.f21961k)) != -1) {
                arrayList.remove(iIndexOf);
            }
        } catch (Throwable th2) {
            if (c0.d()) {
                th2.printStackTrace();
            }
        }
        Intent intentS = com.just.agentweb.a.s(this.f21956f, this.f21960j);
        i(null);
        if (intentS != null) {
            if (!(this.f21956f instanceof Activity)) {
                intentS.addFlags(268435456);
            }
            PendingIntent activity = PendingIntent.getActivity(this.f21956f, this.f21952b << 4, intentS, 134217728);
            this.f21955e.O(this.f21956f.getString(R.string.agentweb_click_open));
            this.f21955e.l0(100, 100, false);
            this.f21955e.N(activity);
            h();
        }
    }

    public void f(int i10) {
        if (!c()) {
            i(a(this.f21956f, this.f21952b, this.f21959i));
        }
        if (!this.f21958h) {
            this.f21958h = true;
            v.b bVar = new v.b(R.drawable.ic_cancel_transparent_2dp, this.f21956f.getString(android.R.string.cancel), a(this.f21956f, this.f21952b, this.f21959i));
            this.f21961k = bVar;
            this.f21955e.b(bVar);
        }
        this.f21955e.O(this.f21956f.getString(R.string.agentweb_current_downloading_progress, i10 + i6.a.f31863g));
        j(100, i10, false);
        h();
    }

    public void g() {
        h();
    }

    public final void h() {
        Notification notificationH = this.f21955e.h();
        this.f21954d = notificationH;
        this.f21953c.notify(this.f21952b, notificationH);
    }

    public final void i(PendingIntent pendingIntent) {
        this.f21955e.x().deleteIntent = pendingIntent;
    }

    public final void j(int i10, int i11, boolean z10) {
        this.f21955e.l0(i10, i11, z10);
        h();
    }
}
