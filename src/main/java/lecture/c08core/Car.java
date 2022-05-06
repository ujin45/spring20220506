package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // bean생성
public class Car {

	
	private Engine engine;
	
	@Autowired // 주입하는 어노테이션
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	 
	public void go() {
		 engine.action();
	 }
}
