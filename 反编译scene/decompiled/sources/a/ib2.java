package a;

import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ib2 extends o42<eb2> implements Object {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jb2 f6395a;

    public ib2(jb2 jb2Var) {
        this.f6395a = jb2Var;
    }

    @Override // a.o42
    public int a() {
        return this.f6395a.e().groupCount() + 1;
    }

    public /* bridge */ boolean b(eb2 eb2Var) {
        return super.contains(eb2Var);
    }

    public eb2 c(int i) {
        ea2 ea2VarD = ob2.d(this.f6395a.e(), i);
        if (ea2VarD.g().intValue() < 0) {
            return null;
        }
        String strGroup = this.f6395a.e().group(i);
        f92.c(strGroup, "matchResult.group(index)");
        return new eb2(strGroup, ea2VarD);
    }

    @Override // a.o42, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof eb2 : true) {
            return b((eb2) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<eb2> iterator() {
        return wa2.e(i52.r(y42.f(this)), new hb2(this)).iterator();
    }
}
