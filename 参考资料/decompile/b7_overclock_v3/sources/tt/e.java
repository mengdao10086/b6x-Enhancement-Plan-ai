package tt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* JADX INFO: loaded from: classes6.dex */
public class e extends Handler implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f51680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f51682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51683d;

    public e(c cVar, Looper looper, int i10) {
        super(looper);
        this.f51682c = cVar;
        this.f51681b = i10;
        this.f51680a = new j();
    }

    @Override // tt.k
    public void a(p pVar, Object obj) {
        i iVarA = i.a(pVar, obj);
        synchronized (this) {
            this.f51680a.a(iVarA);
            if (!this.f51683d) {
                this.f51683d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                i iVarB = this.f51680a.b();
                if (iVarB == null) {
                    synchronized (this) {
                        iVarB = this.f51680a.b();
                        if (iVarB == null) {
                            return;
                        }
                    }
                }
                this.f51682c.l(iVarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f51681b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f51683d = true;
        } finally {
            this.f51683d = false;
        }
    }
}
