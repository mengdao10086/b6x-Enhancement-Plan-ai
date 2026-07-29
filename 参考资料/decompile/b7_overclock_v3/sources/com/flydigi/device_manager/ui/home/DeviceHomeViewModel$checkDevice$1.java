package com.flydigi.device_manager.ui.home;

import com.flydigi.data.DataConstant;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.headset.HeadsetInfo;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes7.dex */
@zj.d(c = "com.flydigi.device_manager.ui.home.DeviceHomeViewModel$checkDevice$1", f = "DeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceHomeViewModel$checkDevice$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public int label;
    public final /* synthetic */ DeviceHomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceHomeViewModel$checkDevice$1(DeviceHomeViewModel deviceHomeViewModel, kotlin.coroutines.c<? super DeviceHomeViewModel$checkDevice$1> cVar) {
        super(2, cVar);
        this.this$0 = deviceHomeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new DeviceHomeViewModel$checkDevice$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        WaspWingInfo waspWingInfoK = v5.a.j().k();
        HeadsetInfo headsetInfoI = v5.a.j().i();
        GamepadInfo gamepadInfoD = v5.a.j().d();
        int iN = o5.m.i().n(DataConstant.SP_APP_LASTEST_CONNECTED_DEVICE_TYPE, 0);
        DeviceHomeViewModel deviceHomeViewModel = this.this$0;
        if (iN == 1 && !androidx.core.util.j.a(gamepadInfoD.getDeviceCode(), "all")) {
            deviceHomeViewModel.f15126d.o(gamepadInfoD);
        } else if (iN == 2 && headsetInfoI != null && !androidx.core.util.j.a(headsetInfoI.getDeviceCode(), "all")) {
            deviceHomeViewModel.f15126d.o(headsetInfoI);
        } else if (iN != 3 || waspWingInfoK == null || androidx.core.util.j.a(waspWingInfoK.getDeviceCode(), "all")) {
            deviceHomeViewModel.f15126d.o(new o());
        } else {
            deviceHomeViewModel.f15126d.o(waspWingInfoK);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((DeviceHomeViewModel$checkDevice$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
