package g2;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class g0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f28957a;

    public g0(IBinder iBinder) {
        this.f28957a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof g0) && ((g0) obj).f28957a.equals(this.f28957a);
    }

    public int hashCode() {
        return this.f28957a.hashCode();
    }
}
