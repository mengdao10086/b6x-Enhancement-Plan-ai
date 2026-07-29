package z7;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public class v0 extends y7.b implements View.OnClickListener {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f57903x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f57904y = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f57905p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f57906q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f57907r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Button f57908s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Button f57909t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f57910u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView f57911v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f57912w;

    public v0(Context context, String str) {
        super(context, (y7.n) null, true);
        this.f57905p = str;
    }

    public void B(int i10) {
        if (i10 == 0) {
            this.f57906q.setText(this.f56478a.getString(R.string.floatview_game_config_notice_for_no_recomm_config));
            this.f57907r.setImageResource(R.drawable.float_view_icon_notice_setting_config);
        } else if (i10 == 1) {
            this.f57906q.setText(this.f56478a.getString(R.string.floatview_game_config_notice_for_unsuited_ratio));
            this.f57907r.setImageResource(R.drawable.float_view_icon_notice_config_unsuited);
        }
    }

    public final void C() {
        boolean zBooleanValue = ((Boolean) this.f57910u.getTag()).booleanValue();
        o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_VIEW_NOTICE_GAME_CONFIG_RATIO_PERFIX + this.f57905p, zBooleanValue, true);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_notice_for_config_ratio;
    }

    @Override // y7.b
    public void n() {
        this.f57906q = (TextView) this.f56479b.findViewById(R.id.tv_desc);
        this.f57908s = (Button) this.f56479b.findViewById(R.id.btn_cancel);
        View viewFindViewById = this.f56479b.findViewById(R.id.layout_cancel_notice);
        this.f57910u = viewFindViewById;
        viewFindViewById.setTag(Boolean.FALSE);
        this.f57911v = (ImageView) this.f56479b.findViewById(R.id.iv_cancel_notice);
        this.f57912w = (TextView) this.f56479b.findViewById(R.id.tv_notice_desc);
        this.f57907r = (ImageView) this.f56479b.findViewById(R.id.iv_setting);
        this.f57909t = (Button) this.f56479b.findViewById(R.id.btn_ok);
        this.f57908s.setOnClickListener(this);
        this.f57909t.setOnClickListener(this);
        this.f57910u.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57908s) {
            C();
            h();
            return;
        }
        View view2 = this.f57910u;
        if (view != view2) {
            if (view == this.f57909t) {
                C();
                h();
                h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, u7.b.f51951d).navigation();
                return;
            }
            return;
        }
        if (((Boolean) view2.getTag()).booleanValue()) {
            this.f57911v.setImageResource(R.drawable.float_view_icon_checkbox_green_no);
            this.f57912w.setTextColor(this.f56478a.getResources().getColor(R.color.color_ffffff_a50));
            this.f57910u.setTag(Boolean.FALSE);
        } else {
            this.f57911v.setImageResource(R.drawable.float_view_icon_checkbox_green_yes);
            this.f57912w.setTextColor(this.f56478a.getResources().getColor(R.color.colorPrimary));
            this.f57910u.setTag(Boolean.TRUE);
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
