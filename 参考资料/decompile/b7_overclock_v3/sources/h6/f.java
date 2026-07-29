package h6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.cyberfox.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f30579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextView f30580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final SuperButton f30581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final TextView f30582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f30583e;

    public f(@n0 ConstraintLayout constraintLayout, @n0 TextView textView, @n0 SuperButton superButton, @n0 TextView textView2, @n0 TextView textView3) {
        this.f30579a = constraintLayout;
        this.f30580b = textView;
        this.f30581c = superButton;
        this.f30582d = textView2;
        this.f30583e = textView3;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.iv_result;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.tv_message;
                TextView textView2 = (TextView) j2.c.a(view, i10);
                if (textView2 != null) {
                    i10 = R.id.tv_result;
                    TextView textView3 = (TextView) j2.c.a(view, i10);
                    if (textView3 != null) {
                        return new f((ConstraintLayout) view, textView, superButton, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.cf_activity_firmware_upgrade_result, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f30579a;
    }
}
