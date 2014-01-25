package br.com.dicadefarmacia.infra.fake;

import java.util.Collection;
import java.util.Map;

public class ContentFake {

	private String description;
	private String name;

	public ContentFake(String description, String name) {
		super();
		this.description = description;
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public static ContentFake findByName(String name) {

		Map<String, ContentFake> createContentsFake = ContentFakeFactory
				.createContentsFake();

		return createContentsFake.get(name);

	}

	public static Collection<ContentFake> findAll() {
		return ContentFakeFactory.createContentsFake().values();

	}

}
