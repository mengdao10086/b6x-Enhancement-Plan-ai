package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o<S> extends Fragment {

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public final LinkedHashSet<n<S>> f20155c8 = new LinkedHashSet<>();

    public boolean E5(n<S> nVar) {
        return this.f20155c8.add(nVar);
    }

    public void F5() {
        this.f20155c8.clear();
    }

    public abstract DateSelector<S> G5();

    public boolean H5(n<S> nVar) {
        return this.f20155c8.remove(nVar);
    }
}
