package a;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class aa<K, V> extends ha<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ba f5585a;

    public aa(ba baVar) {
        this.f5585a = baVar;
    }

    @Override // a.ha
    public void a() {
        this.f5585a.clear();
    }

    @Override // a.ha
    public Object b(int i, int i2) {
        return ((ia) this.f5585a).f1348a[(i << 1) + i2];
    }

    @Override // a.ha
    public Map<K, V> c() {
        return this.f5585a;
    }

    @Override // a.ha
    public int d() {
        return ((ia) this.f5585a).f6390a;
    }

    @Override // a.ha
    public int e(Object obj) {
        return this.f5585a.f(obj);
    }

    @Override // a.ha
    public int f(Object obj) {
        return this.f5585a.h(obj);
    }

    @Override // a.ha
    public void g(K k, V v) {
        this.f5585a.put(k, v);
    }

    @Override // a.ha
    public void h(int i) {
        this.f5585a.k(i);
    }

    @Override // a.ha
    public V i(int i, V v) {
        return this.f5585a.l(i, v);
    }
}
