package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.flydigi.account.R;
import com.google.android.material.textfield.TextInputEditText;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f26064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final TextInputEditText f26065b;

    public g(@n0 LinearLayout linearLayout, @n0 TextInputEditText textInputEditText) {
        this.f26064a = linearLayout;
        this.f26065b = textInputEditText;
    }

    @n0
    public static g a(@n0 View view) {
        int i10 = R.id.et_nickname;
        TextInputEditText textInputEditText = (TextInputEditText) j2.c.a(view, i10);
        if (textInputEditText != null) {
            return new g((LinearLayout) view, textInputEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static g c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static g d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_fragment_text_edit, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f26064a;
    }
}
