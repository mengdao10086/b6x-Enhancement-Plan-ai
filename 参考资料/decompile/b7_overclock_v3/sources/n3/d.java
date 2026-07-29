package n3;

import android.content.Context;
import android.os.Build;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.x0;
import com.flydigi.device_manager.cooperate.cjzc.ui.Activity_CJZC_Listen;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.FloatWindowSizeBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f41775l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f41776m = 10;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f41777n = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<byte[]> f41779b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FloatWindowSizeBean f41782e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GamepadInfo f41785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f41786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f41788k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f41780c = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f41781d = new byte[f41776m];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f41783f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41784g = false;

    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!Thread.interrupted()) {
                synchronized (d.this.f41779b) {
                    byte[] bArrPeek = d.this.f41779b.peek();
                    if (bArrPeek != null) {
                        try {
                            if (d.this.f41787j) {
                                if (Arrays.equals(bArrPeek, l3.b.j())) {
                                    c cVar = d.this.f41786i;
                                    if (cVar != null) {
                                        cVar.l();
                                    }
                                } else {
                                    d.this.f(bArrPeek);
                                }
                            }
                            d.this.f41779b.poll();
                        } catch (InterruptedException e10) {
                            e10.printStackTrace();
                        }
                    } else {
                        d.this.f41779b.wait();
                    }
                }
            }
        }
    }

    public class b extends Thread {
        public b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d.this.f41784g = true;
            if (v5.c.f()) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            c cVar = d.this.f41786i;
            if (cVar != null) {
                cVar.n();
            }
            d.this.d();
            d dVar = d.this;
            if (!dVar.f41783f) {
                dVar.g();
            }
            d dVar2 = d.this;
            dVar2.f41788k = -1;
            dVar2.d();
            d.this.y();
            d.this.f41784g = false;
        }
    }

    public interface c {
        void F(byte[] bArr);

        void a(GamepadInfo gamepadInfo);

        void d();

        void l();

        void n();

        void o(boolean z10, int i10);

        void x(byte[] bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context context) {
        this.f41778a = context;
        if (context instanceof c) {
            this.f41786i = (c) context;
        }
        this.f41779b = new ConcurrentLinkedQueue<>();
        new a("SocketClient").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        c cVar = this.f41786i;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void A() {
        M(l3.b.m());
    }

    public void B(int i10) {
        M(l3.b.n(i10));
    }

    public void C() {
        M(l3.b.o());
    }

    public void D() {
        M(l3.b.e());
    }

    public void E() {
        M(l3.b.f());
    }

    public void F() {
        if (!this.f41787j && n() && this.f41785h.isDriverMode()) {
            ThreadUtils.t0(new Runnable() { // from class: n3.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41774a.p();
                }
            }, 2000L);
        }
        M(l3.b.g());
    }

    public void G(GamepadInfo gamepadInfo) {
        this.f41785h = gamepadInfo;
    }

    public void H(FloatWindowSizeBean floatWindowSizeBean) {
        this.f41782e = floatWindowSizeBean;
    }

    public synchronized void I() {
        if (this.f41784g) {
            return;
        }
        this.f41783f = false;
        new b("ThreadSocket").start();
    }

    public void J(String str) {
        if (!this.f41787j || this.f41783f) {
            return;
        }
        HashMap map = new HashMap();
        map.put("manufacturer", Build.MANUFACTURER);
        map.put("model", Build.MODEL);
        int i10 = Build.VERSION.SDK_INT;
        map.put("systemVersion", String.valueOf(i10));
        GamepadInfo gamepadInfo = this.f41785h;
        map.put("deviceName", gamepadInfo == null ? "" : gamepadInfo.getDeviceName());
        GamepadInfo gamepadInfo2 = this.f41785h;
        map.put(Activity_CJZC_Listen.Q7, (gamepadInfo2 == null || !gamepadInfo2.isFlashplayMode()) ? "传统" : "智联");
        map.put("connectState", n() ? "连接" : "断开");
        map.put("driverVersion", u9.b.j(this.f41788k));
        map.put("usb_debug_state", o5.b.k(this.f41778a) ? "已开启" : "已关闭");
        if (i10 >= 23) {
            map.put("battery_optimization", o5.b.h(this.f41778a) ? "已忽略" : "未忽略");
        }
        map.put("screen_state", x0.l() ? "已锁屏" : "未锁屏");
        map.put("error_message", str);
        u9.g.a().d(this.f41778a, "Remote_Driver_Error", "驱动异常", map);
    }

    public void K(List<byte[]> list) {
        c();
        L(list);
    }

    public void L(List<byte[]> list) {
        synchronized (this.f41779b) {
            ArrayList arrayList = new ArrayList();
            Iterator<byte[]> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(i(it2.next()));
            }
            this.f41779b.addAll(arrayList);
            this.f41779b.notify();
        }
    }

    public void M(byte[] bArr) {
        synchronized (this.f41779b) {
            this.f41779b.add(i(bArr));
            this.f41779b.notify();
        }
    }

    public void c() {
        l3.b.a(this.f41781d);
        M(this.f41781d);
    }

    @g.i
    public void d() {
        this.f41787j = false;
        this.f41788k = -1;
    }

    public void e() {
        this.f41783f = true;
        this.f41784g = false;
        d();
        c cVar = this.f41786i;
        if (cVar != null) {
            cVar.o(false, 0);
        }
    }

    public abstract void f(byte[] bArr);

    public abstract void g();

    public void h() {
        z(u9.b.i());
        x();
        A();
    }

    public final byte[] i(byte[] bArr) {
        if (bArr.length > 33) {
            return bArr;
        }
        byte[] bArr2 = new byte[33];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public void j(int i10, int i11, int i12) {
        M(l3.b.p(i10, i11, i12));
    }

    public void k(int i10, int i11, int i12) {
        M(l3.b.q(i10, i11, i12));
    }

    public void l(int i10, int i11) {
        M(l3.b.r(i10, i11));
    }

    @g.i
    public void m(int i10) {
        if (i10 == 8) {
            byte[] bArr = this.f41780c;
            if ((bArr[0] & (-1)) != 8 || this.f41782e == null) {
                return;
            }
            byte[] bArr2 = (byte[]) bArr.clone();
            c cVar = this.f41786i;
            if (cVar != null) {
                cVar.F(bArr2);
                return;
            }
            return;
        }
        if (i10 == 80) {
            byte[] bArr3 = this.f41780c;
            if ((bArr3[0] & 15) == 4) {
                int i11 = ((bArr3[12] << 8) & 65280) | (bArr3[8] & 255);
                if (i11 != this.f41788k) {
                    this.f41788k = i11;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("驱动连接成功得到驱动版本 认为连接成功:");
                    sb2.append(u9.b.j(this.f41788k));
                    y();
                }
            }
        }
    }

    public boolean n() {
        GamepadInfo gamepadInfo = this.f41785h;
        return gamepadInfo != null && gamepadInfo.isConnected();
    }

    public void o() {
        this.f41783f = true;
        M(l3.b.s());
    }

    public void q() {
        l3.b.t(this.f41781d);
        M(this.f41781d);
    }

    public void r() {
        M(l3.b.u());
    }

    public void s() {
        M(l3.b.d());
    }

    public void t() {
        l3.b.v(this.f41781d);
        M(this.f41781d);
    }

    public void u() {
        M(l3.b.w());
    }

    public int v(int i10, String str) {
        if (i10 != 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("socket通信异常，重试，count:");
            sb2.append(i10);
            return i10 > 0 ? i10 - 1 : i10;
        }
        if (!this.f41783f) {
            J(str);
        }
        this.f41787j = false;
        this.f41788k = -1;
        c cVar = this.f41786i;
        if (cVar != null) {
            cVar.o(false, 0);
        }
        return -1;
    }

    public void w(GamepadInfo gamepadInfo) {
        M(l3.b.h(gamepadInfo));
    }

    public final void x() {
        GamepadInfo gamepadInfo = this.f41785h;
        if (gamepadInfo != null) {
            M(l3.b.i(gamepadInfo));
        }
    }

    public void y() {
        this.f41787j = this.f41788k > 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startConnect 驱动连接");
        sb2.append(this.f41787j ? "成功" : "失败");
        c cVar = this.f41786i;
        if (cVar != null) {
            cVar.o(this.f41787j, this.f41788k);
        }
    }

    public void z(int i10) {
        M(l3.b.k(i10, this.f41781d));
    }
}
