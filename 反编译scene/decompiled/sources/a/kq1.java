package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kq1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iz0 f6631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ jz0 f1677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mq1 f1678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f1679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1680a;
    public final /* synthetic */ CompoundButton b;
    public final /* synthetic */ CompoundButton c;
    public final /* synthetic */ CompoundButton d;

    public kq1(mq1 mq1Var, p80.b bVar, jz0 jz0Var, CompoundButton compoundButton, CompoundButton compoundButton2, CompoundButton compoundButton3, CompoundButton compoundButton4, iz0 iz0Var) {
        this.f1678a = mq1Var;
        this.f1679a = bVar;
        this.f1677a = jz0Var;
        this.f1680a = compoundButton;
        this.b = compoundButton2;
        this.c = compoundButton3;
        this.d = compoundButton4;
        this.f6631a = iz0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1679a.c();
        jz0 jz0Var = this.f1677a;
        CompoundButton compoundButton = this.f1680a;
        f92.c(compoundButton, "androidScroll");
        jz0Var.e(compoundButton.isChecked());
        jz0 jz0Var2 = this.f1677a;
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "hideSuIcon");
        jz0Var2.g(compoundButton2.isChecked());
        jz0 jz0Var3 = this.f1677a;
        CompoundButton compoundButton3 = this.c;
        f92.c(compoundButton3, "fgNotificationDisable");
        jz0Var3.f(compoundButton3.isChecked());
        jz0 jz0Var4 = this.f1677a;
        CompoundButton compoundButton4 = this.d;
        f92.c(compoundButton4, "reverseOptimizer");
        jz0Var4.h(compoundButton4.isChecked());
        if (this.f6631a.g(this.f1677a)) {
            this.f6631a.h();
        } else {
            Toast.makeText(this.f1678a.b(), this.f1678a.b().getString(u61.scene_addin_save_fail), 0).show();
        }
    }
}
