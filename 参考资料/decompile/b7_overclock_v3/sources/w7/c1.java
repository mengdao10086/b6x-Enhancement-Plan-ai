package w7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.float_view.widget.FloatViewPropertyIntroductionView;
import com.flydigi.float_view.widget.PropertyLinearLayout;

/* JADX INFO: loaded from: classes7.dex */
public final class c1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final PropertyLinearLayout f54005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f54006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f54007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final FloatViewPropertyIntroductionView f54008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final FloatViewKeySetView f54009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f54010f;

    public c1(@g.n0 PropertyLinearLayout propertyLinearLayout, @g.n0 Button button, @g.n0 Button button2, @g.n0 FloatViewPropertyIntroductionView floatViewPropertyIntroductionView, @g.n0 FloatViewKeySetView floatViewKeySetView, @g.n0 TextView textView) {
        this.f54005a = propertyLinearLayout;
        this.f54006b = button;
        this.f54007c = button2;
        this.f54008d = floatViewPropertyIntroductionView;
        this.f54009e = floatViewKeySetView;
        this.f54010f = textView;
    }

    @g.n0
    public static c1 a(@g.n0 View view) {
        int i10 = R.id.btn_edit;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_import;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.introduction_view;
                FloatViewPropertyIntroductionView floatViewPropertyIntroductionView = (FloatViewPropertyIntroductionView) j2.c.a(view, i10);
                if (floatViewPropertyIntroductionView != null) {
                    i10 = R.id.ksv_key_cancel;
                    FloatViewKeySetView floatViewKeySetView = (FloatViewKeySetView) j2.c.a(view, i10);
                    if (floatViewKeySetView != null) {
                        i10 = R.id.tv_macro_number;
                        TextView textView = (TextView) j2.c.a(view, i10);
                        if (textView != null) {
                            return new c1((PropertyLinearLayout) view, button, button2, floatViewPropertyIntroductionView, floatViewKeySetView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static c1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.floatview_property_key_macro, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PropertyLinearLayout getRoot() {
        return this.f54005a;
    }
}
