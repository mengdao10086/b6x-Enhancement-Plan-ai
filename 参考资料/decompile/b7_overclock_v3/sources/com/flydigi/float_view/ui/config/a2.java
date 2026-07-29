package com.flydigi.float_view.ui.config;

import android.content.Context;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flydigi.data.DataConstant;
import com.flydigi.float_view.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class a2 extends y7.b implements View.OnClickListener {
    public TextView A;
    public View B;
    public TextView C;
    public View C1;
    public View C2;
    public View D;
    public o8.a E7;
    public int F7;
    public float G7;
    public float H7;
    public float I7;
    public float J7;
    public ImageView K0;
    public View K1;
    public View K2;
    public final boolean K7;
    public o8.a L7;
    public View.OnTouchListener M7;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public View f15563k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public View f15564k1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RelativeLayout f15565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f15566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f15567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f15568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f15569t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f15570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f15571v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public TextView f15572v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f15573v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ImageView f15574w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f15575x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f15576y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f15577z;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            o8.a aVar = (o8.a) view;
            int action = motionEvent.getAction();
            if (action == 0) {
                if (a2.this.L7 != null && a2.this.L7 != aVar) {
                    a2.this.L7.setScaleX(1.0f);
                    a2.this.L7.setScaleY(1.0f);
                    a2.this.L7 = null;
                }
                a2.this.L7 = aVar;
                view.setScaleX(2.5f);
                view.setScaleY(2.5f);
                a2.this.G7 = motionEvent.getRawX();
                a2.this.H7 = motionEvent.getRawY();
                a2.this.I7 = motionEvent.getRawX() - view.getX();
                a2.this.J7 = motionEvent.getRawY() - view.getY();
                a2.this.C2.setY((motionEvent.getRawY() - a2.this.J7) + (view.getHeight() / 2));
                a2.this.K2.setX((motionEvent.getRawX() - a2.this.I7) + (view.getWidth() / 2));
                if (a2.this.f15573v2 == 1) {
                    a2.this.B.setVisibility(4);
                } else if (a2.this.f15573v2 == 2) {
                    a2.this.K1.setVisibility(4);
                }
            } else if (action == 1) {
                float rawX = (motionEvent.getRawX() - a2.this.I7) + (view.getWidth() / 2);
                float rawY = (motionEvent.getRawY() - a2.this.J7) + (view.getHeight() / 2);
                if (a2.this.f15573v2 == 1) {
                    float x10 = a2.this.D.getX();
                    float x11 = a2.this.D.getX() + a2.this.D.getWidth();
                    float y10 = a2.this.D.getY();
                    float y11 = a2.this.D.getY() + a2.this.D.getHeight();
                    if (rawX <= x10 || rawX >= x11 || rawY <= y10 || rawY >= y11) {
                        aVar.setX(aVar.getX0());
                        aVar.setY(aVar.getY0());
                        aVar.setScaleX(1.0f);
                        aVar.setScaleY(1.0f);
                        a2.this.B.setVisibility(0);
                        a2.this.C2.setY(aVar.getY0() + (a2.this.F7 / 2));
                        a2.this.K2.setX(aVar.getX0() + (a2.this.F7 / 2));
                    } else {
                        a2.this.B.setVisibility(4);
                        a2.this.C.setVisibility(4);
                        a2.this.D.setVisibility(4);
                        a2.this.K0.setVisibility(4);
                        a2.this.f15564k1.setVisibility(0);
                        a2.this.f15572v1.setVisibility(0);
                        a2.this.E7.setX0((a2.this.K1.getX() + (a2.this.K1.getWidth() / 2)) - (a2.this.F7 / 2));
                        a2.this.E7.setY0((a2.this.K1.getY() + (a2.this.K1.getWidth() / 2)) - (a2.this.F7 / 2));
                        a2.this.E7.setX((a2.this.K1.getX() + (a2.this.K1.getWidth() / 2)) - (a2.this.F7 / 2));
                        a2.this.E7.setY((a2.this.K1.getY() + (a2.this.K1.getWidth() / 2)) - (a2.this.F7 / 2));
                        a2.this.C2.setY(a2.this.K1.getY() + (a2.this.K1.getWidth() / 2));
                        a2.this.K2.setX(a2.this.K1.getX() + (a2.this.K1.getWidth() / 2));
                        a2.this.f15573v2 = 2;
                        if (!a2.this.f15566q) {
                            HashMap map = new HashMap();
                            map.put("action", "调整配置引导-对齐按键");
                            u9.g.a().e(a2.this.f56478a, "Float_View_Teach_Guide", map);
                        }
                    }
                    return false;
                }
                if (a2.this.f15573v2 == 2) {
                    float x12 = a2.this.C1.getX();
                    float x13 = a2.this.C1.getX() + a2.this.C1.getWidth();
                    float y12 = a2.this.C1.getY();
                    float y13 = a2.this.C1.getY() + a2.this.C1.getHeight();
                    if (rawX <= x12 || rawX >= x13 || rawY <= y12 || rawY >= y13) {
                        aVar.setX(aVar.getX0());
                        aVar.setY(aVar.getY0());
                        a2.this.K1.setVisibility(0);
                        a2.this.C2.setY(aVar.getY0() + (a2.this.F7 / 2));
                        a2.this.K2.setX(aVar.getX0() + (a2.this.F7 / 2));
                    } else {
                        a2.this.f15564k1.setVisibility(4);
                        a2.this.f15572v1.setVisibility(4);
                        aVar.setScaleX(1.0f);
                        aVar.setScaleY(1.0f);
                        o5.m.k(DataConstant.SP_MAIN).y(DataConstant.SP_NAME_SUB_IS_FINISH_SETTINGCONFIG_GUIDE, 1, true);
                        a2.this.h();
                    }
                    return false;
                }
            } else if (action == 2) {
                if (Math.abs(motionEvent.getRawX() - a2.this.G7) > a2.this.f15568s * 5.0f || Math.abs(motionEvent.getRawY() - a2.this.H7) > a2.this.f15568s * 5.0f) {
                    a2.this.C2.setVisibility(0);
                    a2.this.K2.setVisibility(0);
                }
                float f10 = a2.this.f15569t;
                float f11 = a2.this.f15570u;
                float rawX2 = (motionEvent.getRawX() - a2.this.I7) + (view.getWidth() / 2);
                float rawY2 = (motionEvent.getRawY() - a2.this.J7) + (view.getHeight() / 2);
                if (0.0f < rawX2 && rawX2 < f10 && 0.0f < rawY2 && rawY2 < f11) {
                    view.setX(motionEvent.getRawX() - a2.this.I7);
                    view.setY(motionEvent.getRawY() - a2.this.J7);
                    a2.this.C2.setY((motionEvent.getRawY() - a2.this.J7) + (view.getHeight() / 2));
                    a2.this.K2.setX((motionEvent.getRawX() - a2.this.I7) + (view.getWidth() / 2));
                }
            }
            return false;
        }
    }

    public interface b {
        void a();
    }

    public a2(Context context, boolean z10, int i10, int i11, int i12, float f10, b bVar) {
        super(context);
        this.A = null;
        this.C = null;
        this.D = null;
        this.f15572v1 = null;
        this.C1 = null;
        this.f15573v2 = 0;
        this.C2 = null;
        this.K2 = null;
        this.F7 = 0;
        this.G7 = 0.0f;
        this.H7 = 0.0f;
        this.I7 = 0.0f;
        this.J7 = 0.0f;
        this.K7 = false;
        this.L7 = null;
        this.M7 = new a();
        this.f15566q = z10;
        this.f15567r = i10;
        this.f15569t = i11;
        this.f15570u = i12;
        this.f15568s = f10;
        this.f15571v = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0() {
        this.E7 = new o8.a(this.f56478a);
        int i10 = this.F7;
        this.E7.setLayoutParams(new RelativeLayout.LayoutParams(i10, i10));
        this.E7.setX0((this.f15563k0.getX() + (this.f15563k0.getWidth() / 2)) - (this.F7 / 2));
        this.E7.setY0((this.f15563k0.getY() + (this.f15563k0.getWidth() / 2)) - (this.F7 / 2));
        this.E7.setX((this.f15563k0.getX() + (this.f15563k0.getWidth() / 2)) - (this.F7 / 2));
        this.E7.setY((this.f15563k0.getY() + (this.f15563k0.getWidth() / 2)) - (this.F7 / 2));
        this.E7.setVisibility(4);
        this.E7.setClickable(true);
        this.E7.setOnTouchListener(this.M7);
        int i11 = this.f15567r;
        if (i11 == 0) {
            this.f15563k0.setBackgroundResource(R.drawable.floating_guide_circle_big_blue_unreal_gp_a);
            this.E7.setBackgroundResource(R.drawable.flymapping_gp_front_a);
            this.D.setBackgroundResource(R.drawable.floating_guide_circle_targer_a);
        } else if (i11 == 1) {
            this.f15563k0.setBackgroundResource(R.drawable.floating_guide_circle_big_blue_unreal_km_mouseleft);
            this.E7.setBackgroundResource(R.drawable.flymapping_km_front_leftmouse);
            this.D.setBackgroundResource(R.drawable.floating_guide_circle_targer_mouseleft);
        } else if (i11 == 2) {
            this.f15563k0.setBackgroundResource(R.drawable.floating_guide_circle_big_blue_unreal_gp_a);
            this.E7.setBackgroundResource(R.drawable.flymapping_gp_front_a);
            this.D.setBackgroundResource(R.drawable.floating_guide_circle_targer_a);
        }
        this.f15565p.addView(this.E7);
    }

    @Override // y7.b
    public int i() {
        return R.layout.floatview_layout_setting_config_teach;
    }

    @Override // y7.b
    public void n() {
        this.f15565p = (RelativeLayout) this.f56479b.findViewById(R.id.rl_root);
        this.f15576y = this.f56479b.findViewById(R.id.layout_guide_step_0);
        this.A = (TextView) this.f56479b.findViewById(R.id.layout_guide_step_0_tv);
        ImageView imageView = (ImageView) this.f56479b.findViewById(R.id.iv_step_0);
        this.f15577z = imageView;
        com.bumptech.glide.b.F(imageView).p(Integer.valueOf(R.drawable.floating_guide_bg_device)).s1(this.f15577z);
        this.f15576y.setVisibility(0);
        this.A.setVisibility(0);
        this.B = this.f56479b.findViewById(R.id.layout_guide_step_1);
        this.C = (TextView) this.f56479b.findViewById(R.id.layout_guide_step_1_tv);
        this.K0 = (ImageView) this.f56479b.findViewById(R.id.iv_step_1);
        com.bumptech.glide.b.F(this.f15577z).p(Integer.valueOf(R.drawable.floating_guide_hand_move)).s1(this.K0);
        this.f15563k0 = this.f56479b.findViewById(R.id.layout_guide_step_1_center);
        this.D = this.f56479b.findViewById(R.id.layout_guide_step_1_target);
        this.B.setVisibility(4);
        this.C.setVisibility(4);
        this.D.setVisibility(4);
        this.K0.setVisibility(4);
        this.f15564k1 = this.f56479b.findViewById(R.id.layout_guide_step_2);
        this.K1 = this.f56479b.findViewById(R.id.layout_guide_step_2_center);
        this.f15572v1 = (TextView) this.f56479b.findViewById(R.id.layout_guide_step_2_tv);
        this.C1 = this.f56479b.findViewById(R.id.layout_guide_step_2_target);
        this.f15564k1.setVisibility(4);
        this.f15572v1.setVisibility(4);
        this.A.setText(Html.fromHtml(this.f56478a.getString(R.string.floatview_pressed_key_touch_screen)));
        this.C.setText(Html.fromHtml(this.f56478a.getString(R.string.floatview_setting_config_guide_notice_1)));
        this.f15572v1.setText(Html.fromHtml(this.f56478a.getString(R.string.floatview_setting_config_guide_notice_2)));
        this.C2 = this.f56479b.findViewById(R.id.layout_guide_line_x);
        this.K2 = this.f56479b.findViewById(R.id.layout_guide_line_y);
        this.C2.setVisibility(4);
        this.K2.setVisibility(4);
        ImageView imageView2 = (ImageView) this.f56479b.findViewById(R.id.iv_guide_finish);
        this.f15574w = imageView2;
        imageView2.setOnClickListener(this);
        TextView textView = (TextView) this.f56479b.findViewById(R.id.tv_start_guide);
        this.f15575x = textView;
        textView.setText(Html.fromHtml(this.f56478a.getString(R.string.floatview_start_guide)));
        this.f15575x.setOnClickListener(this);
        this.F7 = (int) (this.f15568s * 45.0f);
        this.f15563k0.post(new Runnable() { // from class: com.flydigi.float_view.ui.config.z1
            @Override // java.lang.Runnable
            public final void run() {
                this.f15749a.g0();
            }
        });
        y();
        if (this.f15566q) {
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "调整配置引导-开始引导");
        u9.g.a().e(this.f56478a, "Float_View_Teach_Guide", map);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f15574w) {
            if (!this.f15566q) {
                int i10 = this.f15573v2;
                String str = i10 != 0 ? i10 != 1 ? i10 != 2 ? "" : "调整配置引导-对齐按键-跳过" : "调整配置引导-拖动按键-跳过" : "调整配置引导-开始引导-跳过";
                HashMap map = new HashMap();
                map.put("action", str);
                u9.g.a().e(this.f56478a, "Float_View_Teach_Guide", map);
            }
            b bVar = this.f15571v;
            if (bVar != null) {
                bVar.a();
            }
            o5.m.k(DataConstant.SP_MAIN).y(DataConstant.SP_NAME_SUB_IS_FINISH_SETTINGCONFIG_GUIDE, 1, true);
            h();
            return;
        }
        if (view == this.f15575x) {
            this.f15576y.setVisibility(4);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            this.K0.setVisibility(0);
            this.C2.setVisibility(0);
            this.K2.setVisibility(0);
            this.C2.setY(this.f15563k0.getY() + (this.f15563k0.getWidth() / 2));
            this.K2.setX(this.f15563k0.getX() + (this.f15563k0.getWidth() / 2));
            this.E7.setVisibility(0);
            this.f15573v2 = 1;
            if (this.f15566q) {
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("action", "调整配置引导-拖动按键");
            u9.g.a().e(this.f56478a, "Float_View_Teach_Guide", map2);
        }
    }

    @Override // y7.b
    public WindowManager.LayoutParams p() {
        WindowManager.LayoutParams layoutParamsH = n8.b.h(1);
        layoutParamsH.gravity = 8388659;
        return layoutParamsH;
    }
}
