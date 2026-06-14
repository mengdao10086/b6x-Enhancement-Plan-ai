package a;

import a.r01;
import android.view.View;
import android.widget.ImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r01.a f2812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r01 f2813a;

    public s01(r01 r01Var, int i, r01.a aVar) {
        this.f2813a = r01Var;
        this.f7348a = i;
        this.f2812a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2813a.K(this.f7348a, false);
        ImageButton imageButtonM = this.f2812a.M();
        if (imageButtonM == null || imageButtonM.getVisibility() != 0) {
            q01 q01Var = this.f2813a.f2669a;
            if (q01Var != null) {
                q01Var.b(this.f7348a);
                return;
            }
            return;
        }
        ImageButton imageButtonN = this.f2812a.N();
        if (imageButtonN != null) {
            imageButtonN.setVisibility(0);
        }
        ImageButton imageButtonM2 = this.f2812a.M();
        if (imageButtonM2 != null) {
            imageButtonM2.setVisibility(8);
        }
    }
}
