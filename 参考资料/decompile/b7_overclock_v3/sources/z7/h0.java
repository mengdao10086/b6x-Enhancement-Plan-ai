package z7;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;

/* JADX INFO: loaded from: classes7.dex */
public class h0 extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f57830p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final GamepadInfo f57831q;

    public interface a {
        void a();
    }

    public h0(Context context, GamepadInfo gamepadInfo, a aVar, y7.n nVar) {
        super(context, nVar);
        this.f56478a = context;
        this.f57831q = gamepadInfo;
        this.f57830p = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        a aVar = this.f57830p;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // y7.b
    public void h() {
        super.h();
        o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_VIEW_GUIDE_FLOAT_BALL, true, true);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_float_ball_guide;
    }

    @Override // y7.b
    public void n() {
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_notice);
        Context context = this.f56478a;
        int i10 = R.string.floatview_float_ball_guide_notice_gp_whole;
        String string = context.getString(i10);
        int deviceMode = this.f57831q.getDeviceMode();
        if (deviceMode == 0) {
            string = this.f56478a.getString(i10);
        } else if (deviceMode == 1) {
            string = this.f57831q.getDeviceType() == 49 ? this.f56478a.getString(R.string.floatview_float_ball_guide_notice_km_d1) : this.f56478a.getString(R.string.floatview_float_ball_guide_notice_km_other);
        } else if (deviceMode == 2) {
            string = this.f56478a.getString(R.string.floatview_float_ball_guide_notice_gp_half);
        }
        textView.setText(Html.fromHtml(string));
        com.blankj.utilcode.util.o.r((ImageView) this.f56479b.findViewById(R.id.iv_float_ball), new View.OnClickListener() { // from class: z7.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57828a.C(view);
            }
        });
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388661;
        return layoutParamsH;
    }
}
