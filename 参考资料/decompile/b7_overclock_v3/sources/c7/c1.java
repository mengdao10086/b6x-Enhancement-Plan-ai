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
public final class c1 implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f9882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f9883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final ImageView f9884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f9885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final MappingModeView f9886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final MappingModeView f9887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f9888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.n0
    public final TextView f9889h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f9890i;

    public c1(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 ImageView imageView, @g.n0 Button button2, @g.n0 MappingModeView mappingModeView, @g.n0 MappingModeView mappingModeView2, @g.n0 TextView textView, @g.n0 TextView textView2, @g.n0 TextView textView3) {
        this.f9882a = frameLayout;
        this.f9883b = button;
        this.f9884c = imageView;
        this.f9885d = button2;
        this.f9886e = mappingModeView;
        this.f9887f = mappingModeView2;
        this.f9888g = textView;
        this.f9889h = textView2;
        this.f9890i = textView3;
    }

    @g.n0
    public static c1 a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_close;
            ImageView imageView = (ImageView) j2.c.a(view, i10);
            if (imageView != null) {
                i10 = R.id.btn_help;
                Button button2 = (Button) j2.c.a(view, i10);
                if (button2 != null) {
                    i10 = R.id.rb_mode_flashplay;
                    MappingModeView mappingModeView = (MappingModeView) j2.c.a(view, i10);
                    if (mappingModeView != null) {
                        i10 = R.id.rb_mode_tradition;
                        MappingModeView mappingModeView2 = (MappingModeView) j2.c.a(view, i10);
                        if (mappingModeView2 != null) {
                            i10 = R.id.tv_alert;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                i10 = R.id.tv_notice;
                                TextView textView2 = (TextView) j2.c.a(view, i10);
                                if (textView2 != null) {
                                    i10 = R.id.tv_title;
                                    TextView textView3 = (TextView) j2.c.a(view, i10);
                                    if (textView3 != null) {
                                        return new c1((FrameLayout) view, button, imageView, button2, mappingModeView, mappingModeView2, textView, textView2, textView3);
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

    @g.n0
    public static c1 c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static c1 d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_fragment_mapping_mode, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f9882a;
    }
}
