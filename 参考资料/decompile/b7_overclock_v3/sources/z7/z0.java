package z7;

import android.content.Context;
import android.view.WindowManager;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import i9.a;

/* JADX INFO: loaded from: classes7.dex */
public class z0 extends y7.b {
    public z0(Context context, y7.n nVar) {
        super(context, nVar);
        this.f56483f.postDelayed(new y0(this), 1000L);
    }

    public final void C() {
        if (o5.b.j(this.f56478a)) {
            com.flydigi.base.common.n.a("三指截屏未关闭，1秒后重新检测");
            this.f56483f.postDelayed(new y0(this), 1000L);
        } else {
            com.flydigi.base.common.n.a("三指截屏已关闭，返回app");
            o5.m.k(DataConstant.SP_APP).F(DataConstant.SP_APP_KEY_CHECK_THREE_FINGER, false);
            com.flydigi.base.common.o.E(this.f56478a.getString(R.string.device_three_finger_screenshot_disabled));
            h3.a.j().d(a.f.f31974c).navigation();
        }
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
