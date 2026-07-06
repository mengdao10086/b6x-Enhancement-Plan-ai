package a;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, vn> f7905a = new HashMap<>();

    public final void a() {
        Iterator<vn> it = this.f7905a.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f7905a.clear();
    }

    public final vn b(String str) {
        return this.f7905a.get(str);
    }

    public final void c(String str, vn vnVar) {
        vn vnVarPut = this.f7905a.put(str, vnVar);
        if (vnVarPut != null) {
            vnVarPut.c();
        }
    }
}
