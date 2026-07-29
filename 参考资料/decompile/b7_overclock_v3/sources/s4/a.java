package s4;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f49454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ComponentName f49455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RemoteViews f49456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f49457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f49458h;

    public a(Context context, int i10, int i11, int i12, RemoteViews remoteViews, int... iArr) {
        super(i10, i11);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.f49457g = (Context) v4.m.e(context, "Context can not be null!");
        this.f49456f = (RemoteViews) v4.m.e(remoteViews, "RemoteViews object can not be null!");
        this.f49454d = (int[]) v4.m.e(iArr, "WidgetIds can not be null!");
        this.f49458h = i12;
        this.f49455e = null;
    }

    @Override // s4.p
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void g(@n0 Bitmap bitmap, @p0 t4.f<? super Bitmap> fVar) {
        e(bitmap);
    }

    public final void e(@p0 Bitmap bitmap) {
        this.f49456f.setImageViewBitmap(this.f49458h, bitmap);
        h();
    }

    public final void h() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f49457g);
        ComponentName componentName = this.f49455e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f49456f);
        } else {
            appWidgetManager.updateAppWidget(this.f49454d, this.f49456f);
        }
    }

    @Override // s4.p
    public void s(@p0 Drawable drawable) {
        e(null);
    }

    public a(Context context, int i10, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i10, remoteViews, iArr);
    }

    public a(Context context, int i10, int i11, int i12, RemoteViews remoteViews, ComponentName componentName) {
        super(i10, i11);
        this.f49457g = (Context) v4.m.e(context, "Context can not be null!");
        this.f49456f = (RemoteViews) v4.m.e(remoteViews, "RemoteViews object can not be null!");
        this.f49455e = (ComponentName) v4.m.e(componentName, "ComponentName can not be null!");
        this.f49458h = i12;
        this.f49454d = null;
    }

    public a(Context context, int i10, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i10, remoteViews, componentName);
    }
}
