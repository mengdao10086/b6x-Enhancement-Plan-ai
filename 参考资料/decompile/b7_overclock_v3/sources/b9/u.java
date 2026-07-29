package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.widget.OperateView;
import com.google.android.material.imageview.ShapeableImageView;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f9246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f9247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SuperButton f9248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f9249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ShapeableImageView f9250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f9251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final OperateView f9252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final OperateView f9253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final OperateView f9254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final OperateView f9255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final OperateView f9256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final OperateView f9257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final OperateView f9258m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final OperateView f9259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final OperateView f9260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f9261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final TextView f9262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final TextView f9263r;

    public u(@n0 NestedScrollView nestedScrollView, @n0 LinearLayout linearLayout, @n0 SuperButton superButton, @n0 TextView textView, @n0 ShapeableImageView shapeableImageView, @n0 LinearLayout linearLayout2, @n0 OperateView operateView, @n0 OperateView operateView2, @n0 OperateView operateView3, @n0 OperateView operateView4, @n0 OperateView operateView5, @n0 OperateView operateView6, @n0 OperateView operateView7, @n0 OperateView operateView8, @n0 OperateView operateView9, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4) {
        this.f9246a = nestedScrollView;
        this.f9247b = linearLayout;
        this.f9248c = superButton;
        this.f9249d = textView;
        this.f9250e = shapeableImageView;
        this.f9251f = linearLayout2;
        this.f9252g = operateView;
        this.f9253h = operateView2;
        this.f9254i = operateView3;
        this.f9255j = operateView4;
        this.f9256k = operateView5;
        this.f9257l = operateView6;
        this.f9258m = operateView7;
        this.f9259n = operateView8;
        this.f9260o = operateView9;
        this.f9261p = textView2;
        this.f9262q = textView3;
        this.f9263r = textView4;
    }

    @n0
    public static u a(@n0 View view) {
        int i10 = R.id.area_wechat_account;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, R.id.area_wechat_account);
        if (linearLayout != null) {
            i10 = R.id.btn_close;
            SuperButton superButton = (SuperButton) j2.c.a(view, R.id.btn_close);
            if (superButton != null) {
                i10 = R.id.btn_follow;
                TextView textView = (TextView) j2.c.a(view, R.id.btn_follow);
                if (textView != null) {
                    i10 = R.id.civ_avatar;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) j2.c.a(view, R.id.civ_avatar);
                    if (shapeableImageView != null) {
                        i10 = R.id.ll_login_register;
                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, R.id.ll_login_register);
                        if (linearLayout2 != null) {
                            i10 = R.id.ov_about_phone;
                            OperateView operateView = (OperateView) j2.c.a(view, R.id.ov_about_phone);
                            if (operateView != null) {
                                i10 = R.id.ov_check_upgrade;
                                OperateView operateView2 = (OperateView) j2.c.a(view, R.id.ov_check_upgrade);
                                if (operateView2 != null) {
                                    i10 = R.id.ov_config_sync;
                                    OperateView operateView3 = (OperateView) j2.c.a(view, R.id.ov_config_sync);
                                    if (operateView3 != null) {
                                        i10 = R.id.ov_contact_us;
                                        OperateView operateView4 = (OperateView) j2.c.a(view, R.id.ov_contact_us);
                                        if (operateView4 != null) {
                                            i10 = R.id.ov_my_message;
                                            OperateView operateView5 = (OperateView) j2.c.a(view, R.id.ov_my_message);
                                            if (operateView5 != null) {
                                                i10 = R.id.ov_my_published_article;
                                                OperateView operateView6 = (OperateView) j2.c.a(view, R.id.ov_my_published_article);
                                                if (operateView6 != null) {
                                                    i10 = R.id.ov_my_shared_config;
                                                    OperateView operateView7 = (OperateView) j2.c.a(view, R.id.ov_my_shared_config);
                                                    if (operateView7 != null) {
                                                        i10 = R.id.ov_my_zan;
                                                        OperateView operateView8 = (OperateView) j2.c.a(view, R.id.ov_my_zan);
                                                        if (operateView8 != null) {
                                                            i10 = R.id.ov_setting;
                                                            OperateView operateView9 = (OperateView) j2.c.a(view, R.id.ov_setting);
                                                            if (operateView9 != null) {
                                                                i10 = R.id.tv_login;
                                                                TextView textView2 = (TextView) j2.c.a(view, R.id.tv_login);
                                                                if (textView2 != null) {
                                                                    i10 = R.id.tv_register;
                                                                    TextView textView3 = (TextView) j2.c.a(view, R.id.tv_register);
                                                                    if (textView3 != null) {
                                                                        i10 = R.id.tv_username;
                                                                        TextView textView4 = (TextView) j2.c.a(view, R.id.tv_username);
                                                                        if (textView4 != null) {
                                                                            return new u((NestedScrollView) view, linearLayout, superButton, textView, shapeableImageView, linearLayout2, operateView, operateView2, operateView3, operateView4, operateView5, operateView6, operateView7, operateView8, operateView9, textView2, textView3, textView4);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static u c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static u d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.main_layout_fragment_main_account, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f9246a;
    }
}
