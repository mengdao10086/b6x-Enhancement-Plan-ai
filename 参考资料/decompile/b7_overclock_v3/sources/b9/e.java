package b9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fdg.flashplay.farsef.R;
import com.flydigi.base.widget.ratingbar.CBRatingBar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final FrameLayout f9154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextInputLayout f9155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SuperButton f9156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f9157d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final CBRatingBar f9158e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final TextInputEditText f9159f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final TextView f9160g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final TextView f9161h;

    public e(@n0 FrameLayout frameLayout, @n0 TextInputLayout textInputLayout, @n0 SuperButton superButton, @n0 Button button, @n0 CBRatingBar cBRatingBar, @n0 TextInputEditText textInputEditText, @n0 TextView textView, @n0 TextView textView2) {
        this.f9154a = frameLayout;
        this.f9155b = textInputLayout;
        this.f9156c = superButton;
        this.f9157d = button;
        this.f9158e = cBRatingBar;
        this.f9159f = textInputEditText;
        this.f9160g = textView;
        this.f9161h = textView2;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.area_content;
        TextInputLayout textInputLayout = (TextInputLayout) j2.c.a(view, R.id.area_content);
        if (textInputLayout != null) {
            i10 = R.id.btn_close;
            SuperButton superButton = (SuperButton) j2.c.a(view, R.id.btn_close);
            if (superButton != null) {
                i10 = R.id.btn_submit;
                Button button = (Button) j2.c.a(view, R.id.btn_submit);
                if (button != null) {
                    i10 = R.id.cb_rating_bar;
                    CBRatingBar cBRatingBar = (CBRatingBar) j2.c.a(view, R.id.cb_rating_bar);
                    if (cBRatingBar != null) {
                        i10 = R.id.et_content;
                        TextInputEditText textInputEditText = (TextInputEditText) j2.c.a(view, R.id.et_content);
                        if (textInputEditText != null) {
                            i10 = R.id.tv_level;
                            TextView textView = (TextView) j2.c.a(view, R.id.tv_level);
                            if (textView != null) {
                                i10 = R.id.tv_title;
                                TextView textView2 = (TextView) j2.c.a(view, R.id.tv_title);
                                if (textView2 != null) {
                                    return new e((FrameLayout) view, textInputLayout, superButton, button, cBRatingBar, textInputEditText, textView, textView2);
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
        View viewInflate = layoutInflater.inflate(R.layout.main_dialog_customer_service_evaluate, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9154a;
    }
}
