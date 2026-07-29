package y5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.community.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f56330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final EditText f56331b;

    public g(@n0 ConstraintLayout constraintLayout, @n0 EditText editText) {
        this.f56330a = constraintLayout;
        this.f56331b = editText;
    }

    @n0
    public static g a(@n0 View view) {
        int i10 = R.id.editor;
        EditText editText = (EditText) j2.c.a(view, i10);
        if (editText != null) {
            return new g((ConstraintLayout) view, editText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static g c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static g d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.community_dialog_input_text, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f56330a;
    }
}
