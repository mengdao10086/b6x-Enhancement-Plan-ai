package n4;

import com.bumptech.glide.load.engine.o;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends l4.c<c> implements o {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
        ((c) this.f39446a).stop();
        ((c) this.f39446a).p();
    }

    @Override // l4.c, com.bumptech.glide.load.engine.o
    public void b() {
        ((c) this.f39446a).h().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return ((c) this.f39446a).m();
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<c> d() {
        return c.class;
    }
}
