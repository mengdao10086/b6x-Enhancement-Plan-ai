package s4;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class l extends e<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RemoteViews f49488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f49489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f49490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f49491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Notification f49492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f49493i;

    public l(Context context, int i10, RemoteViews remoteViews, Notification notification, int i11) {
        this(context, i10, remoteViews, notification, i11, null);
    }

    @Override // s4.p
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void g(@n0 Bitmap bitmap, @p0 t4.f<? super Bitmap> fVar) {
        e(bitmap);
    }

    public final void e(@p0 Bitmap bitmap) {
        this.f49488d.setImageViewBitmap(this.f49493i, bitmap);
        h();
    }

    public final void h() {
        ((NotificationManager) v4.m.d((NotificationManager) this.f49489e.getSystemService("notification"))).notify(this.f49491g, this.f49490f, this.f49492h);
    }

    @Override // s4.p
    public void s(@p0 Drawable drawable) {
        e(null);
    }

    public l(Context context, int i10, RemoteViews remoteViews, Notification notification, int i11, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i10, remoteViews, notification, i11, str);
    }

    public l(Context context, int i10, int i11, int i12, RemoteViews remoteViews, Notification notification, int i13, String str) {
        super(i10, i11);
        this.f49489e = (Context) v4.m.e(context, "Context must not be null!");
        this.f49492h = (Notification) v4.m.e(notification, "Notification object can not be null!");
        this.f49488d = (RemoteViews) v4.m.e(remoteViews, "RemoteViews object can not be null!");
        this.f49493i = i12;
        this.f49490f = i13;
        this.f49491g = str;
    }
}
