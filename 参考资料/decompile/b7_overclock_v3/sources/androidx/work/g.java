package androidx.work;

import android.app.Notification;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Notification f8368c;

    public g(int notificationId, @n0 Notification notification) {
        this(notificationId, notification, 0);
    }

    public int a() {
        return this.f8367b;
    }

    @n0
    public Notification b() {
        return this.f8368c;
    }

    public int c() {
        return this.f8366a;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || g.class != o10.getClass()) {
            return false;
        }
        g gVar = (g) o10;
        if (this.f8366a == gVar.f8366a && this.f8367b == gVar.f8367b) {
            return this.f8368c.equals(gVar.f8368c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f8366a * 31) + this.f8367b) * 31) + this.f8368c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f8366a + ", mForegroundServiceType=" + this.f8367b + ", mNotification=" + this.f8368c + '}';
    }

    public g(int notificationId, @n0 Notification notification, int foregroundServiceType) {
        this.f8366a = notificationId;
        this.f8368c = notification;
        this.f8367b = foregroundServiceType;
    }
}
