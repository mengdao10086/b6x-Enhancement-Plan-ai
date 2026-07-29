package v5;

import android.util.LruCache;
import com.blankj.utilcode.util.n0;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache f52718a = new a(((int) (Runtime.getRuntime().totalMemory() / 1024)) / 8);

    public class a extends LruCache<String, ArrayList<CFGPropertyMacro>> {
        public a(int maxSize) {
            super(maxSize);
        }

        @Override // android.util.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String key, ArrayList<CFGPropertyMacro> value) {
            return value.size() / 1024;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f52720a = new e();
    }

    public static e b() {
        return b.f52720a;
    }

    public ArrayList<CFGPropertyMacro> a(String pkgName) {
        Object obj;
        if (n0.m(pkgName) || (obj = this.f52718a.get(pkgName)) == null) {
            return null;
        }
        return (ArrayList) obj;
    }

    public void c(String pkgName, ArrayList<CFGPropertyMacro> listCFGPropertyMacro) {
        this.f52718a.put(pkgName, listCFGPropertyMacro);
    }
}
