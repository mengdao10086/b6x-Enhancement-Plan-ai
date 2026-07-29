package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.community.R;
import com.just.agentweb.AgentWebView;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f56339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final FrameLayout f56340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f56341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final AgentWebView f56342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final LinearLayout f56343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final RelativeLayout f56344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f56345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final SuperButton f56346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final SuperButton f56347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TagFlowLayout f56348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final TextView f56349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final TextView f56350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f56351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f56352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f56353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final ViewPager2 f56354q;

    public i(@n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout, @n0 FrameLayout frameLayout, @n0 TextView textView, @n0 AgentWebView agentWebView, @n0 LinearLayout linearLayout2, @n0 RelativeLayout relativeLayout, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 SuperButton superButton3, @n0 TagFlowLayout tagFlowLayout, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6, @n0 ViewPager2 viewPager2) {
        this.f56338a = constraintLayout;
        this.f56339b = linearLayout;
        this.f56340c = frameLayout;
        this.f56341d = textView;
        this.f56342e = agentWebView;
        this.f56343f = linearLayout2;
        this.f56344g = relativeLayout;
        this.f56345h = superButton;
        this.f56346i = superButton2;
        this.f56347j = superButton3;
        this.f56348k = tagFlowLayout;
        this.f56349l = textView2;
        this.f56350m = textView3;
        this.f56351n = textView4;
        this.f56352o = textView5;
        this.f56353p = textView6;
        this.f56354q = viewPager2;
    }

    @n0
    public static i a(@n0 View view) {
        int i10 = R.id.area_config;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_content;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.area_content_text;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.area_content_web;
                    AgentWebView agentWebView = (AgentWebView) j2.c.a(view, i10);
                    if (agentWebView != null) {
                        i10 = R.id.area_custom;
                        LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.area_media;
                            RelativeLayout relativeLayout = (RelativeLayout) j2.c.a(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.btn_download;
                                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                                if (superButton != null) {
                                    i10 = R.id.btn_like;
                                    SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                                    if (superButton2 != null) {
                                        i10 = R.id.btn_share;
                                        SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                                        if (superButton3 != null) {
                                            i10 = R.id.tag_topic;
                                            TagFlowLayout tagFlowLayout = (TagFlowLayout) j2.c.a(view, i10);
                                            if (tagFlowLayout != null) {
                                                i10 = R.id.tv_config_info;
                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                if (textView2 != null) {
                                                    i10 = R.id.tv_config_name;
                                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                                    if (textView3 != null) {
                                                        i10 = R.id.tv_indicator;
                                                        TextView textView4 = (TextView) j2.c.a(view, i10);
                                                        if (textView4 != null) {
                                                            i10 = R.id.tv_time;
                                                            TextView textView5 = (TextView) j2.c.a(view, i10);
                                                            if (textView5 != null) {
                                                                i10 = R.id.tv_title;
                                                                TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                if (textView6 != null) {
                                                                    i10 = R.id.view_pager;
                                                                    ViewPager2 viewPager2 = (ViewPager2) j2.c.a(view, i10);
                                                                    if (viewPager2 != null) {
                                                                        return new i((ConstraintLayout) view, linearLayout, frameLayout, textView, agentWebView, linearLayout2, relativeLayout, superButton, superButton2, superButton3, tagFlowLayout, textView2, textView3, textView4, textView5, textView6, viewPager2);
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
    public static i c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static i d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_fragment_article_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56338a;
    }
}
