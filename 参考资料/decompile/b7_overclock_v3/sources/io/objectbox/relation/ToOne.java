package io.objectbox.relation;

import com.blankj.utilcode.util.i0;
import ii.a;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.exception.DbDetachedException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import javax.annotation.Nullable;
import li.c;
import ni.f;

/* JADX INFO: loaded from: classes5.dex */
public class ToOne<TARGET> implements Serializable {
    private static final long serialVersionUID = 5092547044335989281L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BoxStore f32919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient a<Object> f32920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile transient a<TARGET> f32921c;
    private boolean checkIdOfTargetForPut;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Field f32922d;
    private boolean debugRelations;
    private final Object entity;
    private final RelationInfo<Object, TARGET> relationInfo;
    private volatile long resolvedTargetId;
    private TARGET target;
    private long targetId;
    private final boolean virtualProperty;

    public ToOne(Object obj, RelationInfo<?, TARGET> relationInfo) {
        if (obj == null) {
            throw new IllegalArgumentException("No source entity given (null)");
        }
        if (relationInfo == null) {
            throw new IllegalArgumentException("No relation info given (null)");
        }
        this.entity = obj;
        this.relationInfo = relationInfo;
        this.virtualProperty = relationInfo.targetIdProperty.isVirtual;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void r(Object obj) {
        w(obj, this.f32921c.G(obj));
        this.f32920b.G(this.entity);
    }

    public final synchronized void b() {
        this.resolvedTargetId = 0L;
        this.target = null;
    }

    public final void c(@Nullable TARGET target) {
        if (this.f32921c == null) {
            try {
                BoxStore boxStore = (BoxStore) f.b().a(this.entity.getClass(), "__boxStore").get(this.entity);
                this.f32919a = boxStore;
                if (boxStore == null) {
                    if (target != null) {
                        this.f32919a = (BoxStore) f.b().a(target.getClass(), "__boxStore").get(target);
                    }
                    if (this.f32919a == null) {
                        throw new DbDetachedException("Cannot resolve relation for detached entities, call box.attach(entity) beforehand.");
                    }
                }
                this.debugRelations = this.f32919a.q2();
                this.f32920b = this.f32919a.i(this.relationInfo.sourceInfo.getEntityClass());
                this.f32921c = this.f32919a.i(this.relationInfo.targetInfo.getEntityClass());
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public TARGET d() {
        return this.target;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ToOne)) {
            return false;
        }
        ToOne toOne = (ToOne) obj;
        return this.relationInfo == toOne.relationInfo && k() == toOne.k();
    }

    public Object f() {
        return this.entity;
    }

    public TARGET h() {
        return i(k());
    }

    public int hashCode() {
        long jK = k();
        return (int) (jK ^ (jK >>> 32));
    }

    @c
    public TARGET i(long j10) {
        synchronized (this) {
            if (this.resolvedTargetId == j10) {
                return this.target;
            }
            c(null);
            TARGET targetG = this.f32921c.g(j10);
            w(targetG, j10);
            return targetG;
        }
    }

    public long k() {
        if (this.virtualProperty) {
            return this.targetId;
        }
        Field fieldL = l();
        try {
            Long l10 = (Long) fieldL.get(this.entity);
            if (l10 != null) {
                return l10.longValue();
            }
            return 0L;
        } catch (IllegalAccessException unused) {
            throw new RuntimeException("Could not access field " + fieldL);
        }
    }

    public final Field l() {
        if (this.f32922d == null) {
            this.f32922d = f.b().a(this.entity.getClass(), this.relationInfo.targetIdProperty.name);
        }
        return this.f32922d;
    }

    @c
    public void m(Cursor<TARGET> cursor) {
        this.checkIdOfTargetForPut = false;
        long jPut = cursor.put(this.target);
        setTargetId(jPut);
        w(this.target, jPut);
    }

    @c
    public boolean n() {
        return this.checkIdOfTargetForPut && this.target != null && k() == 0;
    }

    public boolean o() {
        return k() == 0 && this.target == null;
    }

    public boolean p() {
        return this.resolvedTargetId == k();
    }

    public boolean q() {
        return this.resolvedTargetId != 0 && this.resolvedTargetId == k();
    }

    public void setTargetId(long j10) {
        if (this.virtualProperty) {
            this.targetId = j10;
        } else {
            try {
                l().set(this.entity, Long.valueOf(j10));
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Could not update to-one ID in entity", e10);
            }
        }
        if (j10 != 0) {
            this.checkIdOfTargetForPut = false;
        }
    }

    public void t(@Nullable TARGET target) {
        c(target);
        if (target == null) {
            setTargetId(0L);
            b();
            this.f32920b.G(this.entity);
            return;
        }
        long jN = this.f32921c.n(target);
        if (jN == 0) {
            u(target);
            return;
        }
        setTargetId(jN);
        w(target, jN);
        this.f32920b.G(this.entity);
    }

    public void u(@Nullable final TARGET target) {
        c(target);
        if (target != null) {
            this.f32919a.D2(new Runnable() { // from class: qi.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f47365a.r(target);
                }
            });
            return;
        }
        setTargetId(0L);
        b();
        this.f32920b.G(this.entity);
    }

    public void v(long j10) {
        setTargetId(j10);
        c(null);
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public final synchronized void w(@Nullable TARGET target, long j10) {
        if (this.debugRelations) {
            PrintStream printStream = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting resolved ToOne target to ");
            sb2.append(target == null ? i0.f11859x : "non-null");
            sb2.append(" for ID ");
            sb2.append(j10);
            printStream.println(sb2.toString());
        }
        this.resolvedTargetId = j10;
        this.target = target;
    }

    public void x(@Nullable TARGET target) {
        if (target == null) {
            setTargetId(0L);
            b();
        } else {
            long id2 = this.relationInfo.targetInfo.getIdGetter().getId(target);
            this.checkIdOfTargetForPut = id2 == 0;
            setTargetId(id2);
            w(target, id2);
        }
    }
}
