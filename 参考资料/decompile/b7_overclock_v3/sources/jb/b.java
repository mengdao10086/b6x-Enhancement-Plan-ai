package jb;

import hb.a;
import hb.l;
import hb.r;
import hb.u;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends hb.a {

    /* JADX INFO: renamed from: jb.b$b, reason: collision with other inner class name */
    public static final class C0411b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f36282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f36283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r.a f36284c;

        @Override // hb.a.f
        public a.e a(l lVar, long j10) throws IOException {
            long position = lVar.getPosition();
            long jC = c(lVar);
            long jI = lVar.i();
            lVar.j(Math.max(6, this.f36282a.f30907c));
            long jC2 = c(lVar);
            return (jC > j10 || jC2 <= j10) ? jC2 <= j10 ? a.e.f(jC2, lVar.i()) : a.e.d(jC, position) : a.e.e(jI);
        }

        @Override // hb.a.f
        public /* synthetic */ void b() {
            hb.b.a(this);
        }

        public final long c(l lVar) throws IOException {
            while (lVar.i() < lVar.getLength() - 6 && !r.h(lVar, this.f36282a, this.f36283b, this.f36284c)) {
                lVar.j(1);
            }
            if (lVar.i() < lVar.getLength() - 6) {
                return this.f36284c.f30895a;
            }
            lVar.j((int) (lVar.getLength() - lVar.i()));
            return this.f36282a.f30914j;
        }

        public C0411b(u uVar, int i10) {
            this.f36282a = uVar;
            this.f36283b = i10;
            this.f36284c = new r.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final u uVar, int i10, long j10, long j11) {
        super(new a.d() { // from class: jb.a
            @Override // hb.a.d
            public final long a(long j12) {
                return uVar.l(j12);
            }
        }, new C0411b(uVar, i10), uVar.h(), 0L, uVar.f30914j, j10, j11, uVar.e(), Math.max(6, uVar.f30907c));
        Objects.requireNonNull(uVar);
    }
}
