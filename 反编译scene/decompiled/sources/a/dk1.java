package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dk1 implements r11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kk1 f5912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f578a;

    public dk1(s11 s11Var, kk1 kk1Var, ArrayList arrayList, View view) {
        this.f578a = s11Var;
        this.f5912a = kk1Var;
    }

    @Override // a.r11
    public void b(int i) {
        this.f5912a.f1648a.o(this.f578a.B(i).session);
        this.f578a.E(i);
    }
}
