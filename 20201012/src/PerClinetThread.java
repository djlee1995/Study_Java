

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerClinetThread extends Thread {
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket;
	PrintWriter writer;
	PerClinetThread(Socket socket){
		this.socket = socket;
		try {
			writer = new PrintWriter(socket.getOutputStream());
			list.add(writer);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void run() {
		String name = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine(); //클라이언트 대화명 읽어오기
			sendAll("#"+name+" 님이 들어오셨습니다");
			while(true) {
				String str = reader.readLine(); //클라이언트 메시지 읽어오기
				if(str == null)
					break;
				sendAll(name + "> "+str);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			list.remove(writer);
			sendAll("#"+name +" 님이 나가셨습니다");
			try {
				socket.close();
			}
			catch(Exception ignored) {
			}
		}
	}
	private void sendAll(String str) {
		for(PrintWriter writer:list) {
			writer.println(str);
			writer.flush();
		}
	}
}
