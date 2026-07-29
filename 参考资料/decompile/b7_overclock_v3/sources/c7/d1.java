package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.MappingModeView;

/* JADX INFO: loaded from: classes7.dex */
public final class d1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f9928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f9929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f9930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final MappingModeView f9931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final MappingModeView f9932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9933g;

    public d1(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 ImageView imageView, @g.n0 TextView textView, @g.n0 MappingModeView mappingModeView, @g.n0 MappingModeView mappingModeView2, @g.n0 TextView textView2) {
        this.f9927a = frameLayout;
        this.f9928b = button;
        this.f9929c = imageView;
        this.f9930d = textView;
        this.f9931e = mappingModeView;
        this.f9932f = mappingModeView2;
        this.f9933g = textView2;
    }

    @g.n0
    public static d1 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_close;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.btn_help;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.rb_mode_flashplay;
                    MappingModeView mappingModeView = (MappingModeView) j2.c.a(view, i10);
                    if (mappingModeView != null) {
                        i10 = R.id.rb_mode_tradition;
                        MappingModeView mappingModeView2 = (MappingModeView) j2.c.a(view, i10);
                        if (mappingModeView2 != null) {
                            i10 = R.id.tv_title;
                            TextView textView2 = (TextView) j2.c.a(view, i10);
                            if (textView2 != null) {
                                return new d1((FrameLayout) view, button, imageView, textView, mappingModeView, mappingModeView2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static d1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static d1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_mapping_mode_tradition_pro, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9927a;
    }
}
