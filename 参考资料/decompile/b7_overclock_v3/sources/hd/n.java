package hd;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public interface n {
    Message a(int i10, int i11, int i12);

    boolean b(int i10, int i11);

    boolean c(Runnable runnable);

    Message d(int i10);

    boolean e(int i10);

    boolean f(Runnable runnable, long j10);

    boolean g(int i10);

    Message h(int i10, int i11, int i12, @g.p0 Object obj);

    boolean i(int i10, long j10);

    void j(int i10);

    Message k(int i10, @g.p0 Object obj);

    void l(@g.p0 Object obj);

    Looper m();
}
