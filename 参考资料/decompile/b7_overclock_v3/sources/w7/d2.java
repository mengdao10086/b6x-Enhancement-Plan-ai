package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.flydigi.float_view.R;

/* JADX INFO: loaded from: classes7.dex */
public final class d2 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f54037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f54038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final RadioButton f54039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final RadioButton f54040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final RadioButton f54041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final RadioButton f54042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final RadioGroup f54043g;

    public d2(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 RadioButton radioButton, @g.n0 RadioButton radioButton2, @g.n0 RadioButton radioButton3, @g.n0 RadioButton radioButton4, @g.n0 RadioGroup radioGroup) {
        this.f54037a = frameLayout;
        this.f54038b = button;
        this.f54039c = radioButton;
        this.f54040d = radioButton2;
        this.f54041e = radioButton3;
        this.f54042f = radioButton4;
        this.f54043g = radioGroup;
    }

    @g.n0
    public static d2 a(@g.n0 View view) {
        int i10 = R.id.btn_ok;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.rb_mode_both;
            RadioButton radioButton = (RadioButton) j2.c.a(view, i10);
            if (radioButton != null) {
                i10 = R.id.rb_mode_first;
                RadioButton radioButton2 = (RadioButton) j2.c.a(view, i10);
                if (radioButton2 != null) {
                    i10 = R.id.rb_mode_none;
                    RadioButton radioButton3 = (RadioButton) j2.c.a(view, i10);
                    if (radioButton3 != null) {
                        i10 = R.id.rb_mode_second;
                        RadioButton radioButton4 = (RadioButton) j2.c.a(view, i10);
                        if (radioButton4 != null) {
                            i10 = R.id.rg_mode;
                            RadioGroup radioGroup = (RadioGroup) j2.c.a(view, i10);
                            if (radioGroup != null) {
                                return new d2((FrameLayout) view, button, radioButton, radioButton2, radioButton3, radioButton4, radioGroup);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static d2 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d2 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_setting_combo_key_mode, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f54037a;
    }
}
