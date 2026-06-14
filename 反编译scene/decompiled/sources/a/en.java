package a;

import a.hn;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Method f774a;

    public en(int i, Method method) {
        this.f6022a = i;
        this.f774a = method;
        method.setAccessible(true);
    }

    public void a(kn knVar, hn.a aVar, Object obj) {
        try {
            int i = this.f6022a;
            if (i == 0) {
                this.f774a.invoke(obj, new Object[0]);
            } else if (i == 1) {
                this.f774a.invoke(obj, knVar);
            } else {
                if (i != 2) {
                    return;
                }
                this.f774a.invoke(obj, knVar, aVar);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to call observer method", e2.getCause());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || en.class != obj.getClass()) {
            return false;
        }
        en enVar = (en) obj;
        return this.f6022a == enVar.f6022a && this.f774a.getName().equals(enVar.f774a.getName());
    }

    public int hashCode() {
        return (this.f6022a * 31) + this.f774a.getName().hashCode();
    }
}
