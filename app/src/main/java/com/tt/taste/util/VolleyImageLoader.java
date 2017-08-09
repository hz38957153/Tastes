package com.tt.taste.util;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class VolleyImageLoader {

	/**
	 * @author hz
	 * @param mQueue ��Ϣ����
	 * @param view ��ʾͼƬ�Ŀؼ�
	 * @param defaultImg ��������ʾ��ͼƬ
	 * @param errorImg ����ʧ����ʾ�Ŀؼ�
	 * @param url ͼƬ��ַ
	 */
	public static void ImageLoader(RequestQueue mQueue, NetworkImageView view, int defaultImg, int errorImg, String url){
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache() {
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
				
			}

			@Override
			public Bitmap getBitmap(String url) {
				return null;
			}
		});
		(view).setDefaultImageResId(defaultImg);
		(view).setErrorImageResId(errorImg);
		(view).setImageUrl(url,imageLoader);
		(view).refreshDrawableState();
		(view).destroyDrawingCache();
		(view).clearColorFilter();
		(view).refreshDrawableState();
	}
	
}
