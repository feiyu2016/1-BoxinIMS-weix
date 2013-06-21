package com.boxin.ims.modules.wechat.entity;

public class Weather {
	/**
	 * {"weatherinfo":{"city":"邯郸","city_en":"handan","date_y":"2013年6月17日","date":"","week":"星期一","fchh":"18","cityid":"101091001",
	 * "temp1":"24℃~30℃","temp2":"23℃~30℃","temp3":"23℃~31℃","temp4":"23℃~28℃","temp5":"20℃~27℃","temp6":"21℃~31℃",
	 * "tempF1":"75.2℉~86℉","tempF2":"73.4℉~86℉","tempF3":"73.4℉~87.8℉","tempF4":"73.4℉~82.4℉","tempF5":"68℉~80.6℉","tempF6":"69.8℉~87.8℉",
	 * "weather1":"雷阵雨转阵雨","weather2":"多云","weather3":"多云","weather4":"多云转雷阵雨","weather5":"阵雨","weather6":"多云",
	 * "img1":"4","img2":"3","img3":"1","img4":"99","img5":"1","img6":"99","img7":"1","img8":"4","img9":"3","img10":"99","img11":"1","img12":"99",
	 * "img_single":"3","img_title1":"雷阵雨","img_title2":"阵雨","img_title3":"多云","img_title4":"多云","img_title5":"多云","img_title6":"多云","img_title7":"多云","img_title8":"雷阵雨","img_title9":"阵雨","img_title10":"阵雨","img_title11":"多云","img_title12":"多云",
	 * "img_title_single":"阵雨","wind1":"北风小于3级","wind2":"北风小于3级","wind3":"北风转南风小于3级","wind4":"南风转北风小于3级","wind5":"北风小于3级","wind6":"北风转南风小于3级",
	 * "fx1":"北风","fx2":"北风",
	 * "fl1":"小于3级","fl2":"小于3级","fl3":"小于3级","fl4":"小于3级","fl5":"小于3级","fl6":"小于3级",
	 * "index":"热","index_d":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","index48":"热","index48_d":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。","index_uv":"中等","index48_uv":"中等",
	 * "index_xc":"不宜","index_tr":"适宜","index_co":"较不舒适",
	 * "st1":"28","st2":"22","st3":"30","st4":"23","st5":"31","st6":"23",
	 * "index_cl":"较不宜","index_ls":"不太适宜","index_ag":"极不易发"}}
	 */
	
	private String city;
	private String cityEn;
	private String dateY;
	private String date;
	private String week;
	private String fchh;
	private String cityId;
	private String temp1;
	private String temp2;
	private String temp3;
	private String temp4;
	private String temp5;
	private String temp6;
	private String tempF1;
	private String tempF2;
	private String tempF3;
	private String tempF4;
	private String tempF5;
	private String tempF6;
	private String weather1;
	private String weather2;
	private String weather3;
	private String weather4;
	private String weather5;
	private String weather6;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String img6;
	private String img7;
	private String img8;
	private String img9;
	private String img10;
	private String img11;
	private String img12;
	private String imgSingle;
	private String imgTitle1;
	private String imgTitle2;
	private String imgTitle3;
	private String imgTitle4;
	private String imgTitle5;
	private String imgTitle6;
	private String imgTitle7;
	private String imgTitle8;
	private String imgTitle9;
	private String imgTitle10;
	private String imgTitle11;
	private String imgTitle12;
	private String imgTitleSingle;
	private String wind1;
	private String wind2;
	private String wind3;
	private String wind4;
	private String wind5;
	private String wind6;
	
	private String fx1;
	private String fx2;
	
	private String fl1;
	private String fl2;
	private String fl3;
	private String fl4;
	private String fl5;
	private String fl6;
	
	private String index;
	private String indexD;
	private String index48;
	private String index48D;
	private String indexUV;
	private String index48UV;
	
