package a;

import android.view.View;
import android.view.Window;
import android.widget.Toast;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class be0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ce0 f5698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ArrayList f265a;

    public be0(ce0 ce0Var, ArrayList arrayList) {
        this.f5698a = ce0Var;
        this.f265a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View decorView;
        fe0.B1(this.f5698a.f5784a).c();
        boolean z = false;
        if (this.f265a == null) {
            Toast.makeText(this.f5698a.f5784a.p(), this.f5698a.f5784a.J(ob0.picker_not_item), 0).show();
            return;
        }
        cl clVarJ = this.f5698a.f5784a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        Window window = clVarJ.getWindow();
        Integer numValueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
        if (numValueOf != null && (numValueOf.intValue() & 8192) == 0) {
            z = true;
        }
        b90 b90Var = new b90(z, this.f265a, this.f5698a.f389a.getMultiple(), new ae0(this), 0, 16, null);
        cl clVarJ2 = this.f5698a.f5784a.j();
        f92.b(clVarJ2);
        f92.c(clVarJ2, "activity!!");
        b90Var.B1(clVarJ2.getSupportFragmentManager(), "picker-item-chooser");
    }
}
