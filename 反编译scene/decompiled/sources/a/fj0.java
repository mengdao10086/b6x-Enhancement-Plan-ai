package a;

import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fj0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g82<? super fj0, m42> f6113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<CompoundButton> f906a;

    public fj0(Iterator<? extends CompoundButton> it) {
        f92.d(it, "items");
        this.f906a = new ArrayList<>();
        this.f6113a = cj0.f5800a;
        k(it);
    }

    public fj0(CompoundButton... compoundButtonArr) {
        f92.d(compoundButtonArr, "items");
        this.f906a = new ArrayList<>();
        this.f6113a = cj0.f5800a;
        k(u82.a(compoundButtonArr));
    }

    public final void d(CompoundButton compoundButton) {
        ArrayList<CompoundButton> arrayList = this.f906a;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            CompoundButton compoundButton2 = (CompoundButton) next;
            if (compoundButton2.isChecked() && (f92.a(compoundButton2, compoundButton) ^ true)) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.isEmpty()) {
            compoundButton.setChecked(true);
        }
    }

    public final void e(CompoundButton compoundButton) {
        for (CompoundButton compoundButton2 : this.f906a) {
            if (!f92.a(compoundButton2, compoundButton)) {
                compoundButton2.setChecked(false);
            }
        }
    }

    public final CompoundButton f() {
        Object next;
        Iterator<T> it = this.f906a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((CompoundButton) next).isChecked()) {
                break;
            }
        }
        return (CompoundButton) next;
    }

    public final int g() {
        CompoundButton compoundButtonF = f();
        if (compoundButtonF != null) {
            return this.f906a.indexOf(compoundButtonF);
        }
        return -1;
    }

    public final fj0 h(int i) {
        CompoundButton compoundButton = this.f906a.get(i);
        f92.c(compoundButton, "radios[value]");
        compoundButton.setChecked(true);
        return this;
    }

    public final fj0 i(Object obj) {
        Object next;
        f92.d(obj, "value");
        Iterator<T> it = this.f906a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (f92.a(((CompoundButton) next).getTag(), obj)) {
                break;
            }
        }
        CompoundButton compoundButton = (CompoundButton) next;
        if (compoundButton != null) {
            compoundButton.setChecked(true);
        }
        return this;
    }

    public final void j(g82<? super fj0, m42> g82Var) {
        f92.d(g82Var, "callback");
        this.f6113a = g82Var;
    }

    public final void k(Iterator<? extends CompoundButton> it) {
        while (it.hasNext()) {
            CompoundButton next = it.next();
            this.f906a.add(next);
            next.setOnClickListener(new dj0(this));
            next.setOnCheckedChangeListener(new ej0(this));
        }
        ArrayList<CompoundButton> arrayList = this.f906a;
        ArrayList<CompoundButton> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((CompoundButton) obj).isChecked()) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.size() > 0) {
            CompoundButton compoundButton = (CompoundButton) i52.J(arrayList2);
            for (CompoundButton compoundButton2 : arrayList2) {
                if (!f92.a(compoundButton2, compoundButton)) {
                    compoundButton2.setChecked(false);
                }
            }
        }
    }
}
