package ju;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import iu.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f36962e = "OpenDeviceId library";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f36963f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public iu.a f36965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f36966c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f36964a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0416b f36967d = null;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f36965b = a.AbstractBinderC0402a.Q0(iBinder);
            if (b.this.f36967d != null) {
                b.this.f36967d.a("Deviceid Service Connected", b.this);
            }
            b.this.e("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f36965b = null;
            b.this.e("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: ju.b$b, reason: collision with other inner class name */
    public interface InterfaceC0416b<T> {
        void a(T t10, b bVar);
    }

    public int a(Context context, InterfaceC0416b<String> interfaceC0416b) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.f36964a = context;
        this.f36967d = interfaceC0416b;
        this.f36966c = new a();
        Intent intent = new Intent();
        intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
        if (this.f36964a.bindService(intent, this.f36966c, 1)) {
            e("bindService Successful!");
            return 1;
        }
        e("bindService Failed!");
        return -1;
    }

    public String c() {
        if (this.f36964a == null) {
            i("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            iu.a aVar = this.f36965b;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e10) {
            i("getOAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public final void e(String str) {
    }

    public void g(boolean z10) {
        f36963f = z10;
    }

    public String h() {
        if (this.f36964a == null) {
            i("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            iu.a aVar = this.f36965b;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (RemoteException e10) {
            i("getUDID error, RemoteException!");
            e10.printStackTrace();
            return null;
        } catch (Exception e11) {
            i("getUDID error, Exception!");
            e11.printStackTrace();
            return null;
        }
    }

    public final void i(String str) {
    }

    public boolean j() {
        try {
            if (this.f36965b == null) {
                return false;
            }
            e("Device support opendeviceid");
            return this.f36965b.c();
        } catch (RemoteException unused) {
            i("isSupport error, RemoteException!");
            return false;
        }
    }

    public String k() {
        Context context = this.f36964a;
        if (context == null) {
            e("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        e("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            e("input package is null!");
            return null;
        }
        try {
            iu.a aVar = this.f36965b;
            if (aVar != null) {
                return aVar.a(packageName);
            }
            return null;
        } catch (RemoteException e10) {
            i("getVAID error, RemoteException!");
            e10.printStackTrace();
            return null;
        }
    }

    public String l() {
        Context context = this.f36964a;
        if (context == null) {
            e("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        e("liufeng, getAAID package：" + packageName);
        String strB = null;
        if (packageName == null || packageName.equals("")) {
            e("input package is null!");
            return null;
        }
        try {
            iu.a aVar = this.f36965b;
            if (aVar == null) {
                return null;
            }
            strB = aVar.b(packageName);
            return ((strB == null || "".equals(strB)) && this.f36965b.c(packageName)) ? this.f36965b.b(packageName) : strB;
        } catch (RemoteException unused) {
            i("getAAID error, RemoteException!");
            return strB;
        }
    }

    public void m() {
        try {
            this.f36964a.unbindService(this.f36966c);
            e("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            i("unBind Service exception");
        }
        this.f36965b = null;
    }
}
