package c7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.view.MappingModeView;
import top.androidman.SuperButton;

/* JADX INFO: loaded from: classes7.dex */
public final class x implements j2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final FrameLayout f10547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final Button f10548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final SuperButton f10549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.n0
    public final Button f10550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.n0
    public final MappingModeView f10551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.n0
    public final MappingModeView f10552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.n0
    public final TextView f10553g;

    public x(@g.n0 FrameLayout frameLayout, @g.n0 Button button, @g.n0 SuperButton superButton, @g.n0 Button button2, @g.n0 MappingModeView mappingModeView, @g.n0 MappingModeView mappingModeView2, @g.n0 TextView textView) {
        this.f10547a = frameLayout;
        this.f10548b = button;
        this.f10549c = superButton;
        this.f10550d = button2;
        this.f10551e = mappingModeView;
        this.f10552f = mappingModeView2;
        this.f10553g = textView;
    }

    @g.n0
    public static x a(@g.n0 View view) {
        int i10 = R.id.btn_action;
        Button button = (Button) j2.c.a(view, i10);
        if (button != null) {
            i10 = R.id.btn_close;
            SuperButton superButton = (SuperButton) j2.c.a(view, i10);
            if (superButton != null) {
                i10 = R.id.btn_help;
                Button button2 = (Button) j2.c.a(view, i10);
                if (button2 != null) {
                    i10 = R.id.game_mode_mapping;
                    MappingModeView mappingModeView = (MappingModeView) j2.c.a(view, i10);
                    if (mappingModeView != null) {
                        i10 = R.id.game_mode_native;
                        MappingModeView mappingModeView2 = (MappingModeView) j2.c.a(view, i10);
                        if (mappingModeView2 != null) {
                            i10 = R.id.tv_title;
                            TextView textView = (TextView) j2.c.a(view, i10);
                            if (textView != null) {
                                return new x((FrameLayout) view, button, superButton, button2, mappingModeView, mappingModeView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @g.n0
    public static x c(@g.n0 LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @g.n0
    public static x d(@g.n0 LayoutInflater layoutInflater, @g.p0 ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.device_dialog_game_mode_choose, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // j2.b
    @g.n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f10547a;
    }
}
