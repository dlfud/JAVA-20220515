package board;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	
	ArrayList<Article> articles = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public void run() {	

		while (true) {
			System.out.print(">> ");
			String cmd = sc.nextLine();

			if (cmd.equals("help")) {
				printHelp();

			} else if (cmd.equals("add")) {
				addArticle();
				
			} else if (cmd.equals("list")) {
				printArticles();

			} else if (cmd.equals("update")) {
				updateArticle();

			}  else if (cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
	}
	
	public void printHelp() {
		System.out.println("add    : 게시물 등록");
		System.out.println("list   : 게시물 목록");
		System.out.println("update : 게시물 수정");
		System.out.println("eixt   : 프로그램 종료");
	}
	
	public void updateArticle() {
		// CRUD

		System.out.print("수정할 게시물 번호 : ");
		int no = Integer.parseInt(sc.nextLine());
		int index = no - 1;

		// 0, 마지막 인덱스 = size - 1
		if (index < 0 || index >= articles.size()) {
			System.out.println("없는 게시물입니다.");
			return;
		}

		System.out.print("새제목 : ");
		String title = sc.nextLine();
		System.out.print("새내용 : ");
		String body = sc.nextLine();

		Article article = new Article(title, body);
		articles.set(index, article);

		System.out.println("수정이 완료되었습니다.");
		printArticles();
		
	}

	public void addArticle() {
		System.out.print("제목 :");
		String title = sc.nextLine();

		System.out.print("내용 :");
		String body = sc.nextLine();

		Article article = new Article(title, body);
		articles.add(article);

		System.out.println("게시물이 저장되었습니다.");

	}
	
	public void printArticles() {
		// list 전체 출력
		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			
			System.out.printf("번호: %d\n", i + 1);
			System.out.printf("제목: %s\n", article.title);			
			System.out.println("==========================");
		}
	}
}