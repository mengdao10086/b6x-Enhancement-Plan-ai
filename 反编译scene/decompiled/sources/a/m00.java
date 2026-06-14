package a;

import android.os.Bundle;
import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m00 extends rf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f6754a;

    public m00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6754a = baseTransientBottomBar;
    }

    @Override // a.rf
    public void g(View view, ni niVar) {
        super.g(view, niVar);
        niVar.a(1048576);
        niVar.f0(true);
    }

    @Override // a.rf
    public boolean j(View view, int i, Bundle bundle) {
        if (i != 1048576) {
            return super.j(view, i, bundle);
        }
        this.f6754a.s();
        return true;
    }
}
