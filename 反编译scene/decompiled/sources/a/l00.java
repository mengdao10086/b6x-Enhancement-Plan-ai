package a;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l00 implements ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f6659a;

    public l00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6659a = baseTransientBottomBar;
    }

    @Override // a.ng
    public sh a(View view, sh shVar) {
        this.f6659a.f4667b = shVar.f();
        this.f6659a.c = shVar.g();
        this.f6659a.d = shVar.h();
        this.f6659a.T();
        return shVar;
    }
}
