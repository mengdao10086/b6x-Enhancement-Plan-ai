package uf;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.flydigi.cyberfox.R;
import com.iir_eq.ui.fragment.OtaConfigFragment;
import com.iir_eq.ui.fragment.OtaDaulPickFileFragment;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import za.h1;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends uf.a implements rf.a, View.OnClickListener, OtaConfigFragment.h {
    public static final int Aa = 18;
    public static final int Ab = 5;
    public static final int Ba = 19;
    public static final int Bb = 1;
    public static final int Ca = 20;
    public static final int Cb = 2;
    public static final int Da = 21;
    public static final int Db = 0;
    public static final int Ea = 23;
    public static final int Eb = 1;
    public static final int Fa = 128;
    public static final int Fb = 0;
    public static final int Ga = 129;
    public static final int Gb = 2;
    public static final int Ha = 130;
    public static final int Hb = 0;
    public static final int Ia = 131;
    public static final int Ib = 3;
    public static final int Ja = 132;
    public static final int Jb = 2;
    public static final int Ka = 133;
    public static final int Kb = 1;
    public static final int La = 134;
    public static final int Lb = 128;
    public static final int Ma = 136;
    public static final int Mb = 0;
    public static final int Na = 137;
    public static final int Nb = 1;
    public static final int Oa = 140;
    public static final int Ob = 2;
    public static final int Pa = 141;
    public static final String Pb = "0400";
    public static final int Qa = 142;
    public static final String Qb = "02000C";
    public static final int Ra = 143;
    public static final int Rb = 10;
    public static final int Sa = 153;
    public static final int Sb = 22;
    public static final int Ta = 154;
    public static final int Ua = 155;
    public static final int Va = 144;
    public static final int Wa = 145;
    public static final int Xa = 146;
    public static final int Ya = 147;
    public static final int Za = 156;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    public static final int f51995ab = 157;

    /* JADX INFO: renamed from: bb, reason: collision with root package name */
    public static final int f51996bb = 158;

    /* JADX INFO: renamed from: cb, reason: collision with root package name */
    public static final int f51997cb = 159;

    /* JADX INFO: renamed from: db, reason: collision with root package name */
    public static final int f51998db = 160;

    /* JADX INFO: renamed from: eb, reason: collision with root package name */
    public static final int f51999eb = 161;

    /* JADX INFO: renamed from: fa, reason: collision with root package name */
    public static final String f52000fa = "ota_file";

    /* JADX INFO: renamed from: fb, reason: collision with root package name */
    public static final int f52001fb = 162;

    /* JADX INFO: renamed from: gb, reason: collision with root package name */
    public static final int f52003gb = 163;

    /* JADX INFO: renamed from: hb, reason: collision with root package name */
    public static final int f52005hb = 0;

    /* JADX INFO: renamed from: ib, reason: collision with root package name */
    public static final int f52007ib = 1;

    /* JADX INFO: renamed from: ja, reason: collision with root package name */
    public static final int f52008ja = 512;

    /* JADX INFO: renamed from: jb, reason: collision with root package name */
    public static final int f52009jb = 2;

    /* JADX INFO: renamed from: ka, reason: collision with root package name */
    public static final int f52010ka = 661;

    /* JADX INFO: renamed from: kb, reason: collision with root package name */
    public static final int f52011kb = 3;

    /* JADX INFO: renamed from: la, reason: collision with root package name */
    public static final int f52012la = 0;

    /* JADX INFO: renamed from: lb, reason: collision with root package name */
    public static final int f52013lb = 4;

    /* JADX INFO: renamed from: ma, reason: collision with root package name */
    public static final int f52014ma = 1;

    /* JADX INFO: renamed from: mb, reason: collision with root package name */
    public static final int f52015mb = 5;

    /* JADX INFO: renamed from: na, reason: collision with root package name */
    public static final int f52016na = 2;

    /* JADX INFO: renamed from: nb, reason: collision with root package name */
    public static final int f52017nb = 6;

    /* JADX INFO: renamed from: oa, reason: collision with root package name */
    public static final int f52018oa = 0;

    /* JADX INFO: renamed from: ob, reason: collision with root package name */
    public static final int f52019ob = 7;

    /* JADX INFO: renamed from: pa, reason: collision with root package name */
    public static final int f52020pa = 1;

    /* JADX INFO: renamed from: pb, reason: collision with root package name */
    public static final int f52021pb = 15;

    /* JADX INFO: renamed from: qa, reason: collision with root package name */
    public static final int f52022qa = 2;

    /* JADX INFO: renamed from: qb, reason: collision with root package name */
    public static final byte f52023qb = 0;

    /* JADX INFO: renamed from: ra, reason: collision with root package name */
    public static final int f52024ra = 3;

    /* JADX INFO: renamed from: rb, reason: collision with root package name */
    public static final byte f52025rb = 1;

    /* JADX INFO: renamed from: sa, reason: collision with root package name */
    public static final int f52026sa = 4;

    /* JADX INFO: renamed from: sb, reason: collision with root package name */
    public static final byte f52027sb = 16;

    /* JADX INFO: renamed from: ta, reason: collision with root package name */
    public static final int f52028ta = 5;

    /* JADX INFO: renamed from: tb, reason: collision with root package name */
    public static final byte f52029tb = 17;

    /* JADX INFO: renamed from: ua, reason: collision with root package name */
    public static final int f52030ua = 6;

    /* JADX INFO: renamed from: ub, reason: collision with root package name */
    public static final int f52031ub = -1;

    /* JADX INFO: renamed from: va, reason: collision with root package name */
    public static final int f52032va = 7;

    /* JADX INFO: renamed from: vb, reason: collision with root package name */
    public static final int f52033vb = 0;

    /* JADX INFO: renamed from: wa, reason: collision with root package name */
    public static final int f52034wa = 8;

    /* JADX INFO: renamed from: wb, reason: collision with root package name */
    public static final int f52035wb = 1;

    /* JADX INFO: renamed from: xa, reason: collision with root package name */
    public static final int f52036xa = 9;

    /* JADX INFO: renamed from: xb, reason: collision with root package name */
    public static final int f52037xb = 2;

    /* JADX INFO: renamed from: ya, reason: collision with root package name */
    public static final int f52038ya = 16;

    /* JADX INFO: renamed from: yb, reason: collision with root package name */
    public static final int f52039yb = 3;

    /* JADX INFO: renamed from: za, reason: collision with root package name */
    public static final int f52040za = 17;

    /* JADX INFO: renamed from: zb, reason: collision with root package name */
    public static final int f52041zb = 4;
    public TextView A8;
    public Switch B8;
    public TextView B9;
    public TextView C8;
    public Button C9;
    public Button D8;
    public RadioGroup E7;
    public Button E8;
    public RadioButton F7;
    public Button F8;
    public RadioButton G7;
    public boolean H7;
    public byte[] I9;
    public TextView J8;
    public byte[] J9;
    public Button K8;
    public boolean N9;
    public BluetoothDevice O7;
    public HandlerThread Q7;
    public p R7;
    public byte[] S7;
    public byte[] T7;
    public byte[][][] U7;
    public TextView W8;
    public BluetoothLeScanner W9;
    public String X8;
    public byte[][] Y7;
    public Button Y8;
    public Timer Y9;
    public TextView Z8;
    public TimerTask Z9;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public int f52048c8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public OtaConfigFragment f52057f8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public OtaDaulPickFileFragment f52061h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public long f52063i8;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public byte[] f52064i9;

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public byte[] f52066j9;

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public Button f52070l9;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public Button f52074n9;

    /* JADX INFO: renamed from: q9, reason: collision with root package name */
    public TextView f52080q9;

    /* JADX INFO: renamed from: r9, reason: collision with root package name */
    public TextView f52082r9;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public TextView f52087u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public TextView f52089v8;

    /* JADX INFO: renamed from: v9, reason: collision with root package name */
    public TextView f52090v9;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public TextView f52091w8;

    /* JADX INFO: renamed from: w9, reason: collision with root package name */
    public TextView f52092w9;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public TextView f52093x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public TextView f52095y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public ProgressBar f52097z8;

    /* JADX INFO: renamed from: ga, reason: collision with root package name */
    public static final byte[] f52002ga = {17, 34};

    /* JADX INFO: renamed from: ha, reason: collision with root package name */
    public static final byte[] f52004ha = {51, 68};

    /* JADX INFO: renamed from: ia, reason: collision with root package name */
    public static final byte[] f52006ia = {-117, 1};
    public volatile int I7 = 0;
    public boolean J7 = false;
    public String K7 = null;
    public int L7 = -1;
    public int M7 = 5;
    public volatile int N7 = 0;
    public boolean P7 = false;
    public int V7 = 0;
    public int W7 = 0;
    public boolean X7 = false;
    public int Z7 = 0;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public int f52042a8 = 0;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public Object f52045b8 = new Object();

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public volatile boolean f52051d8 = true;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public final String f52054e8 = "ota_config";

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public final String f52059g8 = "ota_daul_pick_file";

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public long f52065j8 = 0;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public long f52067k8 = 0;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public final int f52069l8 = 3;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public final int f52071m8 = 3000;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public int f52073n8 = 0;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public int f52075o8 = 0;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public int f52077p8 = 0;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public int f52079q8 = 0;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public int f52081r8 = 0;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public boolean f52083s8 = false;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public int f52085t8 = 0;
    public int G8 = 5;
    public int H8 = 100;
    public byte I8 = 0;
    public int L8 = -1;
    public int M8 = 0;
    public int N8 = 0;
    public int O8 = 0;
    public int P8 = 0;
    public final int Q8 = 0;
    public String R8 = "";
    public BluetoothAdapter S8 = null;
    public int T8 = 0;
    public int U8 = 0;
    public int V8 = 0;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public int f52043a9 = 0;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public int f52046b9 = 0;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public int f52049c9 = 0;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public int f52052d9 = 0;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public String f52055e9 = "";

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public boolean f52058f9 = true;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public String f52060g9 = null;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public final String f52062h9 = null;

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public int f52068k9 = 2;

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public int f52072m9 = 0;

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    public final byte[] f52076o9 = new byte[h1.U];

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    public final byte[] f52078p9 = new byte[1024];

    /* JADX INFO: renamed from: s9, reason: collision with root package name */
    public int f52084s9 = -1;

    /* JADX INFO: renamed from: t9, reason: collision with root package name */
    public int f52086t9 = 0;

    /* JADX INFO: renamed from: u9, reason: collision with root package name */
    public int f52088u9 = 0;

    /* JADX INFO: renamed from: x9, reason: collision with root package name */
    public String f52094x9 = "";

    /* JADX INFO: renamed from: y9, reason: collision with root package name */
    public String f52096y9 = "";

    /* JADX INFO: renamed from: z9, reason: collision with root package name */
    public int f52098z9 = 0;
    public boolean A9 = false;
    public final byte[] D9 = new byte[1024];
    public String E9 = "";
    public boolean F9 = true;
    public final String G9 = null;
    public final String H9 = null;
    public int K9 = 0;
    public int L9 = 0;
    public int M9 = 0;
    public String O9 = "";
    public boolean P9 = false;
    public boolean Q9 = false;
    public boolean R9 = false;
    public boolean S9 = false;
    public boolean T9 = true;
    public int U9 = 0;
    public int V9 = 0;
    public final int X9 = 0;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    public int f52044aa = 0;

    /* JADX INFO: renamed from: ba, reason: collision with root package name */
    public int f52047ba = 0;

    /* JADX INFO: renamed from: ca, reason: collision with root package name */
    public final ScanCallback f52050ca = new h();

    /* JADX INFO: renamed from: da, reason: collision with root package name */
    public final Handler f52053da = new l();

    /* JADX INFO: renamed from: ea, reason: collision with root package name */
    public final OtaDaulPickFileFragment.c f52056ea = new C0601c();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(800L);
                if (c.this.N9) {
                    return;
                }
                c.this.q5((byte) -112);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F8.setEnabled(true);
        }
    }

    /* JADX INFO: renamed from: uf.c$c, reason: collision with other inner class name */
    public class C0601c implements OtaDaulPickFileFragment.c {
        public C0601c() {
        }

        @Override // com.iir_eq.ui.fragment.OtaDaulPickFileFragment.c
        public void a() {
        }

        @Override // com.iir_eq.ui.fragment.OtaDaulPickFileFragment.c
        public void b() {
            c.this.a7("onOtaPickFileOk");
            c.this.J7 = false;
            c.this.A9 = true;
        }
    }

    public class d implements DialogInterface.OnClickListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            c.this.G8 = i10;
        }
    }

    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (c.this.G8 == -1 || c.this.G8 == 4) {
                return;
            }
            c cVar = c.this;
            wf.g.d(cVar, tf.a.B, Integer.valueOf(cVar.G8));
            c cVar2 = c.this;
            wf.g.d(cVar2, tf.a.H, Integer.valueOf(cVar2.G8));
            Bundle bundle = new Bundle();
            bundle.putInt("apply_type", c.this.G8);
            c.this.f52061h8.c5(bundle);
            c.this.f52061h8.Z5(c.this.n3(), "ota_daul_pick_file");
            c.this.t5();
            c.this.J7 = false;
            c.this.A9 = true;
        }
    }

    public class f implements BluetoothProfile.ServiceListener {
        public f() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
            String str = c.this.K2;
            List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
            if (connectedDevices == null || connectedDevices.size() <= 0) {
                c.this.X6("请在手机端和耳机配对，以使用相应功能");
                c.this.Y6("--");
                return;
            }
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                c.this.K6(bluetoothDevice.getName());
                c.this.J6(bluetoothDevice.getAddress());
                c cVar = c.this;
                cVar.O7 = qf.a.f(cVar, bluetoothDevice.getAddress());
                c.this.Y6(bluetoothDevice.getName());
                c.this.X6(bluetoothDevice.getAddress());
                c.this.r4("getConnectBtDetails", "mDevice" + c.this.O7 + ag.c.f654g + bluetoothDevice.getAddress());
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i10) {
            String str = c.this.K2;
            Toast.makeText(c.this, i10 + "", 0).show();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(800L);
                if (c.this.H7) {
                    return;
                }
                c.this.v6();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class h extends ScanCallback {
        public h() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i10) {
            super.onScanFailed(i10);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i10, ScanResult scanResult) {
            boolean z10;
            String strA = wf.a.a(scanResult.getScanRecord().getBytes());
            String strSubstring = "03ff";
            String[] strArrSplit = strA.split("03ff");
            if (strA.contains("03ff03ff")) {
                String[] strArrSplit2 = strA.split("03ff03ff");
                if (strArrSplit2.length > 1) {
                    String str = strArrSplit2[1];
                    int i11 = 0;
                    while (true) {
                        if (i11 >= str.length()) {
                            z10 = true;
                            break;
                        }
                        int i12 = i11 + 1;
                        String strSubstring2 = str.substring(i11, i12);
                        String str2 = c.this.K2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onScanResult singleStr: ++++++++");
                        sb2.append(strSubstring2);
                        if (!strSubstring2.equals("0")) {
                            z10 = false;
                            break;
                        }
                        i11 = i12;
                    }
                    if (!z10) {
                        String str3 = strArrSplit[strArrSplit.length - 1];
                        if (str3.length() < 4) {
                            c cVar = c.this;
                            cVar.r4(cVar.K2, "onScanResult needStr < 4: ++++" + str3);
                            return;
                        }
                        strSubstring = str3.substring(0, 4);
                    }
                }
            } else {
                if (strArrSplit.length <= 1) {
                    return;
                }
                String str4 = strArrSplit[strArrSplit.length - 1];
                if (str4.length() < 4) {
                    c cVar2 = c.this;
                    cVar2.r4(cVar2.K2, "onScanResult needStr < 4: ++++" + str4);
                    return;
                }
                strSubstring = str4.substring(0, 4);
            }
            String str5 = c.this.K2;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onScanResult needStr: ++++++needStr");
            sb3.append(strSubstring);
            String str6 = c.this.K2;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("onScanResult needStr: ++++++curPeripheralId");
            sb4.append(c.this.O9);
            c cVar3 = c.this;
            cVar3.r4(cVar3.K2, "onScanResult needStr : ++++" + strSubstring);
            if (strSubstring.equals(c.this.O9)) {
                c.this.W9.stopScan(c.this.f52050ca);
                c.this.W9 = null;
                c cVar4 = c.this;
                cVar4.r4(cVar4.K2, "onScanResult needStr match : ++++" + strSubstring);
                c.this.O7 = scanResult.getDevice();
                c cVar5 = c.this;
                BluetoothDevice bluetoothDevice = cVar5.O7;
                if (bluetoothDevice != null) {
                    cVar5.K6(bluetoothDevice.getName());
                    c cVar6 = c.this;
                    cVar6.J6(cVar6.O7.getAddress());
                    c cVar7 = c.this;
                    cVar7.f52087u8.setText(cVar7.O7.getAddress());
                    c cVar8 = c.this;
                    cVar8.f52089v8.setText(cVar8.O7.getName());
                    c.this.v5();
                }
            }
        }
    }

    public class i extends TimerTask {
        public i() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (c.this.O9.length() > 0) {
                c.W4(c.this);
                if (c.this.f52044aa > 3 && !c.this.P9) {
                    c.this.M6();
                } else if (c.this.P9) {
                    c.this.f52044aa = 0;
                }
                String str = c.this.K2;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("initTimer otaStateNum+++++");
                sb2.append(c.this.f52044aa);
                c cVar = c.this;
                cVar.r4(cVar.K2, "initTimer otaStateNum+++++" + c.this.f52044aa);
            }
        }
    }

    public class j implements RadioGroup.OnCheckedChangeListener {
        public j() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            radioGroup.getCheckedRadioButtonId();
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            if (checkedRadioButtonId == R.id.slow_mod) {
                wf.g.d(c.this.getApplicationContext(), tf.a.O, "1");
                String str = c.this.K2;
            } else if (checkedRadioButtonId == R.id.fast_mod) {
                wf.g.d(c.this.getApplicationContext(), tf.a.O, "2");
                String str2 = c.this.K2;
            }
        }
    }

    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (z10) {
                wf.g.d(c.this.getApplicationContext(), tf.a.M, Boolean.TRUE);
                c.this.r4("ack_enable = true;", "ack_enable = true;");
            } else {
                c.this.r4("ack_enable = false;", "ack_enable = false;");
                wf.g.d(c.this.getApplicationContext(), tf.a.M, Boolean.FALSE);
            }
        }
    }

    public class l extends Handler {
        public l() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            switch (i10) {
                case 0:
                    c.this.r4("MSG_UPDATE_INFO", message.obj.toString());
                    c.this.f52093x8.setText(message.obj.toString());
                    c.this.f52094x9 = c.this.f52094x9 + "\n" + message.obj.toString();
                    if (c.this.X8.equals("SppOtaActivity") || c.this.X8.equals("LeOtaActivity")) {
                        c.this.f52090v9.setText(c.this.f52094x9);
                    }
                    break;
                case 1:
                    c cVar = c.this;
                    ProgressBar progressBar = cVar.f52097z8;
                    if (progressBar == null) {
                        cVar.r4(cVar.K2, "mOtaProgress is null");
                    } else {
                        progressBar.setProgress(((Integer) message.obj).intValue());
                        c.this.A8.setText(((Integer) message.obj) + i6.a.f31863g);
                    }
                    break;
                case 2:
                case 3:
                    c.this.r4("OtaActivity", "MSG_SEND_INFO_TIME_OUT|MSG_SEND_INFO_TIME_OUT time out");
                    c cVar2 = c.this;
                    cVar2.r4(cVar2.K2, "MSG_SEND_INFO_TIME_OUT|MSG_SEND_INFO_TIME_OUT time out");
                    c cVar3 = c.this;
                    TextView textView = cVar3.f52093x8;
                    if (textView != null) {
                        textView.setText(message.arg1);
                        c.this.f52094x9 = c.this.f52094x9 + "\nMSG_SEND_INFO_TIME_OUT";
                        c.this.f52090v9.setText(c.this.f52094x9);
                    } else {
                        cVar3.r4(cVar3.K2, "mOtaInfo is null");
                    }
                    c.this.O6(message.arg2, 0L);
                    break;
                case 4:
                    c cVar4 = c.this;
                    cVar4.r4(cVar4.K2, "MSG_UPDATE_RESULT_INFO");
                    TextView textView2 = c.this.f52095y8;
                    if (textView2 != null) {
                        textView2.setText(message.obj.toString());
                    }
                    break;
                case 5:
                    c cVar5 = c.this;
                    cVar5.r4(cVar5.K2, "MSG_UPDATE_VERSION");
                    c.this.W8.setText(message.obj.toString());
                    break;
                case 6:
                    c cVar6 = c.this;
                    cVar6.r4(cVar6.K2, "MSG_UPDATE_OTA_DAUL_FILE_INFO");
                    c.this.q4();
                    break;
                case 7:
                    c cVar7 = c.this;
                    cVar7.r4(cVar7.K2, "MSG_UPDATE_OTA_DAUL_FILE_INFO");
                    String str = c.this.X8;
                    if (str != "DumpLogActivity" && str != "CrashLogActivity") {
                        if (!message.obj.toString().equals("true")) {
                            c.this.K8.setVisibility(0);
                            c.this.W8.setText("--");
                            c.this.E8.setEnabled(false);
                        } else {
                            c.this.K8.setVisibility(8);
                            c.this.E8.setEnabled(true);
                            c cVar8 = c.this;
                            cVar8.r4(cVar8.K2, "handleMessage connectImmediately--: " + c.this.Q9);
                            if (c.this.Q9) {
                                c.this.r4("role switch", "RESTART OTA");
                                String str2 = c.this.K2;
                                if (c.this.A9) {
                                    c.this.J7 = false;
                                    c.this.A9 = false;
                                } else {
                                    c.this.F6();
                                }
                                if (c.this.G8 == -1 || c.this.G8 == 4) {
                                    c.this.B6();
                                } else {
                                    c.this.C6();
                                }
                            }
                        }
                        break;
                    }
                    break;
                case 8:
                    c cVar9 = c.this;
                    cVar9.r4(cVar9.K2, "MSG_UPDATE_BT_CONNECTED_ADDRESS");
                    c.this.f52087u8.setText(message.obj.toString());
                    break;
                case 9:
                    c cVar10 = c.this;
                    cVar10.r4(cVar10.K2, "MSG_UPDATE_BT_CONNECTED_NAME");
                    c.this.f52089v8.setText(message.obj.toString());
                    break;
                default:
                    switch (i10) {
                        case 16:
                            c.this.r4("MSG_GET_FIREWARE_VERSION_TIME_OUT", "reGetVersionTimes " + c.this.f52075o8);
                            c cVar11 = c.this;
                            if (cVar11.f52075o8 < 3) {
                                cVar11.y6();
                            } else if (cVar11.O9.length() <= 0) {
                                c cVar12 = c.this;
                                cVar12.f52075o8 = 0;
                                cVar12.r4("OtaActivity", "MSG_GET_FIREWARE_VERSION_TIME_OUT");
                                c.this.W8.setText("STEREO\nUnable to upgrade Ibrt at this time, please exit the upgrade interface and start again!!!");
                                c.this.G8 = 4;
                                wf.g.d(c.this, tf.a.H, 4);
                                c.this.B8.setVisibility(0);
                                c.this.C8.setVisibility(0);
                                c cVar13 = c.this;
                                TextView textView3 = cVar13.f52093x8;
                                if (textView3 != null) {
                                    textView3.setText(message.arg1);
                                    c.this.f52094x9 = c.this.f52094x9 + "\nMSG_GET_FIREWARE_VERSION_TIME_OUT";
                                    c.this.f52090v9.setText(c.this.f52094x9);
                                } else {
                                    cVar13.r4(cVar13.K2, "mOtaInfo is null");
                                }
                                c.this.p6();
                            } else {
                                c.this.r4("MSG_GET_FIREWARE_VERSION_TIME_OUT", "role swich");
                                c.this.Q6(new byte[]{-107, 1});
                                c.this.L6(22, 3000L);
                            }
                            break;
                        case 17:
                            c.this.r4("OtaActivity", "MSG_RESUME_OTA_TIME_OUT");
                            c cVar14 = c.this;
                            TextView textView4 = cVar14.f52093x8;
                            if (textView4 != null) {
                                textView4.setText(message.arg1);
                                c.this.f52094x9 = c.this.f52094x9 + "\nMSG_RESUME_OTA_TIME_OUT";
                                c.this.f52090v9.setText(c.this.f52094x9);
                            } else {
                                cVar14.r4(cVar14.K2, "mOtaInfo is null");
                            }
                            c.this.O6(message.arg2, 0L);
                            break;
                        case 18:
                            if (c.this.f52068k9 != 10) {
                                c.this.Z8.setText("正在获取数据中，请稍候...");
                            } else {
                                c.this.B9.setText("正在获取数据中，请稍候...");
                            }
                            break;
                        case 19:
                            if (c.this.f52068k9 != 1) {
                                String str3 = message.obj.toString() + "\n文件路径:" + c.this.f52060g9;
                                c.this.r4("MSG_UPDATE_FL_ITEM str", str3);
                                c.this.B9.setText(str3);
                            } else {
                                String str4 = message.obj.toString() + "\n文件路径:" + c.this.f52060g9;
                                c.this.r4("MSG_UPDATE_FL_ITEM str", str4);
                                c.this.Z8.setText(str4);
                            }
                            break;
                        case 20:
                            c.this.f52080q9.setVisibility(0);
                            c.this.f52082r9.setVisibility(0);
                            c.this.f52080q9.setText(message.obj.toString());
                            break;
                        case 21:
                            c.this.s4();
                            break;
                        case 22:
                            c.this.M6();
                            break;
                        case 23:
                            c cVar15 = c.this;
                            cVar15.r4(cVar15.K2, "MSG_CHOOSE_UPGRADE_TIME_OUT");
                            break;
                    }
                    break;
            }
        }
    }

    public class m implements DialogInterface.OnClickListener {
        public m() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            c.this.x5();
            c.this.finish();
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F8.setEnabled(true);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F8.setEnabled(true);
        }
    }

    public class p extends Handler {
        public p(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            c.this.r4("handleMessage", message + "--daulApply检测--" + c.this.G8);
            if (c.this.X8.equals("SppOtaActivity") && c.this.G8 == 5 && c.this.H8 != 100) {
                c cVar = c.this;
                cVar.G8 = cVar.H8;
            }
            if (!c.this.X8.equals("SppOtaActivity") || c.this.W9 == null) {
                c.this.r4("handleMessage", message + "--daulApply检测后--" + c.this.G8);
                switch (message.what) {
                    case 128:
                        c.this.u5();
                        break;
                    case 129:
                        c.this.w5();
                        break;
                    case 130:
                        c.this.T5();
                        break;
                    case 131:
                        c.this.r4("CMD_START_OTA", "CMD_START_OTA");
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.U6();
                        }
                        break;
                    case 132:
                        c cVar2 = c.this;
                        cVar2.r4(cVar2.K2, "handleMessage CMD_OTA_NEXT--" + c.this.R9);
                        if (c.this.S9 || c.this.R9) {
                            c.this.r4("CMD_OTA_NEXT", "dataSendAndVerifyOver--" + c.this.S9 + "--dataSendOver--" + c.this.R9);
                        } else {
                            c.this.t6();
                        }
                        break;
                    case 133:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.R6();
                        }
                        break;
                    case 134:
                        c.this.U5();
                        break;
                    case 136:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c cVar3 = c.this;
                            cVar3.r4(cVar3.K2, "resend the msg");
                            c.this.O6(132, 0L);
                        }
                        break;
                    case 137:
                        c.this.V5();
                        break;
                    case 140:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            String str = c.this.K2;
                            c.this.N6();
                        }
                        break;
                    case 142:
                        c cVar4 = c.this;
                        cVar4.r4(cVar4.K2, "CMD_SEND_HW_INFO");
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.K5();
                        }
                        break;
                    case 144:
                        c.this.Y5();
                        break;
                    case 145:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.V6();
                        }
                        break;
                    case 146:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c cVar5 = c.this;
                            byte[][][] bArr = cVar5.U7;
                            if (bArr != null && bArr.length > 0) {
                                cVar5.r4(cVar5.K2, "handleMessage: +++++++++++++mOtaData != null");
                            } else {
                                cVar5.s6();
                            }
                        }
                        break;
                    case c.Ya /* 147 */:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c cVar6 = c.this;
                            cVar6.t4(cVar6.f52068k9);
                        }
                        break;
                    case 153:
                        String str2 = c.this.K2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("handleMessage: ROLE_SWITCH_FLAG ++++++++++");
                        sb2.append(c.this.f52072m9);
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.r4("CMD_APPLY_THE_IMAGE_MSG", "CMD_APPLY_THE_IMAGE_MSG");
                            c.this.E5();
                        }
                        break;
                    case 154:
                        c.this.r4("CMD_APPLY_CHANGE", "CMD_APPLY_CHANGE");
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.F5();
                        }
                        break;
                    case 155:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.r4("CMD_OVERWRITING_CONFIRM", "CMD_OVERWRITING_CONFIRM");
                            c.this.I5();
                        }
                        break;
                    case 156:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.n4(c.Qb, "04");
                        }
                        break;
                    case 157:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.o4();
                        }
                        break;
                    case 158:
                        if (c.this.f52072m9 == 0 || c.this.f52072m9 == 2) {
                            c.this.J5();
                        }
                        break;
                    case 159:
                        c.this.r4("CMD_ROLE_SWITCH_RECOONECT", "CMD_ROLE_SWITCH_RECOONECT");
                        c.this.u5();
                        break;
                    case 160:
                        c.this.r4("CMD_ROLE_SWITCH_ACK", "handleCmdRoleSwitchAck");
                        c.this.G5();
                        break;
                    case 161:
                        c.this.r4("CMD_ROLE_SWITCH_RECOONECT_TIMEOUT", "handleCmdRoleSwitchReconnectTimeOut");
                        c.this.H5();
                        break;
                    case 162:
                        c.this.r4("CMD_SET_UPGRADE_TYPE", "CMD_SET_UPGRADE_TYPE");
                        c.this.L5();
                        break;
                    case 163:
                        c.this.r4("CMD_OTA_START_9B", "CMD_OTA_START_9B");
                        c.this.v6();
                        break;
                }
            }
        }
    }

    public static String C5() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    private void Q5() {
        this.E7 = (RadioGroup) findViewById(R.id.upgradechoose);
        String str = (String) wf.g.b(getApplicationContext(), tf.a.O, "1");
        if (str.equals("1")) {
            this.E7.check(R.id.slow_mod);
        } else if (str.equals("2")) {
            this.E7.check(R.id.fast_mod);
        }
        this.F7 = (RadioButton) findViewById(R.id.slow_mod);
        this.G7 = (RadioButton) findViewById(R.id.fast_mod);
        this.E7.setOnCheckedChangeListener(new j());
        this.f52087u8 = (TextView) findViewById(R.id.address);
        this.f52089v8 = (TextView) findViewById(R.id.name);
        this.f52091w8 = (TextView) findViewById(R.id.ota_file);
        this.f52093x8 = (TextView) findViewById(R.id.ota_info);
        this.f52095y8 = (TextView) findViewById(R.id.update_static);
        this.f52097z8 = (ProgressBar) findViewById(R.id.ota_progress);
        this.A8 = (TextView) findViewById(R.id.ota_status);
        this.D8 = (Button) findViewById(R.id.pick_device);
        this.E8 = (Button) findViewById(R.id.pick_ota_file);
        this.F8 = (Button) findViewById(R.id.start_ota);
        this.W8 = (TextView) findViewById(R.id.current_version_details);
        this.K8 = (Button) findViewById(R.id.connect_device_ota);
        this.D8.setOnClickListener(this);
        this.E8.setOnClickListener(this);
        this.E8.setEnabled(false);
        this.F8.setOnClickListener(this);
        this.K8.setOnClickListener(this);
        boolean zBooleanValue = ((Boolean) wf.g.b(getApplicationContext(), tf.a.M, Boolean.FALSE)).booleanValue();
        this.f52089v8.setText(X5());
        this.f52087u8.setText(W5());
        this.B8 = (Switch) findViewById(R.id.ack_switch);
        TextView textView = (TextView) findViewById(R.id.ack_title);
        this.C8 = textView;
        textView.setVisibility(8);
        this.B8.setVisibility(8);
        this.B8.setChecked(zBooleanValue);
        this.B8.setOnCheckedChangeListener(new k());
        this.f52057f8 = new OtaConfigFragment();
        OtaDaulPickFileFragment otaDaulPickFileFragment = new OtaDaulPickFileFragment();
        this.f52061h8 = otaDaulPickFileFragment;
        otaDaulPickFileFragment.i6(this.f52056ea);
        int iZ5 = z5();
        if (iZ5 == -1 || this.X8.equals("LeOtaActivity")) {
            this.D8.setVisibility(0);
        } else {
            this.D8.setVisibility(8);
            A5(iZ5);
        }
        this.f52090v9 = (TextView) findViewById(R.id.ota_info_list);
        this.f52094x9 = "";
        this.f52096y9 = "";
        if (s5()) {
            F6();
        }
        if (this.X8.equals("LeOtaActivity")) {
            if (this.Y9 == null) {
                P5();
            }
            this.Y9.schedule(this.Z9, 0L, 5000L);
        }
        r4(this.K2, "initView connectImmediately: " + this.Q9);
    }

    public static /* synthetic */ int W4(c cVar) {
        int i10 = cVar.f52044aa;
        cVar.f52044aa = i10 + 1;
        return i10;
    }

    public void A2(boolean z10) {
        r4(this.K2, "onConnectionStateChanged " + z10 + "; " + this.N7 + "--irk--");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onConnectionStateChanged: +++++++++111+++++");
        sb2.append(z10);
        if (z10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onConnectionStateChanged: +++++++++222+++++");
            sb3.append(z10);
            this.P9 = true;
            a6();
            return;
        }
        this.P9 = false;
        E6();
        r4(this.K2, "onConnectionStateChanged----- " + this.X8 + this.O9.length());
        if (this.X8.equals("LeOtaActivity") && this.O9.length() > 0) {
            r4(this.K2, "onConnectionStateChanged----- scanDevice");
            L6(22, 3000L);
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("onConnectionStateChanged: ++++--------------------------");
        sb4.append(this.N7);
        if (this.N7 == 1) {
            W6("true");
            r4(this.K2, "mState == STATE_CONNECTING");
            int i10 = this.f52073n8 + 1;
            this.f52073n8 = i10;
            if (i10 <= 3) {
                e7(String.format(getString(R.string.connect_reconnect_try), Integer.valueOf(this.f52073n8)));
                D6();
                return;
            }
            this.N7 = 4;
            h6();
            this.f52075o8 = 0;
            int i11 = this.f52072m9;
            if (i11 == 0 || i11 == 2) {
                d7(R.string.connect_failed);
                return;
            }
            return;
        }
        if (this.N7 == 5) {
            W6("true");
            r4(this.K2, "mState == STATE_OTA_ING");
            h6();
            return;
        }
        if (this.N7 != 0) {
            r4(this.K2, "mState != STATE_IDLE");
            int i12 = this.f52072m9;
            if (i12 == 0 || i12 == 2) {
                d7(R.string.cf_state_unconnected);
                this.f52075o8 = 0;
            }
            this.N7 = 4;
            int i13 = this.f52072m9;
            if (i13 == 0 || i13 == 2) {
                W6("false");
                this.f52075o8 = 0;
                h6();
                return;
            }
            return;
        }
        if (this.N7 == 0) {
            int i14 = this.f52072m9;
            if (i14 == 0 || i14 == 2) {
                r4(this.K2, "mState == STATE_IDLE");
                int i15 = this.f52072m9;
                if (i15 == 0 || i15 == 2) {
                    d7(R.string.cf_state_unconnected);
                }
                this.N7 = 4;
                this.f52075o8 = 0;
                W6("false");
            }
        }
    }

    public final void A5(int i10) {
        this.S8.getProfileProxy(this, new f(), i10);
    }

    public void A6(String str) {
        String[] strArrSplit = str.substring(0, str.indexOf("4W")).replaceFirst("REV_INFO", "VERSION_INFO").split("\\n");
        g7(strArrSplit[8] + "\n" + strArrSplit[9] + "\n" + strArrSplit[11] + "\n");
        String str2 = strArrSplit[8];
        int iIndexOf = str2.indexOf("0x3C");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(iIndexOf);
        sb2.append("");
        String strSubstring = str2.substring(iIndexOf + 4);
        byte[] bArr = new byte[10];
        byte[] bArrH = wf.a.h(strSubstring);
        wf.a.o(bArrH);
        for (int i10 = 0; i10 < bArrH.length; i10++) {
            bArr[i10 + 2] = bArrH[i10];
        }
        bArr[5] = 0;
        String str3 = strArrSplit[9];
        String strSubstring2 = str3.substring(str3.indexOf("0x") + 2);
        if (strSubstring2.length() % 2 > 0) {
            strSubstring2 = "0" + strSubstring2;
        }
        byte[] bArrH2 = wf.a.h(strSubstring2);
        int i11 = (Integer.parseInt(strSubstring2, 16) * 129) / 128;
        this.f52046b9 = i11;
        this.f52064i9 = new byte[i11];
        this.f52066j9 = new byte[Integer.parseInt(strSubstring2, 16)];
        r4(this.K2, "flash_content_byte_total_num:" + this.f52046b9);
        for (int i12 = 0; i12 < bArrH2.length; i12++) {
            bArr[i12 + 6] = bArrH2[i12];
        }
        try {
            bArr[0] = -119;
            bArr[1] = 1;
            wf.a.o(bArr);
            Q6(bArr);
            this.f52068k9 = 1;
            this.f52043a9 = 0;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract int B5(int i10);

    public void B6() {
        this.F8.setEnabled(false);
        r4(this.K2, "readyOta  daulApply" + this.G8);
        if (TextUtils.isEmpty(this.f52087u8.getText())) {
            m4(getString(R.string.pick_device_tips));
            return;
        }
        if (TextUtils.isEmpty(this.f52091w8.getText()) || this.G8 == 5) {
            m4(getString(R.string.pick_File_tips));
            return;
        }
        if (!this.J7) {
            this.f52057f8.Z5(n3(), "ota_config");
        } else if (this.G8 == 4) {
            O6(140, 0L);
        } else {
            O6(153, 0L);
            this.f52063i8 = System.currentTimeMillis();
        }
    }

    public final void C6() {
        int i10;
        if (TextUtils.isEmpty(this.f52087u8.getText())) {
            m4(getString(R.string.pick_device_tips));
            return;
        }
        if (TextUtils.isEmpty(this.f52091w8.getText())) {
            m4(getString(R.string.pick_File_tips));
            return;
        }
        if (this.N7 != 2 || (i10 = this.G8) == -1) {
            return;
        }
        if (!this.J7) {
            this.L8 = 0;
            this.N8 = 0;
            this.f52057f8.Z5(n3(), "ota_config");
            return;
        }
        if (i10 == 0 || i10 == 1) {
            O6(153, 0L);
            return;
        }
        if (i10 == 2) {
            this.f52084s9 = 0;
            O6(153, 0L);
        } else if (i10 == 3) {
            int i11 = this.L7;
            this.L8 = i11;
            if (i11 == 1) {
                this.T8 = 1;
            } else {
                this.L8 = 0;
                this.T8 = 0;
            }
            O6(153, 0L);
        }
    }

    public void D5(byte[] bArr) {
        byte[] bArr2 = new byte[10];
        wf.a.o(bArr);
        int i10 = 0;
        while (i10 < 3) {
            int i11 = i10 + 2;
            i10++;
            bArr2[i11] = bArr[i10];
        }
        byte[] bArrH = wf.a.h(Pb);
        for (int i12 = 0; i12 < bArrH.length; i12++) {
            bArr2[i12 + 6] = bArrH[i12];
        }
        try {
            bArr2[0] = -119;
            bArr2[1] = 1;
            wf.a.o(bArr2);
            Q6(bArr2);
            this.f52068k9 = 0;
            this.f52052d9 = 0;
            this.f52049c9 = 0;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void D6() {
        r4(this.K2, "reconnect " + this.N7 + " SPAN TIME IS 3000");
        wf.d.A(this.K2, "reconnect " + this.N7 + " SPAN TIME IS 3000");
        this.N7 = 0;
        if (S5()) {
            f7(0);
            O6(128, 3000L);
        }
    }

    public final void E5() {
        r4(this.K2, "handleApplyTheImage CMD_APPLY_THE_IMAGE_MSG");
        int i10 = this.G8;
        if (i10 == 3 && this.L8 == 0) {
            if (this.I7 == 1) {
                r4(this.K2, "daulApply == APPLY_BOTH_EARBUD_IN_TWO && daul_step == 0 mDaulConnectState == DAUL_CONNECT_LEFT");
                this.I8 = (byte) 16;
            } else if (this.I7 == 2) {
                r4(this.K2, "daulApply == APPLY_BOTH_EARBUD_IN_TWO && daul_step == 0 mDaulConnectState == DAUL_CONNECT_RIGHT");
                this.I8 = (byte) 1;
            }
        } else if (i10 == 3 && this.L8 == 1) {
            if (this.I7 == 1) {
                r4(this.K2, "daulApply == APPLY_BOTH_EARBUD_IN_TWO && daul_step == 1 mDaulConnectState == DAUL_CONNECT_LEFT");
                this.I8 = (byte) 1;
            } else if (this.I7 == 2) {
                r4(this.K2, "daulApply == APPLY_BOTH_EARBUD_IN_TWO && daul_step == 1 mDaulConnectState == DAUL_CONNECT_RIGHT");
                this.I8 = (byte) 16;
            }
        } else if (i10 == 2 && this.f52084s9 == 0) {
            this.I8 = (byte) 1;
            this.N8 = -1;
        } else if (i10 == 2 && this.f52084s9 == 1) {
            this.I8 = (byte) 16;
            this.N8 = -1;
        } else if (i10 == 2 && this.f52084s9 == 2) {
            this.I8 = (byte) 17;
            this.N8 = 0;
        }
        O6(162, 0L);
    }

    public void E6() {
        r4(this.K2, "removeTimeout");
        this.f52053da.removeMessages(2);
    }

    public void F5() {
        try {
            byte[] bArr = {-112, 17};
            Q6(bArr);
            r4("handleChangeApply", wf.a.o(bArr));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void F6() {
        int i10 = this.M7;
        if (i10 != 3 && i10 != 0 && i10 != 1 && i10 != 2) {
            if (i10 == -1 || i10 == 4) {
                this.f52098z9 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
                this.I8 = (byte) 0;
                this.G8 = this.M7;
                this.f52091w8.setText(wf.g.b(this, "ota_file", "").toString());
                if (this.f52098z9 == 0) {
                    this.J7 = false;
                    return;
                } else {
                    this.J7 = true;
                    return;
                }
            }
            return;
        }
        if (i10 == 0) {
            r4("MSG_UPDATE_INFO", "resume APPLY_LEFT_EARBUD_ONLY");
            int iIntValue = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue;
            if (iIntValue == 0) {
                this.J7 = false;
                return;
            }
            this.J7 = true;
            this.f52091w8.setText(getString(R.string.left_earbud_only) + ":\n" + this.K7);
            this.J7 = true;
            this.I8 = (byte) 1;
            this.G8 = this.M7;
            return;
        }
        if (i10 == 2) {
            r4("MSG_UPDATE_INFO", "resume APPLY_BOTH_EARBUD_IN_ONE");
            this.f52086t9 = 0;
            this.f52088u9 = 0;
            this.f52091w8.setText(getString(R.string.both_earbuds_in_one_bin) + ":\n" + ((String) wf.g.b(getApplicationContext(), tf.a.D, "")));
            this.f52084s9 = 0;
            this.J7 = true;
            this.G8 = this.M7;
            int iIntValue2 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue2;
            if (iIntValue2 == 0) {
                this.J7 = false;
                return;
            } else {
                this.J7 = true;
                return;
            }
        }
        if (i10 == 1) {
            r4("MSG_UPDATE_INFO", "resume APPLY_RIGHT_EARBUD_ONLY");
            this.f52091w8.setText(getString(R.string.right_earbud_only) + ":\n" + this.K7);
            this.G8 = this.M7;
            this.I8 = (byte) 16;
            this.J7 = true;
            int iIntValue3 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue3;
            if (iIntValue3 == 0) {
                this.J7 = false;
                return;
            } else {
                this.J7 = true;
                return;
            }
        }
        if (i10 == 3) {
            this.G8 = i10;
            this.f52091w8.setText(((getString(R.string.both_earbuds_in_two_bins) + "\n") + getString(R.string.left_earbud_image) + ":" + ((String) wf.g.b(this, tf.a.D, "")) + "\n") + getString(R.string.right_earbud_image) + ":" + ((String) wf.g.b(this, tf.a.E, "")));
            this.J7 = true;
            int iIntValue4 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue4;
            if (iIntValue4 == 0) {
                this.J7 = false;
            } else {
                this.J7 = true;
            }
        }
    }

    public final void G5() {
        r4("handleCmdRoleSwitchAck", "handleCmdRoleSwitchAck");
        r4("handleCmdRoleSwitchAck", "res" + Q6(new byte[]{-107, 1}));
    }

    public final boolean G6() {
        long jLongValue = ((Long) wf.g.b(this, tf.a.N, 0L)).longValue();
        r4("resumeImgCRCCheck", "crcdata:" + jLongValue);
        if (jLongValue == p4()) {
            r4("resumeImgCRCCheck", "true");
            return true;
        }
        r4("resumeImgCRCCheck", "false");
        return false;
    }

    public final void H5() {
        this.f52072m9 = 0;
    }

    public final void H6() {
        int i10 = this.M7;
        if (i10 != 3 && i10 != 0 && i10 != 1 && i10 != 2) {
            if (i10 == -1 || i10 == 4) {
                int iIntValue = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
                this.f52098z9 = iIntValue;
                this.I8 = (byte) 0;
                this.G8 = this.M7;
                if (iIntValue == 0) {
                    this.J7 = false;
                    return;
                } else {
                    this.J7 = true;
                    return;
                }
            }
            return;
        }
        if (i10 == 0) {
            int iIntValue2 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue2;
            if (iIntValue2 == 0) {
                this.J7 = false;
                return;
            }
            this.J7 = true;
            this.I8 = (byte) 1;
            this.G8 = this.M7;
            return;
        }
        if (i10 == 2) {
            this.f52086t9 = 0;
            this.f52088u9 = 0;
            this.f52091w8.setText("");
            this.f52084s9 = 0;
            this.J7 = true;
            this.G8 = this.M7;
            int iIntValue3 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue3;
            if (iIntValue3 == 0) {
                this.J7 = false;
                return;
            } else {
                this.J7 = true;
                return;
            }
        }
        if (i10 == 1) {
            this.G8 = i10;
            this.I8 = (byte) 16;
            this.J7 = true;
            int iIntValue4 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue4;
            if (iIntValue4 == 0) {
                this.J7 = false;
                return;
            } else {
                this.J7 = true;
                return;
            }
        }
        if (i10 == 3) {
            this.G8 = i10;
            this.J7 = true;
            int iIntValue5 = ((Integer) wf.g.b(this, tf.a.L, 0)).intValue();
            this.f52098z9 = iIntValue5;
            if (iIntValue5 == 0) {
                this.J7 = false;
            } else {
                this.J7 = true;
            }
        }
    }

    public void I5() {
        r4(this.K2, "handleConfirmOverWriting");
        e7(getString(R.string.ota_version_integrity_verification));
        try {
            if (Q6(new byte[]{-110, 66, 69, 83, 84})) {
                this.T9 = false;
                r4(this.K2, "handleConfirmOverWriting92成功--" + this.T9);
            } else {
                this.T9 = true;
                r4(this.K2, "handleConfirmOverWriting92--" + this.T9);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void I6() {
        r4("MSG_UPDATE_INFO", this.G8 + "--roleSwitchOtaStart");
        this.f52072m9 = 0;
        this.G8 = -1;
        if (this.A9) {
            B6();
            return;
        }
        r4("roleSwitchOtaStart", "pick_new_file == false");
        H6();
        int i10 = this.G8;
        if (i10 == -1 || i10 == 4) {
            B6();
        } else {
            C6();
        }
    }

    public final void J5() {
        byte[] bArr = new byte[10];
        byte[] bArrH = wf.a.h("3000");
        this.K9 = 12288;
        int i10 = (12288 / 128) * 129;
        this.L9 = i10;
        this.I9 = new byte[i10];
        this.J9 = new byte[12288];
        for (int i11 = 0; i11 < bArrH.length; i11++) {
            bArr[i11 + 6] = bArrH[i11];
        }
        byte[] bArr2 = {0, pq.b.f46994k, 15, 0};
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i12 + 2] = bArr2[i12];
        }
        try {
            bArr[0] = -119;
            bArr[1] = 1;
            Q6(bArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract void J6(String str);

    public final void K5() {
        r4(this.K2, "handleGetCurrentVersion");
        try {
            boolean zQ6 = Q6(new byte[]{-114, 66, 69, 83, 84});
            Message messageObtainMessage = this.f52053da.obtainMessage(16);
            int i10 = R.string.old_ota_profile;
            messageObtainMessage.arg1 = i10;
            messageObtainMessage.arg2 = i10;
            this.f52053da.sendMessageDelayed(messageObtainMessage, 3000L);
            r4("handleGetCurrentVersion", " sendRet:" + zQ6);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract void K6(String str);

    public final void L5() {
        r4(this.K2, "handleSetUpgradetype");
        String str = (String) wf.g.b(getApplicationContext(), tf.a.O, "1");
        try {
            if (str.equals("1")) {
                Q6(new byte[]{-99, 1});
                StringBuilder sb2 = new StringBuilder();
                sb2.append("type++++++");
                sb2.append(str);
            } else if (str.equals("2")) {
                Q6(new byte[]{-99, 2});
                StringBuilder sb3 = new StringBuilder();
                sb3.append("type++++++");
                sb3.append(str);
            }
            new Thread(new g()).start();
            Message messageObtainMessage = this.f52053da.obtainMessage(23);
            messageObtainMessage.arg1 = R.string.set_upgrade_mod;
            messageObtainMessage.arg2 = R.string.old_ota_profile;
            this.f52053da.sendMessageDelayed(messageObtainMessage, 1000L);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void L6(int i10, long j10) {
        Message messageObtainMessage = this.f52053da.obtainMessage(22);
        messageObtainMessage.arg2 = i10;
        this.f52053da.sendMessageDelayed(messageObtainMessage, j10);
    }

    public void M5() {
        HandlerThread handlerThread = new HandlerThread(this.K2);
        this.Q7 = handlerThread;
        handlerThread.start();
        this.R7 = new p(this.Q7.getLooper());
    }

    public final void M6() {
        this.f52044aa = 0;
        this.H8 = 100;
        this.U9 = 0;
        this.f52073n8 = 0;
        this.V7 = 0;
        this.f52083s8 = false;
        this.W7 = 0;
        this.Z7 = 0;
        this.N7 = 0;
        this.U7 = null;
        wf.g.d(this, tf.a.I, Integer.valueOf(this.L8));
        wf.g.d(this, tf.a.H, Integer.valueOf(this.G8));
        this.L8 = -1;
        this.N8 = 0;
        this.O8 = 0;
        this.f52084s9 = -1;
        this.f52086t9 = 0;
        this.f52088u9 = 0;
        this.P8 = 0;
        this.M9 = 0;
        r4("onConnectionStateChanged role switch", "RESTART SCAN");
        this.V9 = 0;
        this.X7 = false;
        this.f52051d8 = false;
        BluetoothLeScanner bluetoothLeScanner = this.W9;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f52050ca);
            this.W9 = null;
        }
        BluetoothLeScanner bluetoothLeScanner2 = qf.a.d(this).getBluetoothLeScanner();
        this.W9 = bluetoothLeScanner2;
        bluetoothLeScanner2.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), this.f52050ca);
    }

    public final void N5() {
        I3().Y(true);
        this.f52087u8 = (TextView) findViewById(R.id.crash_log_address);
        this.f52089v8 = (TextView) findViewById(R.id.crash_log_name);
        this.f52093x8 = (TextView) findViewById(R.id.crash_log_ota_info);
        this.D8 = (Button) findViewById(R.id.crash_log_pick_device);
        this.B9 = (TextView) findViewById(R.id.crash_content_details);
        this.C9 = (Button) findViewById(R.id.crash_log_read_fw_version);
        this.D8.setOnClickListener(this);
        this.f52089v8.setText(X5());
        this.f52087u8.setText(W5());
        this.O7 = qf.a.f(this, this.f52087u8.getText().toString());
        this.f52080q9 = (TextView) findViewById(R.id.fw_version_info);
        this.f52082r9 = (TextView) findViewById(R.id.fw_version_title);
        this.C9.setOnClickListener(this);
    }

    public void N6() {
        r4("OtaActivity", "sendBreakPointCheckReq");
        int i10 = this.G8;
        int i11 = 2;
        if (i10 == 2) {
            if (this.f52084s9 == 0) {
                try {
                    this.S7 = new byte[45];
                    byte[] bArr = new byte[32];
                    String str = (String) wf.g.b(this, tf.a.J, "");
                    if (str == null || str == "") {
                        for (int i12 = 0; i12 < 32; i12++) {
                            bArr[i12] = 1;
                            this.S7[i12 + 5] = 1;
                        }
                        wf.g.d(getApplicationContext(), tf.a.J, wf.a.o(bArr));
                        wf.a.o(bArr);
                    } else {
                        byte[] bArrN = wf.a.n(str);
                        r4("sendBreakPoCodestr", "randomCodestr:" + str);
                        r4("sendBreak PorandomCode", "fanxiaoli:" + wf.a.o(bArrN));
                        for (int i13 = 0; i13 < bArrN.length; i13++) {
                            this.S7[i13 + 5] = bArrN[i13];
                        }
                        r4("mOtaResumeDatnormally", "" + wf.a.o(this.S7));
                    }
                    byte[] bArr2 = this.S7;
                    bArr2[0] = -116;
                    bArr2[1] = 66;
                    bArr2[2] = 69;
                    bArr2[3] = 83;
                    bArr2[4] = 84;
                    bArr2[37] = 1;
                    bArr2[38] = 2;
                    bArr2[39] = 3;
                    bArr2[40] = 4;
                    int i14 = 36;
                    byte[] bArr3 = new byte[36];
                    int i15 = 0;
                    while (i15 < i14) {
                        bArr3[i15] = this.S7[i15 + 5];
                        i15++;
                        i14 = 36;
                    }
                    long jF = wf.a.f(bArr3, 0, i14);
                    byte[] bArr4 = this.S7;
                    bArr4[41] = (byte) jF;
                    bArr4[42] = (byte) (jF >> 8);
                    bArr4[43] = (byte) (jF >> 16);
                    bArr4[44] = (byte) (jF >> 24);
                    r4("mOtaResumeDataReq", "" + wf.a.o(this.S7));
                    d7(R.string.resume_request_verify);
                    Q6(this.S7);
                    Message messageObtainMessage = this.f52053da.obtainMessage(17);
                    messageObtainMessage.arg1 = R.string.old_ota_profile;
                    messageObtainMessage.arg2 = 133;
                    this.f52053da.sendMessageDelayed(messageObtainMessage, 10000L);
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    r4("Exception", e10.getMessage());
                    return;
                }
            }
            i11 = 2;
        }
        if (i10 == i11) {
            if (this.f52084s9 == 1) {
                try {
                    this.S7 = new byte[45];
                    byte[] bArr5 = new byte[32];
                    String str2 = (String) wf.g.b(this, tf.a.K, "");
                    if (str2 == null || str2 == "") {
                        for (int i16 = 0; i16 < 32; i16++) {
                            bArr5[i16] = 1;
                            this.S7[i16 + 5] = 1;
                        }
                        wf.g.d(getApplicationContext(), tf.a.K, wf.a.o(bArr5));
                        wf.a.o(bArr5);
                    } else {
                        byte[] bArrN2 = wf.a.n(str2);
                        r4("sendBreakPoCodestr", "randomCodestr:" + str2);
                        r4("sendBreak PorandomCode", "fanxiaoli:" + wf.a.o(bArrN2));
                        for (int i17 = 0; i17 < bArrN2.length; i17++) {
                            this.S7[i17 + 5] = bArrN2[i17];
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("");
                        sb2.append(wf.a.o(this.S7));
                    }
                    byte[] bArr6 = this.S7;
                    bArr6[0] = -116;
                    bArr6[1] = 66;
                    bArr6[2] = 69;
                    bArr6[3] = 83;
                    bArr6[4] = 84;
                    bArr6[37] = 1;
                    bArr6[38] = 2;
                    bArr6[39] = 3;
                    bArr6[40] = 4;
                    int i18 = 36;
                    byte[] bArr7 = new byte[36];
                    int i19 = 0;
                    while (i19 < i18) {
                        bArr7[i19] = this.S7[i19 + 5];
                        i19++;
                        i18 = 36;
                    }
                    long jF2 = wf.a.f(bArr7, 0, i18);
                    byte[] bArr8 = this.S7;
                    bArr8[41] = (byte) jF2;
                    bArr8[42] = (byte) (jF2 >> 8);
                    bArr8[43] = (byte) (jF2 >> 16);
                    bArr8[44] = (byte) (jF2 >> 24);
                    r4("mOtaResumeDataReq", "" + wf.a.o(this.S7));
                    d7(R.string.resume_request_verify);
                    Q6(this.S7);
                    Message messageObtainMessage2 = this.f52053da.obtainMessage(17);
                    messageObtainMessage2.arg1 = R.string.old_ota_profile;
                    messageObtainMessage2.arg2 = 133;
                    this.f52053da.sendMessageDelayed(messageObtainMessage2, 10000L);
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    r4("Exception", e11.getMessage());
                    return;
                }
            }
        }
        try {
            this.S7 = new byte[45];
            byte[] bArr9 = new byte[32];
            String str3 = (String) wf.g.b(this, tf.a.A, "");
            if (str3 == null || str3 == "") {
                for (int i20 = 0; i20 < 32; i20++) {
                    bArr9[i20] = 1;
                    this.S7[i20 + 5] = 1;
                }
                wf.g.d(getApplicationContext(), tf.a.A, wf.a.o(bArr9));
                r4("null fanxiaoli", wf.a.o(bArr9));
            } else {
                byte[] bArrN3 = wf.a.n(str3);
                r4("sendBreakPoCodestr", "randomCodestr:" + str3);
                r4("sendBreak PorandomCode", "fanxiaoli:" + wf.a.o(bArrN3));
                for (int i21 = 0; i21 < bArrN3.length; i21++) {
                    this.S7[i21 + 5] = bArrN3[i21];
                }
                r4("mOtaResumeDatnormally", "" + wf.a.o(this.S7));
            }
            byte[] bArr10 = this.S7;
            bArr10[0] = -116;
            bArr10[1] = 66;
            bArr10[2] = 69;
            bArr10[3] = 83;
            bArr10[4] = 84;
            bArr10[37] = 1;
            bArr10[38] = 2;
            bArr10[39] = 3;
            bArr10[40] = 4;
            int i22 = 36;
            byte[] bArr11 = new byte[36];
            int i23 = 0;
            while (i23 < i22) {
                bArr11[i23] = this.S7[i23 + 5];
                i23++;
                i22 = 36;
            }
            long jF3 = wf.a.f(bArr11, 0, i22);
            byte[] bArr12 = this.S7;
            bArr12[41] = (byte) jF3;
            bArr12[42] = (byte) (jF3 >> 8);
            bArr12[43] = (byte) (jF3 >> 16);
            bArr12[44] = (byte) (jF3 >> 24);
            r4("mOtaResumeDataReq", "" + wf.a.o(this.S7));
            d7(R.string.resume_request_verify);
            r4("mOtaResumeDataReq", "ret " + Q6(this.S7));
            Message messageObtainMessage3 = this.f52053da.obtainMessage(17);
            messageObtainMessage3.arg1 = R.string.old_ota_profile;
            messageObtainMessage3.arg2 = 133;
            this.f52053da.sendMessageDelayed(messageObtainMessage3, 10000L);
        } catch (Exception e12) {
            e12.printStackTrace();
            e12.getMessage();
        }
    }

    public final void O5() {
        I3().Y(true);
        this.f52087u8 = (TextView) findViewById(R.id.dump_log_address);
        this.f52089v8 = (TextView) findViewById(R.id.dump_log_name);
        this.f52093x8 = (TextView) findViewById(R.id.dump_log_ota_info);
        this.D8 = (Button) findViewById(R.id.dump_log_pick_device);
        this.f52074n9 = (Button) findViewById(R.id.dump_log_read_fw_version);
        this.Z8 = (TextView) findViewById(R.id.flash_content_details);
        this.D8.setOnClickListener(this);
        this.f52074n9.setOnClickListener(this);
        this.f52089v8.setText(X5());
        this.f52087u8.setText(W5());
        this.O7 = qf.a.f(this, this.f52087u8.getText().toString());
        this.f52080q9 = (TextView) findViewById(R.id.fw_version_info);
        this.f52082r9 = (TextView) findViewById(R.id.fw_version_title);
    }

    public void O6(int i10, long j10) {
        this.R7.removeMessages(i10);
        if (j10 == 0) {
            this.R7.sendEmptyMessage(i10);
        } else {
            this.R7.sendEmptyMessageDelayed(i10, j10);
        }
    }

    public void P5() {
        this.Y9 = new Timer();
        this.Z9 = new i();
    }

    public void P6() {
        try {
            byte[] bArr = {-116, 66, 69, 83, 84};
            wf.a.o(bArr);
            this.J8.setText(wf.a.o(bArr));
            Q6(bArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract boolean Q6(byte[] bArr);

    public abstract boolean R5();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0112 A[Catch: all -> 0x01a5, Exception -> 0x01a7, TryCatch #1 {all -> 0x01a5, blocks: (B:3:0x0017, B:8:0x0024, B:11:0x002a, B:56:0x0103, B:58:0x0112, B:59:0x0117, B:62:0x0188, B:63:0x018e, B:15:0x0041, B:69:0x01a8, B:23:0x0062, B:27:0x0077, B:29:0x007b, B:32:0x0081, B:42:0x00be, B:33:0x00a1, B:35:0x00a5, B:44:0x00c6, B:46:0x00ca, B:48:0x00ce, B:49:0x00db, B:52:0x00ed, B:54:0x00f3), top: B:82:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018e A[Catch: all -> 0x01a5, Exception -> 0x01a7, TRY_LEAVE, TryCatch #1 {all -> 0x01a5, blocks: (B:3:0x0017, B:8:0x0024, B:11:0x002a, B:56:0x0103, B:58:0x0112, B:59:0x0117, B:62:0x0188, B:63:0x018e, B:15:0x0041, B:69:0x01a8, B:23:0x0062, B:27:0x0077, B:29:0x007b, B:32:0x0081, B:42:0x00be, B:33:0x00a1, B:35:0x00a5, B:44:0x00c6, B:46:0x00ca, B:48:0x00ce, B:49:0x00db, B:52:0x00ed, B:54:0x00f3), top: B:82:0x0017 }] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v37, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v55, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01b2 -> B:83:0x01b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void R6() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.R6():void");
    }

    public boolean S5() {
        return this.N7 == 0 || this.N7 == 6 || this.N7 == 4;
    }

    public void S6(int i10, int i11, long j10) {
        r4(this.K2, "sendTimeout info " + i10 + " ; cmd " + i11 + " ; millis " + j10);
        Message messageObtainMessage = this.f52053da.obtainMessage(2);
        messageObtainMessage.arg1 = i10;
        messageObtainMessage.arg2 = i11;
        this.f52053da.sendMessageDelayed(messageObtainMessage, j10);
    }

    @Override // rf.a
    public void T0(byte[] bArr) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceive data: +++++++");
        sb2.append(wf.a.o(bArr));
        r4(this.K2, "fanxiaoli onReceive data = " + wf.a.o(bArr));
        if (this.N7 == 5 && this.X8.equals("LeOtaActivity")) {
            this.f52044aa = 0;
        }
        BluetoothLeScanner bluetoothLeScanner = this.W9;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f52050ca);
            this.W9 = null;
        }
        boolean zBooleanValue = ((Boolean) wf.g.b(getApplicationContext(), tf.a.G, Boolean.TRUE)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) wf.g.b(getApplicationContext(), tf.a.M, Boolean.FALSE)).booleanValue();
        synchronized (this.f52045b8) {
            if ((bArr[0] & 255) == 158 && bArr.length == 2) {
                this.H7 = true;
                E6();
                this.f52053da.removeMessages(23);
                r4("0x9E", "0x9E");
                if ((bArr[1] & 255) == 1) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("upgradetype: +++");
                    sb3.append(wf.a.o(bArr));
                    this.E7.check(R.id.slow_mod);
                } else if ((bArr[1] & 255) == 2) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("upgradetype: +++");
                    sb4.append(wf.a.o(bArr));
                    this.E7.check(R.id.fast_mod);
                }
                O6(163, 500L);
                return;
            }
            if (bArr.length == 3 && (bArr[0] & 255) == 149 && (bArr[1] & 255) == 131 && (bArr[2] & 255) == 1) {
                E6();
                r4("95,83,01,", "95,83,01,");
                if (this.f52072m9 == 0) {
                    this.f52072m9 = 1;
                    if (R5()) {
                        O6(159, 2000L);
                    } else {
                        this.A9 = false;
                        this.W7 = 0;
                        this.Z7 = 0;
                        this.L8 = -1;
                        this.N8 = 0;
                        this.O8 = 0;
                        this.J7 = true;
                        this.L7 = -1;
                        this.f52084s9 = -1;
                        this.f52086t9 = 0;
                        this.f52088u9 = 0;
                        this.P8 = 0;
                        this.G8 = -1;
                    }
                    Q6(new byte[]{-107, 1});
                    if ((bArr[1] & 255) == 1 && bArr.length == 2) {
                        int i15 = this.G8;
                        if (i15 == 2 && this.N8 == 1) {
                            E6();
                            int i16 = this.V7 + 1;
                            this.V7 = i16;
                            byte[][][] bArr2 = this.U7;
                            if (bArr2.length > 0) {
                                f7((i16 * 100) / bArr2.length);
                            }
                            this.N8 = 0;
                        } else {
                            if (i15 == 2 && this.N8 == 0) {
                                E6();
                                this.N8 = 1;
                                return;
                            }
                            E6();
                            int i17 = this.V7 + 1;
                            this.V7 = i17;
                            byte[][][] bArr3 = this.U7;
                            if (bArr3.length > 0) {
                                f7((i17 * 100) / bArr3.length);
                            }
                        }
                    }
                }
                if (this.f52072m9 == 2) {
                    Q6(new byte[]{-107, 0});
                    E6();
                    if ((bArr[2] & 255) == 1) {
                        int i18 = this.G8;
                        if (i18 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                            return;
                        } else if (i18 == 2 && this.N8 == 1) {
                            this.N8 = 0;
                            O6(134, 0L);
                        } else {
                            O6(134, 0L);
                        }
                    } else {
                        int i19 = this.G8;
                        if (i19 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                            return;
                        }
                        if (i19 == 2 && this.N8 == 1) {
                            this.N8 = 0;
                            g6();
                            O6(129, 0L);
                            return;
                        }
                        g6();
                        O6(129, 0L);
                    }
                }
            }
            if (bArr.length == 3 && (bArr[0] & 255) == 149 && (bArr[1] & 255) == 135 && (bArr[2] & 255) == 1) {
                E6();
                r4("95,87,01", "95,87,01");
                if (this.f52072m9 == 0) {
                    this.f52072m9 = 1;
                    if (R5()) {
                        O6(159, 2000L);
                    } else {
                        this.A9 = false;
                        this.W7 = 0;
                        this.Z7 = 0;
                        this.L8 = -1;
                        this.N8 = 0;
                        this.O8 = 0;
                        this.J7 = true;
                        this.L7 = -1;
                        this.f52084s9 = -1;
                        this.f52086t9 = 0;
                        this.f52088u9 = 0;
                        this.P8 = 0;
                        this.G8 = -1;
                    }
                    Q6(new byte[]{-107, 1});
                }
                if (this.f52072m9 == 2) {
                    Q6(new byte[]{-107, 0});
                    E6();
                    if ((bArr[2] & 255) == 1) {
                        int i20 = this.G8;
                        if (i20 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                        } else if (i20 == 2 && this.N8 == 1) {
                            this.N8 = 0;
                            O6(134, 0L);
                        } else {
                            O6(134, 0L);
                        }
                    } else {
                        int i21 = this.G8;
                        if (i21 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                            return;
                        }
                        if (i21 == 2 && this.N8 == 1) {
                            this.N8 = 0;
                            g6();
                            O6(129, 0L);
                            return;
                        }
                        g6();
                        O6(129, 0L);
                    }
                }
            } else if (bArr.length == 2 && (bArr[0] & 255) == 149 && (bArr[1] & 255) == 139) {
                E6();
                r4("0x95", "0x95");
                if (this.f52072m9 == 0) {
                    this.f52072m9 = 1;
                    if (R5()) {
                        O6(159, 2000L);
                    } else {
                        this.A9 = false;
                        this.W7 = 0;
                        this.Z7 = 0;
                        this.L8 = -1;
                        this.N8 = 0;
                        this.O8 = 0;
                        this.J7 = true;
                        this.L7 = -1;
                        this.f52084s9 = -1;
                        this.f52086t9 = 0;
                        this.f52088u9 = 0;
                        this.P8 = 0;
                        this.G8 = -1;
                    }
                    Q6(new byte[]{-107, 1});
                }
                if (this.f52072m9 == 2) {
                    Q6(new byte[]{-107, 0});
                    if ((zBooleanValue2 || !zBooleanValue) && ((i14 = this.f52072m9) == 0 || i14 == 2)) {
                        E6();
                        O6(132, 0L);
                    }
                }
            } else if (bArr.length == 2 && (bArr[0] & 255) == 139 && (bArr[1] & 255) == 149) {
                if (zBooleanValue2 || !zBooleanValue) {
                    E6();
                    r4("0x8b 0x95", "0x8b 0x95");
                    int i22 = this.f52072m9;
                    if (i22 == 2) {
                        Q6(new byte[]{-107, 0});
                        return;
                    }
                    if (i22 == 0) {
                        this.f52072m9 = 1;
                        if (R5()) {
                            O6(159, 2000L);
                        } else {
                            this.A9 = false;
                            this.W7 = 0;
                            this.Z7 = 0;
                            this.L8 = -1;
                            this.N8 = 0;
                            this.O8 = 0;
                            this.J7 = true;
                            this.L7 = -1;
                            this.f52084s9 = -1;
                            this.f52086t9 = 0;
                            this.f52088u9 = 0;
                            this.P8 = 0;
                            this.G8 = -1;
                        }
                        Q6(new byte[]{-107, 1});
                    }
                }
            } else if ((bArr[0] & 255) == 150 && bArr.length == 1) {
                E6();
                r4("0x96", "0x96");
                if (this.f52072m9 == 1) {
                    this.f52072m9 = 2;
                    W6("true");
                    O6(142, 0L);
                    wf.d.A(this.K2, "onConnected ");
                    d7(R.string.cf_state_connected);
                    this.N7 = 2;
                    this.Z7 = 0;
                    this.f52073n8 = 0;
                    this.G8 = -1;
                }
            } else if ((bArr[0] & 255) == 149 && bArr.length == 1) {
                E6();
                this.P9 = false;
                r4(this.K2, "onReceive cutoff: ++++++++++++++++");
                this.O7.connectGatt(this, false, null).disconnect();
            } else if ((bArr[0] & 255) == 139 && bArr.length == 1) {
                if ((zBooleanValue2 || !zBooleanValue) && ((i13 = this.f52072m9) == 0 || i13 == 2)) {
                    E6();
                    O6(132, 0L);
                }
            } else if (wf.a.j(f52002ga, bArr)) {
                int i23 = this.G8;
                if (i23 == 2 && this.N8 == 1) {
                    this.N8 = 0;
                    E6();
                    this.W7 = 0;
                    int i24 = this.V7 + 1;
                    this.V7 = i24;
                    f7((i24 * 100) / this.U7.length);
                    if (R5() || (zBooleanValue && !zBooleanValue2)) {
                        O6(132, 0L);
                    }
                } else {
                    if (i23 == 2 && this.N8 == 0) {
                        E6();
                        this.N8 = 1;
                        return;
                    }
                    E6();
                    this.W7 = 0;
                    int i25 = this.V7 + 1;
                    this.V7 = i25;
                    f7((i25 * 100) / this.U7.length);
                    if (R5() || (zBooleanValue && !zBooleanValue2)) {
                        O6(132, 0L);
                    }
                }
            } else if (wf.a.j(f52004ha, bArr)) {
                int i26 = this.G8;
                if (i26 == 2 && this.N8 == 0) {
                    E6();
                    this.N8 = 1;
                    return;
                }
                if (i26 == 2 && this.N8 == 1) {
                    this.N8 = 0;
                    E6();
                    this.W7 = 0;
                    if (R5() || (zBooleanValue && !zBooleanValue2)) {
                        O6(132, 0L);
                    }
                } else {
                    E6();
                    this.W7 = 0;
                    if (R5() || (zBooleanValue && !zBooleanValue2)) {
                        O6(132, 0L);
                    }
                }
            } else if (wf.a.k(bArr, new byte[]{-127, 66, 69, 83, 84})) {
                int i27 = this.G8;
                if (i27 == 2 && this.N8 == 1) {
                    r4("0x81", "dual_in_one_response_ok_time == 0");
                    this.N8 = 0;
                    return;
                }
                if (i27 == 2 && this.N8 == 0) {
                    r4("0x81", "dual_in_one_response_ok_time==1");
                    this.N8 = 1;
                    this.f52053da.removeMessages(3);
                    int i28 = (bArr[5] & 255) | ((bArr[6] & 255) << 8);
                    int i29 = (bArr[7] & 255) | ((bArr[8] & 255) << 8);
                    wf.e.g(this.K2, "softwareVersion " + Integer.toHexString(i28) + "; hardwareVersion " + Integer.toHexString(i29));
                    this.f52048c8 = ((bArr[10] & 255) << 8) | (bArr[9] & 255);
                    wf.g.d(getApplicationContext(), tf.a.F, Integer.valueOf(this.f52048c8));
                    int iIntValue = ((Integer) wf.g.b(this, tf.a.F, 0)).intValue();
                    r4(this.K2, "0x81 mtu 1 " + iIntValue);
                    O6(144, 0L);
                } else {
                    r4("0x81", "ok");
                    this.f52053da.removeMessages(3);
                    int i30 = (bArr[5] & 255) | ((bArr[6] & 255) << 8);
                    int i31 = (bArr[7] & 255) | ((bArr[8] & 255) << 8);
                    wf.e.g(this.K2, "softwareVersion " + Integer.toHexString(i30) + "; hardwareVersion " + Integer.toHexString(i31));
                    this.f52048c8 = ((bArr[10] & 255) << 8) | (bArr[9] & 255);
                    wf.g.d(getApplicationContext(), tf.a.F, Integer.valueOf(this.f52048c8));
                    int iIntValue2 = ((Integer) wf.g.b(this, tf.a.F, 0)).intValue();
                    r4(this.K2, "0x81 mtu 2 " + iIntValue2);
                    O6(144, 0L);
                }
            } else if ((bArr[0] & 255) == 131) {
                if (bArr.length == 4 && (bArr[2] & 255) == 132) {
                    int i32 = this.G8;
                    if (i32 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    }
                    if (i32 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        E6();
                        if ((bArr[3] & 255) == 1) {
                            O6(155, 0L);
                        } else if ((bArr[3] & 255) == 0 && ((i12 = this.f52072m9) == 0 || i12 == 2)) {
                            h6();
                            O6(129, 0L);
                        }
                        this.W7 = 0;
                    } else if (i32 == 0 || i32 == 1) {
                        O6(155, 0L);
                        this.W7 = 0;
                    } else if (i32 == 4) {
                        i6();
                        O6(129, 0L);
                        this.W7 = 0;
                    } else {
                        E6();
                        if ((bArr[3] & 255) == 1) {
                            O6(155, 0L);
                        } else if ((bArr[3] & 255) == 0 && ((i11 = this.f52072m9) == 0 || i11 == 2)) {
                            h6();
                            O6(129, 0L);
                        }
                        this.W7 = 0;
                    }
                } else {
                    if ((bArr[1] & 255) == 1 && bArr.length == 2) {
                        int i33 = this.G8;
                        if (i33 == 2 && this.N8 == 1) {
                            E6();
                            int i34 = this.V7 + 1;
                            this.V7 = i34;
                            byte[][][] bArr4 = this.U7;
                            if (bArr4.length > 0) {
                                f7((i34 * 100) / bArr4.length);
                            }
                            this.N8 = 0;
                        } else {
                            if (i33 == 2 && this.N8 == 0) {
                                E6();
                                this.N8 = 1;
                                return;
                            }
                            E6();
                            int i35 = this.V7 + 1;
                            this.V7 = i35;
                            byte[][][] bArr5 = this.U7;
                            if (bArr5 != null && bArr5.length > 0) {
                                f7((i35 * 100) / bArr5.length);
                            }
                        }
                    } else if (wf.a.k(bArr, new byte[]{-125, 1, -125, 1}) && bArr.length == 4) {
                        if (this.G8 == 2) {
                            E6();
                            int i36 = this.V7 + 1;
                            this.V7 = i36;
                            byte[][][] bArr6 = this.U7;
                            if (bArr6.length > 0) {
                                f7((i36 * 100) / bArr6.length);
                            }
                            this.N8 = 0;
                        } else {
                            E6();
                            int i37 = this.V7 + 1;
                            this.V7 = i37;
                            byte[][][] bArr7 = this.U7;
                            if (bArr7.length > 0) {
                                f7((i37 * 100) / bArr7.length);
                            }
                        }
                    } else if ((bArr[1] & 255) == 0) {
                        E6();
                        int i38 = this.G8;
                        if (i38 == 2 && this.N8 == 1) {
                            int i39 = this.V7;
                            this.V7 = i39;
                            f7((i39 * 100) / this.U7.length);
                            this.N8 = 0;
                        } else {
                            if (i38 == 2 && this.N8 == 0) {
                                this.N8 = 1;
                                return;
                            }
                            int i40 = this.V7;
                            this.V7 = i40;
                            byte[][][] bArr8 = this.U7;
                            if (bArr8.length > 0) {
                                f7((i40 * 100) / bArr8.length);
                            }
                        }
                    }
                    this.W7 = 0;
                    O6(132, 0L);
                }
            } else if ((bArr[0] & 255) == 132) {
                r4(this.K2, "(data[0] & 0xFF) == 0x84 " + wf.a.o(bArr));
                E6();
                r4("84,daulApply ", this.G8 + "");
                if ((bArr[1] & 255) == 1) {
                    int i41 = this.G8;
                    if (i41 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        r4(this.K2, "(daulApply == APPLY_BOTH_EARBUD_IN_ONE && dual_in_one_response_ok_time == 0)");
                        return;
                    }
                    if (i41 == 2 && this.N8 == 1) {
                        r4(this.K2, " (daulApply == APPLY_BOTH_EARBUD_IN_ONE && dual_in_one_response_ok_time == 1) ");
                        this.N8 = 0;
                        O6(155, 0L);
                    } else {
                        int i42 = this.L8;
                        if (i42 == 0 && i41 == 3) {
                            r4(this.K2, "(daul_step == 0 && daulApply == APPLY_BOTH_EARBUD_IN_TWO) ");
                            this.L8 = 1;
                            j6();
                            O6(153, 0L);
                            this.T8 = 1;
                            return;
                        }
                        if (i42 == 1 && i41 == 3) {
                            r4(this.K2, " (daul_step == 1 && daulApply == APPLY_BOTH_EARBUD_IN_TWO)  ");
                            this.T8 = 2;
                            this.L8 = 2;
                            j6();
                            O6(154, 0L);
                        } else if (i41 == 0 || i41 == 1) {
                            k6();
                            O6(155, 0L);
                        } else if (i41 == -1) {
                            r4(this.K2, "dataSendAndVerifyOver == true");
                            this.S9 = true;
                            O6(155, 0L);
                        } else if (i41 == 4) {
                            i6();
                            O6(129, 0L);
                            O6(21, 0L);
                        } else {
                            r4(this.K2, "else--------dataSendAndVerifyOver--error");
                            i6();
                            O6(129, 0L);
                            O6(21, 0L);
                        }
                    }
                } else if ((bArr[1] & 255) == 0) {
                    int i43 = this.G8;
                    if (i43 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    }
                    if (i43 == 2 && this.N8 == 1) {
                        int i44 = this.f52072m9;
                        if (i44 == 0 || i44 == 2) {
                            h6();
                            O6(129, 0L);
                            this.N8 = 0;
                            O6(21, 0L);
                        }
                    } else {
                        int i45 = this.f52072m9;
                        if (i45 == 0 || i45 == 2) {
                            h6();
                            O6(129, 0L);
                            O6(21, 0L);
                        }
                    }
                } else if ((bArr[1] & 255) == 2) {
                    int i46 = this.G8;
                    if (i46 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    } else if (i46 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        e7(getString(R.string.received_size_error));
                        O6(129, 0L);
                    } else {
                        e7(getString(R.string.received_size_error));
                        O6(129, 0L);
                    }
                } else if ((bArr[1] & 255) == 3) {
                    r4("84,03", "fanxiaoli");
                    int i47 = this.G8;
                    if (i47 == 2 && this.N8 == 0) {
                        r4("84,03", " if (daulApply == APPLY_BOTH_EARBUD_IN_ONE && dual_in_one_response_ok_time == 0) ");
                        this.N8 = 1;
                        return;
                    } else if (i47 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        e7(getString(R.string.write_flash_offset_error));
                        O6(129, 0L);
                        r4("84,03", " daulApply == APPLY_BOTH_EARBUD_IN_ONE && dual_in_one_response_ok_time == 1");
                    } else {
                        e7(getString(R.string.write_flash_offset_error));
                        O6(129, 0L);
                    }
                } else if ((bArr[1] & 255) == 4) {
                    r4("84,04", "fanxiaoli");
                    int i48 = this.G8;
                    if (i48 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    }
                    if (i48 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        int i49 = this.f52085t8 + 1;
                        this.f52085t8 = i49;
                        if (i49 < 3) {
                            e7(this.f52085t8 + "times resend");
                            O6(134, 0L);
                        } else {
                            e7("Resend fail");
                            this.f52085t8 = 0;
                            byte[] bArr9 = new byte[32];
                            int i50 = 0;
                            for (int i51 = 32; i50 < i51; i51 = 32) {
                                bArr9[i50] = 0;
                                i50++;
                            }
                            wf.g.d(getApplicationContext(), tf.a.A, wf.a.o(bArr9));
                            e7(getString(R.string.segment_verify_error));
                            O6(129, 0L);
                        }
                    } else {
                        int i52 = this.f52085t8 + 1;
                        this.f52085t8 = i52;
                        if (i52 < 3) {
                            e7(this.f52085t8 + "次重传");
                            O6(134, 0L);
                        } else {
                            e7("重传失败");
                            this.f52085t8 = 0;
                            byte[] bArr10 = new byte[32];
                            int i53 = 0;
                            for (int i54 = 32; i53 < i54; i54 = 32) {
                                bArr10[i53] = 0;
                                i53++;
                            }
                            wf.g.d(getApplicationContext(), tf.a.A, wf.a.o(bArr10));
                            e7(getString(R.string.segment_verify_error));
                            O6(129, 0L);
                        }
                    }
                } else if ((bArr[1] & 255) == 5) {
                    r4("84,05", "fanxiaoli");
                    int i55 = this.G8;
                    if (i55 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        e7(getString(R.string.breakpoint_error));
                        O6(129, 0L);
                    } else if (i55 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    } else {
                        e7(getString(R.string.breakpoint_error));
                        O6(129, 0L);
                    }
                } else if ((bArr[1] & 255) == 6) {
                    r4("84,06", "image size error");
                    int i56 = this.G8;
                    if (i56 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        e7(getString(R.string.image_size_error));
                        O6(129, 0L);
                    } else if (i56 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    } else {
                        e7(getString(R.string.breakpoint_error));
                        O6(129, 0L);
                    }
                }
                this.W7 = 0;
            } else if ((bArr[0] & 255) == 141) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(wf.a.o(bArr));
                sb5.append("");
                E6();
                this.f52053da.removeMessages(17);
                byte[] bArrG = wf.a.g(bArr, 1, 4);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(wf.a.o(bArrG));
                sb6.append("");
                if (wf.a.j(bArrG, new byte[]{-1, -1, -1, -1})) {
                    int i57 = this.G8;
                    if (i57 == 2 && this.f52084s9 == 0) {
                        this.f52084s9 = 1;
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO);
                        wf.g.d(getApplicationContext(), tf.a.J, strO);
                        O6(153, 0L);
                    } else if (i57 == 2 && this.f52084s9 == 1) {
                        this.f52084s9 = 2;
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO2 = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO2);
                        wf.g.d(getApplicationContext(), tf.a.K, strO2);
                        O6(153, 0L);
                    } else {
                        this.f52081r8 = 0;
                        this.f52083s8 = false;
                        O6(133, 0L);
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO3 = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO3);
                        wf.g.d(getApplicationContext(), tf.a.A, strO3);
                    }
                } else if (wf.a.j(bArrG, new byte[]{0, 0, 0, 0})) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(this.G8);
                    sb7.append("");
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(this.N8);
                    sb8.append("");
                    int i58 = this.G8;
                    if (i58 == 2 && this.f52084s9 == 0) {
                        this.f52084s9 = 1;
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO4 = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO4);
                        wf.g.d(getApplicationContext(), tf.a.J, strO4);
                        O6(153, 0L);
                    } else if (i58 == 2 && this.f52084s9 == 1) {
                        this.f52084s9 = 2;
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO5 = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO5);
                        wf.g.d(getApplicationContext(), tf.a.K, strO5);
                        O6(153, 0L);
                    } else {
                        if (this.J7) {
                            this.G8 = this.M7;
                        }
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        O6(133, 0L);
                        wf.d.A(this.K2, "onConnected ");
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        String strO6 = wf.a.o(wf.a.g(bArr, 5, 32));
                        r4(this.K2, "random_code_str  fanxiaoli= " + strO6);
                        wf.g.d(getApplicationContext(), tf.a.A, strO6);
                    }
                } else {
                    int i59 = this.G8;
                    if (i59 == 2 && this.f52084s9 == 1) {
                        this.f52086t9 = wf.a.b(bArrG);
                        this.f52084s9 = 2;
                        this.f52081r8 = 0;
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        O6(153, 0L);
                    } else if (i59 == 2 && this.f52084s9 == 0) {
                        this.f52088u9 = wf.a.b(bArrG);
                        this.f52084s9 = 1;
                        this.f52083s8 = false;
                        this.f52081r8 = 0;
                        this.N7 = 2;
                        this.f52073n8 = 0;
                        O6(153, 0L);
                    } else {
                        int i60 = this.M7;
                        if ((i60 == 1 || i60 == 0 || i60 == 3) && G6()) {
                            this.G8 = this.M7;
                            int iB = wf.a.b(bArrG);
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(iB);
                            sb9.append("");
                            if (iB != 0) {
                                this.f52083s8 = true;
                                this.V7 = iB / this.f52098z9;
                                e7(getString(R.string.resume_start));
                                this.f52048c8 = ((Integer) wf.g.b(getApplicationContext(), tf.a.F, 0)).intValue();
                                r4(this.K2, "breakpoint check success 2 mtu" + this.f52048c8);
                                O6(144, 0L);
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("resume mOtaPacketCount");
                                sb10.append(this.V7);
                                StringBuilder sb11 = new StringBuilder();
                                sb11.append("resume mOtaPacketCount");
                                sb11.append(this.V7);
                            }
                        } else {
                            int iB2 = wf.a.b(bArrG);
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append(iB2);
                            sb12.append("");
                            if (iB2 != 0) {
                                this.f52083s8 = true;
                                this.V7 = iB2 / this.f52098z9;
                                e7(getString(R.string.resume_start));
                                this.f52048c8 = ((Integer) wf.g.b(getApplicationContext(), tf.a.F, 0)).intValue();
                                r4(this.K2, "breakpoint check success 2 mtu" + this.f52048c8);
                                O6(144, 0L);
                                StringBuilder sb13 = new StringBuilder();
                                sb13.append("resume mOtaPacketCount");
                                sb13.append(this.V7);
                                this.f52083s8 = false;
                                StringBuilder sb14 = new StringBuilder();
                                sb14.append("resume mOtaPacketCount");
                                sb14.append(this.V7);
                            }
                        }
                    }
                }
            } else if ((bArr[0] & 255) == 135) {
                E6();
                if ((bArr[1] & 255) == 1) {
                    int i61 = this.G8;
                    if (i61 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                    } else if (i61 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        O6(134, 0L);
                    } else {
                        O6(134, 0L);
                    }
                } else {
                    int i62 = this.G8;
                    if (i62 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    }
                    if (i62 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        g6();
                        O6(129, 0L);
                        return;
                    }
                    g6();
                    O6(129, 0L);
                }
            } else if (wf.a.k(bArr, new byte[]{-113, 66, 69, 83, 84})) {
                this.f52053da.removeMessages(16);
                this.f52075o8 = 0;
                this.V8 = 3;
                if ((bArr[5] & 255) == 0) {
                    r4("version_str", "dataSendAndVerifyOver--" + this.S9 + ",connectToRestart--" + this.T9);
                    if (this.S9 && this.T9) {
                        r4(this.K2, "dataSendAndVerifyOver == true && connectToRestart == true");
                        I5();
                        return;
                    }
                    if (this.Q9) {
                        r4(this.K2, "onReceive: 8f+++++connectImmediately = true");
                        I6();
                        return;
                    }
                    String strC = wf.a.c(wf.a.g(bArr, 6, 4));
                    this.I7 = 0;
                    if (strC == null) {
                        i7(getString(R.string.version_number_error));
                        r4("0x8F error", " updateVersion(getString R.string.version_number_error)");
                        return;
                    }
                    r4("version_str", strC);
                    i7("stereo device version ：" + strC);
                    r4("version_str", "dataSendAndVerifyOver--" + this.S9 + ",connectToRestart--" + this.T9);
                    if (this.S9 && !this.T9) {
                        r4("version_str", "connectToRestart == false");
                        this.S9 = false;
                        this.T9 = true;
                        this.R9 = false;
                        return;
                    }
                    this.G8 = -1;
                    wf.g.d(this, tf.a.H, -1);
                    r4("8F daulApply", this.G8 + "");
                    wf.g.d(getApplicationContext(), tf.a.H, -1);
                    this.I8 = (byte) 0;
                    this.M8 = 1;
                    r4("0x8f ROLE_SWITCH_FLAG", this.f52072m9 + "");
                    if (this.f52072m9 == 2 && !R5()) {
                        r4("ROLE_SWITCH_FLAG", "roleSwitchOtaStart");
                        I6();
                    } else if (this.f52072m9 == 1 && R5()) {
                        r4("ROLE_SWITCH_FLAG", "roleSwitchOtaStart");
                        I6();
                    }
                    q6();
                } else if ((bArr[5] & 255) == 1) {
                    r4("received 0x8f", " FWS device, current connected device is left earbud");
                    String str = ("current connected device is left earbud\nleft earbud version :" + wf.a.c(wf.a.g(bArr, 6, 4)) + "\n") + "right earbud version:" + wf.a.c(wf.a.g(bArr, 10, 4));
                    this.I7 = 1;
                    i7(str);
                    this.G8 = 5;
                    this.M8 = 2;
                } else if ((bArr[5] & 255) == 2) {
                    r4("received 0x8f", "FWS device, current connected device is right earbud");
                    String str2 = ("current connected device is right earbud\nleft earbud version :" + wf.a.c(wf.a.g(bArr, 6, 4)) + "\n") + "right earbud version:" + wf.a.c(wf.a.g(bArr, 10, 4));
                    this.I7 = 2;
                    i7(str2);
                    this.G8 = 5;
                    this.M8 = 2;
                }
            } else if ((bArr[0] & 255) == 137) {
                if (bArr.length == 2 && (bArr[1] & 255) == 1) {
                    r4("0x89,0x01", "2");
                    int i63 = this.f52068k9;
                    if (i63 == 1) {
                        c7(1);
                        O6(Ya, 0L);
                        this.f52058f9 = false;
                    } else if (i63 == 10) {
                        c7(10);
                        O6(Ya, 0L);
                        this.f52058f9 = false;
                    }
                } else if (bArr.length == 4 && (bArr[1] & 255) == 1 && (bArr[2] & 255) == 137 && (bArr[3] & 255) == 1) {
                    this.f52058f9 = true;
                }
            } else if ((bArr[0] & 255) == 138) {
                wf.a.o(bArr);
                int i64 = this.f52068k9;
                if (i64 == 1) {
                    b7(bArr, wf.a.o(bArr));
                } else if (i64 == 2) {
                    D5(bArr);
                } else if (i64 == 0) {
                    z6(bArr);
                } else if (i64 == 10) {
                    Z6(bArr, wf.a.o(bArr));
                }
            } else if ((bArr[0] & 255) == 145) {
                E6();
                if ((bArr[1] & 255) == 1) {
                    int i65 = this.G8;
                    if (i65 == 2 && this.f52084s9 == 0) {
                        O6(140, 0L);
                    } else if (i65 == 2 && this.f52084s9 == 1) {
                        O6(140, 0L);
                    } else if (i65 == 2 && this.f52084s9 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                        this.f52084s9 = 0;
                        int i66 = this.f52088u9;
                        if (i66 == this.f52086t9 && i66 != 0 && G6()) {
                            this.f52083s8 = true;
                            this.V7 = this.f52088u9 / this.f52098z9;
                            e7(getString(R.string.resume_start));
                            this.f52048c8 = ((Integer) wf.g.b(getApplicationContext(), tf.a.F, 0)).intValue();
                            r4(this.K2, "breakpoint check success 2 mtu" + this.f52048c8);
                            O6(144, 0L);
                            StringBuilder sb15 = new StringBuilder();
                            sb15.append("resume mOtaPacketCount");
                            sb15.append(this.V7);
                            StringBuilder sb16 = new StringBuilder();
                            sb16.append("resume mOtaPacketCount");
                            sb16.append(this.V7);
                        } else {
                            this.f52083s8 = false;
                            this.f52081r8 = 0;
                            O6(133, 0L);
                            this.N7 = 2;
                            this.f52073n8 = 0;
                        }
                    } else {
                        if (i65 == 2 && this.f52084s9 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                            return;
                        }
                        if (i65 == 2 && this.N8 == 0) {
                            this.N8 = 1;
                            return;
                        }
                        if (i65 == 2 && this.N8 == 1) {
                            this.N8 = 0;
                            O6(140, 0L);
                        } else if (i65 == 3 && this.T8 == 2 && this.P8 == 1) {
                            r4(this.K2, "(daulApply == APPLY_BOTH_EARBUD_IN_TWO) && (ota_response_ok == 2) && (dual_apply_change_response == 1)");
                            this.P8 = 0;
                            this.T8 = 0;
                            O6(155, 0L);
                        } else {
                            if (i65 == 3 && this.T8 == 2 && this.P8 == 0) {
                                r4(this.K2, "(daulApply == APPLY_BOTH_EARBUD_IN_TWO) && (ota_response_ok == 2) && (dual_apply_change_response_check == 0)");
                                this.P8 = 1;
                                return;
                            }
                            O6(140, 0L);
                        }
                    }
                } else if ((bArr[1] & 255) == 0) {
                    int i67 = this.G8;
                    if (i67 == 2 && this.N8 == 0) {
                        this.N8 = 1;
                        return;
                    }
                    if (i67 == 2 && this.N8 == 1) {
                        this.N8 = 0;
                    } else if (i67 == 3 && (i10 = this.P8) == 2 && i10 == 1) {
                        this.P8 = 0;
                        this.T8 = 0;
                    } else if (i67 == 3 && this.T8 == 2 && this.P8 == 0) {
                        r4("received 0x91", " dual_apply_change_response_check == 0");
                        this.P8 = 1;
                    }
                }
            } else if (wf.a.k(bArr, new byte[]{-109, 1, -109, 1}) && bArr.length == 4 && this.G8 == 3) {
                this.U8 = 0;
                i6();
                O6(129, 0L);
                O6(21, 0L);
            } else if (wf.a.k(bArr, new byte[]{-109, 0, -109, 0}) && bArr.length == 4 && this.G8 == 3) {
                this.U8 = 0;
                g6();
                O6(129, 0L);
            } else if ((bArr[0] & 255) == 147 && bArr.length == 2) {
                E6();
                if ((bArr[1] & 255) == 1) {
                    r4("MSG_UPDATE_INFO", "Version Validation OK daulApply:" + this.G8);
                    e7(getString(R.string.ota_version_verification_ok));
                    int i68 = this.G8;
                    if ((i68 == 3 || i68 == 2) && this.U8 == 1) {
                        this.U8 = 0;
                        i6();
                        O6(129, 3000L);
                        O6(21, 0L);
                    } else if (i68 == 3 && this.U8 == 0) {
                        this.U8 = 1;
                    } else if (i68 == -1) {
                        i6();
                        O6(129, 3000L);
                        O6(21, 0L);
                    } else {
                        i6();
                        O6(129, 3000L);
                        O6(21, 0L);
                    }
                } else if ((bArr[1] & 255) == 0) {
                    int i69 = this.G8;
                    if ((i69 == 2 || i69 == 3) && this.U8 == 0) {
                        this.U8 = 1;
                        return;
                    }
                    if ((i69 == 2 || i69 == 3) && this.U8 == 1) {
                        this.U8 = 0;
                        g6();
                        O6(129, 0L);
                    } else if (i69 == -1) {
                        g6();
                        O6(129, 0L);
                    } else {
                        g6();
                        O6(129, 0L);
                    }
                }
            } else if ((bArr[0] & 255) == 156) {
                this.N9 = true;
                this.Q9 = true;
                String strReplace = wf.a.o(bArr).replace(ag.c.f654g, "");
                String strSubstring = strReplace.substring(strReplace.length() - 4);
                StringBuilder sb17 = new StringBuilder();
                sb17.append("onReceive:dataStr +++++++");
                sb17.append(strSubstring);
                r4(this.K2, "onReceive:dataStr  irk-------" + strSubstring);
                this.O9 = strSubstring;
                B6();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0246 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void T5() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.T5():void");
    }

    public final void T6() {
        String[] strArr = {getString(R.string.left_earbud_only), getString(R.string.right_earbud_only), getString(R.string.both_earbuds_in_one_bin), getString(R.string.both_earbuds_in_two_bins)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.daul_earbuds_ota_apply));
        builder.setSingleChoiceItems(strArr, -1, new d());
        builder.setPositiveButton("确定", new e());
        builder.show();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x021f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:87:0x021f */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void U5() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.U5():void");
    }

    public void U6() {
        r4(this.K2, "startOta daulApply " + this.G8);
        r4(this.K2, "startOta " + this.X7);
        if (this.G8 == 5) {
            this.G8 = -1;
        }
        if (this.G8 == 3) {
            this.f52063i8 = System.currentTimeMillis();
            e7("begin time:" + C5());
            e7(getString(R.string.ota_file_on_going_is) + this.R8);
        } else {
            this.f52063i8 = System.currentTimeMillis();
            e7(y5() + "\nbegin time:" + C5());
            d7(R.string.ota_ing);
        }
        this.N7 = 5;
        O6(132, 0L);
        l6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022b A[Catch: IOException -> 0x020b, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x020b, blocks: (B:89:0x0207, B:99:0x021d, B:105:0x022b, B:63:0x01d6), top: B:121:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0207 A[Catch: IOException -> 0x020b, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x020b, blocks: (B:89:0x0207, B:99:0x021d, B:105:0x022b, B:63:0x01d6), top: B:121:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021d A[Catch: IOException -> 0x020b, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x020b, blocks: (B:89:0x0207, B:99:0x021d, B:105:0x022b, B:63:0x01d6), top: B:121:0x000c }] */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [byte[][][]] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v62 */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r3v66 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void V5() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.V5():void");
    }

    public void V6() {
        int i10;
        r4(this.K2, "startOtaConfig daulApply " + this.G8);
        if (this.X8.equals("SppOtaActivity") && this.G8 == 5 && (i10 = this.H8) != 100) {
            this.G8 = i10;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startOtaConfig 检测后 +++ ");
        sb2.append(this.G8);
        r4(this.K2, "startOtaConfig 检测后 + " + this.G8);
        r4(this.K2, "startOtaConfig " + this.N7);
        if (this.N7 == 5) {
            return;
        }
        this.N7 = 7;
        O6(146, 0L);
    }

    public abstract String W5();

    public void W6(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(7);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public abstract String X5();

    public void X6(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(8);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01e9: MOVE (r1 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]), block:B:88:0x01e9 */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y5() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.Y5():void");
    }

    public void Y6(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(9);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void Z5() {
        r4(this.K2, "onConnectFailed");
        wf.d.A(this.K2, "onConnectFailed " + ((System.currentTimeMillis() - this.f52063i8) / 1000));
        d7(R.string.connect_failed);
        this.N7 = 4;
    }

    public void Z6(byte[] bArr, String str) {
        if (this.f52060g9 == null) {
            return;
        }
        try {
            if (this.K9 >= this.L9) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < bArr.length; i11++) {
                this.I9[this.K9 + i11] = bArr[i11];
            }
            this.K9 += bArr.length;
            r4(this.K2, this.f52043a9 + "");
            if (this.K9 != this.L9) {
                return;
            }
            int i12 = 0;
            while (true) {
                byte[] bArr2 = this.I9;
                if (i10 >= bArr2.length) {
                    r4(this.K2, "crash_content_byte = " + wf.a.o(this.J9));
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f52060g9, true);
                    fileOutputStream.write(this.J9);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Message messageObtainMessage = this.f52053da.obtainMessage(19);
                    messageObtainMessage.obj = "get flash content info ready";
                    this.f52053da.sendMessage(messageObtainMessage);
                    O6(129, 0L);
                    return;
                }
                if (i10 % 129 > 0) {
                    this.J9[i12] = bArr2[i10];
                    i12++;
                }
                i10++;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void a6() {
        r4(this.K2, "onConnected");
        ((Boolean) wf.g.b(getApplicationContext(), tf.a.G, Boolean.TRUE)).booleanValue();
        String str = this.X8;
        if (str == "DumpLogActivity") {
            if (this.f52068k9 == 2) {
                O6(156, 0L);
                wf.d.A(this.K2, "onConnected ");
                d7(R.string.cf_state_connected);
                this.N7 = 2;
                this.f52073n8 = 0;
                return;
            }
            return;
        }
        if (str != "CrashLogActivity") {
            W6("true");
            O6(142, 0L);
            wf.d.A(this.K2, "onConnected ");
            d7(R.string.cf_state_connected);
            this.N7 = 2;
            this.f52073n8 = 0;
            return;
        }
        if (this.f52068k9 == 10) {
            O6(158, 0L);
            wf.d.A(this.K2, "onConnected ");
            d7(R.string.cf_state_connected);
            this.N7 = 2;
            this.f52073n8 = 0;
        }
    }

    public void a7(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(6);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void b6() {
        r4(this.K2, "onConnecting");
        wf.d.A(this.K2, "onConnecting ");
        d7(R.string.connecting_device);
        this.N7 = 1;
    }

    public void b7(byte[] bArr, String str) {
        if (this.f52060g9 == null) {
            return;
        }
        try {
            if (this.f52043a9 >= this.f52046b9) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < bArr.length; i11++) {
                this.f52064i9[this.f52043a9 + i11] = bArr[i11];
            }
            this.f52043a9 += bArr.length;
            r4(this.K2, this.f52043a9 + "");
            if (this.f52043a9 != this.f52046b9) {
                return;
            }
            int i12 = 0;
            while (true) {
                byte[] bArr2 = this.f52064i9;
                if (i10 >= bArr2.length) {
                    r4(this.K2, "flash_content_byte = " + wf.a.o(this.f52066j9));
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f52060g9, true);
                    fileOutputStream.write(this.f52066j9);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    Message messageObtainMessage = this.f52053da.obtainMessage(19);
                    messageObtainMessage.obj = "get flash content info ready";
                    this.f52053da.sendMessage(messageObtainMessage);
                    O6(129, 0L);
                    return;
                }
                if (i10 % 129 > 0) {
                    this.f52066j9[i12] = bArr2[i10];
                    i12++;
                }
                i10++;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void c6() {
        r4(this.K2, "onLoadFileFailed");
        d7(R.string.load_file_failed);
    }

    public void c7(int i10) {
        if (i10 == 1) {
            Message messageObtainMessage = this.f52053da.obtainMessage(18);
            messageObtainMessage.obj = "数据写入中";
            this.f52053da.sendMessage(messageObtainMessage);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("flash_content_str");
            sb2.append(this.f52055e9);
            return;
        }
        if (i10 == 10) {
            Message messageObtainMessage2 = this.f52053da.obtainMessage(18);
            messageObtainMessage2.obj = "数据写入中";
            this.f52053da.sendMessage(messageObtainMessage2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("flash_content_str");
            sb3.append(this.f52055e9);
        }
    }

    public void d6() {
        int i10;
        r4(this.K2, "onLoadFileSuccessfully");
        if (this.X8.equals("SppOtaActivity") && this.G8 == 5 && (i10 = this.H8) != 100) {
            this.G8 = i10;
        }
        r4(this.K2, "onLoadFileSuccessfully 检测后 + " + this.G8);
        d7(R.string.load_file_successfully);
        O6(131, 0L);
    }

    public void d7(int i10) {
        e7(getString(i10));
    }

    public void e6() {
        r4(this.K2, "onLoadOtaConfigFailed");
        d7(R.string.load_ota_config_failed);
    }

    public void e7(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(0);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void f6() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onLoadOtaConfigSuccessfully: +++++++++");
        sb2.append(this.G8);
        r4(this.K2, "onLoadOtaConfigSuccessfully daulApply" + this.G8);
        d7(R.string.load_ota_config_successfully);
        O6(145, 0L);
    }

    public void f7(int i10) {
        Message messageObtainMessage = this.f52053da.obtainMessage(1);
        messageObtainMessage.obj = Integer.valueOf(i10);
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void g6() {
        d7(R.string.ota_config_failed);
        this.Y7 = null;
        this.Z7 = 0;
        this.N7 = 0;
        this.M9 = 0;
    }

    public void g7(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(20);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void h6() {
        String string;
        runOnUiThread(new o());
        if (this.f52072m9 == 0) {
            this.f52077p8++;
            this.f52079q8++;
            h7("Result：Total count = " + this.f52077p8 + "  Failure count = " + this.f52079q8);
            int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f52063i8) / 1000);
            String string2 = "Disconnected";
            if (this.f52067k8 == 0) {
                string = "Disconnected";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed time-cost ");
                sb2.append(iCurrentTimeMillis);
                sb2.append(" s Retransmission count ");
                sb2.append(this.f52065j8);
                sb2.append(" Speed :");
                long j10 = this.f52067k8;
                sb2.append(j10 / (iCurrentTimeMillis == 0 ? j10 : iCurrentTimeMillis));
                sb2.append(" B/s");
                string = sb2.toString();
            }
            wf.d.A(this.K2, string);
            if (this.f52067k8 != 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed time-cost ");
                sb3.append(iCurrentTimeMillis);
                sb3.append(" s Speed :");
                long j11 = this.f52067k8;
                sb3.append(j11 / (iCurrentTimeMillis == 0 ? j11 : iCurrentTimeMillis));
                sb3.append(" B/s");
                string2 = sb3.toString();
            }
            e7(string2);
        }
        this.H8 = 100;
        this.f52044aa = 0;
        this.Q9 = false;
        this.U9 = 0;
        this.S9 = false;
        this.T9 = true;
        this.R9 = false;
        this.N9 = false;
        this.O9 = "";
        this.f52073n8 = 0;
        this.V7 = 0;
        this.f52083s8 = false;
        this.W7 = 0;
        this.Z7 = 0;
        this.N7 = 6;
        this.U7 = null;
        wf.g.d(this, tf.a.I, Integer.valueOf(this.L8));
        wf.g.d(this, tf.a.H, Integer.valueOf(this.G8));
        this.L8 = -1;
        this.N8 = 0;
        this.O8 = 0;
        this.f52084s9 = -1;
        this.f52086t9 = 0;
        this.f52088u9 = 0;
        this.P8 = 0;
        this.M9 = 0;
    }

    public void h7(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(4);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    public void i6() {
        runOnUiThread(new n());
        r4(this.K2, "onOtaOver");
        r4("OtaActivity", "onOtaOver");
        this.f52077p8++;
        String str = "Result：OTA SUCCESSFULL !!! Total count = " + this.f52077p8 + "  Failure count = " + this.f52079q8;
        h7(str);
        wf.d.A(this.K2, "onOtaOver System.currentTimeMillis :" + System.currentTimeMillis());
        r4("OtaActivity", str);
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f52063i8) / 1000);
        r4("onOtaOver updateTime : ", iCurrentTimeMillis + "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Successful time-cost ");
        sb2.append(iCurrentTimeMillis);
        sb2.append(" s Retransmission count ");
        sb2.append(this.f52065j8);
        sb2.append(" Speed :");
        long j10 = this.f52067k8;
        sb2.append(j10 / (iCurrentTimeMillis == 0 ? j10 : iCurrentTimeMillis));
        sb2.append(" B/s");
        wf.d.A(this.K2, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Successful time-cost ");
        sb3.append(iCurrentTimeMillis);
        sb3.append(" s Speed :");
        long j11 = this.f52067k8;
        sb3.append(j11 / (iCurrentTimeMillis == 0 ? j11 : iCurrentTimeMillis));
        sb3.append(" B/s");
        e7(sb3.toString());
        e7("otaImgSize:" + this.f52067k8);
        String str2 = "end time :" + C5();
        e7(str2);
        r4("OtaActivity", str2);
        f7(100);
        this.H8 = 100;
        this.Q9 = false;
        this.U9 = 0;
        this.N9 = false;
        this.V7 = 0;
        this.f52083s8 = false;
        this.W7 = 0;
        this.Z7 = 0;
        this.N7 = 0;
        this.L8 = -1;
        this.N8 = 0;
        this.O8 = 0;
        wf.g.d(this, tf.a.H, 5);
        this.J7 = false;
        this.L7 = -1;
        this.f52084s9 = -1;
        this.f52086t9 = 0;
        this.f52088u9 = 0;
        wf.g.d(this, tf.a.N, 0L);
        this.P8 = 0;
        this.f52072m9 = 0;
        this.M9 = 0;
        this.S9 = false;
        this.R9 = false;
        this.T9 = true;
    }

    public void i7(String str) {
        Message messageObtainMessage = this.f52053da.obtainMessage(5);
        messageObtainMessage.obj = str;
        this.f52053da.sendMessage(messageObtainMessage);
    }

    @Override // com.iir_eq.ui.fragment.OtaConfigFragment.h
    public void j2() {
        runOnUiThread(new b());
    }

    @Override // uf.a
    public void j4() {
        r4(this.K2, "exit");
        if (S5()) {
            this.f52077p8 = 0;
            this.f52079q8 = 0;
            this.N8 = 0;
            this.G8 = 5;
            this.f52053da.removeMessages(3);
            this.P7 = true;
            this.L8 = -1;
            this.N8 = 0;
            this.O8 = 0;
            this.I7 = 0;
            this.I8 = (byte) 0;
            this.W8.setText("--");
            this.f52086t9 = 0;
            this.f52088u9 = 0;
            finish();
            s4();
            this.A9 = false;
            this.P8 = 0;
            this.M9 = 0;
        } else {
            k4(R.string.ota_exit_tips, new m());
        }
        BluetoothLeScanner bluetoothLeScanner = this.W9;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f52050ca);
            this.W9 = null;
        }
    }

    public void j6() {
        r4(this.K2, "onOtaOverDaulOneStep");
        this.f52077p8++;
        h7("Result：Total count = " + this.f52077p8 + "  Failure count = " + this.f52079q8);
        f7(100);
        this.V7 = 0;
        this.W7 = 0;
        this.Z7 = 0;
        this.U7 = null;
        this.N7 = 0;
    }

    public void k6() {
        h7("Result：Total count = " + this.f52077p8 + "  Failure count = " + this.f52079q8);
        f7(100);
        this.V7 = 0;
        this.W7 = 0;
        this.Z7 = 0;
        this.f52083s8 = false;
        this.U7 = null;
        this.N7 = 0;
    }

    public abstract void l6();

    public void m6(int i10, Intent intent) {
        if (i10 == -1) {
            this.O7 = (BluetoothDevice) intent.getParcelableExtra(uf.d.I7);
            r4("MSG_UPDATE_INFO", "连接 " + this.O7.getName() + ee.a.f26978c + this.O7.getAddress() + ee.a.f26979d);
            BluetoothDevice bluetoothDevice = this.O7;
            if (bluetoothDevice != null) {
                K6(bluetoothDevice.getName());
                J6(this.O7.getAddress());
                this.f52087u8.setText(this.O7.getAddress());
                this.f52089v8.setText(this.O7.getName());
            }
        }
    }

    public final void n4(String str, String str2) {
        byte[] bArr = new byte[10];
        byte[] bArrH = wf.a.h(str2);
        r4(this.K2, "GetBuildInfoAddress flash_length =" + wf.a.o(bArrH));
        for (int i10 = 0; i10 < bArrH.length; i10++) {
            bArr[i10 + 6] = bArrH[i10];
        }
        byte[] bArrH2 = wf.a.h(str);
        for (int i11 = 0; i11 < bArrH2.length; i11++) {
            bArr[i11 + 2] = bArrH2[i11];
        }
        try {
            bArr[0] = -119;
            bArr[1] = 1;
            Q6(bArr);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void n6(int i10, Intent intent) {
        if (i10 == -1) {
            t5();
            if (this.G8 == 4) {
                this.B8.setVisibility(0);
                this.C8.setVisibility(0);
            } else {
                this.B8.setVisibility(8);
                this.C8.setVisibility(8);
            }
            this.J7 = false;
            this.U7 = null;
            String stringExtra = intent.getStringExtra("result_file_path");
            wf.g.d(this, "ota_file", stringExtra);
            this.A9 = true;
            this.f52091w8.setText(stringExtra);
        }
    }

    public final void o4() {
    }

    public void o6() {
        r4("start_ota", this.G8 + "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.A9);
        sb2.append("");
        if (this.X8.equals("LeOtaActivity") && this.Y9 == null) {
            P5();
            this.Y9.schedule(this.Z9, 0L, 5000L);
        }
        if (this.A9) {
            this.J7 = false;
            this.A9 = false;
        } else {
            F6();
        }
        int i10 = this.G8;
        if (i10 == -1 || i10 == 4) {
            B6();
        } else {
            C6();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, androidx.fragment.app.g, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        r4(this.K2, "onActivityResult");
        if (i10 == 0) {
            n6(i11, intent);
        } else if (i10 == 1) {
            m6(i11, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.pick_device) {
            if (S5()) {
                w6(1);
                return;
            }
            return;
        }
        if (id2 == R.id.pick_ota_file) {
            int i10 = this.G8;
            if (i10 != -1 && i10 != 4) {
                t5();
                this.A9 = true;
                this.J7 = false;
                T6();
                return;
            }
            if (this.N7 != 5) {
                t5();
                this.A9 = true;
                x6(0);
                return;
            }
            return;
        }
        if (id2 == R.id.start_ota) {
            v5();
            return;
        }
        if (id2 == R.id.dump_log_pick_device) {
            if (S5()) {
                w6(1);
                return;
            }
            return;
        }
        if (id2 == R.id.dump_log_read_fw_version) {
            this.f52068k9 = 2;
            v5();
            return;
        }
        if (id2 == R.id.crash_log_pick_device) {
            if (S5()) {
                w6(1);
            }
        } else if (id2 == R.id.crash_log_read_fw_version) {
            this.f52068k9 = 10;
            v5();
        } else if (id2 == R.id.connect_device_ota) {
            this.f52096y9 = wf.c.i();
            v5();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r4(this.K2, "onCreate");
        String strY5 = y5();
        this.X8 = strY5;
        r4("onCreate", strY5);
        this.A9 = false;
        if (z5() == -1) {
            wf.g.d(getApplicationContext(), tf.a.G, Boolean.TRUE);
        } else {
            wf.g.d(getApplicationContext(), tf.a.G, Boolean.FALSE);
        }
        if (this.X8.equals("DumpLogActivity")) {
            setContentView(R.layout.act_dumplog);
            O5();
            M5();
        }
        if (this.X8.equals("CrashLogActivity")) {
            setContentView(R.layout.act_crashlog);
            N5();
            M5();
        } else {
            setContentView(R.layout.act_ota);
            Q5();
            M5();
        }
        if (this.S8 == null) {
            this.S8 = BluetoothAdapter.getDefaultAdapter();
        }
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        r4(this.K2, "onDestroy");
        O6(129, 0L);
        this.N8 = 0;
        this.G8 = 5;
        this.L8 = -1;
        Handler handler = this.f52053da;
        if (handler != null) {
            handler.removeMessages(3);
            this.f52053da.removeMessages(2);
        }
        p pVar = this.R7;
        if (pVar != null) {
            pVar.removeMessages(132);
            this.R7.removeMessages(146);
        }
        HandlerThread handlerThread = this.Q7;
        if (handlerThread != null && handlerThread.isAlive()) {
            this.Q7.quit();
        }
        if (this.S8 != null) {
            this.S8 = null;
        }
        if (this.X8.equals("DumpLogActivity")) {
            if (this.f52064i9 != null) {
                this.f52064i9 = null;
            }
            if (this.f52066j9 != null) {
                this.f52066j9 = null;
            }
            this.f52043a9 = 0;
            this.f52046b9 = 0;
        } else if (this.X8.equals("CrashLogActivity")) {
            if (this.I9 != null) {
                this.I9 = null;
            }
            if (this.J9 != null) {
                this.J9 = null;
            }
            this.K9 = 0;
            this.L9 = 0;
        }
        this.P8 = 0;
        this.f52072m9 = 0;
        this.M9 = 0;
        BluetoothLeScanner bluetoothLeScanner = this.W9;
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.stopScan(this.f52050ca);
            this.W9 = null;
        }
        wf.g.d(this, tf.a.H, 5);
        r4(this.K2, "onDestroy: +++++++++++++++APPLY_STEREO_UNDEFINED");
        Timer timer = this.Y9;
        if (timer != null) {
            timer.cancel();
            this.Y9 = null;
        }
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        j4();
        return true;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onResume() {
        r4(this.K2, "onResume");
        super.onResume();
        int iZ5 = z5();
        if (iZ5 == -1 || this.X8.equals("LeOtaActivity")) {
            this.D8.setVisibility(0);
        } else {
            this.D8.setVisibility(8);
            A5(iZ5);
        }
        if (this.X8.equals("LeOtaActivity") || this.X8.equals("SppOtaActivity")) {
            this.E8.setEnabled(!this.W8.getText().toString().equals("--"));
            if (s5()) {
                F6();
            }
        }
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        r4(this.K2, "onStop");
        super.onStop();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:84|3|4|(1:50)(3:8|9|(1:11)(4:13|93|(2:15|16)(2:24|(2:26|27)(8:29|(1:(2:44|(1:46)(2:47|48)))(4:33|(1:35)(3:37|(1:39)|40)|36|40)|52|(1:54)|55|89|56|60))|92))|51|52|(0)|55|89|56|60) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ee, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00db A[Catch: all -> 0x00f3, IOException -> 0x00f5, FileNotFoundException -> 0x00ff, TryCatch #2 {all -> 0x00f3, blocks: (B:3:0x0001, B:8:0x000c, B:11:0x0012, B:52:0x00cc, B:54:0x00db, B:55:0x00e0, B:15:0x0029, B:64:0x00f6, B:69:0x0100, B:26:0x0051, B:31:0x0066, B:33:0x006a, B:35:0x006e, B:40:0x008d, B:37:0x007c, B:39:0x0080, B:42:0x0095, B:44:0x0099, B:46:0x009d, B:47:0x00aa, B:50:0x00bc), top: B:86:0x0001 }] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v44, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p4() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: uf.c.p4():long");
    }

    public abstract void p6();

    public final void q4() {
        int i10 = this.G8;
        if (i10 == 0) {
            this.f52091w8.setText(getString(R.string.left_earbud_only) + ":\n" + ((String) wf.g.b(this, tf.a.D, "")));
            this.I8 = (byte) 1;
            this.L8 = -1;
            return;
        }
        if (i10 == 1) {
            this.f52091w8.setText(getString(R.string.right_earbud_only) + ":\n" + ((String) wf.g.b(this, tf.a.E, "")));
            this.I8 = (byte) 16;
            this.L8 = -1;
            return;
        }
        if (i10 == 2) {
            this.f52091w8.setText(getString(R.string.both_earbuds_in_one_bin) + ":\n" + ((String) wf.g.b(getApplicationContext(), tf.a.D, "")));
            this.I8 = (byte) 17;
            this.L8 = -1;
            this.N8 = 0;
            this.f52084s9 = 0;
            this.f52086t9 = 0;
            this.f52088u9 = 0;
            return;
        }
        if (i10 == 3) {
            this.f52091w8.setText(((getString(R.string.both_earbuds_in_two_bins) + "\n") + getString(R.string.left_earbud_image) + ":" + ((String) wf.g.b(this, tf.a.D, "")) + "\n") + getString(R.string.right_earbud_image) + ":" + ((String) wf.g.b(this, tf.a.E, "")));
            this.L8 = 0;
        }
    }

    public final void q5(byte b10) {
        try {
            byte[] bArr = {b10, this.I8};
            Q6(bArr);
            r4("handleApplyTheImage", wf.a.o(bArr));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public abstract void q6();

    public void r4(String str, String str2) {
    }

    public final String r5(long j10) {
        if (j10 >= 1073741824) {
            return String.format("%.1f GB", Float.valueOf(j10 / 1073741824));
        }
        if (j10 >= 1048576) {
            float f10 = j10 / 1048576;
            return String.format(f10 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f10));
        }
        if (j10 <= 1024) {
            return String.format("%d B", Long.valueOf(j10));
        }
        float f11 = j10 / 1024;
        return String.format(f11 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f11));
    }

    public void r6() {
        this.f52051d8 = true;
        r4(this.K2, "onWritten mWritten = true");
    }

    public final void s4() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f52096y9, true);
            fileOutputStream.write(this.f52094x9.getBytes("gbk"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        this.f52094x9 = "";
        this.f52096y9 = "";
    }

    public boolean s5() {
        this.M7 = ((Integer) wf.g.b(getApplicationContext(), tf.a.H, 5)).intValue();
        r4("checkResumeState", this.M7 + "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.M7);
        sb2.append("+++++");
        int i10 = this.M7;
        if (i10 == 5) {
            return false;
        }
        if (i10 == 2) {
            return ((String) wf.g.b(this, tf.a.D, "")) != null;
        }
        if (i10 == 3) {
            if (((String) wf.g.b(this, tf.a.E, "")) == null || ((String) wf.g.b(this, tf.a.D, "")) == null) {
                return false;
            }
            int iIntValue = ((Integer) wf.g.b(getApplicationContext(), tf.a.I, -1)).intValue();
            this.L7 = iIntValue;
            if (iIntValue == -1) {
                return false;
            }
            this.G8 = this.M7;
            this.L8 = iIntValue;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("daul_step = ");
            sb3.append(this.L8);
            return true;
        }
        if (i10 == 1) {
            String str = (String) wf.g.b(this, tf.a.E, "");
            if (str == null) {
                return false;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("file :");
            sb4.append(str);
            this.G8 = this.M7;
            this.K7 = str;
            return true;
        }
        if (i10 != 0) {
            return true;
        }
        String str2 = (String) wf.g.b(this, tf.a.D, "");
        if (str2 == null || str2 == "") {
            return false;
        }
        this.G8 = this.M7;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("file :");
        sb5.append(str2);
        this.K7 = str2;
        return true;
    }

    public void s6() {
        byte[][] bArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otaConfigNext: ++++++++++daulApply");
        sb2.append(this.G8);
        synchronized (this.f52045b8) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.N7);
            sb3.append("");
            byte[][] bArr2 = this.Y7;
            if (this.N7 == 7 && (bArr = this.Y7) != null) {
                if (this.Z7 != bArr.length) {
                    r4(this.K2, "otaConfigNext " + this.Z7 + "; " + this.Y7.length + " mWritten = " + this.f52051d8);
                    this.M9 = 0;
                    if (Q6(this.Y7[this.Z7])) {
                        int i10 = this.Z7 + 1;
                        this.Z7 = i10;
                        if (i10 == this.Y7.length) {
                            S6(R.string.ota_config_time_out, 129, 5000L);
                        }
                    } else {
                        r4(this.K2, "otaConfigNext write failed");
                        O6(146, 10L);
                    }
                    return;
                }
                r4("otaConfigNext mOtaConfigPacketCount", this.Z7 + " mOtaConfigData.length " + this.Y7.length);
                r4(this.K2, "otaConfigNext mOtaConfigPacketCount == mOtaConfigData.length");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("otaConfigNext: +++++++++1--reloadOtaConfigInfotime");
                sb4.append(this.M9);
                if (this.M9 == 0) {
                    this.M9 = 1;
                    O6(144, 0L);
                } else if (this.Q9 && this.U9 < 2) {
                    r4(this.K2, "otaConfigNext connectImmediatelyTimes");
                    this.U9++;
                    this.M9 = 0;
                    Q6(new byte[]{-122});
                }
                return;
            }
            r4(this.K2, "otaConfigNext mState != STATE_OTA_CONFIG || mOtaConfigData == null");
        }
    }

    public final void t4(int i10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        sb2.append("");
        if (i10 == 1) {
            this.f52060g9 = wf.c.g(0);
            this.f52055e9 = "";
            this.f52043a9 = 0;
            this.f52058f9 = false;
            return;
        }
        this.f52060g9 = wf.c.g(1);
        this.E9 = "";
        this.K9 = 0;
        this.F9 = false;
    }

    public final void t5() {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = 0;
        }
        wf.g.d(getApplicationContext(), tf.a.A, wf.a.o(bArr));
        wf.g.d(getApplicationContext(), tf.a.J, wf.a.o(bArr));
        wf.g.d(getApplicationContext(), tf.a.K, wf.a.o(bArr));
    }

    public void t6() {
        byte[][][] bArr;
        boolean zQ6;
        synchronized (this.f52045b8) {
            r4("otaNext  -> daulApply ", this.G8 + "");
            r4("otaNext  -> mState ", this.N7 + "");
            byte[][][] bArr2 = this.U7;
            if (this.N7 == 5 && (bArr = this.U7) != null) {
                if (this.V7 == bArr.length) {
                    r4(this.K2, "otaNext -> mState != STATE_OTA_ING || mOtaData == null ");
                    return;
                }
                r4(this.K2, "otaNext totalPacketCount = " + this.f52042a8 + " ; subCount " + this.V7 + "; " + this.W7 + "; " + this.U7[this.V7].length);
                if (this.X7 || this.f52051d8) {
                    int i10 = this.W7;
                    byte[][][] bArr3 = this.U7;
                    int i11 = this.V7;
                    if (i10 < bArr3[i11].length) {
                        byte[] bArr4 = {-107, 1};
                        int i12 = this.f52072m9;
                        if (i12 == 0 || i12 == 2) {
                            if (bArr3[i11][i10].length == 1 && (bArr3[i11][i10][0] & 255) == 136) {
                                this.R9 = true;
                            }
                            zQ6 = Q6(this.U7[this.V7][this.W7]);
                        } else if (i12 == 1 && R5()) {
                            r4("ROLE_SWITCH_FLAG", wf.a.o(bArr4));
                            wf.a.o(bArr4);
                            zQ6 = Q6(bArr4);
                        } else {
                            zQ6 = false;
                        }
                        if (!zQ6) {
                            r4(this.K2, "otaNext write failed , try to resend");
                            int i13 = this.f52072m9;
                            if (i13 == 0 || i13 == 2) {
                                this.R9 = false;
                                O6(132, 40L);
                            } else if (i13 == 1 && R5()) {
                                this.R9 = false;
                                O6(160, 10L);
                            }
                        } else {
                            if (this.f52072m9 == 1 && R5()) {
                                return;
                            }
                            if (!this.X7 && this.V7 == this.U7.length - 1) {
                                i6();
                                return;
                            }
                            int i14 = this.W7;
                            if (i14 == 0) {
                                r4(this.K2, "---------------------------------START--------------------------------------");
                            } else if (i14 == this.U7[this.V7].length - 1) {
                                r4(this.K2, "---------------------------------END--------------------------------------");
                            }
                            int i15 = this.W7 + 1;
                            this.W7 = i15;
                            if (i15 == this.U7[this.V7].length) {
                                r4("otaNext", "CMD_DISCONNECT");
                                E6();
                                S6(R.string.ota_time_out, 129, 30000L);
                            } else {
                                r4("otaNext", "CMD_RESEND_MSG");
                                E6();
                                S6(R.string.ota_time_out, 136, 10000L);
                            }
                        }
                    }
                } else {
                    r4(this.K2, "otaNext  -> (mSupportNewOtaProfile || mWritten) is false  " + this.X7 + " ;" + this.f52051d8);
                }
                return;
            }
            r4(this.K2, "otaNext  -> mState != STATE_OTA_ING || mOtaData == null ");
        }
    }

    public abstract void u5();

    public void u6(long j10) {
        boolean zBooleanValue = ((Boolean) wf.g.b(getApplicationContext(), tf.a.G, Boolean.TRUE)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) wf.g.b(getApplicationContext(), tf.a.M, Boolean.FALSE)).booleanValue();
        synchronized (this.f52045b8) {
            if (this.N7 == 5) {
                if (R5() || (zBooleanValue && !zBooleanValue2)) {
                    O6(132, j10);
                }
            } else if (this.N7 == 7) {
                O6(146, j10);
            }
        }
    }

    public void v5() {
        if ((this.f52087u8.getText() == "--" || this.f52087u8.getText() == null) && this.O7 == null) {
            if (z5() == -1) {
                m4(getString(R.string.no_device_mention_tips));
            }
        } else {
            if (this.X8.equals("SppOtaActivity") || (this.X8.equals("LeOtaActivity") && !this.Q9)) {
                this.W8.setText(getString(R.string.old_ota_ways_version_tips));
            }
            O6(128, 0L);
        }
    }

    public final void v6() {
        if (this.N9) {
            q5((byte) -112);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handleApplyTheImage: +++++++++++++++++----------");
        sb2.append(this.N9);
        q5((byte) -101);
        new Thread(new a()).start();
    }

    public abstract void w5();

    public abstract void w6(int i10);

    public void x5() {
        wf.g.d(this, tf.a.I, Integer.valueOf(this.L8));
        E6();
        O6(129, 0L);
        this.N8 = 0;
        this.L8 = 0;
        this.G8 = 5;
        this.f52053da.removeMessages(3);
        this.P7 = true;
        this.J7 = false;
        this.I7 = 0;
        this.I8 = (byte) 0;
        this.W8.setText("--");
        this.f52086t9 = 0;
        this.f52088u9 = 0;
        s4();
        this.A9 = false;
        this.P8 = 0;
        if (this.f52072m9 == 1) {
            wf.g.d(this, tf.a.H, -1);
        }
        this.f52072m9 = 0;
        this.M9 = 0;
    }

    public void x6(int i10) {
        startActivityForResult(new Intent(this, (Class<?>) FilePickerActivity.class), i10);
    }

    public abstract String y5();

    public void y6() {
        r4(this.K2, "reGetVersion " + this.N7 + " SPAN TIME IS 3000 daulApply is " + this.G8);
        wf.d.A(this.K2, "reGetVersion " + this.N7 + " SPAN TIME IS 3000 daulApply is " + this.G8);
        if (this.N7 == 2) {
            this.f52075o8++;
            r4("reGetVersion", this.f52075o8 + "");
            O6(142, 3000L);
        }
    }

    @Override // com.iir_eq.ui.fragment.OtaConfigFragment.h
    public void z2() {
        f7(0);
        if (this.G8 == 4) {
            O6(140, 0L);
            this.f52063i8 = System.currentTimeMillis();
            e7(y5() + "\nbegin time:" + C5());
        } else {
            O6(153, 0L);
            r4("onOtaConfigOk", "CMD_APPLY_THE_IMAGE_MSG");
        }
        this.J7 = true;
    }

    public final int z5() {
        if (this.S8 == null) {
            this.S8 = BluetoothAdapter.getDefaultAdapter();
        }
        int profileConnectionState = this.S8.getProfileConnectionState(2);
        int profileConnectionState2 = this.S8.getProfileConnectionState(1);
        int profileConnectionState3 = this.S8.getProfileConnectionState(3);
        if (profileConnectionState != 2) {
            profileConnectionState = profileConnectionState2 == 2 ? profileConnectionState2 : profileConnectionState3 == 2 ? profileConnectionState3 : -1;
        }
        r4("getConnectBt flag", profileConnectionState + "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getConnectBt flag: ++++++++");
        sb2.append(profileConnectionState);
        return profileConnectionState;
    }

    public void z6(byte[] bArr) {
        wf.a.o(bArr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(bArr.length);
        sb2.append("");
        this.f52052d9 = (Integer.parseInt(Pb, 16) * 129) / 128;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.f52052d9);
        sb3.append("");
        if (this.f52049c9 < this.f52052d9) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                this.f52076o9[this.f52049c9 + i10] = bArr[i10];
            }
            int length = this.f52049c9 + bArr.length;
            this.f52049c9 = length;
            if (length == this.f52052d9) {
                int i11 = 0;
                for (int i12 = 0; i12 < this.f52052d9; i12++) {
                    if (i12 % 129 > 0) {
                        this.f52078p9[i11] = this.f52076o9[i12];
                        i11++;
                    }
                }
                A6(wf.a.l(this.f52078p9));
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        super.onRestoreInstanceState(bundle, persistableBundle);
    }
}
