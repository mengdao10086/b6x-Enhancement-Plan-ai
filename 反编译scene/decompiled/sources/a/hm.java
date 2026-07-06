package a;

import a.hn;
import androidx.fragment.app.Fragment;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f1185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1188a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f1189b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<String> f1190b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ArrayList<String> f1192c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ArrayList<Runnable> f1193d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<gm> f1187a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1191b = false;

    public hm b(int i, Fragment fragment, String str) {
        k(i, fragment, str, 1);
        return this;
    }

    public hm c(Fragment fragment, String str) {
        k(0, fragment, str, 1);
        return this;
    }

    public void d(gm gmVar) {
        this.f1187a.add(gmVar);
        gmVar.b = this.f6323a;
        gmVar.c = this.b;
        gmVar.d = this.c;
        gmVar.e = this.d;
    }

    public hm e(Fragment fragment) {
        d(new gm(7, fragment));
        return this;
    }

    public abstract int f();

    public abstract int g();

    public abstract void h();

    public hm i(Fragment fragment) {
        d(new gm(6, fragment));
        return this;
    }

    public hm j() {
        if (this.f1188a) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    public void k(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f4275c;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f4275c + " now " + str);
            }
            fragment.f4275c = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.d;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.d + " now " + i);
            }
            fragment.d = i;
            fragment.e = i;
        }
        d(new gm(i2, fragment));
    }

    public hm l(Fragment fragment) {
        d(new gm(3, fragment));
        return this;
    }

    public hm m(int i, Fragment fragment) {
        n(i, fragment, null);
        return this;
    }

    public hm n(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        k(i, fragment, str, 2);
        return this;
    }

    public hm o(Fragment fragment, hn.b bVar) {
        d(new gm(10, fragment, bVar));
        return this;
    }
}
