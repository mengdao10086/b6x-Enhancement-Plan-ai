package a;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g10 implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TabLayout.i f955a;

    public g10(TabLayout.i iVar, View view) {
        this.f955a = iVar;
        this.f6157a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f6157a.getVisibility() == 0) {
            this.f955a.r(this.f6157a);
        }
    }
}
