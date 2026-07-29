package h4;

import g.n0;
import g.p0;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface n<Model, Data> {

    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c4.b f30486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c4.b> f30487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f30488c;

        public a(@n0 c4.b bVar, @n0 com.bumptech.glide.load.data.d<Data> dVar) {
            this(bVar, Collections.emptyList(), dVar);
        }

        public a(@n0 c4.b bVar, @n0 List<c4.b> list, @n0 com.bumptech.glide.load.data.d<Data> dVar) {
            this.f30486a = (c4.b) v4.m.d(bVar);
            this.f30487b = (List) v4.m.d(list);
            this.f30488c = (com.bumptech.glide.load.data.d) v4.m.d(dVar);
        }
    }

    @p0
    a<Data> a(@n0 Model model, int i10, int i11, @n0 c4.e eVar);

    boolean b(@n0 Model model);
}
