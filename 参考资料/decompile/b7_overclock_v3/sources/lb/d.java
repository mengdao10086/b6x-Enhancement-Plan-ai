package lb;

import hb.a0;
import hb.b0;
import hb.d0;
import hb.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f39553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f39554b;

    public class a implements a0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a0 f39555d;

        public a(a0 a0Var) {
            this.f39555d = a0Var;
        }

        @Override // hb.a0
        public boolean e() {
            return this.f39555d.e();
        }

        @Override // hb.a0
        public a0.a g(long j10) {
            a0.a aVarG = this.f39555d.g(j10);
            b0 b0Var = aVarG.f30800a;
            b0 b0Var2 = new b0(b0Var.f30805a, b0Var.f30806b + d.this.f39553a);
            b0 b0Var3 = aVarG.f30801b;
            return new a0.a(b0Var2, new b0(b0Var3.f30805a, b0Var3.f30806b + d.this.f39553a));
        }

        @Override // hb.a0
        public long h() {
            return this.f39555d.h();
        }
    }

    public d(long j10, m mVar) {
        this.f39553a = j10;
        this.f39554b = mVar;
    }

    @Override // hb.m
    public d0 d(int i10, int i11) {
        return this.f39554b.d(i10, i11);
    }

    @Override // hb.m
    public void k() {
        this.f39554b.k();
    }

    @Override // hb.m
    public void o(a0 a0Var) {
        this.f39554b.o(new a(a0Var));
    }
}
