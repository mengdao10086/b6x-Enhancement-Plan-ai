package f0;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import f0.v;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class w implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f27874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f27875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v.n f27876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f27877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RemoteViews f27878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Bundle> f27879f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f27880g = new Bundle();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f27881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RemoteViews f27882i;

    @v0(16)
    public static class a {
        @g.u
        public static Notification a(Notification.Builder builder) {
            return builder.build();
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setPriority(i10);
        }

        @g.u
        public static Notification.Builder c(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }

        @g.u
        public static Notification.Builder d(Notification.Builder builder, boolean z10) {
            return builder.setUsesChronometer(z10);
        }
    }

    @v0(17)
    public static class b {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setShowWhen(z10);
        }
    }

    @v0(19)
    public static class c {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    @v0(20)
    public static class d {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @g.u
        public static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @g.u
        public static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @g.u
        public static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        @g.u
        public static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        @g.u
        public static String f(Notification notification) {
            return notification.getGroup();
        }

        @g.u
        public static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @g.u
        public static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        @g.u
        public static Notification.Builder i(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        @g.u
        public static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    @v0(21)
    public static class e {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @g.u
        public static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        @g.u
        public static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @g.u
        public static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @g.u
        public static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    @v0(23)
    public static class f {
        @g.u
        public static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    @v0(24)
    public static class g {
        @g.u
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @g.u
        public static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @g.u
        public static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @g.u
        public static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    @v0(26)
    public static class h {
        @g.u
        public static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        @g.u
        public static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        @g.u
        public static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        @g.u
        public static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @g.u
        public static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @g.u
        public static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    @v0(28)
    public static class i {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        @g.u
        public static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    @v0(29)
    public static class j {
        @g.u
        public static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @g.u
        public static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        @g.u
        public static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    @v0(31)
    public static class k {
        @g.u
        public static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        @g.u
        public static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    public w(v.n nVar) {
        int i10;
        Object obj;
        this.f27876c = nVar;
        Context context = nVar.f27749a;
        this.f27874a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f27875b = h.a(context, nVar.L);
        } else {
            this.f27875b = new Notification.Builder(nVar.f27749a);
        }
        Notification notification = nVar.U;
        this.f27875b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, nVar.f27757i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(nVar.f27753e).setContentText(nVar.f27754f).setContentInfo(nVar.f27759k).setContentIntent(nVar.f27755g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(nVar.f27756h, (notification.flags & 128) != 0).setLargeIcon(nVar.f27758j).setNumber(nVar.f27760l).setProgress(nVar.f27769u, nVar.f27770v, nVar.f27771w);
        a.b(a.d(a.c(this.f27875b, nVar.f27766r), nVar.f27763o), nVar.f27761m);
        Iterator<v.b> it2 = nVar.f27750b.iterator();
        while (it2.hasNext()) {
            b(it2.next());
        }
        Bundle bundle = nVar.E;
        if (bundle != null) {
            this.f27880g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f27877d = nVar.I;
        this.f27878e = nVar.J;
        b.a(this.f27875b, nVar.f27762n);
        d.i(this.f27875b, nVar.A);
        d.g(this.f27875b, nVar.f27772x);
        d.j(this.f27875b, nVar.f27774z);
        d.h(this.f27875b, nVar.f27773y);
        this.f27881h = nVar.Q;
        e.b(this.f27875b, nVar.D);
        e.c(this.f27875b, nVar.F);
        e.f(this.f27875b, nVar.G);
        e.d(this.f27875b, nVar.H);
        e.e(this.f27875b, notification.sound, notification.audioAttributes);
        List listE = i11 < 28 ? e(g(nVar.f27751c), nVar.X) : nVar.X;
        if (listE != null && !listE.isEmpty()) {
            Iterator it3 = listE.iterator();
            while (it3.hasNext()) {
                e.a(this.f27875b, (String) it3.next());
            }
        }
        this.f27882i = nVar.K;
        if (nVar.f27752d.size() > 0) {
            Bundle bundle2 = nVar.t().getBundle(v.p.f27791d);
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < nVar.f27752d.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), y.j(nVar.f27752d.get(i12)));
            }
            bundle2.putBundle(v.p.f27795h, bundle4);
            bundle3.putBundle(v.p.f27795h, bundle4);
            nVar.t().putBundle(v.p.f27791d, bundle2);
            this.f27880g.putBundle(v.p.f27791d, bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23 && (obj = nVar.W) != null) {
            f.b(this.f27875b, obj);
        }
        if (i13 >= 24) {
            c.a(this.f27875b, nVar.E);
            g.e(this.f27875b, nVar.f27768t);
            RemoteViews remoteViews = nVar.I;
            if (remoteViews != null) {
                g.c(this.f27875b, remoteViews);
            }
            RemoteViews remoteViews2 = nVar.J;
            if (remoteViews2 != null) {
                g.b(this.f27875b, remoteViews2);
            }
            RemoteViews remoteViews3 = nVar.K;
            if (remoteViews3 != null) {
                g.d(this.f27875b, remoteViews3);
            }
        }
        if (i13 >= 26) {
            h.b(this.f27875b, nVar.M);
            h.e(this.f27875b, nVar.f27767s);
            h.f(this.f27875b, nVar.N);
            h.g(this.f27875b, nVar.P);
            h.d(this.f27875b, nVar.Q);
            if (nVar.C) {
                h.c(this.f27875b, nVar.B);
            }
            if (!TextUtils.isEmpty(nVar.L)) {
                this.f27875b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i13 >= 28) {
            Iterator<f0> it4 = nVar.f27751c.iterator();
            while (it4.hasNext()) {
                i.a(this.f27875b, it4.next().k());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            j.a(this.f27875b, nVar.S);
            j.b(this.f27875b, v.m.k(nVar.T));
            h0.c0 c0Var = nVar.O;
            if (c0Var != null) {
                j.d(this.f27875b, c0Var.c());
            }
        }
        if (i14 >= 31 && (i10 = nVar.R) != 0) {
            k.b(this.f27875b, i10);
        }
        if (nVar.V) {
            if (this.f27876c.f27773y) {
                this.f27881h = 2;
            } else {
                this.f27881h = 1;
            }
            this.f27875b.setVibrate(null);
            this.f27875b.setSound(null);
            int i15 = notification.defaults & (-2) & (-3);
            notification.defaults = i15;
            this.f27875b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f27876c.f27772x)) {
                    d.g(this.f27875b, v.f27631e1);
                }
                h.d(this.f27875b, this.f27881h);
            }
        }
    }

    @p0
    public static List<String> e(@p0 List<String> list, @p0 List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.c cVar = new androidx.collection.c(list.size() + list2.size());
        cVar.addAll(list);
        cVar.addAll(list2);
        return new ArrayList(cVar);
    }

    @p0
    public static List<String> g(@p0 List<f0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<f0> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().j());
        }
        return arrayList;
    }

    @Override // f0.s
    public Notification.Builder a() {
        return this.f27875b;
    }

    public final void b(v.b bVar) {
        int i10 = Build.VERSION.SDK_INT;
        IconCompat iconCompatF = bVar.f();
        Notification.Action.Builder builderA = i10 >= 23 ? f.a(iconCompatF != null ? iconCompatF.M() : null, bVar.j(), bVar.a()) : d.e(iconCompatF != null ? iconCompatF.A() : 0, bVar.j(), bVar.a());
        if (bVar.g() != null) {
            for (RemoteInput remoteInput : h0.d(bVar.g())) {
                d.c(builderA, remoteInput);
            }
        }
        Bundle bundle = bVar.d() != null ? new Bundle(bVar.d()) : new Bundle();
        bundle.putBoolean(y.f27891c, bVar.b());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            g.a(builderA, bVar.b());
        }
        bundle.putInt(v.b.f27689y, bVar.h());
        if (i11 >= 28) {
            i.b(builderA, bVar.h());
        }
        if (i11 >= 29) {
            j.c(builderA, bVar.l());
        }
        if (i11 >= 31) {
            k.a(builderA, bVar.k());
        }
        bundle.putBoolean(v.b.f27688x, bVar.i());
        d.b(builderA, bundle);
        d.a(this.f27875b, d.d(builderA));
    }

    public Notification c() {
        Bundle bundleN;
        RemoteViews remoteViewsX;
        RemoteViews remoteViewsV;
        v.y yVar = this.f27876c.f27765q;
        if (yVar != null) {
            yVar.b(this);
        }
        RemoteViews remoteViewsW = yVar != null ? yVar.w(this) : null;
        Notification notificationD = d();
        if (remoteViewsW != null) {
            notificationD.contentView = remoteViewsW;
        } else {
            RemoteViews remoteViews = this.f27876c.I;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (yVar != null && (remoteViewsV = yVar.v(this)) != null) {
            notificationD.bigContentView = remoteViewsV;
        }
        if (yVar != null && (remoteViewsX = this.f27876c.f27765q.x(this)) != null) {
            notificationD.headsUpContentView = remoteViewsX;
        }
        if (yVar != null && (bundleN = v.n(notificationD)) != null) {
            yVar.a(bundleN);
        }
        return notificationD;
    }

    public Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return a.a(this.f27875b);
        }
        if (i10 >= 24) {
            Notification notificationA = a.a(this.f27875b);
            if (this.f27881h != 0) {
                if (d.f(notificationA) != null && (notificationA.flags & 512) != 0 && this.f27881h == 2) {
                    h(notificationA);
                }
                if (d.f(notificationA) != null && (notificationA.flags & 512) == 0 && this.f27881h == 1) {
                    h(notificationA);
                }
            }
            return notificationA;
        }
        c.a(this.f27875b, this.f27880g);
        Notification notificationA2 = a.a(this.f27875b);
        RemoteViews remoteViews = this.f27877d;
        if (remoteViews != null) {
            notificationA2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f27878e;
        if (remoteViews2 != null) {
            notificationA2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f27882i;
        if (remoteViews3 != null) {
            notificationA2.headsUpContentView = remoteViews3;
        }
        if (this.f27881h != 0) {
            if (d.f(notificationA2) != null && (notificationA2.flags & 512) != 0 && this.f27881h == 2) {
                h(notificationA2);
            }
            if (d.f(notificationA2) != null && (notificationA2.flags & 512) == 0 && this.f27881h == 1) {
                h(notificationA2);
            }
        }
        return notificationA2;
    }

    public Context f() {
        return this.f27874a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }
}
