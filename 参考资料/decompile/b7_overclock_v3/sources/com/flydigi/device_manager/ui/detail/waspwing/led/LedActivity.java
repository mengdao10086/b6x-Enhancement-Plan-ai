package com.flydigi.device_manager.ui.detail.waspwing.led;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.m0;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import com.blankj.utilcode.util.ToastUtils;
import com.flydigi.base.common.p;
import com.flydigi.base.widget.DividerPaddingLinearLayout;
import com.flydigi.device_manager.R;
import com.flydigi.sdk.waspwing.LedData;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.slider.Slider;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.sequences.SequencesKt___SequencesKt;
import t9.i;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nLedActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 Handler.kt\nandroidx/core/os/HandlerKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,449:1\n1855#2,2:450\n1864#2,3:452\n1864#2,3:471\n45#3:455\n45#3:474\n33#4,12:456\n13654#5,3:468\n*S KotlinDebug\n*F\n+ 1 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity\n*L\n345#1:450,2\n355#1:452,3\n290#1:471,3\n211#1:455\n379#1:474\n226#1:456,12\n275#1:468,3\n*E\n"})
public final class LedActivity extends p implements t9.i {

    @yt.k
    public static final a K7 = new a(null);

    @yt.k
    public static final androidx.collection.a<Integer, byte[]> L7;

    @yt.k
    public static final ArrayList<Integer> M7;
    public c F7;

    @yt.l
    public WaspWingInfo G7;
    public int H7;
    public c7.h K2;

    @yt.k
    public List<b> E7 = CollectionsKt__CollectionsKt.E();
    public boolean I7 = true;

