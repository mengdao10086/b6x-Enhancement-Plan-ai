package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import cn.jzvd.JzvdStd;
import com.flydigi.base.widget.TagFlowLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f56398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final FrameLayout f56399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RecyclerView f56400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ImageView f56401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final JzvdStd f56403g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f56404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final SuperButton f56405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final SuperButton f56406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final SuperButton f56407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ImageView f56408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final ImageView f56409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TagFlowLayout f56410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final TextView f56411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f56412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final TextView f56413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final TextView f56414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @n0
    public final TextView f56415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @n0
    public final TextView f56416t;

    public p(@n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout, @n0 FrameLayout frameLayout, @n0 RecyclerView recyclerView, @n0 ImageView imageView, @n0 ConstraintLayout constraintLayout2, @n0 JzvdStd jzvdStd, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 SuperButton superButton3, @n0 SuperButton superButton4, @n0 ImageView imageView2, @n0 ImageView imageView3, @n0 TagFlowLayout tagFlowLayout, @n0 TextView textView, @n0 TextView textView2, @n0 TextView textView3, @n0 TextView textView4, @n0 TextView textView5, @n0 TextView textView6) {
        this.f56397a = constraintLayout;
        this.f56398b = linearLayout;
        this.f56399c = frameLayout;
        this.f56400d = recyclerView;
        this.f56401e = imageView;
        this.f56402f = constraintLayout2;
        this.f56403g = jzvdStd;
        this.f56404h = superButton;
        this.f56405i = superButton2;
        this.f56406j = superButton3;
        this.f56407k = superButton4;
        this.f56408l = imageView2;
        this.f56409m = imageView3;
        this.f56410n = tagFlowLayout;
        this.f56411o = textView;
        this.f56412p = textView2;
        this.f56413q = textView3;
        this.f56414r = textView4;
        this.f56415s = textView5;
        this.f56416t = textView6;
    }

    @n0
    public static p a(@n0 View view) {
        int i10 = R.id.area_config;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_image;
            FrameLayout frameLayout = (FrameLayout) j2.c.a(view, i10);
            if (frameLayout != null) {
                i10 = R.id.area_image_multi;
                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.area_image_single;
                    ImageView imageView = (ImageView) j2.c.a(view, i10);
                    if (imageView != null) {
                        i10 = R.id.area_media;
                        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                        if (constraintLayout != null) {
                            i10 = R.id.area_video;
                            JzvdStd jzvdStd = (JzvdStd) j2.c.a(view, i10);
                            if (jzvdStd != null) {
                                i10 = R.id.btn_comment;
                                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                                if (superButton != null) {
                                    i10 = R.id.btn_download;
                                    SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                                    if (superButton2 != null) {
                                        i10 = R.id.btn_like;
                                        SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                                        if (superButton3 != null) {
                                            i10 = R.id.btn_share;
                                            SuperButton superButton4 = (SuperButton) j2.c.a(view, i10);
                                            if (superButton4 != null) {
                                                i10 = R.id.iv_avatar;
                                                ImageView imageView2 = (ImageView) j2.c.a(view, i10);
                                                if (imageView2 != null) {
                                                    i10 = R.id.iv_user_mark;
                                                    ImageView imageView3 = (ImageView) j2.c.a(view, i10);
                                                    if (imageView3 != null) {
                                                        i10 = R.id.tag_topic;
                                                        TagFlowLayout tagFlowLayout = (TagFlowLayout) j2.c.a(view, i10);
                                                        if (tagFlowLayout != null) {
                                                            i10 = R.id.tv_config_info;
                                                            TextView textView = (TextView) j2.c.a(view, i10);
                                                            if (textView != null) {
                                                                i10 = R.id.tv_config_name;
                                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                if (textView2 != null) {
                                                                    i10 = R.id.tv_content;
                                                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                                                    if (textView3 != null) {
                                                                        i10 = R.id.tv_update_time;
                                                                        TextView textView4 = (TextView) j2.c.a(view, i10);
                                                                        if (textView4 != null) {
                                                                            i10 = R.id.tv_user_mark;
                                                                            TextView textView5 = (TextView) j2.c.a(view, i10);
                                                                            if (textView5 != null) {
                                                                                i10 = R.id.tv_user_name;
                                                                                TextView textView6 = (TextView) j2.c.a(view, i10);
                                                                                if (textView6 != null) {
                                                                                    return new p((ConstraintLayout) view, linearLayout, frameLayout, recyclerView, imageView, constraintLayout, jzvdStd, superButton, superButton2, superButton3, superButton4, imageView2, imageView3, tagFlowLayout, textView, textView2, textView3, textView4, textView5, textView6);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static p c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static p d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_item_article, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56397a;
    }
}
