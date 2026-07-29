package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1127:1\n1855#2,2:1128\n1#3:1130\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$createBondTimeoutRunnable$2\n*L\n340#1:1128,2\n*E\n"})
public final class AbstractBluetoothController$createBondTimeoutRunnable$2 extends Lambda implements ik.a<Runnable> {
    public final /* synthetic */ AbstractBluetoothController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBluetoothController$createBondTimeoutRunnable$2(AbstractBluetoothController abstractBluetoothController) {
        super(0);
        this.this$0 = abstractBluetoothController;
    }

    public static final void f(AbstractBluetoothController this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Iterator it2 = this$0.f16224n.iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).i0(this$0.M());
        }
        BluetoothDevice bluetoothDeviceM = this$0.M();
        if (bluetoothDeviceM != null) {
            this$0.v(bluetoothDeviceM);
        }
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Runnable o() {
        final AbstractBluetoothController abstractBluetoothController = this.this$0;
        return new Runnable() { // from class: com.flydigi.sdk.bluetooth.g
            @Override // java.lang.Runnable
            public final void run() {
                AbstractBluetoothController$createBondTimeoutRunnable$2.f(abstractBluetoothController);
            }
        };
    }
}
