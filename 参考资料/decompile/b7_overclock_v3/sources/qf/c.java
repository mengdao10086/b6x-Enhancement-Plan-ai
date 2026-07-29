package qf;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f47332b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f47333a = new b();

    public static c g() {
        if (f47332b == null) {
            synchronized (c.class) {
                if (f47332b == null) {
                    f47332b = new c();
                }
            }
        }
        return f47332b;
    }

    public void a(rf.a aVar) {
        this.f47333a.j(aVar);
    }

    public void b() {
        this.f47333a.k();
    }

    public boolean c(Context context, BluetoothDevice bluetoothDevice) {
        return this.f47333a.l(context, bluetoothDevice);
    }

    public boolean d(Context context, String str) {
        return this.f47333a.m(context, str);
    }

    public boolean e() {
        return this.f47333a.n();
    }

    public boolean f(UUID uuid, UUID uuid2, UUID uuid3) {
        return this.f47333a.o(uuid, uuid2, uuid3);
    }

    public boolean h() {
        return this.f47333a.p();
    }

    public boolean i() {
        return this.f47333a.w();
    }

    public void j(rf.a aVar) {
        this.f47333a.x(aVar);
    }

    public boolean k(int i10) {
        return this.f47333a.y(i10);
    }

    public boolean l(UUID uuid, UUID uuid2) {
        return this.f47333a.z(uuid, uuid2);
    }

    public boolean m(byte[] bArr) {
        return this.f47333a.A(bArr);
    }

    public boolean n(byte[] bArr) {
        return this.f47333a.B(bArr);
    }
}
