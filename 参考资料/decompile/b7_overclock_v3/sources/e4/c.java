package e4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f26604a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f26605b = new b();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lock f26606a = new ReentrantLock();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f26607b;
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f26608b = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<a> f26609a = new ArrayDeque();

        public a a() {
            a aVarPoll;
            synchronized (this.f26609a) {
                aVarPoll = this.f26609a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        public void b(a aVar) {
            synchronized (this.f26609a) {
                if (this.f26609a.size() < 10) {
                    this.f26609a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.f26604a.get(str);
            if (aVarA == null) {
                aVarA = this.f26605b.a();
                this.f26604a.put(str, aVarA);
            }
            aVarA.f26607b++;
        }
        aVarA.f26606a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) v4.m.d(this.f26604a.get(str));
            int i10 = aVar.f26607b;
            if (i10 < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f26607b);
            }
            int i11 = i10 - 1;
            aVar.f26607b = i11;
            if (i11 == 0) {
                a aVarRemove = this.f26604a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.f26605b.b(aVarRemove);
            }
        }
        aVar.f26606a.unlock();
    }
}
