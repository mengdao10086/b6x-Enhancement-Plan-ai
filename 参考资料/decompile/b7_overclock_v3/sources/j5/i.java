package j5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f36101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ImageView f36102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Button f36103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final EditText f36104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final TextView f36105e;

    public i(@n0 ConstraintLayout constraintLayout, @n0 ImageView imageView, @n0 Button button, @n0 EditText editText, @n0 TextView textView) {
        this.f36101a = constraintLayout;
        this.f36102b = imageView;
        this.f36103c = button;
        this.f36104d = editText;
        this.f36105e = textView;
    }

    @n0
    public static i a(@n0 View view) {
        int i10 = R.id.btn_close;
        ImageView imageView = (ImageView) j2.c.a(view, i10);
        if (imageView != null) {
            i10 = R.id.btn_submit;
            Button button = (Button) j2.c.a(view, i10);
            if (button != null) {
                i10 = R.id.et_text;
                EditText editText = (EditText) j2.c.a(view, i10);
                if (editText != null) {
                    i10 = R.id.tv_title;
                    TextView textView = (TextView) j2.c.a(view, i10);
                    if (textView != null) {
                        return new i((ConstraintLayout) view, imageView, button, editText, textView);
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
        View viewInflate = layoutInflater.inflate(R.layout.base_layout_edittext_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f36101a;
    }
}
