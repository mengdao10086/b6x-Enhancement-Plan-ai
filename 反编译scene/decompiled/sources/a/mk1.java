package a;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mk1 implements q01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r01 f6817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ sk1 f1943a;

    public mk1(r01 r01Var, sk1 sk1Var, ArrayList arrayList, View view) {
        this.f6817a = r01Var;
        this.f1943a = sk1Var;
    }

    @Override // a.q01
    public void b(int i) {
        this.f1943a.f7409a.f(this.f6817a.B(i));
        this.f1943a.v1();
    }
}
