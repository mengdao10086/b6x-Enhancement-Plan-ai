package com.flydigi.cyberfox.h1.base;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.blankj.utilcode.util.y0;
import com.flydigi.base.common.FZFragment;
import com.flydigi.cyberfox.h1.services.GAIABREDRService;
import com.flydigi.cyberfox.h1.services.GAIAGATTBLEService;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.List;
import q9.f;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ServiceFragment extends FZFragment {

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final String f14119u8 = "CyberFoxFragment";

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public com.flydigi.cyberfox.h1.services.b f14120o8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public a f14122q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f14123r8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public final ServiceConnection f14121p8 = new b(this);

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public final int f14124s8 = 1;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public Runnable f14125t8 = new Runnable() { // from class: j6.a
        @Override // java.lang.Runnable
        public final void run() {
            this.f36184a.b6();
        }
    };

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ServiceFragment> f14126a;

        public a(ServiceFragment serviceFragment) {
            this.f14126a = new WeakReference<>(serviceFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ServiceFragment serviceFragment = this.f14126a.get();
            if (serviceFragment.f14123r8) {
                return;
            }
            serviceFragment.e6(message);
        }
    }

    public static class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ServiceFragment> f14127a;

        public b(ServiceFragment serviceFragment) {
            this.f14127a = new WeakReference<>(serviceFragment);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ServiceFragment serviceFragment = this.f14127a.get();
            if (componentName.getClassName().equals(GAIAGATTBLEService.class.getName())) {
                serviceFragment.f14120o8 = ((GAIAGATTBLEService.f) iBinder).a();
            } else if (componentName.getClassName().equals(GAIABREDRService.class.getName())) {
                serviceFragment.f14120o8 = ((GAIABREDRService.a) iBinder).a();
            }
            if (serviceFragment.f14120o8 != null) {
                serviceFragment.g6();
                serviceFragment.i6();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (componentName.getClassName().equals(GAIAGATTBLEService.class.getName())) {
                ServiceFragment serviceFragment = this.f14127a.get();
                serviceFragment.f14120o8 = null;
                serviceFragment.j6();
            }
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@p0 Bundle bundle) {
        super.K3(bundle);
        if (f.o().booleanValue()) {
            f6();
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        super.P3();
        com.flydigi.cyberfox.h1.services.b bVar = this.f14120o8;
        if (bVar != null) {
            bVar.t(this.f14122q8);
            this.f14120o8 = null;
            y0.m(this.f14121p8);
        }
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void a4() {
        super.a4();
        this.f14123r8 = true;
        G5().removeCallbacks(this.f14125t8);
    }

    public final void b6() {
        if (this.f14120o8.u() != null && this.f14120o8.C() != 0) {
            i6();
            return;
        }
        List<BluetoothDevice> listH = f.h();
        if (!listH.isEmpty()) {
            c6(listH.get(0));
            return;
        }
        h6();
        G5().removeCallbacks(this.f14125t8);
        G5().postDelayed(this.f14125t8, 1000L);
    }

    public final void c6(BluetoothDevice bluetoothDevice) {
        if (this.f14120o8 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("尝试与");
            sb2.append(bluetoothDevice.getName());
            sb2.append("进行连接");
            this.f14120o8.w(bluetoothDevice.getAddress());
        }
    }

    public int d6() {
        return 1;
    }

    public abstract void e6(Message message);

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void f4() {
        super.f4();
        this.f14123r8 = false;
        if (this.f14120o8 == null || !f.o().booleanValue()) {
            return;
        }
        g6();
    }

    public final void f6() {
        if (this.f14122q8 == null) {
            this.f14122q8 = new a(this);
        }
        k6();
    }

    public final void g6() {
        this.f14120o8.r(this.f14122q8);
        G5().removeCallbacks(this.f14125t8);
        G5().postDelayed(this.f14125t8, 1000L);
    }

    public abstract void h6();

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void i4() {
        super.i4();
    }

    public abstract void i6();

    public void j6() {
        G5().removeCallbacks(this.f14125t8);
        G5().postDelayed(this.f14125t8, 1000L);
    }

    public final void k6() {
        y0.b(GAIABREDRService.class, this.f14121p8, 1);
    }
}