    @yt.k
    public final Runnable J7 = new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.m
        @Override // java.lang.Runnable
        public final void run() {
            LedActivity.U4(this.f14800a);
        }
    };

    @t0({"SMAP\nLedActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,449:1\n1#2:450\n*E\n"})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final Intent a(@yt.k Context context, @yt.k WaspWingInfo deviceInfo) {
            f0.p(context, "context");
            f0.p(deviceInfo, "deviceInfo");
            Intent intent = new Intent(context, (Class<?>) LedActivity.class);
            intent.putExtra("key_device_info", deviceInfo);
            return intent;
        }

        @yt.k
        public final ArrayList<Integer> b() {
            return LedActivity.M7;
        }

        @yt.k
        public final androidx.collection.a<Integer, byte[]> c() {
            return LedActivity.L7;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14769a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final String f14770b;

        public b(int i10, @yt.k String name) {
            f0.p(name, "name");
            this.f14769a = i10;
            this.f14770b = name;
        }

        public static /* synthetic */ b d(b bVar, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = bVar.f14769a;
            }
            if ((i11 & 2) != 0) {
                str = bVar.f14770b;
            }
            return bVar.c(i10, str);
        }

        public final int a() {
            return this.f14769a;
        }

        @yt.k
        public final String b() {
            return this.f14770b;
        }

        @yt.k
        public final b c(int i10, @yt.k String name) {
            f0.p(name, "name");
            return new b(i10, name);
        }

        @yt.k
        public final String e() {
            return this.f14770b;
        }

        public boolean equals(@yt.l Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14769a == bVar.f14769a && f0.g(this.f14770b, bVar.f14770b);
        }

        public final int f() {
            return this.f14769a;
        }

        public int hashCode() {
            return (this.f14769a * 31) + this.f14770b.hashCode();
        }

        @yt.k
        public String toString() {
            return this.f14770b;
        }
    }

    public static final class c extends ArrayAdapter<b> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@yt.k Context context) {
            super(context, R.layout.device_item_led_type);
            f0.p(context, "context");
        }
    }

    @t0({"SMAP\nLedActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity$onCreate$7\n+ 2 Handler.kt\nandroidx/core/os/HandlerKt\n*L\n1#1,449:1\n33#2,12:450\n*S KotlinDebug\n*F\n+ 1 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity$onCreate$7\n*L\n200#1:450,12\n*E\n"})
    public static final class d implements AdapterView.OnItemSelectedListener {

        @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity$onCreate$7\n*L\n1#1,69:1\n201#2,2:70\n*E\n"})
        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LedActivity f14772a;

            public a(LedActivity ledActivity) {
                this.f14772a = ledActivity;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f14772a.I7 = true;
            }
        }

        public d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(@yt.l AdapterView<?> adapterView, @yt.l View view, int i10, long j10) {
            t9.j.P(t9.j.f50990a, ((b) LedActivity.this.E7.get(i10)).f(), null, null, null, 14, null);
            LedActivity.this.H7 = 0;
            Handler handler = LedActivity.this.b4();
            f0.o(handler, "handler");
            handler.postDelayed(new a(LedActivity.this), 250L);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(@yt.l AdapterView<?> adapterView) {
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 LedActivity.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/LedActivity\n*L\n1#1,69:1\n227#2,2:70\n*E\n"})
    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            LedActivity.this.I7 = true;
        }
    }

    static {
        androidx.collection.a<Integer, byte[]> aVar = new androidx.collection.a<>();
        L7 = aVar;
        M7 = CollectionsKt__CollectionsKt.r(Integer.valueOf(Color.parseColor("#FF0000")), Integer.valueOf(Color.parseColor("#FF6A00")), Integer.valueOf(Color.parseColor("#FFFF00")), Integer.valueOf(Color.parseColor("#00FF00")), Integer.valueOf(Color.parseColor("#00FFFF")), Integer.valueOf(Color.parseColor("#0000FF")), Integer.valueOf(Color.parseColor("#9A00FF")), Integer.valueOf(Color.parseColor("#FF0080")));
        aVar.put(4, ArraysKt___ArraysKt.Rr(new byte[]{3, 5, 8}));
        aVar.put(3, ArraysKt___ArraysKt.Rr(new byte[]{2, 4, 6}));
        aVar.put(5, ArraysKt___ArraysKt.Rr(new byte[]{3, 5, 8}));
        aVar.put(6, ArraysKt___ArraysKt.Rr(new byte[]{6, 8, 10}));
    }

    @hk.m
    @yt.k
    public static final Intent E4(@yt.k Context context, @yt.k WaspWingInfo waspWingInfo) {
        return K7.a(context, waspWingInfo);
    }

    public static final boolean H4(final LedActivity this$0, final int i10, final View view) {
        f0.p(this$0, "this$0");
        f0.o(view, "view");
        this$0.L4(view, i10);
        m0 m0Var = new m0(this$0, view);
        m0Var.g(R.menu.device_menu_waspwing_led_color);
        m0Var.k(new m0.e() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.i
            @Override // androidx.appcompat.widget.m0.e
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return LedActivity.I4(this.f14794a, view, i10, menuItem);
            }
        });
        m0Var.l();
        return true;
    }

    public static final boolean I4(LedActivity this$0, View view, int i10, MenuItem menuItem) {
        f0.p(this$0, "this$0");
        if (menuItem.getItemId() == R.id.menu_delete) {
            c7.h hVar = this$0.K2;
            c7.h hVar2 = null;
            if (hVar == null) {
                f0.S("viewBinding");
                hVar = null;
            }
            DividerPaddingLinearLayout dividerPaddingLinearLayout = hVar.f10054b;
            f0.o(dividerPaddingLinearLayout, "viewBinding.areaColors");
            if (dividerPaddingLinearLayout.getChildCount() == 3) {
                ToastUtils.P(R.string.device_waspwing_led_color_limit);
                return true;
            }
            c7.h hVar3 = this$0.K2;
            if (hVar3 == null) {
                f0.S("viewBinding");
                hVar3 = null;
            }
            hVar3.f10054b.removeView(view);
            c7.h hVar4 = this$0.K2;
            if (hVar4 == null) {
                f0.S("viewBinding");
                hVar4 = null;
            }
            ShapeableImageView shapeableImageView = hVar4.f10061i;
            f0.o(shapeableImageView, "viewBinding.ivAdd");
            o5.c.b(shapeableImageView, Boolean.TRUE, false, 2, null);
            c7.h hVar5 = this$0.K2;
            if (hVar5 == null) {
                f0.S("viewBinding");
            } else {
                hVar2 = hVar5;
            }
            View childAt = hVar2.f10054b.getChildAt(0);
            f0.o(childAt, "viewBinding.areaColors.getChildAt(0)");
            this$0.L4(childAt, i10);
            this$0.b4().removeCallbacks(this$0.J7);
            this$0.b4().post(this$0.J7);
        }
        return true;
    }

    public static final void J4(LedActivity this$0, int i10, View view) {
        f0.p(this$0, "this$0");
        f0.o(view, "view");
        this$0.L4(view, i10);
    }

    public static final void M4(LedActivity this$0, Slider slider, float f10, boolean z10) {
        WaspWingInfo waspWingInfo;
        LedData ledData;
        f0.p(this$0, "this$0");
        f0.p(slider, "<anonymous parameter 0>");
        if (!z10 || (waspWingInfo = this$0.G7) == null || (ledData = waspWingInfo.getLedData()) == null) {
            return;
        }
        t9.j.f50990a.O(ledData.C(), Integer.valueOf(ledData.M()), ledData.z(), Integer.valueOf((int) f10));
    }

    public static final void N4(LedActivity this$0, View view) {
        f0.p(this$0, "this$0");
        com.flydigi.device_manager.ui.detail.waspwing.led.a aVarG4 = this$0.G4(-1);
        c7.h hVar = this$0.K2;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        DividerPaddingLinearLayout dividerPaddingLinearLayout = hVar.f10054b;
        c7.h hVar2 = this$0.K2;
        if (hVar2 == null) {
            f0.S("viewBinding");
            hVar2 = null;
        }
        DividerPaddingLinearLayout dividerPaddingLinearLayout2 = hVar2.f10054b;
        f0.o(dividerPaddingLinearLayout2, "viewBinding.areaColors");
        dividerPaddingLinearLayout.addView(aVarG4, dividerPaddingLinearLayout2.getChildCount() - 1);
        c7.h hVar3 = this$0.K2;
        if (hVar3 == null) {
            f0.S("viewBinding");
            hVar3 = null;
        }
        ShapeableImageView shapeableImageView = hVar3.f10061i;
        f0.o(shapeableImageView, "viewBinding.ivAdd");
        c7.h hVar4 = this$0.K2;
        if (hVar4 == null) {
            f0.S("viewBinding");
            hVar4 = null;
        }
        o5.c.b(shapeableImageView, Boolean.valueOf(hVar4.f10054b.getChildCount() != 9), false, 2, null);
        this$0.L4(aVarG4, -1);
        this$0.b4().post(this$0.J7);
    }

    public static final void O4(LedActivity this$0, View view) {
        LedData ledData;
        f0.p(this$0, "this$0");
        WaspWingInfo waspWingInfo = this$0.G7;
        if (waspWingInfo == null || (ledData = waspWingInfo.getLedData()) == null) {
            return;
        }
        t9.j.f50990a.O(ledData.C(), Integer.valueOf(ledData.M()), M7, Integer.valueOf(ledData.F()));
        Handler handler = this$0.b4();
        f0.o(handler, "handler");
        handler.postDelayed(this$0.new e(), 250L);
    }

    public static final void P4(LedActivity this$0, CompoundButton compoundButton, boolean z10) {
        f0.p(this$0, "this$0");
        c7.h hVar = this$0.K2;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        ConstraintLayout constraintLayout = hVar.f10055c;
        f0.o(constraintLayout, "viewBinding.areaLedConfig");
        o5.c.b(constraintLayout, Boolean.valueOf(z10), false, 2, null);
        if (!z10) {
            t9.j.f50990a.Q();
            return;
        }
        t9.j jVar = t9.j.f50990a;
        jVar.R();
        jVar.G(0);
    }

    public static final void Q4(LedActivity this$0, Slider slider, float f10, boolean z10) {
        WaspWingInfo waspWingInfo;
        LedData ledData;
        byte[] bArr;
        f0.p(this$0, "this$0");
        f0.p(slider, "<anonymous parameter 0>");
        if (!z10 || (waspWingInfo = this$0.G7) == null || (ledData = waspWingInfo.getLedData()) == null || (bArr = L7.get(Integer.valueOf(ledData.C()))) == null) {
            return;
        }
        t9.j.f50990a.O(ledData.C(), Integer.valueOf(bArr[(int) f10]), ledData.z(), Integer.valueOf(ledData.F()));
    }

    public static final void R4(LedActivity this$0, WaspWingInfo waspWingInfo) {
        f0.p(this$0, "this$0");
        f0.p(waspWingInfo, "$waspWingInfo");
        c7.h hVar = this$0.K2;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        if (hVar.f10064l.isChecked() != waspWingInfo.getLightState()) {
            c7.h hVar2 = this$0.K2;
            if (hVar2 == null) {
                f0.S("viewBinding");
                hVar2 = null;
            }
            hVar2.f10064l.setChecked(waspWingInfo.getLightState());
        }
        c7.h hVar3 = this$0.K2;
        if (hVar3 == null) {
            f0.S("viewBinding");
            hVar3 = null;
        }
        ConstraintLayout constraintLayout = hVar3.f10055c;
        f0.o(constraintLayout, "viewBinding.areaLedConfig");
        o5.c.b(constraintLayout, Boolean.valueOf(waspWingInfo.getLightState()), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void S4(com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity r13, com.flydigi.sdk.waspwing.LedData r14, com.flydigi.sdk.waspwing.WaspWingInfo r15) {
        /*
            Method dump skipped, instruction units count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity.S4(com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity, com.flydigi.sdk.waspwing.LedData, com.flydigi.sdk.waspwing.WaspWingInfo):void");
    }

    public static final void T4(LedActivity this$0) {
        f0.p(this$0, "this$0");
        this$0.finish();
    }

    public static final void U4(LedActivity this$0) {
        LedData ledData;
        f0.p(this$0, "this$0");
        c7.h hVar = this$0.K2;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        DividerPaddingLinearLayout dividerPaddingLinearLayout = hVar.f10054b;
        f0.o(dividerPaddingLinearLayout, "viewBinding.areaColors");
        List listC3 = SequencesKt___SequencesKt.c3(SequencesKt___SequencesKt.k1(SequencesKt___SequencesKt.p0(ViewGroupKt.e(dividerPaddingLinearLayout), new ik.l<View, Boolean>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity$updateColorRunnable$1$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean i(@yt.k View it2) {
                f0.p(it2, "it");
                return Boolean.valueOf(it2.getId() != R.id.iv_add);
            }
        }), new ik.l<View, Integer>() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity$updateColorRunnable$1$2
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer i(@yt.k View it2) {
                f0.p(it2, "it");
                return Integer.valueOf(((a) it2).getCurrentColor$device_manager_officialRelease());
            }
        }));
        WaspWingInfo waspWingInfo = this$0.G7;
        if (waspWingInfo == null || (ledData = waspWingInfo.getLedData()) == null) {
            return;
        }
        t9.j.f50990a.O(ledData.C(), Integer.valueOf(ledData.M()), new ArrayList<>(listC3), Integer.valueOf(ledData.F()));
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void A(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.b(this, bluetoothDevice);
    }

    @Override // t9.i
    public void F1(@yt.k final WaspWingInfo waspWingInfo) {
        f0.p(waspWingInfo, "waspWingInfo");
        runOnUiThread(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.d
            @Override // java.lang.Runnable
            public final void run() {
                LedActivity.R4(this.f14786a, waspWingInfo);
            }
        });
        final LedData ledData = waspWingInfo.getLedData();
        if (ledData != null) {
            runOnUiThread(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.c
                @Override // java.lang.Runnable
                public final void run() {
                    LedActivity.S4(this.f14783a, ledData, waspWingInfo);
                }
            });
            this.G7 = waspWingInfo.copy(((-1) & 1) != 0 ? waspWingInfo.deviceName : null, ((-1) & 2) != 0 ? waspWingInfo.address : null, ((-1) & 4) != 0 ? waspWingInfo.isConnected : false, ((-1) & 8) != 0 ? waspWingInfo.deviceCode : null, ((-1) & 16) != 0 ? waspWingInfo.firmwareVersion : null, ((-1) & 32) != 0 ? waspWingInfo.lightState : false, ((-1) & 64) != 0 ? waspWingInfo.windLevel : 0, ((-1) & 128) != 0 ? waspWingInfo.coldLevel : 0, ((-1) & 256) != 0 ? waspWingInfo.temperature : 0, ((-1) & 512) != 0 ? waspWingInfo.temperatureDecimal : 0, ((-1) & 1024) != 0 ? waspWingInfo.runMode : 0, ((-1) & 2048) != 0 ? waspWingInfo.targetTemperature : 0, ((-1) & 4096) != 0 ? waspWingInfo.overClockUsable : false, ((-1) & 8192) != 0 ? waspWingInfo.overClockUsableLevel : 0, ((-1) & 16384) != 0 ? waspWingInfo.windLevelOverclock : 0, ((-1) & 32768) != 0 ? waspWingInfo.coldLevelOverclock : 0, ((-1) & 65536) != 0 ? waspWingInfo.speed : 0, ((-1) & 131072) != 0 ? waspWingInfo.windRunLevel : 0, ((-1) & 262144) != 0 ? waspWingInfo.coldRunLevel : 0, ((-1) & 524288) != 0 ? waspWingInfo.ledType : 0, ((-1) & 1048576) != 0 ? waspWingInfo.hotSurfaceTemperature : (byte) 0, ((-1) & 2097152) != 0 ? waspWingInfo.ledData : null, ((-1) & 4194304) != 0 ? waspWingInfo.coldProtection : false, ((-1) & 8388608) != 0 ? waspWingInfo.hotProtection : false, ((-1) & 16777216) != 0 ? waspWingInfo.hotProtectionEnabled : false, ((-1) & CommonNetImpl.FLAG_SHARE_JUMP) != 0 ? waspWingInfo.coldProtectionEnabled : false, ((-1) & 67108864) != 0 ? waspWingInfo.tempHistories : null, ((-1) & 134217728) != 0 ? waspWingInfo.ipType : 0, ((-1) & 268435456) != 0 ? waspWingInfo.modeCustom : 0, ((-1) & 536870912) != 0 ? waspWingInfo.isExperimentalRunModeOn : false, ((-1) & 1073741824) != 0 ? waspWingInfo.experimentalRunModeValue : null, ((-1) & Integer.MIN_VALUE) != 0 ? waspWingInfo.uuid : null, (1 & 1) != 0 ? waspWingInfo.quickSwitchRunMode : 0);
        }
    }

    public final void F4(LedData ledData) {
        c7.h hVar = this.K2;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        DividerPaddingLinearLayout dividerPaddingLinearLayout = hVar.f10054b;
        c7.h hVar2 = this.K2;
        if (hVar2 == null) {
            f0.S("viewBinding");
            hVar2 = null;
        }
        dividerPaddingLinearLayout.removeViews(0, hVar2.f10054b.getChildCount() - 1);
        int i10 = 0;
        for (Object obj : ledData.z()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            int iIntValue = ((Number) obj).intValue();
            c7.h hVar3 = this.K2;
            if (hVar3 == null) {
                f0.S("viewBinding");
                hVar3 = null;
            }
            hVar3.f10054b.addView(G4(iIntValue), i10);
            i10 = i11;
        }
        c7.h hVar4 = this.K2;
        if (hVar4 == null) {
            f0.S("viewBinding");
            hVar4 = null;
        }
        View childAt = hVar4.f10054b.getChildAt(this.H7);
        childAt.setSelected(true);
        if (childAt instanceof com.flydigi.device_manager.ui.detail.waspwing.led.a) {
            c7.h hVar5 = this.K2;
            if (hVar5 == null) {
                f0.S("viewBinding");
                hVar5 = null;
            }
            hVar5.f10060h.setColor(((com.flydigi.device_manager.ui.detail.waspwing.led.a) childAt).getCurrentColor$device_manager_officialRelease());
        }
        c7.h hVar6 = this.K2;
        if (hVar6 == null) {
            f0.S("viewBinding");
            hVar6 = null;
        }
        ShapeableImageView shapeableImageView = hVar6.f10061i;
        f0.o(shapeableImageView, "viewBinding.ivAdd");
        o5.c.b(shapeableImageView, Boolean.valueOf(ledData.z().size() != 8), false, 2, null);
    }

    public final com.flydigi.device_manager.ui.detail.waspwing.led.a G4(final int i10) {
        com.flydigi.device_manager.ui.detail.waspwing.led.a aVar = new com.flydigi.device_manager.ui.detail.waspwing.led.a(this, null, 0, 6, null);
        aVar.setCurrentColor$device_manager_officialRelease(i10);
        int dimensionPixelSize = aVar.getResources().getDimensionPixelSize(R.dimen.qb_px_24);
        aVar.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        aVar.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.g
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return LedActivity.H4(this.f14791a, i10, view);
            }
        });
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LedActivity.J4(this.f14789a, i10, view);
            }
        });
        return aVar;
    }

    public final String K4(int i10) {
        for (b bVar : this.E7) {
            if (bVar.f() == i10) {
                return bVar.e();
            }
        }
        return "";
    }

    public final void L4(View view, int i10) {
        c7.h hVar = this.K2;
        c7.h hVar2 = null;
        if (hVar == null) {
            f0.S("viewBinding");
            hVar = null;
        }
        hVar.f10054b.getChildAt(this.H7).setSelected(false);
        c7.h hVar3 = this.K2;
        if (hVar3 == null) {
            f0.S("viewBinding");
            hVar3 = null;
        }
        this.H7 = hVar3.f10054b.indexOfChild(view);
        view.setSelected(true);
        c7.h hVar4 = this.K2;
        if (hVar4 == null) {
            f0.S("viewBinding");
        } else {
            hVar2 = hVar4;
        }
        hVar2.f10060h.setColor(i10);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void O2(@yt.k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        i.a.e(this, gatt);
        runOnUiThread(new Runnable() { // from class: com.flydigi.device_manager.ui.detail.waspwing.led.l
            @Override // java.lang.Runnable
            public final void run() {
                LedActivity.T4(this.f14799a);
            }
        });
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void V0(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.d(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void e2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.c(this, bluetoothDevice);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.device_activity_waspwing_led;
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void g2(@yt.k BluetoothDevice bluetoothDevice) {
        i.a.a(this, bluetoothDevice);
    }

    @Override // com.flydigi.sdk.bluetooth.w
    public void k1(int i10) {
        i.a.f(this, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(@yt.l android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.device_manager.ui.detail.waspwing.led.LedActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        t9.j.e0(this);
        super.onDestroy();
    }

    @Override // com.flydigi.base.common.c, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        t9.j.f50990a.G(0);
    }

    @Override // t9.i
    public void q2(@yt.k byte[] bArr) {
        i.a.g(this, bArr);
    }

    @Override // androidx.appcompat.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        c7.h hVarC = c7.h.c(getLayoutInflater());
        f0.o(hVarC, "inflate(layoutInflater)");
        this.K2 = hVarC;
        if (hVarC == null) {
            f0.S("viewBinding");
            hVarC = null;
        }
        setContentView(hVarC.getRoot());
    }
}
