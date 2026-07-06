package a;

import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pg0 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rg0 f7116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f2428a;
    public final /* synthetic */ TextView b;

    public pg0(rg0 rg0Var, TextView textView, TextView textView2) {
        this.f7116a = rg0Var;
        this.f2428a = textView;
        this.b = textView2;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        this.f7116a.e(u42.u(zArr, true));
        this.f7116a.f(this.f2428a, this.b);
    }
}
