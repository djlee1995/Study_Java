
public class NestedClassExample8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageSender obj = new MessageSender(){
			void send(String message) {
				System.out.println("�߽�: ���̴ٽ�");
				System.out.println("����: �� ������");
				System.out.println("�޽���:"+message);
				System.out.println();
			}
		};
		//SatelliteSender obj = new SatelliteSender();
		obj.send("�� ���");

	}

}
