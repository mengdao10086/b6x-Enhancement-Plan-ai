package z7;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.d1;
import com.flydigi.base.widget.IndicatorView;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.GameStrategyBean;
import com.flydigi.float_view.R;
import z7.k0;

/* JADX INFO: loaded from: classes7.dex */
public class i0 extends y7.b implements View.OnClickListener {
    public k0 A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f57834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f57835q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RelativeLayout f57836r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewPager f57837s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c1 f57838t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f57839u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final GameStrategyBean f57840v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f57841w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView f57842x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f57843y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public IndicatorView f57844z;

    public class a implements ViewPager.j {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            com.flydigi.base.common.n.a("flydigitestdata onPageSelected:" + i10);
            i0.this.f57844z.setCurrentStep(i10);
            if (i0.this.f57840v.config.get(i10).button.length() > 0) {
                i0.this.f57835q.setVisibility(0);
                i0.this.f57835q.setText(i0.this.f57840v.config.get(i10).button);
            } else {
                i0.this.f57835q.setVisibility(4);
            }
            if (i10 == 0) {
                i0.this.f57842x.setVisibility(4);
                i0.this.f57843y.setVisibility(0);
            } else if (i10 == i0.this.f57840v.config.size() - 1) {
                i0.this.f57842x.setVisibility(0);
                i0.this.f57843y.setVisibility(4);
            } else {
                i0.this.f57842x.setVisibility(0);
                i0.this.f57843y.setVisibility(0);
            }
        }
    }

    public class b implements k0.a {
        public b() {
        }

        @Override // z7.k0.a
        public void a() {
            i0.this.y();
        }
    }

    public i0(Context context, Handler handler, String str, boolean z10, GameStrategyBean gameStrategyBean, y7.n nVar) {
        super(context, nVar, handler);
        this.A = null;
        this.f57839u = str;
        this.f57841w = z10;
        this.f57840v = gameStrategyBean;
    }

    public final void G() {
        if (this.f57841w) {
            return;
        }
        if (d1.g(this.f57840v.pkgName)) {
            o5.m.l(DataConstant.SP_FLOAT, 2).G("sp_float_hide_game_strategy_prefix_common", true, true);
            return;
        }
        o5.m.l(DataConstant.SP_FLOAT, 2).G(DataConstant.SP_FLOAT_HIDE_GAME_STRATEGY_PREFIX + this.f57839u, true, true);
    }

    @Override // y7.b
    public void h() {
        super.h();
        k0 k0Var = this.A;
        if (k0Var != null) {
            k0Var.h();
            this.A = null;
        }
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_game_strategy;
    }

    @Override // y7.b
    public void n() {
        ImageView imageView = (ImageView) this.f56479b.findViewById(R.id.iv_close);
        this.f57834p = imageView;
        imageView.setOnClickListener(this);
        com.blankj.utilcode.util.o.z(this.f57834p, 100);
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_setting);
        this.f57835q = textView;
        textView.getPaint().setFlags(8);
        this.f57835q.getPaint().setAntiAlias(true);
        View view = this.f56479b;
        int i10 = R.id.iv_arrow_left;
        this.f57842x = (ImageView) view.findViewById(i10);
        View view2 = this.f56479b;
        int i11 = R.id.iv_arrow_right;
        this.f57843y = (ImageView) view2.findViewById(i11);
        this.f57842x = (ImageView) this.f56479b.findViewById(i10);
        this.f57843y = (ImageView) this.f56479b.findViewById(i11);
        this.f57836r = (RelativeLayout) this.f56479b.findViewById(R.id.fl_progress);
        this.f57837s = (ViewPager) this.f56479b.findViewById(R.id.viewpager);
        c1 c1Var = new c1(this.f56478a, this.f57840v.config);
        this.f57838t = c1Var;
        this.f57837s.setAdapter(c1Var);
        this.f57837s.setOnPageChangeListener(new a());
        IndicatorView indicatorView = (IndicatorView) this.f56479b.findViewById(R.id.indicator_view);
        this.f57844z = indicatorView;
        indicatorView.setStepsNumber(this.f57840v.config.size());
        this.f57844z.setCurrentStep(0);
        this.f57842x.setVisibility(4);
        this.f57843y.setVisibility(4);
        this.f57844z.setVisibility(4);
        if (this.f57840v.config.size() > 1) {
            this.f57843y.setVisibility(0);
            this.f57844z.setVisibility(0);
        }
        if (this.f57840v.config.get(0).button.length() > 0) {
            this.f57835q.setVisibility(0);
            this.f57835q.setText(this.f57840v.config.get(0).button);
        } else {
            this.f57835q.setVisibility(4);
        }
        this.f57835q.setOnClickListener(this);
        this.f57842x.setOnClickListener(this);
        this.f57843y.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f57834p) {
            G();
            r(19, 8);
            return;
        }
        if (view == this.f57835q) {
            if (this.f57837s.getCurrentItem() == this.f57840v.config.size() - 1) {
                G();
                r(19, 8);
                return;
            } else {
                l();
                this.A = new k0(this.f56478a, new b());
                return;
            }
        }
        if (view == this.f57842x) {
            int currentItem = this.f57837s.getCurrentItem() - 1;
            this.f57837s.setCurrentItem(currentItem);
            this.f57844z.setCurrentStep(currentItem);
        } else if (view == this.f57843y) {
            int currentItem2 = this.f57837s.getCurrentItem() + 1;
            this.f57837s.setCurrentItem(currentItem2);
            this.f57844z.setCurrentStep(currentItem2);
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 17;
        return layoutParamsH;
    }
}
