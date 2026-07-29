package h0;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import g0.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"ActionValue"})
    public static final String f30166b = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b.AbstractBinderC0340b f30167a = new a();

    public class a extends b.AbstractBinderC0340b {
        public a() {
        }

        @Override // g0.b
        public void t0(@g.p0 g0.a aVar) throws RemoteException {
            if (aVar == null) {
                return;
            }
            m0.this.a(new l0(aVar));
        }
    }

    public abstract void a(@g.n0 l0 l0Var);

    @Override // android.app.Service
    @g.p0
    public IBinder onBind(@g.p0 Intent intent) {
        return this.f30167a;
    }
}
