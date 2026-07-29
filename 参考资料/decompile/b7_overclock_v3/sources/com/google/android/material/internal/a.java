package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.j;
import g.h1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@h1
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a<T extends j<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, T> f20340a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f20341b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f20342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20344e;

    /* JADX INFO: renamed from: com.google.android.material.internal.a$a, reason: collision with other inner class name */
    public class C0206a implements j.a<T> {
        public C0206a() {
        }

        @Override // com.google.android.material.internal.j.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(T t10, boolean z10) {
            if (!z10) {
                a aVar = a.this;
                if (!aVar.t(t10, aVar.f20344e)) {
                    return;
                }
            } else if (!a.this.g(t10)) {
                return;
            }
            a.this.n();
        }
    }

    public interface b {
        void a(@n0 Set<Integer> set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T t10) {
        this.f20340a.put(Integer.valueOf(t10.getId()), t10);
        if (t10.isChecked()) {
            g(t10);
        }
        t10.setInternalOnCheckedChangeListener(new C0206a());
    }

    public void f(@g.d0 int i10) {
        T t10 = this.f20340a.get(Integer.valueOf(i10));
        if (t10 != null && g(t10)) {
            n();
        }
    }

    public final boolean g(@n0 j<T> jVar) {
        int id2 = jVar.getId();
        if (this.f20341b.contains(Integer.valueOf(id2))) {
            return false;
        }
        T t10 = this.f20340a.get(Integer.valueOf(k()));
        if (t10 != null) {
            t(t10, false);
        }
        boolean zAdd = this.f20341b.add(Integer.valueOf(id2));
        if (!jVar.isChecked()) {
            jVar.setChecked(true);
        }
        return zAdd;
    }

    public void h() {
        boolean z10 = !this.f20341b.isEmpty();
        Iterator<T> it2 = this.f20340a.values().iterator();
        while (it2.hasNext()) {
            t(it2.next(), false);
        }
        if (z10) {
            n();
        }
    }

    @n0
    public Set<Integer> i() {
        return new HashSet(this.f20341b);
    }

    @n0
    public List<Integer> j(@n0 ViewGroup viewGroup) {
        Set<Integer> setI = i();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof j) && setI.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    @g.d0
    public int k() {
        if (!this.f20343d || this.f20341b.isEmpty()) {
            return -1;
        }
        return this.f20341b.iterator().next().intValue();
    }

    public boolean l() {
        return this.f20344e;
    }

    public boolean m() {
        return this.f20343d;
    }

    public final void n() {
        b bVar = this.f20342c;
        if (bVar != null) {
            bVar.a(i());
        }
    }

    public void o(T t10) {
        t10.setInternalOnCheckedChangeListener(null);
        this.f20340a.remove(Integer.valueOf(t10.getId()));
        this.f20341b.remove(Integer.valueOf(t10.getId()));
    }

    public void p(@p0 b bVar) {
        this.f20342c = bVar;
    }

    public void q(boolean z10) {
        this.f20344e = z10;
    }

    public void r(boolean z10) {
        if (this.f20343d != z10) {
            this.f20343d = z10;
            h();
        }
    }

    public void s(@g.d0 int i10) {
        T t10 = this.f20340a.get(Integer.valueOf(i10));
        if (t10 != null && t(t10, this.f20344e)) {
            n();
        }
    }

    public final boolean t(@n0 j<T> jVar, boolean z10) {
        int id2 = jVar.getId();
        if (!this.f20341b.contains(Integer.valueOf(id2))) {
            return false;
        }
        if (z10 && this.f20341b.size() == 1 && this.f20341b.contains(Integer.valueOf(id2))) {
            jVar.setChecked(true);
            return false;
        }
        boolean zRemove = this.f20341b.remove(Integer.valueOf(id2));
        if (jVar.isChecked()) {
            jVar.setChecked(false);
        }
        return zRemove;
    }
}
