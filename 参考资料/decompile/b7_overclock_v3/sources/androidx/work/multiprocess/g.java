package androidx.work.multiprocess;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.work.multiprocess.c;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends c.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f8685e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<byte[]> f8684d = androidx.work.impl.utils.futures.a.u();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IBinder.DeathRecipient f8686f = new a(this);

    public static class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f8687a;

        public a(@n0 g gVar) {
            this.f8687a = gVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.f8687a.d0("Binder died");
        }
    }

    @n0
    public ListenableFuture<byte[]> T0() {
        return this.f8684d;
    }

    public final void U0(@n0 Throwable th2) {
        this.f8684d.q(th2);
        X0();
        V0();
    }

    public void V0() {
    }

    public void W0(@n0 IBinder iBinder) {
        this.f8685e = iBinder;
        try {
            iBinder.linkToDeath(this.f8686f, 0);
        } catch (RemoteException e10) {
            U0(e10);
        }
    }

    public final void X0() {
        IBinder iBinder = this.f8685e;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.f8686f, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // androidx.work.multiprocess.c
    public void d0(@n0 String str) {
        U0(new RuntimeException(str));
    }

    @Override // androidx.work.multiprocess.c
    public void z0(@n0 byte[] bArr) throws RemoteException {
        this.f8684d.p(bArr);
        X0();
        V0();
    }
}
