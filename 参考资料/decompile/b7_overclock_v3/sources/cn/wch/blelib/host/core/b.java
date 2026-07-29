package cn.wch.blelib.host.core;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import cn.wch.blelib.exception.BLELibException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static b f11051f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11053b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11054c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, d> f11055d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, Connector> f11056e = new HashMap<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f11058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z2.a f11059c;

        /* JADX INFO: renamed from: cn.wch.blelib.host.core.b$a$a, reason: collision with other inner class name */
        public class C0111a implements z2.a {
            public C0111a() {
            }

            @Override // z2.a
            public void a(String str, Throwable th2) {
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.a(str, th2);
                }
            }

            @Override // z2.a
            public void b(String str) {
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.b(str);
                }
            }

            @Override // z2.a
            public void c(String str, BluetoothDevice bluetoothDevice, int i10) {
                b.this.f11055d.remove(a.this.f11057a);
                try {
                    b.this.f(str);
                } catch (BLELibException e10) {
                    e10.printStackTrace();
                }
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.c(str, bluetoothDevice, i10);
                }
            }

            @Override // z2.a
            public void d(String str) {
                try {
                    b.this.f(str);
                } catch (BLELibException e10) {
                    e10.printStackTrace();
                }
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.d(str);
                }
            }

            @Override // z2.a
            public void e(String str, d dVar) {
                b.this.f11055d.remove(a.this.f11057a);
                b.this.f11055d.put(a.this.f11057a, dVar);
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.e(str, dVar);
                }
            }

            @Override // z2.a
            public void f(String str, List<BluetoothGattService> list) {
                z2.a aVar = a.this.f11059c;
                if (aVar != null) {
                    aVar.f(str, list);
                }
            }
        }

        public a(String str, c cVar, z2.a aVar) {
            this.f11057a = str;
            this.f11058b = cVar;
            this.f11059c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f11056e.put(this.f11057a, new Connector(b.this.f11052a, this.f11057a, this.f11058b, new C0111a()));
        }
    }

    public b(Context context) {
        this.f11052a = context;
    }

    public static void e(c cVar) throws BLELibException {
        if (!o(cVar)) {
            throw new BLELibException("ConnRuler MAC  is invalid");
        }
        if (cVar.a() <= 0) {
            throw new BLELibException("ConnectTimeout should more than 0 ");
        }
    }

    public static b k(Context context) {
        if (f11051f == null) {
            synchronized (b.class) {
                f11051f = new b(context);
            }
        }
        return f11051f;
    }

    public static String l(c cVar) throws BLELibException {
        e(cVar);
        return cVar.b();
    }

    public static boolean n(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}");
    }

    public static boolean o(c cVar) {
        if (cVar == null || cVar.b() == null) {
            return false;
        }
        return n(cVar.b());
    }

    public void d(c cVar, z2.a aVar) throws BLELibException {
        new Thread(new a(l(cVar), cVar, aVar)).start();
    }

    public void f(String str) throws BLELibException {
        if (str == null) {
            throw new BLELibException("mac is null");
        }
        if (this.f11056e.containsKey(str)) {
            Connector connector = this.f11056e.get(str);
            if (connector != null) {
                connector.E();
            }
            this.f11056e.remove(str);
        }
        if (this.f11055d.containsKey(str)) {
            d dVar = this.f11055d.get(str);
            if (dVar != null) {
                dVar.a();
            }
            this.f11055d.remove(str);
        }
    }

    public void g() {
        if (this.f11055d.isEmpty()) {
            return;
        }
        Iterator<String> it2 = this.f11055d.keySet().iterator();
        while (it2.hasNext()) {
            d dVar = this.f11055d.get(it2.next());
            if (dVar != null) {
                dVar.a();
            }
        }
        this.f11055d.clear();
    }

    public void h(String str) throws BLELibException {
        if (str == null) {
            throw new BLELibException("mac is null");
        }
        if (this.f11055d.containsKey(str)) {
            this.f11055d.get(str).b();
            this.f11055d.remove(str);
        }
    }

    public HashMap<String, d> i() {
        return this.f11055d;
    }

    public d j(String str) {
        if (TextUtils.isEmpty(str) || !e3.a.b(str)) {
            return null;
        }
        return this.f11055d.get(str);
    }

    public boolean m(String str) {
        if (str != null && this.f11055d.containsKey(str)) {
            return this.f11055d.get(str).g();
        }
        return false;
    }
}
