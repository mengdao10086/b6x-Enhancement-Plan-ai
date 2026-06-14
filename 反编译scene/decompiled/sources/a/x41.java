package a;

import a.w41;
import android.view.View;
import android.widget.ImageButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x41 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w41.a f3532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w41 f3533a;

    public x41(w41 w41Var, int i, w41.a aVar) {
        this.f3533a = w41Var;
        this.f7854a = i;
        this.f3532a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3533a.J(this.f7854a, false);
        ImageButton imageButtonM = this.f3532a.M();
        if (imageButtonM == null || imageButtonM.getVisibility() != 0) {
            v41 v41Var = this.f3533a.f3378a;
            if (v41Var != null) {
                v41Var.b(this.f7854a);
                return;
            }
            return;
        }
        ImageButton imageButtonN = this.f3532a.N();
        if (imageButtonN != null) {
            imageButtonN.setVisibility(0);
        }
        ImageButton imageButtonM2 = this.f3532a.M();
        if (imageButtonM2 != null) {
            imageButtonM2.setVisibility(8);
        }
    }
}