	/**
	 * 
	 * "index_xc":"不宜","index_tr":"适宜","index_co":"较不舒适",
	 * "st1":"28","st2":"22","st3":"30","st4":"23","st5":"31","st6":"23",
	 * "index_cl":"较不宜","index_ls":"不太适宜","index_ag":"极不易发"}}
	 */
	private String indexXC;
	private String indexTR;
	private String indexCO;
	private String st1;
	private String st2;
	private String st3;
	private String st4;
	private String st5;
	private String st6;
	
	private String indexCL;
	private String indexLS;
	private String indexAG;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityEn() {
		return cityEn;
	}
	public void setCityEn(String cityEn) {
		this.cityEn = cityEn;
	}
	public String getDateY() {
		return dateY;
	}
	public void setDateY(String dateY) {
		this.dateY = dateY;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getFchh() {
		return fchh;
	}
	public void setFchh(String fchh) {
		this.fchh = fchh;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getTemp1() {
		return temp1;
	}
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	public String getTemp2() {
		return temp2;
	}
	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}
	public String getTemp3() {
		return temp3;
	}
	public void setTemp3(String temp3) {
		this.temp3 = temp3;
	}
	public String getTemp4() {
		return temp4;
	}
	public void setTemp4(String temp4) {
		this.temp4 = temp4;
	}
	public String getTemp5() {
		return temp5;
	}
	public void setTemp5(String temp5) {
		this.temp5 = temp5;
	}
	public String getTemp6() {
		return temp6;
	}
	public void setTemp6(String temp6) {
		this.temp6 = temp6;
	}
	public String getTempF1() {
		return tempF1;
	}
	public void setTempF1(String tempF1) {
		this.tempF1 = tempF1;
	}
	public String getTempF2() {
		return tempF2;
	}
	public void setTempF2(String tempF2) {
		this.tempF2 = tempF2;
	}
	public String getTempF3() {
		return tempF3;
	}
	public void setTempF3(String tempF3) {
		this.tempF3 = tempF3;
	}
	public String getTempF4() {
		return tempF4;
	}
	public void setTempF4(String tempF4) {
		this.tempF4 = tempF4;
	}
	public String getTempF5() {
		return tempF5;
	}
	public void setTempF5(String tempF5) {
		this.tempF5 = tempF5;
	}
	public String getTempF6() {
		return tempF6;
	}
	public void setTempF6(String tempF6) {
		this.tempF6 = tempF6;
	}
	public String getWeather1() {
		return weather1;
	}
	public void setWeather1(String weather1) {
		this.weather1 = weather1;
	}
	public String getWeather2() {
		return weather2;
	}
	public void setWeather2(String weather2) {
		this.weather2 = weather2;
	}
	public String getWeather3() {
		return weather3;
	}
	public void setWeather3(String weather3) {
		this.weather3 = weather3;
	}
	public String getWeather4() {
		return weather4;
	}
	public void setWeather4(String weather4) {
		this.weather4 = weather4;
	}
	public String getWeather5() {
		return weather5;
	}
	public void setWeather5(String weather5) {
		this.weather5 = weather5;
	}
	public String getWeather6() {
		return weather6;
	}
	public void setWeather6(String weather6) {
		this.weather6 = weather6;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	public String getImg5() {
		return img5;
	}
	public void setImg5(String img5) {
		this.img5 = img5;
	}
	public String getImg6() {
		return img6;
	}
	public void setImg6(String img6) {
		this.img6 = img6;
	}
	public String getImg7() {
		return img7;
	}
	public void setImg7(String img7) {
		this.img7 = img7;
	}
	public String getImg8() {
		return img8;
	}
	public void setImg8(String img8) {
		this.img8 = img8;
	}
	public String getImg9() {
		return img9;
	}
	public void setImg9(String img9) {
		this.img9 = img9;
	}
	public String getImg10() {
		return img10;
	}
	public void setImg10(String img10) {
		this.img10 = img10;
	}
	public String getImg11() {
		return img11;
	}
	public void setImg11(String img11) {
		this.img11 = img11;
	}
	public String getImg12() {
		return img12;
	}
	public void setImg12(String img12) {
		this.img12 = img12;
	}
	public String getImgSingle() {
		return imgSingle;
	}
	public void setImgSingle(String imgSingle) {
		this.imgSingle = imgSingle;
	}
	public String getImgTitle1() {
		return imgTitle1;
	}
	public void setImgTitle1(String imgTitle1) {
		this.imgTitle1 = imgTitle1;
	}
	public String getImgTitle2() {
		return imgTitle2;
	}
	public void setImgTitle2(String imgTitle2) {
		this.imgTitle2 = imgTitle2;
	}
	public String getImgTitle3() {
		return imgTitle3;
	}
	public void setImgTitle3(String imgTitle3) {
		this.imgTitle3 = imgTitle3;
	}
	public String getImgTitle4() {
		return imgTitle4;
	}
	public void setImgTitle4(String imgTitle4) {
		this.imgTitle4 = imgTitle4;
	}
	public String getImgTitle5() {
		return imgTitle5;
	}
	public void setImgTitle5(String imgTitle5) {
		this.imgTitle5 = imgTitle5;
	}
	public String getImgTitle6() {
		return imgTitle6;
	}
	public void setImgTitle6(String imgTitle6) {
		this.imgTitle6 = imgTitle6;
	}
	public String getImgTitle7() {
		return imgTitle7;
	}
	public void setImgTitle7(String imgTitle7) {
		this.imgTitle7 = imgTitle7;
	}
	public String getImgTitle8() {
		return imgTitle8;
	}
	public void setImgTitle8(String imgTitle8) {
		this.imgTitle8 = imgTitle8;
	}
	public String getImgTitle9() {
		return imgTitle9;
	}
	public void setImgTitle9(String imgTitle9) {
		this.imgTitle9 = imgTitle9;
	}
	public String getImgTitle10() {
		return imgTitle10;
	}
	public void setImgTitle10(String imgTitle10) {
		this.imgTitle10 = imgTitle10;
	}
	public String getImgTitle11() {
		return imgTitle11;
	}
	public void setImgTitle11(String imgTitle11) {
		this.imgTitle11 = imgTitle11;
	}
	public String getImgTitle12() {
		return imgTitle12;
	}
	public void setImgTitle12(String imgTitle12) {
		this.imgTitle12 = imgTitle12;
	}
	public String getImgTitleSingle() {
		return imgTitleSingle;
	}
	public void setImgTitleSingle(String imgTitleSingle) {
		this.imgTitleSingle = imgTitleSingle;
	}
	public String getWind1() {
		return wind1;
	}
	public void setWind1(String wind1) {
		this.wind1 = wind1;
	}
	public String getWind2() {
		return wind2;
	}
	public void setWind2(String wind2) {
		this.wind2 = wind2;
	}
	public String getWind3() {
		return wind3;
	}
	public void setWind3(String wind3) {
		this.wind3 = wind3;
	}
	public String getWind4() {
		return wind4;
	}
	public void setWind4(String wind4) {
		this.wind4 = wind4;
	}
	public String getWind5() {
		return wind5;
	}
	public void setWind5(String wind5) {
		this.wind5 = wind5;
	}
	public String getWind6() {
		return wind6;
	}
	public void setWind6(String wind6) {
		this.wind6 = wind6;
	}
	public String getFx1() {
		return fx1;
	}
	public void setFx1(String fx1) {
		this.fx1 = fx1;
	}
	public String getFx2() {
		return fx2;
	}
	public void setFx2(String fx2) {
		this.fx2 = fx2;
	}
	public String getFl1() {
		return fl1;
	}
	public void setFl1(String fl1) {
		this.fl1 = fl1;
	}
	public String getFl2() {
		return fl2;
	}
	public void setFl2(String fl2) {
		this.fl2 = fl2;
	}
	public String getFl3() {
		return fl3;
	}
	public void setFl3(String fl3) {
		this.fl3 = fl3;
	}
	public String getFl4() {
		return fl4;
	}
	public void setFl4(String fl4) {
		this.fl4 = fl4;
	}
	public String getFl5() {
		return fl5;
	}
	public void setFl5(String fl5) {
		this.fl5 = fl5;
	}
	public String getFl6() {
		return fl6;
	}
	public void setFl6(String fl6) {
		this.fl6 = fl6;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIndexD() {
		return indexD;
	}
	public void setIndexD(String indexD) {
		this.indexD = indexD;
	}
	public String getIndex48() {
		return index48;
	}
	public void setIndex48(String index48) {
		this.index48 = index48;
	}
	public String getIndex48D() {
		return index48D;
	}
	public void setIndex48D(String index48d) {
		index48D = index48d;
	}
	public String getIndexUV() {
		return indexUV;
	}
	public void setIndexUV(String indexUV) {
		this.indexUV = indexUV;
	}
	public String getIndex48UV() {
		return index48UV;
	}
	public void setIndex48UV(String index48uv) {
		index48UV = index48uv;
	}
	public String getIndexXC() {
		return indexXC;
	}
	public void setIndexXC(String indexXC) {
		this.indexXC = indexXC;
	}
	public String getIndexTR() {
		return indexTR;
	}
	public void setIndexTR(String indexTR) {
		this.indexTR = indexTR;
	}
	public String getIndexCO() {
		return indexCO;
	}
	public void setIndexCO(String indexCO) {
		this.indexCO = indexCO;
	}
	public String getSt1() {
		return st1;
	}
	public void setSt1(String st1) {
		this.st1 = st1;
	}
	public String getSt2() {
		return st2;
	}
	public void setSt2(String st2) {
		this.st2 = st2;
	}
	public String getSt3() {
		return st3;
	}
	public void setSt3(String st3) {
		this.st3 = st3;
	}
	public String getSt4() {
		return st4;
	}
	public void setSt4(String st4) {
		this.st4 = st4;
	}
	public String getSt5() {
		return st5;
	}
	public void setSt5(String st5) {
		this.st5 = st5;
	}
	public String getSt6() {
		return st6;
	}
	public void setSt6(String st6) {
		this.st6 = st6;
	}
	public String getIndexCL() {
		return indexCL;
	}
	public void setIndexCL(String indexCL) {
		this.indexCL = indexCL;
	}
	public String getIndexLS() {
		return indexLS;
	}
	public void setIndexLS(String indexLS) {
		this.indexLS = indexLS;
	}
	public String getIndexAG() {
		return indexAG;
	}
	public void setIndexAG(String indexAG) {
		this.indexAG = indexAG;
	}
	
	/**
	 * @author Jakemanse
	 * @time 2013-6-19  上午2:35:04
	 * @function <p> 最主要信息 </p>
	 * @return
	 */
	public String toMailWeatherString(){
		StringBuffer sb = new StringBuffer();
		sb.append(getCity()).append("今天天气:").append(getTemp1()).append(",").append(getWeather1()).append(",").append(getWind1()).append(getFl1()).append(";\n");
		sb.append("未来五天天气:").append(getTemp2()).append(",").append(getWeather2()).append(",").append(getWind2()).append(getFl2()).append(";\n");
		sb.append(getTemp3()).append(",").append(getWeather3()).append(",").append(getWind3()).append(getFl3()).append(";\n");
		sb.append(getTemp4()).append(",").append(getWeather4()).append(",").append(getWind4()).append(getFl4()).append(";\n");
		sb.append(getTemp5()).append(",").append(getWeather5()).append(",").append(getWind5()).append(getFl5()).append(";\n");
		sb.append(getTemp6()).append(",").append(getWeather6()).append(",").append(getWind6()).append(getFl6()).append(";\n");
		
		
		return sb.toString();
	}
	
	
	
	
	

}
