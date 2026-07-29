package z7;

import android.content.Context;
import android.view.WindowManager;
import com.flydigi.data.DataConstant;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class x0 extends y7.b {
    public x0(Context context, y7.n nVar) {
        super(context, nVar);
        this.f56483f.postDelayed(new w0(this), 1000L);
    }

    public final void C() {
        if (!o5.b.e(this.f56478a)) {
            this.f56483f.postDelayed(new w0(this), 1000L);
        } else {
            D();
            h();
        }
    }

    public final void D() {
        h3.a.j().d(a.d.f31950f).withBoolean(DataConstant.DEVICE_KEY_DRIVER_ACTIVE_FROM_PERMISSION_CHECK, true).withBoolean(DataConstant.DEVICE_KEY_ACTIVATION_FAILED, false).navigation();
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
