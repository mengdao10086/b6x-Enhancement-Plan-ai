package ut;

import android.os.Looper;
import tt.g;
import tt.k;

/* JADX INFO: loaded from: classes6.dex */
public class e implements g {
    @Override // tt.g
    public k a(tt.c cVar) {
        return new tt.e(cVar, Looper.getMainLooper(), 10);
    }

    @Override // tt.g
    public boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
