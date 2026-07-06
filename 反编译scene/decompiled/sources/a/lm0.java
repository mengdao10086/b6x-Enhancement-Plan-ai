package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lm0 extends ArrayList<String> {
    public lm0() {
        add("ps");
        add("top");
        add("com.omarea.vtools");
    }

    public /* bridge */ boolean a(String str) {
        return super.contains(str);
    }

    public /* bridge */ int b() {
        return super.size();
    }

    public /* bridge */ int c(String str) {
        return super.indexOf(str);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    public /* bridge */ int d(String str) {
        return super.lastIndexOf(str);
    }

    public /* bridge */ boolean e(String str) {
        return super.remove(str);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return c((String) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return d((String) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof String) {
            return e((String) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return b();
    }
}
