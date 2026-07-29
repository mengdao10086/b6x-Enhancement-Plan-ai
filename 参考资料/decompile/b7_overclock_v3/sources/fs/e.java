package fs;

import cs.q;
import cs.s;
import cs.t;
import java.io.InputStream;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.v;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f28729a;

    public class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f28730a;

        /* JADX INFO: renamed from: fs.e$a$a, reason: collision with other inner class name */
        public class C0337a implements s {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zn.b f28732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ mp.e f28733b;

            public C0337a(zn.b bVar, mp.e eVar) {
                this.f28732a = bVar;
                this.f28733b = eVar;
            }

            @Override // cs.s
            public zn.b a() {
                return this.f28732a;
            }

            @Override // cs.s
            public InputStream b(InputStream inputStream) {
                return new gp.a(inputStream, this.f28733b);
            }

            public q c() {
                return new q(c0.a(a.this.f28730a));
            }
        }

        public a(char[] cArr) {
            this.f28730a = cArr;
        }

        @Override // cs.t
        public s a(zn.b bVar) {
            mp.e eVarC = g.c(bVar.x());
            eVarC.f(false, g.a(bVar.x(), e.this.f28729a, eVarC.b(), r.y(bVar.A()), this.f28730a));
            return new C0337a(bVar, eVarC);
        }
    }

    public e() {
        this(new zo.c0());
    }

    public e(v vVar) {
        this.f28729a = vVar;
    }

    public t b(char[] cArr) {
        return new a(cArr);
    }
}
