package org.xatu.util;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.imageclassify.AipImageClassify;

public class Sample {
	
	 //设置APPID/AK/SK
	public static final String APP_ID = "10542347";
    public static final String API_KEY = "T5TQ8AkdeaUUFex66ROS2peW";
    public static final String SECRET_KEY = "7gcxDRLVBIYkcwK51QIlfbUueBWXv8vm";


      public static Object faceRecognize(String imgPath){
    	  // 初始化一个AipImageClassifyClient
          AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

          // 可选：设置网络连接参数
          client.setConnectionTimeoutInMillis(2000);
          client.setSocketTimeoutInMillis(60000);
          
          //设置识别的参数
          HashMap<String, String>  options = new HashMap<String, String>();
          //参数 ：颜值
          options.put("max_face_num", "1");
          //参数  ，颜值，年龄
          options.put("face_fields", "age,beauty");
          //开始r检测
          JSONObject response = client.detect(imgPath, options);
  
         return response;
      }

}
