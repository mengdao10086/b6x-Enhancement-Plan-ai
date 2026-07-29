package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.flydigi.account.R;
import g.n0;
import g.p0;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final NestedScrollView f26009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f26010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f26011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f26012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final CheckBox f26013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final EditText f26014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final EditText f26015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final SuperButton f26016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final SuperButton f26017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final ImageButton f26018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final ImageView f26019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final ImageButton f26020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @n0
    public final LinearLayout f26021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @n0
    public final Button f26022n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final Button f26023o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final TextView f26024p;

    public c(@n0 NestedScrollView nestedScrollView, @n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 Button button, @n0 CheckBox checkBox, @n0 EditText editText, @n0 EditText editText2, @n0 SuperButton superButton, @n0 SuperButton superButton2, @n0 ImageButton imageButton, @n0 ImageView imageView, @n0 ImageButton imageButton2, @n0 LinearLayout linearLayout3, @n0 Button button2, @n0 Button button3, @n0 TextView textView) {
        this.f26009a = nestedScrollView;
        this.f26010b = linearLayout;
        this.f26011c = linearLayout2;
        this.f26012d = button;
        this.f26013e = checkBox;
        this.f26014f = editText;
        this.f26015g = editText2;
        this.f26016h = superButton;
        this.f26017i = superButton2;
        this.f26018j = imageButton;
        this.f26019k = imageView;
        this.f26020l = imageButton2;
        this.f26021m = linearLayout3;
        this.f26022n = button2;
        this.f26023o = button3;
        this.f26024p = textView;
    }

    @n0
    public static c a(@n0 View view) {
        int i10 = R.id.area_account;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_password;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.btn_login;
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
                                i10 = R.id.iv_clear_account;
                                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                                if (superButton != null) {
                                    i10 = R.id.iv_clear_password;
                                    SuperButton superButton2 = (SuperButton) j2.c.a(view, i10);
                                    if (superButton2 != null) {
                                        i10 = R.id.iv_qq;
                                        ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                                        if (imageButton != null) {
                                            i10 = R.id.iv_show_password;
                                            ImageView imageView = (ImageView) j2.c.a(view, i10);
                                            if (imageView != null) {
                                                i10 = R.id.iv_weixin;
                                                ImageButton imageButton2 = (ImageButton) j2.c.a(view, i10);
                                                if (imageButton2 != null) {
                                                    i10 = R.id.ll_user_agreement;
                                                    LinearLayout linearLayout3 = (LinearLayout) j2.c.a(view, i10);
                                                    if (linearLayout3 != null) {
                                                        i10 = R.id.tv_forget_password;
                                                        Button button2 = (Button) j2.c.a(view, i10);
                                                        if (button2 != null) {
                                                            i10 = R.id.tv_register;
                                                            Button button3 = (Button) j2.c.a(view, i10);
                                                            if (button3 != null) {
                                                                i10 = R.id.tv_user_policy;
                                                                TextView textView = (TextView) j2.c.a(view, i10);
                                                                if (textView != null) {
                                                                    return new c((NestedScrollView) view, linearLayout, linearLayout2, button, checkBox, editText, editText2, superButton, superButton2, imageButton, imageView, imageButton2, linearLayout3, button2, button3, textView);
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
    public static c c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static c d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_fragment_login, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f26009a;
    }
}
