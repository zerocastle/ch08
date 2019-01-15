package ys.main;

import java.util.Scanner;

import org.hibernate.id.GUIDGenerator;
import org.springframework.context.support.GenericXmlApplicationContext;

import ys.service.WordRegisterService;
import ys.service.WordSearchService;

public class MainClass {

	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String[] key = { "c언어", "java" };
		String[] value = { "절차지향 프로그래밍", "겍체 지향 프로그래밍" };
		// 더미 데이터
		String contxtPath = "classpath:app.xml";

		WordSet wordSet = null;

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(contxtPath);

		WordRegisterService register = ctx.getBean("wordRegsterService", WordRegisterService.class);
		WordSearchService search = ctx.getBean("wordSearchService", WordSearchService.class);

		while (true) {
			MainClass.guid();
			Integer selectValue = s.nextInt();
			switch (selectValue) {
			case 1: {
				System.out.println("등록 할 단어와 내용을 입력하세여");
				String registerKey, registerValue = null;
				for (int i = 0; i < 1; i++) {
					System.out.println("키워드를 입력하세요 ");
					registerKey = s.next();
					System.out.println("내용을 입력하세요");
					registerValue = s.next();
					wordSet = new WordSet(registerKey, registerValue);
					register.register(wordSet);
					System.out.println("등록이 완료 되었습니다.");
				}
				break;

			}
			case 2: {
				System.out.println("단어키워드를 입력하세요");
				String searchKey = s.next();
				wordSet = search.searchWord(searchKey);

				System.out.println(
						"검색된 결과 값  :         ==> 입력 값 :" + wordSet.getKey() + "검색된 내용의 값 :" + wordSet.getValue());

			}
			break;

			default:
				break;
			}

			if (selectValue == null)
				System.out.println("값을 입력 하세요");

		}

	}

	// 가이드

	public static void guid() {
		// TODO Auto-generated method stub

		System.out.println("===== 단어를 등록 하려면 1번 , 검색을 원하면 2번  =====");

	}

}
