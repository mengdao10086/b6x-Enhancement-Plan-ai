package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.c1;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@x0
public class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7250a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, String> f7251b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RemoteCallbackList<b1> f7252c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c1.b f7253d = new b();

    public class a extends RemoteCallbackList<b1> {
        public a() {
        }

        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(b1 b1Var, Object obj) {
            MultiInstanceInvalidationService.this.f7251b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends c1.b {
        public b() {
        }

        @Override // androidx.room.c1
        public void G0(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f7252c) {
                String str = MultiInstanceInvalidationService.this.f7251b.get(Integer.valueOf(i10));
                if (str == null) {
                    return;
                }
                int iBeginBroadcast = MultiInstanceInvalidationService.this.f7252c.beginBroadcast();
                for (int i11 = 0; i11 < iBeginBroadcast; i11++) {
                    try {
                        int iIntValue = ((Integer) MultiInstanceInvalidationService.this.f7252c.getBroadcastCookie(i11)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f7251b.get(Integer.valueOf(iIntValue));
                        if (i10 != iIntValue && str.equals(str2)) {
                            try {
                                ((b1) MultiInstanceInvalidationService.this.f7252c.getBroadcastItem(i11)).J(strArr);
                            } catch (RemoteException unused) {
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.f7252c.finishBroadcast();
                    }
                }
            }
        }

        @Override // androidx.room.c1
        public void K0(b1 b1Var, int i10) {
            synchronized (MultiInstanceInvalidationService.this.f7252c) {
                MultiInstanceInvalidationService.this.f7252c.unregister(b1Var);
                MultiInstanceInvalidationService.this.f7251b.remove(Integer.valueOf(i10));
            }
        }

        @Override // androidx.room.c1
        public int R(b1 b1Var, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f7252c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i10 = multiInstanceInvalidationService.f7250a + 1;
                multiInstanceInvalidationService.f7250a = i10;
                if (multiInstanceInvalidationService.f7252c.register(b1Var, Integer.valueOf(i10))) {
                    MultiInstanceInvalidationService.this.f7251b.put(Integer.valueOf(i10), str);
                    return i10;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f7250a--;
                return 0;
            }
        }
    }

    @Override // android.app.Service
    @g.p0
    public IBinder onBind(@g.n0 Intent intent) {
        return this.f7253d;
    }
}
