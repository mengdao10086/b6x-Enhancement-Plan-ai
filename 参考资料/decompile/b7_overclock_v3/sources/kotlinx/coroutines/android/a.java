package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.m2;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements z {
    @Override // kotlinx.coroutines.internal.z
    @k
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.z
    @k
    public m2 b(@k List<? extends z> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(f.e(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.z
    public int c() {
        return 1073741823;
    }
}
