package com.flydigi.sdk.bluetooth;

import java.util.Iterator;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$removeBondTimeoutRunnable$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1127:1\n1855#2,2:1128\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$removeBondTimeoutRunnable$2\n*L\n347#1:1128,2\n*E\n"})
public final class AbstractBluetoothController$removeBondTimeoutRunnable$2 extends Lambda implements ik.a<Runnable> {
    public final /* synthetic */ AbstractBluetoothController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBluetoothController$removeBondTimeoutRunnable$2(AbstractBluetoothController abstractBluetoothController) {
        super(0);
        this.this$0 = abstractBluetoothController;
    }

    public static final void f(AbstractBluetoothController this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        Iterator it2 = this$0.f16224n.iterator();
        while (it2.hasNext()) {
            ((n) it2.next()).y(this$0.M());
        }
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Runnable o() {
        final AbstractBluetoothController abstractBluetoothController = this.this$0;
        return new Runnable() { // from class: com.flydigi.sdk.bluetooth.k
            @Override // java.lang.Runnable
            public final void run() {
                AbstractBluetoothController$removeBondTimeoutRunnable$2.f(abstractBluetoothController);
            }
        };
    }
}
