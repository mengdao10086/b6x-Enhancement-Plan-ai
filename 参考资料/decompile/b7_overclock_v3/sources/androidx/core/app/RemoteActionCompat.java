package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.o;
import g.n0;
import g.u;
import g.v0;
import i2.e;

/* JADX INFO: loaded from: classes2.dex */
public final class RemoteActionCompat implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public IconCompat f4589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public CharSequence f4590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public CharSequence f4591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public PendingIntent f4592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f4593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean f4594f;

    @v0(26)
    public static class a {
        @u
        public static RemoteAction a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
            return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
        }

        @u
        public static PendingIntent b(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        @u
        public static CharSequence c(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        @u
        public static Icon d(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        @u
        public static CharSequence e(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        @u
        public static boolean f(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        @u
        public static void g(RemoteAction remoteAction, boolean z10) {
            remoteAction.setEnabled(z10);
        }
    }

    @v0(28)
    public static class b {
        @u
        public static void a(RemoteAction remoteAction, boolean z10) {
            remoteAction.setShouldShowIcon(z10);
        }

        @u
        public static boolean b(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }
    }

    public RemoteActionCompat(@n0 IconCompat iconCompat, @n0 CharSequence charSequence, @n0 CharSequence charSequence2, @n0 PendingIntent pendingIntent) {
        this.f4589a = (IconCompat) o.l(iconCompat);
        this.f4590b = (CharSequence) o.l(charSequence);
        this.f4591c = (CharSequence) o.l(charSequence2);
        this.f4592d = (PendingIntent) o.l(pendingIntent);
        this.f4593e = true;
        this.f4594f = true;
    }

    @n0
    @v0(26)
    public static RemoteActionCompat h(@n0 RemoteAction remoteAction) {
        o.l(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.n(a.d(remoteAction)), a.e(remoteAction), a.c(remoteAction), a.b(remoteAction));
        remoteActionCompat.n(a.f(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.o(b.b(remoteAction));
        }
        return remoteActionCompat;
    }

    @n0
    public PendingIntent i() {
        return this.f4592d;
    }

    @n0
    public CharSequence j() {
        return this.f4591c;
    }

    @n0
    public IconCompat k() {
        return this.f4589a;
    }

    @n0
    public CharSequence l() {
        return this.f4590b;
    }

    public boolean m() {
        return this.f4593e;
    }

    public void n(boolean z10) {
        this.f4593e = z10;
    }

    public void o(boolean z10) {
        this.f4594f = z10;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean p() {
        return this.f4594f;
    }

    @n0
    @v0(26)
    public RemoteAction q() {
        RemoteAction remoteActionA = a.a(this.f4589a.M(), this.f4590b, this.f4591c, this.f4592d);
        a.g(remoteActionA, m());
        if (Build.VERSION.SDK_INT >= 28) {
            b.a(remoteActionA, p());
        }
        return remoteActionA;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@n0 RemoteActionCompat remoteActionCompat) {
        o.l(remoteActionCompat);
        this.f4589a = remoteActionCompat.f4589a;
        this.f4590b = remoteActionCompat.f4590b;
        this.f4591c = remoteActionCompat.f4591c;
        this.f4592d = remoteActionCompat.f4592d;
        this.f4593e = remoteActionCompat.f4593e;
        this.f4594f = remoteActionCompat.f4594f;
    }
}
