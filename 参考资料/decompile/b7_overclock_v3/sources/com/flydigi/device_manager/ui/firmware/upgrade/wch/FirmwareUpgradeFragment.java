package com.flydigi.device_manager.ui.firmware.upgrade.wch;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bj.e;
import c7.p0;
import cn.wch.blelib.exception.BLELibException;
import cn.wch.blelib.host.core.c;
import cn.wch.blelib.host.core.d;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.p1;
import com.flydigi.base.common.FZFragment;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment;
import dj.g;
import dj.o;
import g.n0;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import o5.l;
import xi.c0;
import xi.g0;
import xi.z;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class FirmwareUpgradeFragment extends FZFragment {

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public p0 f15112s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public BluetoothGattCharacteristic f15113t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public c f15114u8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public String f15108o8 = null;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public String f15109p8 = null;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public String f15110q8 = null;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f15111r8 = false;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public final z2.a f15115v8 = new b();

    public class a implements g0<String> {
        public a() {
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(@e String str) {
        }

        @Override // xi.g0
        public void onComplete() {
            FirmwareUpgradeFragment.this.f15114u8.a(true, "Success", 1, FirmwareUpgradeFragment.this.f15110q8);
        }

        @Override // xi.g0
        public void onError(@e Throwable th2) {
            FirmwareUpgradeFragment.this.f15114u8.a(false, th2.getMessage(), 1, FirmwareUpgradeFragment.this.f15110q8);
        }

        @Override // xi.g0
        public void onSubscribe(@e io.reactivex.disposables.b bVar) {
        }
    }

    public class b implements z2.a {
        public b() {
        }

        @Override // z2.a
        public void a(String str, Throwable th2) {
            e3.c.a("连接回调：" + th2.getMessage());
            FirmwareUpgradeFragment.this.u6(th2.getMessage());
        }

        @Override // z2.a
        public void b(String str) {
            FirmwareUpgradeFragment.this.w6();
        }

        @Override // z2.a
        public void c(String str, BluetoothDevice bluetoothDevice, int i10) {
            e3.c.a("连接回调：断开连接");
            FirmwareUpgradeFragment.this.x6();
        }

        @Override // z2.a
        public void d(String str) {
            FirmwareUpgradeFragment.this.u6("连接超时");
        }

        @Override // z2.a
        public void e(String str, d dVar) {
            FirmwareUpgradeFragment.this.f15109p8 = str;
            FirmwareUpgradeFragment.this.v6();
        }

        @Override // z2.a
        public void f(String str, List<BluetoothGattService> list) {
            FirmwareUpgradeFragment.this.y6(list);
        }
    }

    public interface c {
        void a(boolean z10, String str, int i10, String str2);
    }

    public static FirmwareUpgradeFragment m6(@k String str, @k String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(m7.a.f40701a, str);
        bundle.putString(m7.a.f40702b, str2);
        bundle.putString("key_device_code", str3);
        FirmwareUpgradeFragment firmwareUpgradeFragment = new FirmwareUpgradeFragment();
        firmwareUpgradeFragment.c5(bundle);
        return firmwareUpgradeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n6() {
        String strC3 = c3(a5.b.f(this.f15110q8));
        this.f15112s8.f10328d.setText(d3(R.string.device_firmware_upgrade_message, d3(R.string.device_firmware_upgrade_message_connecting, strC3), strC3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ File o6(String str) throws Exception {
        String str2 = this.f15108o8;
        for (File file : p1.g(str2, b0.A(str2))) {
            if (Objects.equals(b0.F(file), "bin")) {
                return file;
            }
        }
        throw new IOException();
    }

    public static /* synthetic */ void q6(Throwable th2) throws Exception {
        y2.a.e().d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r6() {
        this.f15112s8.f10328d.setText(d3(R.string.device_firmware_upgrade_message, c3(R.string.device_firmware_upgrade_message_uploading), c3(a5.b.f(this.f15110q8))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s6(int i10) {
        this.f15112s8.f10327c.setProgress(i10);
        this.f15112s8.f10329e.setText(String.format("%d%%", Integer.valueOf(i10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t6(File file, xi.b0 b0Var) throws Exception {
        Thread.currentThread().setPriority(10);
        if (!A6(new byte[]{-1, 90, -91}, 3)) {
            b0Var.onError(new Throwable(c3(R.string.device_firmware_upgrade_failed)));
            return;
        }
        if (!z6(file)) {
            b0Var.onError(new Throwable(c3(R.string.device_firmware_upgrade_failed)));
            return;
        }
        if (!A6(new byte[]{85, 85}, 2)) {
            b0Var.onError(new Throwable(c3(R.string.device_firmware_upgrade_failed)));
            return;
        }
        if (!A6(new byte[]{85, -86}, 2)) {
            b0Var.onError(new Throwable(c3(R.string.device_firmware_upgrade_failed)));
        } else if (A6(new byte[]{-86, -86}, 2)) {
            b0Var.onComplete();
        } else {
            b0Var.onError(new Throwable(c3(R.string.device_firmware_upgrade_failed)));
        }
    }

    public final boolean A6(byte[] bArr, int i10) {
        try {
            return y2.a.e().o(this.f15113t8, bArr, i10) == i10;
        } catch (BLELibException e10) {
            e3.c.a(e10.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: B6, reason: merged with bridge method [inline-methods] */
    public void p6(@n0 final File file) {
        z.r1(new c0() { // from class: m7.h
            @Override // xi.c0
            public final void a(xi.b0 b0Var) throws Exception {
                this.f40712a.t6(file, b0Var);
            }
        }).x1(2L, TimeUnit.SECONDS).J5(lj.b.e()).b4(aj.a.c()).c(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    public void H3(@n0 Context context) {
        super.H3(context);
        if (context instanceof c) {
            this.f15114u8 = (c) context;
        }
        try {
            y2.a.e().h(j1.a());
        } catch (BLELibException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void K3(@g.p0 Bundle bundle) {
        super.K3(bundle);
        if (T1() == null) {
            P4().finish();
            return;
        }
        this.f15110q8 = T1().getString("key_device_code");
        this.f15109p8 = T1().getString(m7.a.f40701a);
        this.f15108o8 = T1().getString(m7.a.f40702b);
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.device_fragment_firmware_upgrade;
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, androidx.fragment.app.Fragment
    @g.p0
    public View O3(@k LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, @g.p0 Bundle bundle) {
        p0 p0VarD = p0.d(layoutInflater, viewGroup, false);
        this.f15112s8 = p0VarD;
        return p0VarD.getRoot();
    }

    @Override // com.flydigi.base.common.FZFragment, com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void P3() {
        try {
            y2.a.e().d(true);
        } catch (BLELibException e10) {
            e10.printStackTrace();
        }
        super.P3();
    }

    @Override // com.flydigi.base.common.BaseFragment, com.flydigi.base.common.t
    public boolean V() {
        return true;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@n0 View view, @g.p0 Bundle bundle) {
        super.j4(view, bundle);
        com.bumptech.glide.b.F(this.f15112s8.f10326b).p(Integer.valueOf(R.drawable.device_firmware_upgrade_progress)).C0(Integer.MIN_VALUE).s1(this.f15112s8.f10326b);
        if (this.f15111r8) {
            return;
        }
        k6(this.f15109p8);
    }

    public void k6(String str) {
        try {
            y2.a.e().c(new c.b(str).d(10000L).c(), this.f15115v8);
        } catch (BLELibException e10) {
            e10.printStackTrace();
        }
    }

    public boolean l6(List<BluetoothGattService> list) {
        this.f15113t8 = null;
        for (BluetoothGattService bluetoothGattService : list) {
            if (bluetoothGattService.getUuid().toString().equalsIgnoreCase(m7.a.f40703c)) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(m7.a.f40704d)) {
                        this.f15113t8 = bluetoothGattCharacteristic;
                        bluetoothGattCharacteristic.setWriteType(1);
                    }
                }
            }
        }
        return this.f15113t8 != null;
    }

    public void u6(String str) {
        this.f15111r8 = false;
        this.f15114u8.a(false, str, 1, this.f15110q8);
    }

    public void v6() {
    }

    public final void w6() {
        this.f15111r8 = false;
        H5().e(new Runnable() { // from class: m7.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f40708a.n6();
            }
        });
    }

    public void x6() {
        this.f15111r8 = false;
    }

    public void y6(List<BluetoothGattService> list) {
        if (!l6(list)) {
            try {
                y2.a.e().d(false);
                return;
            } catch (BLELibException e10) {
                e10.printStackTrace();
                return;
            }
        }
        this.f15111r8 = true;
        String strG = b0.G(this.f15108o8);
        if (Objects.equals(strG, "bin")) {
            p6(new File(this.f15108o8));
            return;
        }
        if (Objects.equals(strG, "zip")) {
            z.m3(this.f15108o8).A3(new o() { // from class: m7.d
                @Override // dj.o
                public final Object apply(Object obj) {
                    return this.f40707a.o6((String) obj);
                }
            }).s0(l.d()).F5(new g() { // from class: m7.b
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    this.f40705a.p6((File) obj);
                }
            }, new g() { // from class: m7.c
                @Override // dj.g
                public final void accept(Object obj) throws Exception {
                    FirmwareUpgradeFragment.q6((Throwable) obj);
                }
            });
            return;
        }
        try {
            y2.a.e().d(false);
        } catch (BLELibException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.flydigi.base.common.y] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Runnable, m7.f] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00a2 -> B:103:0x00a5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z6(java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.firmware.upgrade.wch.FirmwareUpgradeFragment.z6(java.io.File):boolean");
    }
}
