package a;

import android.view.Menu;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g2 extends v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f6159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(h2 h2Var, Window.Callback callback) {
        super(callback);
        this.f6159a = h2Var;
    }

    @Override // a.v3, android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return i == 0 ? new View(this.f6159a.f6265a.x()) : super.onCreatePanelView(i);
    }

    @Override // a.v3, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
        if (zOnPreparePanel) {
            h2 h2Var = this.f6159a;
            if (!h2Var.f1100a) {
                h2Var.f6265a.a();
                this.f6159a.f1100a = true;
            }
        }
        return zOnPreparePanel;
    }
}
