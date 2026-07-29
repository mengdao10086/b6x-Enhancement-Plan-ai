package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.i;
import g.n0;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s<T, VH extends RecyclerView.e0> extends RecyclerView.g<VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<T> f7195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.b<T> f7196b;

    public class a implements d.b<T> {
        public a() {
        }

        @Override // androidx.recyclerview.widget.d.b
        public void a(@n0 List<T> list, @n0 List<T> list2) {
            s.this.m(list, list2);
        }
    }

    public s(@n0 i.d<T> dVar) {
        a aVar = new a();
        this.f7196b = aVar;
        d<T> dVar2 = new d<>(new b(this), new c.a(dVar).a());
        this.f7195a = dVar2;
        dVar2.a(aVar);
    }

    public T getItem(int i10) {
        return this.f7195a.b().get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f7195a.b().size();
    }

    @n0
    public List<T> l() {
        return this.f7195a.b();
    }

    public void m(@n0 List<T> list, @n0 List<T> list2) {
    }

    public void n(@p0 List<T> list) {
        this.f7195a.f(list);
    }

    public void o(@p0 List<T> list, @p0 Runnable runnable) {
        this.f7195a.g(list, runnable);
    }

    public s(@n0 c<T> cVar) {
        a aVar = new a();
        this.f7196b = aVar;
        d<T> dVar = new d<>(new b(this), cVar);
        this.f7195a = dVar;
        dVar.a(aVar);
    }
}
