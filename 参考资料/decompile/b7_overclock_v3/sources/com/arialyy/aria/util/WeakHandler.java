package com.arialyy.aria.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class WeakHandler {
    private final Handler.Callback mCallback;
    private final ExecHandler mExec;
    private Lock mLock;
    public final ChainedRef mRunnables;

    public static class WeakRunnable implements Runnable {
        private final WeakReference<Runnable> mDelegate;
        private final WeakReference<ChainedRef> mReference;

        public WeakRunnable(WeakReference<Runnable> weakReference, WeakReference<ChainedRef> weakReference2) {
            this.mDelegate = weakReference;
            this.mReference = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.mDelegate.get();
            ChainedRef chainedRef = this.mReference.get();
            if (chainedRef != null) {
                chainedRef.remove();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public WeakHandler() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler();
    }

    private WeakRunnable wrapRunnable(Runnable runnable) {
        Objects.requireNonNull(runnable, "Runnable can't be null");
        ChainedRef chainedRef = new ChainedRef(this.mLock, runnable);
        this.mRunnables.insertAfter(chainedRef);
        return chainedRef.wrapper;
    }

    public final Looper getLooper() {
        return this.mExec.getLooper();
    }

    public final boolean hasMessages(int i10) {
        return this.mExec.hasMessages(i10);
    }

    public final boolean post(Runnable runnable) {
        return this.mExec.post(wrapRunnable(runnable));
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return this.mExec.postAtFrontOfQueue(wrapRunnable(runnable));
    }

    public final boolean postAtTime(Runnable runnable, long j10) {
        return this.mExec.postAtTime(wrapRunnable(runnable), j10);
    }

    public final boolean postDelayed(Runnable runnable, long j10) {
        return this.mExec.postDelayed(wrapRunnable(runnable), j10);
    }

    public final void removeCallbacks(Runnable runnable) {
        WeakRunnable weakRunnableRemove = this.mRunnables.remove(runnable);
        if (weakRunnableRemove != null) {
            this.mExec.removeCallbacks(weakRunnableRemove);
        }
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.mExec.removeCallbacksAndMessages(obj);
    }

    public final void removeMessages(int i10) {
        this.mExec.removeMessages(i10);
    }

    public final boolean sendEmptyMessage(int i10) {
        return this.mExec.sendEmptyMessage(i10);
    }

    public final boolean sendEmptyMessageAtTime(int i10, long j10) {
        return this.mExec.sendEmptyMessageAtTime(i10, j10);
    }

    public final boolean sendEmptyMessageDelayed(int i10, long j10) {
        return this.mExec.sendEmptyMessageDelayed(i10, j10);
    }

    public final boolean sendMessage(Message message) {
        return this.mExec.sendMessage(message);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        return this.mExec.sendMessageAtFrontOfQueue(message);
    }

    public boolean sendMessageAtTime(Message message, long j10) {
        return this.mExec.sendMessageAtTime(message, j10);
    }

    public final boolean sendMessageDelayed(Message message, long j10) {
        return this.mExec.sendMessageDelayed(message, j10);
    }

    public static class ExecHandler extends Handler {
        private final WeakReference<Handler.Callback> mCallback;

        public ExecHandler() {
            this.mCallback = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.mCallback;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }

        public ExecHandler(WeakReference<Handler.Callback> weakReference) {
            this.mCallback = weakReference;
        }

        public ExecHandler(Looper looper) {
            super(looper);
            this.mCallback = null;
        }

        public ExecHandler(Looper looper, WeakReference<Handler.Callback> weakReference) {
            super(looper);
            this.mCallback = weakReference;
        }
    }

    public final boolean hasMessages(int i10, Object obj) {
        return this.mExec.hasMessages(i10, obj);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j10) {
        return this.mExec.postAtTime(wrapRunnable(runnable), obj, j10);
    }

    public final void removeMessages(int i10, Object obj) {
        this.mExec.removeMessages(i10, obj);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        WeakRunnable weakRunnableRemove = this.mRunnables.remove(runnable);
        if (weakRunnableRemove != null) {
            this.mExec.removeCallbacks(weakRunnableRemove, obj);
        }
    }

    public WeakHandler(Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new ExecHandler((WeakReference<Handler.Callback>) new WeakReference(callback));
    }

    public static class ChainedRef {
        public Lock lock;
        public ChainedRef next;
        public ChainedRef prev;
        public final Runnable runnable;
        public final WeakRunnable wrapper;

        public ChainedRef(Lock lock, Runnable runnable) {
            this.runnable = runnable;
            this.lock = lock;
            this.wrapper = new WeakRunnable(new WeakReference(runnable), new WeakReference(this));
        }

        public void insertAfter(ChainedRef chainedRef) {
            this.lock.lock();
            try {
                ChainedRef chainedRef2 = this.next;
                if (chainedRef2 != null) {
                    chainedRef2.prev = chainedRef;
                }
                chainedRef.next = chainedRef2;
                this.next = chainedRef;
                chainedRef.prev = this;
            } finally {
                this.lock.unlock();
            }
        }

        public WeakRunnable remove() {
            this.lock.lock();
            try {
                ChainedRef chainedRef = this.prev;
                if (chainedRef != null) {
                    chainedRef.next = this.next;
                }
                ChainedRef chainedRef2 = this.next;
                if (chainedRef2 != null) {
                    chainedRef2.prev = chainedRef;
                }
                this.prev = null;
                this.next = null;
                this.lock.unlock();
                return this.wrapper;
            } catch (Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
        }

        public WeakRunnable remove(Runnable runnable) {
            this.lock.lock();
            try {
                for (ChainedRef chainedRef = this.next; chainedRef != null; chainedRef = chainedRef.next) {
                    if (chainedRef.runnable == runnable) {
                        return chainedRef.remove();
                    }
                }
                this.lock.unlock();
                return null;
            } finally {
                this.lock.unlock();
            }
        }
    }

    public WeakHandler(Looper looper) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new ExecHandler(looper);
    }

    public WeakHandler(Looper looper, Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new ChainedRef(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new ExecHandler(looper, new WeakReference(callback));
    }
}
