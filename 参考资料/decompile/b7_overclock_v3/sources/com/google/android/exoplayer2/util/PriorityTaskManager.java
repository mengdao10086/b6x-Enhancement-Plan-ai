package com.google.android.exoplayer2.util;

import hd.u0;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19296a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityQueue<Integer> f19297b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19298c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i10, int i11) {
            super("Priority too low [priority=" + i10 + ", highest=" + i11 + "]");
        }
    }

    public void a(int i10) {
        synchronized (this.f19296a) {
            this.f19297b.add(Integer.valueOf(i10));
            this.f19298c = Math.max(this.f19298c, i10);
        }
    }

    public void b(int i10) throws InterruptedException {
        synchronized (this.f19296a) {
            while (this.f19298c != i10) {
                this.f19296a.wait();
            }
        }
    }

    public boolean c(int i10) {
        boolean z10;
        synchronized (this.f19296a) {
            z10 = this.f19298c == i10;
        }
        return z10;
    }

    public void d(int i10) throws PriorityTooLowException {
        synchronized (this.f19296a) {
            if (this.f19298c != i10) {
                throw new PriorityTooLowException(i10, this.f19298c);
            }
        }
    }

    public void e(int i10) {
        synchronized (this.f19296a) {
            this.f19297b.remove(Integer.valueOf(i10));
            this.f19298c = this.f19297b.isEmpty() ? Integer.MIN_VALUE : ((Integer) u0.k(this.f19297b.peek())).intValue();
            this.f19296a.notifyAll();
        }
    }
}
