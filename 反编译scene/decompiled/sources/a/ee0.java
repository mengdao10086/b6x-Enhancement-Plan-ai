package a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ee0 extends HashMap<String, String> {
    public ee0(boolean z) {
        put("state", z ? "1" : "0");
    }

    public /* bridge */ boolean a(String str) {
        return super.containsKey(str);
    }

    public /* bridge */ boolean b(String str) {
        return super.containsValue(str);
    }

    public /* bridge */ String c(String str) {
        return (String) super.get(str);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return a((String) obj);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof String) {
            return b((String) obj);
        }
        return false;
    }

    public /* bridge */ Set d() {
        return super.entrySet();
    }

    public /* bridge */ Set e() {
        return super.keySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return d();
    }

    public /* bridge */ String f(String str, String str2) {
        return (String) super.getOrDefault(str, str2);
    }

    public /* bridge */ int g() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return c((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj instanceof String ? f((String) obj, (String) obj2) : obj2;
    }

    public /* bridge */ Collection h() {
        return super.values();
    }

    public /* bridge */ String i(String str) {
        return (String) super.remove(str);
    }

    public /* bridge */ boolean j(String str, String str2) {
        return super.remove(str, str2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return e();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return i((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof String)) {
            return j((String) obj, (String) obj2);
        }
        return false;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<String> values() {
        return h();
    }
}
