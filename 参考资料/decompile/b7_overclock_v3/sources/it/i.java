package it;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i extends h {
    public i(File file) throws FileNotFoundException {
        super(e(file));
    }

    public static List<g> e(File file) throws FileNotFoundException {
        f lVar;
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("file reference does not refer to directory");
        }
        File[] fileArrListFiles = file.listFiles();
        ArrayList arrayList = new ArrayList(fileArrListFiles.length);
        for (int i10 = 0; i10 != fileArrListFiles.length; i10++) {
            if (!fileArrListFiles[i10].isDirectory()) {
                lVar = new l(fileArrListFiles[i10]);
            } else if (fileArrListFiles[i10].listFiles().length != 0) {
                lVar = new i(fileArrListFiles[i10]);
            }
            arrayList.add(lVar);
        }
        return arrayList;
    }

    public List<l> f() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != this.f35856b.size(); i10++) {
            if (this.f35856b.get(i10) instanceof l) {
                arrayList.add((l) this.f35856b.get(i10));
            }
        }
        return arrayList;
    }

    public List<i> g() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != this.f35856b.size(); i10++) {
            if (this.f35856b.get(i10) instanceof i) {
                arrayList.add((i) this.f35856b.get(i10));
            }
        }
        return arrayList;
    }
}
