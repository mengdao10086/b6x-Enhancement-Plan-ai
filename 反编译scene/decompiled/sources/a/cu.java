package a;

import android.graphics.Path;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class cu extends bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wc[] f445a;
    public int b;

    public cu() {
        super();
        this.f445a = null;
        this.f5828a = 0;
    }

    public cu(cu cuVar) {
        super();
        this.f445a = null;
        this.f5828a = 0;
        this.f444a = cuVar.f444a;
        this.b = cuVar.b;
        this.f445a = xc.f(cuVar.f445a);
    }

    public boolean c() {
        return false;
    }

    public void d(Path path) {
        path.reset();
        wc[] wcVarArr = this.f445a;
        if (wcVarArr != null) {
            wc.e(wcVarArr, path);
        }
    }

    public wc[] getPathData() {
        return this.f445a;
    }

    public String getPathName() {
        return this.f444a;
    }

    public void setPathData(wc[] wcVarArr) {
        if (xc.b(this.f445a, wcVarArr)) {
            xc.j(this.f445a, wcVarArr);
        } else {
            this.f445a = xc.f(wcVarArr);
        }
    }
}
