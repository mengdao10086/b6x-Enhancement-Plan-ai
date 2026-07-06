package a;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ca<E> extends ha<E, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ da f5769a;

    public ca(da daVar) {
        this.f5769a = daVar;
    }

    @Override // a.ha
    public void a() {
        this.f5769a.clear();
    }

    @Override // a.ha
    public Object b(int i, int i2) {
        return this.f5769a.f521a[i];
    }

    @Override // a.ha
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // a.ha
    public int d() {
        return this.f5769a.f5876a;
    }

    @Override // a.ha
    public int e(Object obj) {
        return this.f5769a.indexOf(obj);
    }

    @Override // a.ha
    public int f(Object obj) {
        return this.f5769a.indexOf(obj);
    }

    @Override // a.ha
    public void g(E e, E e2) {
        this.f5769a.add(e);
    }

    @Override // a.ha
    public void h(int i) {
        this.f5769a.g(i);
    }

    @Override // a.ha
    public E i(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
