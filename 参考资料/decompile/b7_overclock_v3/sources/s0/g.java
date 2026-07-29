package s0;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends LocationListener {
    @Override // android.location.LocationListener
    void onFlushComplete(int i10);

    @Override // android.location.LocationListener
    void onLocationChanged(@n0 List<Location> list);

    @Override // android.location.LocationListener
    void onProviderDisabled(@n0 String str);

    @Override // android.location.LocationListener
    void onProviderEnabled(@n0 String str);

    @Override // android.location.LocationListener
    void onStatusChanged(@n0 String str, int i10, @p0 Bundle bundle);
}
