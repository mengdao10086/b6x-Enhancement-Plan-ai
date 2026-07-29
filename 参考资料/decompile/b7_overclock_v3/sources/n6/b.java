package n6;

import android.bluetooth.BluetoothGattService;
import androidx.collection.l;
import java.util.List;
import n6.a;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ boolean f41953i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f41954a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f41955b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f41956c = new h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f41957d = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f41958e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f41959f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f41960g = new d();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l<Integer, c> f41961h = new l<>();

    public boolean a() {
        return !this.f41961h.isEmpty();
    }

    public boolean b() {
        return this.f41957d.e();
    }

    public boolean c() {
        return this.f41959f.k() && this.f41960g.c();
    }

    public boolean d() {
        return this.f41956c.e();
    }

    public boolean e() {
        return this.f41954a;
    }

    public void f() {
        this.f41954a = false;
        this.f41956c.f();
        this.f41955b.k();
        this.f41957d.f();
        this.f41958e.f();
        this.f41961h.clear();
        this.f41959f.l();
        this.f41960g.d();
    }

    public void g(List<BluetoothGattService> list) {
        this.f41954a = true;
        f();
        for (BluetoothGattService bluetoothGattService : list) {
            if (!this.f41955b.a(bluetoothGattService) && !this.f41956c.a(bluetoothGattService) && !this.f41957d.a(bluetoothGattService) && !this.f41958e.a(bluetoothGattService)) {
                if (bluetoothGattService.getUuid().equals(a.g.f41944j)) {
                    c cVar = new c();
                    cVar.a(bluetoothGattService);
                    this.f41961h.put(Integer.valueOf(bluetoothGattService.getInstanceId()), cVar);
                } else if (!this.f41959f.a(bluetoothGattService)) {
                    this.f41960g.a(bluetoothGattService);
                }
            }
        }
    }

    public String toString() {
        String str = (this.f41955b.toString() + "\n\n" + this.f41956c.toString() + "\n\n" + this.f41957d.toString() + "\n\n" + this.f41958e.toString() + "\n\n" + this.f41959f.toString() + "\n\n" + this.f41960g.toString()) + "\n\n" + this.f41961h.size() + " BATTERY Service(s) available:";
        for (int i10 = 0; i10 < this.f41961h.size(); i10++) {
            int iIntValue = this.f41961h.k(i10).intValue();
            str = str + "\ninstance " + iIntValue + ": " + this.f41961h.get(Integer.valueOf(iIntValue)).toString();
        }
        return str;
    }
}
