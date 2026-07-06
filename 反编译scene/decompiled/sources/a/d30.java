package a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class d30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f5855a;

    public d30() {
        this.f5855a = new ArrayList();
    }

    public d30(j30 j30Var) throws e30 {
        Object objD = j30Var.d();
        if (objD instanceof d30) {
            this.f5855a = ((d30) objD).f5855a;
        } else {
            c30.h(objD, "JSONArray");
            throw null;
        }
    }

    public d30(Object obj) throws e30 {
        if (!obj.getClass().isArray()) {
            throw new e30("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        this.f5855a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            k(g30.B(Array.get(obj, i)));
        }
    }

    public d30(String str) {
        this(new j30(str));
    }

    public d30(Collection collection) {
        this();
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                k(g30.B(it.next()));
            }
        }
    }

    public Object a(int i) throws e30 {
        try {
            Object obj = this.f5855a.get(i);
            if (obj != null) {
                return obj;
            }
            throw new e30("Value at " + i + " is null.");
        } catch (IndexOutOfBoundsException e) {
            throw new e30("Index " + i + " out of range [0.." + this.f5855a.size() + ")", e);
        }
    }

    public double b(int i) throws e30 {
        Object objA = a(i);
        Double dC = c30.c(objA);
        if (dC != null) {
            return dC.doubleValue();
        }
        c30.g(Integer.valueOf(i), objA, "double");
        throw null;
    }

    public int c(int i) throws e30 {
        Object objA = a(i);
        Integer numD = c30.d(objA);
        if (numD != null) {
            return numD.intValue();
        }
        c30.g(Integer.valueOf(i), objA, "int");
        throw null;
    }

    public g30 d(int i) {
        Object objA = a(i);
        if (objA instanceof g30) {
            return (g30) objA;
        }
        c30.g(Integer.valueOf(i), objA, "JSONObject");
        throw null;
    }

    public String e(int i) throws e30 {
        Object objA = a(i);
        String strF = c30.f(objA);
        if (strF != null) {
            return strF;
        }
        c30.g(Integer.valueOf(i), objA, "String");
        throw null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d30) && ((d30) obj).f5855a.equals(this.f5855a);
    }

    public boolean f(int i) {
        Object objH = h(i);
        return objH == null || objH == g30.f959a;
    }

    public int g() {
        return this.f5855a.size();
    }

    public Object h(int i) {
        if (i < 0 || i >= this.f5855a.size()) {
            return null;
        }
        return this.f5855a.get(i);
    }

    public int hashCode() {
        return this.f5855a.hashCode();
    }

    public d30 i(double d) throws e30 {
        List<Object> list = this.f5855a;
        c30.a(d);
        list.add(Double.valueOf(d));
        return this;
    }

    public d30 j(int i) {
        this.f5855a.add(Integer.valueOf(i));
        return this;
    }

    public d30 k(Object obj) {
        this.f5855a.add(obj);
        return this;
    }

    public void l(i30 i30Var) {
        i30Var.a();
        Iterator<Object> it = this.f5855a.iterator();
        while (it.hasNext()) {
            i30Var.n(it.next());
        }
        i30Var.e();
    }

    public String toString() {
        try {
            i30 i30Var = new i30();
            l(i30Var);
            return i30Var.toString();
        } catch (e30 unused) {
            return null;
        }
    }
}
