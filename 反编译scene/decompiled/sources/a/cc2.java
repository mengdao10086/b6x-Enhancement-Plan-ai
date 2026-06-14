package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cc2 extends g92 implements k82<CharSequence, Integer, d42<? extends Integer, ? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f5780a;
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc2(List list, boolean z) {
        super(2);
        this.f5780a = list;
        this.b = z;
    }

    public final d42<Integer, Integer> a(CharSequence charSequence, int i) {
        f92.d(charSequence, "$receiver");
        d42 d42VarF = ec2.F(charSequence, this.f5780a, i, this.b, false);
        if (d42VarF != null) {
            return j42.a(d42VarF.c(), Integer.valueOf(((String) d42VarF.d()).length()));
        }
        return null;
    }

    @Override // a.k82
    public /* bridge */ /* synthetic */ d42<? extends Integer, ? extends Integer> d(CharSequence charSequence, Integer num) {
        return a(charSequence, num.intValue());
    }
}
