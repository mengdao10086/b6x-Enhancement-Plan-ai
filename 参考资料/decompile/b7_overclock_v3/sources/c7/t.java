package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.flydigi.device_manager.R;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final RelativeLayout f10462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final Button f10464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final TextView f10465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final SeekBar f10466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final TextView f10467f;

    public t(@g.n0 RelativeLayout relativeLayout, @g.n0 Button button, @g.n0 Button button2, @g.n0 TextView textView, @g.n0 SeekBar seekBar, @g.n0 TextView textView2) {
        this.f10462a = relativeLayout;
        this.f10463b = button;
        this.f10464c = button2;
        this.f10465d = textView;
        this.f10466e = seekBar;
        this.f10467f = textView2;
    }

    @g.n0
    public static t a(@g.n0 View view) {
        int i10 = R.id.btn_minus;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_plus;
            Button button2 = (Button) j2.c.a(view, i10);
            if (button2 != null) {
                i10 = R.id.name;
                TextView textView = (TextView) j2.c.a(view, i10);
                if (textView != null) {
                    i10 = R.id.seekbar;
                    SeekBar seekBar = (SeekBar) j2.c.a(view, i10);
                    if (seekBar != null) {
                        i10 = R.id.value;
                        TextView textView2 = (TextView) j2.c.a(view, i10);
                        if (textView2 != null) {
                            return new t((RelativeLayout) view, button, button2, textView, seekBar, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static t c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static t d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_cjzc_listen_special_seekbar, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f10462a;
    }
}
