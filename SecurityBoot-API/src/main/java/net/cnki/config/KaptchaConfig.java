package net.cnki.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
@Configuration
public class KaptchaConfig {

	@Bean
	public Producer captcha() {
		Properties properties = new Properties();
		properties.setProperty("kaptcha.border","no");
		properties.setProperty("kaptcha.image.width","120");//图片宽
		properties.setProperty("kaptcha.image.height","38");//图片高
		properties.setProperty("kaptcha.textproducer.char.string","0123456789");//只包含数字验证码，其他直接添加即可
		properties.setProperty("kaptcha.textproducer.char.length","4");//验证码长度
		properties.setProperty("kaptcha.textproducer.font.names","Times New Roman");//禁止使用微软雅黑
		properties.setProperty("kaptcha.textproducer.font.size","30");//字体大小
		properties.setProperty("kaptcha.textproducer.font.color","0,255,0");//字体颜色
		properties.setProperty("kaptcha.textproducer.char.space","6");//文字间隔
		//properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.DefaultNoise");//干扰实现类
		properties.setProperty("kaptcha.noise.color","224,21,14");//干扰颜色
		//properties.setProperty("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");//图片样式，默认的看的清楚点
		//properties.setProperty("kaptcha.background.impl","com.google.code.kaptcha.impl.DefaultBackground");//背景实现类
		//properties.setProperty("kaptcha.background.clear.from","grey");//背景颜色渐变，開始颜色
		//properties.setProperty("kaptcha.background.clear.to","white");//背景颜色渐变。结束颜色
		//properties.setProperty("kaptcha.word.impl","com.google.code.kaptcha.text.impl.DefaultWordRenderer");//文字渲染器
		
		
		
		Config config = new Config(properties);
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		defaultKaptcha.setConfig(config);
		
		return defaultKaptcha;
	}
}
