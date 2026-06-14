package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ek1 implements r11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kk1 f6016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f768a;

    public ek1(s11 s11Var, kk1 kk1Var, ArrayList arrayList, View view) {
        this.f768a = s11Var;
        this.f6016a = kk1Var;
    }

    @Override // a.r11
    public void b(int i) {
        this.f6016a.f6615a.f(this.f768a.B(i));
        this.f6016a.v1();
    }
}
