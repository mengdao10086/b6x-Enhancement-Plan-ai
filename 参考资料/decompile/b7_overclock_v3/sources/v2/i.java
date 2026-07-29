package v2;

import androidx.work.WorkInfo;
import androidx.work.w;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import u2.x;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static void a(@n0 StringBuilder builder, int count) {
        if (count <= 0) {
            return;
        }
        builder.append("?");
        for (int i10 = 1; i10 < count; i10++) {
            builder.append(ag.c.f654g);
            builder.append("?");
        }
    }

    @n0
    public static c2.g b(@n0 w querySpec) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> listB = querySpec.b();
        String str = " AND";
        String str2 = " WHERE";
        if (!listB.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(listB.size());
            Iterator<WorkInfo.State> it2 = listB.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(x.j(it2.next())));
            }
            sb2.append(" WHERE");
            sb2.append(" state IN (");
            a(sb2, arrayList2.size());
            sb2.append(ee.a.f26979d);
            arrayList.addAll(arrayList2);
            str2 = " AND";
        }
        List<UUID> listA = querySpec.a();
        if (!listA.isEmpty()) {
            ArrayList arrayList3 = new ArrayList(listA.size());
            Iterator<UUID> it3 = listA.iterator();
            while (it3.hasNext()) {
                arrayList3.add(it3.next().toString());
            }
            sb2.append(str2);
            sb2.append(" id IN (");
            a(sb2, listA.size());
            sb2.append(ee.a.f26979d);
            arrayList.addAll(arrayList3);
            str2 = " AND";
        }
        List<String> listC = querySpec.c();
        if (listC.isEmpty()) {
            str = str2;
        } else {
            sb2.append(str2);
            sb2.append(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN (");
            a(sb2, listC.size());
            sb2.append("))");
            arrayList.addAll(listC);
        }
        List<String> listD = querySpec.d();
        if (!listD.isEmpty()) {
            sb2.append(str);
            sb2.append(" id IN (SELECT work_spec_id FROM workname WHERE name IN (");
            a(sb2, listD.size());
            sb2.append("))");
            arrayList.addAll(listD);
        }
        sb2.append(";");
        return new c2.a(sb2.toString(), arrayList.toArray());
    }
}
