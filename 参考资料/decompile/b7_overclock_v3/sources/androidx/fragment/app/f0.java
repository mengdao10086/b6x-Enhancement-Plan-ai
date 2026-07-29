package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5928e = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f5929a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, d0> f5930b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, FragmentState> f5931c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f5932d;

    @p0
    public ArrayList<String> A() {
        synchronized (this.f5929a) {
            if (this.f5929a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f5929a.size());
            for (Fragment fragment : this.f5929a) {
                arrayList.add(fragment.f5646f);
                if (FragmentManager.W0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("saveAllState: adding fragment (");
                    sb2.append(fragment.f5646f);
                    sb2.append("): ");
                    sb2.append(fragment);
                }
            }
            return arrayList;
        }
    }

    public void B(@g.n0 y yVar) {
        this.f5932d = yVar;
    }

    @p0
    public FragmentState C(@g.n0 String str, @p0 FragmentState fragmentState) {
        return fragmentState != null ? this.f5931c.put(str, fragmentState) : this.f5931c.remove(str);
    }

    public void a(@g.n0 Fragment fragment) {
        if (this.f5929a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f5929a) {
            this.f5929a.add(fragment);
        }
        fragment.f5654l = true;
    }

    public void b() {
        this.f5930b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(@g.n0 String str) {
        return this.f5930b.get(str) != null;
    }

    public void d(int i10) {
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                d0Var.u(i10);
            }
        }
    }

    public void e(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
        String str2 = str + wn.a.f54751a;
        if (!this.f5930b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (d0 d0Var : this.f5930b.values()) {
                printWriter.print(str);
                if (d0Var != null) {
                    Fragment fragmentK = d0Var.k();
                    printWriter.println(fragmentK);
                    fragmentK.n1(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(com.blankj.utilcode.util.i0.f11859x);
                }
            }
        }
        int size = this.f5929a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = this.f5929a.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
    }

    @p0
    public Fragment f(@g.n0 String str) {
        d0 d0Var = this.f5930b.get(str);
        if (d0Var != null) {
            return d0Var.k();
        }
        return null;
    }

    @p0
    public Fragment g(@g.d0 int i10) {
        for (int size = this.f5929a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f5929a.get(size);
            if (fragment != null && fragment.f5668x == i10) {
                return fragment;
            }
        }
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                Fragment fragmentK = d0Var.k();
                if (fragmentK.f5668x == i10) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @p0
    public Fragment h(@p0 String str) {
        if (str != null) {
            for (int size = this.f5929a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f5929a.get(size);
                if (fragment != null && str.equals(fragment.f5670z)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                Fragment fragmentK = d0Var.k();
                if (str.equals(fragmentK.f5670z)) {
                    return fragmentK;
                }
            }
        }
        return null;
    }

    @p0
    public Fragment i(@g.n0 String str) {
        Fragment fragmentT1;
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null && (fragmentT1 = d0Var.k().t1(str)) != null) {
                return fragmentT1;
            }
        }
        return null;
    }

    public int j(@g.n0 Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f5665v1;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f5929a.indexOf(fragment);
        for (int i10 = iIndexOf - 1; i10 >= 0; i10--) {
            Fragment fragment2 = this.f5929a.get(i10);
            if (fragment2.f5665v1 == viewGroup && (view2 = fragment2.C1) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f5929a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f5929a.get(iIndexOf);
            if (fragment3.f5665v1 == viewGroup && (view = fragment3.C1) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    public int k() {
        return this.f5930b.size();
    }

    @g.n0
    public List<d0> l() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                arrayList.add(d0Var);
            }
        }
        return arrayList;
    }

    @g.n0
    public List<Fragment> m() {
        ArrayList arrayList = new ArrayList();
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                arrayList.add(d0Var.k());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    @g.n0
    public ArrayList<FragmentState> n() {
        return new ArrayList<>(this.f5931c.values());
    }

    @p0
    public d0 o(@g.n0 String str) {
        return this.f5930b.get(str);
    }

    @g.n0
    public List<Fragment> p() {
        ArrayList arrayList;
        if (this.f5929a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f5929a) {
            arrayList = new ArrayList(this.f5929a);
        }
        return arrayList;
    }

    public y q() {
        return this.f5932d;
    }

    @p0
    public FragmentState r(@g.n0 String str) {
        return this.f5931c.get(str);
    }

    public void s(@g.n0 d0 d0Var) {
        Fragment fragmentK = d0Var.k();
        if (c(fragmentK.f5646f)) {
            return;
        }
        this.f5930b.put(fragmentK.f5646f, d0Var);
        if (fragmentK.D) {
            if (fragmentK.C) {
                this.f5932d.g(fragmentK);
            } else {
                this.f5932d.s(fragmentK);
            }
            fragmentK.D = false;
        }
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Added fragment to active set ");
            sb2.append(fragmentK);
        }
    }

    public void t(@g.n0 d0 d0Var) {
        Fragment fragmentK = d0Var.k();
        if (fragmentK.C) {
            this.f5932d.s(fragmentK);
        }
        if (this.f5930b.put(fragmentK.f5646f, null) != null && FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Removed fragment from active set ");
            sb2.append(fragmentK);
        }
    }

    public void u() {
        Iterator<Fragment> it2 = this.f5929a.iterator();
        while (it2.hasNext()) {
            d0 d0Var = this.f5930b.get(it2.next().f5646f);
            if (d0Var != null) {
                d0Var.m();
            }
        }
        for (d0 d0Var2 : this.f5930b.values()) {
            if (d0Var2 != null) {
                d0Var2.m();
                Fragment fragmentK = d0Var2.k();
                if (fragmentK.f5655m && !fragmentK.v3()) {
                    if (fragmentK.f5656n && !this.f5931c.containsKey(fragmentK.f5646f)) {
                        d0Var2.s();
                    }
                    t(d0Var2);
                }
            }
        }
    }

    public void v(@g.n0 Fragment fragment) {
        synchronized (this.f5929a) {
            this.f5929a.remove(fragment);
        }
        fragment.f5654l = false;
    }

    public void w() {
        this.f5930b.clear();
    }

    public void x(@p0 List<String> list) {
        this.f5929a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment fragmentF = f(str);
                if (fragmentF == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ee.a.f26979d);
                }
                if (FragmentManager.W0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("restoreSaveState: added (");
                    sb2.append(str);
                    sb2.append("): ");
                    sb2.append(fragmentF);
                }
                a(fragmentF);
            }
        }
    }

    public void y(@g.n0 ArrayList<FragmentState> arrayList) {
        this.f5931c.clear();
        for (FragmentState fragmentState : arrayList) {
            this.f5931c.put(fragmentState.f5782b, fragmentState);
        }
    }

    @g.n0
    public ArrayList<String> z() {
        ArrayList<String> arrayList = new ArrayList<>(this.f5930b.size());
        for (d0 d0Var : this.f5930b.values()) {
            if (d0Var != null) {
                Fragment fragmentK = d0Var.k();
                d0Var.s();
                arrayList.add(fragmentK.f5646f);
                if (FragmentManager.W0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Saved state of ");
                    sb2.append(fragmentK);
                    sb2.append(": ");
                    sb2.append(fragmentK.f5642b);
                }
            }
        }
        return arrayList;
    }
}
