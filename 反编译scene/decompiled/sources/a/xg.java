package a;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xg implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ng f7886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sh f3581a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3582a;

    public xg(View view, ng ngVar) {
        this.f3582a = view;
        this.f7886a = ngVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        sh shVarT = sh.t(windowInsets, view);
        if (Build.VERSION.SDK_INT < 30) {
            yg.a(windowInsets, this.f3582a);
            if (shVarT.equals(this.f3581a)) {
                return this.f7886a.a(view, shVarT).r();
            }
        }
        this.f3581a = shVarT;
        sh shVarA = this.f7886a.a(view, shVarT);
        if (Build.VERSION.SDK_INT >= 30) {
            return shVarA.r();
        }
        eh.h0(view);
        return shVarA.r();
    }
}
