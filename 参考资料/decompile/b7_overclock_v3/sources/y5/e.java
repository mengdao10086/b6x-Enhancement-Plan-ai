package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.flydigi.community.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f56300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f56302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f56304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final SuperButton f56305f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final SuperButton f56306g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f56307h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final TextView f56308i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final EditText f56309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ImageView f56310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final RecyclerView f56311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final RecyclerView f56312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final SuperButton f56313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final SuperButton f56314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f56315p;

    public e(@n0 LinearLayout linearLayout, @n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout2, @n0 ConstraintLayout constraintLayout2, @n0 LinearLayout linearLayout3, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 SuperButton superButton3, @n0 TextView textView, @n0 EditText editText, @n0 ImageView imageView, @n0 RecyclerView recyclerView, @n0 RecyclerView recyclerView2, @n0 SuperButton superButton4, @n0 SuperButton superButton5, @n0 TextView textView2) {
        this.f56300a = linearLayout;
        this.f56301b = constraintLayout;
        this.f56302c = linearLayout2;
        this.f56303d = constraintLayout2;
        this.f56304e = linearLayout3;
        this.f56305f = superButton;
        this.f56306g = superButton2;
        this.f56307h = superButton3;
        this.f56308i = textView;
        this.f56309j = editText;
        this.f56310k = imageView;
        this.f56311l = recyclerView;
        this.f56312m = recyclerView2;
        this.f56313n = superButton4;
        this.f56314o = superButton5;
        this.f56315p = textView2;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.area_config;
        ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.area_config_title;
            LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout != null) {
                i10 = R.id.area_tag;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout2 != null) {
                    i10 = R.id.area_tag_title;
                    LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = R.id.btn_choose_config;
                        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                        if (superButton != null) {
                            i10 = R.id.btn_choose_topic;
                            SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                            if (superButton2 != null) {
                                i10 = R.id.btn_close;
                                SuperButton superButton3 = (SuperButton) j2.c.a(view, i10);
                                if (superButton3 != null) {
                                    i10 = R.id.btn_post;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        i10 = R.id.et_content;
                                        EditText editText = (EditText) j2.c.a(view, i10);
                                        if (editText != null) {
                                            i10 = R.id.iv_config_prefix;
                                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                                            if (imageView != null) {
                                                i10 = R.id.rv_hot_tag;
                                                RecyclerView recyclerView = (RecyclerView) j2.c.a(view, i10);
                                                if (recyclerView != null) {
                                                    i10 = R.id.rv_img_video;
                                                    RecyclerView recyclerView2 = (RecyclerView) j2.c.a(view, i10);
                                                    if (recyclerView2 != null) {
                                                        i10 = R.id.tv_config;
                                                        SuperButton superButton4 = (SuperButton) j2.c.a(view, i10);
                                                        if (superButton4 != null) {
                                                            i10 = R.id.tv_tag;
                                                            SuperButton superButton5 = (SuperButton) j2.c.a(view, i10);
                                                            if (superButton5 != null) {
                                                                i10 = R.id.tv_tag_prefix;
                                                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                if (textView2 != null) {
                                                                    return new e((LinearLayout) view, constraintLayout, linearLayout, constraintLayout2, linearLayout2, superButton, superButton2, superButton3, textView, editText, imageView, recyclerView, recyclerView2, superButton4, superButton5, textView2);
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
    public static e c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_activity_post, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f56300a;
    }
}
