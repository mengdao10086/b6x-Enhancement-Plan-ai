package a;

import android.content.Context;
import com.omarea.Scene;
import com.omarea.model.BatteryStatus;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sa0 implements ha0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hj0 f2864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ij0 f2865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zy0 f2866a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2867b;

    public sa0(Context context) {
        f92.d(context, "context");
        this.f2864a = new hj0(new ra0(this), "Analyser-Power");
        this.f2866a = zy0.e();
        this.f2865a = new ij0(context);
        zy0 zy0Var = this.f2866a;
        f92.c(zy0Var, "storage");
        this.f7376a = zy0Var.h();
        this.f2867b = true;
        zy0 zy0Var2 = this.f2866a;
        f92.c(zy0Var2, "storage");
        this.f2863a = zy0Var2.g();
        this.b = this.f2866a.f();
    }

    public final void b() {
        this.f2864a.c();
    }

    public final void c() {
        this.f2867b = false;
        this.f7376a = this.f2866a.m();
    }

    public final void d() {
        if (fa0.f867a.c() == 5 || fa0.f867a.c() == 1) {
            fa0.f867a.x();
        } else {
            fa0.f867a.B();
        }
        if (fa0.f867a.h()) {
            return;
        }
        boolean zC = this.f2865a.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f2863a;
        if (jCurrentTimeMillis - j > 86400000 || (jCurrentTimeMillis - j > 30000 && fa0.f867a.a() > this.b)) {
            c();
        }
        this.f2863a = jCurrentTimeMillis;
        this.b = fa0.f867a.a();
        if (Math.abs(fa0.f867a.b()) > 60000) {
            c();
            if (m61.f6775a.b()) {
                return;
            }
            new m61(Scene.f4798a.c()).h(true);
            return;
        }
        BatteryStatus batteryStatus = new BatteryStatus();
        batteryStatus.time = jCurrentTimeMillis;
        batteryStatus.session = this.f7376a;
        batteryStatus.temperature = fa0.f867a.o();
        batteryStatus.status = fa0.f867a.c();
        batteryStatus.current = (int) fa0.f867a.b();
        double dP = fa0.f867a.p();
        if (dP > 0) {
            batteryStatus.voltage = dP;
        }
        batteryStatus.screenOn = zC;
        batteryStatus.capacity = fa0.f867a.a();
        batteryStatus.packageName = fa0.f867a.j();
        batteryStatus.mode = wu0.f3480a.d();
        this.f2866a.l(batteryStatus);
        this.f2867b = true;
        if (zC) {
            return;
        }
        b();
    }

    public final void e() {
        if (!this.f2864a.d() && this.f2865a.c() && this.f2864a.e(1000L, 3000L)) {
            fa0.z(fa0.f867a, 0L, 1, null);
        }
    }

    @Override // a.ha0
    public boolean eventFilter(aa0 aa0Var) {
        f92.d(aa0Var, "eventType");
        switch (qa0.f7192a[aa0Var.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public final void f() {
        if (this.f2867b) {
            c();
        }
    }

    @Override // a.ha0
    public boolean isAsync() {
        return true;
    }

    @Override // a.ha0
    public void onReceive(aa0 aa0Var, HashMap<String, Object> map) {
        f92.d(aa0Var, "eventType");
        switch (qa0.b[aa0Var.ordinal()]) {
            case 1:
                break;
            case 2:
                d();
                return;
            case 3:
            case 4:
                c();
                return;
            case 5:
                f();
                break;
            case 6:
                if (!fa0.f867a.m()) {
                    f();
                    return;
                }
                break;
            default:
                return;
        }
        e();
    }

    @Override // a.ha0
    public void onSubscribe() {
        e();
    }

    @Override // a.ha0
    public void onUnsubscribe() {
        b();
    }
}
