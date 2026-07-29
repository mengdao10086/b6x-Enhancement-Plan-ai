package d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.flydigi.account.R;
import com.flydigi.base.widget.action_item.ActionItemNormal;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinearLayout f26025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Button f26026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final ImageView f26027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final ActionItemNormal f26028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final ActionItemNormal f26029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final ActionItemNormal f26030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final Button f26031g;

    public d(@n0 LinearLayout linearLayout, @n0 Button button, @n0 ImageView imageView, @n0 ActionItemNormal actionItemNormal, @n0 ActionItemNormal actionItemNormal2, @n0 ActionItemNormal actionItemNormal3, @n0 Button button2) {
        this.f26025a = linearLayout;
        this.f26026b = button;
        this.f26027c = imageView;
        this.f26028d = actionItemNormal;
        this.f26029e = actionItemNormal2;
        this.f26030f = actionItemNormal3;
        this.f26031g = button2;
    }

    @n0
    public static d a(@n0 View view) {
        int i10 = R.id.btn_logoff;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.civ_avatar;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.ov_avatar;
                ActionItemNormal actionItemNormal = (ActionItemNormal) j2.c.a(view, i10);
                if (actionItemNormal != null) {
                    i10 = R.id.ov_change_password;
                    ActionItemNormal actionItemNormal2 = (ActionItemNormal) j2.c.a(view, i10);
                    if (actionItemNormal2 != null) {
                        i10 = R.id.ov_nickname;
                        ActionItemNormal actionItemNormal3 = (ActionItemNormal) j2.c.a(view, i10);
                        if (actionItemNormal3 != null) {
                            i10 = R.id.tv_exit;
                            Button button2 = (Button) j2.c.a(view, i10);
                            if (button2 != null) {
                                return new d((LinearLayout) view, button, imageView, actionItemNormal, actionItemNormal2, actionItemNormal3, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @n0
    public static d c(@n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @n0
    public static d d(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.account_fragment_profile, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f26025a;
    }
}
