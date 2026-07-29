package com.flydigi.device_manager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.motionelf.FloatingWindow;
import com.blankj.utilcode.util.n0;
import com.flydigi.base.common.p;
import com.flydigi.base.common.y;
import com.flydigi.device_manager.d;
import com.flydigi.remote.DeviceInfo;
import com.flydigi.sdk.gamepad.GamepadInfo;
import h9.b;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends p {

    @yt.l
    public h9.b E7;
    public boolean F7;

    @yt.k
    public final h9.c G7 = new a();

    @yt.l
    public h9.d H7 = r4();

    @yt.k
    public final ServiceConnection I7 = new b();

    @yt.l
    public GamepadInfo K2;

    public static final class a extends h9.e {
        public a() {
        }

        public static final void W0(d this$0) {
            f0.p(this$0, "this$0");
            GamepadInfo gamepadInfoO4 = this$0.o4();
            if (gamepadInfoO4 != null) {
                this$0.s4(gamepadInfoO4);
            }
        }

        public static final void X0(d this$0) {
            f0.p(this$0, "this$0");
            this$0.t4();
        }

        public static final void Y0(d this$0) {
            f0.p(this$0, "this$0");
            this$0.u4();
        }

        @Override // h9.e, h9.c
        public void H0(@yt.k DeviceInfo deviceInfo) {
            f0.p(deviceInfo, "deviceInfo");
            GamepadInfo gamepadInfoB = DeviceInfo.b(deviceInfo);
            if (n0.b(d.this.o4(), gamepadInfoB)) {
                return;
            }
            d.this.v4(gamepadInfoB);
            v5.a.j().o(gamepadInfoB);
            y yVarC4 = d.this.c4();
            final d dVar = d.this;
            yVarC4.e(new Runnable() { // from class: com.flydigi.device_manager.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.W0(dVar);
                }
            });
        }

        @Override // h9.e, h9.c
        public void v0() {
            super.v0();
            y yVarC4 = d.this.c4();
            final d dVar = d.this;
            yVarC4.e(new Runnable() { // from class: com.flydigi.device_manager.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.X0(dVar);
                }
            });
        }

        @Override // h9.e, h9.c
        public void x0() {
            super.x0();
            y yVarC4 = d.this.c4();
            final d dVar = d.this;
            yVarC4.e(new Runnable() { // from class: com.flydigi.device_manager.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.Y0(dVar);
                }
            });
        }
    }

    public static final class b implements ServiceConnection {
        public b() {
        }

        public static final void b(d this$0) {
            f0.p(this$0, "this$0");
            GamepadInfo gamepadInfoO4 = this$0.o4();
            if (gamepadInfoO4 != null) {
                this$0.s4(gamepadInfoO4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@yt.l ComponentName componentName, @yt.l IBinder iBinder) {
            d.this.E7 = b.AbstractBinderC0365b.Q0(iBinder);
            try {
                h9.b bVar = d.this.E7;
                if (bVar != null) {
                    final d dVar = d.this;
                    bVar.O(dVar.G7);
                    if (dVar.H7 != null) {
                        bVar.S(dVar.H7);
                    }
                    GamepadInfo gamepadInfoB = DeviceInfo.b(bVar.E0());
                    if (n0.b(dVar.o4(), gamepadInfoB)) {
                        return;
                    }
                    dVar.v4(gamepadInfoB);
                    dVar.c4().e(new Runnable() { // from class: com.flydigi.device_manager.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.b.b(dVar);
                        }
                    });
                }
            } catch (RemoteException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@yt.l ComponentName componentName) {
            d.this.E7 = null;
        }
    }

    @yt.l
    public final GamepadInfo o4() {
        return this.K2;
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        Intent intent = new Intent(this, (Class<?>) FloatingWindow.class);
        intent.setAction(h9.b.class.getName());
        this.F7 = bindService(intent, this.I7, 65);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.F7) {
            unbindService(this.I7);
        }
    }

    public final boolean p4() {
        GamepadInfo gamepadInfo = this.K2;
        if (gamepadInfo != null) {
            return gamepadInfo.isConnected();
        }
        return false;
    }

    public final boolean q4() {
        GamepadInfo gamepadInfo = this.K2;
        if (gamepadInfo != null) {
            return gamepadInfo.isDriverConnected();
        }
        return false;
    }

    @yt.l
    public h9.d r4() {
        return null;
    }

    public void s4(@yt.k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
    }

    public void t4() {
    }

    public void u4() {
    }

    public final void v4(@yt.l GamepadInfo gamepadInfo) {
        this.K2 = gamepadInfo;
    }
}
