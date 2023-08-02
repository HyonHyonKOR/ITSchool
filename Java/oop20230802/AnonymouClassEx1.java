package oop20230802;

interface IMessage {
    void msgPring();
}

public class AnonymouClassEx1 {

public static void main(String[] args) {
	
	//Anonymousを込めるインタフェース変数を作成
    IMessage message = new IMessage() { 
	@Override
	public void msgPring() {
	    System.out.println("===Anonymous===");		
	    }	
	 };
	 
	 message.msgPring();
	 
				
    } // main() end

}