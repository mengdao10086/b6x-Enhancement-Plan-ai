package a;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qb implements ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nb f2558a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Notification.Builder f2559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RemoteViews f2561a;
    public RemoteViews b;
    public RemoteViews c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Bundle> f2562a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f2560a = new Bundle();

    public qb(nb nbVar) {
        Icon icon;
        List<String> listD;
        Bundle bundle;
        String str;
        this.f2558a = nbVar;
        Context context = nbVar.f2041a;
        this.f2559a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(nbVar.f2041a, nbVar.f2065d) : new Notification.Builder(nbVar.f2041a);
        Notification notification = nbVar.f2051b;
        this.f2559a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, nbVar.f2045a).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(nbVar.f2046a).setContentText(nbVar.f2054b).setContentInfo(nbVar.f2059c).setContentIntent(nbVar.f2040a).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(nbVar.f2052b, (notification.flags & 128) != 0).setLargeIcon(nbVar.f2042a).setNumber(nbVar.f6895a).setProgress(nbVar.c, nbVar.d, nbVar.f2062c);
        if (Build.VERSION.SDK_INT < 21) {
            this.f2559a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f2559a.setSubText(nbVar.f2064d).setUsesChronometer(nbVar.f2057b).setPriority(nbVar.b);
            Iterator<jb> it = nbVar.f2048a.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle2 = nbVar.f2044a;
            if (bundle2 != null) {
                this.f2560a.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (nbVar.f2070e) {
                    this.f2560a.putBoolean("android.support.localOnly", true);
                }
                String str2 = nbVar.f2047a;
                if (str2 != null) {
                    this.f2560a.putString("android.support.groupKey", str2);
                    if (nbVar.f2067d) {
                        bundle = this.f2560a;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f2560a;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str3 = nbVar.f2055b;
                if (str3 != null) {
                    this.f2560a.putString("android.support.sortKey", str3);
                }
            }
            this.f2561a = nbVar.f2053b;
            this.b = nbVar.f2058c;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f2559a.setShowWhen(nbVar.f2049a);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 21 && (listD = d(e(nbVar.f2056b), nbVar.f2066d)) != null && !listD.isEmpty()) {
            this.f2560a.putStringArray("android.people", (String[]) listD.toArray(new String[listD.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f2559a.setLocalOnly(nbVar.f2070e).setGroup(nbVar.f2047a).setGroupSummary(nbVar.f2067d).setSortKey(nbVar.f2055b);
            this.f7194a = nbVar.h;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2559a.setCategory(nbVar.f2060c).setColor(nbVar.e).setVisibility(nbVar.f).setPublicVersion(nbVar.f2039a).setSound(notification.sound, notification.audioAttributes);
            List listD2 = Build.VERSION.SDK_INT < 28 ? d(e(nbVar.f2056b), nbVar.f2066d) : nbVar.f2066d;
            if (listD2 != null && !listD2.isEmpty()) {
                Iterator it2 = listD2.iterator();
                while (it2.hasNext()) {
                    this.f2559a.addPerson((String) it2.next());
                }
            }
            this.c = nbVar.f2063d;
            if (nbVar.f2061c.size() > 0) {
                Bundle bundle3 = nbVar.b().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle(bundle3);
                Bundle bundle5 = new Bundle();
                for (int i2 = 0; i2 < nbVar.f2061c.size(); i2++) {
                    bundle5.putBundle(Integer.toString(i2), rb.b(nbVar.f2061c.get(i2)));
                }
                bundle3.putBundle("invisible_actions", bundle5);
                bundle4.putBundle("invisible_actions", bundle5);
                nbVar.b().putBundle("android.car.EXTENSIONS", bundle3);
                this.f2560a.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && (icon = nbVar.f2043a) != null) {
            this.f2559a.setSmallIcon(icon);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f2559a.setExtras(nbVar.f2044a).setRemoteInputHistory(nbVar.f2050a);
            RemoteViews remoteViews = nbVar.f2053b;
            if (remoteViews != null) {
                this.f2559a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = nbVar.f2058c;
            if (remoteViews2 != null) {
                this.f2559a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = nbVar.f2063d;
            if (remoteViews3 != null) {
                this.f2559a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2559a.setBadgeIconType(nbVar.g).setSettingsText(nbVar.f2068e).setShortcutId(nbVar.f2069e).setTimeoutAfter(nbVar.f2035a).setGroupAlertBehavior(nbVar.h);
            if (nbVar.f2072g) {
                this.f2559a.setColorized(nbVar.f2071f);
            }
            if (!TextUtils.isEmpty(nbVar.f2065d)) {
                this.f2559a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<tb> it3 = nbVar.f2056b.iterator();
            while (it3.hasNext()) {
                this.f2559a.addPerson(it3.next().b());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2559a.setAllowSystemGeneratedContextualActions(nbVar.f2073h);
            this.f2559a.setBubbleMetadata(mb.i(nbVar.f2036a));
            zb zbVar = nbVar.f2038a;
            if (zbVar != null) {
                this.f2559a.setLocusId(zbVar.a());
            }
        }
        if (nbVar.i) {
            if (this.f2558a.f2067d) {
                this.f7194a = 2;
            } else {
                this.f7194a = 1;
            }
            this.f2559a.setVibrate(null);
            this.f2559a.setSound(null);
            int i3 = notification.defaults & (-2);
            notification.defaults = i3;
            int i4 = i3 & (-3);
            notification.defaults = i4;
            this.f2559a.setDefaults(i4);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f2558a.f2047a)) {
                    this.f2559a.setGroup("silent");
                }
                this.f2559a.setGroupAlertBehavior(this.f7194a);
            }
        }
    }

    public static List<String> d(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        da daVar = new da(list.size() + list2.size());
        daVar.addAll(list);
        daVar.addAll(list2);
        return new ArrayList(daVar);
    }

    public static List<String> e(List<tb> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<tb> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    public final void a(jb jbVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.f2562a.add(rb.f(this.f2559a, jbVar));
                return;
            }
            return;
        }
        IconCompat iconCompatE = jbVar.e();
        Notification.Action.Builder builder = Build.VERSION.SDK_INT >= 23 ? new Notification.Action.Builder(iconCompatE != null ? iconCompatE.k() : null, jbVar.i(), jbVar.a()) : new Notification.Action.Builder(iconCompatE != null ? iconCompatE.b() : 0, jbVar.i(), jbVar.a());
        if (jbVar.f() != null) {
            for (RemoteInput remoteInput : ub.b(jbVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = jbVar.d() != null ? new Bundle(jbVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", jbVar.b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(jbVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", jbVar.g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(jbVar.g());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setContextual(jbVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", jbVar.h());
        builder.addExtras(bundle);
        this.f2559a.addAction(builder.build());
    }

    public Notification b() {
        Bundle bundleA;
        RemoteViews remoteViewsE;
        RemoteViews remoteViewsC;
        ob obVar = this.f2558a.f2037a;
        if (obVar != null) {
            obVar.b(this);
        }
        RemoteViews remoteViewsD = obVar != null ? obVar.d(this) : null;
        Notification notificationC = c();
        if (remoteViewsD != null || (remoteViewsD = this.f2558a.f2053b) != null) {
            notificationC.contentView = remoteViewsD;
        }
        if (Build.VERSION.SDK_INT >= 16 && obVar != null && (remoteViewsC = obVar.c(this)) != null) {
            notificationC.bigContentView = remoteViewsC;
        }
        if (Build.VERSION.SDK_INT >= 21 && obVar != null && (remoteViewsE = this.f2558a.f2037a.e(this)) != null) {
            notificationC.headsUpContentView = remoteViewsE;
        }
        if (Build.VERSION.SDK_INT >= 16 && obVar != null && (bundleA = pb.a(notificationC)) != null) {
            obVar.a(bundleA);
        }
        return notificationC;
    }

    public Notification c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f2559a.build();
        }
        if (i >= 24) {
            Notification notificationBuild = this.f2559a.build();
            if (this.f7194a != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f7194a == 2) {
                    f(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f7194a == 1) {
                    f(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i >= 21) {
            this.f2559a.setExtras(this.f2560a);
            Notification notificationBuild2 = this.f2559a.build();
            RemoteViews remoteViews = this.f2561a;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.b;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.c;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f7194a != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f7194a == 2) {
                    f(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f7194a == 1) {
                    f(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i >= 20) {
            this.f2559a.setExtras(this.f2560a);
            Notification notificationBuild3 = this.f2559a.build();
            RemoteViews remoteViews4 = this.f2561a;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.b;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            if (this.f7194a != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.f7194a == 2) {
                    f(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.f7194a == 1) {
                    f(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (i >= 19) {
            SparseArray<Bundle> sparseArrayA = rb.a(this.f2562a);
            if (sparseArrayA != null) {
                this.f2560a.putSparseParcelableArray("android.support.actionExtras", sparseArrayA);
            }
            this.f2559a.setExtras(this.f2560a);
            Notification notificationBuild4 = this.f2559a.build();
            RemoteViews remoteViews6 = this.f2561a;
            if (remoteViews6 != null) {
                notificationBuild4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.b;
            if (remoteViews7 != null) {
                notificationBuild4.bigContentView = remoteViews7;
            }
            return notificationBuild4;
        }
        if (i < 16) {
            return this.f2559a.getNotification();
        }
        Notification notificationBuild5 = this.f2559a.build();
        Bundle bundleA = pb.a(notificationBuild5);
        Bundle bundle = new Bundle(this.f2560a);
        for (String str : this.f2560a.keySet()) {
            if (bundleA.containsKey(str)) {
                bundle.remove(str);
            }
        }
        bundleA.putAll(bundle);
        SparseArray<Bundle> sparseArrayA2 = rb.a(this.f2562a);
        if (sparseArrayA2 != null) {
            pb.a(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayA2);
        }
        RemoteViews remoteViews8 = this.f2561a;
        if (remoteViews8 != null) {
            notificationBuild5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.b;
        if (remoteViews9 != null) {
            notificationBuild5.bigContentView = remoteViews9;
        }
        return notificationBuild5;
    }

    public final void f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }
}
