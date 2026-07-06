package a;

import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class jl {
    public static final fl b = new fl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fl f6521a = null;

    public abstract hm a();

    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Fragment c(String str);

    public abstract int d();

    public fl e() {
        if (this.f6521a == null) {
            this.f6521a = b;
        }
        return this.f6521a;
    }

    public abstract List<Fragment> f();

    public abstract void g();

    public abstract void h(int i, int i2);

    public abstract boolean i();

    public void j(fl flVar) {
        this.f6521a = flVar;
    }
}
