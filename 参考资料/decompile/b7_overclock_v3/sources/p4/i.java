package p4;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(26)
public final class i implements k, ComponentCallbacks2 {
    @Override // p4.k
    public void a(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@n0 Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(20);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
    }
}
