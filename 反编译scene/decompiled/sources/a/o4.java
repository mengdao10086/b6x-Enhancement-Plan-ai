package a;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o4 extends FrameLayout implements l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f6979a;

    /* JADX WARN: Multi-variable type inference failed */
    public o4(View view) {
        super(view.getContext());
        this.f6979a = (CollapsibleActionView) view;
        addView(view);
    }

    public View a() {
        return (View) this.f6979a;
    }

    @Override // a.l3
    public void b() {
        this.f6979a.onActionViewCollapsed();
    }

    @Override // a.l3
    public void f() {
        this.f6979a.onActionViewExpanded();
    }
}
