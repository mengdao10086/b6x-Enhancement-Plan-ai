package com.flydigi.sdk.bluetooth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import com.flydigi.sdk.bluetooth.AbstractBluetoothController;
import com.flydigi.sdk.bluetooth.data.BleDevice;
import com.flydigi.sdk.bluetooth.m;
import com.flydigi.sdk.bluetooth.u;
import com.umeng.socialize.common.SocializeConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v0;
import kotlin.z1;
import rx_activity_result2.RxActivityResult;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1127:1\n1855#2,2:1128\n1855#2,2:1130\n1855#2,2:1132\n1855#2,2:1134\n1855#2,2:1136\n1855#2,2:1138\n1855#2,2:1140\n1855#2,2:1142\n1855#2,2:1144\n1855#2,2:1146\n1855#2,2:1148\n1855#2,2:1150\n1855#2,2:1152\n1855#2,2:1154\n1855#2,2:1156\n1855#2,2:1158\n1855#2,2:1161\n1855#2,2:1163\n1855#2,2:1165\n1855#2,2:1167\n1855#2,2:1169\n1855#2,2:1171\n1855#2,2:1173\n1855#2,2:1175\n1855#2,2:1177\n1855#2,2:1179\n1855#2,2:1181\n1855#2,2:1183\n1855#2,2:1185\n1855#2,2:1187\n1855#2,2:1189\n1855#2,2:1191\n1855#2,2:1193\n1855#2,2:1195\n1855#2,2:1197\n1#3:1160\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController\n*L\n393#1:1128,2\n419#1:1130,2\n461#1:1132,2\n486#1:1134,2\n506#1:1136,2\n538#1:1138,2\n575#1:1140,2\n605#1:1142,2\n661#1:1144,2\n672#1:1146,2\n706#1:1148,2\n739#1:1150,2\n759#1:1152,2\n762#1:1154,2\n764#1:1156,2\n776#1:1158,2\n806#1:1161,2\n811#1:1163,2\n817#1:1165,2\n833#1:1167,2\n838#1:1169,2\n851#1:1171,2\n877#1:1173,2\n900#1:1175,2\n907#1:1177,2\n921#1:1179,2\n938#1:1181,2\n950#1:1183,2\n996#1:1185,2\n1007#1:1187,2\n1025#1:1189,2\n1037#1:1191,2\n1041#1:1193,2\n559#1:1195,2\n591#1:1197,2\n*E\n"})
public abstract class AbstractBluetoothController {

    @yt.k
    public static final a C = new a(null);
    public static final long D = 15000;

    @yt.k
    public final kotlin.z A;

    @yt.k
    public final kotlin.z B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Context f16211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final u f16212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public BluetoothDevice f16214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f16215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f16216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f16217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public BluetoothManager f16219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public BluetoothAdapter f16220j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.l
    public BluetoothProfile f16221k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public ArrayList<m> f16222l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public ArrayList<e0> f16223m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public ArrayList<n> f16224n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public ArrayList<t> f16225o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16226p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f16227q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f16228r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16229s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public final d f16230t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public final b f16231u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public final c f16232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @yt.k
    public final e f16233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @yt.k
    public final kotlin.z f16234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @yt.k
    public final g f16235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @yt.k
    public final kotlin.z f16236z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public static final class b extends BroadcastReceiver {
        public b() {
        }

        public final String a(int i10) {
            switch (i10) {
                case 10:
                    return "已关闭";
                case 11:
                    return "正在打开";
                case 12:
                    return "已打开";
                case 13:
                    return "正在关闭";
                default:
                    return "未知状态";
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@yt.k Context context, @yt.k Intent intent) {
            kotlin.jvm.internal.f0.p(context, "context");
            kotlin.jvm.internal.f0.p(intent, "intent");
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
            l9.a.c("[Broadcast] Action received: android.bluetooth.adapter.action.STATE_CHANGED state changed form " + a(intExtra2) + " to " + a(intExtra));
            if (intExtra == 10 && intExtra2 == 13) {
                AbstractBluetoothController.this.b0();
            } else if (intExtra == 12 && intExtra2 == 11) {
                AbstractBluetoothController.this.c0();
            }
        }
    }

    @t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1127:1\n1855#2,2:1128\n1855#2,2:1130\n1855#2,2:1132\n1855#2,2:1134\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mBondStateReceiver$1\n*L\n188#1:1128,2\n190#1:1130,2\n199#1:1132,2\n207#1:1134,2\n*E\n"})
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        public static final void c(AbstractBluetoothController this$0, BluetoothDevice bluetoothDevice) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this$0.A(bluetoothDevice);
        }

