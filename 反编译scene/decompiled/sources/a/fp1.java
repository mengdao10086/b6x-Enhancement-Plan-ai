package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;
import java.io.IOException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f6127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ iq1 f936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f938a;
    public final /* synthetic */ boolean b;

    public fp1(iq1 iq1Var, p80.b bVar, fj0 fj0Var, CompoundButton compoundButton, boolean z) {
        this.f936a = iq1Var;
        this.f937a = bVar;
        this.f6127a = fj0Var;
        this.f938a = compoundButton;
        this.b = z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IOException {
        Object tag;
        this.f937a.c();
        CompoundButton compoundButtonF = this.f6127a.f();
        if (compoundButtonF == null || (tag = compoundButtonF.getTag()) == null) {
            tag = "app";
        }
        String string = tag.toString();
        CompoundButton compoundButton = this.f938a;
        f92.c(compoundButton, "switchCreateModule");
        if (compoundButton.isChecked() && this.b) {
            this.f936a.Y(string);
        } else {
            this.f936a.X(string);
        }
    }
}
