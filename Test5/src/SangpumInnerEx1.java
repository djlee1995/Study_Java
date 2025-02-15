import java.util.*;

public class SangpumInnerEx1 {
	public static void main(String args[]) {
		SangpumInner sangpum = new SangpumInner();
		Scanner scan = new Scanner(System.in);

		int menu;
		while (true) {
			printMenu();
			System.out.print("메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();

			if (menu == 6) {
				System.out.println("The End...");
				break;
			}

			switch (menu) {
			case 1:
				inputSangpum(sangpum);
				break;
			case 2:
				outputSangpum(sangpum);
				break;
			case 3:
				searchSangpum(sangpum);
				break;
			case 4:
				updateSangpum(sangpum);
				break;
			case 5:
				deleteSangpum(sangpum);
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요!!!\n");
			}

		}

	}

	static void printMenu() {
		System.out.println("*** 상품관리 ***");
		System.out.println("1. 상품정보 입력");
		System.out.println("2. 상품정보 출력");
		System.out.println("3. 상품정보 조회");
		System.out.println("4. 상품정보 수정");
		System.out.println("5. 상품정보 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println();
	}

	static void inputSangpum(SangpumInner sangpum) {
		SangpumInner.Sangpum obj = sangpum.new Sangpum();
		obj.input_Sangpum();
		if (sangpum.checkSangpum(obj)) {
			System.out.println("코드중복오류!!\n");
			return;
		}
		sangpum.addSangpum(obj);

	}

	static void outputSangpum(SangpumInner sangpum) {
		if (sangpum.getSungjukNum() == 0) {
			System.out.println("출력할 상품정보가 없습니다.");
			return;
		}
		System.out.println("             *** 판매 현황 ***");
		System.out.println("=======================================");
		System.out.println("코드    상품명    수량    단가         금액            평가   ");
		System.out.println("=======================================");
		for (SangpumInner.Sangpum dat : sangpum.getlist()) {
			dat.output_Sangpum();
		}
		System.out.println("=======================================");
		System.out.println("                            총 판매금액: " + sangpum.getTotal());
	}

	static void searchSangpum(SangpumInner sangpum) {
		Scanner scan = new Scanner(System.in);
		System.out.println("조회할 상품코드를 입력해주세요=> ");
		String code = scan.next();
		for (SangpumInner.Sangpum dat : sangpum.getlist()) {
			if (code.equals(dat.code)) {
				System.out.println("\n코드    상품명    수량    단가   금액    평가   ");
				System.out.println("=======================================");
				dat.output_Sangpum();
				System.out.println("=======================================");
				return;
			}
		}
		System.out.println("조회할 학번 오류!!\n");
	}

	static void updateSangpum(SangpumInner sangpum) {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 상품코드를 입력해주세요");
		String code = scan.next();
		for (SangpumInner.Sangpum dat : sangpum.getlist()) {
			if (code.equals(dat.code)) {

				System.out.println("상품명을 입력=> ");
				dat.name = scan.next();
				System.out.println("수량을 입력=> ");
				dat.count = scan.nextInt();
				System.out.println("단가 입력=> ");
				dat.price = scan.nextInt();
				System.out.println("변경완료!!");
				return;

			}
		}
		System.out.println("변경할 상품코드 오류!!\n");
	}

	static void deleteSangpum(SangpumInner sangpum) {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 상품코드를 입력해주세요");
		String code = scan.next();
		for (SangpumInner.Sangpum dat : sangpum.getlist()) {
			if (code.equals(dat.code)) {
				sangpum.removeSangpum(dat);

				return;
			}
		}
		System.out.println("삭제할 상품코드 오류!!\n");
	}
}