        public final String b(int i10) {
            switch (i10) {
                case 10:
                    return "未配对";
                case 11:
                    return "正在配对中";
                case 12:
                    return "已配对";
                default:
                    return "未知";
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@yt.k Context context, @yt.k Intent intent) {
            kotlin.jvm.internal.f0.p(context, "context");
            kotlin.jvm.internal.f0.p(intent, "intent");
            final BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
            if (bluetoothDevice != null && AbstractBluetoothController.this.Z(bluetoothDevice) && u.a.a(AbstractBluetoothController.this.J(), bluetoothDevice.getName(), 0, 2, null)) {
                v0 v0Var = v0.f37964a;
                String str = String.format("bond state changed from " + b(intExtra2) + " to: " + b(intExtra), Arrays.copyOf(new Object[0], 0));
                kotlin.jvm.internal.f0.o(str, "format(format, *args)");
                l9.a.c(str);
                if (intExtra != 10) {
                    if (intExtra != 12) {
                        return;
                    }
                    AbstractBluetoothController.this.O().removeCallbacks(AbstractBluetoothController.this.I());
                    AbstractBluetoothController.this.O().removeCallbacks(AbstractBluetoothController.this.R());
                    if (intExtra2 == 11) {
                        AbstractBluetoothController.this.z(bluetoothDevice);
                        Iterator it2 = AbstractBluetoothController.this.f16224n.iterator();
                        while (it2.hasNext()) {
                            ((n) it2.next()).p2(bluetoothDevice, true);
                        }
                        return;
                    }
                    if (intExtra2 != 12) {
                        return;
                    }
                    Iterator it3 = AbstractBluetoothController.this.f16224n.iterator();
                    while (it3.hasNext()) {
                        ((n) it3.next()).G0(bluetoothDevice, false);
                    }
                    return;
                }
                AbstractBluetoothController.this.O().removeCallbacks(AbstractBluetoothController.this.I());
                AbstractBluetoothController.this.O().removeCallbacks(AbstractBluetoothController.this.R());
                if (intExtra2 == 11) {
                    Iterator it4 = AbstractBluetoothController.this.f16224n.iterator();
                    while (it4.hasNext()) {
                        ((n) it4.next()).p2(bluetoothDevice, false);
                    }
                } else {
                    if (intExtra2 != 12) {
                        return;
                    }
                    if (!AbstractBluetoothController.this.f16229s) {
                        Iterator it5 = AbstractBluetoothController.this.f16224n.iterator();
                        while (it5.hasNext()) {
                            ((n) it5.next()).G0(bluetoothDevice, true);
                        }
                    } else {
                        AbstractBluetoothController.this.f16229s = false;
                        Handler handlerO = AbstractBluetoothController.this.O();
                        final AbstractBluetoothController abstractBluetoothController = AbstractBluetoothController.this;
                        handlerO.postDelayed(new Runnable() { // from class: com.flydigi.sdk.bluetooth.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                AbstractBluetoothController.c.c(abstractBluetoothController, bluetoothDevice);
                            }
                        }, 250L);
                    }
                }
            }
        }
    }

    @t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1127:1\n1855#2,2:1128\n1855#2,2:1130\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$mClassicScanReceiver$1\n*L\n88#1:1128,2\n92#1:1130,2\n*E\n"})
    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@yt.k Context context, @yt.k Intent intent) {
            kotlin.jvm.internal.f0.p(context, "context");
            kotlin.jvm.internal.f0.p(intent, "intent");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            String stringExtra = intent.getStringExtra("android.bluetooth.device.extra.NAME");
            short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) -100);
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -1780914469) {
                    if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                        Iterator it2 = AbstractBluetoothController.this.f16223m.iterator();
                        while (it2.hasNext()) {
                            ((e0) it2.next()).s2();
                        }
                        return;
                    }
                    return;
                }
                if (iHashCode != 6759640) {
                    if (iHashCode == 1167529923 && action.equals("android.bluetooth.device.action.FOUND") && bluetoothDevice != null) {
                        AbstractBluetoothController.this.f0(kotlin.collections.s.k(new BleDevice(bluetoothDevice, stringExtra, shortExtra, null, System.currentTimeMillis())));
                        return;
                    }
                    return;
                }
                if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                    Iterator it3 = AbstractBluetoothController.this.f16223m.iterator();
                    while (it3.hasNext()) {
                        ((e0) it3.next()).t0();
                    }
                }
            }
        }
    }

    public static final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@yt.k Context context, @yt.k Intent intent) {
            kotlin.jvm.internal.f0.p(context, "context");
            kotlin.jvm.internal.f0.p(intent, "intent");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null || !AbstractBluetoothController.this.Z(bluetoothDevice) || !u.a.a(AbstractBluetoothController.this.J(), bluetoothDevice.getName(), 0, 2, null) || (AbstractBluetoothController.this.M() != null && !androidx.core.util.j.a(bluetoothDevice, AbstractBluetoothController.this.M()))) {
                l9.a.e("skip other device[" + (bluetoothDevice != null ? bluetoothDevice.getName() : null) + "]");
                return;
            }
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -301431627) {
                    if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                        AbstractBluetoothController.this.v0(bluetoothDevice);
                        l9.a.e("[Broadcast] Action received: device:" + bluetoothDevice.getName() + " android.bluetooth.device.action.ACL_CONNECTED connectionStateCallback.size:" + AbstractBluetoothController.this.f16225o.size());
                        AbstractBluetoothController.this.d0(bluetoothDevice);
                        return;
                    }
                    return;
                }
                if (iHashCode != 1123270207) {
                    if (iHashCode == 1821585647 && action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                        l9.a.e("[Broadcast] Action received: device:" + bluetoothDevice.getName() + " android.bluetooth.device.action.ACL_DISCONNECTED ");
                        AbstractBluetoothController.this.e0(bluetoothDevice);
                        AbstractBluetoothController.this.s0();
                        return;
                    }
                    return;
                }
                if (action.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED")) {
                    l9.a.e("[Broadcast] Action received: device:" + bluetoothDevice.getName() + " android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED ");
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    if (intExtra == 0) {
                        AbstractBluetoothController.this.e0(bluetoothDevice);
                        AbstractBluetoothController.this.s0();
                    } else {
                        if (intExtra != 2) {
                            return;
                        }
                        AbstractBluetoothController.this.d0(bluetoothDevice);
                    }
                }
            }
        }
    }

    @t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1127:1\n1855#2,2:1128\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$openProfile$2\n*L\n404#1:1128,2\n*E\n"})
    public static final class f implements BluetoothProfile.ServiceListener {
        public f() {
        }

        public static final void b(AbstractBluetoothController this$0) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this$0.m0();
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i10, @yt.l BluetoothProfile bluetoothProfile) {
            if (bluetoothProfile == null) {
                Handler handlerO = AbstractBluetoothController.this.O();
                final AbstractBluetoothController abstractBluetoothController = AbstractBluetoothController.this;
                handlerO.postDelayed(new Runnable() { // from class: com.flydigi.sdk.bluetooth.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        AbstractBluetoothController.f.b(abstractBluetoothController);
                    }
                }, 2000L);
            } else {
                AbstractBluetoothController.this.f16221k = bluetoothProfile;
                Iterator it2 = AbstractBluetoothController.this.f16222l.iterator();
                while (it2.hasNext()) {
                    ((m) it2.next()).q(i10);
                }
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i10) {
        }
    }

    @t0({"SMAP\nAbstractBluetoothController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1127:1\n1054#2:1128\n766#2:1129\n857#2,2:1130\n1549#2:1132\n1620#2,3:1133\n1855#2,2:1136\n*S KotlinDebug\n*F\n+ 1 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1\n*L\n308#1:1128\n308#1:1129\n308#1:1130,2\n309#1:1132\n309#1:1133,3\n325#1:1136,2\n*E\n"})
    public static final class g extends ScanCallback {

        @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n+ 2 AbstractBluetoothController.kt\ncom/flydigi/sdk/bluetooth/AbstractBluetoothController$scanCallback$1\n*L\n1#1,328:1\n308#2:329\n*E\n"})
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return uj.g.l(Integer.valueOf(((ScanResult) t11).getRssi()), Integer.valueOf(((ScanResult) t10).getRssi()));
            }
        }

        public g() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(@yt.k List<ScanResult> results) {
            kotlin.jvm.internal.f0.p(results, "results");
            super.onBatchScanResults(results);
            AbstractBluetoothController.this.P().removeCallbacks(AbstractBluetoothController.this.D());
            List listP5 = CollectionsKt___CollectionsKt.p5(results, new a());
            AbstractBluetoothController abstractBluetoothController = AbstractBluetoothController.this;
            ArrayList<ScanResult> arrayList = new ArrayList();
            for (Object obj : listP5) {
                BluetoothDevice device = ((ScanResult) obj).getDevice();
                kotlin.jvm.internal.f0.o(device, "it.device");
                if (abstractBluetoothController.Z(device)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
            for (ScanResult scanResult : arrayList) {
                BluetoothDevice device2 = scanResult.getDevice();
                kotlin.jvm.internal.f0.o(device2, "result.device");
                String name = scanResult.getDevice().getName();
                int rssi = scanResult.getRssi();
                ScanRecord scanRecord = scanResult.getScanRecord();
                arrayList2.add(new BleDevice(device2, name, rssi, scanRecord != null ? scanRecord.getBytes() : null, System.nanoTime()));
            }
            AbstractBluetoothController.this.f0(arrayList2);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i10) {
            super.onScanFailed(i10);
            Iterator it2 = AbstractBluetoothController.this.f16223m.iterator();
            while (it2.hasNext()) {
                ((e0) it2.next()).x0(i10);
            }
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i10, @yt.k ScanResult result) {
            kotlin.jvm.internal.f0.p(result, "result");
            super.onScanResult(i10, result);
            AbstractBluetoothController.this.P().removeCallbacks(AbstractBluetoothController.this.D());
            AbstractBluetoothController abstractBluetoothController = AbstractBluetoothController.this;
            BluetoothDevice device = result.getDevice();
            kotlin.jvm.internal.f0.o(device, "result.device");
            String name = result.getDevice().getName();
            int rssi = result.getRssi();
            ScanRecord scanRecord = result.getScanRecord();
            abstractBluetoothController.f0(kotlin.collections.s.k(new BleDevice(device, name, rssi, scanRecord != null ? scanRecord.getBytes() : null, System.nanoTime())));
        }
    }

    public static final class h implements m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.fragment.app.g f16244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f16245c;

        public h(androidx.fragment.app.g gVar, int i10) {
            this.f16244b = gVar;
            this.f16245c = i10;
        }

        @Override // com.flydigi.sdk.bluetooth.m
        public void P(boolean z10) {
            if (z10) {
                AbstractBluetoothController.this.E0(this.f16244b, this.f16245c);
            }
        }

        @Override // com.flydigi.sdk.bluetooth.m
        public void R0() {
            m.a.a(this);
        }

        @Override // com.flydigi.sdk.bluetooth.m
        public void b0() {
            m.a.b(this);
        }

        @Override // com.flydigi.sdk.bluetooth.m
        public void l() {
            m.a.c(this);
        }

        @Override // com.flydigi.sdk.bluetooth.m
        public void q(int i10) {
            m.a.d(this, i10);
        }
    }

    public AbstractBluetoothController(@yt.k Context mContext, @yt.k u deviceFilter, int i10) {
        kotlin.jvm.internal.f0.p(mContext, "mContext");
        kotlin.jvm.internal.f0.p(deviceFilter, "deviceFilter");
        this.f16211a = mContext;
        this.f16212b = deviceFilter;
        this.f16213c = i10;
        this.f16217g = -1;
        this.f16222l = new ArrayList<>();
        this.f16223m = new ArrayList<>();
        this.f16224n = new ArrayList<>();
        this.f16225o = new ArrayList<>();
        this.f16226p = 2;
        this.f16227q = true;
        d dVar = new d();
        this.f16230t = dVar;
        b bVar = new b();
        this.f16231u = bVar;
        c cVar = new c();
        this.f16232v = cVar;
        e eVar = new e();
        this.f16233w = eVar;
        this.f16234x = kotlin.b0.a(new AbstractBluetoothController$leScanCallback$2(this));
        this.f16235y = new g();
        this.f16236z = kotlin.b0.a(new AbstractBluetoothController$checkLocationServiceEnabledRunnable$2(this));
        this.A = kotlin.b0.a(new AbstractBluetoothController$createBondTimeoutRunnable$2(this));
        this.B = kotlin.b0.a(new AbstractBluetoothController$removeBondTimeoutRunnable$2(this));
        Object systemService = mContext.getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
        kotlin.jvm.internal.f0.n(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        this.f16219i = bluetoothManager;
        BluetoothAdapter defaultAdapter = (bluetoothManager == null || (defaultAdapter = bluetoothManager.getAdapter()) == null) ? BluetoothAdapter.getDefaultAdapter() : defaultAdapter;
        this.f16220j = defaultAdapter;
        this.f16227q = defaultAdapter != null;
        HandlerThread handlerThread = new HandlerThread("flyBleThread");
        handlerThread.start();
        x0(new Handler(handlerThread.getLooper()));
        w0(new Handler(Looper.getMainLooper()));
        if (this.f16227q) {
            m0();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            intentFilter.addAction("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            mContext.registerReceiver(dVar, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            mContext.registerReceiver(bVar, intentFilter2);
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter3.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter3.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            mContext.registerReceiver(eVar, intentFilter3);
            mContext.registerReceiver(cVar, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        }
    }

    public static final void C0(AbstractBluetoothController this$0, boolean z10, List list, List list2) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(list, "<anonymous parameter 1>");
        kotlin.jvm.internal.f0.p(list2, "<anonymous parameter 2>");
        if (z10) {
            this$0.A0();
            return;
        }
        Iterator<T> it2 = this$0.f16223m.iterator();
        while (it2.hasNext()) {
            ((e0) it2.next()).x0(9);
        }
    }

    public static /* synthetic */ List G(AbstractBluetoothController abstractBluetoothController, Boolean bool, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConnectedDevices");
        }
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        return abstractBluetoothController.F(bool);
    }

    public static /* synthetic */ void i0(AbstractBluetoothController abstractBluetoothController, Fragment fragment, m mVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openBluetooth");
        }
        if ((i10 & 2) != 0) {
            mVar = null;
        }
        abstractBluetoothController.g0(fragment, mVar);
    }

    public static /* synthetic */ void j0(AbstractBluetoothController abstractBluetoothController, androidx.fragment.app.g gVar, m mVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openBluetooth");
        }
        if ((i10 & 2) != 0) {
            mVar = null;
        }
        abstractBluetoothController.h0(gVar, mVar);
    }

    public static final void k0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void l0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void r0(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static /* synthetic */ void x(AbstractBluetoothController abstractBluetoothController, Boolean bool, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkLocationServiceEnabled");
        }
        if ((i10 & 1) != 0) {
            bool = Boolean.FALSE;
        }
        abstractBluetoothController.w(bool);
    }

    public static final void z0(AbstractBluetoothController this$0, boolean z10, List list, List list2) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(list, "<anonymous parameter 1>");
        kotlin.jvm.internal.f0.p(list2, "<anonymous parameter 2>");
        if (!z10) {
            Iterator<T> it2 = this$0.f16223m.iterator();
            while (it2.hasNext()) {
                ((e0) it2.next()).x0(9);
            }
            return;
        }
        BluetoothAdapter bluetoothAdapter = this$0.f16220j;
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isDiscovering()) {
                l9.a.c("取消之前的扫描");
                bluetoothAdapter.cancelDiscovery();
            }
            bluetoothAdapter.startDiscovery();
        }
    }

    public final void A(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return;
        }
        F0();
        BluetoothDevice bluetoothDeviceQ = Q(device.getAddress());
        this.f16214d = bluetoothDeviceQ;
        if (bluetoothDeviceQ == null) {
            Iterator<T> it3 = this.f16224n.iterator();
            while (it3.hasNext()) {
                ((n) it3.next()).p2(device, false);
            }
            return;
        }
        String address = bluetoothDeviceQ.getAddress();
        kotlin.jvm.internal.f0.o(address, "it.address");
        if (!W(address)) {
            if (!bluetoothDeviceQ.createBond()) {
                Iterator<T> it4 = this.f16224n.iterator();
                while (it4.hasNext()) {
                    ((n) it4.next()).p2(bluetoothDeviceQ, false);
                }
                return;
            } else {
                Iterator<T> it5 = this.f16224n.iterator();
                while (it5.hasNext()) {
                    ((n) it5.next()).R1(bluetoothDeviceQ);
                }
                O().postDelayed(I(), 15000L);
                return;
            }
        }
        this.f16229s = true;
        l9.a.e("已有" + bluetoothDeviceQ.getName() + ee.a.f26978c + bluetoothDeviceQ.getAddress() + ")的配对信息，需要先取消配对");
        String address2 = bluetoothDeviceQ.getAddress();
        kotlin.jvm.internal.f0.o(address2, "it.address");
        p0(address2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0() {
        /*
            r9 = this;
            boolean r0 = r9.f16227q
            if (r0 != 0) goto L1b
            java.util.ArrayList<com.flydigi.sdk.bluetooth.m> r0 = r9.f16222l
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L1a
            java.lang.Object r1 = r0.next()
            com.flydigi.sdk.bluetooth.m r1 = (com.flydigi.sdk.bluetooth.m) r1
            r1.R0()
            goto La
        L1a:
            return
        L1b:
            boolean r0 = r9.f16228r
            if (r0 == 0) goto L25
            java.lang.String r0 = "已经在扫描中了"
            l9.a.f(r0)
            return
        L25:
            r0 = 1
            r9.f16228r = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            int r2 = r9.f16226p
            r3 = 500(0x1f4, double:2.47E-321)
            r5 = 2
            if (r2 != r5) goto L3d
            android.bluetooth.BluetoothAdapter r0 = r9.f16220j
            if (r0 == 0) goto L83
            android.bluetooth.BluetoothAdapter$LeScanCallback r1 = r9.L()
            r0.startLeScan(r1)
            goto L83
        L3d:
            android.bluetooth.le.ScanSettings$Builder r2 = new android.bluetooth.le.ScanSettings$Builder
            r2.<init>()
            int r6 = r9.f16226p
            r7 = 3
            r8 = 0
            if (r6 == r7) goto L52
            r1 = 4
            if (r6 == r1) goto L50
            r1 = 5
            if (r6 == r1) goto L57
            r0 = 2
            goto L57
        L50:
            r0 = 0
            goto L57
        L52:
            r0 = 23
            if (r1 < r0) goto L50
            r0 = -1
        L57:
            r2.setScanMode(r0)
            int r0 = r9.f16226p
            if (r0 != r5) goto L64
            r0 = 0
            r2.setReportDelay(r0)
            goto L6c
        L64:
            r0 = 5000(0x1388, double:2.4703E-320)
            r3 = 1000(0x3e8, double:4.94E-321)
            r2.setReportDelay(r3)
            r3 = r0
        L6c:
            android.bluetooth.BluetoothAdapter r0 = r9.f16220j
            if (r0 == 0) goto L83
            android.bluetooth.le.BluetoothLeScanner r0 = r0.getBluetoothLeScanner()
            if (r0 == 0) goto L83
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.E()
            android.bluetooth.le.ScanSettings r2 = r2.build()
            com.flydigi.sdk.bluetooth.AbstractBluetoothController$g r5 = r9.f16235y
            r0.startScan(r1, r2, r5)
        L83:
            java.util.ArrayList<com.flydigi.sdk.bluetooth.e0> r0 = r9.f16223m
            java.util.Iterator r0 = r0.iterator()
        L89:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L99
            java.lang.Object r1 = r0.next()
            com.flydigi.sdk.bluetooth.e0 r1 = (com.flydigi.sdk.bluetooth.e0) r1
            r1.t0()
            goto L89
        L99:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 >= r1) goto Laa
            android.os.Handler r0 = r9.P()
            java.lang.Runnable r1 = r9.D()
            r0.postDelayed(r1, r3)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.sdk.bluetooth.AbstractBluetoothController.A0():void");
    }

    public final boolean B(BluetoothDevice bluetoothDevice) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        try {
            BluetoothProfile bluetoothProfile = this.f16221k;
            if (bluetoothProfile == null) {
                return false;
            }
            Method method = bluetoothProfile.getClass().getMethod("disconnect", BluetoothDevice.class);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice);
            kotlin.jvm.internal.f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"CheckResult"})
    public final void B0(androidx.fragment.app.g gVar) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
        } else {
            bg.b bVarC = bg.c.c(gVar);
            String[] strArr = new String[1];
            strArr[0] = Build.VERSION.SDK_INT >= 31 ? "android.permission.BLUETOOTH_SCAN" : "android.permission.ACCESS_FINE_LOCATION";
            bVarC.b(strArr).r(new cg.d() { // from class: com.flydigi.sdk.bluetooth.a
                @Override // cg.d
                public final void a(boolean z10, List list, List list2) {
                    AbstractBluetoothController.C0(this.f16250a, z10, list, list2);
                }
            });
        }
    }

    @yt.k
    public final List<BluetoothDevice> C() {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return CollectionsKt__CollectionsKt.E();
        }
        List<BluetoothDevice> listE = CollectionsKt__CollectionsKt.E();
        BluetoothAdapter bluetoothAdapter = this.f16220j;
        if (bluetoothAdapter != null) {
            for (BluetoothDevice device : bluetoothAdapter.getBondedDevices()) {
                if (u.a.a(this.f16212b, device.getName(), 0, 2, null)) {
                    kotlin.jvm.internal.f0.o(device, "device");
                    listE = CollectionsKt___CollectionsKt.z4(listE, device);
                }
            }
        }
        return listE;
    }

    public final Runnable D() {
        return (Runnable) this.f16236z.getValue();
    }

    public final void D0(@yt.k Fragment fragment, int i10) {
        kotlin.jvm.internal.f0.p(fragment, "fragment");
        androidx.fragment.app.g gVarP4 = fragment.P4();
        kotlin.jvm.internal.f0.o(gVarP4, "fragment.requireActivity()");
        E0(gVarP4, i10);
    }

    public final int E() {
        return this.f16217g;
    }

    public final void E0(@yt.k androidx.fragment.app.g activity, int i10) {
        kotlin.jvm.internal.f0.p(activity, "activity");
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            if (it2.hasNext()) {
                ((m) it2.next()).R0();
                return;
            }
        }
        this.f16226p = i10;
        if (!T()) {
            h0(activity, new h(activity, i10));
        } else if (i10 == 1) {
            y0(activity);
        } else {
            B0(activity);
        }
    }

    @yt.k
    public final List<BluetoothDevice> F(@yt.l Boolean bool) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return CollectionsKt__CollectionsKt.E();
        }
        List<BluetoothDevice> listE = CollectionsKt__CollectionsKt.E();
        BluetoothManager bluetoothManager = this.f16219i;
        if (bluetoothManager != null) {
            for (BluetoothDevice device : bluetoothManager.getConnectedDevices(7)) {
                if (u.a.a(this.f16212b, device.getName(), 0, 2, null)) {
                    l9.a.c("find bluetooth " + device.getName());
                    if (!kotlin.jvm.internal.f0.g(bool, Boolean.TRUE)) {
                        kotlin.jvm.internal.f0.o(device, "device");
                        listE = CollectionsKt___CollectionsKt.z4(listE, device);
                    } else if (device.getBondState() == 12) {
                        kotlin.jvm.internal.f0.o(device, "device");
                        listE = CollectionsKt___CollectionsKt.z4(listE, device);
                    }
                }
            }
        }
        if (listE.isEmpty()) {
            try {
                BluetoothProfile bluetoothProfile = this.f16221k;
                if (bluetoothProfile != null) {
                    for (BluetoothDevice device2 : bluetoothProfile.getConnectedDevices()) {
                        if (u.a.a(this.f16212b, device2.getName(), 0, 2, null)) {
                            kotlin.jvm.internal.f0.o(device2, "device");
                            listE = CollectionsKt___CollectionsKt.z4(listE, device2);
                        }
                    }
                }
            } catch (Exception unused) {
                for (BluetoothDevice bluetoothDevice : C()) {
                    if (u.a.a(this.f16212b, bluetoothDevice.getName(), 0, 2, null) && V(bluetoothDevice)) {
                        listE = CollectionsKt___CollectionsKt.z4(listE, bluetoothDevice);
                    }
                }
            }
        }
        return listE;
    }

    public final void F0() {
        BluetoothLeScanner bluetoothLeScanner;
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return;
        }
        this.f16228r = false;
        l9.a.c("停止扫描");
        BluetoothAdapter bluetoothAdapter = this.f16220j;
        if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        if (this.f16226p == 2) {
            BluetoothAdapter bluetoothAdapter2 = this.f16220j;
            if (bluetoothAdapter2 != null) {
                bluetoothAdapter2.stopLeScan(L());
                return;
            }
            return;
        }
        BluetoothAdapter bluetoothAdapter3 = this.f16220j;
        if (bluetoothAdapter3 == null || (bluetoothLeScanner = bluetoothAdapter3.getBluetoothLeScanner()) == null) {
            return;
        }
        bluetoothLeScanner.stopScan(this.f16235y);
    }

    @g.i
    public void G0(@yt.k Object obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        if ((obj instanceof m) && this.f16222l.contains(obj)) {
            this.f16222l.remove(obj);
        }
        if ((obj instanceof t) && this.f16225o.contains(obj)) {
            this.f16225o.remove(obj);
        }
        if ((obj instanceof e0) && this.f16223m.contains(obj)) {
            this.f16223m.remove(obj);
        }
        if ((obj instanceof n) && this.f16224n.contains(obj)) {
            this.f16224n.remove(obj);
        }
    }

    public final int H(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return 0;
        }
        BluetoothManager bluetoothManager = this.f16219i;
        if (bluetoothManager != null) {
            return bluetoothManager.getConnectionState(device, 7);
        }
        BluetoothProfile bluetoothProfile = this.f16221k;
        if (bluetoothProfile != null) {
            return bluetoothProfile.getConnectionState(device);
        }
        return 0;
    }

    public final Runnable I() {
        return (Runnable) this.A.getValue();
    }

    @yt.k
    public final u J() {
        return this.f16212b;
    }

    public final boolean K() {
        return this.f16218h;
    }

    public final BluetoothAdapter.LeScanCallback L() {
        return (BluetoothAdapter.LeScanCallback) this.f16234x.getValue();
    }

    @yt.l
    public final BluetoothDevice M() {
        return this.f16214d;
    }

    @yt.k
    public final Context N() {
        return this.f16211a;
    }

    @yt.k
    public final Handler O() {
        Handler handler = this.f16216f;
        if (handler != null) {
            return handler;
        }
        kotlin.jvm.internal.f0.S("mMainHandler");
        return null;
    }

    @yt.k
    public final Handler P() {
        Handler handler = this.f16215e;
        if (handler != null) {
            return handler;
        }
        kotlin.jvm.internal.f0.S("mWorkHandler");
        return null;
    }

    @yt.l
    public final BluetoothDevice Q(@yt.l String str) {
        BluetoothAdapter bluetoothAdapter = this.f16220j;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.getRemoteDevice(str);
        }
        return null;
    }

    public final Runnable R() {
        return (Runnable) this.B.getValue();
    }

    public final boolean S() {
        return h0.d.a(this.f16211a, "android.permission.ACCESS_FINE_LOCATION") == 0 || h0.d.a(this.f16211a, "android.permission.BLUETOOTH_SCAN") == 0;
    }

    public final boolean T() {
        if (this.f16227q) {
            BluetoothAdapter bluetoothAdapter = this.f16220j;
            if (bluetoothAdapter != null) {
                return bluetoothAdapter.isEnabled();
            }
            return false;
        }
        Iterator<T> it2 = this.f16222l.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).R0();
        }
        return false;
    }

    public final boolean U() {
        return this.f16227q;
    }

    public final boolean V(@yt.k BluetoothDevice bluetoothDevice) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        kotlin.jvm.internal.f0.p(bluetoothDevice, "<this>");
        Method method = BluetoothDevice.class.getMethod("isConnected", new Class[0]);
        method.setAccessible(true);
        Object objInvoke = method.invoke(bluetoothDevice, new Object[0]);
        kotlin.jvm.internal.f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objInvoke).booleanValue();
    }

    public final boolean W(String str) {
        if (this.f16227q) {
            BluetoothDevice bluetoothDeviceQ = Q(str);
            return bluetoothDeviceQ != null && bluetoothDeviceQ.getBondState() == 12;
        }
        Iterator<T> it2 = this.f16222l.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).R0();
        }
        return false;
    }

    public final boolean X(@yt.l BluetoothDevice bluetoothDevice) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return false;
        }
        try {
            Iterator it3 = G(this, null, 1, null).iterator();
            while (it3.hasNext()) {
                if (kotlin.jvm.internal.f0.g(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, ((BluetoothDevice) it3.next()).getAddress())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final boolean Y(@yt.l String str) {
        return X(Q(str));
    }

    public final boolean Z(@yt.k BluetoothDevice bluetoothDevice) {
        kotlin.jvm.internal.f0.p(bluetoothDevice, "<this>");
        String name = bluetoothDevice.getName();
        return !(name == null || name.length() == 0);
    }

    public final boolean a0(byte[] bArr) {
        if (bArr != null && bArr.length > 1) {
            try {
                int length = bArr.length - 1;
                for (int i10 = 0; i10 < length; i10++) {
                    if (bArr[i10] == 1) {
                        byte b10 = bArr[i10 + 1];
                        return (b10 & 1) > 0 || (b10 & 2) > 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void b0() {
        Iterator<T> it2 = this.f16222l.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).P(false);
        }
    }

    public final void c0() {
        Iterator<T> it2 = this.f16222l.iterator();
        while (it2.hasNext()) {
            ((m) it2.next()).P(true);
        }
    }

    @g.i
    public void d0(@yt.l BluetoothDevice bluetoothDevice) {
        Iterator<T> it2 = this.f16225o.iterator();
        while (it2.hasNext()) {
            ((t) it2.next()).e0(bluetoothDevice);
        }
    }

    @g.i
    public void e0(@yt.l BluetoothDevice bluetoothDevice) {
        this.f16217g = -1;
        Iterator<T> it2 = this.f16225o.iterator();
        while (it2.hasNext()) {
            ((t) it2.next()).N(bluetoothDevice);
        }
    }

    public final void f0(List<BleDevice> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<BleDevice> it2 = list.iterator();
        while (true) {
            boolean z10 = true;
            if (!it2.hasNext()) {
                break;
            }
            BleDevice next = it2.next();
            String name = Z(next.F()) ? next.F().getName() : l.a(next.C());
            next.V(name);
            String strM = next.M();
            if (strM != null && strM.length() != 0) {
                z10 = false;
            }
            if (!z10 && this.f16212b.a(name, next.S())) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator<T> it3 = this.f16223m.iterator();
            while (it3.hasNext()) {
                ((e0) it3.next()).q1(arrayList);
            }
        }
    }

    public final void g0(@yt.k Fragment fragment, @yt.l m mVar) {
        kotlin.jvm.internal.f0.p(fragment, "fragment");
        androidx.fragment.app.g gVarW1 = fragment.w1();
        if (gVarW1 != null) {
            h0(gVarW1, mVar);
        }
    }

    public final void h0(@yt.k androidx.fragment.app.g activity, @yt.l final m mVar) {
        kotlin.jvm.internal.f0.p(activity, "activity");
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
        } else {
            xi.z zVarE = RxActivityResult.a(activity).e(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
            final ik.l<rx_activity_result2.f<androidx.fragment.app.g>, z1> lVar = new ik.l<rx_activity_result2.f<androidx.fragment.app.g>, z1>() { // from class: com.flydigi.sdk.bluetooth.AbstractBluetoothController$openBluetooth$disposable$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(rx_activity_result2.f<androidx.fragment.app.g> fVar) {
                    if (fVar.c() != -1) {
                        Iterator it3 = this.this$0.f16222l.iterator();
                        while (it3.hasNext()) {
                            ((m) it3.next()).b0();
                        }
                    } else {
                        this.this$0.c0();
                        m mVar2 = mVar;
                        if (mVar2 != null) {
                            mVar2.P(true);
                        }
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<androidx.fragment.app.g> fVar) {
                    b(fVar);
                    return z1.f38230a;
                }
            };
            dj.g gVar = new dj.g() { // from class: com.flydigi.sdk.bluetooth.d
                @Override // dj.g
                public final void accept(Object obj) {
                    AbstractBluetoothController.k0(lVar, obj);
                }
            };
            final ik.l<Throwable, z1> lVar2 = new ik.l<Throwable, z1>() { // from class: com.flydigi.sdk.bluetooth.AbstractBluetoothController$openBluetooth$disposable$2
                {
                    super(1);
                }

                public final void b(Throwable th2) {
                    Iterator it3 = this.this$0.f16222l.iterator();
                    while (it3.hasNext()) {
                        ((m) it3.next()).l();
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                    b(th2);
                    return z1.f38230a;
                }
            };
            zVarE.F5(gVar, new dj.g() { // from class: com.flydigi.sdk.bluetooth.c
                @Override // dj.g
                public final void accept(Object obj) {
                    AbstractBluetoothController.l0(lVar2, obj);
                }
            });
        }
    }

    public final void m0() {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
        } else {
            BluetoothAdapter bluetoothAdapter = this.f16220j;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.getProfileProxy(this.f16211a, new f(), this.f16213c);
            }
        }
    }

    @g.i
    public void n0(@yt.k Object obj) {
        kotlin.jvm.internal.f0.p(obj, "obj");
        if ((obj instanceof m) && !this.f16222l.contains(obj)) {
            this.f16222l.add(obj);
        }
        if ((obj instanceof t) && !this.f16225o.contains(obj)) {
            this.f16225o.add(obj);
        }
        if ((obj instanceof e0) && !this.f16223m.contains(obj)) {
            this.f16223m.add(obj);
        }
        if (!(obj instanceof n) || this.f16224n.contains(obj)) {
            return;
        }
        this.f16224n.add(obj);
    }

    public final void o0(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return;
        }
        if (device.getBondState() != 12) {
            Iterator<T> it3 = this.f16224n.iterator();
            while (it3.hasNext()) {
                ((n) it3.next()).G0(device, false);
            }
            return;
        }
        Iterator<T> it4 = this.f16224n.iterator();
        while (it4.hasNext()) {
            ((n) it4.next()).V1(device);
        }
        if (X(device) ? B(device) : true) {
            try {
                Method method = BluetoothDevice.class.getMethod("removeBond", new Class[0]);
                method.setAccessible(true);
                Object objInvoke = method.invoke(device, new Object[0]);
                kotlin.jvm.internal.f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
                if (((Boolean) objInvoke).booleanValue()) {
                    O().postDelayed(R(), 15000L);
                    return;
                }
                Iterator<T> it5 = this.f16224n.iterator();
                while (it5.hasNext()) {
                    ((n) it5.next()).G0(device, false);
                }
            } catch (Exception unused) {
                Iterator<T> it6 = this.f16224n.iterator();
                while (it6.hasNext()) {
                    ((n) it6.next()).G0(device, false);
                }
            }
        }
    }

    public final void p0(@yt.k String deviceMac) {
        kotlin.jvm.internal.f0.p(deviceMac, "deviceMac");
        BluetoothDevice bluetoothDeviceQ = Q(deviceMac);
        if (bluetoothDeviceQ != null) {
            o0(bluetoothDeviceQ);
        }
    }

    @yt.k
    public final io.reactivex.disposables.b q0(@yt.k Activity activity) {
        kotlin.jvm.internal.f0.p(activity, "activity");
        xi.z zVarE = RxActivityResult.a(activity).e(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        final ik.l<rx_activity_result2.f<Activity>, z1> lVar = new ik.l<rx_activity_result2.f<Activity>, z1>() { // from class: com.flydigi.sdk.bluetooth.AbstractBluetoothController$requestEnableLocationService$1
            {
                super(1);
            }

            public final void b(rx_activity_result2.f<Activity> fVar) {
                this.this$0.w(Boolean.TRUE);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(rx_activity_result2.f<Activity> fVar) {
                b(fVar);
                return z1.f38230a;
            }
        };
        io.reactivex.disposables.b bVarE5 = zVarE.E5(new dj.g() { // from class: com.flydigi.sdk.bluetooth.e
            @Override // dj.g
            public final void accept(Object obj) {
                AbstractBluetoothController.r0(lVar, obj);
            }
        });
        kotlin.jvm.internal.f0.o(bVarE5, "fun requestEnableLocatio…true)\n            }\n    }");
        return bVarE5;
    }

    @g.i
    public void s0() {
        O().removeCallbacksAndMessages(null);
        P().removeCallbacksAndMessages(null);
        this.f16214d = null;
    }

    public final void t0(int i10) {
        this.f16217g = i10;
    }

    public final void u0(boolean z10) {
        this.f16218h = z10;
    }

    public final boolean v(BluetoothDevice bluetoothDevice) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return false;
        }
        if (!T()) {
            return false;
        }
        try {
            Method method = BluetoothDevice.class.getMethod("cancelBondProcess", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothDevice, null);
            kotlin.jvm.internal.f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void v0(@yt.l BluetoothDevice bluetoothDevice) {
        this.f16214d = bluetoothDevice;
    }

    public final void w(Boolean bool) {
        Object systemService = this.f16211a.getSystemService(SocializeConstants.KEY_LOCATION);
        kotlin.jvm.internal.f0.n(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        if (Build.VERSION.SDK_INT >= 28 ? locationManager.isLocationEnabled() : locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("passive")) {
            if (kotlin.jvm.internal.f0.g(bool, Boolean.TRUE)) {
                A0();
            }
        } else {
            F0();
            Iterator<T> it2 = this.f16223m.iterator();
            while (it2.hasNext()) {
                ((e0) it2.next()).x0(8);
            }
        }
    }

    public final void w0(@yt.k Handler handler) {
        kotlin.jvm.internal.f0.p(handler, "<set-?>");
        this.f16216f = handler;
    }

    public final void x0(@yt.k Handler handler) {
        kotlin.jvm.internal.f0.p(handler, "<set-?>");
        this.f16215e = handler;
    }

    public final boolean y() {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return true;
        }
        if (!T()) {
            l9.a.f("系统蓝牙未开启，无需关闭");
            return true;
        }
        BluetoothAdapter bluetoothAdapter = this.f16220j;
        if (bluetoothAdapter != null) {
            return bluetoothAdapter.disable();
        }
        return false;
    }

    public final void y0(androidx.fragment.app.g gVar) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
        } else {
            bg.b bVarC = bg.c.c(gVar);
            String[] strArr = new String[1];
            strArr[0] = Build.VERSION.SDK_INT >= 31 ? "android.permission.BLUETOOTH_SCAN" : "android.permission.ACCESS_FINE_LOCATION";
            bVarC.b(strArr).r(new cg.d() { // from class: com.flydigi.sdk.bluetooth.b
                @Override // cg.d
                public final void a(boolean z10, List list, List list2) {
                    AbstractBluetoothController.z0(this.f16254a, z10, list, list2);
                }
            });
        }
    }

    public final boolean z(BluetoothDevice bluetoothDevice) {
        if (!this.f16227q) {
            Iterator<T> it2 = this.f16222l.iterator();
            while (it2.hasNext()) {
                ((m) it2.next()).R0();
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        try {
            BluetoothProfile bluetoothProfile = this.f16221k;
            if (bluetoothProfile == null) {
                return false;
            }
            Method method = bluetoothProfile.getClass().getMethod("connect", BluetoothDevice.class);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice);
            kotlin.jvm.internal.f0.n(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
