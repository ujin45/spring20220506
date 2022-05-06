package lecture.c08core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component
@ToString
public class Computer {
	
	@Setter(onMethod_ = {@Autowired}) // 여러 어노테이션 만들때 {배열로}
	private Memory memory;
	
	
//	@Autowired
//	public void setMemory(Memory memory) {
//		this.memory = memory;
//	}
}
