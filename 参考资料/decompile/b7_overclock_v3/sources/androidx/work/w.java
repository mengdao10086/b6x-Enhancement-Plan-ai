package androidx.work;

import android.annotation.SuppressLint;
import androidx.work.WorkInfo;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<UUID> f8751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f8752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f8753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<WorkInfo.State> f8754d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<UUID> f8755a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f8756b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f8757c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<WorkInfo.State> f8758d = new ArrayList();

        @SuppressLint({"BuilderSetStyle"})
        @n0
        public static a f(@n0 List<UUID> ids) {
            a aVar = new a();
            aVar.a(ids);
            return aVar;
        }

        @SuppressLint({"BuilderSetStyle"})
        @n0
        public static a g(@n0 List<WorkInfo.State> states) {
            a aVar = new a();
            aVar.b(states);
            return aVar;
        }

        @SuppressLint({"BuilderSetStyle"})
        @n0
        public static a h(@n0 List<String> tags) {
            a aVar = new a();
            aVar.c(tags);
            return aVar;
        }

        @SuppressLint({"BuilderSetStyle"})
        @n0
        public static a i(@n0 List<String> uniqueWorkNames) {
            a aVar = new a();
            aVar.d(uniqueWorkNames);
            return aVar;
        }

        @n0
        public a a(@n0 List<UUID> ids) {
            this.f8755a.addAll(ids);
            return this;
        }

        @n0
        public a b(@n0 List<WorkInfo.State> states) {
            this.f8758d.addAll(states);
            return this;
        }

        @n0
        public a c(@n0 List<String> tags) {
            this.f8757c.addAll(tags);
            return this;
        }

        @n0
        public a d(@n0 List<String> uniqueWorkNames) {
            this.f8756b.addAll(uniqueWorkNames);
            return this;
        }

        @n0
        public w e() {
            if (this.f8755a.isEmpty() && this.f8756b.isEmpty() && this.f8757c.isEmpty() && this.f8758d.isEmpty()) {
                throw new IllegalArgumentException("Must specify ids, uniqueNames, tags or states when building a WorkQuery");
            }
            return new w(this);
        }
    }

    public w(@n0 a builder) {
        this.f8751a = builder.f8755a;
        this.f8752b = builder.f8756b;
        this.f8753c = builder.f8757c;
        this.f8754d = builder.f8758d;
    }

    @n0
    public List<UUID> a() {
        return this.f8751a;
    }

    @n0
    public List<WorkInfo.State> b() {
        return this.f8754d;
    }

    @n0
    public List<String> c() {
        return this.f8753c;
    }

    @n0
    public List<String> d() {
        return this.f8752b;
    }
}
