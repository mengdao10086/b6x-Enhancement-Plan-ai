package e4;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.s;
import e4.j;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends v4.j<c4.b, s<?>> implements j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j.a f26630e;

    public i(long j10) {
        super(j10);
    }

    @Override // e4.j
    @SuppressLint({"InlinedApi"})
    public void b(int i10) {
        if (i10 >= 40) {
            c();
        } else if (i10 >= 20 || i10 == 15) {
            q(a() / 2);
        }
    }

    @Override // e4.j
    @p0
    public /* bridge */ /* synthetic */ s f(@n0 c4.b bVar) {
        return (s) super.p(bVar);
    }

    @Override // e4.j
    @p0
    public /* bridge */ /* synthetic */ s g(@n0 c4.b bVar, @p0 s sVar) {
        return (s) super.o(bVar, sVar);
    }

    @Override // e4.j
    public void h(@n0 j.a aVar) {
        this.f26630e = aVar;
    }

    @Override // v4.j
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public int m(@p0 s<?> sVar) {
        return sVar == null ? super.m(null) : sVar.c();
    }

    @Override // v4.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void n(@n0 c4.b bVar, @p0 s<?> sVar) {
        j.a aVar = this.f26630e;
        if (aVar == null || sVar == null) {
            return;
        }
        aVar.a(sVar);
    }
}
