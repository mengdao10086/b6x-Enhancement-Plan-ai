package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
    public double maxPermits;
    private long nextFreeTicketMicros;
    public double stableIntervalMicros;
    public double storedPermits;

    public static final class SmoothBursty extends SmoothRateLimiter {
        public final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d10) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d10;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d10, double d11) {
            double d12 = this.maxPermits;
            double d13 = this.maxBurstSeconds * d10;
            this.maxPermits = d13;
            if (d12 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d13;
            } else {
                this.storedPermits = d12 != 0.0d ? (this.storedPermits * d13) / d12 : 0.0d;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d10, double d11) {
            return 0L;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j10, TimeUnit timeUnit, double d10) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j10);
            this.coldFactor = d10;
        }

        private double permitsToTime(double d10) {
            return this.stableIntervalMicros + (d10 * this.slope);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public double coolDownIntervalMicros() {
            return this.warmupPeriodMicros / this.maxPermits;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public void doSetRate(double d10, double d11) {
            double d12 = this.maxPermits;
            double d13 = this.coldFactor * d11;
            long j10 = this.warmupPeriodMicros;
            double d14 = (j10 * 0.5d) / d11;
            this.thresholdPermits = d14;
            double d15 = ((j10 * 2.0d) / (d11 + d13)) + d14;
            this.maxPermits = d15;
            this.slope = (d13 - d11) / (d15 - d14);
            if (d12 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d12 != 0.0d) {
                d15 = (this.storedPermits * d15) / d12;
            }
            this.storedPermits = d15;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        public long storedPermitsToWaitTime(double d10, double d11) {
            long jPermitsToTime;
            double d12 = d10 - this.thresholdPermits;
            if (d12 > 0.0d) {
                double dMin = Math.min(d12, d11);
                jPermitsToTime = (long) (((permitsToTime(d12) + permitsToTime(d12 - dMin)) * dMin) / 2.0d);
                d11 -= dMin;
            } else {
                jPermitsToTime = 0;
            }
            return jPermitsToTime + ((long) (this.stableIntervalMicros * d11));
        }
    }

    public abstract double coolDownIntervalMicros();

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double doGetRate() {
        return TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
    }

    public abstract void doSetRate(double d10, double d11);

    @Override // com.google.common.util.concurrent.RateLimiter
    public final void doSetRate(double d10, long j10) {
        resync(j10);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d10;
        this.stableIntervalMicros = micros;
        doSetRate(d10, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long queryEarliestAvailable(long j10) {
        return this.nextFreeTicketMicros;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final long reserveEarliestAvailable(int i10, long j10) {
        resync(j10);
        long j11 = this.nextFreeTicketMicros;
        double d10 = i10;
        double dMin = Math.min(d10, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, dMin) + ((long) ((d10 - dMin) * this.stableIntervalMicros)));
        this.storedPermits -= dMin;
        return j11;
    }

    public void resync(long j10) {
        if (j10 > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + ((j10 - r0) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j10;
        }
    }

    public abstract long storedPermitsToWaitTime(double d10, double d11);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0L;
    }
}
