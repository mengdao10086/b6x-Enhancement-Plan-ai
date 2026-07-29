package no;

import gm.y;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.util.m;

/* JADX INFO: loaded from: classes5.dex */
public class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f42308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set f42309b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f42310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42311d;

    public d(Set set) {
        this.f42308a = set;
    }

    public void a(y yVar) {
        this.f42309b.add(yVar);
    }

    public Set b() {
        HashSet hashSet = new HashSet(this.f42308a);
        hashSet.removeAll(this.f42309b);
        return hashSet;
    }

    public boolean c() {
        return this.f42310c;
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        return null;
    }

    public void e(boolean z10) {
        this.f42310c = z10;
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
    }
}
