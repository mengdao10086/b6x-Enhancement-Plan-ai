package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.flydigi.account.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f26000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final LinearLayout f26001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final LinearLayout f26002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Button f26003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final EditText f26004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final EditText f26005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final ImageButton f26006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final ImageView f26007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final Button f26008i;

    public b(@n0 LinearLayout linearLayout, @n0 LinearLayout linearLayout2, @n0 LinearLayout linearLayout3, @n0 Button button, @n0 EditText editText, @n0 EditText editText2, @n0 ImageButton imageButton, @n0 ImageView imageView, @n0 Button button2) {
        this.f26000a = linearLayout;
        this.f26001b = linearLayout2;
        this.f26002c = linearLayout3;
        this.f26003d = button;
        this.f26004e = editText;
        this.f26005f = editText2;
        this.f26006g = imageButton;
        this.f26007h = imageView;
        this.f26008i = button2;
    }

    @n0
    public static b a(@n0 View view) {
        int i10 = R.id.area_account;
        LinearLayout linearLayout = (LinearLayout) j2.c.a(view, i10);
        if (linearLayout != null) {
            i10 = R.id.area_verify_code;
            LinearLayout linearLayout2 = (LinearLayout) j2.c.a(view, i10);
            if (linearLayout2 != null) {
                i10 = R.id.btn_register;
                Button button = (Button) j2.c.a(view, i10);
                if (button != null) {
                    i10 = R.id.et_account;
                    EditText editText = (EditText) j2.c.a(view, i10);
                    if (editText != null) {
                        i10 = R.id.et_verify_code;
                        EditText editText2 = (EditText) j2.c.a(view, i10);
                        if (editText2 != null) {
                            i10 = R.id.iv_clear_phone;
                            ImageButton imageButton = (ImageButton) j2.c.a(view, i10);
                            if (imageButton != null) {
                                i10 = R.id.iv_close;
                                ImageView imageView = (ImageView) j2.c.a(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.tv_get_verify_code;
                                    Button button2 = (Button) j2.c.a(view, i10);
                                    if (button2 != null) {
                                        return new b((LinearLayout) view, linearLayout, linearLayout2, button, editText, editText2, imageButton, imageView, button2);
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
    public static b c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static b d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_dialog_bind_phone, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f26000a;
    }
}
