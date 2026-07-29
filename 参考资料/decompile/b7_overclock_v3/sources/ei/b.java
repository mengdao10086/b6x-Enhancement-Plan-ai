package ei;

import ei.h;
import gi.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<VH extends gi.c, S extends h> extends c<VH> implements f<VH, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26997a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<S> f26998b;

    public b A(S s10) {
        if (this.f26998b == null) {
            this.f26998b = new ArrayList();
        }
        this.f26998b.add(s10);
        return this;
    }

    public b B(int i10, List<S> list) {
        List<S> list2 = this.f26998b;
        if (list2 == null || i10 < 0 || i10 >= list2.size()) {
            if (this.f26998b == null) {
                this.f26998b = new ArrayList();
            }
            this.f26998b.addAll(list);
        } else {
            this.f26998b.addAll(i10, list);
        }
        return this;
    }

    public boolean C(S s10) {
        List<S> list = this.f26998b;
        return list != null && list.contains(s10);
    }

    public S D(int i10) {
        List<S> list = this.f26998b;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return this.f26998b.get(i10);
    }

    public final int E(S s10) {
        List<S> list = this.f26998b;
        if (list != null) {
            return list.indexOf(s10);
        }
        return -1;
    }

    public final int G() {
        List<S> list = this.f26998b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean H() {
        List<S> list = this.f26998b;
        return list != null && list.size() > 0;
    }

    public boolean I(int i10) {
        List<S> list = this.f26998b;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return false;
        }
        this.f26998b.remove(i10);
        return true;
    }

    public boolean J(S s10) {
        List<S> list;
        return (s10 == null || (list = this.f26998b) == null || !list.remove(s10)) ? false : true;
    }

    public boolean K(List<S> list) {
        List<S> list2;
        return (list == null || (list2 = this.f26998b) == null || !list2.removeAll(list)) ? false : true;
    }

    public b L(List<S> list) {
        this.f26998b = list;
        return this;
    }

    @Override // ei.f
    public final List<S> getSubItems() {
        return this.f26998b;
    }

    @Override // ei.f
    public boolean isExpanded() {
        return this.f26997a;
    }

    @Override // ei.f
    public int l() {
        return 0;
    }

    @Override // ei.f
    public void setExpanded(boolean z10) {
        this.f26997a = z10;
    }

    public b z(int i10, S s10) {
        List<S> list = this.f26998b;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            A(s10);
        } else {
            this.f26998b.add(i10, s10);
        }
        return this;
    }
}
