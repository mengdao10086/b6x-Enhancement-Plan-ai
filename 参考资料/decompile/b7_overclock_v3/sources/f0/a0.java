package f0;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import bg.c;
import c.a;
import g.n0;
import g.p0;
import g.v0;
import g.y0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27362c = "NotifManCompat";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27363d = "checkOpNoThrow";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27364e = "OP_POST_NOTIFICATION";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27365f = "android.support.useSideChannel";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27366g = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f27367h = 19;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27368i = 1000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f27369j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f27370k = "enabled_notification_listeners";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @g.b0("sEnabledNotificationListenersLock")
    public static String f27372m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.b0("sLock")
    public static h f27375p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f27376q = -1000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f27377r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f27378s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f27379t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f27380u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f27381v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f27382w = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f27383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f27384b;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f27371l = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.b0("sEnabledNotificationListenersLock")
    public static Set<String> f27373n = new HashSet();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f27374o = new Object();

    @v0(24)
    public static class a {
        @g.u
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        @g.u
        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    @v0(26)
    public static class b {
        @g.u
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        @g.u
        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        @g.u
        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        @g.u
        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        @g.u
        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        @g.u
        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        @g.u
        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @g.u
        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @g.u
        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        @g.u
        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        @g.u
        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    @v0(28)
    public static class c {
        @g.u
        public static NotificationChannelGroup a(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannelGroup(str);
        }
    }

    @v0(30)
    public static class d {
        @g.u
        public static NotificationChannel a(NotificationManager notificationManager, String str, String str2) {
            return notificationManager.getNotificationChannel(str, str2);
        }

        @g.u
        public static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    public static class f implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f27389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f27390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f27391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f27392d;

        public f(String str, int i10, String str2, Notification notification) {
            this.f27389a = str;
            this.f27390b = i10;
            this.f27391c = str2;
            this.f27392d = notification;
        }

        @Override // f0.a0.i
        public void a(c.a aVar) throws RemoteException {
            aVar.I0(this.f27389a, this.f27390b, this.f27391c, this.f27392d);
        }

        @n0
        public String toString() {
            return "NotifyTask[packageName:" + this.f27389a + ", id:" + this.f27390b + ", tag:" + this.f27391c + "]";
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f27393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f27394b;

        public g(ComponentName componentName, IBinder iBinder) {
            this.f27393a = componentName;
            this.f27394b = iBinder;
        }
    }

    public static class h implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f27395f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f27396g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f27397h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f27398i = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f27399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f27400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f27401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f27402d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set<String> f27403e = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f27404a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c.a f27406c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f27405b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque<i> f27407d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f27408e = 0;

            public a(ComponentName componentName) {
                this.f27404a = componentName;
            }
        }

        public h(Context context) {
            this.f27399a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f27400b = handlerThread;
            handlerThread.start();
            this.f27401c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f27405b) {
                return true;
            }
            boolean zBindService = this.f27399a.bindService(new Intent(a0.f27366g).setComponent(aVar.f27404a), this, 33);
            aVar.f27405b = zBindService;
            if (zBindService) {
                aVar.f27408e = 0;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to bind to listener ");
                sb2.append(aVar.f27404a);
                this.f27399a.unbindService(this);
            }
            return aVar.f27405b;
        }

        public final void b(a aVar) {
            if (aVar.f27405b) {
                this.f27399a.unbindService(this);
                aVar.f27405b = false;
            }
            aVar.f27406c = null;
        }

        public final void c(i iVar) {
            j();
            for (a aVar : this.f27402d.values()) {
                aVar.f27407d.add(iVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f27402d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f27402d.get(componentName);
            if (aVar != null) {
                aVar.f27406c = a.b.Q0(iBinder);
                aVar.f27408e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f27402d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable(a0.f27362c, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Processing component ");
                sb2.append(aVar.f27404a);
                sb2.append(", ");
                sb2.append(aVar.f27407d.size());
                sb2.append(" queued tasks");
            }
            if (aVar.f27407d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f27406c == null) {
                i(aVar);
                return;
            }
            while (true) {
                i iVarPeek = aVar.f27407d.peek();
                if (iVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable(a0.f27362c, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Sending task ");
                        sb3.append(iVarPeek);
                    }
                    iVarPeek.a(aVar.f27406c);
                    aVar.f27407d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable(a0.f27362c, 3)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Remote service has died: ");
                        sb4.append(aVar.f27404a);
                    }
                } catch (RemoteException unused2) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("RemoteException communicating with ");
                    sb5.append(aVar.f27404a);
                }
            }
            if (aVar.f27407d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(i iVar) {
            this.f27401c.obtainMessage(0, iVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((i) message.obj);
                return true;
            }
            if (i10 == 1) {
                g gVar = (g) message.obj;
                e(gVar.f27393a, gVar.f27394b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f27401c.hasMessages(3, aVar.f27404a)) {
                return;
            }
            int i10 = aVar.f27408e + 1;
            aVar.f27408e = i10;
            if (i10 <= 6) {
                int i11 = (1 << (i10 - 1)) * 1000;
                if (Log.isLoggable(a0.f27362c, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Scheduling retry for ");
                    sb2.append(i11);
                    sb2.append(" ms");
                }
                this.f27401c.sendMessageDelayed(this.f27401c.obtainMessage(3, aVar.f27404a), i11);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Giving up on delivering ");
            sb3.append(aVar.f27407d.size());
            sb3.append(" tasks to ");
            sb3.append(aVar.f27404a);
            sb3.append(" after ");
            sb3.append(aVar.f27408e);
            sb3.append(" retries");
            aVar.f27407d.clear();
        }

        public final void j() {
            Set<String> setQ = a0.q(this.f27399a);
            if (setQ.equals(this.f27403e)) {
                return;
            }
            this.f27403e = setQ;
            List<ResolveInfo> listQueryIntentServices = this.f27399a.getPackageManager().queryIntentServices(new Intent().setAction(a0.f27366g), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setQ.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Permission present on component ");
                        sb2.append(componentName);
                        sb2.append(", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f27402d.containsKey(componentName2)) {
                    if (Log.isLoggable(a0.f27362c, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Adding listener record for ");
                        sb3.append(componentName2);
                    }
                    this.f27402d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it2 = this.f27402d.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<ComponentName, a> next = it2.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable(a0.f27362c, 3)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Removing listener record for ");
                        sb4.append(next.getKey());
                    }
                    b(next.getValue());
                    it2.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable(a0.f27362c, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Connected to service ");
                sb2.append(componentName);
            }
            this.f27401c.obtainMessage(1, new g(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable(a0.f27362c, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Disconnected from service ");
                sb2.append(componentName);
            }
            this.f27401c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface i {
        void a(c.a aVar) throws RemoteException;
    }

    public a0(Context context) {
        this.f27383a = context;
        this.f27384b = (NotificationManager) context.getSystemService("notification");
    }

    public static boolean F(Notification notification) {
        Bundle bundleN = v.n(notification);
        return bundleN != null && bundleN.getBoolean(f27365f);
    }

    @n0
    public static a0 p(@n0 Context context) {
        return new a0(context);
    }

    @n0
    public static Set<String> q(@n0 Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f27371l) {
            if (string != null) {
                if (!string.equals(f27372m)) {
                    String[] strArrSplit = string.split(":", -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f27373n = hashSet;
                    f27372m = string;
                }
                set = f27373n;
            } else {
                set = f27373n;
            }
        }
        return set;
    }

    @n0
    public List<NotificationChannel> A() {
        return Build.VERSION.SDK_INT >= 26 ? b.k(this.f27384b) : Collections.emptyList();
    }

    @n0
    public List<t> B() {
        if (Build.VERSION.SDK_INT >= 26) {
            List<NotificationChannel> listA = A();
            if (!listA.isEmpty()) {
                ArrayList arrayList = new ArrayList(listA.size());
                Iterator<NotificationChannel> it2 = listA.iterator();
                while (it2.hasNext()) {
                    arrayList.add(new t(it2.next()));
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    @y0(c.a.f9430a)
    public void C(int i10, @n0 Notification notification) {
        D(null, i10, notification);
    }

    @y0(c.a.f9430a)
    public void D(@p0 String str, int i10, @n0 Notification notification) {
        if (!F(notification)) {
            this.f27384b.notify(str, i10, notification);
        } else {
            E(new f(this.f27383a.getPackageName(), i10, str, notification));
            this.f27384b.cancel(str, i10);
        }
    }

    public final void E(i iVar) {
        synchronized (f27374o) {
            if (f27375p == null) {
                f27375p = new h(this.f27383a.getApplicationContext());
            }
            f27375p.h(iVar);
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(this.f27384b);
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f27383a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f27383a.getApplicationInfo();
        String packageName = this.f27383a.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod(f27363d, cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(f27364e).get(Integer.class)).intValue()), Integer.valueOf(i10), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i10) {
        c(null, i10);
    }

    public void c(@p0 String str, int i10) {
        this.f27384b.cancel(str, i10);
    }

    public void d() {
        this.f27384b.cancelAll();
    }

    public void e(@n0 NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f27384b, notificationChannel);
        }
    }

    public void f(@n0 t tVar) {
        e(tVar.m());
    }

    public void g(@n0 NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.b(this.f27384b, notificationChannelGroup);
        }
    }

    public void h(@n0 u uVar) {
        g(uVar.f());
    }

    public void i(@n0 List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.c(this.f27384b, list);
        }
    }

    public void j(@n0 List<u> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<u> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().f());
        }
        b.c(this.f27384b, arrayList);
    }

    public void k(@n0 List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.d(this.f27384b, list);
        }
    }

    public void l(@n0 List<t> list) {
        if (Build.VERSION.SDK_INT < 26 || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<t> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().m());
        }
        b.d(this.f27384b, arrayList);
    }

    public void m(@n0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.e(this.f27384b, str);
        }
    }

    public void n(@n0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.f(this.f27384b, str);
        }
    }

    public void o(@n0 Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel notificationChannel : b.k(this.f27384b)) {
                if (!collection.contains(b.g(notificationChannel)) && (Build.VERSION.SDK_INT < 30 || !collection.contains(d.b(notificationChannel)))) {
                    b.e(this.f27384b, b.g(notificationChannel));
                }
            }
        }
    }

    public int r() {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.b(this.f27384b);
        }
        return -1000;
    }

    @p0
    public NotificationChannel s(@n0 String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b.i(this.f27384b, str);
        }
        return null;
    }

    @p0
    public NotificationChannel t(@n0 String str, @n0 String str2) {
        return Build.VERSION.SDK_INT >= 30 ? d.a(this.f27384b, str, str2) : s(str);
    }

    @p0
    public t u(@n0 String str) {
        NotificationChannel notificationChannelS;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannelS = s(str)) == null) {
            return null;
        }
        return new t(notificationChannelS);
    }

    @p0
    public t v(@n0 String str, @n0 String str2) {
        NotificationChannel notificationChannelT;
        if (Build.VERSION.SDK_INT < 26 || (notificationChannelT = t(str, str2)) == null) {
            return null;
        }
        return new t(notificationChannelT);
    }

    @p0
    public NotificationChannelGroup w(@n0 String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return c.a(this.f27384b, str);
        }
        if (i10 >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : y()) {
                if (b.h(notificationChannelGroup).equals(str)) {
                    return notificationChannelGroup;
                }
            }
        }
        return null;
    }

    @p0
    public u x(@n0 String str) {
        NotificationChannelGroup notificationChannelGroupW;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            NotificationChannelGroup notificationChannelGroupW2 = w(str);
            if (notificationChannelGroupW2 != null) {
                return new u(notificationChannelGroupW2);
            }
            return null;
        }
        if (i10 < 26 || (notificationChannelGroupW = w(str)) == null) {
            return null;
        }
        return new u(notificationChannelGroupW, A());
    }

    @n0
    public List<NotificationChannelGroup> y() {
        return Build.VERSION.SDK_INT >= 26 ? b.j(this.f27384b) : Collections.emptyList();
    }

    @n0
    public List<u> z() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            List<NotificationChannelGroup> listY = y();
            if (!listY.isEmpty()) {
                List<NotificationChannel> listEmptyList = i10 >= 28 ? Collections.emptyList() : A();
                ArrayList arrayList = new ArrayList(listY.size());
                for (NotificationChannelGroup notificationChannelGroup : listY) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        arrayList.add(new u(notificationChannelGroup));
                    } else {
                        arrayList.add(new u(notificationChannelGroup, listEmptyList));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public static class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f27385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f27386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f27387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f27388d;

        public e(String str) {
            this.f27385a = str;
            this.f27386b = 0;
            this.f27387c = null;
            this.f27388d = true;
        }

        @Override // f0.a0.i
        public void a(c.a aVar) throws RemoteException {
            if (this.f27388d) {
                aVar.P(this.f27385a);
            } else {
                aVar.p0(this.f27385a, this.f27386b, this.f27387c);
            }
        }

        @n0
        public String toString() {
            return "CancelTask[packageName:" + this.f27385a + ", id:" + this.f27386b + ", tag:" + this.f27387c + ", all:" + this.f27388d + "]";
        }

        public e(String str, int i10, String str2) {
            this.f27385a = str;
            this.f27386b = i10;
            this.f27387c = str2;
            this.f27388d = false;
        }
    }
}
