package a;

import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ig0 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kg0 f6409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f1364a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;

    public ig0(kg0 kg0Var, TextView textView, TextView textView2, TextView textView3) {
        this.f6409a = kg0Var;
        this.f1364a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            this.f6409a.f1631a[i2] = zArr[i];
            i++;
            i2++;
        }
        this.f6409a.f(this.f1364a, this.b, this.c);
    }
}
