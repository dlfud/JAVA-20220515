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
				System.out.println("���α׷��� �����մϴ�.");
				break;

			} else {
				System.out.println("�� �� ���� ��ɾ��Դϴ�.");
			}
		}
	}
	
	public void printHelp() {
		System.out.println("add    : �Խù� ���");
		System.out.println("list   : �Խù� ���");
		System.out.println("update : �Խù� ����");
		System.out.println("eixt   : ���α׷� ����");
	}
	
	public void updateArticle() {
		// CRUD

		System.out.print("������ �Խù� ��ȣ : ");
		int no = Integer.parseInt(sc.nextLine());
		int index = no - 1;

		// 0, ������ �ε��� = size - 1
		if (index < 0 || index >= articles.size()) {
			System.out.println("���� �Խù��Դϴ�.");
			return;
		}

		System.out.print("������ : ");
		String title = sc.nextLine();
		System.out.print("������ : ");
		String body = sc.nextLine();

		Article article = new Article(title, body);
		articles.set(index, article);

		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		printArticles();
		
	}

	public void addArticle() {
		System.out.print("���� :");
		String title = sc.nextLine();

		System.out.print("���� :");
		String body = sc.nextLine();

		Article article = new Article(title, body);
		articles.add(article);

		System.out.println("�Խù��� ����Ǿ����ϴ�.");

	}
	
	public void printArticles() {
		// list ��ü ���
		for(int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			
			System.out.printf("��ȣ: %d\n", i + 1);
			System.out.printf("����: %s\n", article.title);			
			System.out.println("==========================");
		}
	}
}