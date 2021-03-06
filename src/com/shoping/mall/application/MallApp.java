package com.shoping.mall.application;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okio.Buffer;
import android.annotation.SuppressLint;
import android.app.Application;

import com.shoping.mall.exception.CrashHandler;
import com.shoping.mall.study.okhttp.lib.OkHttpClientManager;
import com.shoping.mall.util.LogUtil;

public class MallApp extends Application {

	
	
	private static boolean isConnect;
	
	// 组件实例
	private static MallApp mMallApp;
	
	public static MallApp getInstance() {
		return mMallApp;
	}

	public boolean isRun;
	public boolean isDown;
	
	 private String CER_12306 = "-----BEGIN CERTIFICATE-----\n" +
	            "MIICmjCCAgOgAwIBAgIIbyZr5/jKH6QwDQYJKoZIhvcNAQEFBQAwRzELMAkGA1UEBhMCQ04xKTAn\n" +
	            "BgNVBAoTIFNpbm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMB4X\n" +
	            "DTA5MDUyNTA2NTYwMFoXDTI5MDUyMDA2NTYwMFowRzELMAkGA1UEBhMCQ04xKTAnBgNVBAoTIFNp\n" +
	            "bm9yYWlsIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MQ0wCwYDVQQDEwRTUkNBMIGfMA0GCSqGSIb3\n" +
	            "DQEBAQUAA4GNADCBiQKBgQDMpbNeb34p0GvLkZ6t72/OOba4mX2K/eZRWFfnuk8e5jKDH+9BgCb2\n" +
	            "9bSotqPqTbxXWPxIOz8EjyUO3bfR5pQ8ovNTOlks2rS5BdMhoi4sUjCKi5ELiqtyww/XgY5iFqv6\n" +
	            "D4Pw9QvOUcdRVSbPWo1DwMmH75It6pk/rARIFHEjWwIDAQABo4GOMIGLMB8GA1UdIwQYMBaAFHle\n" +
	            "tne34lKDQ+3HUYhMY4UsAENYMAwGA1UdEwQFMAMBAf8wLgYDVR0fBCcwJTAjoCGgH4YdaHR0cDov\n" +
	            "LzE5Mi4xNjguOS4xNDkvY3JsMS5jcmwwCwYDVR0PBAQDAgH+MB0GA1UdDgQWBBR5XrZ3t+JSg0Pt\n" +
	            "x1GITGOFLABDWDANBgkqhkiG9w0BAQUFAAOBgQDGrAm2U/of1LbOnG2bnnQtgcVaBXiVJF8LKPaV\n" +
	            "23XQ96HU8xfgSZMJS6U00WHAI7zp0q208RSUft9wDq9ee///VOhzR6Tebg9QfyPSohkBrhXQenvQ\n" +
	            "og555S+C3eJAAVeNCTeMS3N/M5hzBRJAoffn3qoYdAO1Q8bTguOi+2849A==\n" +
	            "-----END CERTIFICATE-----";
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		if(!LogUtil.isOutPutLog){
			CrashHandler crashHandler = CrashHandler.getInstance();
			crashHandler.init(this);
		}
		mMallApp = this;
		
	    OkHttpClientManager.getInstance().setCertificates(new InputStream[]{
	                new Buffer()
	                        .writeUtf8(CER_12306)
	                        .inputStream()});
	   OkHttpClientManager.getInstance().getOkHttpClient().setConnectTimeout(100000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}

	@SuppressLint("NewApi")
	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		switch (level) {
		case TRIM_MEMORY_UI_HIDDEN:
			
			break;

		default:
			break;
		}
	}

	public static boolean isConnect(){
		return isConnect;
	}
	
	public static void setConnect(boolean connect){
		isConnect = connect;
	}
}
