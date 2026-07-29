package b8;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.PropertyLinearLayout;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import w7.c0;

/* JADX INFO: loaded from: classes7.dex */
public class e extends y7.b implements View.OnClickListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c0 f9130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e8.e f9131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CFGPropertyKey f9132r;

    public e(Context context, Handler handler, CFGPropertyKey cFGPropertyKey, GamepadInfo gamepadInfo) {
        super(context, null, handler, gamepadInfo);
        this.f9132r = cFGPropertyKey;
        this.f9131q = new e8.e(this.f56478a, gamepadInfo);
    }

    public final void B() {
        CFGPropertyKey cFGPropertyKeyC = this.f9131q.c();
        cFGPropertyKeyC.key_id = this.f9132r.key_id;
        Message message = new Message();
        message.what = 101;
        message.obj = cFGPropertyKeyC;
        this.f56482e.sendMessage(message);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_property_joystick;
    }

    @Override // y7.b
    public void n() {
        c0 c0VarA = c0.a(this.f56479b);
        this.f9130p = c0VarA;
        c0VarA.f54004i.setText(n8.b.f(this.f56478a, this.f9132r.key_id, this.f56484g.getDeviceMode(), this.f56484g.getDeviceType()) + this.f56478a.getString(R.string.floatview_property_key_title));
        o.r(this.f9130p.f54002g, this);
        o.r(this.f9130p.f54003h, this);
        this.f9130p.f54000e.setVisibility(8);
        this.f9131q.f(this.f9132r);
        PropertyLinearLayout propertyLinearLayoutD = this.f9131q.d();
        propertyLinearLayoutD.setId(3);
        this.f9130p.f53997b.addView(propertyLinearLayoutD);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c0 c0Var = this.f9130p;
        if (view == c0Var.f54002g) {
            this.f56482e.sendEmptyMessage(111);
            h();
        } else if (view == c0Var.f54003h) {
            B();
            h();
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
