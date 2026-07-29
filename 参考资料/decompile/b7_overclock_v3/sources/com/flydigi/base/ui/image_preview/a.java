package com.flydigi.base.ui.image_preview;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.e0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<PreviewBean> f13403l;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f13403l = new ArrayList<>();
    }

    @Override // androidx.fragment.app.e0
    public Fragment a(int i10) {
        return this.f13403l.get(i10).video ? VideoPreviewFragment.a6(this.f13403l.get(i10)) : PhotoViewFragment.e6(this.f13403l.get(i10).url);
    }

    public void b(ArrayList<PreviewBean> arrayList) {
        this.f13403l = arrayList;
        notifyDataSetChanged();
    }

    @Override // k2.a
    public int getCount() {
        return this.f13403l.size();
    }
}
