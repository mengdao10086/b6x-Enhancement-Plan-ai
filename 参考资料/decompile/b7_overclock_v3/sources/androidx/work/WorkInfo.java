package androidx.work;

import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class WorkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public UUID f8290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public State f8291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public d f8292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public Set<String> f8293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public d f8294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8295f;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkInfo(@n0 UUID id2, @n0 State state, @n0 d outputData, @n0 List<String> tags, @n0 d progress, int runAttemptCount) {
        this.f8290a = id2;
        this.f8291b = state;
        this.f8292c = outputData;
        this.f8293d = new HashSet(tags);
        this.f8294e = progress;
        this.f8295f = runAttemptCount;
    }

    @n0
    public UUID a() {
        return this.f8290a;
    }

    @n0
    public d b() {
        return this.f8292c;
    }

    @n0
    public d c() {
        return this.f8294e;
    }

    @f0(from = 0)
    public int d() {
        return this.f8295f;
    }

    @n0
    public State e() {
        return this.f8291b;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || WorkInfo.class != o10.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) o10;
        if (this.f8295f == workInfo.f8295f && this.f8290a.equals(workInfo.f8290a) && this.f8291b == workInfo.f8291b && this.f8292c.equals(workInfo.f8292c) && this.f8293d.equals(workInfo.f8293d)) {
            return this.f8294e.equals(workInfo.f8294e);
        }
        return false;
    }

    @n0
    public Set<String> f() {
        return this.f8293d;
    }

    public int hashCode() {
        return (((((((((this.f8290a.hashCode() * 31) + this.f8291b.hashCode()) * 31) + this.f8292c.hashCode()) * 31) + this.f8293d.hashCode()) * 31) + this.f8294e.hashCode()) * 31) + this.f8295f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f8290a + "', mState=" + this.f8291b + ", mOutputData=" + this.f8292c + ", mTags=" + this.f8293d + ", mProgress=" + this.f8294e + '}';
    }
}
