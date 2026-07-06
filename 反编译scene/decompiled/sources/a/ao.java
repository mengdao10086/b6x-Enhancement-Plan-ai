package a;

import a.wn;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ao extends zn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kn f89a;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<D>] */
    public static class a<D> extends qn<D> {
        public abstract bo<D> h(boolean z);

        public abstract void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        public abstract void j();

        public abstract String toString();
    }

    public static class b extends vn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final wn.a f5624a = new a();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ja<a> f90a = new ja<>();

        public static class a implements wn.a {
            @Override // a.wn.a
            public <T extends vn> T a(Class<T> cls) {
                return new b();
            }
        }

        public static b e(xn xnVar) {
            return (b) new wn(xnVar, f5624a).a(b.class);
        }

        @Override // a.vn
        public void c() {
            super.c();
            int iL = this.f90a.l();
            for (int i = 0; i < iL; i++) {
                this.f90a.m(i).h(true);
            }
            this.f90a.b();
        }

        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f90a.l() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f90a.l(); i++) {
                    a aVarM = this.f90a.m(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f90a.i(i));
                    printWriter.print(": ");
                    printWriter.println(aVarM.toString());
                    aVarM.i(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void f() {
            int iL = this.f90a.l();
            for (int i = 0; i < iL; i++) {
                this.f90a.m(i).j();
            }
        }
    }

    public ao(kn knVar, xn xnVar) {
        this.f89a = knVar;
        this.f5623a = b.e(xnVar);
    }

    @Override // a.zn
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f5623a.d(str, fileDescriptor, printWriter, strArr);
    }

    @Override // a.zn
    public void c() {
        this.f5623a.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Cif.a(this.f89a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
