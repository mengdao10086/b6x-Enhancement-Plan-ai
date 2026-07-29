package com.arialyy.aria.http.download;

import com.arialyy.aria.core.common.RequestEnum;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.BaseHttpThreadTaskAdapter;
import com.arialyy.aria.http.ConnectionHelp;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.BufferedRandomAccessFile;
import com.google.common.net.HttpHeaders;
import hb.u;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class HttpDThreadTaskAdapter extends BaseHttpThreadTaskAdapter {
    private final String TAG;
    private DTaskWrapper mTaskWrapper;

    public HttpDThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        super(subThreadConfig);
        this.TAG = "HttpDThreadTaskAdapter";
    }

    private void handleComplete() {
        if (!getThreadTask().isBreak() && getThreadTask().checkBlock()) {
            complete();
        }
    }

    private void readChunked(InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        int i10;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(getThreadConfig().tempFile, true);
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[getTaskConfig().getBuffSize()];
            while (getThreadTask().isLive() && (i10 = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
                BandwidthLimiter bandwidthLimiter = this.mSpeedBandUtil;
                if (bandwidthLimiter != null) {
                    bandwidthLimiter.limitNextBytes(i10);
                }
                fileOutputStream.write(bArr, 0, i10);
                progress(i10);
            }
            handleComplete();
            fileOutputStream.close();
        } catch (IOException e12) {
            e = e12;
            fileOutputStream2 = fileOutputStream;
            fail(new AriaHTTPException(String.format("文件下载失败，savePath: %s, url: %s", getEntity().getFilePath(), getThreadConfig().url), e), true);
            if (fileOutputStream2 == null) {
            } else {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc A[Catch: IOException -> 0x00f8, TryCatch #1 {IOException -> 0x00f8, blocks: (B:53:0x00f1, B:57:0x00fc, B:59:0x0101), top: B:63:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101 A[Catch: IOException -> 0x00f8, TRY_LEAVE, TryCatch #1 {IOException -> 0x00f8, blocks: (B:53:0x00f1, B:57:0x00fc, B:59:0x0101), top: B:63:0x00f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void readDynamicFile(java.io.InputStream r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.http.download.HttpDThreadTaskAdapter.readDynamicFile(java.io.InputStream):void");
    }

    private void readNormal(InputStream inputStream, BufferedRandomAccessFile bufferedRandomAccessFile) throws IOException {
        int i10;
        byte[] bArr = new byte[getTaskConfig().getBuffSize()];
        while (getThreadTask().isLive() && (i10 = inputStream.read(bArr)) != -1 && !getThreadTask().isBreak()) {
            BandwidthLimiter bandwidthLimiter = this.mSpeedBandUtil;
            if (bandwidthLimiter != null) {
                bandwidthLimiter.limitNextBytes(i10);
            }
            bufferedRandomAccessFile.write(bArr, 0, i10);
            progress(i10);
        }
    }

    @Override // com.arialyy.aria.core.task.AbsThreadTaskAdapter
    public void handlerThreadTask() throws Throwable {
        HttpURLConnection httpURLConnectionHandleConnection;
        BufferedInputStream bufferedInputStream;
        Exception e10;
        MalformedURLException e11;
        ArrayIndexOutOfBoundsException e12;
        IOException e13;
        Map<String, String> params;
        this.mTaskWrapper = (DTaskWrapper) getTaskWrapper();
        if (getThreadRecord().isComplete) {
            handleComplete();
            return;
        }
        BufferedRandomAccessFile bufferedRandomAccessFile = null;
        try {
            try {
                try {
                    httpURLConnectionHandleConnection = ConnectionHelp.handleConnection(ConnectionHelp.handleUrl(getThreadConfig().url, this.mTaskOption), this.mTaskOption);
                    try {
                        if (this.mTaskWrapper.isSupportBP()) {
                            ALog.d("HttpDThreadTaskAdapter", String.format("任务【%s】线程__%s__开始下载【开始位置 : %s，结束位置：%s】", getFileName(), Integer.valueOf(getThreadRecord().threadId), Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation)));
                            httpURLConnectionHandleConnection.setRequestProperty(HttpHeaders.RANGE, String.format("bytes=%s-%s", Long.valueOf(getThreadRecord().startLocation), Long.valueOf(getThreadRecord().endLocation - 1)));
                        } else {
                            ALog.w("HttpDThreadTaskAdapter", "该下载不支持断点");
                        }
                        ConnectionHelp.setConnectParam(this.mTaskOption, httpURLConnectionHandleConnection);
                        httpURLConnectionHandleConnection.setConnectTimeout(getTaskConfig().getConnectTimeOut());
                        httpURLConnectionHandleConnection.setReadTimeout(getTaskConfig().getIOTimeOut());
                        if (this.mTaskOption.isChunked()) {
                            httpURLConnectionHandleConnection.setDoInput(true);
                            httpURLConnectionHandleConnection.setChunkedStreamingMode(0);
                        }
                        httpURLConnectionHandleConnection.connect();
                        if (this.mTaskOption.getRequestEnum() == RequestEnum.POST && (params = this.mTaskOption.getParams()) != null) {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnectionHandleConnection.getOutputStream());
                            Set<String> setKeySet = params.keySet();
                            StringBuilder sb2 = new StringBuilder();
                            for (String str : setKeySet) {
                                sb2.append(str);
                                sb2.append(u.f30904o);
                                sb2.append(URLEncoder.encode(params.get(str)));
                                sb2.append("&");
                            }
                            String string = sb2.toString();
                            outputStreamWriter.write(string.substring(0, string.length() - 1));
                            outputStreamWriter.flush();
                            outputStreamWriter.close();
                        }
                        bufferedInputStream = new BufferedInputStream(ConnectionHelp.convertInputStream(httpURLConnectionHandleConnection));
                        try {
                            if (this.mTaskOption.isChunked()) {
                                readChunked(bufferedInputStream);
                            } else if (getThreadConfig().isBlock) {
                                readDynamicFile(bufferedInputStream);
                            } else {
                                BufferedRandomAccessFile bufferedRandomAccessFile2 = new BufferedRandomAccessFile(getThreadConfig().tempFile, "rwd", getTaskConfig().getBuffSize());
                                try {
                                    if (getThreadRecord().startLocation > 0) {
                                        bufferedRandomAccessFile2.seek(getThreadRecord().startLocation);
                                    }
                                    readNormal(bufferedInputStream, bufferedRandomAccessFile2);
                                    handleComplete();
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                } catch (IOException e14) {
                                    e13 = e14;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e13), true);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnectionHandleConnection != null) {
                                        httpURLConnectionHandleConnection.getInputStream().close();
                                        httpURLConnectionHandleConnection.disconnect();
                                        return;
                                    }
                                    return;
                                } catch (ArrayIndexOutOfBoundsException e15) {
                                    e12 = e15;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e12), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnectionHandleConnection != null) {
                                        httpURLConnectionHandleConnection.getInputStream().close();
                                        httpURLConnectionHandleConnection.disconnect();
                                        return;
                                    }
                                    return;
                                } catch (MalformedURLException e16) {
                                    e11 = e16;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e11), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnectionHandleConnection != null) {
                                        httpURLConnectionHandleConnection.getInputStream().close();
                                        httpURLConnectionHandleConnection.disconnect();
                                        return;
                                    }
                                    return;
                                } catch (Exception e17) {
                                    e10 = e17;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    fail(new AriaHTTPException(String.format("任务【%s】下载失败，filePath: %s, url: %s", getFileName(), getEntity().getFilePath(), getEntity().getUrl()), e10), false);
                                    if (bufferedRandomAccessFile != null) {
                                        bufferedRandomAccessFile.close();
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnectionHandleConnection != null) {
                                        httpURLConnectionHandleConnection.getInputStream().close();
                                        httpURLConnectionHandleConnection.disconnect();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedRandomAccessFile = bufferedRandomAccessFile2;
                                    if (bufferedRandomAccessFile != null) {
                                        try {
                                            bufferedRandomAccessFile.close();
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (bufferedInputStream != null) {
                                        bufferedInputStream.close();
                                    }
                                    if (httpURLConnectionHandleConnection != null) {
                                        httpURLConnectionHandleConnection.getInputStream().close();
                                        httpURLConnectionHandleConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedRandomAccessFile != null) {
                                bufferedRandomAccessFile.close();
                            }
                            bufferedInputStream.close();
                            httpURLConnectionHandleConnection.getInputStream().close();
                            httpURLConnectionHandleConnection.disconnect();
                        } catch (IOException e19) {
                            e13 = e19;
                        } catch (ArrayIndexOutOfBoundsException e20) {
                            e12 = e20;
                        } catch (MalformedURLException e21) {
                            e11 = e21;
                        } catch (Exception e22) {
                            e10 = e22;
                        }
                    } catch (MalformedURLException e23) {
                        e11 = e23;
                        bufferedInputStream = null;
                    } catch (IOException e24) {
                        e13 = e24;
                        bufferedInputStream = null;
                    } catch (ArrayIndexOutOfBoundsException e25) {
                        e12 = e25;
                        bufferedInputStream = null;
                    } catch (Exception e26) {
                        e10 = e26;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e27) {
                httpURLConnectionHandleConnection = null;
                e13 = e27;
                bufferedInputStream = null;
            } catch (ArrayIndexOutOfBoundsException e28) {
                httpURLConnectionHandleConnection = null;
                e12 = e28;
                bufferedInputStream = null;
            } catch (MalformedURLException e29) {
                httpURLConnectionHandleConnection = null;
                e11 = e29;
                bufferedInputStream = null;
            } catch (Exception e30) {
                httpURLConnectionHandleConnection = null;
                e10 = e30;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                httpURLConnectionHandleConnection = null;
                bufferedInputStream = null;
            }
        } catch (IOException e31) {
            e31.printStackTrace();
        }
    }
}
