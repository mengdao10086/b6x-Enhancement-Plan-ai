package a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public mb f2036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ob f2037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zb f2038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Notification f2039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PendingIntent f2040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f2042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Icon f2043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f2044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RemoteViews f2045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<jb> f2048a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence[] f2050a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Notification f2051b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PendingIntent f2052b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RemoteViews f2053b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f2054b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f2055b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<tb> f2056b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2057b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public RemoteViews f2058c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f2059c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f2060c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ArrayList<jb> f2061c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2062c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public RemoteViews f2063d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f2064d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f2065d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Deprecated
    public ArrayList<String> f2066d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2067d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public CharSequence f2068e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f2069e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2070e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2071f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f2072g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f2073h;
    public boolean i;

    @Deprecated
    public nb(Context context) {
        this(context, null);
    }

    public nb(Context context, String str) {
        this.f2048a = new ArrayList<>();
        this.f2056b = new ArrayList<>();
        this.f2061c = new ArrayList<>();
        this.f2049a = true;
        this.f2070e = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        Notification notification = new Notification();
        this.f2051b = notification;
        this.f2041a = context;
        this.f2065d = str;
        notification.when = System.currentTimeMillis();
        this.f2051b.audioStreamType = -1;
        this.b = 0;
        this.f2066d = new ArrayList<>();
        this.f2073h = true;
    }

    public static CharSequence c(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification a() {
        return new qb(this).b();
    }

    public Bundle b() {
        if (this.f2044a == null) {
            this.f2044a = new Bundle();
        }
        return this.f2044a;
    }

    public nb d(boolean z) {
        i(16, z);
        return this;
    }

    public nb e(PendingIntent pendingIntent) {
        this.f2040a = pendingIntent;
        return this;
    }

    public nb f(CharSequence charSequence) {
        this.f2054b = c(charSequence);
        return this;
    }

    public nb g(CharSequence charSequence) {
        this.f2046a = c(charSequence);
        return this;
    }

    public nb h(RemoteViews remoteViews) {
        this.f2053b = remoteViews;
        return this;
    }

    public final void i(int i, boolean z) {
        Notification notification;
        int i2;
        if (z) {
            notification = this.f2051b;
            i2 = i | notification.flags;
        } else {
            notification = this.f2051b;
            i2 = (~i) & notification.flags;
        }
        notification.flags = i2;
    }

    public nb j(boolean z) {
        i(2, z);
        return this;
    }

    public nb k(int i, int i2, boolean z) {
        this.c = i;
        this.d = i2;
        this.f2062c = z;
        return this;
    }

    public nb l(boolean z) {
        this.f2049a = z;
        return this;
    }

    public nb m(boolean z) {
        this.i = z;
        return this;
    }

    public nb n(int i) {
        this.f2051b.icon = i;
        return this;
    }

    public nb o(Uri uri) {
        Notification notification = this.f2051b;
        notification.sound = uri;
        notification.audioStreamType = -1;
        if (Build.VERSION.SDK_INT >= 21) {
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        }
        return this;
    }

    public nb p(long j) {
        this.f2051b.when = j;
        return this;
    }
}
