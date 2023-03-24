package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//Spring 자동생성 어노테이션 -@Controller, @Componet, @Service, @Repository, @RestController, @Advice
//root-context.xml에 설정이 되어 있어야 한다.

@Component
@Data
public class Restaurant {
	
	// @Inject - java DI, @Autowired - Spring, @Setter - lombok : Spring Autowired을 사용한다.
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
