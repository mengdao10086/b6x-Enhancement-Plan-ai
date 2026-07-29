package sf;

import android.annotation.TargetApi;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@TargetApi(21)
public class e extends sf.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BluetoothLeScanner f49835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ScanCallback f49836f;

    public class a extends ScanCallback {
        public a() {
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i10) {
            wf.e.g(e.this.f49826a, "onScanFailed " + i10);
            super.onScanFailed(i10);
            e.this.f();
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i10, ScanResult scanResult) {
            String str = e.this.f49826a;
            String str2 = e.this.f49826a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onScanResult: ++++++");
            sb2.append(wf.a.a(scanResult.getScanRecord().getBytes()));
            e.this.e(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes());
        }
    }

    public e(Context context) {
        super(context);
        this.f49836f = new a();
        this.f49835e = c().getBluetoothLeScanner();
    }

    @Override // sf.a, sf.b
    public void a(rf.c cVar) {
        super.a(cVar);
        if (d()) {
            return;
        }
        if (this.f49835e == null) {
            this.f49835e = c().getBluetoothLeScanner();
        }
        this.f49835e.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), this.f49836f);
        g();
    }

    @Override // sf.b
    public void b() {
        if (d()) {
            this.f49835e.stopScan(this.f49836f);
            f();
        }
    }

    @Override // sf.a, sf.b
    public void close() {
    }
}
