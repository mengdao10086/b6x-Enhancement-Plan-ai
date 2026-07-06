package a;

import android.content.pm.ShortcutInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cd0 extends ArrayList<ShortcutInfo> {
    public cd0(ShortcutInfo shortcutInfo) {
        add(shortcutInfo);
    }

    public /* bridge */ boolean a(ShortcutInfo shortcutInfo) {
        return super.contains(shortcutInfo);
    }

    public /* bridge */ int b() {
        return super.size();
    }

    public /* bridge */ int c(ShortcutInfo shortcutInfo) {
        return super.indexOf(shortcutInfo);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ShortcutInfo) {
            return a((ShortcutInfo) obj);
        }
        return false;
    }

    public /* bridge */ int d(ShortcutInfo shortcutInfo) {
        return super.lastIndexOf(shortcutInfo);
    }

    public /* bridge */ boolean e(ShortcutInfo shortcutInfo) {
        return super.remove(shortcutInfo);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ShortcutInfo) {
            return c((ShortcutInfo) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ShortcutInfo) {
            return d((ShortcutInfo) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof ShortcutInfo) {
            return e((ShortcutInfo) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return b();
    }
}
