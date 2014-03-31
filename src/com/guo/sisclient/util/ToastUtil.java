package com.guo.sisclient.util;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtil工具类
 * 
 * @author 20130701
 *   
 */
public class ToastUtil {
	/**
	 * 基本类
	 * 
	 * @param context
	 * @param message
	 * @param time
	 */
	private static Toast toast;
	
	private static void ToastBase(Context context, String message, int time) {

		if(toast != null){
			toast.cancel();
		}
		toast = Toast.makeText(context, message, time);
		toast.show();
	}
	
	/**
     * Toast提示
     * @param string 提示内容
   */
	public static void toastHint(Context context , boolean isLong , String string){
		if(isLong){
			Toast.makeText(context,string,
					Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(context,string,
					Toast.LENGTH_SHORT).show();
		}
		
	}
	

	/**
	 * 连接超时
	 * @param context
	 */
	public static void timeOutToast(Context context) {
		ToastBase(context, "与服务器连接超时！", Toast.LENGTH_LONG);
	}

	/**信息获取失败
	 * @param context
	 */
	public static void dateFaile(Context context) {
		ToastBase(context, "信息获取失败！", Toast.LENGTH_LONG);
	}

	/**
	 * 自定义信息
	 * @param context
	 * @param mes
	 */
	public static void customMes(Context context, String mes) {

		ToastBase(context, mes, Toast.LENGTH_LONG);
	}
	
	/**
	 * 自定义信息，显示时间短
	 * @param context
	 * @param mes
	 */
	public static void customMesShort(Context context, String mes){
		ToastBase(context, mes, Toast.LENGTH_SHORT);
	}

	
	/**
	 * XML解析失败
	 * @param context
	 */
	public static void xmlFaile(Context context) {
		ToastBase(context, "XML解析失败！", Toast.LENGTH_LONG);
	}
	
	
	public static void webFalit(Context context,String errMsg){
		ToastBase(context, "获取信息失败\n错误原因"+errMsg, Toast.LENGTH_LONG);
	}
	
	public static void noData(Context context){
		ToastBase(context, "暂无数据", Toast.LENGTH_SHORT);
	}
}
