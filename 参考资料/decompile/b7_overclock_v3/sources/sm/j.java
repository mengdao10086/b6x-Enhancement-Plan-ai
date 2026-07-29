package sm;

import com.blankj.utilcode.util.i0;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49996a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f49997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f49998b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public StringBuffer f49999c = new StringBuffer();

        public a(String str) {
            this.f49997a = str;
        }

        public void a(String str) {
            if (this.f49998b) {
                this.f49998b = false;
            } else {
                this.f49999c.append(this.f49997a);
            }
            this.f49999c.append(str);
        }

        public String toString() {
            return this.f49999c.toString();
        }
    }

    public j() {
        this.f49996a = 0;
    }

    public j(int i10) {
        this.f49996a = i10;
    }

    public String a(Hashtable hashtable) {
        a aVar = new a(i0.f11861z);
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Integer num = (Integer) enumerationKeys.nextElement();
            if (c(num.intValue())) {
                aVar.a((String) hashtable.get(num));
            }
        }
        return aVar.toString();
    }

    public int b() {
        return this.f49996a;
    }

    public boolean c(int i10) {
        return (i10 & this.f49996a) != 0;
    }

    public void d(int i10) {
        this.f49996a = i10 | this.f49996a;
    }
}
