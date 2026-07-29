package h4;

import androidx.core.util.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import g.n0;
import g.p0;
import h4.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class q<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<n<Model, Data>> f30493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n.a<List<Throwable>> f30494b;

    public static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.bumptech.glide.load.data.d<Data>> f30495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n.a<List<Throwable>> f30496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f30497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Priority f30498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.a<? super Data> f30499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @p0
        public List<Throwable> f30500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f30501g;

        public a(@n0 List<com.bumptech.glide.load.data.d<Data>> list, @n0 n.a<List<Throwable>> aVar) {
            this.f30496b = aVar;
            v4.m.c(list);
            this.f30495a = list;
            this.f30497c = 0;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<Data> a() {
            return this.f30495a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f30500f;
            if (list != null) {
                this.f30496b.b(list);
            }
            this.f30500f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it2 = this.f30495a.iterator();
            while (it2.hasNext()) {
                it2.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@n0 Exception exc) {
            ((List) v4.m.d(this.f30500f)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f30501g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it2 = this.f30495a.iterator();
            while (it2.hasNext()) {
                it2.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@p0 Data data) {
            if (data != null) {
                this.f30499e.d(data);
            } else {
                g();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public DataSource e() {
            return this.f30495a.get(0).e();
        }

        @Override // com.bumptech.glide.load.data.d
        public void f(@n0 Priority priority, @n0 d.a<? super Data> aVar) {
            this.f30498d = priority;
            this.f30499e = aVar;
            this.f30500f = this.f30496b.a();
            this.f30495a.get(this.f30497c).f(priority, this);
            if (this.f30501g) {
                cancel();
            }
        }

        public final void g() {
            if (this.f30501g) {
                return;
            }
            if (this.f30497c < this.f30495a.size() - 1) {
                this.f30497c++;
                f(this.f30498d, this.f30499e);
            } else {
                v4.m.d(this.f30500f);
                this.f30499e.c(new GlideException("Fetch failed", new ArrayList(this.f30500f)));
            }
        }
    }

    public q(@n0 List<n<Model, Data>> list, @n0 n.a<List<Throwable>> aVar) {
        this.f30493a = list;
        this.f30494b = aVar;
    }

    @Override // h4.n
    public n.a<Data> a(@n0 Model model, int i10, int i11, @n0 c4.e eVar) {
        n.a<Data> aVarA;
        int size = this.f30493a.size();
        ArrayList arrayList = new ArrayList(size);
        c4.b bVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            n<Model, Data> nVar = this.f30493a.get(i12);
            if (nVar.b(model) && (aVarA = nVar.a(model, i10, i11, eVar)) != null) {
                bVar = aVarA.f30486a;
                arrayList.add(aVarA.f30488c);
            }
        }
        if (arrayList.isEmpty() || bVar == null) {
            return null;
        }
        return new n.a<>(bVar, new a(arrayList, this.f30494b));
    }

    @Override // h4.n
    public boolean b(@n0 Model model) {
        Iterator<n<Model, Data>> it2 = this.f30493a.iterator();
        while (it2.hasNext()) {
            if (it2.next().b(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f30493a.toArray()) + '}';
    }
}
