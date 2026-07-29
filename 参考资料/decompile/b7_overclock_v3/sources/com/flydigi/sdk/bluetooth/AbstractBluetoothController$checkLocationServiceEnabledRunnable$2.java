package com.flydigi.sdk.bluetooth;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractBluetoothController$checkLocationServiceEnabledRunnable$2 extends Lambda implements ik.a<Runnable> {
    public final /* synthetic */ AbstractBluetoothController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBluetoothController$checkLocationServiceEnabledRunnable$2(AbstractBluetoothController abstractBluetoothController) {
        super(0);
        this.this$0 = abstractBluetoothController;
    }

    public static final void f(AbstractBluetoothController this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        AbstractBluetoothController.x(this$0, null, 1, null);
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Runnable o() {
        final AbstractBluetoothController abstractBluetoothController = this.this$0;
        return new Runnable() { // from class: com.flydigi.sdk.bluetooth.f
            @Override // java.lang.Runnable
            public final void run() {
                AbstractBluetoothController$checkLocationServiceEnabledRunnable$2.f(abstractBluetoothController);
            }
        };
    }
}
