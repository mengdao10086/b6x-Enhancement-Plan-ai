package z7;

import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class b extends y7.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f57782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f57783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f57784r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f57785s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayout f57786t;

    public b(Context context, Handler handler, String str, boolean z10) {
        super(context, (y7.n) null, handler);
        this.f57782p = str;
        this.f57783q = z10;
        this.f56483f.postDelayed(new Runnable() { // from class: z7.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f57775a.h();
            }
        }, 2400L);
    }

    public void B(String str, boolean z10) {
        TextView textView = this.f57784r;
        if (textView != null) {
            if (z10) {
                textView.setText(this.f56478a.getString(R.string.floatview_gamepad_state_connected, str));
                this.f57785s.setVisibility(8);
            } else {
                textView.setText(this.f56478a.getString(R.string.floatview_gamepad_state_disconnected, str));
                this.f57785s.setVisibility(0);
            }
        }
        if (this.f57786t != null) {
            if (com.blankj.utilcode.util.d.L()) {
                this.f57786t.setBackgroundResource(R.drawable.float_bg_forgroud_connect_state);
                this.f57785s.setImageResource(R.drawable.float_ic_device_disconnected_forgroud);
                this.f57784r.setTextColor(this.f56478a.getResources().getColor(R.color.color_000000_a90));
            } else {
                this.f57786t.setBackgroundResource(R.drawable.float_bg_backgroud_connect_state);
                this.f57785s.setImageResource(R.drawable.float_ic_device_disconnected_backgroud);
                this.f57784r.setTextColor(this.f56478a.getResources().getColor(R.color.white));
            }
        }
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_connect_state;
    }

    @Override // y7.b
    public void n() {
        this.f57786t = (LinearLayout) this.f56479b.findViewById(R.id.ll_bg);
        this.f57784r = (TextView) this.f56479b.findViewById(R.id.tv_content);
        this.f57785s = (ImageView) this.f56479b.findViewById(R.id.iv_unconnected);
        B(this.f57782p, this.f57783q);
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(3);
        layoutParamsH.gravity = 49;
        return layoutParamsH;
    }
}
