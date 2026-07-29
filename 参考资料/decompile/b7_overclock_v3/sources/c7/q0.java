package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.device_manager.R;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class q0 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ConstraintLayout f10357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final TextView f10358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f10359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final SuperButton f10360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final TextView f10361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10362f;

    public q0(@g.n0 ConstraintLayout constraintLayout, @g.n0 TextView textView, @g.n0 Button button, @g.n0 SuperButton superButton, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f10357a = constraintLayout;
        this.f10358b = textView;
        this.f10359c = button;
        this.f10360d = superButton;
        this.f10361e = textView2;
        this.f10362f = textView3;
    }

    @g.n0
    public static q0 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        TextView textView = (TextView) j2.c.a(view, i10);
        if (textView != null) {
            i10 = R.id.btn_help;
            Button button = (Button) j2.c.a(view, i10);
            if (button != null) {
                i10 = R.id.iv_result;
                SuperButton superButton = (SuperButton) j2.c.a(view, i10);
                if (superButton != null) {
                    i10 = R.id.tv_message;
                    TextView textView2 = (TextView) j2.c.a(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.tv_result;
                        TextView textView3 = (TextView) j2.c.a(view, i10);
                        if (textView3 != null) {
                            return new q0((ConstraintLayout) view, textView, button, superButton, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static q0 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static q0 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_firmware_upgrade_result, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f10357a;
    }
}
