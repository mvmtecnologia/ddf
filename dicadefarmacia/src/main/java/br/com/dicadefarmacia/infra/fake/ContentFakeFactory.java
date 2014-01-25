package br.com.dicadefarmacia.infra.fake;

import java.util.HashMap;
import java.util.Map;

public class ContentFakeFactory {

	public static Map<String, ContentFake>  createContentsFake(){
		Map<String, ContentFake> map = new HashMap<String, ContentFake>();
		map.put("cafeteira", new ContentFake("Máquina de passar café linda demais e tal tal tal", "cafeteira"));
		map.put("ps3", new ContentFake("lindo ps3 bonitao vende na loja do tio matheus", "ps3"));
		map.put("xbox", new ContentFake("lindo ps3 bonitao vende na loja do tio rodolfo", "ps3"));
		map.put("pc", new ContentFake("pc dual core novinho em folha, pc tipo maça huahuahuahuaua", "pc"));
		map.put("cd racionais", new ContentFake("cd racionais mcs só para os vidas lokas", "cd racionais"));
		
		
		return map;
	}
}
