package a;

import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zh extends yh {
    public zh(sh shVar, zh zhVar) {
        super(shVar, zhVar);
    }

    public zh(sh shVar, WindowInsets windowInsets) {
        super(shVar, windowInsets);
    }

    @Override // a.ci
    public sh a() {
        return sh.s(((xh) this).f3589a.consumeDisplayCutout());
    }

    @Override // a.xh, a.ci
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zh)) {
            return false;
        }
        zh zhVar = (zh) obj;
        return Objects.equals(((xh) this).f3589a, ((xh) zhVar).f3589a) && Objects.equals(this.f3590b, zhVar.f3590b);
    }

    @Override // a.ci
    public vf f() {
        return vf.a(((xh) this).f3589a.getDisplayCutout());
    }

    @Override // a.ci
    public int hashCode() {
        return ((xh) this).f3589a.hashCode();
    }
}
