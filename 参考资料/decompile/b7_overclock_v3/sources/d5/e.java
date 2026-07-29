package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
public final class e implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f26032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f26033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f26034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ConstraintLayout f26035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final LinearLayout f26036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final Button f26037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final CheckBox f26038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final EditText f26039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final EditText f26040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final EditText f26041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final SuperButton f26042k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final SuperButton f26043l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final ImageView f26044m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final LinearLayout f26045n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final NestedScrollView f26046o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final Button f26047p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public final TextView f26048q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @n0
    public final TextView f26049r;

    public e(@n0 NestedScrollView nestedScrollView, @n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout3, @n0 Button button, @n0 CheckBox checkBox, @n0 EditText editText, @n0 EditText editText2, @n0 EditText editText3, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 ImageView imageView, @n0 LinearLayout linearLayout4, @n0 NestedScrollView nestedScrollView2, @n0 Button button2, @n0 TextView textView, @n0 TextView textView2) {
        this.f26032a = nestedScrollView;
        this.f26033b = linearLayout;
        this.f26034c = linearLayout2;
        this.f26035d = constraintLayout;
        this.f26036e = linearLayout3;
        this.f26037f = button;
        this.f26038g = checkBox;
        this.f26039h = editText;
        this.f26040i = editText2;
        this.f26041j = editText3;
        this.f26042k = superButton;
        this.f26043l = superButton2;
        this.f26044m = imageView;
        this.f26045n = linearLayout4;
        this.f26046o = nestedScrollView2;
        this.f26047p = button2;
        this.f26048q = textView;
        this.f26049r = textView2;
    }

    @n0
    public static e a(@n0 View view) {
        int i10 = R.id.area_account;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_password;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.area_register;
                ConstraintLayout constraintLayout = (ConstraintLayout) j2.c.a(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.area_verify_code;
                    LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                    if (linearLayout3 != null) {
                        i10 = R.id.btn_register;
                        Button button = (Button) j2.c.a(view, i10);
                        if (button != null) {
                            i10 = R.id.cb_user_policy;
                            CheckBox checkBox = (CheckBox) j2.c.a(view, i10);
                            if (checkBox != null) {
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
                                                        i10 = R.id.ll_user_agreement;
                                                        LinearLayout linearLayout4 = (LinearLayout) j2.c.a(view, i10);
                                                        if (linearLayout4 != null) {
                                                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                            i10 = R.id.tv_get_verify_code;
                                                            Button button2 = (Button) j2.c.a(view, i10);
                                                            if (button2 != null) {
                                                                i10 = R.id.tv_message;
                                                                TextView textView = (TextView) j2.c.a(view, i10);
                                                                if (textView != null) {
                                                                    i10 = R.id.tv_user_policy;
                                                                    TextView textView2 = (TextView) j2.c.a(view, i10);
                                                                    if (textView2 != null) {
                                                                        return new e(nestedScrollView, linearLayout, linearLayout2, constraintLayout, linearLayout3, button, checkBox, editText, editText2, editText3, superButton, superButton2, imageView, linearLayout4, nestedScrollView, button2, textView, textView2);
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
    public static e c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static e d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_fragment_register, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f26032a;
    }
}
