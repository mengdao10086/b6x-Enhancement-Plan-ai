package vf;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.cyberfox.R;
import g.h1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BluetoothDevice> f53154a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Integer> f53155b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f53156c;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f53157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f53158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f53159c;

        public b() {
        }
    }

    public a(Context context) {
        this.f53156c = context;
    }

    @h1
    public void a(BluetoothDevice bluetoothDevice, int i10) {
        synchronized (this.f53154a) {
            int iIndexOf = this.f53154a.indexOf(bluetoothDevice);
            if (iIndexOf < 0) {
                this.f53154a.add(bluetoothDevice);
                notifyDataSetChanged();
            } else if (!TextUtils.isEmpty(bluetoothDevice.getName()) && TextUtils.isEmpty(this.f53154a.get(iIndexOf).getName())) {
                this.f53154a.set(iIndexOf, bluetoothDevice);
                notifyDataSetChanged();
            }
        }
    }

    public void b() {
        synchronized (this.f53154a) {
            this.f53154a.clear();
            this.f53155b.clear();
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BluetoothDevice getItem(int i10) {
        return this.f53154a.get(i10);
    }

    public final int d(int i10) {
        return i10 < -90 ? R.drawable.signal_level0 : i10 < -80 ? R.drawable.signal_level1 : i10 < -70 ? R.drawable.signal_level2 : i10 < -60 ? R.drawable.signal_level3 : i10 < -50 ? R.drawable.signal_level4 : R.drawable.signal_level5;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f53154a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f53156c).inflate(R.layout.device_item, viewGroup, false);
            bVar = new b();
            bVar.f53157a = (TextView) view.findViewById(R.id.name);
            bVar.f53158b = (ImageView) view.findViewById(R.id.rssi_icon);
            bVar.f53159c = (TextView) view.findViewById(R.id.rssi_value);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        BluetoothDevice bluetoothDevice = this.f53154a.get(i10);
        String name = bluetoothDevice.getName();
        if (TextUtils.isEmpty(name)) {
            name = bluetoothDevice.getAddress();
        }
        bVar.f53157a.setText(name);
        return view;
    }
}
