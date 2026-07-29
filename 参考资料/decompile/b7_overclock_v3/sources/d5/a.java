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
import com.flydigi.account.R;
import g.n0;
import g.p0;
import j5.u;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ConstraintLayout f25989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f25990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f25991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final u f25992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final Button f25993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final CheckBox f25994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final EditText f25995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f25996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final ImageView f25997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final TextView f25998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final TextView f25999k;

    public a(@n0 ConstraintLayout constraintLayout, @n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 u uVar, @n0 Button button, @n0 CheckBox checkBox, @n0 EditText editText, @n0 SuperButton superButton, @n0 ImageView imageView, @n0 TextView textView, @n0 TextView textView2) {
        this.f25989a = constraintLayout;
        this.f25990b = linearLayout;
        this.f25991c = linearLayout2;
        this.f25992d = uVar;
        this.f25993e = button;
        this.f25994f = checkBox;
        this.f25995g = editText;
        this.f25996h = superButton;
        this.f25997i = imageView;
        this.f25998j = textView;
        this.f25999k = textView2;
    }

    @n0
    public static a a(@n0 View view) {
        View viewA;
        int i10 = R.id.area_logoff;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_password;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null && (viewA = j2.c.a(view, (i10 = R.id.area_toolbar))) != null) {
                u uVarA = u.a(viewA);
                i10 = R.id.btn_logoff;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.cb_read;
                    CheckBox checkBox = (CheckBox) j2.c.a(view, i10);
                    if (checkBox != null) {
                        i10 = R.id.et_password;
                        EditText editText = (EditText) j2.c.a(view, i10);
                        if (editText != null) {
                            i10 = R.id.iv_clear_password;
                            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                            if (superButton != null) {
                                i10 = R.id.iv_show_password;
                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.tv_warning_content;
                                    TextView textView = (TextView) j2.c.a(view, i10);
                                    if (textView != null) {
                                        i10 = R.id.tv_warning_title;
                                        TextView textView2 = (TextView) j2.c.a(view, i10);
                                        if (textView2 != null) {
                                            return new a((ConstraintLayout) view, linearLayout, linearLayout2, uVarA, button, checkBox, editText, superButton, imageView, textView, textView2);
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
    public static a c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static a d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_activity_logoff, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f25989a;
    }
}
