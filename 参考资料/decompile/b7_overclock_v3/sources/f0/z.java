package f0;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import c.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends Service {

    public class a extends a.b {
        public a() {
        }

        @Override // c.a
        public void I0(String str, int i10, String str2, Notification notification) throws RemoteException {
            z.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                z.this.d(str, i10, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // c.a
        public void P(String str) {
            z.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                z.this.b(str);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // c.a
        public void p0(String str, int i10, String str2) throws RemoteException {
            z.this.c(Binder.getCallingUid(), str);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                z.this.a(str, i10, str2);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public abstract void a(String str, int i10, String str2);

    public abstract void b(String str);

    public void c(int i10, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(i10)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i10 + " is not authorized for package " + str);
    }

    public abstract void d(String str, int i10, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        intent.getAction().equals(a0.f27366g);
        return null;
    }
}
