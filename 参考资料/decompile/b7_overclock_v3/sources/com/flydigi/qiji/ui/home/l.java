package com.flydigi.qiji.ui.home;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import g.n0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class l extends FragmentStateAdapter {
    public l(@n0 androidx.fragment.app.g gVar) {
        super(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return m.h();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @n0
    public Fragment n(int i10) {
        Fragment fragmentD = m.d(i10);
        Objects.requireNonNull(fragmentD);
        return fragmentD;
    }
}
