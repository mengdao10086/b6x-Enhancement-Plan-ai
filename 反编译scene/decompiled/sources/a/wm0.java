package a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wm0 {
    public final String a() {
        Object next;
        g30 g30VarM0 = e50.f677a.m0();
        if (g30VarM0 != null) {
            String[] strArr = {"serial_id", "serial_no", "cpu_id", "gid"};
            ArrayList arrayList = new ArrayList(4);
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                arrayList.add(g30VarM0.j(str) ? g30VarM0.i(str) : "");
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                String str2 = (String) next;
                f92.c(str2, "it");
                if (str2.length() > 0) {
                    break;
                }
            }
            String str3 = (String) next;
            if (str3 != null) {
                return str3;
            }
        }
        return "";
    }

    public String toString() {
        return a();
    }
}
