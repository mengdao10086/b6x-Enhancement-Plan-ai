package a;

import a.s11;
import android.view.View;
import android.widget.ImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11.a f2940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f2941a;

    public t11(s11 s11Var, int i, s11.a aVar) {
        this.f2941a = s11Var;
        this.f7453a = i;
        this.f2940a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2941a.K(this.f7453a, false);
        ImageButton imageButtonM = this.f2940a.M();
        if (imageButtonM == null || imageButtonM.getVisibility() != 0) {
            r11 r11Var = this.f2941a.f2816a;
            if (r11Var != null) {
                r11Var.b(this.f7453a);
                return;
            }
            return;
        }
        ImageButton imageButtonN = this.f2940a.N();
        if (imageButtonN != null) {
            imageButtonN.setVisibility(0);
        }
        ImageButton imageButtonM2 = this.f2940a.M();
        if (imageButtonM2 != null) {
            imageButtonM2.setVisibility(8);
        }
    }
}
