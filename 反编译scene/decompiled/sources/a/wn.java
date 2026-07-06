package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xn f3458a;

    public interface a {
        <T extends vn> T a(Class<T> cls);
    }

    public wn(xn xnVar, a aVar) {
        this.f7804a = aVar;
        this.f3458a = xnVar;
    }

    public <T extends vn> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends vn> T b(String str, Class<T> cls) {
        T t = (T) this.f3458a.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f7804a.a(cls);
        this.f3458a.c(str, t2);
        return t2;
    }
}
