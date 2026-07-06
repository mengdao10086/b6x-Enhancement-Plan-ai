package a;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xl implements bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final sk f3600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f3601a;

    public xl(sk skVar, boolean z) {
        this.f3601a = z;
        this.f3600a = skVar;
    }

    @Override // a.bl
    public void a() {
        this.f7901a++;
    }

    @Override // a.bl
    public void b() {
        int i = this.f7901a - 1;
        this.f7901a = i;
        if (i != 0) {
            return;
        }
        this.f3600a.f7407a.i1();
    }

    public void c() {
        sk skVar = this.f3600a;
        skVar.f7407a.w(skVar, this.f3601a, false, false);
    }

    public void d() {
        boolean z = this.f7901a > 0;
        yl ylVar = this.f3600a.f7407a;
        int size = ylVar.f3736b.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = ylVar.f3736b.get(i);
            fragment.p1(null);
            if (z && fragment.V()) {
                fragment.u1();
            }
        }
        sk skVar = this.f3600a;
        skVar.f7407a.w(skVar, this.f3601a, !z, true);
    }

    public boolean e() {
        return this.f7901a == 0;
    }
}
