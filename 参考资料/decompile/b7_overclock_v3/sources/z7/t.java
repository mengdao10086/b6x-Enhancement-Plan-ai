package z7;

import android.content.Context;
import android.view.WindowManager;
import com.flydigi.baseProvider.IRemoteProvider;
import com.flydigi.data.DataConstant;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class t extends y7.b {
    public t(Context context, y7.n nVar) {
        super(context, nVar);
        this.f56483f.postDelayed(new Runnable() { // from class: z7.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f57897a.C();
            }
        }, 1000L);
    }

    public final void C() {
        if (o5.b.a(this.f56478a)) {
            D();
        } else {
            ((IRemoteProvider) h3.a.j().d(a.g.f31983b).navigation()).c(this.f56478a, DataConstant.FLOAT_WINDOW_ACTION_ENABLE_USB_DEBUG_SHOW);
        }
        h();
    }

    public final void D() {
        h3.a.j().d(a.d.f31950f).withBoolean(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, false).withBoolean(DataConstant.DEVICE_KEY_ACTIVATION_FAILED, false).navigation();
    }

    @Override // y7.b
    public int i() {
        return 0;
    }

    @Override // y7.b
    public void n() {
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        return null;
    }
}
