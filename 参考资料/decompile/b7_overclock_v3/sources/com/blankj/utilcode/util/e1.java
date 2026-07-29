package com.blankj.utilcode.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11757a = System.getProperty("line.separator");

    public e1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String a(Throwable th2) {
        List<String> listB;
        ArrayList arrayList = new ArrayList();
        while (th2 != null && !arrayList.contains(th2)) {
            arrayList.add(th2);
            th2 = th2.getCause();
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i10 = size - 1;
        List<String> listB2 = b((Throwable) arrayList.get(i10));
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (size != 0) {
                listB = b((Throwable) arrayList.get(size - 1));
                c(listB2, listB);
            } else {
                listB = listB2;
            }
            if (size == i10) {
                arrayList2.add(((Throwable) arrayList.get(size)).toString());
            } else {
                arrayList2.add(" Caused by: " + ((Throwable) arrayList.get(size)).toString());
            }
            arrayList2.addAll(listB2);
            listB2 = listB;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            sb2.append(f11757a);
        }
        return sb2.toString();
    }

    public static List<String> b(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), f11757a);
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf("at");
            if (iIndexOf != -1 && strNextToken.substring(0, iIndexOf).trim().isEmpty()) {
                arrayList.add(strNextToken);
                z10 = true;
            } else if (z10) {
                break;
            }
        }
        return arrayList;
    }

    public static void c(List<String> list, List<String> list2) {
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }
}
