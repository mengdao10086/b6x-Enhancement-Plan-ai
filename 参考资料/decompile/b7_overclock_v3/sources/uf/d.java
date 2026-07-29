package uf;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.flydigi.cyberfox.R;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public abstract class d extends uf.a implements rf.c, SwipeRefreshLayout.j, AdapterView.OnItemClickListener {
    public static final String I7 = "extra_device";
    public ListView E7;
    public SwipeRefreshLayout F7;
    public vf.a G7;
    public sf.b H7;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BluetoothDevice f52115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f52116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f52117c;

        public a(BluetoothDevice bluetoothDevice, byte[] bArr, int i10) {
            this.f52115a = bluetoothDevice;
            this.f52116b = bArr;
            this.f52117c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.p4(this.f52115a, this.f52116b)) {
                d.this.G7.a(this.f52115a, this.f52117c);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwipeRefreshLayout swipeRefreshLayout = d.this.F7;
            if (swipeRefreshLayout == null || !swipeRefreshLayout.n()) {
                return;
            }
            d.this.F7.setRefreshing(false);
        }
    }

    private void t4() {
        I3().Y(true);
        this.F7 = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        this.E7 = (ListView) findViewById(R.id.devices);
        vf.a aVar = new vf.a(this);
        this.G7 = aVar;
        this.E7.setAdapter((ListAdapter) aVar);
        this.F7.setOnRefreshListener(this);
        this.E7.setOnItemClickListener(this);
    }

    public void U1() {
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.act_scan;
    }

    public void h() {
        runOnUiThread(new b());
    }

    public abstract boolean o4();

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        e4();
        this.C1.setText(R.string.cf_upgrade_firmware);
        t4();
        s4();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        u4(this.G7.getItem(i10));
    }

    @Override // com.flydigi.base.common.p, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            w4();
            this.H7.close();
        }
    }

    @Override // com.flydigi.base.common.c, ch.a, androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStart() {
        super.onStart();
        v4();
    }

    public abstract boolean p4(BluetoothDevice bluetoothDevice, byte[] bArr);

    public abstract sf.b q4();

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void r() {
        v4();
    }

    public final boolean r4() {
        if (qf.a.d(this).isEnabled()) {
            return true;
        }
        startActivity(new Intent("android.settings.BLUETOOTH_SETTINGS"));
        return false;
    }

    public final void s4() {
        sf.b bVarQ4 = q4();
        this.H7 = bVarQ4;
        if (bVarQ4 == null) {
            finish();
        }
    }

    @Override // rf.c
    public void u2(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
        runOnUiThread(new a(bluetoothDevice, bArr, i10));
    }

    public abstract void u4(BluetoothDevice bluetoothDevice);

    public boolean v4() {
        this.G7.b();
        if (!r4() || !o4()) {
            return false;
        }
        this.H7.a(this);
        return true;
    }

    public void w4() {
        this.H7.b();
    }
}
