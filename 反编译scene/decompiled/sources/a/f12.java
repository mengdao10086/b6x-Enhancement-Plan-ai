package a;

import android.view.View;
import com.omarea.vtools.AccessibilitySceneMode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f12 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h12 f6064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f836a;
    public final /* synthetic */ String b;

    public f12(h12 h12Var, String str, String str2) {
        this.f6064a = h12Var;
        this.f836a = str;
        this.b = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new wg0(this.f6064a.f1092a).g(this.f836a, this.b, ug0.ALLOW);
        this.f6064a.c();
        if (this.f6064a.f1092a instanceof AccessibilitySceneMode) {
            ((AccessibilitySceneMode) this.f6064a.f1092a).performGlobalAction(1);
        }
    }
}
