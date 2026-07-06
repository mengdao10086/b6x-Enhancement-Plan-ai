package a;

import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zo implements Comparator<bp> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(bp bpVar, bp bpVar2) {
        if ((bpVar.f290a == null) != (bpVar2.f290a == null)) {
            return bpVar.f290a == null ? 1 : -1;
        }
        boolean z = bpVar.f291a;
        if (z != bpVar2.f291a) {
            return z ? -1 : 1;
        }
        int i = bpVar2.f5721a - bpVar.f5721a;
        if (i != 0) {
            return i;
        }
        int i2 = bpVar.b - bpVar2.b;
        if (i2 != 0) {
            return i2;
        }
        return 0;
    }
}
