package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.blankj.utilcode.util.l0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MessengerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, b> f11467a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, a> f11468b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f11469c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11470d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11471e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11472f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f11473g = "MESSENGER_UTILS";

    public static class ServerService extends Service {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<Integer, Messenger> f11474a = new ConcurrentHashMap<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        public final Handler f11475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Messenger f11476c;

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 0) {
                    ServerService.this.f11474a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i10 == 1) {
                    ServerService.this.f11474a.remove(Integer.valueOf(message.arg1));
                } else if (i10 != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.f11475b = aVar;
            this.f11476c = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            b bVar;
            Bundle data = message.getData();
            if (data == null || (string = data.getString(MessengerUtils.f11473g)) == null || (bVar = (b) MessengerUtils.f11467a.get(string)) == null) {
                return;
            }
            bVar.a(data);
        }

        public final void e(Message message) {
            for (Messenger messenger : this.f11474a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(message);
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }

        @Override // android.app.Service
        @g.p0
        public IBinder onBind(Intent intent) {
            return this.f11476c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i10, int i11) {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, l1.b0(l0.a.f11925b, null));
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.f11475b, 2);
                messageObtain.replyTo = this.f11476c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Messenger f11479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinkedList<Bundle> f11480c = new LinkedList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SuppressLint({"HandlerLeak"})
        public Handler f11481d = new HandlerC0114a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Messenger f11482e = new Messenger(this.f11481d);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ServiceConnection f11483f = new b();

        /* JADX INFO: renamed from: com.blankj.utilcode.util.MessengerUtils$a$a, reason: collision with other inner class name */
        public class HandlerC0114a extends Handler {
            public HandlerC0114a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar;
                Bundle data = message.getData();
                data.setClassLoader(MessengerUtils.class.getClassLoader());
                String string = data.getString(MessengerUtils.f11473g);
                if (string == null || (bVar = (b) MessengerUtils.f11467a.get(string)) == null) {
                    return;
                }
                bVar.a(data);
            }
        }

        public class b implements ServiceConnection {
            public b() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("client service connected ");
                sb2.append(componentName);
                a.this.f11479b = new Messenger(iBinder);
                Message messageObtain = Message.obtain(a.this.f11481d, 0, l1.N().hashCode(), 0);
                messageObtain.getData().setClassLoader(MessengerUtils.class.getClassLoader());
                a aVar = a.this;
                messageObtain.replyTo = aVar.f11482e;
                try {
                    aVar.f11479b.send(messageObtain);
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                a.this.d();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("client service disconnected:");
                sb2.append(componentName);
                a aVar = a.this;
                aVar.f11479b = null;
                if (aVar.b()) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("client service rebind failed: ");
                sb3.append(componentName);
            }
        }

        public a(String str) {
            this.f11478a = str;
        }

        public boolean b() {
            if (TextUtils.isEmpty(this.f11478a)) {
                return j1.a().bindService(new Intent(j1.a(), (Class<?>) ServerService.class), this.f11483f, 1);
            }
            if (!l1.s0(this.f11478a)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bind: the app is not installed -> ");
                sb2.append(this.f11478a);
                return false;
            }
            if (!l1.t0(this.f11478a)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("bind: the app is not running -> ");
                sb3.append(this.f11478a);
                return false;
            }
            Intent intent = new Intent(this.f11478a + ".messenger");
            intent.setPackage(this.f11478a);
            return j1.a().bindService(intent, this.f11483f, 1);
        }

        public final boolean c(Bundle bundle) {
            Message messageObtain = Message.obtain(this.f11481d, 2);
            bundle.setClassLoader(MessengerUtils.class.getClassLoader());
            messageObtain.setData(bundle);
            messageObtain.replyTo = this.f11482e;
            try {
                this.f11479b.send(messageObtain);
                return true;
            } catch (RemoteException e10) {
                e10.printStackTrace();
                return false;
            }
        }

        public final void d() {
            if (this.f11480c.isEmpty()) {
                return;
            }
            for (int size = this.f11480c.size() - 1; size >= 0; size--) {
                if (c(this.f11480c.get(size))) {
                    this.f11480c.remove(size);
                }
            }
        }

        public void e(Bundle bundle) {
            if (this.f11479b == null) {
                this.f11480c.addFirst(bundle);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("save the bundle ");
                sb2.append(bundle);
                return;
            }
            d();
            if (c(bundle)) {
                return;
            }
            this.f11480c.addFirst(bundle);
        }

        public void f() {
            Message messageObtain = Message.obtain(this.f11481d, 1, l1.N().hashCode(), 0);
            messageObtain.replyTo = this.f11482e;
            try {
                this.f11479b.send(messageObtain);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
            try {
                j1.a().unbindService(this.f11483f);
            } catch (Exception unused) {
            }
        }
    }

    public interface b {
        void a(Bundle bundle);
    }

    public static void b(@g.n0 String str, @g.n0 Bundle bundle) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'data' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        bundle.putString(f11473g, str);
        a aVar = f11469c;
        if (aVar != null) {
            aVar.e(bundle);
        } else {
            Intent intent = new Intent(j1.a(), (Class<?>) ServerService.class);
            intent.putExtras(bundle);
            e(intent);
        }
        Iterator<a> it2 = f11468b.values().iterator();
        while (it2.hasNext()) {
            it2.next().e(bundle);
        }
    }

    public static void c() {
        if (l1.y0()) {
            if (l1.B0(ServerService.class.getName())) {
                return;
            }
            e(new Intent(j1.a(), (Class<?>) ServerService.class));
        } else if (f11469c == null) {
            a aVar = new a(null);
            if (aVar.b()) {
                f11469c = aVar;
            }
        }
    }

    public static void d(String str) {
        if (f11468b.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("register: client registered: ");
            sb2.append(str);
            return;
        }
        a aVar = new a(str);
        if (aVar.b()) {
            f11468b.put(str, aVar);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("register: client bind failed: ");
        sb3.append(str);
    }

    public static void e(Intent intent) {
        try {
            intent.setFlags(32);
            if (Build.VERSION.SDK_INT >= 26) {
                j1.a().startForegroundService(intent);
            } else {
                j1.a().startService(intent);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void f(@g.n0 String str, @g.n0 b bVar) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bVar, "Argument 'callback' of type MessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f11467a.put(str, bVar);
    }

    public static void g() {
        if (l1.y0()) {
            if (!l1.B0(ServerService.class.getName())) {
                return;
            }
            j1.a().stopService(new Intent(j1.a(), (Class<?>) ServerService.class));
        }
        a aVar = f11469c;
        if (aVar != null) {
            aVar.f();
        }
    }

    public static void h(String str) {
        if (!f11468b.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("unregister: client didn't register: ");
            sb2.append(str);
        } else {
            a aVar = f11468b.get(str);
            f11468b.remove(str);
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    public static void i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f11467a.remove(str);
    }
}
