package com.boxin.ims.modules.wechat.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.boxin.ims.modules.wechat.entity.Weather;
import com.boxin.ims.modules.wechat.entity.WechatConfig;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

public class WeChatUtils {
	
	/**
	 * 
	 * http://m.weather.com.cn/data/101090901.html
	 */
	public final static String WEATHER_URL = "http://m.weather.com.cn/data/"; 
	
	
	
	
	public static void main(String[] args) {
		try {
			URL url = new URL(WeChatUtils.WEATHER_URL);
			Document doc = 	Jsoup.parse(url, 100000);
			doc.toString();
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static  String getWeatherJson(String code){
		
		String result = "";
		try {
			
			URL url = new URL (WEATHER_URL+code+".html") ;
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求的方式;
			conn.setRequestMethod("GET"); 
			// 设置可以读入 ;
			conn.setDoInput(true); 
			// 设置可以输出 ;
			conn.setDoOutput(true); 
			// 构建缓冲流 ;
			BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line = null ;
			while ( (line = br.readLine()) != null ) {
				result += line+"\n" ;     
			}    
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
	     return result ;
	}
	
	
	public static  Weather convertJsonToWeather(JSONObject object){
		Weather weather = new Weather();
		weather.setCity(object.getString("city"));
		weather.setCityEn(object.getString("city_en"));
		weather.setCityId(object.getString("cityid"));
		weather.setDate(object.getString("date"));
		weather.setDateY(object.getString("date_y"));
		weather.setFchh(object.getString("fchh"));
		
		//<!-- 风速描述 -->    
		weather.setWind1(object.getString("wind1"));
		weather.setWind2(object.getString("wind2"));
		weather.setWind3(object.getString("wind3"));
		weather.setWind4(object.getString("wind4"));
		weather.setWind5(object.getString("wind5"));
		weather.setWind6(object.getString("wind6"));
		
		//<!-- 风速级别描述 -->   
		weather.setFl1(object.getString("fl1"));
		weather.setFl2(object.getString("fl2"));
		weather.setFl3(object.getString("fl3"));
		weather.setFl4(object.getString("fl4"));
		weather.setFl5(object.getString("fl5"));
		weather.setFl6(object.getString("fl6"));
		weather.setFx1(object.getString("fx1"));
		weather.setFx2(object.getString("fx2"));
		
		//<!-- 从今天开始到第六天的每天的天气情况，这里的温度是摄氏温度 -->  
		weather.setTemp1(object.getString("temp1"));
		weather.setTemp2(object.getString("temp2"));
		weather.setTemp3(object.getString("temp3"));
		weather.setTemp4(object.getString("temp4"));
		weather.setTemp5(object.getString("temp5"));
		weather.setTemp6(object.getString("temp6"));
		
		//<!-- 天气描述 -->    
		weather.setWeather1(object.getString("weather1"));
		weather.setWeather2(object.getString("weather2"));
		weather.setWeather3(object.getString("weather3"));
		weather.setWeather4(object.getString("weather4"));
		weather.setWeather5(object.getString("weather5"));
		weather.setWeather6(object.getString("weather6"));
		
		// <!-- 今天穿衣指数 -->   
		
		
		
		//<!-- 48小时穿衣指数 -->  
		
		return weather;
		
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-20  上午12:15:28
	 * @function <p> 找到问题的相似答案  </p>
	 * @param configs
	 * @param upcon
	 * @return
	 */
	public static WechatConfig getConfigByUpContent(List<WechatConfig> configs,String upcon){
		for(WechatConfig config : configs){
			if(config.getUpContent().trim().toLowerCase().contains(upcon.trim().toLowerCase())){
				return config;
			}
		}
		return null;
	}
	
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-22  上午12:31:38
	 * @function <p>获取微信设置中上传的文件资源路径  </p>
	 * @return
	 */
	public static String getWechatResourceSavePath(){
		 return DictUtils.getDictValue("微信资源目录", "res_wp_path", "微信资源目录");
	}
	

}
