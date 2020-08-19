package day25.ch02_map;

import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;



public class Quiz01 {
	public static void main(String[] args) {
		//Ű : ���ܾ�(String)
		//�� : ���� ��(String)
		
		//�޴� : 
		//1.�ܾ���
		//2.�ܾ� �˻� -> ���ܾ� �Է� �ް� ������ ���� ���, ������ "�̵�� �ܾ��Դϴ�."
		//3.��� �ܾ� ���� -> ��� �ܾ�� ���� ���
		//4.QuizǮ�� *** ���ù��� -> �����ϰ� ���� ��� �ϰ� ���ܾ �Է� �޾Ƽ� "����!" Ȥ�� "��" ���
		//0.����
		
		String menu = "1. �ܾ��� \n 2.�ܾ�˻� \n 3.��� �ܾ� ����\n 4.Quiz Ǯ�� \n 0.����";
		
		HashMap<String, String> voca = new HashMap<>();
		while(true) {
			String select =  JOptionPane.showInputDialog(menu);
			switch (select) {
			case "1":
				voca.put(JOptionPane.showInputDialog("��� �� �ܾ� �Է�"), JOptionPane.showInputDialog("�ܾ��� ���� �Է�"));		
				break;
			case "2":
				String k =JOptionPane.showInputDialog("�˻��� �ܾ� �Է�");
				if(voca.containsKey(k)) {
					JOptionPane.showMessageDialog(null, "�ܾ��� �� : "+ voca.get(k));
				}
				else {
					JOptionPane.showMessageDialog(null, "�̵�� �ܾ��Դϴ�.");
				}
				break;
			case "3":
				StringBuffer sb = new StringBuffer("-----------�ܾ� ����Ʈ -----------\n");
				Set<String> key =  voca.keySet();
				
				for(String e : key) {
					sb.append(e+":"+voca.get(e)+"\n");
			
				}

				JOptionPane.showMessageDialog(null, sb);
				break;
				
			case "4":
				//4.QuizǮ�� *** ���ù��� -> �����ϰ� ���� ��� �ϰ� ���ܾ �Է� �޾Ƽ� "����!" Ȥ�� "��" ���
				int rand = (int)(Math.random()*voca.size())+1;//1~voca.size()
				int num = rand%voca.size();
		
				Object[] keys = voca.keySet().toArray();

				String answer = JOptionPane.showInputDialog(keys[num]);
				
				if(answer.equals(voca.get(keys[num]))) {
					JOptionPane.showMessageDialog(null, "����!");
				}
				else {
					JOptionPane.showMessageDialog(null, "��!");
				}
				// Object[] keys1 = voca.values().toArray();
				// System.out.println(keys1[num]);
				break;
			case "0":
				return;

			}
		}
	}
}
