package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.flydigi.account.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f26050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f26051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f26052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f26053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f26054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f26055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final EditText f26056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final EditText f26057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final EditText f26058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final SuperButton f26059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final SuperButton f26060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ImageView f26061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final Button f26062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final TextView f26063n;

    public f(@n0 NestedScrollView nestedScrollView, @n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout3, @n0 Button button, @n0 EditText editText, @n0 EditText editText2, @n0 EditText editText3, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 ImageView imageView, @n0 Button button2, @n0 TextView textView) {
        this.f26050a = nestedScrollView;
        this.f26051b = linearLayout;
        this.f26052c = linearLayout2;
        this.f26053d = constraintLayout;
        this.f26054e = linearLayout3;
        this.f26055f = button;
        this.f26056g = editText;
        this.f26057h = editText2;
        this.f26058i = editText3;
        this.f26059j = superButton;
        this.f26060k = superButton2;
        this.f26061l = imageView;
        this.f26062m = button2;
        this.f26063n = textView;
    }

    @n0
    public static f a(@n0 View view) {
        int i10 = R.id.area_account;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_password;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.area_reset_password;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.area_verify_code;
                    LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R.id.btn_reset;
                        Button button = (Button) j2.c.a(view, i10);
                        if (button != null) {
                            i10 = R.id.et_account;
                            EditText editText = (EditText) j2.c.a(view, i10);
                            if (editText != null) {
                                i10 = R.id.et_password;
                                EditText editText2 = (EditText) j2.c.a(view, i10);
                                if (editText2 != null) {
                                    i10 = R.id.et_verify_code;
                                    EditText editText3 = (EditText) j2.c.a(view, i10);
                                    if (editText3 != null) {
                                        i10 = R.id.iv_clear_account;
                                        SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                                        if (superButton != null) {
                                            i10 = R.id.iv_clear_password;
                                            SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                                            if (superButton2 != null) {
                                                i10 = R.id.iv_show_password;
                                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                                if (imageView != null) {
                                                    i10 = R.id.tv_get_verify_code;
                                                    Button button2 = (Button) j2.c.a(view, i10);
                                                    if (button2 != null) {
                                                        i10 = R.id.tv_message;
                                                        TextView textView = (TextView) j2.c.a(view, i10);
                                                        if (textView != null) {
                                                            return new f((NestedScrollView) view, linearLayout, linearLayout2, constraintLayout, linearLayout3, button, editText, editText2, editText3, superButton, superButton2, imageView, button2, textView);
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
    public static f c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static f d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_fragment_reset_password, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f26050a;
    }
}
