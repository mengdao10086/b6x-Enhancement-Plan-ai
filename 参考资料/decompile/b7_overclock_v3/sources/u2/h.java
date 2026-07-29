package u2;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.w2;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f51814a;

    public class a implements Callable<List<r.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c2.g f51815a;

        public a(final c2.g val$_internalQuery) {
            this.f51815a = val$_internalQuery;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<r.c> call() throws Exception {
            Cursor cursorF = b2.c.f(h.this.f51814a, this.f51815a, true, null);
            try {
                int iD = b2.b.d(cursorF, "id");
                int iD2 = b2.b.d(cursorF, "state");
                int iD3 = b2.b.d(cursorF, "output");
                int iD4 = b2.b.d(cursorF, "run_attempt_count");
                androidx.collection.a aVar = new androidx.collection.a();
                androidx.collection.a aVar2 = new androidx.collection.a();
                while (cursorF.moveToNext()) {
                    if (!cursorF.isNull(iD)) {
                        String string = cursorF.getString(iD);
                        if (((ArrayList) aVar.get(string)) == null) {
                            aVar.put(string, new ArrayList());
                        }
                    }
                    if (!cursorF.isNull(iD)) {
                        String string2 = cursorF.getString(iD);
                        if (((ArrayList) aVar2.get(string2)) == null) {
                            aVar2.put(string2, new ArrayList());
                        }
                    }
                }
                cursorF.moveToPosition(-1);
                h.this.d(aVar);
                h.this.c(aVar2);
                ArrayList arrayList = new ArrayList(cursorF.getCount());
                while (cursorF.moveToNext()) {
                    ArrayList arrayList2 = !cursorF.isNull(iD) ? (ArrayList) aVar.get(cursorF.getString(iD)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = !cursorF.isNull(iD) ? (ArrayList) aVar2.get(cursorF.getString(iD)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    r.c cVar = new r.c();
                    if (iD != -1) {
                        cVar.f51861a = cursorF.getString(iD);
                    }
                    if (iD2 != -1) {
                        cVar.f51862b = x.g(cursorF.getInt(iD2));
                    }
                    if (iD3 != -1) {
                        cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iD3));
                    }
                    if (iD4 != -1) {
                        cVar.f51864d = cursorF.getInt(iD4);
                    }
                    cVar.f51865e = arrayList2;
                    cVar.f51866f = arrayList3;
                    arrayList.add(cVar);
                }
                return arrayList;
            } finally {
                cursorF.close();
            }
        }
    }

    public h(RoomDatabase __db) {
        this.f51814a = __db;
    }

    @Override // u2.g
    public List<r.c> a(final c2.g query) {
        this.f51814a.d();
        Cursor cursorF = b2.c.f(this.f51814a, query, true, null);
        try {
            int iD = b2.b.d(cursorF, "id");
            int iD2 = b2.b.d(cursorF, "state");
            int iD3 = b2.b.d(cursorF, "output");
            int iD4 = b2.b.d(cursorF, "run_attempt_count");
            androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>();
            androidx.collection.a<String, ArrayList<androidx.work.d>> aVar2 = new androidx.collection.a<>();
            while (cursorF.moveToNext()) {
                if (!cursorF.isNull(iD)) {
                    String string = cursorF.getString(iD);
                    if (aVar.get(string) == null) {
                        aVar.put(string, new ArrayList<>());
                    }
                }
                if (!cursorF.isNull(iD)) {
                    String string2 = cursorF.getString(iD);
                    if (aVar2.get(string2) == null) {
                        aVar2.put(string2, new ArrayList<>());
                    }
                }
            }
            cursorF.moveToPosition(-1);
            d(aVar);
            c(aVar2);
            ArrayList arrayList = new ArrayList(cursorF.getCount());
            while (cursorF.moveToNext()) {
                ArrayList<String> arrayList2 = !cursorF.isNull(iD) ? aVar.get(cursorF.getString(iD)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<androidx.work.d> arrayList3 = !cursorF.isNull(iD) ? aVar2.get(cursorF.getString(iD)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                r.c cVar = new r.c();
                if (iD != -1) {
                    cVar.f51861a = cursorF.getString(iD);
                }
                if (iD2 != -1) {
                    cVar.f51862b = x.g(cursorF.getInt(iD2));
                }
                if (iD3 != -1) {
                    cVar.f51863c = androidx.work.d.m(cursorF.getBlob(iD3));
                }
                if (iD4 != -1) {
                    cVar.f51864d = cursorF.getInt(iD4);
                }
                cVar.f51865e = arrayList2;
                cVar.f51866f = arrayList3;
                arrayList.add(cVar);
            }
            return arrayList;
        } finally {
            cursorF.close();
        }
    }

    @Override // u2.g
    public LiveData<List<r.c>> b(final c2.g query) {
        return this.f51814a.o().f(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new a(query));
    }

    public final void c(final androidx.collection.a<String, ArrayList<androidx.work.d>> _map) {
        ArrayList<androidx.work.d> arrayList;
        int i10;
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            androidx.collection.a<String, ArrayList<androidx.work.d>> aVar = new androidx.collection.a<>(999);
            int size = _map.size();
            int i11 = 0;
            loop0: while (true) {
                i10 = 0;
                while (i11 < size) {
                    aVar.put(_map.k(i11), _map.o(i11));
                    i11++;
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                c(aVar);
                aVar = new androidx.collection.a<>(999);
            }
            if (i10 > 0) {
                c(aVar);
                return;
            }
            return;
        }
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        b2.g.a(sbC, size2);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size2 + 0);
        int i12 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                w2VarF.l1(i12);
            } else {
                w2VarF.D(i12, str);
            }
            i12++;
        }
        Cursor cursorF = b2.c.f(this.f51814a, w2VarF, false, null);
        try {
            int iD = b2.b.d(cursorF, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorF.moveToNext()) {
                if (!cursorF.isNull(iD) && (arrayList = _map.get(cursorF.getString(iD))) != null) {
                    arrayList.add(androidx.work.d.m(cursorF.getBlob(0)));
                }
            }
        } finally {
            cursorF.close();
        }
    }

    public final void d(final androidx.collection.a<String, ArrayList<String>> _map) {
        ArrayList<String> arrayList;
        int i10;
        Set<String> setKeySet = _map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            androidx.collection.a<String, ArrayList<String>> aVar = new androidx.collection.a<>(999);
            int size = _map.size();
            int i11 = 0;
            loop0: while (true) {
                i10 = 0;
                while (i11 < size) {
                    aVar.put(_map.k(i11), _map.o(i11));
                    i11++;
                    i10++;
                    if (i10 == 999) {
                        break;
                    }
                }
                d(aVar);
                aVar = new androidx.collection.a<>(999);
            }
            if (i10 > 0) {
                d(aVar);
                return;
            }
            return;
        }
        StringBuilder sbC = b2.g.c();
        sbC.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        b2.g.a(sbC, size2);
        sbC.append(ee.a.f26979d);
        w2 w2VarF = w2.f(sbC.toString(), size2 + 0);
        int i12 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                w2VarF.l1(i12);
            } else {
                w2VarF.D(i12, str);
            }
            i12++;
        }
        Cursor cursorF = b2.c.f(this.f51814a, w2VarF, false, null);
        try {
            int iD = b2.b.d(cursorF, "work_spec_id");
            if (iD == -1) {
                return;
            }
            while (cursorF.moveToNext()) {
                if (!cursorF.isNull(iD) && (arrayList = _map.get(cursorF.getString(iD))) != null) {
                    arrayList.add(cursorF.getString(0));
                }
            }
        } finally {
            cursorF.close();
        }
    }
}
